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
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationNotificationArchiveDAO
extends GenericDAO<CommunicationNotificationArchive> {
    public CommunicationNotificationArchiveDAO() {
        super(CommunicationNotificationArchive.class);
    }

    public CommunicationNotificationArchive getCommunicationNotificationArchiveById(Long id) {
        CommunicationNotificationArchive instance = (CommunicationNotificationArchive)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive", (Serializable)id);
        return instance;
    }

    public List<CommunicationNotificationArchive> getCommunicationNotificationArchivesByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationNotificationArchive.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List communicationNotificationArchives = criteria.list();
        return communicationNotificationArchives;
    }

    public List<CommunicationNotificationArchive> getCommunicationNotificationArchivesByEmail(String email) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationNotificationArchive.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        List communicationNotificationArchives = criteria.list();
        return communicationNotificationArchives;
    }
}
