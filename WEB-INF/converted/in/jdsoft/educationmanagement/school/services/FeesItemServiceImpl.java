/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.FeesItemDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.FeesItemException;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.FeesItemService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="feesItemService")
public class FeesItemServiceImpl
implements FeesItemService {
    @Autowired
    FeesItemDAO feesItemDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public Long createFeesItem(FeesItem feesItem) {
        try {
            FeesItem persistedfeesItem = this.feesItemDAO.save(feesItem);
            Long feesItemId = persistedfeesItem.getFeesItemId();
            log.info((Object)("FeesItem is created with the id=" + feesItemId));
            return feesItemId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating FeesItem", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteFeesItem(Long feesItemId) {
        try {
            FeesItem feesItem = this.feesItemDAO.getFeesItemById(feesItemId);
            if (feesItem != null) {
                this.feesItemDAO.delete(feesItem);
                log.info((Object)("FeesItem with id=" + feesItemId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting FeesItem", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesItem> feesItemList() {
        try {
            List<FeesItem> feesItemList = this.feesItemDAO.getList();
            Integer listSize = feesItemList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + " feesItem records where reterived"));
            } else {
                log.info((Object)"No feesItem(s) available");
            }
            return feesItemList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving feesItem list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public FeesItem feesItemById(Long feesItemId) {
        try {
            FeesItem feesItem = this.feesItemDAO.getFeesItemById(feesItemId);
            if (feesItem != null) {
                Hibernate.initialize(feesItem.getFeesStructures());
                Hibernate.initialize((Object)feesItem.getLedgerAccount());
                Hibernate.initialize((Object)feesItem.getInstitution());
                Hibernate.initialize(feesItem.getTaxClasses());
                log.info((Object)("feesItem with id=" + feesItemId + " has been reterived"));
                return feesItem;
            }
            log.info((Object)("No feesItem with  id=" + feesItemId + " is available"));
            return feesItem;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving feesItem by id=" + feesItemId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateFeesItem(FeesItem feesItem) {
        try {
            this.feesItemDAO.saveOrUpdate(feesItem);
            Long feesItemId = feesItem.getFeesItemId();
            if (feesItemId != null) {
                log.info((Object)("feesItem with id=" + feesItemId + " has been updated"));
            } else {
                log.info((Object)"New feesItem has been added, because no feesItem found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating feesItem", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FeesItem> feesItemList(Long institutionId) throws FeesItemException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<FeesItem> feesItems = this.feesItemDAO.getFeesItemByInstitution(institution);
                Integer feesItemRecordSize = feesItems.size();
                if (feesItemRecordSize > 0) {
                    for (FeesItem feesItem : feesItems) {
                        Hibernate.initialize(feesItem.getFeesStructures());
                        Hibernate.initialize((Object)feesItem.getLedgerAccount());
                        Hibernate.initialize((Object)feesItem.getInstitution());
                    }
                    log.info((Object)(feesItemRecordSize + " feesItem records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No feesItem Records found for institution " + institution.getInstitutionAliasName()));
                }
                return feesItems;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new FeesItemException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving feesItems of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
