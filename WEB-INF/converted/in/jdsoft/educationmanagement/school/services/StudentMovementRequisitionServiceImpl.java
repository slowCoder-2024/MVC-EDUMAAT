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
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentMovementRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.StudentMovementRequisitionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.StudentMovementRequisitionService;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="StudentMovementRequisitionService")
public class StudentMovementRequisitionServiceImpl
implements StudentMovementRequisitionService {
    @Autowired
    StudentMovementRequisitionDAO studentMovementRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;

    @Override
    public Long createStudentMovementRequisition(StudentMovementRequisition studentMovementRequisition) throws StudentMovementRequisitionException {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(studentMovementRequisition.getMovementApprover());
            PortalTask portalTask = new PortalTask("Student Movement Approvals", "Student Movement Approvals", addUser, 1, "/student/leave/approvals", studentMovementRequisition.getStudent().getEmail(), studentMovementRequisition.getInstitution());
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            studentMovementRequisition.setPortalTask(persistedPortalTask);
            StudentMovementRequisition persistedStudentMovementRequisition = this.studentMovementRequisitionDAO.save(studentMovementRequisition);
            Long StudentMovementRequisitionId = persistedStudentMovementRequisition.getStudentMovementRequisitionId();
            log.info((Object)("StudentMovementRequisition created with the id=" + StudentMovementRequisitionId));
            return StudentMovementRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating StudentMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentMovementRequisition(Long StudentMovementRequisitionId) throws StudentMovementRequisitionException {
        try {
            StudentMovementRequisition StudentMovementRequisition2 = this.studentMovementRequisitionDAO.getStudentMovementRequisitionById(StudentMovementRequisitionId);
            if (StudentMovementRequisition2 != null) {
                this.studentMovementRequisitionDAO.delete(StudentMovementRequisition2);
                log.info((Object)("StudentMovementRequisition with id=" + StudentMovementRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting StudentMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentMovementRequisition> studentMovementRequisitionList() throws StudentMovementRequisitionException {
        try {
            List<StudentMovementRequisition> StudentMovementRequisitionList = this.studentMovementRequisitionDAO.getList();
            Integer StudentMovementRequisitionListSize = StudentMovementRequisitionList.size();
            if (StudentMovementRequisitionListSize > 0) {
                log.info((Object)(StudentMovementRequisitionListSize + " StudentMovementRequisition records where reterived"));
            } else {
                log.info((Object)"No StudentMovementRequisition list available");
            }
            return StudentMovementRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StudentMovementRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentMovementRequisition studentMovementRequisitionById(Long studentMovementRequisitionId) throws StudentMovementRequisitionException {
        try {
            StudentMovementRequisition StudentMovementRequisition2 = this.studentMovementRequisitionDAO.getStudentMovementRequisitionById(studentMovementRequisitionId);
            if (StudentMovementRequisition2 != null) {
                log.info((Object)("StudentMovementRequisition with id=" + studentMovementRequisitionId + " has been reterived"));
                return StudentMovementRequisition2;
            }
            log.info((Object)("No StudentMovementRequisition with  id=" + studentMovementRequisitionId + " is available"));
            return StudentMovementRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StudentMovementRequisition by id=" + studentMovementRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentMovementRequisition(StudentMovementRequisition studentMovementRequisition) throws StudentMovementRequisitionException {
        try {
            this.studentMovementRequisitionDAO.saveOrUpdate(studentMovementRequisition);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(studentMovementRequisition.getStudent().getUser());
            PortalTask portalTask = new PortalTask("Student Movement " + studentMovementRequisition.getApprovalStatus(), "Student Movement " + studentMovementRequisition.getApprovalStatus(), addUser, 1, "/student/leave/requisition", studentMovementRequisition.getStudent().getEmail(), studentMovementRequisition.getInstitution());
            this.portalTaskDAO.save(portalTask);
            Long StudentMovementRequisitionId = studentMovementRequisition.getStudentMovementRequisitionId();
            if (StudentMovementRequisitionId != null) {
                log.info((Object)("StudentMovementRequisition with id=" + StudentMovementRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New StudentMovementRequisition has been added, because no StudentMovementRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating StudentMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentMovementRequisition studentMovementRequisitionByIdEager(Long studentMovementRequisitionId) throws StudentMovementRequisitionException {
        try {
            StudentMovementRequisition StudentMovementRequisition2 = this.studentMovementRequisitionDAO.getStudentMovementRequisitionById(studentMovementRequisitionId);
            if (StudentMovementRequisition2 != null) {
                log.info((Object)("StudentMovementRequisition with id=" + studentMovementRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudent().getInstitution());
                Hibernate.initialize((Object)StudentMovementRequisition2.getPortalTask());
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
                Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
                Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
                Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
                return StudentMovementRequisition2;
            }
            log.info((Object)("No StudentMovementRequisition with  id=" + studentMovementRequisitionId + " is available"));
            return StudentMovementRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StudentMovementRequisition by id=" + studentMovementRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequisitionListByStudentEmail(String studentEMail) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        Student student = this.studentDAO.getStudentByParentEmail(studentEMail);
        tcRequests.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndStatus(student, "Pending"));
        return tcRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequisitionListByMovementApprover(String studentEMail) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        User user = this.userDAO.getUserByEmail(studentEMail);
        tcRequests.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndUserAndStatus(user, "Pending"));
        for (StudentMovementRequisition StudentMovementRequisition2 : tcRequests) {
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
            Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
            Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
            Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
        }
        return tcRequests;
    }

    @Override
    public void cancelStudentMovementRequisition(StudentMovementRequisition StudentMovementRequisition2) throws StudentMovementRequisitionException {
        try {
            log.info((Object)("StudentMovementRequisition with id=" + StudentMovementRequisition2.getStudentMovementRequisitionId() + " has been cancelled"));
            PortalTask portalTask = StudentMovementRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.studentMovementRequisitionDAO.update(StudentMovementRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel StudentMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequestApprovedAndRejectedLists(String studentEMail) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        Student student = this.studentDAO.getStudentByParentEmail(studentEMail);
        tcRequests.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndStatus(student, "Approved"));
        tcRequests.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndStatus(student, "Rejected"));
        for (StudentMovementRequisition StudentMovementRequisition2 : tcRequests) {
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
            Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
            Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
            Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
        }
        return tcRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndAllClass(Long academicYearId) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        if (this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYear(academicYear) != null) {
            for (StudentMovementRequisition StudentMovementRequisition2 : this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYear(academicYear)) {
                if (StudentMovementRequisition2.getApprovalStatus().equals("Cancelled")) continue;
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
                Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
                Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
                Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
                tcRequests.add(StudentMovementRequisition2);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndClassAndSection(Long academicYearId, Long classId, Long sectionId) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        Class classs = this.classDAO.getClassById(classId);
        Section section = this.sectionDAO.getSectionById(sectionId);
        if (this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section) != null) {
            for (StudentMovementRequisition StudentMovementRequisition2 : this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section)) {
                if (StudentMovementRequisition2.getApprovalStatus().equals("Cancelled")) continue;
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
                Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
                Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
                Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
                tcRequests.add(StudentMovementRequisition2);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndAdmissionNo(Long academicYearId, String admissionNo) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> tcRequests = new LinkedHashSet<StudentMovementRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        if (this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYearAndAdmissionNumber(academicYear, admissionNo) != null) {
            for (StudentMovementRequisition StudentMovementRequisition2 : this.studentMovementRequisitionDAO.getStudentMovementRequisitionListAndAcademicYearAndAdmissionNumber(academicYear, admissionNo)) {
                if (StudentMovementRequisition2.getApprovalStatus().equals("Cancelled")) continue;
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
                Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
                Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
                Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
                Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
                tcRequests.add(StudentMovementRequisition2);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequestApprovedListByInstitution(Long institutionId) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> movementRequisitionList = new LinkedHashSet<StudentMovementRequisition>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        movementRequisitionList.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListByStatusAndInstitution(institution, "Approved"));
        for (StudentMovementRequisition StudentMovementRequisition2 : movementRequisitionList) {
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
            Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
            Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
            Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
        }
        return movementRequisitionList;
    }

    @Override
    public Set<StudentMovementRequisition> studentMovementRequestApprovedListByInstitutionAndDate(Long institutionId, Date todayDate) throws StudentMovementRequisitionException {
        LinkedHashSet<StudentMovementRequisition> movementRequisitionList = new LinkedHashSet<StudentMovementRequisition>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        movementRequisitionList.addAll(this.studentMovementRequisitionDAO.getStudentMovementRequisitionListByStatusAndInstitutionAndCurrentDate(institution, "Approved", todayDate));
        for (StudentMovementRequisition StudentMovementRequisition2 : movementRequisitionList) {
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudent());
            Hibernate.initialize((Object)StudentMovementRequisition2.getStudentClass());
            Hibernate.initialize((Object)StudentMovementRequisition2.getSection());
            Hibernate.initialize((Object)StudentMovementRequisition2.getInstitution());
            Hibernate.initialize((Object)StudentMovementRequisition2.getAcademicYear());
        }
        return movementRequisitionList;
    }
}
