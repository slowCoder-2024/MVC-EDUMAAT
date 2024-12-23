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
import in.jdsoft.educationmanagement.school.model.InventoryCategory;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryCategoryDAO
extends GenericDAO<InventoryCategory> {
    public InventoryCategoryDAO() {
        super(InventoryCategory.class);
    }

    public InventoryCategory getInventoryCategoryById(Long id) {
        InventoryCategory instance = (InventoryCategory)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryCategory", (Serializable)id);
        return instance;
    }

    public InventoryCategory getInventoryCategoryByInventoryCategoryName(String inventoryCategoryName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryCategory.class);
        criteria.add((Criterion)Restrictions.eq((String)"inventoryCategoryName", (Object)inventoryCategoryName));
        InventoryCategory inventoryCategory = (InventoryCategory)criteria.uniqueResult();
        return inventoryCategory;
    }
}
