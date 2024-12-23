/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StaffAttendanceConfigurationDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffAttendanceConfigurationException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import in.jdsoft.educationmanagement.school.services.StaffAttendanceConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffAttendanceConfigurationService")
public class StaffAttendanceConfigurationServiceImpl
implements StaffAttendanceConfigurationService {
    @Autowired
    private StaffAttendanceConfigurationDAO staffAttendanceConfigurationDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public StaffAttendanceConfiguration staffAttendanceConfiguration(Long institutionId) throws StaffAttendanceConfigurationException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                StaffAttendanceConfiguration staffAttendanceConfiguration = institution.getStaffAttendanceConfiguration();
                if (staffAttendanceConfiguration != null) {
                    log.info((Object)("staff attendance configuration of institution " + institution.getInstitutionAliasName() + " has been reterived"));
                } else {
                    log.info((Object)("No staff attendance configuration found for institution " + institution.getInstitutionAliasName()));
                }
                return staffAttendanceConfiguration;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffAttendanceConfigurationException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving staff attendance configuration of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(StaffAttendanceConfiguration staffAttendanceConfiguration) {
        try {
            Institution institution = staffAttendanceConfiguration.getInstitution();
            if (institution != null) {
                StaffAttendanceConfiguration staffAttendanceConfig = institution.getStaffAttendanceConfiguration();
                if (staffAttendanceConfig == null) {
                    this.staffAttendanceConfigurationDAO.saveOrUpdate(staffAttendanceConfiguration);
                    Long staffAttendanceConfigurationId = staffAttendanceConfiguration.getStaffAttendanceConfigurationId();
                    if (staffAttendanceConfigurationId != null) {
                        log.info((Object)("staff attendance configuration with id=" + staffAttendanceConfigurationId + " has been updated"));
                    } else {
                        log.info((Object)"New staff attendance configuration has been added, because no staff attendance configuration found for update");
                    }
                } else {
                    staffAttendanceConfig.setStartingWorkTime(staffAttendanceConfiguration.getStartingWorkTime());
                    staffAttendanceConfig.setClosingWorkTime(staffAttendanceConfiguration.getClosingWorkTime());
                    staffAttendanceConfig.setEnablePermissionHours(staffAttendanceConfiguration.isEnablePermissionHours());
                    staffAttendanceConfig.setEnableLeaveDays(staffAttendanceConfiguration.isEnableLeaveDays());
                    staffAttendanceConfig.setMonthlyPermissionHours(staffAttendanceConfiguration.getMonthlyPermissionHours());
                    staffAttendanceConfig.setMonthlyleaveDays(staffAttendanceConfiguration.getMonthlyleaveDays());
                    staffAttendanceConfig.setPermissionCarryForward(staffAttendanceConfiguration.isPermissionCarryForward());
                    staffAttendanceConfig.setLeaveCarryForward(staffAttendanceConfiguration.isLeaveCarryForward());
                    this.staffAttendanceConfigurationDAO.update(staffAttendanceConfig);
                    log.info((Object)"staff attendance configuration has been updated");
                }
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating feesItem", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
