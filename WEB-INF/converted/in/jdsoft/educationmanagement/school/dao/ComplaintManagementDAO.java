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
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ComplaintManagementDAO
extends GenericDAO<ComplaintManagement> {
    public ComplaintManagementDAO() {
        super(ComplaintManagement.class);
    }

    public ComplaintManagement getComplaintManagementById(Long id) {
        ComplaintManagement instance = (ComplaintManagement)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ComplaintManagement", (Serializable)id);
        return instance;
    }

    public List<ComplaintManagement> getComplaintManagementListAndApproveUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ComplaintManagement.class);
        criteria.add((Criterion)Restrictions.eq((String)"complaintReceiver", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"complaintStatus", (Object)status));
        List ComplaintManagements = criteria.list();
        return ComplaintManagements;
    }

    public List<ComplaintManagement> getComplaintManagementListAndRequestUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ComplaintManagement.class);
        criteria.add((Criterion)Restrictions.eq((String)"complaintSender", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"complaintStatus", (Object)status));
        List ComplaintManagements = criteria.list();
        return ComplaintManagements;
    }

    public List<ComplaintManagement> getComplaintManagementListByStatus(String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ComplaintManagement.class);
        criteria.add((Criterion)Restrictions.eq((String)"complaintStatus", (Object)status));
        List ComplaintManagements = criteria.list();
        return ComplaintManagements;
    }

    public List<ComplaintManagement> getComplaintManagementListAndApproveUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ComplaintManagement.class);
        criteria.add((Criterion)Restrictions.eq((String)"complaintReceiver", (Object)user));
        List ComplaintManagements = criteria.list();
        return ComplaintManagements;
    }

    public List<ComplaintManagement> getComplaintManagementListAndRequestUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ComplaintManagement.class);
        criteria.add((Criterion)Restrictions.eq((String)"complaintSender", (Object)user));
        List ComplaintManagements = criteria.list();
        return ComplaintManagements;
    }
}
