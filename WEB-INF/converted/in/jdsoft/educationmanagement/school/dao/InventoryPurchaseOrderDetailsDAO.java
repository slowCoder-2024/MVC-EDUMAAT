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
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryPurchaseOrderDetailsDAO
extends GenericDAO<InventoryPurchaseOrderDetails> {
    public InventoryPurchaseOrderDetailsDAO() {
        super(InventoryPurchaseOrderDetails.class);
    }

    public InventoryPurchaseOrderDetails getInventoryPurchaseOrderDetailsById(Long id) {
        InventoryPurchaseOrderDetails instance = (InventoryPurchaseOrderDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails", (Serializable)id);
        return instance;
    }

    public InventoryPurchaseOrderDetails getInventoryPurchaseOrderDetailsIdBy(InventoryPurchaseOrder inventoryPurchaseOrder, InventoryItemMaster inventoryItemMaster) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryPurchaseOrderDetails.class);
        criteria.add((Criterion)Restrictions.eq((String)"inventoryPurchaseOrder", (Object)inventoryPurchaseOrder));
        criteria.add((Criterion)Restrictions.eq((String)"inventoryItemMaster", (Object)inventoryItemMaster));
        InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail = (InventoryPurchaseOrderDetails)criteria.uniqueResult();
        return inventoryPurchaseOrderDetail;
    }
}
