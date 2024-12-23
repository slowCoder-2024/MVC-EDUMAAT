/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StaffTypeDAO;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffTypeService")
public class StaffTypeServiceImpl
implements StaffTypeService {
    @Autowired
    StaffTypeDAO staffTypeDAO;

    @Override
    public List<StaffType> staffTypeList() {
        try {
            List<StaffType> staffTypeList = this.staffTypeDAO.getList();
            Integer staffTypeListSize = staffTypeList.size();
            if (staffTypeListSize > 0) {
                log.info((Object)(staffTypeListSize + " staff type records where reterived"));
            } else {
                log.info((Object)"No staff type list available");
            }
            return staffTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff type list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffType staffTypeById(Long staffTypeId) {
        try {
            StaffType staffType = this.staffTypeDAO.getStaffTypeById(staffTypeId);
            if (staffType != null) {
                log.info((Object)("Staff Type with id=" + staffTypeId + " has been reterived"));
                return staffType;
            }
            log.info((Object)("No Staff Type with  id=" + staffTypeId + " is available"));
            return staffType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff type by id=" + staffTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
