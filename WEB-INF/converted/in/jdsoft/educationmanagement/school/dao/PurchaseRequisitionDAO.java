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
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseRequisitionDAO
extends GenericDAO<PurchaseRequisition> {
    public PurchaseRequisitionDAO() {
        super(PurchaseRequisition.class);
    }

    public PurchaseRequisition getPurchaseRequisitionById(Long id) {
        PurchaseRequisition instance = (PurchaseRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PurchaseRequisition", (Serializable)id);
        return instance;
    }

    public List<PurchaseRequisition> getPurchaseRequisitionListByRequesterUser(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PurchaseRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"purchaseRequistionBy", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List purchaseRequisitionList = criteria.list();
        return purchaseRequisitionList;
    }

    public List<PurchaseRequisition> getPurchaseRequisitionListByApproverUser(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PurchaseRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"purchaseApproverBy", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List purchaseRequisitionList = criteria.list();
        return purchaseRequisitionList;
    }
}
