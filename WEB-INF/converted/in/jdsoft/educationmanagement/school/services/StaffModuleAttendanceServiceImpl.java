/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleDAO;
import in.jdsoft.educationmanagement.school.dao.StaffModuleAttendanceDAO;
import in.jdsoft.educationmanagement.school.dao.StudentAttendanceTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.StudentLeaveRequisitionDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.services.StaffModuleAttendanceService;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffModuleAttendanceService")
public class StaffModuleAttendanceServiceImpl
implements StaffModuleAttendanceService {
    @Autowired
    StaffModuleAttendanceDAO staffModuleAttendanceDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    ClassSectionDAO classSectionDAO;
    @Autowired
    ClassSectionModuleDAO classSectionModuleDAO;
    @Autowired
    private StudentAttendanceTypeDAO studentAttendanceTypeDAO;
    @Autowired
    StudentLeaveRequisitionDAO studentLeaveRequisitionDAO;
    @Autowired
    private EmailHandler emailHandler;

    @Override
    public void addStaffModuleAttendance(List<StaffModuleAttendance> staffModuleAttendances) throws StaffException, ParseException, Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Time time = null;
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                time = staffModuleAttendance.getAttendanceTime();
                Student student = this.studentDAO.getStudentById(staffModuleAttendance.getStudent().getStudentId());
                Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                Hibernate.initialize((Object)staffModuleAttendance.getStudent());
                Hibernate.initialize(student.getStudentLeaveRequistions());
                Hibernate.initialize(student.getStudentMovementRequisitions());
                if (student.getStudentLeaveRequistions().isEmpty() && student.getStudentMovementRequisitions().isEmpty()) {
                    if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                        Hibernate.initialize((Object)student.getUser());
                        Hibernate.initialize((Object)student.getParentUser());
                        addUser.add(student.getUser());
                        addUser.add(student.getParentUser());
                    }
                    this.staffModuleAttendanceDAO.persist(staffModuleAttendance);
                    continue;
                }
                for (StudentLeaveRequisition studentLeaveRequisition : staffModuleAttendance.getStudent().getStudentLeaveRequistions()) {
                    if (formatter.parse(formatter.format(staffModuleAttendance.getAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveStartDate()) < 0 || formatter.parse(formatter.format(staffModuleAttendance.getAttendanceDate())).compareTo(studentLeaveRequisition.getStudentLeaveEndDate()) > 0 || !studentLeaveRequisition.getApprovalStatus().equals("Approved")) continue;
                    staffModuleAttendance.setStudentAttendanceType(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize((Object)student.getParentUser());
                    addUser.add(student.getUser());
                    addUser.add(student.getParentUser());
                }
                for (StudentMovementRequisition studentMovementRequisition : staffModuleAttendance.getStudent().getStudentMovementRequisitions()) {
                    if (!studentMovementRequisition.getApprovalStatus().equals("Approved")) continue;
                    String timePoint = time.toString();
                    Time tfromval = Time.valueOf(studentMovementRequisition.getStartTime().toString());
                    Long timeFromVal = tfromval.getTime();
                    Time tpoint = Time.valueOf(timePoint);
                    Long timePointVal = tpoint.getTime();
                    Time ttoval = Time.valueOf(studentMovementRequisition.getEndTime().toString());
                    Long timeToVal = ttoval.getTime();
                    if (timePointVal < timeFromVal || timePointVal > timeToVal) continue;
                    staffModuleAttendance.setStudentAttendanceType(this.studentAttendanceTypeDAO.getStudentAttendanceTypeById(2L));
                    Hibernate.initialize((Object)student.getUser());
                    Hibernate.initialize((Object)student.getParentUser());
                    addUser.add(student.getUser());
                    addUser.add(student.getParentUser());
                }
                this.staffModuleAttendanceDAO.persist(staffModuleAttendance);
            }
            if (addUser.size() > 0) {
                String[] userMailIds = new String[addUser.size()];
                int i = 0;
                for (User user : addUser) {
                    userMailIds[i] = user.getEmail().trim();
                    ++i;
                }
                this.emailHandler.sendEmail(userMailIds, "Hour Absent", "Hour Absent  " + time);
            }
            log.info((Object)"Staff module attendance added successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in adding staff module attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffModuleAttendance> staffModuleAttendanceByStudentEmailAndAttendanceStartDateAndAttendanceEndDateEager(String studentEmail, Institution institution, Date attendanceStartDate, Date attendanceEndDate) throws StaffException {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
            staffModuleAttendances.addAll(this.staffModuleAttendanceDAO.getStaffModuleAttendanceByStudentEmailAndClassAndSectionAndAttendanceStartDateAndAttendanceEndDate(student, student.getStudentClass(), student.getSection(), attendanceStartDate, attendanceEndDate, academicYear));
            Integer staffModuleAttendanceRecordSize = staffModuleAttendances.size();
            if (staffModuleAttendanceRecordSize > 0) {
                for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                    Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                    Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule().getModule());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getSection());
                }
                log.info((Object)(staffModuleAttendanceRecordSize + " staffModuleAttendance records reterived"));
            } else {
                log.info((Object)"No staffModuleAttendance Records found for given EmailId,AttendanceStartDate,AttendanceEndDate ");
            }
            return staffModuleAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StaffModuleAttendance given EmailId=" + studentEmail + ",AttendanceStartDate=" + attendanceStartDate + ",AttendanceEndDate=" + attendanceEndDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffModuleAttendance> staffModuleAttendanceByStudentEmailAndAttendanceMonthEager(String studentEmail, Institution institution, Date attendanceMonth) throws StaffException {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            AcademicYear academicYear = this.academicYearDAO.getActiveAcademicYear();
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
            staffModuleAttendances.addAll(this.staffModuleAttendanceDAO.getStaffModuleAttendanceByStudentEmailAndClassAndSectionAndAttendanceMonth(student, student.getStudentClass(), student.getSection(), attendanceMonth, academicYear));
            Integer staffModuleAttendanceRecordSize = staffModuleAttendances.size();
            if (staffModuleAttendanceRecordSize > 0) {
                for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                    Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                    Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule().getModule());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getSection());
                }
                log.info((Object)(staffModuleAttendanceRecordSize + " staffModuleAttendance records reterived"));
            } else {
                log.info((Object)"No staffModuleAttendance Records found for given EmailId,AttendanceMonth ");
            }
            return staffModuleAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StaffModuleAttendance given EmailId=" + studentEmail + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffModuleAttendance> staffModuleAttendanceByClassAndSectionAndAttendanceStartDateAndAttendanceEndDateEager(Class classs, Section section, Date attendanceStartDate, Date attendanceEndDate) throws StaffException {
        try {
            ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
            staffModuleAttendances.addAll(this.staffModuleAttendanceDAO.getStaffModuleAttendanceByClassAndSectionAndAttendanceStartDateAndAttendanceEndDate(classs, section, attendanceStartDate, attendanceEndDate));
            Integer staffModuleAttendanceRecordSize = staffModuleAttendances.size();
            if (staffModuleAttendanceRecordSize > 0) {
                for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                    Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                    Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule().getModule());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getSection());
                }
                log.info((Object)(staffModuleAttendanceRecordSize + " staffModuleAttendance records reterived"));
            } else {
                log.info((Object)"No staffModuleAttendance Records found for given Class,Section,AttendanceStartDate,AttendanceEndDate ");
            }
            return staffModuleAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StaffModuleAttendance given Class=" + classs.getClassName() + ",section=" + section.getSectionName() + ",AttendanceStartDate=" + attendanceStartDate + ",AttendanceEndDate=" + attendanceEndDate), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffModuleAttendance> staffModuleAttendanceByClassAndSectionAndAttendanceMonthEager(Class classs, Section section, Date attendanceMonth) throws StaffException {
        try {
            ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
            staffModuleAttendances.addAll(this.staffModuleAttendanceDAO.getStaffModuleAttendanceByClassAndSectionAndAttendanceMonth(classs, section, attendanceMonth));
            Integer staffModuleAttendanceRecordSize = staffModuleAttendances.size();
            if (staffModuleAttendanceRecordSize > 0) {
                for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                    Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                    Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule().getModule());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getStudentClass());
                    Hibernate.initialize((Object)staffModuleAttendance.getStudent().getSection());
                }
                log.info((Object)(staffModuleAttendanceRecordSize + " staffModuleAttendance records reterived"));
            } else {
                log.info((Object)"No staffModuleAttendance Records found for given Class,Section,AttendanceMonth ");
            }
            return staffModuleAttendances;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving StaffModuleAttendance given Class=" + classs.getClassName() + ",section=" + section.getSectionName() + ",AttendanceMonth=" + attendanceMonth), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffModuleAttendance(Long staffModuleAttendanceId) {
        try {
            this.staffModuleAttendanceDAO.delete(this.staffModuleAttendanceDAO.getStaffModuleAttendanceById(staffModuleAttendanceId));
            log.info((Object)"Staff module attendance deleted successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in delete staff module attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAllStaffModuleAttendance(Long[] staffModuleAttendanceIds) {
        try {
            Long[] longArray = staffModuleAttendanceIds;
            int n = staffModuleAttendanceIds.length;
            int n2 = 0;
            while (n2 < n) {
                Long staffModuleAttendanceId = longArray[n2];
                this.staffModuleAttendanceDAO.delete(this.staffModuleAttendanceDAO.getStaffModuleAttendanceById(staffModuleAttendanceId));
                ++n2;
            }
            log.info((Object)"Staff module attendance deleted successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in delete staff module attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffModuleAttendance staffModuleAttendanceById(Long staffModuleAttendanceId) throws StaffException {
        try {
            StaffModuleAttendance staffModuleAttendance = null;
            staffModuleAttendance = this.staffModuleAttendanceDAO.getStaffModuleAttendanceById(staffModuleAttendanceId);
            Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
            Hibernate.initialize((Object)staffModuleAttendance.getStudent());
            Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule());
            return staffModuleAttendance;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffModuleAttendance(StaffModuleAttendance staffModuleAttendance) {
        try {
            this.staffModuleAttendanceDAO.saveOrUpdate(staffModuleAttendance);
            log.info((Object)"Staff module attendance update successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
            }
            log.error((Object)"Exception in updating staff module attendance", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SevenFieldReports> studentListByAcademicYearAndClassAndSection(Class classes, Section section, AcademicYear academicYear, ClassSectionModule classSectionModule) throws StaffException {
        try {
            ArrayList<SevenFieldReports> sevenFieldReports = new ArrayList<SevenFieldReports>();
            List<Object> students = new ArrayList();
            students = this.studentDAO.getStudentsByClassAndSection(classes, section);
            Integer studentsRecordSize = students.size();
            Hibernate.initialize((Object)classSectionModule.getModule());
            Long totalWorkingDays = classSectionModule.getModule().getTotalNumberOfHours();
            DecimalFormat df = new DecimalFormat("#.##");
            if (studentsRecordSize > 0) {
                for (Student student : students) {
                    String admissionNumber = "";
                    String name = "";
                    Integer precentCount = 0;
                    Integer absentCount = 0;
                    Integer ondutyCount = 0;
                    String percentageWithSymbol = "0%";
                    name = student.getLastName() != null ? String.valueOf(student.getFirstName()) + " " + student.getLastName() : student.getFirstName();
                    admissionNumber = student.getAdmissionNo();
                    LinkedHashSet<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
                    Hibernate.initialize(student.getStaffModuleAttendances());
                    for (StaffModuleAttendance staffModuleAttendance : student.getStaffModuleAttendances()) {
                        Hibernate.initialize((Object)staffModuleAttendance.getStudentClass());
                        Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                        Hibernate.initialize((Object)staffModuleAttendance.getSection());
                        Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule());
                        if (staffModuleAttendance.getAcdemicYear().getAcademicYearId() != academicYear.getAcademicYearId() || staffModuleAttendance.getStudentClass().getClassId() != classes.getClassId() || staffModuleAttendance.getSection().getSectionId() != section.getSectionId() || staffModuleAttendance.getClassSectionModule().getClassSectionModuleId() != classSectionModule.getClassSectionModuleId()) continue;
                        Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                        staffModuleAttendances.add(staffModuleAttendance);
                        if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 1L) {
                            precentCount = precentCount + 1;
                            continue;
                        }
                        if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                            absentCount = absentCount + 1;
                            continue;
                        }
                        if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() != 3L) continue;
                        ondutyCount = ondutyCount + 1;
                    }
                    student.setStaffModuleAttendances(staffModuleAttendances);
                    Double percentile = (double)(precentCount + ondutyCount) / (double)totalWorkingDays.longValue();
                    Double percentage = percentile * 100.0;
                    if (!percentage.isNaN()) {
                        percentageWithSymbol = df.format(percentage).concat("%");
                    }
                    sevenFieldReports.add(new SevenFieldReports(admissionNumber, name, precentCount, absentCount, ondutyCount, totalWorkingDays, percentageWithSymbol));
                }
                log.info((Object)(studentsRecordSize + " student records reterived"));
            } else {
                log.info((Object)"No student Records found for given Class,Section,AcademicYear,ClassSectionModule ");
            }
            return sevenFieldReports;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)("Exception in reteriving Student given Class=" + classes + ",Section=" + section + ",AcademicYear=" + academicYear + ",ClassSectionModule=" + classSectionModule + " ," + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SevenFieldReports> staffModuleAttendanceByAcademicYearAndStudentEmail(AcademicYear academicYear, String studentEmail) throws StaffException {
        try {
            ArrayList<SevenFieldReports> sevenFieldReports = new ArrayList<SevenFieldReports>();
            Student student = this.studentDAO.getStudentByEmail(studentEmail);
            if (student == null) {
                student = this.studentDAO.getStudentByParentEmail(studentEmail);
            }
            DecimalFormat df = new DecimalFormat("#.##");
            Hibernate.initialize((Object)student.getStudentClass());
            Hibernate.initialize((Object)student.getSection());
            ClassSection classSection = this.classSectionDAO.getClasssSectionByClassAndSection(student.getStudentClass(), student.getSection());
            List<Object> classSectionModules = new ArrayList();
            classSectionModules = this.classSectionModuleDAO.getClassSectionModuleByClassSection(classSection);
            for (ClassSectionModule classSectionModule : classSectionModules) {
                Hibernate.initialize((Object)classSectionModule.getModule());
                Hibernate.initialize((Object)classSectionModule.getClassSection());
                Long totalWorkingDays = classSectionModule.getModule().getTotalNumberOfHours();
                String moduleName = "";
                String moduleCode = "";
                Integer precentCount = 0;
                Integer absentCount = 0;
                Integer ondutyCount = 0;
                String percentageWithSymbol = "0%";
                moduleName = classSectionModule.getModule().getModuleName();
                moduleCode = classSectionModule.getModule().getModuleCode();
                ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
                staffModuleAttendances.addAll(this.staffModuleAttendanceDAO.getStaffModuleAttendanceByClassAndSectionAndAcademicYearAndClassSectionModule(student.getStudentClass(), student.getSection(), classSectionModule, academicYear, student));
                for (StaffModuleAttendance staffModuleAttendance : staffModuleAttendances) {
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentClass());
                    Hibernate.initialize((Object)staffModuleAttendance.getAcdemicYear());
                    Hibernate.initialize((Object)staffModuleAttendance.getSection());
                    Hibernate.initialize((Object)staffModuleAttendance.getClassSectionModule());
                    if (staffModuleAttendance.getAcdemicYear().getAcademicYearId() != academicYear.getAcademicYearId() || staffModuleAttendance.getStudentClass().getClassId() != student.getStudentClass().getClassId() || staffModuleAttendance.getSection().getSectionId() != student.getSection().getSectionId() || staffModuleAttendance.getClassSectionModule().getClassSectionModuleId() != classSectionModule.getClassSectionModuleId()) continue;
                    Hibernate.initialize((Object)staffModuleAttendance.getStudentAttendanceType());
                    if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 1L) {
                        precentCount = precentCount + 1;
                        continue;
                    }
                    if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() == 2L) {
                        absentCount = absentCount + 1;
                        continue;
                    }
                    if (staffModuleAttendance.getStudentAttendanceType().getStudentAttendaceTypeId() != 3L) continue;
                    ondutyCount = ondutyCount + 1;
                }
                Double percentile = (double)(precentCount + ondutyCount) / (double)totalWorkingDays.longValue();
                Double percentage = percentile * 100.0;
                if (!percentage.isNaN()) {
                    percentageWithSymbol = df.format(percentage).concat("%");
                }
                sevenFieldReports.add(new SevenFieldReports(moduleCode, moduleName, precentCount, absentCount, ondutyCount, totalWorkingDays, percentageWithSymbol));
            }
            return sevenFieldReports;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffException(new Message("nullpointer", e.getMessage()));
            }
            e.printStackTrace();
            throw e;
        }
    }
}
