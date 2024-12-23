/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.FeesStructureDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.FeesStructureException;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.FeesStructureService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="feesStructureService")
public class FeesStructureServiceImpl
implements FeesStructureService {
    @Autowired
    FeesStructureDAO feesStructureDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public Long createFeesStructure(FeesStructure feesStructure) {
        try {
            FeesStructure persistedfeesStructure = this.feesStructureDAO.save(feesStructure);
            Long feesStructureId = persistedfeesStructure.getFeesStructureId();
            log.info((Object)("FeesStructure is created with the id=" + feesStructureId));
            return feesStructureId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating FeesStructure", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteFeesStructure(Long feesStructureId) {
        try {
            FeesStructure feesStructure = this.feesStructureDAO.getFeesStructureById(feesStructureId);
            if (feesStructure != null) {
                this.feesStructureDAO.delete(feesStructure);
                log.info((Object)("FeesStructure with id=" + feesStructureId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting FeesStructure", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesStructure> feesStructureList() {
        try {
            List<FeesStructure> feesStructureList = this.feesStructureDAO.getList();
            Integer listSize = feesStructureList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + " feesStructure records where reterived"));
            } else {
                log.info((Object)"No feesStructure(s) available");
            }
            return feesStructureList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving feesStructure list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesStructure feesStructureById(Long feesStructureId) {
        try {
            FeesStructure feesStructure = this.feesStructureDAO.getFeesStructureById(feesStructureId);
            if (feesStructure != null) {
                log.info((Object)("feesStructure with id=" + feesStructureId + " has been reterived"));
                return feesStructure;
            }
            log.info((Object)("No feesStructure with  id=" + feesStructureId + " is available"));
            return feesStructure;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving feesStructure by id=" + feesStructureId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateFeesStructure(FeesStructure feesStructure) {
        try {
            this.feesStructureDAO.saveOrUpdate(feesStructure);
            Long feesStructureId = feesStructure.getFeesStructureId();
            if (feesStructureId != null) {
                log.info((Object)("feesStructure with id=" + feesStructureId + " has been updated"));
            } else {
                log.info((Object)"New feesStructure has been added, because no feesStructure found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating feesStructure", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesStructure> feesStructureList(Long institutionId) throws FeesStructureException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<FeesStructure> feesStructures = this.feesStructureDAO.getFeesStructureByInstitution(institution);
                Integer feesStructureRecordSize = feesStructures.size();
                if (feesStructureRecordSize > 0) {
                    log.info((Object)(feesStructureRecordSize + " feesStructure records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No feesStructure Records found for institution " + institution.getInstitutionAliasName()));
                }
                return feesStructures;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new FeesStructureException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving feesStructures of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesStructure> feesStructureListEager(Long institutionId) throws FeesStructureException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<FeesStructure> feesStructures = this.feesStructureDAO.getFeesStructureByInstitution(institution);
                Integer feesStructureRecordSize = feesStructures.size();
                if (feesStructureRecordSize > 0) {
                    for (FeesStructure feesStructure : feesStructures) {
                        Hibernate.initialize((Object)feesStructure.getInstitution());
                        Hibernate.initialize(feesStructure.getFeesItems());
                    }
                    log.info((Object)(feesStructureRecordSize + " feesStructure records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No feesStructure Records found for institution " + institution.getInstitutionAliasName()));
                }
                return feesStructures;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new FeesStructureException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving feesStructures of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesStructure feesStructureByIdEager(Long feesStructureId) {
        try {
            FeesStructure feesStructure = this.feesStructureDAO.getFeesStructureById(feesStructureId);
            if (feesStructure != null) {
                Hibernate.initialize(feesStructure.getFeesItems());
                Hibernate.initialize((Object)feesStructure.getInstitution());
                log.info((Object)("feesStructure with id=" + feesStructureId + " has been reterived with childs"));
                return feesStructure;
            }
            log.info((Object)("No feesStructure with  id=" + feesStructureId + " is available"));
            return feesStructure;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving feesStructure with childs  by id=" + feesStructureId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
