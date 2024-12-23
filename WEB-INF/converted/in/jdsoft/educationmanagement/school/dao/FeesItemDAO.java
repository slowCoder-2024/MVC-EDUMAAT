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
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FeesItemDAO
extends GenericDAO<FeesItem> {
    public FeesItemDAO() {
        super(FeesItem.class);
    }

    public FeesItem getFeesItemById(Long id) {
        FeesItem instance = (FeesItem)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.FeesItem", (Serializable)id);
        return instance;
    }

    public List<FeesItem> getFeesItemByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesItem.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List feesItems = criteria.list();
        return feesItems;
    }
}
