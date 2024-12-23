/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableGeneratorDaysService {
    public static final Logger log = LogManager.getLogger((String)TimeTableGeneratorDaysService.class.getName());

    public List<TimeTableGeneratorDays> timeTableGeneratorDayList();

    public TimeTableGeneratorDays timeTableGeneratorDayById(Long var1);

    public Set<TimeTableGeneratorDays> timeTableGeneratorDayByName(String var1);

    public TimeTableGeneratorDays timeTableGeneratorDayByTimeTableGeneratorAndTimeTableGeneratorDayId(Long var1, Long var2);
}
