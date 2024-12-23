/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StaffExperienceDetailDAO;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.services.StaffExperienceDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="StaffExperienceDetailService")
public class StaffExperienceDetailServiceImpl
implements StaffExperienceDetailService {
    @Autowired
    StaffExperienceDetailDAO staffExperienceDetailDAO;

    @Override
    public List<StaffExperienceDetail> staffExperienceDetailList() {
        try {
            List<StaffExperienceDetail> staffExperienceDetailList = this.staffExperienceDetailDAO.getList();
            Integer staffExperienceDetailSize = staffExperienceDetailList.size();
            if (staffExperienceDetailSize > 0) {
                log.info((Object)(staffExperienceDetailSize + " StaffExperienceDetail records where reterived"));
            } else {
                log.info((Object)"No StaffExperienceDetail(s) available");
            }
            return staffExperienceDetailList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StaffExperienceDetail list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffExperienceDetail staffExperienceDetailById(Long staffExperienceDetailId) {
        try {
            StaffExperienceDetail staffExperienceDetail = this.staffExperienceDetailDAO.getStaffExperienceDetailById(staffExperienceDetailId);
            if (staffExperienceDetail != null) {
                log.info((Object)("StaffExperienceDetail with id=" + staffExperienceDetailId + " has been reterived"));
                return staffExperienceDetail;
            }
            log.info((Object)("No StaffExperienceDetail with  id=" + staffExperienceDetailId + " is available"));
            return staffExperienceDetail;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StaffExperienceDetail by id=" + staffExperienceDetailId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffExperienceDetail(Long staffExperienceDetailId) {
        try {
            StaffExperienceDetail staffExperienceDetail = this.staffExperienceDetailDAO.getStaffExperienceDetailById(staffExperienceDetailId);
            if (staffExperienceDetail != null) {
                this.staffExperienceDetailDAO.delete(staffExperienceDetail);
                log.info((Object)("StaffExperienceDetail with id=" + staffExperienceDetailId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting StaffExperienceDetail", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
