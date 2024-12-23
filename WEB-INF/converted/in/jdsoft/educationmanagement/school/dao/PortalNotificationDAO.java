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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PortalNotificationDAO
extends GenericDAO<PortalNotification> {
    public PortalNotificationDAO() {
        super(PortalNotification.class);
    }

    public PortalNotification getPortalNotificationById(Long id) {
        PortalNotification instance = (PortalNotification)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PortalNotification", (Serializable)id);
        return instance;
    }

    public List<PortalNotification> getPortalNotificationsByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List portalNotifications = criteria.list();
        return portalNotifications;
    }

    public List<PortalNotification> getPortalNotificationsByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"notificationStatus", (Object)status));
        List portalNotifications = criteria.list();
        return portalNotifications;
    }

    public List<PortalNotification> getPortalNotificationsByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalNotification.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List portalNotifications = criteria.list();
        return portalNotifications;
    }
}
