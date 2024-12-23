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
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationFeedBackAndOthersDAO
extends GenericDAO<CommunicationFeedBackAndOthers> {
    public CommunicationFeedBackAndOthersDAO() {
        super(CommunicationFeedBackAndOthers.class);
    }

    public CommunicationFeedBackAndOthers getCommunicationFeedBackAndOthersById(Long id) {
        CommunicationFeedBackAndOthers instance = (CommunicationFeedBackAndOthers)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers", (Serializable)id);
        return instance;
    }

    public List<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthersByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthers.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List communicationFeedBackAndOthers = criteria.list();
        return communicationFeedBackAndOthers;
    }

    public List<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthersByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthers.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List communicationFeedBackAndOthers = criteria.list();
        return communicationFeedBackAndOthers;
    }

    public List<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthersByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationFeedBackAndOthers.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        List communicationFeedBackAndOthers = criteria.list();
        return communicationFeedBackAndOthers;
    }
}
