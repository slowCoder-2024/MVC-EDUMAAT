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
import in.jdsoft.educationmanagement.school.model.Category;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAO
extends GenericDAO<Category> {
    public CategoryDAO() {
        super(Category.class);
    }

    public Category getCategoryById(Long id) {
        Category instance = (Category)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Category", (Serializable)id);
        return instance;
    }

    public Category getCategoryByCategoryName(String categoryName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Category.class);
        criteria.add((Criterion)Restrictions.eq((String)"categoryName", (Object)categoryName));
        Category category = (Category)criteria.uniqueResult();
        return category;
    }
}
