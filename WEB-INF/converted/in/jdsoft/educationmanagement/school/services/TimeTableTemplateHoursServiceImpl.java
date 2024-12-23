/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateHoursDAO;
import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateHoursService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="timeTableTemplateHoursService")
public class TimeTableTemplateHoursServiceImpl
implements TimeTableTemplateHoursService {
    @Autowired
    TimeTableTemplateHoursDAO timeTableTemplateHoursDAO;
    @Autowired
    TimeTableTemplateDAO timeTableTemplateDAO;

    @Override
    public List<TimeTableTemplateHours> timeTableTemplateHoursList() {
        try {
            List<TimeTableTemplateHours> TimeTableTemplateHoursList = this.timeTableTemplateHoursDAO.getList();
            Integer TimeTableTemplateHoursSize = TimeTableTemplateHoursList.size();
            if (TimeTableTemplateHoursSize > 0) {
                log.info((Object)(TimeTableTemplateHoursSize + " TimeTableTemplateHours records where reterived"));
            } else {
                log.info((Object)"No TimeTableTemplateHours(s) available");
            }
            return TimeTableTemplateHoursList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TimeTableTemplateHours list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableTemplateHours timeTableTemplateHoursById(Long timeTableTemplateHoursId) {
        try {
            TimeTableTemplateHours timeTableTemplateHours = this.timeTableTemplateHoursDAO.getTimeTableTemplateHoursById(timeTableTemplateHoursId);
            if (timeTableTemplateHours != null) {
                log.info((Object)("TimeTableTemplateHours with id=" + timeTableTemplateHoursId + " has been reterived"));
                return timeTableTemplateHours;
            }
            log.info((Object)("No TimeTableTemplateHours with  id=" + timeTableTemplateHoursId + " is available"));
            return timeTableTemplateHours;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableTemplateHours by id=" + timeTableTemplateHoursId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTimeTableTemplateHours(Long timeTableTemplateHoursId) throws TimeTableTemplateException {
        try {
            this.timeTableTemplateHoursDAO.delete(this.timeTableTemplateHoursDAO.getTimeTableTemplateHoursById(timeTableTemplateHoursId));
            log.info((Object)"TimeTableTemplateHours is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TimeTableTemplateHours", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteAllTimeTableTemplateHours(Set<TimeTableTemplateHours> timeTableTemplateHours) throws TimeTableTemplateException {
        try {
            for (TimeTableTemplateHours timeTableTemplateHours2 : timeTableTemplateHours) {
                this.timeTableTemplateHoursDAO.delete(timeTableTemplateHours2);
            }
            log.info((Object)"TimeTableTemplateHours is deleted");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Deleting TimeTableTemplateHours", e.getCause());
            throw e;
        }
    }
}
