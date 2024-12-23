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
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StaffLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.StaffTypeDAO;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.StaffLeaveRequisitionService;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffLeaveRequisitionService")
public class StaffLeaveRequitionServiceImpl
implements StaffLeaveRequisitionService {
    @Autowired
    StaffLeaveRequisitionDAO staffLeaveRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StaffTypeDAO staffTypeDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;

    @Override
    public Long createStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition) {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(staffLeaveRequisition.getLeaveApprover());
            PortalTask portalTask = new PortalTask("Leave Approvals", "Leave Approvals", addUser, 1, "/staff/approvals", staffLeaveRequisition.getStaff().getEmail(), staffLeaveRequisition.getStaff().getInstitution());
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            staffLeaveRequisition.setPortalTask(persistedPortalTask);
            StaffLeaveRequisition persistedStaffLeaveRequisition = this.staffLeaveRequisitionDAO.save(staffLeaveRequisition);
            Long staffLeaveRequisitionId = persistedStaffLeaveRequisition.getStaffLeaveRequisitionId();
            log.info((Object)("Staff LeaveRequisition created with the id=" + staffLeaveRequisitionId));
            return staffLeaveRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Staff LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffLeaveRequisition(Long staffLeaveRequisitionId) {
        try {
            StaffLeaveRequisition staffLeaveRequisition = this.staffLeaveRequisitionDAO.getStaffLeaveRequisitionById(staffLeaveRequisitionId);
            if (staffLeaveRequisition != null) {
                this.staffLeaveRequisitionDAO.delete(staffLeaveRequisition);
                log.info((Object)("Staff LeaveRequisition with id=" + staffLeaveRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Staff LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffLeaveRequisition> staffLeaveRequisitionList() {
        try {
            List<StaffLeaveRequisition> staffLeaveRequisitionList = this.staffLeaveRequisitionDAO.getList();
            Integer staffLeaveRequisitionListSize = staffLeaveRequisitionList.size();
            if (staffLeaveRequisitionListSize > 0) {
                log.info((Object)(staffLeaveRequisitionListSize + " staff LeaveRequisition records where reterived"));
            } else {
                log.info((Object)"No staff LeaveRequisition list available");
            }
            return staffLeaveRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff LeaveRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffLeaveRequisition staffLeaveRequisitionById(Long staffLeaveRequisitionId) {
        try {
            StaffLeaveRequisition staffLeaveRequisition = this.staffLeaveRequisitionDAO.getStaffLeaveRequisitionById(staffLeaveRequisitionId);
            if (staffLeaveRequisition != null) {
                log.info((Object)("Staff LeaveRequisition with id=" + staffLeaveRequisitionId + " has been reterived"));
                return staffLeaveRequisition;
            }
            log.info((Object)("No Staff LeaveRequisition with  id=" + staffLeaveRequisitionId + " is available"));
            return staffLeaveRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff LeaveRequisition by id=" + staffLeaveRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition) {
        try {
            this.staffLeaveRequisitionDAO.saveOrUpdate(staffLeaveRequisition);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(staffLeaveRequisition.getStaff().getUser());
            PortalTask portalTask = new PortalTask("Leave " + staffLeaveRequisition.getApprovalStatus(), "Leave " + staffLeaveRequisition.getApprovalStatus(), addUser, 1, "/staff/requisition", staffLeaveRequisition.getStaff().getEmail(), staffLeaveRequisition.getStaff().getInstitution());
            this.portalTaskDAO.save(portalTask);
            Long staffLeaveRequisitionId = staffLeaveRequisition.getStaffLeaveRequisitionId();
            if (staffLeaveRequisitionId != null) {
                log.info((Object)("Staff LeaveRequisition with id=" + staffLeaveRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New Staff LeaveRequisition has been added, because no staff LeaveRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating Staff LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffLeaveRequisition staffLeaveRequisitionByIdEager(Long staffLeaveRequisitionId) {
        try {
            StaffLeaveRequisition staffLeaveRequisition = this.staffLeaveRequisitionDAO.getStaffLeaveRequisitionById(staffLeaveRequisitionId);
            if (staffLeaveRequisition != null) {
                log.info((Object)("Staff LeaveRequisition with id=" + staffLeaveRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
                Hibernate.initialize((Object)staffLeaveRequisition.getStaff());
                Hibernate.initialize((Object)staffLeaveRequisition.getStaff().getInstitution());
                Hibernate.initialize((Object)staffLeaveRequisition.getPortalTask());
                return staffLeaveRequisition;
            }
            log.info((Object)("No Staff LeaveRequisition with  id=" + staffLeaveRequisitionId + " is available"));
            return staffLeaveRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff LeaveRequisition by id=" + staffLeaveRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffLeaveRequisition> staffLeaveRequisitionListByStaffEmail(String staffEMail) {
        try {
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
            List<StaffLeaveRequisition> staffLeaveRequisitionList = this.staffLeaveRequisitionDAO.getStaffLeaveRequisitionList(staff);
            Integer staffLeaveRequisitionListSize = staffLeaveRequisitionList.size();
            if (staffLeaveRequisitionListSize > 0) {
                for (StaffLeaveRequisition staffLeaveRequisition : staffLeaveRequisitionList) {
                    Hibernate.initialize((Object)staffLeaveRequisition);
                    Hibernate.initialize((Object)staffLeaveRequisition.getStaffLeaveType());
                    Hibernate.initialize((Object)staffLeaveRequisition.getStaff());
                    Hibernate.initialize((Object)staffLeaveRequisition.getPortalTask());
                }
                log.info((Object)(staffLeaveRequisitionListSize + " staff LeaveRequisition records where reterived"));
            } else {
                log.info((Object)"No staff LeaveRequisition list available");
            }
            return staffLeaveRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff LeaveRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void cancelStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition) {
        try {
            PortalTask portalTask = staffLeaveRequisition.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.staffLeaveRequisitionDAO.update(staffLeaveRequisition);
            log.info((Object)("Staff LeaveRequisition with id=" + staffLeaveRequisition.getStaffLeaveRequisitionId() + " has been cancelled"));
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel Staff LeaveRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
