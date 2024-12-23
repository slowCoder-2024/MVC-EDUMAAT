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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SpecialCategoryDAO
extends GenericDAO<SpecialCategory> {
    public SpecialCategoryDAO() {
        super(SpecialCategory.class);
    }

    public SpecialCategory getSpecialCategoryById(Long id) {
        SpecialCategory instance = (SpecialCategory)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.SpecialCategory", (Serializable)id);
        return instance;
    }

    public List<SpecialCategory> getSpecialCategoryByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SpecialCategory.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List specialCategories = criteria.list();
        return specialCategories;
    }

    public SpecialCategory getSpecialCategoryByNameAndInstitution(String specialCategoryName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SpecialCategory.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"specialCategoryName", (Object)specialCategoryName)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        SpecialCategory specialCategory = (SpecialCategory)criteria.uniqueResult();
        return specialCategory;
    }
}
