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
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationFeedBackAndOthersArchiveDAO
extends GenericDAO<CommunicationFeedBackAndOthersArchive> {
    public CommunicationFeedBackAndOthersArchiveDAO() {
        super(CommunicationFeedBackAndOthersArchive.class);
    }

    public CommunicationFeedBackAndOthersArchive getCommunicationFeedBackAndOthersArchiveById(Long id) {
        CommunicationFeedBackAndOthersArchive instance = (CommunicationFeedBackAndOthersArchive)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive", (Serializable)id);
        return instance;
    }

    public List<CommunicationFeedBackAndOthersArchive> getCommunicationFeedBackAndOthersArchivesByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthersArchive.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List communicationFeedBackAndOthersArchive = criteria.list();
        return communicationFeedBackAndOthersArchive;
    }

    public List<CommunicationFeedBackAndOthersArchive> getCommunicationFeedBackAndOthersArchivesByEmail(String email) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthersArchive.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        List communicationNotificationArchives = criteria.list();
        return communicationNotificationArchives;
    }
}
