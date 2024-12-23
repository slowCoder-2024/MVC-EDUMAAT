/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.TimeTableGeneratorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableGeneratorService {
    public static final Logger log = LogManager.getLogger((String)TimeTableGeneratorService.class.getName());

    public void createTimeTableGenerator(TimeTableGenerator var1, Set<TimeTableGeneratorDays> var2, Set<TimeTableGeneratorHours> var3) throws TimeTableGeneratorException;

    public void createAutomaticTimeTableGenerator(Set<TimeTableGenerator> var1, Set<TimeTableGeneratorDays> var2, Set<TimeTableGeneratorHours> var3) throws TimeTableGeneratorException;

    public void updateTimeTableGenerator(TimeTableGenerator var1, Set<TimeTableGeneratorDays> var2, Set<TimeTableGeneratorHours> var3) throws TimeTableGeneratorException;

    public void deleteTimeTableGenerator(Long var1) throws TimeTableGeneratorException;

    public TimeTableGenerator timeTableGeneratorById(Long var1);

    public TimeTableGenerator timeTableGeneratorIdByEager(Long var1);

    public List<TimeTableGenerator> timeTableGeneratorList();

    public List<TimeTableGenerator> timeTableGeneratorListEager() throws TimeTableGeneratorException;

    public TimeTableGenerator timeTableGeneratorEagerByClassSectionId(Long var1);

    public Set<TimeTableGenerator> timeTableGeneratorByTimeTableGeneratorDayAndTimeTableGeneratorHourEager(Set<TimeTableGeneratorDays> var1, Set<TimeTableGeneratorHours> var2);

    public List<TimeTableGenerator> timeTableGeneratorList(Long var1) throws TimeTableGeneratorException;

    public List<TimeTableGenerator> timeTableGeneratorListEager(Long var1) throws TimeTableGeneratorException;

    public List<TimeTableGenerator> timeTableGeneratorList(Long var1, AcademicYear var2) throws TimeTableGeneratorException;

    public List<TimeTableGenerator> timeTableGeneratorListEager(Long var1, AcademicYear var2) throws TimeTableGeneratorException;
}
