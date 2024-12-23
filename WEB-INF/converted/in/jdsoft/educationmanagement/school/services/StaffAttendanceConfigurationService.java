/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffAttendanceConfigurationException;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffAttendanceConfigurationService {
    public static final Logger log = LogManager.getLogger((String)StaffAttendanceConfigurationService.class.getName());

    public StaffAttendanceConfiguration staffAttendanceConfiguration(Long var1) throws StaffAttendanceConfigurationException;

    public void update(StaffAttendanceConfiguration var1);
}
