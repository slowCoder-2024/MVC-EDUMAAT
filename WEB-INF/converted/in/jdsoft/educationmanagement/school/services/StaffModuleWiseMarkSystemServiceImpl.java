/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.services.StaffModuleWiseMarkSystemService;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="StaffModuleWiseMarkSystemService")
public class StaffModuleWiseMarkSystemServiceImpl
implements StaffModuleWiseMarkSystemService {
    @Autowired
    private StudentMarkDAO studentMarkDAO;
    @Autowired
    private StudentMarksDetailDAO studentMarksDetailDAO;
    @Autowired
    private GradeSystemDetailDAO gradeSystemDetailDAO;
    @Autowired
    private GradeSystemDAO gradeSystemDAO;

    @Override
    public void saveModuleWiseMark(Set<StudentMark> studentMarks, Set<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds) {
        try {
            Iterator<StudentMark> iterator1 = studentMarks.iterator();
            Iterator<StudentMarksDetailWithModuleBased> iterator2 = studentMarksDetailWithModuleBaseds.iterator();
            while (iterator1.hasNext() && iterator2.hasNext()) {
                StudentMark studentMark = iterator1.next();
                StudentMark studentMarkObj = new StudentMark(studentMark.getStudent(), studentMark.getClassSection(), studentMark.getClassSectionAssesmentType(), studentMark.getClassSectionTermExam(), studentMark.getAcademicYear(), studentMark.getInstitution());
                StudentMark persistedStudentMark = this.studentMarkDAO.save(studentMarkObj);
                Long gradeSystemId = persistedStudentMark.getClassSectionAssesmentType().getGradeSystem().getGradeSystemId();
                GradeSystem gradeSystem = this.gradeSystemDAO.getGradeSystemById(gradeSystemId);
                Double classSectionTermExamPercentage = persistedStudentMark.getClassSectionTermExam().getClassSectionTermExamPercentage();
                StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBased = iterator2.next();
                StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBasedObj = new StudentMarksDetailWithModuleBased(studentMarksDetailWithModuleBased.getTermExamMarkObtained(), studentMarksDetailWithModuleBased.getClassSectionTermExamActivity(), studentMarksDetailWithModuleBased.getClassSectionModule());
                studentMarksDetailWithModuleBasedObj.setStudentMark(persistedStudentMark);
                Double ClassSectionTermExamActivityMaximumMark = studentMarksDetailWithModuleBased.getClassSectionTermExamActivity().getMaximumMark();
                Double gradePointObtained = studentMarksDetailWithModuleBased.getTermExamMarkObtained() / ClassSectionTermExamActivityMaximumMark * classSectionTermExamPercentage;
                studentMarksDetailWithModuleBasedObj.setTermExamGradePointObtained(gradePointObtained);
                GradeSystemDetail grade = this.gradeSystemDetailDAO.getGradeByMark(studentMarksDetailWithModuleBased.getTermExamMarkObtained(), gradeSystem);
                if (grade != null) {
                    studentMarksDetailWithModuleBasedObj.setTermExamGradeObtained(grade.getGradeTitle());
                } else {
                    studentMarksDetailWithModuleBasedObj.setTermExamGradeObtained("GNG");
                }
                this.studentMarksDetailDAO.persist(studentMarksDetailWithModuleBasedObj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
