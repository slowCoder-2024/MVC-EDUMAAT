/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.FeesPenaltySettingDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.FeesPenaltySettingException;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.services.FeesPenaltySettingService;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="FfeesPenaltySettingService")
public class FeesPenaltySettingServiceImpl
implements FeesPenaltySettingService {
    @Autowired
    FeesPenaltySettingDAO feesPenaltySettingDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    private Logger log = LogManager.getLogger((String)FeesPenaltySettingServiceImpl.class.getName());

    @Override
    @Transactional(rollbackFor={FeesPenaltySettingException.class})
    public void createFeesPenaltySetting(FeesPenaltySetting feesPenaltySetting) throws FeesPenaltySettingException {
        try {
            this.feesPenaltySettingDAO.persist(feesPenaltySetting);
            this.log.info((Object)"FeesPenaltySetting is created");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateFeesPenaltySetting(FeesPenaltySetting feesPenaltySetting) throws FeesPenaltySettingException {
        try {
            this.feesPenaltySettingDAO.update(feesPenaltySetting);
            this.log.info((Object)"FeesPenaltySetting is updated");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating FeesPenaltySetting", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteFeesPenaltySetting(Long feesPenaltySettingId) throws FeesPenaltySettingException {
        try {
            this.feesPenaltySettingDAO.delete(this.feesPenaltySettingDAO.getFeesPenaltySettingById(feesPenaltySettingId));
            this.log.info((Object)"FeesPenaltySetting is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting FeesPenaltySetting", e.getCause());
            throw e;
        }
    }

    @Override
    public FeesPenaltySetting feesPenaltySettingById(Long feesPenaltySettingId) {
        try {
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingDAO.getFeesPenaltySettingById(feesPenaltySettingId);
            if (feesPenaltySetting != null) {
                this.log.info((Object)("FeesPenaltySetting with id=" + feesPenaltySettingId + " has been reterived"));
                return feesPenaltySetting;
            }
            this.log.info((Object)("No FeesPenaltySetting with  id=" + feesPenaltySettingId + " is available"));
            return feesPenaltySetting;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving FeesPenaltySetting by id=" + feesPenaltySettingId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesPenaltySetting feesPenaltySettingIdByEager(Long feesPenaltySettingId) {
        try {
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingDAO.getFeesPenaltySettingById(feesPenaltySettingId);
            if (feesPenaltySetting != null) {
                this.log.info((Object)("FeesPenaltySetting with id=" + feesPenaltySettingId + " has been retrieved"));
                return feesPenaltySetting;
            }
            this.log.info((Object)("No FeesPenaltySetting with  id=" + feesPenaltySettingId + " is available"));
            return feesPenaltySetting;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving FeesPenaltySetting by id=" + feesPenaltySettingId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesPenaltySetting> feesPenaltySettingList() {
        try {
            List<FeesPenaltySetting> feesPenaltySettingList = this.feesPenaltySettingDAO.getList();
            Integer feesPenaltySettingListSize = feesPenaltySettingList.size();
            if (feesPenaltySettingListSize > 0) {
                this.log.info((Object)(feesPenaltySettingListSize + " FeesPenaltySetting records where retrieved"));
            } else {
                this.log.info((Object)"No FeesPenaltySetting list available");
            }
            return feesPenaltySettingList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving FeesPenaltySetting list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesPenaltySetting> feesPenaltySettingListByInstitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<FeesPenaltySetting> feesPenaltySettingList = this.feesPenaltySettingDAO.getFeesPenaltySettingListByInstitution(institution);
            Integer feesPenaltySettingListSize = feesPenaltySettingList.size();
            if (feesPenaltySettingListSize > 0) {
                this.log.info((Object)(feesPenaltySettingListSize + " FeesPenaltySetting records where retrieved"));
            } else {
                this.log.info((Object)"No FeesPenaltySetting list available");
            }
            return feesPenaltySettingList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving FeesPenaltySetting list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesPenaltySetting feesPenaltySettingByInstitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingDAO.getFeesPenaltySettingByInstitution(institution);
            return feesPenaltySetting;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving FeesPenaltySetting ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesPenaltySetting feesPenaltySettingByFeesPenaltySeetingType(String feesPenaltySettingType) {
        try {
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingDAO.getFeesPenaltySettingByFeesPenaltySettingType(feesPenaltySettingType);
            return feesPenaltySetting;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving FeesPenaltySetting ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesPenaltySetting feesPenaltySettingByFeesPenaltySettingTypeAndInstitution(String feesPenaltySettingType, Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            FeesPenaltySetting feesPenaltySetting = this.feesPenaltySettingDAO.getFeesPenaltySettingByFeesPenaltySettingTypeAndInstitution(feesPenaltySettingType, institution);
            return feesPenaltySetting;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving FeesPenaltySetting ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
