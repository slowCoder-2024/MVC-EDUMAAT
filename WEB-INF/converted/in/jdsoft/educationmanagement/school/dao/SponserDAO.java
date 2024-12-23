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
import in.jdsoft.educationmanagement.school.model.Sponser;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SponserDAO
extends GenericDAO<Sponser> {
    public SponserDAO() {
        super(Sponser.class);
    }

    public Sponser getSponserById(Long id) {
        Sponser instance = (Sponser)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Sponser", (Serializable)id);
        return instance;
    }

    public Sponser getSponserBySponserName(String sponserName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Sponser.class);
        criteria.add((Criterion)Restrictions.eq((String)"sponserTitle", (Object)sponserName));
        Sponser sponser = (Sponser)criteria.uniqueResult();
        return sponser;
    }
}
