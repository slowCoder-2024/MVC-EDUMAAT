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
import in.jdsoft.educationmanagement.school.dao.StaffLeaveTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StaffTypeDAO;
import in.jdsoft.educationmanagement.school.model.StaffLeaveType;
import in.jdsoft.educationmanagement.school.services.StaffLeaveTypeService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffLeaveTypeService")
public class StaffLeaveTypeServiceImpl
implements StaffLeaveTypeService {
    @Autowired
    StaffLeaveTypeDAO staffLeaveTypeDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StaffTypeDAO staffTypeDAO;

    @Override
    public Long createStaffLeaveType(StaffLeaveType staffLeaveType) {
        try {
            StaffLeaveType persistedStaffLeaveType = this.staffLeaveTypeDAO.save(staffLeaveType);
            Long staffLeaveTypeId = persistedStaffLeaveType.getStaffLeaveTypeId();
            log.info((Object)("Staff LeaveType created with the id=" + staffLeaveTypeId));
            return staffLeaveTypeId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Staff LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffLeaveType(Long staffLeaveTypeId) {
        try {
            StaffLeaveType staffLeaveType = this.staffLeaveTypeDAO.getStaffLeaveTypeById(staffLeaveTypeId);
            if (staffLeaveType != null) {
                this.staffLeaveTypeDAO.delete(staffLeaveType);
                log.info((Object)("Staff LeaveType with id=" + staffLeaveTypeId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Staff LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffLeaveType> staffLeaveTypeList() {
        try {
            List<StaffLeaveType> staffLeaveTypeList = this.staffLeaveTypeDAO.getList();
            Integer staffLeaveTypeListSize = staffLeaveTypeList.size();
            if (staffLeaveTypeListSize > 0) {
                log.info((Object)(staffLeaveTypeListSize + " staff LeaveType records where reterived"));
            } else {
                log.info((Object)"No staff LeaveType list available");
            }
            return staffLeaveTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff LeaveType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffLeaveType staffLeaveTypeById(Long staffLeaveTypeId) {
        try {
            StaffLeaveType staffLeaveType = this.staffLeaveTypeDAO.getStaffLeaveTypeById(staffLeaveTypeId);
            if (staffLeaveType != null) {
                log.info((Object)("Staff LeaveType with id=" + staffLeaveTypeId + " has been reterived"));
                return staffLeaveType;
            }
            log.info((Object)("No Staff LeaveType with  id=" + staffLeaveTypeId + " is available"));
            return staffLeaveType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff LeaveType by id=" + staffLeaveTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffLeaveType(StaffLeaveType staffLeaveType) {
        try {
            this.staffLeaveTypeDAO.saveOrUpdate(staffLeaveType);
            Long staffLeaveTypeId = staffLeaveType.getStaffLeaveTypeId();
            if (staffLeaveTypeId != null) {
                log.info((Object)("Staff LeaveType with id=" + staffLeaveTypeId + " has been updated"));
            } else {
                log.info((Object)"New Staff LeaveType has been added, because no staff LeaveType found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating Staff LeaveType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffLeaveType staffLeaveTypeByIdEager(Long staffLeaveTypeId) {
        try {
            StaffLeaveType staffLeaveType = this.staffLeaveTypeDAO.getStaffLeaveTypeById(staffLeaveTypeId);
            if (staffLeaveType != null) {
                log.info((Object)("Staff LeaveType with id=" + staffLeaveTypeId + " has been reterived"));
                Hibernate.initialize(staffLeaveType.getStaffLeaveRequisitions());
                return staffLeaveType;
            }
            log.info((Object)("No Staff LeaveType with  id=" + staffLeaveTypeId + " is available"));
            return staffLeaveType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff LeaveType by id=" + staffLeaveTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
