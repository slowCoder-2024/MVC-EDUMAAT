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
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class HousesDAO
extends GenericDAO<Houses> {
    public HousesDAO() {
        super(Houses.class);
    }

    public Houses getHousesById(Long id) {
        Houses instance = (Houses)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Houses", (Serializable)id);
        return instance;
    }

    public List<Houses> getHousesByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Houses.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List specialCategories = criteria.list();
        return specialCategories;
    }

    public Houses getHousesByNameAndInstitution(String HousesName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Houses.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"houseName", (Object)HousesName)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        Houses Houses2 = (Houses)criteria.uniqueResult();
        return Houses2;
    }
}
