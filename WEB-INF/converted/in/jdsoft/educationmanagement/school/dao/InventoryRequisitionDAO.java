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
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRequisitionDAO
extends GenericDAO<InventoryRequisition> {
    public InventoryRequisitionDAO() {
        super(InventoryRequisition.class);
    }

    public InventoryRequisition getInventoryRequisitionById(Long id) {
        InventoryRequisition instance = (InventoryRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryRequisition", (Serializable)id);
        return instance;
    }

    public List<InventoryRequisition> getInventoryRequisitionListByRequesterUser(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"inventoryRequistionBy", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List inventoryRequisitionList = criteria.list();
        return inventoryRequisitionList;
    }

    public List<InventoryRequisition> getInventoryRequisitionListByApproverUser(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"inventoryRequisitionApproverBy", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List inventoryRequisitionList = criteria.list();
        return inventoryRequisitionList;
    }

    public List<InventoryRequisition> getInventoryRequisitionListByStatus(String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List inventoryRequisitionList = criteria.list();
        return inventoryRequisitionList;
    }
}
