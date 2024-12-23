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
import in.jdsoft.educationmanagement.school.model.InventoryType;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryTypeDAO
extends GenericDAO<InventoryType> {
    public InventoryTypeDAO() {
        super(InventoryType.class);
    }

    public InventoryType getInventoryTypeById(Long id) {
        InventoryType instance = (InventoryType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryType", (Serializable)id);
        return instance;
    }

    public InventoryType getInventoryTypeByInventoryTypeName(String inventoryTypeName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryType.class);
        criteria.add((Criterion)Restrictions.eq((String)"inventoryType", (Object)inventoryTypeName));
        InventoryType inventoryType = (InventoryType)criteria.uniqueResult();
        return inventoryType;
    }
}
