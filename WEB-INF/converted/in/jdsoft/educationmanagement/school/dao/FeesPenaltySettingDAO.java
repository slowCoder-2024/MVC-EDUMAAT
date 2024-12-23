/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FeesPenaltySettingDAO
extends GenericDAO<FeesPenaltySetting> {
    public FeesPenaltySettingDAO() {
        super(FeesPenaltySetting.class);
    }

    public FeesPenaltySetting getFeesPenaltySettingById(Long id) {
        FeesPenaltySetting instance = (FeesPenaltySetting)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.FeesPenaltySetting", (Serializable)id);
        return instance;
    }

    public List<FeesPenaltySetting> getFeesPenaltySettingListByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesPenaltySetting.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List feesPenaltySetting = criteria.list();
        return feesPenaltySetting;
    }

    public FeesPenaltySetting getFeesPenaltySettingByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesPenaltySetting.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        FeesPenaltySetting feesPenaltySetting = (FeesPenaltySetting)criteria.uniqueResult();
        return feesPenaltySetting;
    }

    public FeesPenaltySetting getFeesPenaltySettingByFeesPenaltySettingType(String feesPenaltySettingType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesPenaltySetting.class);
        criteria.add((Criterion)Restrictions.eq((String)"feesPenaltySettingType", (Object)feesPenaltySettingType));
        FeesPenaltySetting feesPenaltySetting = (FeesPenaltySetting)criteria.uniqueResult();
        return feesPenaltySetting;
    }

    public FeesPenaltySetting getFeesPenaltySettingByFeesPenaltySettingTypeAndInstitution(String feesPenaltySettingType, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesPenaltySetting.class);
        criteria.add((Criterion)Restrictions.eq((String)"feesPenaltySettingType", (Object)feesPenaltySettingType));
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        FeesPenaltySetting feesPenaltySetting = (FeesPenaltySetting)criteria.uniqueResult();
        return feesPenaltySetting;
    }
}
