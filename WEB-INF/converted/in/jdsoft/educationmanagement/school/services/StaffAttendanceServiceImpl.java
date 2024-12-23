/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.DataFormatter
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StaffAttendanceDAO;
import in.jdsoft.educationmanagement.school.dao.StaffAttendancePunchDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StaffTypeDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffAttendanceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import in.jdsoft.educationmanagement.school.model.StaffAttendancePunch;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.reports.model.PunchDetails;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.StaffAttendanceService;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StaffAttendanceServiceImpl
implements StaffAttendanceService {
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    StaffAttendanceDAO staffAttendanceDAO;
    @Autowired
    StaffAttendancePunchDAO staffAttendancePunchDAO;
    @Autowired
    StaffTypeDAO staffTypeDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;

    @Override
    public void addPunch(String staffCode) throws ParseException, StaffAttendanceException {
        block16: {
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
            Time time = null;
            Staff staff = this.staffDAO.getStaffByStaffCode(staffCode);
            if (staff != null) {
                Institution institution = staff.getInstitution();
                StaffAttendanceConfiguration staffAttendanceConfig = institution.getStaffAttendanceConfiguration();
                Set<AcademicYear> academicYears = institution.getAcademicYears();
                AcademicYear academicYear = null;
                for (AcademicYear academicYear2 : academicYears) {
                    if (academicYear2.getAcademicYearStatus() != 1) continue;
                    academicYear = academicYear2;
                    break;
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date date = new Date();
                String[] dateAndTime = dateFormat.format(date).split("-");
                StaffAttendance staffAttendancecheck = this.staffAttendanceDAO.getStaffAttendance(academicYear, formatter.parse(dateAndTime[0]), staff);
                time = new Time(timeFormat.parse(dateAndTime[1]).getTime());
                boolean checkStatus = true;
                if (staffAttendancecheck != null) {
                    Hibernate.initialize(staff.getStaffLeaveRequisitions());
                    Hibernate.initialize(staff.getStaffMovementRequisitions());
                    if (staff.getStaffLeaveRequisitions().isEmpty() && staff.getStaffMovementRequisitions().isEmpty()) {
                        StaffAttendancePunch punch = new StaffAttendancePunch(staffAttendancecheck, new Time(timeFormat.parse(dateAndTime[1]).getTime()));
                        this.staffAttendancePunchDAO.persist(punch);
                    } else {
                        for (StaffLeaveRequisition staffLeaveRequisition : staff.getStaffLeaveRequisitions()) {
                            if (dateformatter.parse(dateformatter.format(staffAttendancecheck.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(staffAttendancecheck.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveEndDate()) > 0 || !staffLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                            checkStatus = false;
                        }
                        for (StaffMovementRequisition staffMovementRequisition : staff.getStaffMovementRequisitions()) {
                            if (!staffMovementRequisition.getApprovalStatus().equals("Approved")) continue;
                            String timePoint = time.toString();
                            Time tfromval = Time.valueOf(staffMovementRequisition.getStartTime().toString());
                            Long timeFromVal = tfromval.getTime();
                            Time tpoint = Time.valueOf(timePoint);
                            Long timePointVal = tpoint.getTime();
                            Time ttoval = Time.valueOf(staffMovementRequisition.getEndTime().toString());
                            Long timeToVal = ttoval.getTime();
                            if (timePointVal < timeFromVal || timePointVal > timeToVal) continue;
                            checkStatus = false;
                        }
                        if (checkStatus) {
                            StaffAttendancePunch punch = new StaffAttendancePunch(staffAttendancecheck, new Time(timeFormat.parse(dateAndTime[1]).getTime()));
                            this.staffAttendancePunchDAO.persist(punch);
                        }
                    }
                } else {
                    StaffAttendance staffAttendance = new StaffAttendance(date, academicYear, staffAttendanceConfig.getStartingWorkTime(), staffAttendanceConfig.getClosingWorkTime(), staff, institution);
                    Hibernate.initialize(staff.getStaffLeaveRequisitions());
                    Hibernate.initialize(staff.getStaffMovementRequisitions());
                    if (staff.getStaffLeaveRequisitions().isEmpty() && staff.getStaffMovementRequisitions().isEmpty()) {
                        StaffAttendance persistedStaffAttendance = this.staffAttendanceDAO.save(staffAttendance);
                        StaffAttendancePunch punch = new StaffAttendancePunch(persistedStaffAttendance, new Time(timeFormat.parse(dateAndTime[1]).getTime()));
                        this.staffAttendancePunchDAO.persist(punch);
                    } else {
                        for (StaffLeaveRequisition staffLeaveRequisition : staff.getStaffLeaveRequisitions()) {
                            if (dateformatter.parse(dateformatter.format(staffAttendance.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(staffAttendance.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveEndDate()) > 0 || !staffLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                            checkStatus = false;
                        }
                        for (StaffMovementRequisition staffMovementRequisition : staff.getStaffMovementRequisitions()) {
                            if (!staffMovementRequisition.getApprovalStatus().equals("Approved")) continue;
                            String timePoint = time.toString();
                            Time tfromval = Time.valueOf(staffMovementRequisition.getStartTime().toString());
                            Long timeFromVal = tfromval.getTime();
                            Time tpoint = Time.valueOf(timePoint);
                            Long timePointVal = tpoint.getTime();
                            Time ttoval = Time.valueOf(staffMovementRequisition.getEndTime().toString());
                            Long timeToVal = ttoval.getTime();
                            if (timePointVal < timeFromVal || timePointVal > timeToVal) continue;
                            checkStatus = false;
                        }
                        if (checkStatus) {
                            StaffAttendance persistedStaffAttendance = this.staffAttendanceDAO.save(staffAttendance);
                            StaffAttendancePunch punch = new StaffAttendancePunch(persistedStaffAttendance, new Time(timeFormat.parse(dateAndTime[1]).getTime()));
                            this.staffAttendancePunchDAO.persist(punch);
                        }
                    }
                }
                break block16;
            }
            throw new StaffAttendanceException(new Message("invalidStaff", "Invalid Staff Code"));
        }
    }

    @Override
    public List<PunchDetails> staffsPunchDetails(Date date) {
        List<StaffAttendance> staffAttendances = this.staffAttendanceDAO.getStaffAttendance(date);
        ArrayList<PunchDetails> punchDetails = new ArrayList<PunchDetails>();
        for (StaffAttendance staffAttendance : staffAttendances) {
            LinkedHashSet<StaffAttendancePunch> staffAttendancePunches = new LinkedHashSet<StaffAttendancePunch>(staffAttendance.getStaffAttendancePunches());
            if (!staffAttendancePunches.iterator().hasNext()) continue;
            Time inTime = ((StaffAttendancePunch)staffAttendancePunches.iterator().next()).getPunchTime();
            punchDetails.add(new PunchDetails(staffAttendance.getStaff().getStaffCode(), String.valueOf(staffAttendance.getStaff().getFirstName()) + " " + staffAttendance.getStaff().getLastName(), date, inTime));
        }
        return punchDetails;
    }

    @Override
    public Set<StaffAttendancePunch> staffAttendancePunchDetails(Long staffAttendanceId) {
        StaffAttendance staffAttendance = this.staffAttendanceDAO.getStaffAttendanceById(staffAttendanceId);
        Set<StaffAttendancePunch> staffAttendacePunches = staffAttendance.getStaffAttendancePunches();
        return staffAttendacePunches;
    }

    @Override
    public String staffAttendancePercentageByCurrentDate(Institution institution, StaffType staffType) {
        String percentage = "0%";
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            List<StaffAttendance> staffAttendances = this.staffAttendanceDAO.staffAttendanceByDate(formatter.parse(formatter.format(new Date())), institution, staffType);
            Integer staffsPresent = staffAttendances.size();
            Integer totalStaffs = this.staffDAO.getStaffsByStatusAndType(1, staffType).size();
            Double totalPercentage = (double)staffsPresent.intValue() / (double)totalStaffs.intValue() * 100.0;
            if (!totalPercentage.isNaN()) {
                percentage = df.format(totalPercentage).concat("%");
            }
            return percentage;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff attendance percentage by current date", e.getCause());
            e.printStackTrace();
            return percentage;
        }
    }

    @Override
    public TwoFieldReport chartStaffAttendancePercentageByCurrentDate(Institution institution, StaffType staffType) {
        TwoFieldReport twoFieldReport = null;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            List<StaffAttendance> staffAttendances = this.staffAttendanceDAO.staffAttendanceByDate(formatter.parse(formatter.format(new Date())), institution, staffType);
            Integer staffsPresent = staffAttendances.size();
            Integer totalStaffs = this.staffDAO.getStaffsByStatusAndType(1, staffType).size();
            Integer staffsAbsent = totalStaffs - staffsPresent;
            twoFieldReport = new TwoFieldReport(staffsPresent, staffsAbsent);
            return twoFieldReport;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving absent staff attendance percentage by current date", e.getCause());
            e.printStackTrace();
            return twoFieldReport;
        }
    }

    @Override
    public Integer staffAttendanceBulkUpload(MultipartFile staffExcelFile, Long institutionId) throws StaffAttendanceException, ParseException {
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        int i = 1;
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm:ss a");
            DataFormatter formatter = new DataFormatter();
            HSSFWorkbook workbook = new HSSFWorkbook(staffExcelFile.getInputStream());
            HSSFSheet worksheet = workbook.getSheetAt(0);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            while (i <= worksheet.getLastRowNum()) {
                Date date;
                HSSFRow row = worksheet.getRow(i++);
                String staffCode = null;
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) {
                    throw new StaffAttendanceException(new Message("staffCodeNotFound", "Upload Failed : You have to mention Staff Code in row " + i));
                }
                staffCode = formatter.formatCellValue((Cell)row.getCell(0)).trim();
                Date attendanceDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(3)).isEmpty()) {
                    throw new StaffAttendanceException(new Message("invalidDateFormat", "Upload Failed : Invalid Attendance Date Format in row " + i + " correct format [eg:dd/MM/yyyy]"));
                }
                attendanceDate = date = new Date(formatter.formatCellValue((Cell)row.getCell(3)).trim());
                String inTime = null;
                if (formatter.formatCellValue((Cell)row.getCell(1)).isEmpty()) {
                    throw new StaffAttendanceException(new Message("invalidDateFormat", "Upload Failed : Invalid Attendance In Time format in row " + i + " correct format [eg:HH:mm]"));
                }
                inTime = formatter.formatCellValue((Cell)row.getCell(1)).trim();
                String outTime = null;
                if (formatter.formatCellValue((Cell)row.getCell(2)).isEmpty()) {
                    throw new StaffAttendanceException(new Message("invalidDateFormat", "Upload Failed : Invalid Attendance Out Time format in row " + i + " correct format [eg:HH:mm]"));
                }
                outTime = formatter.formatCellValue((Cell)row.getCell(2)).trim();
                Staff staff = this.staffDAO.getStaffByStaffCode(staffCode);
                boolean checkStatus = true;
                if (staff != null) {
                    StaffAttendanceConfiguration staffAttendanceConfig = institution.getStaffAttendanceConfiguration();
                    Set<AcademicYear> academicYears = institution.getAcademicYears();
                    AcademicYear academicYear = null;
                    for (AcademicYear academicYear2 : academicYears) {
                        if (academicYear2.getAcademicYearStatus() != 1) continue;
                        academicYear = academicYear2;
                        break;
                    }
                    StaffAttendance staffAttendancecheck = this.staffAttendanceDAO.getStaffAttendance(academicYear, attendanceDate, staff);
                    if (staffAttendancecheck != null) {
                        Object outpunch;
                        StaffAttendancePunch punch;
                        Hibernate.initialize(staff.getStaffLeaveRequisitions());
                        Hibernate.initialize(staff.getStaffMovementRequisitions());
                        if (staff.getStaffLeaveRequisitions().isEmpty() && staff.getStaffMovementRequisitions().isEmpty()) {
                            punch = new StaffAttendancePunch(staffAttendancecheck, new Time(inFormat.parse(inTime).getTime()));
                            this.staffAttendancePunchDAO.persist(punch);
                            outpunch = new StaffAttendancePunch(staffAttendancecheck, new Time(inFormat.parse(outTime).getTime()));
                            this.staffAttendancePunchDAO.persist(outpunch);
                            continue;
                        }
                        for (StaffLeaveRequisition staffLeaveRequisition : staff.getStaffLeaveRequisitions()) {
                            if (dateformatter.parse(dateformatter.format(staffAttendancecheck.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(staffAttendancecheck.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveEndDate()) > 0 || !staffLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                            checkStatus = false;
                        }
                        for (StaffMovementRequisition staffMovementRequisition : staff.getStaffMovementRequisitions()) {
                            if (!staffMovementRequisition.getApprovalStatus().equals("Approved")) continue;
                            Time tfromval = Time.valueOf(staffMovementRequisition.getStartTime().toString());
                            Long timeFromVal = tfromval.getTime();
                            Time tpoint = Time.valueOf(inTime);
                            Long timePointVal = tpoint.getTime();
                            Time ttoval = Time.valueOf(staffMovementRequisition.getEndTime().toString());
                            Long timeToVal = ttoval.getTime();
                            if (timePointVal < timeFromVal || timePointVal > timeToVal) continue;
                            checkStatus = false;
                        }
                        if (!checkStatus) continue;
                        punch = new StaffAttendancePunch(staffAttendancecheck, new Time(inFormat.parse(inTime).getTime()));
                        this.staffAttendancePunchDAO.persist(punch);
                        outpunch = new StaffAttendancePunch(staffAttendancecheck, new Time(inFormat.parse(outTime).getTime()));
                        this.staffAttendancePunchDAO.persist(outpunch);
                        continue;
                    }
                    StaffAttendance staffAttendance = new StaffAttendance(attendanceDate, academicYear, staffAttendanceConfig.getStartingWorkTime(), staffAttendanceConfig.getClosingWorkTime(), staff, institution);
                    Hibernate.initialize(staff.getStaffLeaveRequisitions());
                    Hibernate.initialize(staff.getStaffMovementRequisitions());
                    for (StaffLeaveRequisition staffLeaveRequisition : staff.getStaffLeaveRequisitions()) {
                        if (dateformatter.parse(dateformatter.format(staffAttendance.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(staffAttendance.getDate())).compareTo(staffLeaveRequisition.getStaffLeaveEndDate()) > 0 || !staffLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                        checkStatus = false;
                    }
                    for (StaffMovementRequisition staffMovementRequisition : staff.getStaffMovementRequisitions()) {
                        if (!staffMovementRequisition.getApprovalStatus().equals("Approved")) continue;
                        Time tfromval = Time.valueOf(staffMovementRequisition.getStartTime().toString());
                        Long timeFromVal = tfromval.getTime();
                        Time tpoint = Time.valueOf(inTime);
                        Long timePointVal = tpoint.getTime();
                        Time ttoval = Time.valueOf(staffMovementRequisition.getEndTime().toString());
                        Long timeToVal = ttoval.getTime();
                        if (timePointVal < timeFromVal || timePointVal > timeToVal) continue;
                        checkStatus = false;
                    }
                    if (!checkStatus) continue;
                    StaffAttendance persistedStaffAttendance = this.staffAttendanceDAO.save(staffAttendance);
                    StaffAttendancePunch punch = new StaffAttendancePunch(persistedStaffAttendance, new Time(inFormat.parse(inTime).getTime()));
                    this.staffAttendancePunchDAO.persist(punch);
                    StaffAttendancePunch outpunch = new StaffAttendancePunch(persistedStaffAttendance, new Time(inFormat.parse(outTime).getTime()));
                    this.staffAttendancePunchDAO.persist(outpunch);
                    continue;
                }
                throw new StaffAttendanceException(new Message("invalidStaff", "Invalid Staff Code"));
            }
            return i;
        }
        catch (IOException | ConstraintViolationException e) {
            if (e.getClass().equals(IOException.class)) {
                e.printStackTrace();
                throw new StaffAttendanceException(new Message("fileError", "Excel File Not Found"));
            }
            if (e.getClass().equals(NullPointerException.class)) {
                e.printStackTrace();
                throw new StaffAttendanceException(new Message("Null Value", "Fields Cannot be Blank"));
            }
            e.printStackTrace();
            return 0;
        }
    }
}
