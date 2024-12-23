/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableTemplateDaysDAO
extends GenericDAO<TimeTableTemplateDays> {
    public TimeTableTemplateDaysDAO() {
        super(TimeTableTemplateDays.class);
    }

    public TimeTableTemplateDays getTimeTableTemplateDaysById(Long id) {
        TimeTableTemplateDays instance = (TimeTableTemplateDays)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays", (Serializable)id);
        return instance;
    }
}
