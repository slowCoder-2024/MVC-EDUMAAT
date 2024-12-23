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
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PortalReplyMessageDAO
extends GenericDAO<PortalReplyMessage> {
    public PortalReplyMessageDAO() {
        super(PortalReplyMessage.class);
    }

    public PortalReplyMessage getPortalReplyMessageById(Long id) {
        PortalReplyMessage instance = (PortalReplyMessage)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PortalReplyMessage", (Serializable)id);
        return instance;
    }

    public List<PortalReplyMessage> getPortalReplyMessagesByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalReplyMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List portalReplyMessages = criteria.list();
        return portalReplyMessages;
    }

    public List<PortalReplyMessage> getPortalReplyMessagesByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalReplyMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"portalMessageStatus", (Object)status));
        List portalReplyMessages = criteria.list();
        return portalReplyMessages;
    }

    public List<PortalReplyMessage> getPortalReplyMessagesByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalReplyMessage.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List portalReplyMessages = criteria.list();
        return portalReplyMessages;
    }
}
