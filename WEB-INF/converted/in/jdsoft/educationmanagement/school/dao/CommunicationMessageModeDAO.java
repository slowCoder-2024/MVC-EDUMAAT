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
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class CommunicationMessageModeDAO
extends GenericDAO<CommunicationMessageMode> {
    public CommunicationMessageModeDAO() {
        super(CommunicationMessageMode.class);
    }

    public CommunicationMessageMode getCommunicationMessageModeById(Long id) {
        CommunicationMessageMode instance = (CommunicationMessageMode)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.CommunicationMessageMode", (Serializable)id);
        return instance;
    }

    public CommunicationMessageMode getCommunicationMessageModeByName(String communicationMessageModeTitle) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(CommunicationMessageMode.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"communicationMessageModeTitle", (Object)communicationMessageModeTitle)));
        CommunicationMessageMode communicationMessageMode = (CommunicationMessageMode)criteria.uniqueResult();
        return communicationMessageMode;
    }
}
