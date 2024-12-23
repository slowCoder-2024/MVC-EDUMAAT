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
import in.jdsoft.educationmanagement.school.dao.ComplaintManagementDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.ComplaintManagementException;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.ComplaintManagementService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="complaintManagementService")
public class ComplaintManagementServiceImpl
implements ComplaintManagementService {
    @Autowired
    ComplaintManagementDAO complaintManagementDAO;
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
    public Long createComplaintManagement(ComplaintManagement complaintManagement, PortalTask portalTask) throws ComplaintManagementException {
        try {
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            complaintManagement.setPortalTask(persistedPortalTask);
            ComplaintManagement persistedComplaintManagement = this.complaintManagementDAO.save(complaintManagement);
            Long ComplaintManagementId = persistedComplaintManagement.getComplaintId();
            log.info((Object)("ComplaintManagement created with the id=" + ComplaintManagementId));
            return ComplaintManagementId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating ComplaintManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteComplaintManagement(Long complaintManagementId) throws ComplaintManagementException {
        try {
            ComplaintManagement complaintManagement = this.complaintManagementDAO.getComplaintManagementById(complaintManagementId);
            if (complaintManagement != null) {
                this.complaintManagementDAO.delete(complaintManagement);
                log.info((Object)("ComplaintManagement with id=" + complaintManagementId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting ComplaintManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ComplaintManagement> complaintManagementList() throws ComplaintManagementException {
        try {
            List<ComplaintManagement> ComplaintManagementList = this.complaintManagementDAO.getList();
            Integer ComplaintManagementListSize = ComplaintManagementList.size();
            if (ComplaintManagementListSize > 0) {
                log.info((Object)(ComplaintManagementListSize + " ComplaintManagement records where reterived"));
            } else {
                log.info((Object)"No ComplaintManagement list available");
            }
            return ComplaintManagementList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving ComplaintManagement list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ComplaintManagement complaintManagementById(Long complaintManagementId) throws ComplaintManagementException {
        try {
            ComplaintManagement ComplaintManagement2 = this.complaintManagementDAO.getComplaintManagementById(complaintManagementId);
            if (ComplaintManagement2 != null) {
                log.info((Object)("ComplaintManagement with id=" + complaintManagementId + " has been reterived"));
                return ComplaintManagement2;
            }
            log.info((Object)("No ComplaintManagement with  id=" + complaintManagementId + " is available"));
            return ComplaintManagement2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving ComplaintManagement by id=" + complaintManagementId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateComplaintManagement(ComplaintManagement complaintManagement, PortalTask portalTask) throws ComplaintManagementException {
        try {
            this.complaintManagementDAO.saveOrUpdate(complaintManagement);
            this.portalTaskDAO.save(portalTask);
            Long ComplaintManagementId = complaintManagement.getComplaintId();
            if (ComplaintManagementId != null) {
                log.info((Object)("ComplaintManagement with id=" + ComplaintManagementId + " has been updated"));
            } else {
                log.info((Object)"New ComplaintManagement has been added, because no ComplaintManagement found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating ComplaintManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ComplaintManagement complaintManagementByIdEager(Long complaintManagementId) throws ComplaintManagementException {
        try {
            ComplaintManagement complaintManagement = this.complaintManagementDAO.getComplaintManagementById(complaintManagementId);
            if (complaintManagement != null) {
                log.info((Object)("ComplaintManagement with id=" + complaintManagementId + " has been reterived"));
                Hibernate.initialize((Object)complaintManagement.getPortalTask());
                Hibernate.initialize((Object)complaintManagement.getAcademicYear());
                Hibernate.initialize((Object)complaintManagement.getInstitution());
                Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStaff());
                Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStudent());
                Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStaff());
                Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStudent());
                return complaintManagement;
            }
            log.info((Object)("No ComplaintManagement with  id=" + complaintManagementId + " is available"));
            return complaintManagement;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving ComplaintManagement by id=" + complaintManagementId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<ComplaintManagement> complaintManagementListByRequesterEmail(String email) throws ComplaintManagementException {
        LinkedHashSet<ComplaintManagement> complaintManagementList = new LinkedHashSet<ComplaintManagement>();
        User user = this.userDAO.getUserByEmail(email);
        complaintManagementList.addAll(this.complaintManagementDAO.getComplaintManagementListAndRequestUserAndStatus(user, "Pending"));
        for (ComplaintManagement complaintManagement : complaintManagementList) {
            Hibernate.initialize((Object)complaintManagement.getPortalTask());
            Hibernate.initialize((Object)complaintManagement.getAcademicYear());
            Hibernate.initialize((Object)complaintManagement.getInstitution());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStudent());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStudent());
        }
        return complaintManagementList;
    }

    @Override
    public Set<ComplaintManagement> complaintManagementListByApprover(String email) throws ComplaintManagementException {
        LinkedHashSet<ComplaintManagement> complaintManagementList = new LinkedHashSet<ComplaintManagement>();
        User user = this.userDAO.getUserByEmail(email);
        complaintManagementList.addAll(this.complaintManagementDAO.getComplaintManagementListAndApproveUserAndStatus(user, "Pending"));
        for (ComplaintManagement complaintManagement : complaintManagementList) {
            Hibernate.initialize((Object)complaintManagement.getPortalTask());
            Hibernate.initialize((Object)complaintManagement.getAcademicYear());
            Hibernate.initialize((Object)complaintManagement.getInstitution());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStudent());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStudent());
        }
        return complaintManagementList;
    }

    @Override
    public void cancelComplaintManagement(ComplaintManagement complaintManagement) throws ComplaintManagementException {
        try {
            log.info((Object)("ComplaintManagement with id=" + complaintManagement.getComplaintId() + " has been cancelled"));
            PortalTask portalTask = complaintManagement.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.complaintManagementDAO.update(complaintManagement);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel ComplaintManagement", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<ComplaintManagement> complaintManagementApprovedAndRejectedLists(String email) throws ComplaintManagementException {
        LinkedHashSet<ComplaintManagement> complaintManagementList = new LinkedHashSet<ComplaintManagement>();
        User user = this.userDAO.getUserByEmail(email);
        complaintManagementList.addAll(this.complaintManagementDAO.getComplaintManagementListAndRequestUserAndStatus(user, "Resolved"));
        complaintManagementList.addAll(this.complaintManagementDAO.getComplaintManagementListAndRequestUserAndStatus(user, "Rejected"));
        for (ComplaintManagement complaintManagement : complaintManagementList) {
            Hibernate.initialize((Object)complaintManagement.getPortalTask());
            Hibernate.initialize((Object)complaintManagement.getAcademicYear());
            Hibernate.initialize((Object)complaintManagement.getInstitution());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintSender().getStudent());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStaff());
            Hibernate.initialize((Object)complaintManagement.getComplaintReceiver().getStudent());
        }
        return complaintManagementList;
    }
}
