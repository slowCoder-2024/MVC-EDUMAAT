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

import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.exceptions.StudentAttendanceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional(rollbackFor={StudentAttendanceException.class})
public interface StudentAttendanceService {
    public static final Logger log = LogManager.getLogger((String)StudentAttendanceService.class.getName());

    public void addStudentAttendance(List<StudentAttendance> var1) throws StudentAttendanceException, ParseException, Exception;

    public String studentAttendancePercentageByCurrentDate(Long var1);

    public ThreeFieldReports chartStudentAttendancePercentageByCurrentDate(Long var1);

    public List<StudentAttendance> studentAttendanceByStudentEmailAndAttendanceMonthEager(String var1, Institution var2, Date var3) throws StaffException;

    public List<StudentAttendance> studentAttendanceByClassAndSectionAndAttendanceMonthEager(Class var1, Section var2, Date var3) throws StaffException;

    public List<FourFieldReport> todayAttendanceByClassWiseByInstitution(Long var1);

    public List<FourFieldReport> todayAttendanceByClassWise();

    public List<StudentAttendance> studentAttendanceByClassAndSectionAndDateAttendanceEager(Class var1, Section var2, Date var3) throws StudentAttendanceException;

    public void deleteAllStudentAttendance(Long[] var1);

    public StudentAttendance studentAttendanceByIdEager(Long var1) throws StudentAttendanceException;

    public void updateStudentAttendance(StudentAttendance var1) throws StudentAttendanceException;

    public List<StudentAttendance> studentAttendanceByAttendanceStartDateAndEndDateAndStudentEmail(String var1, Institution var2, Date var3, Date var4) throws StudentAttendanceException;

    public SevenFieldReports overAllStudentAttendanceByAcademicYearAndStudentEmail(AcademicYear var1, String var2) throws StudentAttendanceException;

    public List<NineFieldReports> studentAttendanceListByLongAbsentStudentListByDefaultMonth() throws StudentAttendanceException, ParseException;

    public List<NineFieldReports> studentAttendanceListByLongAbsentStudentListBySelectedMonthAndInstitution(Date var1, Long var2) throws StudentAttendanceException, ParseException;

    public Integer studentAttendanceBulkUpload(MultipartFile var1, Long var2) throws StudentAttendanceException, ParseException;
}
