/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.StudentAttendanceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceService;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceTypeService;
import in.jdsoft.educationmanagement.school.services.StudentMovementRequisitionService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="studentAttendanceController")
@RequestMapping(value={"/studentattendance"})
public class StudentAttendanceController {
    private Logger log = LogManager.getLogger((String)StudentAttendanceController.class.getName());
    @Autowired
    private ClassService classService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentAttendanceService studentAttendanceService;
    @Autowired
    private StudentAttendanceTypeService studentAttendanceTypeService;
    @Autowired
    private AcademicYearService acdemicYearService;
    @Autowired
    private InstitutionService institutionServices;
    @Autowired
    private StudentMovementRequisitionService studentMovementRequisitionService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayStudentAttendancePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student attendance page"));
            ModelAndView modelandview = new ModelAndView("studentattendance");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classes", this.classService.classList(institutionId));
            modelandview.addObject("studentMovementRequestApprovedLists", this.studentMovementRequisitionService.studentMovementRequestApprovedListByInstitutionAndDate(institutionId, formatter.parse(formatter.format(new Date()))));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/managestudentattendancereport"})
    public ModelAndView displayModuleAttendanceReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student attendance report page"));
            ModelAndView modelandview = new ModelAndView("managestudentattendancereport");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classes", this.classService.classList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/managestudentattendancereport/retreiveDateAttendanceDetails"})
    @ResponseBody
    public ArrayList<StudentAttendance> retrieveParticularClassAndSectionStudentAttendanceRetrieve(HttpServletRequest request) throws Exception {
        try {
            ArrayList<StudentAttendance> studentAttendanceList = new ArrayList<StudentAttendance>();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular Class And Section Student Attendance List"));
            Long classId = Long.parseLong(request.getParameter("class"));
            Class classs = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("section"));
            Section section = this.sectionService.sectionById(sectionId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String date = request.getParameter("attendanceDate");
            Date attendanceDate = formatter.parse(date);
            studentAttendanceList.addAll(this.studentAttendanceService.studentAttendanceByClassAndSectionAndDateAttendanceEager(classs, section, attendanceDate));
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/managestudentattendancereport/deleteAll"})
    public String deleteAllStudentAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has delete student attendance"));
            String deleteStaffModuleAttendanceIds = request.getParameter("selectedStudentAttendanceIds");
            String[] selectStudents = deleteStaffModuleAttendanceIds.split(",");
            Long[] deleteAttendanceIds = new Long[selectStudents.length];
            Integer count = 0;
            int i = 0;
            while (i < selectStudents.length) {
                Integer n = count;
                count = n + 1;
                deleteAttendanceIds[n.intValue()] = Long.parseLong(selectStudents[i]);
                ++i;
            }
            this.studentAttendanceService.deleteAllStudentAttendance(deleteAttendanceIds);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Attendance Deleted Successfully...!"));
            return "redirect:/studentattendance/managestudentattendancereport";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/studentattendance/managestudentattendancereport";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/managestudentattendancereport/retreiveModuleAttendance"})
    @ResponseBody
    public StudentAttendance retreiveStudentAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has retreive student attendance"));
            Long studentAttendanceId = Long.parseLong(request.getParameter("studentAttendanceId"));
            StudentAttendance studentAttendance = null;
            studentAttendance = this.studentAttendanceService.studentAttendanceByIdEager(studentAttendanceId);
            return studentAttendance;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/managestudentattendancereport/update"})
    public String updateStudentAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has update existing student attendance"));
            String[] studentAttendanceIds = request.getParameter("updateStudentAttendanceId").split(",");
            studentAttendanceIds = (String[])Arrays.stream(studentAttendanceIds).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            StudentAttendance studentAttendance = null;
            String[] stringArray = studentAttendanceIds;
            int n = studentAttendanceIds.length;
            int n2 = 0;
            while (n2 < n) {
                String studentAttendanceId = stringArray[n2];
                String[] studentAndAttendanceIds = studentAttendanceId.split("-");
                Long attendanceId = Long.parseLong(studentAndAttendanceIds[0]);
                Long studentAttendanceTypeId = Long.parseLong(studentAndAttendanceIds[1]);
                String dayAttendanceType = studentAndAttendanceIds[2].trim();
                StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeService.studentAttendanceTypeById(studentAttendanceTypeId);
                studentAttendance = this.studentAttendanceService.studentAttendanceByIdEager(attendanceId);
                studentAttendance.setStudentAttendanceType(studentAttendanceType);
                studentAttendance.setDayAttendanceType(dayAttendanceType);
                ++n2;
            }
            this.studentAttendanceService.updateStudentAttendance(studentAttendance);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Attendance Updated"));
            return "redirect:/studentattendance/managestudentattendancereport";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/studentattendance/managestudentattendancereport";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"add"})
    public String addStudentAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student attendance page"));
            ArrayList<StudentAttendance> studentAttendanceList = new ArrayList<StudentAttendance>();
            String studentAttendanceCombinations = request.getParameter("attendanceStudentId");
            String[] studentAttendanceCombinationArray = studentAttendanceCombinations.split(",");
            Long studentId = null;
            Long studentAttendanceTypeId = null;
            String date = request.getParameter("attendanceDate");
            String time = request.getParameter("attendanceTime");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date d1 = format.parse(time);
            Time attendanceTime = new Time(d1.getTime());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date studentAttendanceDate = formatter.parse(date);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionServices.institutionById(institutionId);
            AcademicYear academicYear = this.acdemicYearService.getActiveAcademicYear();
            String[] stringArray = studentAttendanceCombinationArray;
            int n = studentAttendanceCombinationArray.length;
            int n2 = 0;
            while (n2 < n) {
                String studentAttendanceCombination = stringArray[n2];
                String[] studentAndAttendanceId = studentAttendanceCombination.split("-");
                studentId = Long.parseLong(studentAndAttendanceId[0].trim());
                studentAttendanceTypeId = Long.parseLong(studentAndAttendanceId[1].trim());
                String dayAttendnaceType = studentAndAttendanceId[2].trim();
                Student student = this.studentService.studentByIdEager(studentId);
                Class studentClass = student.getStudentClass();
                Section section = student.getSection();
                StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeService.studentAttendanceTypeById(studentAttendanceTypeId);
                StudentAttendance studentAttendance = new StudentAttendance(student, studentClass, section, academicYear, studentAttendanceDate, attendanceTime, studentAttendanceType, institution, dayAttendnaceType);
                studentAttendanceList.add(studentAttendance);
                ++n2;
            }
            this.studentAttendanceService.addStudentAttendance(studentAttendanceList);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Attendance Marked Successfully...!"));
            return "redirect:/studentattendance";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentAttendanceException.class)) {
                StudentAttendanceException sae = (StudentAttendanceException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)sae.getCustomMessage());
                return "redirect:/studentattendance";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Attendance Cannot Be Marked...!"));
            e.printStackTrace();
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/studentattendance";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStudentAttendanceByOverAllDateWise"})
    @ResponseBody
    public SevenFieldReports viewStudentAttendanceRetrieveByOverAllDateWise(HttpServletRequest request) throws Exception {
        try {
            SevenFieldReports sevenFieldReports = null;
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student Attendance List"));
            String studentEmail = request.getSession().getAttribute("username").toString();
            Long academicYearId = Long.parseLong(request.getParameter("overAllAcademicYearId"));
            AcademicYear academicYear = this.acdemicYearService.academicYearById(academicYearId);
            sevenFieldReports = this.studentAttendanceService.overAllStudentAttendanceByAcademicYearAndStudentEmail(academicYear, studentEmail);
            return sevenFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStudentAttendanceByMonth"})
    @ResponseBody
    public ArrayList<StudentAttendance> viewStudentAttendanceRetrieveByMonth(HttpServletRequest request) throws Exception {
        try {
            ArrayList studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student Attendance List"));
            String studentEmail = request.getSession().getAttribute("username").toString();
            String reportType = request.getParameter("studentReportType");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionServices.institutionById(institutionId);
            if (reportType.equals("monthly")) {
                String monthDate = request.getParameter("studentMonthDate");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                Date attendanceMonthDate = formatter.parse(monthDate);
                studentAttendanceList = (ArrayList)this.studentAttendanceService.studentAttendanceByStudentEmailAndAttendanceMonthEager(studentEmail, institution, attendanceMonthDate);
            } else if (reportType.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = request.getParameter("studentFromDate");
                String endDate = request.getParameter("studentToDate");
                Date attendanceStartDate = formatter.parse(startDate);
                Date attendanceEndDate = formatter.parse(endDate);
                studentAttendanceList = (ArrayList)this.studentAttendanceService.studentAttendanceByAttendanceStartDateAndEndDateAndStudentEmail(studentEmail, institution, attendanceStartDate, attendanceEndDate);
            }
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStudentAttendanceByAcademicYearAndClassAndSection"})
    @ResponseBody
    public List<SevenFieldReports> retrieveParticularAcademicYearAndClassAndSectionStudentAttendanceRetrieve(HttpServletRequest request) throws Exception {
        try {
            ArrayList<SevenFieldReports> studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular AcademicYear And Class And Section Student Attendance List"));
            Long classId = Long.parseLong(request.getParameter("overAllClassId"));
            Class classs = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("overAllSectionId"));
            Section section = this.sectionService.sectionById(sectionId);
            Long academicYearId = Long.parseLong(request.getParameter("overAllAcademicYearId"));
            AcademicYear academicYear = this.acdemicYearService.academicYearById(academicYearId);
            studentAttendanceList = this.studentService.studentListByAcademicYearAndClassAndSection(classs, section, academicYear);
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveClassAndSectionStudentAttendanceByMonth"})
    @ResponseBody
    public ArrayList<Student> retrieveParticularClassAndSectionStudentAttendanceRetrieveByMonth(HttpServletRequest request) throws Exception {
        try {
            ArrayList studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular Class And Section Student Attendance List"));
            String reportType = request.getParameter("reportType");
            Long classId = Long.parseLong(request.getParameter("classId"));
            Class classs = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            Section section = this.sectionService.sectionById(sectionId);
            if (reportType.equals("monthly")) {
                String monthDate = request.getParameter("monthDate");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                Date attendanceMonthDate = formatter.parse(monthDate);
                studentAttendanceList = (ArrayList)this.studentService.studentListByClassAndSectionAndAttendanceMonthEager(classs, section, attendanceMonthDate);
            } else if (reportType.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = request.getParameter("fromDate");
                String endDate = request.getParameter("toDate");
                Date attendanceStartDate = formatter.parse(startDate);
                Date attendanceEndDate = formatter.parse(endDate);
                studentAttendanceList = (ArrayList)this.studentService.studenListByClassAndSectionAndAttendanceFromDateAndToDateEager(classs, section, attendanceStartDate, attendanceEndDate);
            }
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveClassSectionModuleAndStudentAttendanceByMonth"})
    @ResponseBody
    public ArrayList<Student> retrieveParticularClassSectionModuleAndStudentAttendanceRetrieveByMonth(HttpServletRequest request) throws Exception {
        try {
            ArrayList studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular ClassSectionModule Student Attendance List"));
            String reportType = request.getParameter("reportType");
            Long classSectionModuleId = Long.parseLong(request.getParameter("classSectionModuleId"));
            if (reportType.equals("monthly")) {
                String monthDate = request.getParameter("monthDate");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                Date attendanceMonthDate = formatter.parse(monthDate);
                studentAttendanceList = (ArrayList)this.studentService.activeStudentListByClassSectionModuleAndAttendanceMonthEager(classSectionModuleId, attendanceMonthDate);
            } else if (reportType.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = request.getParameter("fromDate");
                String endDate = request.getParameter("toDate");
                Date attendanceStartDate = formatter.parse(startDate);
                Date attendanceEndDate = formatter.parse(endDate);
                studentAttendanceList = (ArrayList)this.studentService.activeStudentListByClassSectionModuleIdAndAttendanceFromDateAndToDateEager(classSectionModuleId, attendanceStartDate, attendanceEndDate);
            }
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/bulkupload"})
    public String addBulkStudentAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="studentAttendanceExcelfile") MultipartFile studentAttendanceExcelfile) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " added student Attendance "));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.studentAttendanceService.studentAttendanceBulkUpload(studentAttendanceExcelfile, institutionId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Attendance Upload Successfully...!"));
            return "redirect:/studentattendance";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentAttendanceException.class)) {
                StudentAttendanceException studentAttendanceException = (StudentAttendanceException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentAttendanceException.getCustomMessage());
                return "redirect:/studentattendance";
            }
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return "redirect:/studentattendance";
        }
    }

    @RequestMapping(value={"/studentAttendanceExcelFormat"}, method={RequestMethod.POST})
    public ModelAndView downloadStaffAttendnaceExcelFormat(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return new ModelAndView("studentDayAttendanceDetails", "studentList", this.studentService.studentList(institutionId));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
