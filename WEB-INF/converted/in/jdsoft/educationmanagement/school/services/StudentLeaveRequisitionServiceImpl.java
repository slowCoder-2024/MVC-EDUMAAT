/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.StudentLeaveRequisitionService;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="studentLeaveRequisitionService")
public class StudentLeaveRequisitionServiceImpl
implements StudentLeaveRequisitionService {
    @Autowired
    StudentLeaveRequisitionDAO studentLeaveRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;

    @Override
    public Long createStudentLeaveRequisition(StudentLeaveRequisition studentLeaveRequisition) {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(studentLeaveRequisition.getLeaveApprover());
            PortalTask portalTask = new PortalTask("Leave Approvals", "Leave Approvals", addUser, 1, "/student/leave/approvals", studentLeaveRequisition.getStudent().getEmail(), studentLeaveRequisition.getStudent().getInstitution());
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            studentLeaveRequisition.setPortalTask(persistedPortalTask);
            StudentLeaveRequisition persistedStudentLeaveRequisition = this.studentLeaveRequisitionDAO.save(studentLeaveRequisition);
            Long studentLeaveRequisitionId = persistedStudentLeaveRequisition.getStudentLeaveRequisitionId();
            log.info((Object)("Student LeaveRequisition created with the id=" + studentLeaveRequisitionId));
            return studentLeaveRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Student LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStudentLeaveRequisition(Long studentLeaveRequisitionId) {
        try {
            StudentLeaveRequisition studentLeaveRequisition = this.studentLeaveRequisitionDAO.getStudentLeaveRequisitionById(studentLeaveRequisitionId);
            if (studentLeaveRequisition != null) {
                this.studentLeaveRequisitionDAO.delete(studentLeaveRequisition);
                log.info((Object)("Student LeaveRequisition with id=" + studentLeaveRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Student LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentLeaveRequisition> studentLeaveRequisitionList() {
        try {
            List<StudentLeaveRequisition> studentLeaveRequisitionList = this.studentLeaveRequisitionDAO.getList();
            Integer studentLeaveRequisitionListSize = studentLeaveRequisitionList.size();
            if (studentLeaveRequisitionListSize > 0) {
                log.info((Object)(studentLeaveRequisitionListSize + " student LeaveRequisition records where reterived"));
            } else {
                log.info((Object)"No student LeaveRequisition list available");
            }
            return studentLeaveRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student LeaveRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentLeaveRequisition studentLeaveRequisitionById(Long studentLeaveRequisitionId) {
        try {
            StudentLeaveRequisition studentLeaveRequisition = this.studentLeaveRequisitionDAO.getStudentLeaveRequisitionById(studentLeaveRequisitionId);
            if (studentLeaveRequisition != null) {
                log.info((Object)("Student LeaveRequisition with id=" + studentLeaveRequisitionId + " has been reterived"));
                return studentLeaveRequisition;
            }
            log.info((Object)("No Student LeaveRequisition with  id=" + studentLeaveRequisitionId + " is available"));
            return studentLeaveRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student LeaveRequisition by id=" + studentLeaveRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentLeaveRequisition(StudentLeaveRequisition studentLeaveRequisition) {
        try {
            this.studentLeaveRequisitionDAO.saveOrUpdate(studentLeaveRequisition);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(studentLeaveRequisition.getStudent().getUser());
            PortalTask portalTask = new PortalTask("Leave " + studentLeaveRequisition.getApprovalStatus(), "Leave " + studentLeaveRequisition.getApprovalStatus(), addUser, 1, "/student/leave/requisition", studentLeaveRequisition.getStudent().getEmail(), studentLeaveRequisition.getStudent().getInstitution());
            this.portalTaskDAO.save(portalTask);
            Long studentLeaveRequisitionId = studentLeaveRequisition.getStudentLeaveRequisitionId();
            if (studentLeaveRequisitionId != null) {
                log.info((Object)("Student LeaveRequisition with id=" + studentLeaveRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New Student LeaveRequisition has been added, because no student LeaveRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating Student LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentLeaveRequisition studentLeaveRequisitionByIdEager(Long studentLeaveRequisitionId) {
        try {
            StudentLeaveRequisition studentLeaveRequisition = this.studentLeaveRequisitionDAO.getStudentLeaveRequisitionById(studentLeaveRequisitionId);
            if (studentLeaveRequisition != null) {
                log.info((Object)("Student LeaveRequisition with id=" + studentLeaveRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)studentLeaveRequisition.getStudentLeaveType());
                Hibernate.initialize((Object)studentLeaveRequisition.getStudent());
                Hibernate.initialize((Object)studentLeaveRequisition.getStudent().getInstitution());
                Hibernate.initialize((Object)studentLeaveRequisition.getPortalTask());
                return studentLeaveRequisition;
            }
            log.info((Object)("No Student LeaveRequisition with  id=" + studentLeaveRequisitionId + " is available"));
            return studentLeaveRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving student LeaveRequisition by id=" + studentLeaveRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentLeaveRequisition> studentLeaveRequisitionListByStudentEmail(String studentEMail) {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEMail);
            List<StudentLeaveRequisition> studentLeaveRequisitionList = this.studentLeaveRequisitionDAO.getStudentLeaveRequisitionList(student);
            Integer studentLeaveRequisitionListSize = studentLeaveRequisitionList.size();
            if (studentLeaveRequisitionListSize > 0) {
                for (StudentLeaveRequisition studentLeaveRequisition : studentLeaveRequisitionList) {
                    Hibernate.initialize((Object)studentLeaveRequisition);
                    Hibernate.initialize((Object)studentLeaveRequisition.getStudentLeaveType());
                    Hibernate.initialize((Object)studentLeaveRequisition.getStudent());
                    Hibernate.initialize((Object)studentLeaveRequisition.getPortalTask());
                }
                log.info((Object)(studentLeaveRequisitionListSize + " student LeaveRequisition records where reterived"));
            } else {
                log.info((Object)"No student LeaveRequisition list available");
            }
            return studentLeaveRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student LeaveRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void cancelStudentLeaveRequisition(StudentLeaveRequisition studentLeaveRequisition) {
        try {
            log.info((Object)("Student LeaveRequisition with id=" + studentLeaveRequisition.getStudentLeaveRequisitionId() + " has been cancelled"));
            PortalTask portalTask = studentLeaveRequisition.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.studentLeaveRequisitionDAO.update(studentLeaveRequisition);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel Student LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
