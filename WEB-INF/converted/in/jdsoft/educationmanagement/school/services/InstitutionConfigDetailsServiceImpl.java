/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionConfigDetailsDAO;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.services.InstitutionConfigDetailsService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="InstitutionConfigDetailsService")
public class InstitutionConfigDetailsServiceImpl
implements InstitutionConfigDetailsService {
    @Autowired
    private InstitutionConfigDetailsDAO institutionConfigDetailsDAO;

    @Override
    public Long createInstitutionConfigDetails(InstitutionConfigDetails institutionConfigDetails) {
        try {
            InstitutionConfigDetails persistedInstitutionConfigDetails = this.institutionConfigDetailsDAO.save(institutionConfigDetails);
            Long institutionConfigDetailsId = persistedInstitutionConfigDetails.getInstitutionConfigDetailsId();
            log.info((Object)("InstitutionConfigDetails is created with the id=" + institutionConfigDetailsId));
            return institutionConfigDetailsId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating InstitutionConfigDetails", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InstitutionConfigDetails> institutionConfigDetailsList() {
        try {
            List<InstitutionConfigDetails> institutionConfigDetailsList = this.institutionConfigDetailsDAO.getList();
            Integer institutionConfigDetailsListSize = institutionConfigDetailsList.size();
            if (institutionConfigDetailsListSize > 0) {
                log.info((Object)(institutionConfigDetailsListSize + "InstitutionConfigDetails records where reterived"));
            } else {
                log.info((Object)"No InstitutionConfigDetail(s) available");
            }
            return institutionConfigDetailsList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InstitutionConfigDetails list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InstitutionConfigDetails institutionConfigDetailsById(Long institutionConfigDetailsId) {
        try {
            InstitutionConfigDetails institutionConfigDetail = this.institutionConfigDetailsDAO.getInstitutionConfigDetailsById(institutionConfigDetailsId);
            if (institutionConfigDetail != null) {
                log.info((Object)("institutionConfigDetail with id=" + institutionConfigDetailsId + " has been reterived"));
                return institutionConfigDetail;
            }
            log.info((Object)("No InstitutionConfigDetail with  id=" + institutionConfigDetailsId + " is available"));
            return institutionConfigDetail;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InstitutionConfigDetail by id=" + institutionConfigDetailsId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InstitutionConfigDetails institutionConfigDetail() {
        InstitutionConfigDetails institutionConfigDetail = null;
        List institutionConfigDetailsList = this.institutionConfigDetailsDAO.getList();
        Iterator iterator = institutionConfigDetailsList.iterator();
        while (iterator.hasNext()) {
            InstitutionConfigDetails InstitutionConfigDetails2;
            institutionConfigDetail = InstitutionConfigDetails2 = (InstitutionConfigDetails)iterator.next();
        }
        return institutionConfigDetail;
    }
}
