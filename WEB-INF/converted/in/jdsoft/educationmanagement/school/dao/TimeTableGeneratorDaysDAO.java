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
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableGeneratorDaysDAO
extends GenericDAO<TimeTableGeneratorDays> {
    public TimeTableGeneratorDaysDAO() {
        super(TimeTableGeneratorDays.class);
    }

    public TimeTableGeneratorDays getTimeTableGeneratorDaysById(Long id) {
        TimeTableGeneratorDays instance = (TimeTableGeneratorDays)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays", (Serializable)id);
        return instance;
    }

    public TimeTableGeneratorDays getTimeTableGeneratorDaysByTimeTableGeneratorAndTimeTableGeneratorDayId(Long timeTableGeneratorDayId, TimeTableGenerator timeTableGenerator) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGeneratorDays.class);
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGeneratorDayId", (Object)timeTableGeneratorDayId));
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGenerator", (Object)timeTableGenerator));
        TimeTableGeneratorDays timeTableGeneratorDay = (TimeTableGeneratorDays)criteria.uniqueResult();
        return timeTableGeneratorDay;
    }

    public List<TimeTableGeneratorDays> getTimeTableGeneratorDaysByName(String dayName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGeneratorDays.class);
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGeneratorDayName", (Object)dayName));
        List timeTableGeneratorDay = criteria.list();
        return timeTableGeneratorDay;
    }
}
