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
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class FeesStructureDAO
extends GenericDAO<FeesStructure> {
    public FeesStructureDAO() {
        super(FeesStructure.class);
    }

    public FeesStructure getFeesStructureById(Long id) {
        FeesStructure instance = (FeesStructure)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.FeesStructure", (Serializable)id);
        return instance;
    }

    public List<FeesStructure> getFeesStructureByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(FeesStructure.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List feesStructures = criteria.list();
        return feesStructures;
    }
}
