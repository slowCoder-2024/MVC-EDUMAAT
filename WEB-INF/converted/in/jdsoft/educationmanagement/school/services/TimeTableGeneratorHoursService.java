/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableGeneratorHoursService {
    public static final Logger log = LogManager.getLogger((String)TimeTableGeneratorHoursService.class.getName());

    public List<TimeTableGeneratorHours> timeTableGeneratorHourList();

    public TimeTableGeneratorHours timeTableGeneratorHourById(Long var1);

    public Set<TimeTableGeneratorHours> timeTableGeneratorHourByTitleAndTimeTableGeneratorDay(String var1, Set<TimeTableGeneratorDays> var2);

    public TimeTableGeneratorHours timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long var1, Long var2);

    public TimeTableGeneratorHours substituteTimeTableGeneratorHourChecking(String var1, String var2, TimeTableGeneratorDays var3) throws TimeTableTemplateException;
}
