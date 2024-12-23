/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.FeesTermDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.FeesTermException;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.FeesTermService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="feesTermService")
public class FeesTermServiceImpl
implements FeesTermService {
    @Autowired
    private FeesTermDAO feesTermDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public Long createFeesTerm(FeesTerm feesTerm) {
        try {
            FeesTerm persistedfeesTerm = this.feesTermDAO.save(feesTerm);
            Long feesTermId = persistedfeesTerm.getFeesTermId();
            log.info((Object)("FeesTerm is created with the id=" + feesTermId));
            return feesTermId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating FeesTerm", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteFeesTerm(Long feesTermId) {
        try {
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            if (feesTerm != null) {
                this.feesTermDAO.delete(feesTerm);
                log.info((Object)("FeesTerm with id=" + feesTermId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting FeesTerm", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesTerm> feesTermList() {
        try {
            List<FeesTerm> feesTermList = this.feesTermDAO.getList();
            Integer feesTermListSize = feesTermList.size();
            if (feesTermListSize > 0) {
                log.info((Object)(feesTermListSize + "feesTerm records where reterived"));
            } else {
                log.info((Object)"No feesTerm(s) available");
            }
            return feesTermList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving feesTerm list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<FeesTerm> feesTermList(Long institutionId) throws FeesTermException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                Set<FeesTerm> feesTerms = institution.getFeesTerms();
                Integer feesTermRecordSize = feesTerms.size();
                if (feesTermRecordSize > 0) {
                    log.info((Object)(feesTermRecordSize + " feesTerm records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No feesTerm Records found for institution " + institution.getInstitutionAliasName()));
                }
                return feesTerms;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new FeesTermException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving feesTerms of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesTerm feesTermById(Long feesTermId) {
        try {
            FeesTerm feesTerm = this.feesTermDAO.getFeesTermById(feesTermId);
            if (feesTerm != null) {
                log.info((Object)("feesTerm with id=" + feesTermId + " has been reterived"));
                return feesTerm;
            }
            log.info((Object)("No feesTerm with  id=" + feesTermId + " is available"));
            return feesTerm;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving feesTerm by id=" + feesTermId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(FeesTerm feesTerm) {
        try {
            this.feesTermDAO.saveOrUpdate(feesTerm);
            Long feesTermId = feesTerm.getFeesTermId();
            if (feesTermId != null) {
                log.info((Object)("feesTerm with id=" + feesTermId + " has been updated"));
            } else {
                log.info((Object)"New feesTerm has been added, because no feesTerm found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating feesTerm", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
