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

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentAttendanceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentAttendanceTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentStatusDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.exceptions.StudentAttendanceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceService;
import java.io.IOException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
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
public class StudentAttendanceServiceImpl
implements StudentAttendanceService {
    @Autowired
    private StudentAttendanceDAO studentAttendanceDAO;
    @Autowired
    private StudentAttendanceTypeDAO studentAttendanceTypeDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private StudentStatusDAO studentStatusDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    StudentLeaveRequisitionDAO studentLeaveRequisitionDAO;
    @Autowired
    private ClassDAO classDAO;

    @Override
    public void addStudentAttendance(List<StudentAttendance> studentAttendances) throws StudentAttendanceException, ParseException, Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            for (StudentAttendance studentAttendance : studentAttendances) {
                Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                Hibernate.initialize((Object)studentAttendance.getStudent());
                Hibernate.initialize(studentAttendance.getStudent().getStudentLeaveRequistions());
                if (studentAttendance.getStudent().getStudentLeaveRequistions().isEmpty()) {
                    if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                        Student student = this.studentDAO.getStudentById(studentAttendance.getStudent().getStudentId());
                        Hibernate.initialize((Object)student.getUser());
                        Hibernate.initialize((Object)student.getParentUser());
                        addUser.add(student.getUser());
                        addUser.add(student.getParentUser());
                    }
                    this.studentAttendanceDAO.persist(studentAttendance);
                    continue;
                }
                for (StudentLeaveRequisition studentLeaveRequisition : studentAttendance.getStudent().getStudentLeaveRequistions()) {
                    if (formatter.parse(formatter.format(studentAttendance.getStudentAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveStartDate()) < 0 || formatter.parse(formatter.format(studentAttendance.getStudentAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveEndDate()) > 0 || !studentLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                    studentAttendance.setStudentAttendanceType(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
                    Student student = this.studentDAO.getStudentById(studentAttendance.getStudent().getStudentId());
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize((Object)student.getParentUser());
                    addUser.add(student.getUser());
                    addUser.add(student.getParentUser());
                }
                this.studentAttendanceDAO.persist(studentAttendance);
            }
            if (addUser.size() > 0) {
                String[] userMailIds = new String[addUser.size()];
                int i = 0;
                for (User user : addUser) {
                    userMailIds[i] = user.getEmail().trim();
                    ++i;
                }
                Date currentDate = new Date();
                this.emailHandler.sendEmail(userMailIds, "Today Absent", "Absent  " + currentDate);
            }
            log.info((Object)"Creating student attendance completed successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                ConstraintViolationException cve = (ConstraintViolationException)e;
                if (cve.getConstraintName() != null && cve.getConstraintName().equals("attendance_date")) {
                    throw new StudentAttendanceException(new Message("failure", "Cannot Saved !! Duplicate Attendance"));
                }
            }
            log.error((Object)"Exception in Creating Student Attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public String studentAttendancePercentageByCurrentDate(Long institutionId) {
        String percentageWithSymbol = "0%";
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            LinkedHashSet<StudentAttendanceType> studentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            studentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(1L));
            studentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(3L));
            List<StudentAttendance> studentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndType(new Date(System.currentTimeMillis()), institution, studentAttendanceTypes);
            Integer availableStudents = studentAttendanceRecords.size();
            List<Student> students = this.studentDAO.getStudentsByStatus(institution, studentStatus);
            Integer totalStudents = students.size();
            Double percentile = (double)availableStudents.intValue() / (double)totalStudents.intValue();
            Double percentage = percentile * 100.0;
            if (!percentage.isNaN()) {
                percentageWithSymbol = df.format(percentage).concat("%");
            }
            return percentageWithSymbol;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student attendance percentage by current date", e.getCause());
            e.printStackTrace();
            return percentageWithSymbol;
        }
    }

    @Override
    public List<StudentAttendance> studentAttendanceByStudentEmailAndAttendanceMonthEager(String studentEmail, Institution institution, Date attendanceMonth) throws StaffException {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            List<StudentAttendance> studentAttendances = this.studentAttendanceDAO.getStudentAttendanceByStudentEmailAndClassAndSectionAndAttendanceMonth(student, student.getStudentClass(), student.getSection(), attendanceMonth, academicYear);
            Integer studentAttendanceRecordSize = studentAttendances.size();
            if (studentAttendanceRecordSize > 0) {
                for (StudentAttendance studentAttendance : studentAttendances) {
                    Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)studentAttendance.getStudent());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getSection());
                }
                log.info((Object)(studentAttendanceRecordSize + " studentAttendance records reterived"));
            } else {
                log.info((Object)"No studentAttendance Records found for given EmailId,AttendanceMonth ");
            }
            return studentAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StudentAttendance given EmailId=" + studentEmail + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ThreeFieldReports chartStudentAttendancePercentageByCurrentDate(Long institutionId) {
        ThreeFieldReports percentageWithSymbol = null;
        try {
            StudentStatus studentStatus = this.studentStatusDAO.getStudentStatusById(1L);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            LinkedHashSet<StudentAttendanceType> presentStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            presentStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(1L));
            LinkedHashSet<StudentAttendanceType> ondutyStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            ondutyStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(3L));
            List<StudentAttendance> presentStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndType(new Date(System.currentTimeMillis()), institution, presentStudentAttendanceTypes);
            Integer presentStudents = presentStudentAttendanceRecords.size();
            List<StudentAttendance> ondutyStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndType(new Date(System.currentTimeMillis()), institution, ondutyStudentAttendanceTypes);
            Integer ondutyStudents = ondutyStudentAttendanceRecords.size();
            List<Student> students = this.studentDAO.getStudentsByStatus(institution, studentStatus);
            Integer totalStudents = students.size();
            Integer absentStudents = totalStudents - (ondutyStudents + presentStudents);
            percentageWithSymbol = new ThreeFieldReports(presentStudents, ondutyStudents, absentStudents);
            return percentageWithSymbol;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student attendance percentage by current date", e.getCause());
            e.printStackTrace();
            return percentageWithSymbol;
        }
    }

    @Override
    public List<StudentAttendance> studentAttendanceByClassAndSectionAndAttendanceMonthEager(Class classs, Section section, Date attendanceMonth) throws StaffException {
        try {
            List<StudentAttendance> studentAttendances = this.studentAttendanceDAO.getStudentAttendanceByClassAndSectionAndAttendanceMonth(classs, section, attendanceMonth);
            Integer studentAttendanceRecordSize = studentAttendances.size();
            if (studentAttendanceRecordSize > 0) {
                for (StudentAttendance studentAttendance : studentAttendances) {
                    Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)studentAttendance.getStudent());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getSection());
                }
                log.info((Object)(studentAttendanceRecordSize + " studentAttendance records reterived"));
            } else {
                log.info((Object)"No studentAttendance Records found for given Class,Section,AttendanceMonth ");
            }
            return studentAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StudentAttendance given Class=" + classs + ",Section=" + section + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<FourFieldReport> todayAttendanceByClassWise() {
        ArrayList<FourFieldReport> fourFieldReports = new ArrayList<FourFieldReport>();
        for (Class classes : this.classDAO.getList()) {
            LinkedHashSet<StudentAttendanceType> presentStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            presentStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(1L));
            LinkedHashSet<StudentAttendanceType> ondutyStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            ondutyStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(3L));
            LinkedHashSet<StudentAttendanceType> absentStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            absentStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
            List<StudentAttendance> presentStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, presentStudentAttendanceTypes);
            Integer presentStudents = presentStudentAttendanceRecords.size();
            List<StudentAttendance> ondutyStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, ondutyStudentAttendanceTypes);
            Integer ondutyStudents = ondutyStudentAttendanceRecords.size();
            List<StudentAttendance> absentStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, absentStudentAttendanceTypes);
            Integer absentStudents = absentStudentAttendanceRecords.size();
            fourFieldReports.add(new FourFieldReport(classes.getClassName(), presentStudents, ondutyStudents, absentStudents));
        }
        return fourFieldReports;
    }

    @Override
    public List<FourFieldReport> todayAttendanceByClassWiseByInstitution(Long institutionId) {
        ArrayList<FourFieldReport> fourFieldReports = new ArrayList<FourFieldReport>();
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Hibernate.initialize(institution.getClasses());
        for (Class classes : institution.getClasses()) {
            LinkedHashSet<StudentAttendanceType> presentStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            presentStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(1L));
            LinkedHashSet<StudentAttendanceType> ondutyStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            ondutyStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(3L));
            LinkedHashSet<StudentAttendanceType> absentStudentAttendanceTypes = new LinkedHashSet<StudentAttendanceType>();
            absentStudentAttendanceTypes.add(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
            List<StudentAttendance> presentStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, presentStudentAttendanceTypes);
            Integer presentStudents = presentStudentAttendanceRecords.size();
            List<StudentAttendance> ondutyStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, ondutyStudentAttendanceTypes);
            Integer ondutyStudents = ondutyStudentAttendanceRecords.size();
            List<StudentAttendance> absentStudentAttendanceRecords = this.studentAttendanceDAO.studentAttendanceByDateAndTypeAndClass(new Date(System.currentTimeMillis()), classes, absentStudentAttendanceTypes);
            Integer absentStudents = absentStudentAttendanceRecords.size();
            fourFieldReports.add(new FourFieldReport(classes.getClassName(), presentStudents, ondutyStudents, absentStudents));
        }
        return fourFieldReports;
    }

    @Override
    public List<StudentAttendance> studentAttendanceByClassAndSectionAndDateAttendanceEager(Class classs, Section section, Date attendanceDate) throws StudentAttendanceException {
        try {
            List<StudentAttendance> studentAttendances = this.studentAttendanceDAO.getStudentAttendanceByClassAndSectionAndAttendanceDate(classs, section, attendanceDate);
            Integer studentAttendanceRecordSize = studentAttendances.size();
            if (studentAttendanceRecordSize > 0) {
                for (StudentAttendance studentAttendance : studentAttendances) {
                    Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)studentAttendance.getStudent());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)studentAttendance.getStudent().getSection());
                }
                log.info((Object)(studentAttendanceRecordSize + " studentAttendance records reterived"));
            } else {
                log.info((Object)"No studentAttendance Records found for given Class,Section,AttendanceDate ");
            }
            return studentAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentAttendanceException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StudentAttendance given Class=" + classs + ",Section=" + section + ",AttendanceMonth=" + attendanceDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAllStudentAttendance(Long[] studentAttendanceIds) {
        try {
            Long[] longArray = studentAttendanceIds;
            int n = studentAttendanceIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long studentAttendanceId = longArray[n2];
                this.studentAttendanceDAO.delete(this.studentAttendanceDAO.getStudentAttendanceById(studentAttendanceId));
                ++n2;
            }
            log.info((Object)"Student attendance deleted successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in delete student attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StudentAttendance studentAttendanceByIdEager(Long studentAttendanceId) throws StudentAttendanceException {
        try {
            StudentAttendance studentAttendance = null;
            studentAttendance = this.studentAttendanceDAO.getStudentAttendanceById(studentAttendanceId);
            Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
            Hibernate.initialize((Object)studentAttendance.getStudent());
            return studentAttendance;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStudentAttendance(StudentAttendance studentAttendance) {
        try {
            this.studentAttendanceDAO.saveOrUpdate(studentAttendance);
            log.info((Object)"Student attendance updated successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in update student attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StudentAttendance> studentAttendanceByAttendanceStartDateAndEndDateAndStudentEmail(String studentEmail, Institution institution, Date attendanceStartDate, Date attendanceEndDate) throws StudentAttendanceException {
        try {
            AcademicYear academicYear;
            Integer studentsRecordSize;
            List<Object> studentAttendanceList = new ArrayList();
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            if ((studentsRecordSize = Integer.valueOf((studentAttendanceList = this.studentAttendanceDAO.getStudentAttendanceByAttendanceStartDateAndEndDateAndStudent(student, attendanceStartDate, attendanceEndDate, academicYear = this.academicYearDAO.getActiveAcademicYear())).size())) > 0) {
                for (StudentAttendance studentAttendance : studentAttendanceList) {
                    Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)studentAttendance.getStudent());
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Student Email,AttendanceStartDate,AttendanceEndDate ");
            }
            return studentAttendanceList;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentAttendanceException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given Student Email=" + studentEmail + ",AttendanceStartDate=" + attendanceStartDate + ",AttendanceEndDate=" + attendanceEndDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SevenFieldReports overAllStudentAttendanceByAcademicYearAndStudentEmail(AcademicYear academicYear, String studentEmail) throws StudentAttendanceException {
        try {
            SevenFieldReports sevenFieldReport = null;
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            Long totalWorkingDays = academicYear.getTotalWorkingDays();
            DecimalFormat df = new DecimalFormat("#.##");
            String className = "";
            String sectionName = "";
            Double precentCount = 0.0;
            Integer absentCount = 0;
            Integer ondutyCount = 0;
            String percentageWithSymbol = "0%";
            className = student.getStudentClass().getClassName();
            sectionName = student.getSection().getSectionName();
            LinkedHashSet<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
            Hibernate.initialize(student.getStudentAttendances());
            for (StudentAttendance studentAttendance : student.getStudentAttendances()) {
                Hibernate.initialize((Object)studentAttendance.getStudentClass());
                Hibernate.initialize((Object)studentAttendance.getAcademicYear());
                Hibernate.initialize((Object)studentAttendance.getSection());
                if (studentAttendance.getAcademicYear().getAcademicYearId() != academicYear.getAcademicYearId() || studentAttendance.getStudentClass().getClassId() != student.getStudentClass().getClassId() || studentAttendance.getSection().getSectionId() != student.getSection().getSectionId()) continue;
                Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                studentAttendances.add(studentAttendance);
                if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 1L) {
                    if (studentAttendance.getDayAttendanceType().equals("HalfDay")) {
                        precentCount = precentCount + 0.5;
                        continue;
                    }
                    if (!studentAttendance.getDayAttendanceType().equals("FullDay")) continue;
                    precentCount = precentCount + 1.0;
                    continue;
                }
                if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                    absentCount = absentCount + 1;
                    continue;
                }
                if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() != 3L) continue;
                ondutyCount = ondutyCount + 1;
            }
            student.setStudentAttendances(studentAttendances);
            Double percentile = (precentCount + (double)ondutyCount.intValue()) / (double)totalWorkingDays.longValue();
            Double percentage = percentile * 100.0;
            if (!percentage.isNaN()) {
                percentageWithSymbol = df.format(percentage).concat("%");
            }
            sevenFieldReport = new SevenFieldReports(String.valueOf(className) + "/" + sectionName, academicYear.getAcademicYearTitle(), precentCount, absentCount, ondutyCount, totalWorkingDays, percentageWithSymbol);
            return sevenFieldReport;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StudentAttendanceException(new Message("nullpointer", e.getMessage()));
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<NineFieldReports> studentAttendanceListByLongAbsentStudentListByDefaultMonth() throws StudentAttendanceException, ParseException {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(currentDate);
        formatter.parse(date);
        StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
        List<Student> students = this.studentDAO.getStudentListByStatus(status);
        ArrayList<NineFieldReports> nineFieldReports = new ArrayList<NineFieldReports>();
        StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L);
        Integer studentsRecordSize = students.size();
        if (studentsRecordSize > 0) {
            for (Student student : students) {
                if (this.studentAttendanceDAO.getLongAbsentStudentList(student, formatter.parse(date), studentAttendanceType).size() < 3) continue;
                int size = this.studentAttendanceDAO.getLongAbsentStudentList(student, formatter.parse(date), studentAttendanceType).size();
                String name = "";
                name = student.getLastName() != null && student.getLastName() != " " ? String.valueOf(student.getFirstName()) + " " + student.getLastName() : student.getFirstName();
                nineFieldReports.add(new NineFieldReports(student.getAdmissionNo(), name, student.getStudentClass().getClassName(), student.getSection().getSectionName(), student.getInstitution().getInstitutionName(), student.getJoinedAcademicYear().getAcademicYearTitle(), student.getContact(), student.getParentContact(), size));
            }
            log.info((Object)(studentsRecordSize + " student records reterived"));
        } else {
            log.info((Object)"No student Records found for given default month ");
        }
        return nineFieldReports;
    }

    @Override
    public List<NineFieldReports> studentAttendanceListByLongAbsentStudentListBySelectedMonthAndInstitution(Date month, Long institutionId) throws StudentAttendanceException {
        StudentStatus status = this.studentStatusDAO.getStudentStatusById(1L);
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        List<Student> students = this.studentDAO.getStudentsByStatus(institution, status);
        ArrayList<NineFieldReports> nineFieldReports = new ArrayList<NineFieldReports>();
        StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L);
        Integer studentsRecordSize = students.size();
        if (studentsRecordSize > 0) {
            for (Student student : students) {
                if (this.studentAttendanceDAO.getLongAbsentStudentList(student, month, studentAttendanceType).size() < 3) continue;
                int size = this.studentAttendanceDAO.getLongAbsentStudentList(student, month, studentAttendanceType).size();
                String name = "";
                name = student.getLastName() != null && student.getLastName() != " " ? String.valueOf(student.getFirstName()) + " " + student.getLastName() : student.getFirstName();
                nineFieldReports.add(new NineFieldReports(student.getAdmissionNo(), name, student.getStudentClass().getClassName(), student.getSection().getSectionName(), student.getInstitution().getInstitutionName(), student.getJoinedAcademicYear().getAcademicYearTitle(), student.getContact(), student.getParentContact(), size));
            }
            log.info((Object)(studentsRecordSize + " student records reterived"));
        } else {
            log.info((Object)"No student Records found for given selected month ");
        }
        return nineFieldReports;
    }

    @Override
    public Integer studentAttendanceBulkUpload(MultipartFile studentExcelFile, Long institutionId) throws StudentAttendanceException, ParseException {
        int i = 1;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        LinkedHashSet<User> addUser = new LinkedHashSet<User>();
        try {
            DataFormatter formatter = new DataFormatter();
            HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
            HSSFSheet worksheet = workbook.getSheetAt(0);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            while (i <= worksheet.getLastRowNum()) {
                Date date;
                HSSFRow row = worksheet.getRow(i++);
                String studentAdmissionNumber = null;
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) {
                    throw new StudentAttendanceException(new Message("admissionNumberNotFound", "Upload Failed : You have to mention Student Admission Number in row " + i));
                }
                studentAdmissionNumber = formatter.formatCellValue((Cell)row.getCell(0)).trim();
                Date attendanceDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(1)).isEmpty()) {
                    throw new StudentAttendanceException(new Message("invalidDateFormat", "Upload Failed : Invalid Attendance Date Format in row " + i + " correct format [eg:MM/dd/yyyy]"));
                }
                attendanceDate = date = new Date(formatter.formatCellValue((Cell)row.getCell(1)).trim());
                StudentAttendanceType studentAttendanceType = null;
                String attendanceType = null;
                if (!formatter.formatCellValue((Cell)row.getCell(2)).isEmpty()) {
                    attendanceType = formatter.formatCellValue((Cell)row.getCell(2)).trim();
                    if (this.studentAttendanceTypeDAO.getStudentAttendanceTypeByName(attendanceType) == null) {
                        throw new StudentAttendanceException(new Message("attendanceTypeNotFound", "Upload Failed : You have to correctly mention Attendnace Type in row " + i));
                    }
                } else {
                    throw new StudentAttendanceException(new Message("attendanceTypeNotFound", "Upload Failed : You have to mention Attendnace Type in row " + i));
                }
                studentAttendanceType = this.studentAttendanceTypeDAO.getStudentAttendanceTypeByName(attendanceType);
                String dayAttendanceType = null;
                if (!formatter.formatCellValue((Cell)row.getCell(3)).isEmpty()) {
                    dayAttendanceType = formatter.formatCellValue((Cell)row.getCell(3)).trim();
                    if (dayAttendanceType.isEmpty() || dayAttendanceType.equals("")) {
                        throw new StudentAttendanceException(new Message("dayAttendanceTypeNotFound", "Upload Failed : You have to correctly mention Day Attendnace Type in row " + i));
                    }
                } else {
                    throw new StudentAttendanceException(new Message("dayAttendanceTypeNotFound", "Upload Failed : You have to mention Day Attendnace Type in row " + i));
                }
                dayAttendanceType = formatter.formatCellValue((Cell)row.getCell(3)).trim();
                Student student = this.studentDAO.getStudentByAdmissionNo(studentAdmissionNumber);
                if (student != null) {
                    Hibernate.initialize((Object)student.getStudentClass());
                    Hibernate.initialize((Object)student.getSection());
                    AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
                    StudentAttendance studentAttendancecheck = this.studentAttendanceDAO.getStudentAttendanceByStudentAndAcademicYearAndAttendanceDate(student, academicYear, attendanceDate);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd-HH:mm");
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    Date date2 = new Date();
                    String[] dateAndTime = dateFormat.format(date2).split("-");
                    if (studentAttendancecheck == null) {
                        StudentAttendance studentAttendance = new StudentAttendance(student, student.getStudentClass(), student.getSection(), academicYear, attendanceDate, new Time(timeFormat.parse(dateAndTime[1]).getTime()), studentAttendanceType, institution, dayAttendanceType);
                        Hibernate.initialize((Object)studentAttendance.getStudentAttendanceType());
                        Hibernate.initialize((Object)studentAttendance.getStudent());
                        Hibernate.initialize(studentAttendance.getStudent().getStudentLeaveRequistions());
                        if (studentAttendance.getStudent().getStudentLeaveRequistions().isEmpty()) {
                            if (studentAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                                Hibernate.initialize((Object)student.getUser());
                                Hibernate.initialize((Object)student.getParentUser());
                                addUser.add(student.getUser());
                                addUser.add(student.getParentUser());
                            }
                            this.studentAttendanceDAO.persist(studentAttendance);
                            continue;
                        }
                        for (StudentLeaveRequisition studentLeaveRequisition : studentAttendance.getStudent().getStudentLeaveRequistions()) {
                            if (dateformatter.parse(dateformatter.format(studentAttendance.getStudentAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveStartDate()) < 0 || dateformatter.parse(dateformatter.format(studentAttendance.getStudentAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveEndDate()) > 0 || !studentLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                            studentAttendance.setStudentAttendanceType(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
                            Hibernate.initialize((Object)student.getUser());
                            Hibernate.initialize((Object)student.getParentUser());
                            addUser.add(student.getUser());
                            addUser.add(student.getParentUser());
                        }
                        this.studentAttendanceDAO.persist(studentAttendance);
                        continue;
                    }
                    SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
                    throw new StudentAttendanceException(new Message("invalidStudent", "Already Attendance Taken By " + formatter1.format(attendanceDate) + " This Date And " + studentAdmissionNumber + " This Admission Number"));
                }
                throw new StudentAttendanceException(new Message("invalidStudent", "Invalid Student Admission Number"));
            }
            return i;
        }
        catch (IOException | ConstraintViolationException e) {
            if (e.getClass().equals(IOException.class)) {
                e.printStackTrace();
                throw new StudentAttendanceException(new Message("fileError", "Excel File Not Found"));
            }
            if (e.getClass().equals(NullPointerException.class)) {
                e.printStackTrace();
                throw new StudentAttendanceException(new Message("Null Value", "Fields Cannot be Blank"));
            }
            e.printStackTrace();
            return 0;
        }
    }
}
