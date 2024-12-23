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
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationFeedBackAndOthersHistoryDAO
extends GenericDAO<CommunicationFeedBackAndOthersHistory> {
    public CommunicationFeedBackAndOthersHistoryDAO() {
        super(CommunicationFeedBackAndOthersHistory.class);
    }

    public CommunicationFeedBackAndOthersHistory getCommunicationFeedBackAndOthersHistoryById(Long id) {
        CommunicationFeedBackAndOthersHistory instance = (CommunicationFeedBackAndOthersHistory)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory", (Serializable)id);
        return instance;
    }

    public List<CommunicationFeedBackAndOthersHistory> getCommunicationFeedBackAndOthersHistoryByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthersHistory.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUser", (Object)user));
        List communicationFeedBackAndOthersHistory = criteria.list();
        return communicationFeedBackAndOthersHistory;
    }

    public List<CommunicationFeedBackAndOthersHistory> getCommunicationFeedBackAndOthersHistoryByEmail(String email) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthersHistory.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        List communicationFeedBackAndOthersHistory = criteria.list();
        return communicationFeedBackAndOthersHistory;
    }
}
