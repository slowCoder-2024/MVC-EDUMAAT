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
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PortalMessageDAO
extends GenericDAO<PortalMessage> {
    public PortalMessageDAO() {
        super(PortalMessage.class);
    }

    public PortalMessage getPortalMessageById(Long id) {
        PortalMessage instance = (PortalMessage)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PortalMessage", (Serializable)id);
        return instance;
    }

    public List<PortalMessage> getPortalMessagesByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List portalMessages = criteria.list();
        return portalMessages;
    }

    public List<PortalMessage> getPortalMessagesByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"portalMessageStatus", (Object)status));
        List portalMessages = criteria.list();
        return portalMessages;
    }

    public List<PortalMessage> getPortalMessagesByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List portalMessages = criteria.list();
        return portalMessages;
    }
}
