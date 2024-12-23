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
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class BloodGroupDAO
extends GenericDAO<BloodGroup> {
    public BloodGroupDAO() {
        super(BloodGroup.class);
    }

    public BloodGroup getBloodGroupById(Long id) {
        BloodGroup instance = (BloodGroup)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.BloodGroup", (Serializable)id);
        return instance;
    }

    public BloodGroup getBloodGroupByName(String bloodGroupName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(BloodGroup.class);
        criteria.add((Criterion)Restrictions.eq((String)"bloodGroupName", (Object)bloodGroupName));
        BloodGroup bloodGroup = (BloodGroup)criteria.uniqueResult();
        return bloodGroup;
    }
}
