/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDaysDAO;
import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateDaysService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="timeTableTemplateDaysService")
public class TimeTableTemplateDaysServiceImpl
implements TimeTableTemplateDaysService {
    @Autowired
    TimeTableTemplateDaysDAO timeTableTemplateDaysDAO;
    @Autowired
    TimeTableTemplateDAO timeTableTemplateDAO;

    @Override
    public List<TimeTableTemplateDays> timeTableTemplateDaysList() {
        try {
            List<TimeTableTemplateDays> TimeTableTemplateDaysList = this.timeTableTemplateDaysDAO.getList();
            Integer TimeTableTemplateDaysSize = TimeTableTemplateDaysList.size();
            if (TimeTableTemplateDaysSize > 0) {
                log.info((Object)(TimeTableTemplateDaysSize + " TimeTableTemplateDays records where reterived"));
            } else {
                log.info((Object)"No TimeTableTemplateDays(s) available");
            }
            return TimeTableTemplateDaysList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TimeTableTemplateDays list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableTemplateDays timeTableTemplateDaysById(Long timeTableTemplateDaysId) {
        try {
            TimeTableTemplateDays timeTableTemplateDays = this.timeTableTemplateDaysDAO.getTimeTableTemplateDaysById(timeTableTemplateDaysId);
            if (timeTableTemplateDays != null) {
                log.info((Object)("TimeTableTemplateDays with id=" + timeTableTemplateDaysId + " has been reterived"));
                return timeTableTemplateDays;
            }
            log.info((Object)("No TimeTableTemplateDays with  id=" + timeTableTemplateDaysId + " is available"));
            return timeTableTemplateDays;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableTemplateDays by id=" + timeTableTemplateDaysId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTimeTableTemplateDays(Long timeTableTemplateDaysId) throws TimeTableTemplateException {
        try {
            this.timeTableTemplateDaysDAO.delete(this.timeTableTemplateDaysDAO.getTimeTableTemplateDaysById(timeTableTemplateDaysId));
            log.info((Object)"TimeTableTemplateDays is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TimeTableTemplateDays", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteAllTimeTableTemplateDays(Set<TimeTableTemplateDays> timeTableTemplateDays) throws TimeTableTemplateException {
        try {
            for (TimeTableTemplateDays timeTableTemplateDays2 : timeTableTemplateDays) {
                this.timeTableTemplateDaysDAO.delete(timeTableTemplateDays2);
            }
            log.info((Object)"TimeTableTemplateDays is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TimeTableTemplateDays", e.getCause());
            throw e;
        }
    }
}
