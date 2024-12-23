/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorDaysDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorHoursDAO;
import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorHoursService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="timeTableGeneratorHoursService")
public class TimeTableGeneratorHoursServiceImpl
implements TimeTableGeneratorHoursService {
    @Autowired
    TimeTableGeneratorHoursDAO timeTableGeneratorHourDAO;
    @Autowired
    TimeTableGeneratorDaysDAO timeTableGeneratorDayDAO;

    @Override
    public List<TimeTableGeneratorHours> timeTableGeneratorHourList() {
        try {
            List<TimeTableGeneratorHours> timeTableGeneratorHourList = this.timeTableGeneratorHourDAO.getList();
            Integer timeTableGeneratorHourSize = timeTableGeneratorHourList.size();
            if (timeTableGeneratorHourSize > 0) {
                log.info((Object)(timeTableGeneratorHourSize + " TimeTableGeneratorHours records where reterived"));
            } else {
                log.info((Object)"No TimeTableGeneratorHour(s) available");
            }
            return timeTableGeneratorHourList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TimeTableGeneratorHours list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGeneratorHours timeTableGeneratorHourById(Long timeTableGeneratorHourId) {
        try {
            TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourDAO.getTimeTableGeneratorHoursById(timeTableGeneratorHourId);
            if (timeTableGeneratorHour != null) {
                log.info((Object)("TimeTableGeneratorHour with id=" + timeTableGeneratorHourId + " has been reterived"));
                return timeTableGeneratorHour;
            }
            log.info((Object)("No TimeTableGeneratorHour with  id=" + timeTableGeneratorHourId + " is available"));
            return timeTableGeneratorHour;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorHour by id=" + timeTableGeneratorHourId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGeneratorHours timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long timeTableGeneratorHourId, Long timeTableGeneratorDayId) {
        try {
            TimeTableGeneratorDays timeTableGeneratorDay = this.timeTableGeneratorDayDAO.getTimeTableGeneratorDaysById(timeTableGeneratorDayId);
            TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourDAO.getTimeTableGeneratorDaysByTimeTableGeneratorDayAndTimeTableGeneratorDayId(timeTableGeneratorHourId, timeTableGeneratorDay);
            if (timeTableGeneratorHour != null) {
                log.info((Object)("TimeTableGeneratorHour with id=" + timeTableGeneratorHourId + " has been reterived"));
                return timeTableGeneratorHour;
            }
            log.info((Object)("No TimeTableGeneratorHour with  id=" + timeTableGeneratorHourId + " is available"));
            return timeTableGeneratorHour;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorHour by id=" + timeTableGeneratorHourId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<TimeTableGeneratorHours> timeTableGeneratorHourByTitleAndTimeTableGeneratorDay(String timeTableGeneratorHourTitle, Set<TimeTableGeneratorDays> timeTableGeneratorDays) {
        try {
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableGeneratorHour = new LinkedHashSet<TimeTableGeneratorHours>();
            for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGeneratorDays) {
                addTimeTableGeneratorHour.add(this.timeTableGeneratorHourDAO.getTimeTableGeneratorHoursByTitleAndTimeTableGeneratorDay(timeTableGeneratorHourTitle, timeTableGeneratorDay));
            }
            log.info((Object)("TimeTableGeneratorHour with title=" + timeTableGeneratorHourTitle + " has been reterived"));
            return addTimeTableGeneratorHour;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorHour by title=" + timeTableGeneratorHourTitle), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGeneratorHours substituteTimeTableGeneratorHourChecking(String hourTitle, String subjectTitle, TimeTableGeneratorDays timeTableGeneratorDay) throws TimeTableTemplateException {
        try {
            TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourDAO.getTimeTableGeneratorHoursByTitleAndSubjectTitleAndTimeTableGeneratorDay(hourTitle, subjectTitle, timeTableGeneratorDay);
            return timeTableGeneratorHour;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
