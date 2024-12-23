/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorDaysDAO;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorDaysService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="timeTableGeneratorDaysService")
public class TimeTableGeneratorDaysServiceImpl
implements TimeTableGeneratorDaysService {
    @Autowired
    TimeTableGeneratorDaysDAO timeTableGeneratorDayDAO;
    @Autowired
    TimeTableGeneratorDAO timeTableGeneratorDAO;

    @Override
    public List<TimeTableGeneratorDays> timeTableGeneratorDayList() {
        try {
            List<TimeTableGeneratorDays> timeTableGeneratorDayList = this.timeTableGeneratorDayDAO.getList();
            Integer timeTableGeneratorDaySize = timeTableGeneratorDayList.size();
            if (timeTableGeneratorDaySize > 0) {
                log.info((Object)(timeTableGeneratorDaySize + " TimeTableGeneratorDays records where reterived"));
            } else {
                log.info((Object)"No TimeTableGeneratorDay(s) available");
            }
            return timeTableGeneratorDayList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TimeTableGeneratorDays list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGeneratorDays timeTableGeneratorDayById(Long timeTableGeneratorDayId) {
        try {
            TimeTableGeneratorDays timeTableGeneratorDay = this.timeTableGeneratorDayDAO.getTimeTableGeneratorDaysById(timeTableGeneratorDayId);
            if (timeTableGeneratorDay != null) {
                log.info((Object)("TimeTableGeneratorDay with id=" + timeTableGeneratorDayId + " has been reterived"));
                return timeTableGeneratorDay;
            }
            log.info((Object)("No TimeTableGeneratorDay with  id=" + timeTableGeneratorDayId + " is available"));
            return timeTableGeneratorDay;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorDay by id=" + timeTableGeneratorDayId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGeneratorDays timeTableGeneratorDayByTimeTableGeneratorAndTimeTableGeneratorDayId(Long timeTableGeneratorDayId, Long timeTableGeneratorId) {
        try {
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorDAO.getTimeTableGeneratorById(timeTableGeneratorId);
            TimeTableGeneratorDays timeTableGeneratorDay = this.timeTableGeneratorDayDAO.getTimeTableGeneratorDaysByTimeTableGeneratorAndTimeTableGeneratorDayId(timeTableGeneratorDayId, timeTableGenerator);
            if (timeTableGeneratorDay != null) {
                log.info((Object)("TimeTableGeneratorDay with id=" + timeTableGeneratorDayId + " has been reterived"));
                return timeTableGeneratorDay;
            }
            log.info((Object)("No TimeTableGeneratorDay with  id=" + timeTableGeneratorDayId + " is available"));
            return timeTableGeneratorDay;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorDay by id=" + timeTableGeneratorDayId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<TimeTableGeneratorDays> timeTableGeneratorDayByName(String timeTableGeneratorDayName) {
        try {
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableGeneratorDays = new LinkedHashSet<TimeTableGeneratorDays>();
            List<TimeTableGeneratorDays> timeTableGeneratorDays = this.timeTableGeneratorDayDAO.getTimeTableGeneratorDaysByName(timeTableGeneratorDayName);
            for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGeneratorDays) {
                addTimeTableGeneratorDays.add(timeTableGeneratorDay);
            }
            log.info((Object)("TimeTableGeneratorDay with name=" + timeTableGeneratorDayName + " has been reterived"));
            return addTimeTableGeneratorDays;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TimeTableGeneratorDay by name=" + timeTableGeneratorDayName), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
