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
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryPurchaseOrderDAO
extends GenericDAO<InventoryPurchaseOrder> {
    public InventoryPurchaseOrderDAO() {
        super(InventoryPurchaseOrder.class);
    }

    public InventoryPurchaseOrder getInventoryPurchaseOrderById(Long id) {
        InventoryPurchaseOrder instance = (InventoryPurchaseOrder)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder", (Serializable)id);
        return instance;
    }

    public InventoryPurchaseOrder getInventoryPurchaseOrderByInventoryPurchaseOrder(Long purchaseOrderId) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryPurchaseOrder.class);
        criteria.add((Criterion)Restrictions.eq((String)"purchaseOrderId", (Object)purchaseOrderId));
        InventoryPurchaseOrder inventoryPurchaseOrders = (InventoryPurchaseOrder)criteria.uniqueResult();
        return inventoryPurchaseOrders;
    }
}
