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
import in.jdsoft.educationmanagement.school.model.Privilege;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PrivilegeDAO
extends GenericDAO<Privilege> {
    public PrivilegeDAO() {
        super(Privilege.class);
    }

    public Privilege getPrivilegeById(Long id) {
        Privilege instance = (Privilege)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Privilege", (Serializable)id);
        return instance;
    }

    public List<Privilege> privilegesByTargetType(String targetType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Privilege.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetType", (Object)targetType));
        List privileges = criteria.list();
        return privileges;
    }
}
