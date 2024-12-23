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
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableTemplateHoursService {
    public static final Logger log = LogManager.getLogger((String)TimeTableTemplateHoursService.class.getName());

    public List<TimeTableTemplateHours> timeTableTemplateHoursList();

    public TimeTableTemplateHours timeTableTemplateHoursById(Long var1);

    public void deleteTimeTableTemplateHours(Long var1) throws TimeTableTemplateException;

    public void deleteAllTimeTableTemplateHours(Set<TimeTableTemplateHours> var1) throws TimeTableTemplateException;
}
