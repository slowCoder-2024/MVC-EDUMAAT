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
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableGeneratorHoursDAO
extends GenericDAO<TimeTableGeneratorHours> {
    public TimeTableGeneratorHoursDAO() {
        super(TimeTableGeneratorHours.class);
    }

    public TimeTableGeneratorHours getTimeTableGeneratorHoursById(Long id) {
        TimeTableGeneratorHours instance = (TimeTableGeneratorHours)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours", (Serializable)id);
        return instance;
    }

    public TimeTableGeneratorHours getTimeTableGeneratorHoursByTitleAndTimeTableGeneratorDay(String timeTableGeneratorHourTitle, TimeTableGeneratorDays timeTableGeneratorDay) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGeneratorHours.class);
        criteria.add((Criterion)Restrictions.eq((String)"hourTitle", (Object)timeTableGeneratorHourTitle));
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGeneratorDays", (Object)timeTableGeneratorDay));
        TimeTableGeneratorHours timeTableGeneratorHour = (TimeTableGeneratorHours)criteria.uniqueResult();
        return timeTableGeneratorHour;
    }

    public TimeTableGeneratorHours getTimeTableGeneratorHoursByTitleAndSubjectTitleAndTimeTableGeneratorDay(String timeTableGeneratorHourTitle, String timeTableGeneratorSubjectTitle, TimeTableGeneratorDays timeTableGeneratorDay) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGeneratorHours.class);
        criteria.add((Criterion)Restrictions.eq((String)"hourTitle", (Object)timeTableGeneratorHourTitle));
        criteria.add((Criterion)Restrictions.eq((String)"subjectName", (Object)timeTableGeneratorSubjectTitle));
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGeneratorDays", (Object)timeTableGeneratorDay));
        TimeTableGeneratorHours timeTableGeneratorHour = (TimeTableGeneratorHours)criteria.uniqueResult();
        return timeTableGeneratorHour;
    }

    public TimeTableGeneratorHours getTimeTableGeneratorDaysByTimeTableGeneratorDayAndTimeTableGeneratorDayId(Long timeTableGeneratorHourId, TimeTableGeneratorDays timeTableGeneratorDay) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGeneratorHours.class);
        criteria.add((Criterion)Restrictions.eq((String)"timTableGeneratorHourId", (Object)timeTableGeneratorHourId));
        criteria.add((Criterion)Restrictions.eq((String)"timeTableGeneratorDays", (Object)timeTableGeneratorDay));
        TimeTableGeneratorHours timeTableGeneratorHour = (TimeTableGeneratorHours)criteria.uniqueResult();
        return timeTableGeneratorHour;
    }
}
