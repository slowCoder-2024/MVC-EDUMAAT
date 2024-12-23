/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StaffMovementRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffMovementRequisitionException;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.StaffMovementRequisitionService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="StaffMovementRequisitionService")
public class StaffMovementRequisitionServiceImpl
implements StaffMovementRequisitionService {
    @Autowired
    StaffMovementRequisitionDAO StaffMovementRequisitionDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public Long createStaffMovementRequisition(StaffMovementRequisition StaffMovementRequisition2) throws StaffMovementRequisitionException {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(StaffMovementRequisition2.getStaffMovementApprover());
            PortalTask portalTask = new PortalTask("Staff Movement Approvals", "Staff Movement Approvals", addUser, 1, "/staff/approvals", StaffMovementRequisition2.getStaff().getEmail(), StaffMovementRequisition2.getStaff().getInstitution());
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            StaffMovementRequisition2.setPortalTask(persistedPortalTask);
            StaffMovementRequisition persistedStaffMovementRequisition = this.StaffMovementRequisitionDAO.save(StaffMovementRequisition2);
            Long StaffMovementRequisitionId = persistedStaffMovementRequisition.getStaffMovementRequisitionId();
            log.info((Object)("StaffMovementRequisition created with the id=" + StaffMovementRequisitionId));
            return StaffMovementRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating StaffMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffMovementRequisition(Long StaffMovementRequisitionId) throws StaffMovementRequisitionException {
        try {
            StaffMovementRequisition StaffMovementRequisition2 = this.StaffMovementRequisitionDAO.getStaffMovementRequisitionById(StaffMovementRequisitionId);
            if (StaffMovementRequisition2 != null) {
                this.StaffMovementRequisitionDAO.delete(StaffMovementRequisition2);
                log.info((Object)("StaffMovementRequisition with id=" + StaffMovementRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting StaffMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffMovementRequisition> staffMovementRequisitionList() throws StaffMovementRequisitionException {
        try {
            List<StaffMovementRequisition> StaffMovementRequisitionList = this.StaffMovementRequisitionDAO.getList();
            Integer StaffMovementRequisitionListSize = StaffMovementRequisitionList.size();
            if (StaffMovementRequisitionListSize > 0) {
                log.info((Object)(StaffMovementRequisitionListSize + " StaffMovementRequisition records where reterived"));
            } else {
                log.info((Object)"No StaffMovementRequisition list available");
            }
            return StaffMovementRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StaffMovementRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffMovementRequisition staffMovementRequisitionById(Long StaffMovementRequisitionId) throws StaffMovementRequisitionException {
        try {
            StaffMovementRequisition StaffMovementRequisition2 = this.StaffMovementRequisitionDAO.getStaffMovementRequisitionById(StaffMovementRequisitionId);
            if (StaffMovementRequisition2 != null) {
                log.info((Object)("StaffMovementRequisition with id=" + StaffMovementRequisitionId + " has been reterived"));
                return StaffMovementRequisition2;
            }
            log.info((Object)("No StaffMovementRequisition with  id=" + StaffMovementRequisitionId + " is available"));
            return StaffMovementRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StaffMovementRequisition by id=" + StaffMovementRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffMovementRequisition(StaffMovementRequisition StaffMovementRequisition2) throws StaffMovementRequisitionException {
        try {
            this.StaffMovementRequisitionDAO.saveOrUpdate(StaffMovementRequisition2);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(StaffMovementRequisition2.getStaff().getUser());
            PortalTask portalTask = new PortalTask("Staff Movement " + StaffMovementRequisition2.getApprovalStatus(), "Staff Movement " + StaffMovementRequisition2.getApprovalStatus(), addUser, 1, "/staff/requisition", StaffMovementRequisition2.getStaff().getEmail(), StaffMovementRequisition2.getStaff().getInstitution());
            this.portalTaskDAO.save(portalTask);
            Long StaffMovementRequisitionId = StaffMovementRequisition2.getStaffMovementRequisitionId();
            if (StaffMovementRequisitionId != null) {
                log.info((Object)("StaffMovementRequisition with id=" + StaffMovementRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New StaffMovementRequisition has been added, because no StaffMovementRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating StaffMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffMovementRequisition staffMovementRequisitionByIdEager(Long StaffMovementRequisitionId) throws StaffMovementRequisitionException {
        try {
            StaffMovementRequisition StaffMovementRequisition2 = this.StaffMovementRequisitionDAO.getStaffMovementRequisitionById(StaffMovementRequisitionId);
            if (StaffMovementRequisition2 != null) {
                log.info((Object)("StaffMovementRequisition with id=" + StaffMovementRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)StaffMovementRequisition2.getStaff());
                Hibernate.initialize((Object)StaffMovementRequisition2.getStaff().getInstitution());
                Hibernate.initialize((Object)StaffMovementRequisition2.getPortalTask());
                return StaffMovementRequisition2;
            }
            log.info((Object)("No StaffMovementRequisition with  id=" + StaffMovementRequisitionId + " is available"));
            return StaffMovementRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StaffMovementRequisition by id=" + StaffMovementRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StaffMovementRequisition> staffMovementRequisitionListByStudentEmail(String staffEMail) throws StaffMovementRequisitionException {
        LinkedHashSet<StaffMovementRequisition> MovementRequests = new LinkedHashSet<StaffMovementRequisition>();
        Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
        MovementRequests.addAll(this.StaffMovementRequisitionDAO.getStaffMovementRequisitionListAndStatus(staff, "Pending"));
        return MovementRequests;
    }

    @Override
    public Set<StaffMovementRequisition> staffMovementRequisitionListByMovementApprover(String studentEMail) throws StaffMovementRequisitionException {
        LinkedHashSet<StaffMovementRequisition> MovementRequests = new LinkedHashSet<StaffMovementRequisition>();
        User user = this.userDAO.getUserByEmail(studentEMail);
        MovementRequests.addAll(this.StaffMovementRequisitionDAO.getStaffMovementRequisitionListAndUserAndStatus(user, "Pending"));
        for (StaffMovementRequisition StaffMovementRequisition2 : MovementRequests) {
            Hibernate.initialize((Object)StaffMovementRequisition2.getStaff());
            Hibernate.initialize((Object)StaffMovementRequisition2.getStaff().getInstitution());
            Hibernate.initialize((Object)StaffMovementRequisition2.getPortalTask());
        }
        return MovementRequests;
    }

    @Override
    public void cancelStaffMovementRequisition(StaffMovementRequisition StaffMovementRequisition2) throws StaffMovementRequisitionException {
        try {
            log.info((Object)("StaffMovementRequisition with id=" + StaffMovementRequisition2.getStaffMovementRequisitionId() + " has been cancelled"));
            PortalTask portalTask = StaffMovementRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.StaffMovementRequisitionDAO.update(StaffMovementRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel StaffMovementRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<StaffMovementRequisition> staffMovementRequestApprovedAndRejectedLists(String staffEMail) throws StaffMovementRequisitionException {
        LinkedHashSet<StaffMovementRequisition> MovementRequests = new LinkedHashSet<StaffMovementRequisition>();
        Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
        MovementRequests.addAll(this.StaffMovementRequisitionDAO.getStaffMovementRequisitionListAndStatus(staff, "Approved"));
        MovementRequests.addAll(this.StaffMovementRequisitionDAO.getStaffMovementRequisitionListAndStatus(staff, "Rejected"));
        for (StaffMovementRequisition StaffMovementRequisition2 : MovementRequests) {
            Hibernate.initialize((Object)StaffMovementRequisition2.getStaff());
            Hibernate.initialize((Object)StaffMovementRequisition2.getStaff().getInstitution());
            Hibernate.initialize((Object)StaffMovementRequisition2.getPortalTask());
        }
        return MovementRequests;
    }
}
