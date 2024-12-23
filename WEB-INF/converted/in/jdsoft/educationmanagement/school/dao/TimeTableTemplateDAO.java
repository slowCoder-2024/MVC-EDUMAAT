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
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableTemplateDAO
extends GenericDAO<TimeTableTemplate> {
    public TimeTableTemplateDAO() {
        super(TimeTableTemplate.class);
    }

    public TimeTableTemplate getTimeTableTemplateById(Long id) {
        TimeTableTemplate instance = (TimeTableTemplate)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableTemplate", (Serializable)id);
        return instance;
    }

    public List<TimeTableTemplate> getTimeTableTemplatesByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableTemplate.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List timeTableTemplates = criteria.list();
        return timeTableTemplates;
    }
}
