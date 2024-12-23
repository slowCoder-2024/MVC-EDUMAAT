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

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SMSGatewayDetailsDAO;
import in.jdsoft.educationmanagement.school.exceptions.SMSGatewayDetailsException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SMSGatewayDetails;
import in.jdsoft.educationmanagement.school.services.SMSGatewayDetailsService;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="sMSGatewayDetailsService")
public class SMSGatewayDetailsServiceImpl
implements SMSGatewayDetailsService {
    @Autowired
    SMSGatewayDetailsDAO sMSGatewayDetailsDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    private Logger log = LogManager.getLogger((String)SMSGatewayDetailsServiceImpl.class.getName());

    @Override
    @Transactional(rollbackFor={SMSGatewayDetailsException.class})
    public void createSMSGatewayDetails(SMSGatewayDetails sMSGatewayDetails) throws SMSGatewayDetailsException {
        try {
            this.sMSGatewayDetailsDAO.persist(sMSGatewayDetails);
            this.log.info((Object)"SMSGatewayDetails is created");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSMSGatewayDetails(SMSGatewayDetails sMSGatewayDetails) throws SMSGatewayDetailsException {
        try {
            this.sMSGatewayDetailsDAO.update(sMSGatewayDetails);
            this.log.info((Object)"SMSGatewayDetails is updated");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating SMSGatewayDetails", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteSMSGatewayDetails(Long sMSGatewayDetailsId) throws SMSGatewayDetailsException {
        try {
            this.sMSGatewayDetailsDAO.delete(this.sMSGatewayDetailsDAO.getSMSGatewayDetailsById(sMSGatewayDetailsId));
            this.log.info((Object)"SMSGatewayDetails is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting SMSGatewayDetails", e.getCause());
            throw e;
        }
    }

    @Override
    public SMSGatewayDetails sMSGatewayDetailsById(Long sMSGatewayDetailsId) {
        try {
            SMSGatewayDetails SMSGatewayDetails2 = this.sMSGatewayDetailsDAO.getSMSGatewayDetailsById(sMSGatewayDetailsId);
            if (SMSGatewayDetails2 != null) {
                this.log.info((Object)("SMSGatewayDetails with id=" + sMSGatewayDetailsId + " has been reterived"));
                return SMSGatewayDetails2;
            }
            this.log.info((Object)("No SMSGatewayDetails with  id=" + sMSGatewayDetailsId + " is available"));
            return SMSGatewayDetails2;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving SMSGatewayDetails by id=" + sMSGatewayDetailsId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SMSGatewayDetails sMSGatewayDetailsIdByEager(Long sMSGatewayDetailsId) {
        try {
            SMSGatewayDetails sMSGatewayDetails = this.sMSGatewayDetailsDAO.getSMSGatewayDetailsById(sMSGatewayDetailsId);
            if (sMSGatewayDetails != null) {
                this.log.info((Object)("SMSGatewayDetails with id=" + sMSGatewayDetailsId + " has been retrieved"));
                return sMSGatewayDetails;
            }
            this.log.info((Object)("No SMSGatewayDetails with  id=" + sMSGatewayDetailsId + " is available"));
            return sMSGatewayDetails;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving SMSGatewayDetails by id=" + sMSGatewayDetailsId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SMSGatewayDetails> sMSGatewayDetailsList() {
        try {
            List<SMSGatewayDetails> sMSGatewayDetailsList = this.sMSGatewayDetailsDAO.getList();
            Integer SMSGatewayDetailsListSize = sMSGatewayDetailsList.size();
            if (SMSGatewayDetailsListSize > 0) {
                this.log.info((Object)(SMSGatewayDetailsListSize + " SMSGatewayDetails records where retrieved"));
            } else {
                this.log.info((Object)"No SMSGatewayDetails list available");
            }
            return sMSGatewayDetailsList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving SMSGatewayDetails list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SMSGatewayDetails> sMSGatewayDetailsListByInstitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<SMSGatewayDetails> sMSGatewayDetailsList = this.sMSGatewayDetailsDAO.getSMSGatewayDetailsByInstitution(institution);
            Integer SMSGatewayDetailsListSize = sMSGatewayDetailsList.size();
            if (SMSGatewayDetailsListSize > 0) {
                this.log.info((Object)(SMSGatewayDetailsListSize + " SMSGatewayDetails records where retrieved"));
            } else {
                this.log.info((Object)"No SMSGatewayDetails list available");
            }
            return sMSGatewayDetailsList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving SMSGatewayDetails list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SMSGatewayDetails sMSGatewayDetailsByInstitution(Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            SMSGatewayDetails sMSGatewayDetails = this.sMSGatewayDetailsDAO.getSMSGatewayDetailByInstitution(institution);
            return sMSGatewayDetails;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving SMSGatewayDetails ", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
