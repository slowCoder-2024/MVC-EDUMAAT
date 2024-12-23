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
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationNotificationDAO
extends GenericDAO<CommunicationNotification> {
    public CommunicationNotificationDAO() {
        super(CommunicationNotification.class);
    }

    public CommunicationNotification getCommunicationNotificationById(Long id) {
        CommunicationNotification instance = (CommunicationNotification)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationNotification", (Serializable)id);
        return instance;
    }

    public List<CommunicationNotification> getCommunicationNotificationsByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List communicationNotifications = criteria.list();
        return communicationNotifications;
    }

    public List<CommunicationNotification> getCommunicationNotificationsByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List communicationNotifications = criteria.list();
        return communicationNotifications;
    }

    public List<CommunicationNotification> getCommunicationNotificationsByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        List communicationNotifications = criteria.list();
        return communicationNotifications;
    }
}
