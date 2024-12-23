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
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeTableTemplateService {
    public static final Logger log = LogManager.getLogger((String)TimeTableTemplateService.class.getName());

    public void createTimeTableTemplate(TimeTableTemplate var1, Set<TimeTableTemplateDays> var2, Set<TimeTableTemplateHours> var3) throws TimeTableTemplateException;

    public void updateTimeTableTemplate(TimeTableTemplate var1) throws TimeTableTemplateException;

    public void deleteTimeTableTemplate(Long var1) throws TimeTableTemplateException;

    public TimeTableTemplate timeTableTemplateById(Long var1);

    public TimeTableTemplate timeTableTemplateIdByEager(Long var1);

    public List<TimeTableTemplate> timeTableTemplateList(Long var1) throws TimeTableTemplateException;

    public List<TimeTableTemplate> timeTableTemplateListEager(Long var1) throws TimeTableTemplateException;

    public List<TimeTableTemplate> timeTableTemplateList();
}
