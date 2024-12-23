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
import in.jdsoft.educationmanagement.school.model.HearedUs;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HearedUsDAO
extends GenericDAO<HearedUs> {
    public HearedUsDAO() {
        super(HearedUs.class);
    }

    public HearedUs getHearedUsById(Long id) {
        HearedUs instance = (HearedUs)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.HearedUs", (Serializable)id);
        return instance;
    }

    public HearedUs getHearedUsByHearedUsName(String hearedUsName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(HearedUs.class);
        criteria.add((Criterion)Restrictions.eq((String)"hearedUsTitle", (Object)hearedUsName));
        HearedUs hearedUs = (HearedUs)criteria.uniqueResult();
        return hearedUs;
    }
}
