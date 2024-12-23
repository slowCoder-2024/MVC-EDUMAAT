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
import in.jdsoft.educationmanagement.school.model.Religion;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ReligionDAO
extends GenericDAO<Religion> {
    public ReligionDAO() {
        super(Religion.class);
    }

    public Religion getReligionById(Long id) {
        Religion instance = (Religion)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Religion", (Serializable)id);
        return instance;
    }

    public Religion getReligionByReligionName(String religionName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Religion.class);
        criteria.add((Criterion)Restrictions.eq((String)"religionName", (Object)religionName));
        Religion religion = (Religion)criteria.uniqueResult();
        return religion;
    }
}
