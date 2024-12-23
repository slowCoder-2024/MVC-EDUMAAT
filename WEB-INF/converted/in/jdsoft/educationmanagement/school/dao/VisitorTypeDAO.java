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
import in.jdsoft.educationmanagement.school.model.VisitorType;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorTypeDAO
extends GenericDAO<VisitorType> {
    public VisitorTypeDAO() {
        super(VisitorType.class);
    }

    public VisitorType getVisitorTypeById(Long id) {
        VisitorType instance = (VisitorType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.VisitorType", (Serializable)id);
        return instance;
    }

    public VisitorType getVisitorTypeByVisitorTypeName(String visitorTypeName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(VisitorType.class);
        criteria.add((Criterion)Restrictions.eq((String)"visitorType", (Object)visitorTypeName));
        VisitorType visitorType = (VisitorType)criteria.uniqueResult();
        return visitorType;
    }
}
