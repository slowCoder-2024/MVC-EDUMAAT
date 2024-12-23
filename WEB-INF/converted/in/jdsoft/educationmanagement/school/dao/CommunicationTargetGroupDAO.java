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
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationTargetGroupDAO
extends GenericDAO<CommunicationTargetGroup> {
    public CommunicationTargetGroupDAO() {
        super(CommunicationTargetGroup.class);
    }

    public CommunicationTargetGroup getCommunicationTargetGroupById(Long id) {
        CommunicationTargetGroup instance = (CommunicationTargetGroup)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup", (Serializable)id);
        return instance;
    }

    public CommunicationTargetGroup getCommunicationTargetGroupByName(String communicationTargetGroupTitle) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationTargetGroup.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"communicationTagetGroupTitle", (Object)communicationTargetGroupTitle)));
        CommunicationTargetGroup communicationTargetGroup = (CommunicationTargetGroup)criteria.uniqueResult();
        return communicationTargetGroup;
    }
}
