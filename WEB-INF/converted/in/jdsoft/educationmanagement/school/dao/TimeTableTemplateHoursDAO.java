/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableTemplateHoursDAO
extends GenericDAO<TimeTableTemplateHours> {
    public TimeTableTemplateHoursDAO() {
        super(TimeTableTemplateHours.class);
    }

    public TimeTableTemplateHours getTimeTableTemplateHoursById(Long id) {
        TimeTableTemplateHours instance = (TimeTableTemplateHours)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours", (Serializable)id);
        return instance;
    }
}
