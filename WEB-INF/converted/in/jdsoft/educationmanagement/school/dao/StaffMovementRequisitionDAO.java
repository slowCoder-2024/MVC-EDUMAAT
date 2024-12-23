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
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffMovementRequisitionDAO
extends GenericDAO<StaffMovementRequisition> {
    public StaffMovementRequisitionDAO() {
        super(StaffMovementRequisition.class);
    }

    public StaffMovementRequisition getStaffMovementRequisitionById(Long id) {
        StaffMovementRequisition instance = (StaffMovementRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffMovementRequisition", (Serializable)id);
        return instance;
    }

    public List<StaffMovementRequisition> getStaffMovementRequisitionList(Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        List StaffMomentRequisitions = criteria.list();
        return StaffMomentRequisitions;
    }

    public List<StaffMovementRequisition> getStaffMovementRequisitionListAndStatus(Staff staff, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List StaffMomentRequisitions = criteria.list();
        return StaffMomentRequisitions;
    }

    public List<StaffMovementRequisition> getStaffMovementRequisitionListAndUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"staffMovementApprover", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List StaffMomentRequisitions = criteria.list();
        return StaffMomentRequisitions;
    }

    public List<StaffMovementRequisition> getStaffMovementRequisitionListAndUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"staffMovementApprover", (Object)user));
        List StaffMomentRequisitions = criteria.list();
        return StaffMomentRequisitions;
    }
}
