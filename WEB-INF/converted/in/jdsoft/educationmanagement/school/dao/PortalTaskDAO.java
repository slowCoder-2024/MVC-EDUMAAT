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
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class PortalTaskDAO
extends GenericDAO<PortalTask> {
    public PortalTaskDAO() {
        super(PortalTask.class);
    }

    public PortalTask getPortalTaskById(Long id) {
        PortalTask instance = (PortalTask)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PortalTask", (Serializable)id);
        return instance;
    }

    public List<PortalTask> getPortalTasksByUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalTask.class);
        criteria.add((Criterion)Restrictions.eq((String)"targetUsers", (Object)user));
        List portalTasks = criteria.list();
        return portalTasks;
    }

    public List<PortalTask> getPortalTasksByEmailAndStatus(String email, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalTask.class);
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"portalTaskStatus", (Object)status));
        List portalTasks = criteria.list();
        return portalTasks;
    }

    public List<PortalTask> getPortalTasksByInstituion(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(PortalTask.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List portalTasks = criteria.list();
        return portalTasks;
    }
}
