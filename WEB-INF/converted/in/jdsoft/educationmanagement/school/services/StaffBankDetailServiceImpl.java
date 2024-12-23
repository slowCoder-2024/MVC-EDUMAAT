/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StaffBankDetailDAO;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.services.StaffBankDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="StaffBankDetailService")
public class StaffBankDetailServiceImpl
implements StaffBankDetailService {
    @Autowired
    StaffBankDetailDAO staffBankDetailDAO;

    @Override
    public List<StaffBankDetail> staffBankDetailList() {
        try {
            List<StaffBankDetail> staffBankDetailList = this.staffBankDetailDAO.getList();
            Integer staffBankDetailSize = staffBankDetailList.size();
            if (staffBankDetailSize > 0) {
                log.info((Object)(staffBankDetailSize + " StaffBankDetail records where reterived"));
            } else {
                log.info((Object)"No StaffBankDetail(s) available");
            }
            return staffBankDetailList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StaffBankDetail list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffBankDetail staffBankDetailById(Long staffBankDetailId) {
        try {
            StaffBankDetail staffBankDetail = this.staffBankDetailDAO.getStaffBankDetailById(staffBankDetailId);
            if (staffBankDetail != null) {
                log.info((Object)("StaffBankDetail with id=" + staffBankDetailId + " has been reterived"));
                return staffBankDetail;
            }
            log.info((Object)("No StaffBankDetail with  id=" + staffBankDetailId + " is available"));
            return staffBankDetail;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StaffBankDetail by id=" + staffBankDetailId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
