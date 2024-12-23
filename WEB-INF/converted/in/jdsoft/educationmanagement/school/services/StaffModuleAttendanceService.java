/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffModuleAttendanceService {
    public static final Logger log = LogManager.getLogger(StaffModuleAttendanceService.class);

    public void addStaffModuleAttendance(List<StaffModuleAttendance> var1) throws StaffException, ParseException, Exception;

    public List<StaffModuleAttendance> staffModuleAttendanceByStudentEmailAndAttendanceStartDateAndAttendanceEndDateEager(String var1, Institution var2, Date var3, Date var4) throws StaffException;

    public List<StaffModuleAttendance> staffModuleAttendanceByStudentEmailAndAttendanceMonthEager(String var1, Institution var2, Date var3) throws StaffException;

    public List<StaffModuleAttendance> staffModuleAttendanceByClassAndSectionAndAttendanceStartDateAndAttendanceEndDateEager(Class var1, Section var2, Date var3, Date var4) throws StaffException;

    public List<StaffModuleAttendance> staffModuleAttendanceByClassAndSectionAndAttendanceMonthEager(Class var1, Section var2, Date var3) throws StaffException;

    public void deleteStaffModuleAttendance(Long var1);

    public void deleteAllStaffModuleAttendance(Long[] var1);

    public StaffModuleAttendance staffModuleAttendanceById(Long var1) throws StaffException;

    public void updateStaffModuleAttendance(StaffModuleAttendance var1);

    public List<SevenFieldReports> studentListByAcademicYearAndClassAndSection(Class var1, Section var2, AcademicYear var3, ClassSectionModule var4) throws StaffException;

    public List<SevenFieldReports> staffModuleAttendanceByAcademicYearAndStudentEmail(AcademicYear var1, String var2) throws StaffException;
}
