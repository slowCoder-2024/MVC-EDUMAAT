/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentAppraisalDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.services.StudentAppraisalService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentAppraisalService")
public class StudentAppraisalServiceImpl
implements StudentAppraisalService {
    @Autowired
    StudentAppraisalDAO studentAppraisalDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;

    @Override
    public List<StudentAppraisal> studentAppraisalList() {
        try {
            List<StudentAppraisal> studentAppraisalList = this.studentAppraisalDAO.getList();
            Integer appraisalSize = studentAppraisalList.size();
            if (appraisalSize > 0) {
                for (StudentAppraisal studentAppraisal : studentAppraisalList) {
                    Hibernate.initialize((Object)studentAppraisal.getStudent());
                    Hibernate.initialize((Object)studentAppraisal.getInstitution());
                    Hibernate.initialize((Object)studentAppraisal.getAcademicYear());
                    Hibernate.initialize((Object)studentAppraisal.getStudentClass());
                    Hibernate.initialize((Object)studentAppraisal.getSection());
                }
                log.info((Object)(appraisalSize + " StudentAppraisal records where reterived"));
            } else {
                log.info((Object)"No StudentAppraisal available");
            }
            return studentAppraisalList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StudentAppraisal list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentAppraisal studentAppraisalById(Long studentAppraisalId) {
        try {
            StudentAppraisal studentAppraisal = this.studentAppraisalDAO.getStudentAppraisalById(studentAppraisalId);
            if (studentAppraisalId != null) {
                Hibernate.initialize((Object)studentAppraisal.getStudent());
                Hibernate.initialize((Object)studentAppraisal.getInstitution());
                Hibernate.initialize((Object)studentAppraisal.getAcademicYear());
                Hibernate.initialize((Object)studentAppraisal.getStudentClass());
                Hibernate.initialize((Object)studentAppraisal.getSection());
                log.info((Object)("StudentAppraisal with id=" + studentAppraisalId + " has been reterived"));
                return studentAppraisal;
            }
            log.info((Object)("No StudentAppraisal with  id=" + studentAppraisalId + " is available"));
            return studentAppraisal;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StudentAppraisal by id=" + studentAppraisalId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createStudentAppraisal(StudentAppraisal studentAppraisal) throws Exception {
        try {
            this.studentAppraisalDAO.save(studentAppraisal);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating StudentAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentAppraisal(StudentAppraisal dtudentAppraisal) {
        try {
            this.studentAppraisalDAO.saveOrUpdate(dtudentAppraisal);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating StudentAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentAppraisal(Long StudentAppraisalId) {
        try {
            this.studentAppraisalDAO.delete(this.studentAppraisalDAO.getStudentAppraisalById(StudentAppraisalId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting StudentAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentAppraisal> studentAppraisalListByStudentAdmissionNumber(String studentAdmissionNumber) {
        try {
            Student student = this.studentDAO.getStudentByAdmissionNo(studentAdmissionNumber);
            LinkedHashSet<StudentAppraisal> studentAppraisals = new LinkedHashSet<StudentAppraisal>();
            if (this.studentAppraisalDAO.getStudentAppraisalListByStudent(student) != null) {
                for (StudentAppraisal studentAppraisal : this.studentAppraisalDAO.getStudentAppraisalListByStudent(student)) {
                    Hibernate.initialize((Object)studentAppraisal.getStudent());
                    Hibernate.initialize((Object)studentAppraisal.getAcademicYear());
                    Hibernate.initialize((Object)studentAppraisal.getInstitution());
                    Hibernate.initialize((Object)studentAppraisal.getStudentClass());
                    Hibernate.initialize((Object)studentAppraisal.getSection());
                    studentAppraisals.add(studentAppraisal);
                }
            }
            return studentAppraisals;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StudentAppraisal> studentAppraisalListByClassAndSection(Long classId, Long sectionId) {
        try {
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            ArrayList<StudentAppraisal> studentAppraisals = new ArrayList<StudentAppraisal>();
            if (this.studentAppraisalDAO.getStudentAppraisalListByClassAndSection(classes, section) != null) {
                for (StudentAppraisal studentAppraisal : this.studentAppraisalDAO.getStudentAppraisalListByClassAndSection(classes, section)) {
                    Hibernate.initialize((Object)studentAppraisal.getStudent());
                    Hibernate.initialize((Object)studentAppraisal.getAcademicYear());
                    Hibernate.initialize((Object)studentAppraisal.getInstitution());
                    Hibernate.initialize((Object)studentAppraisal.getStudentClass());
                    Hibernate.initialize((Object)studentAppraisal.getSection());
                    studentAppraisals.add(studentAppraisal);
                }
            }
            return studentAppraisals;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StudentAppraisal> studentAppraisalListByAcademicYearAndEmail(Long academicYearId, String email) {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Student student = this.studentDAO.getStudentByEmail(email);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(email);
            }
            ArrayList<StudentAppraisal> studentAppraisals = new ArrayList<StudentAppraisal>();
            if (this.studentAppraisalDAO.getStudentAppraisalListByAcademicYearAndEmail(academicYear, student) != null) {
                for (StudentAppraisal studentAppraisal : this.studentAppraisalDAO.getStudentAppraisalListByAcademicYearAndEmail(academicYear, student)) {
                    Hibernate.initialize((Object)studentAppraisal.getStudent());
                    Hibernate.initialize((Object)studentAppraisal.getAcademicYear());
                    Hibernate.initialize((Object)studentAppraisal.getInstitution());
                    Hibernate.initialize((Object)studentAppraisal.getStudentClass());
                    Hibernate.initialize((Object)studentAppraisal.getSection());
                    studentAppraisals.add(studentAppraisal);
                }
            }
            return studentAppraisals;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
