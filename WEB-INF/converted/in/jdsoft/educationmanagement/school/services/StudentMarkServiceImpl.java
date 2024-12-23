/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.GradeSystemDAO;
import in.jdsoft.educationmanagement.school.dao.GradeSystemDetailDAO;
import in.jdsoft.educationmanagement.school.dao.StudentMarkDAO;
import in.jdsoft.educationmanagement.school.dao.StudentMarksDetailDAO;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.services.StudentMarkService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentMarkService")
public class StudentMarkServiceImpl
implements StudentMarkService {
    @Autowired
    private StudentMarkDAO studentMarkDAO;
    @Autowired
    private StudentMarksDetailDAO studentMarksDetailDAO;
    @Autowired
    private GradeSystemDetailDAO gradeSystemDetailDAO;
    @Autowired
    private GradeSystemDAO gradeSystemDAO;

    @Override
    public void deleteStudentMarks(Long studentMarkId) {
    }

    @Override
    public Long saveStudentMarks(StudentMark studentMarks, Set<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds) {
        try {
            StudentMark persistedStudentMark = this.studentMarkDAO.save(studentMarks);
            Long studentMarkId = persistedStudentMark.getStudentMarkId();
            Long gradeSystemId = persistedStudentMark.getClassSectionAssesmentType().getGradeSystem().getGradeSystemId();
            GradeSystem gradeSystem = this.gradeSystemDAO.getGradeSystemById(gradeSystemId);
            Double classSectionTermExamPercentage = persistedStudentMark.getClassSectionTermExam().getClassSectionTermExamPercentage();
            for (StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBased : studentMarksDetailWithModuleBaseds) {
                studentMarksDetailWithModuleBased.setStudentMark(persistedStudentMark);
                Double ClassSectionTermExamActivityMaximumMark = studentMarksDetailWithModuleBased.getClassSectionTermExamActivity().getMaximumMark();
                Double gradePointObtained = studentMarksDetailWithModuleBased.getTermExamMarkObtained() / ClassSectionTermExamActivityMaximumMark * classSectionTermExamPercentage;
                studentMarksDetailWithModuleBased.setTermExamGradePointObtained(gradePointObtained);
                GradeSystemDetail grade = this.gradeSystemDetailDAO.getGradeByMark(studentMarksDetailWithModuleBased.getTermExamMarkObtained(), gradeSystem);
                if (grade != null) {
                    studentMarksDetailWithModuleBased.setTermExamGradeObtained(grade.getGradeTitle());
                } else {
                    studentMarksDetailWithModuleBased.setTermExamGradeObtained("GNG");
                }
                this.studentMarksDetailDAO.persist(studentMarksDetailWithModuleBased);
            }
            return studentMarkId;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentMark> getStudentMarkEager(Student student) {
        try {
            List<StudentMark> classSectionnandacademics = this.studentMarkDAO.getStudentMarkBy(student);
            LinkedHashSet<StudentMark> studentMarks = new LinkedHashSet<StudentMark>();
            for (StudentMark studentMark : classSectionnandacademics) {
                Hibernate.initialize((Object)studentMark.getStudent());
                Hibernate.initialize(studentMark.getStudentMarksDetails());
                Hibernate.initialize((Object)studentMark.getClassSectionAssesmentType());
                Hibernate.initialize((Object)studentMark.getClassSectionTermExam());
                for (StudentMarksDetail studentMarksDetail : studentMark.getStudentMarksDetails()) {
                    StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBased = (StudentMarksDetailWithModuleBased)studentMarksDetail;
                    Hibernate.initialize((Object)studentMarksDetailWithModuleBased.getClassSectionModule().getModule());
                }
                studentMarks.add(studentMark);
            }
            return studentMarks;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
