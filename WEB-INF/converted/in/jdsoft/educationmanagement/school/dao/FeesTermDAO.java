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
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FeesTermDAO
extends GenericDAO<FeesTerm> {
    public FeesTermDAO() {
        super(FeesTerm.class);
    }

    public FeesTerm getFeesTermById(Long id) {
        FeesTerm instance = (FeesTerm)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.FeesTerm", (Serializable)id);
        return instance;
    }

    public List<FeesTerm> feesTermInInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesTerm.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List feesTerms = criteria.list();
        return feesTerms;
    }
}
