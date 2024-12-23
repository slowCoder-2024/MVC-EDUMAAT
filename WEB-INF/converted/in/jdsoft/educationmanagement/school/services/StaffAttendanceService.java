/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffAttendanceException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StaffAttendancePunch;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.reports.model.PunchDetails;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface StaffAttendanceService {
    public static final Logger log = LogManager.getLogger((String)StaffAttendanceService.class.getName());

    public void addPunch(String var1) throws ParseException, StaffAttendanceException;

    public List<PunchDetails> staffsPunchDetails(Date var1);

    public Set<StaffAttendancePunch> staffAttendancePunchDetails(Long var1);

    public String staffAttendancePercentageByCurrentDate(Institution var1, StaffType var2);

    public TwoFieldReport chartStaffAttendancePercentageByCurrentDate(Institution var1, StaffType var2);

    public Integer staffAttendanceBulkUpload(MultipartFile var1, Long var2) throws StaffAttendanceException, ParseException;
}
