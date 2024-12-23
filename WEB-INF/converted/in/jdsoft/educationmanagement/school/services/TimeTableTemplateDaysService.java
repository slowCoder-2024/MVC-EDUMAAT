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
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableTemplateDaysService {
    public static final Logger log = LogManager.getLogger((String)TimeTableTemplateDaysService.class.getName());

    public List<TimeTableTemplateDays> timeTableTemplateDaysList();

    public TimeTableTemplateDays timeTableTemplateDaysById(Long var1);

    public void deleteTimeTableTemplateDays(Long var1) throws TimeTableTemplateException;

    public void deleteAllTimeTableTemplateDays(Set<TimeTableTemplateDays> var1) throws TimeTableTemplateException;
}
