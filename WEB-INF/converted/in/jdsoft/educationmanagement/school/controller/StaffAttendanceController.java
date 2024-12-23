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

import in.jdsoft.educationmanagement.school.exceptions.StaffAttendanceException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.StaffAttendanceConfigurationService;
import in.jdsoft.educationmanagement.school.services.StaffAttendanceService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller(value="staffAttendanceController")
@RequestMapping(value={"/staffattendance"})
public class StaffAttendanceController {
    private Logger log = LogManager.getLogger((String)StaffAttendanceController.class.getName());
    @Autowired
    StaffAttendanceConfigurationService staffAttendanceConfigurationService;
    @Autowired
    InstitutionService insititutionService;
    @Autowired
    StaffAttendanceService staffAttendanceService;
    @Autowired
    StaffService staffService;

    @RequestMapping(method={RequestMethod.GET}, value={"/configuration"})
    public ModelAndView displayStaffAttendanceConfigurationPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff attendance configuration page"));
            ModelAndView modelandview = new ModelAndView("staffattendanceconfiguration");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("staffattendanceconfiguration", (Object)this.staffAttendanceConfigurationService.staffAttendanceConfiguration(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/configuration/save"})
    public String saveOrUpdate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " creating or updating Staff Attendance configuration"));
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            String startTime = request.getParameter("start_time");
            String endTime = request.getParameter("end_time");
            String enablePermission = request.getParameter("enable_permission_hours");
            String enableLeave = request.getParameter("enable_leave_permission");
            Time startingWorkTime = null;
            Time closingWorkTime = null;
            boolean enablePermissionHours = false;
            boolean enableLeaveDays = false;
            double monthlyPermissionHours = 0.0;
            double monthlyleaveDays = 0.0;
            boolean permissionCarryForward = false;
            boolean leaveCarryForward = false;
            if (!startTime.isEmpty()) {
                startingWorkTime = new Time(formatter.parse(startTime).getTime());
            }
            if (!endTime.isEmpty()) {
                closingWorkTime = new Time(formatter.parse(endTime).getTime());
            }
            if (!enablePermission.isEmpty() && (enablePermissionHours = Boolean.parseBoolean(enablePermission))) {
                monthlyPermissionHours = Double.parseDouble(request.getParameter("no_of_permission_hours"));
                permissionCarryForward = Boolean.parseBoolean(request.getParameter("permission_hours_carry_forward"));
            }
            if (!enableLeave.isEmpty() && (enableLeaveDays = Boolean.parseBoolean(enableLeave))) {
                monthlyleaveDays = Double.parseDouble(request.getParameter("no_of_leaves"));
                leaveCarryForward = Boolean.parseBoolean(request.getParameter("leave_carry_forward"));
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.insititutionService.institutionById(institutionId);
            StaffAttendanceConfiguration staffAttendanceConfig = new StaffAttendanceConfiguration(startingWorkTime, closingWorkTime, enablePermissionHours, enableLeaveDays, monthlyPermissionHours, monthlyleaveDays, permissionCarryForward, leaveCarryForward, institution);
            this.staffAttendanceConfigurationService.update(staffAttendanceConfig);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Attendance Configured Successfully...!"));
            return "redirect:/staffattendance/configuration";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Cannot Be Done...!"));
            e.printStackTrace();
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/staffattendance/configuration";
        }
    }

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayStaffAttendancePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff attendance  page"));
            ModelAndView modelandview = new ModelAndView("staffattendance");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            modelandview.addObject("punchDetails", this.staffAttendanceService.staffsPunchDetails(dateFormat.parse(dateFormat.format(date))));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/punch"})
    public String addPunch(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " added punch time"));
            String staffCode = request.getParameter("staffCode");
            this.staffAttendanceService.addPunch(staffCode);
            return "redirect:/staffattendance";
        }
        catch (Exception e) {
            if (e.getClass().equals(StaffAttendanceException.class)) {
                StaffAttendanceException staffAttendanceException = (StaffAttendanceException)e;
                redirectAttributes.addFlashAttribute("errorMessage", (Object)staffAttendanceException.getCustomMessage());
                return "redirect:/staffattendance";
            }
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/bulkupload"})
    public String addBulkStaffAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="staffAttendanceExcelfile") MultipartFile staffAttendanceExcelfile) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " added staff Attendance "));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.staffAttendanceService.staffAttendanceBulkUpload(staffAttendanceExcelfile, institutionId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Attendance Upload Successfully...!"));
            return "redirect:/staffattendance";
        }
        catch (Exception e) {
            if (e.getClass().equals(StaffAttendanceException.class)) {
                StaffAttendanceException staffAttendanceException = (StaffAttendanceException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)staffAttendanceException.getCustomMessage());
                return "redirect:/staffattendance";
            }
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return "redirect:/staffattendance";
        }
    }

    @RequestMapping(value={"/staffAttendanceExcelFormat"}, method={RequestMethod.POST})
    public ModelAndView downloadStaffAttendnaceExcelFormat(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return new ModelAndView("staffAttendanceDetails", "staffList", this.staffService.staffList(institutionId));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStaffAttendanceByMonth"})
    @ResponseBody
    public Staff viewStaffAttendanceRetrieveByMonth(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Staff Attendance List"));
            String staffEmail = request.getSession().getAttribute("username").toString();
            String monthDate = request.getParameter("monthDate");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
            Date attendanceMonthDate = formatter.parse(monthDate);
            Staff staff = this.staffService.staffAttendanceByStaffEmailAndAttendanceMonthEager(staffEmail, attendanceMonthDate);
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStaffAttendanceByStaffCode"})
    @ResponseBody
    public Staff viewStaffAttendanceRetrieveByStaffCode(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Staff Attendance List"));
            String staffCode = request.getParameter("staffCode");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            Staff staff = this.staffService.staffByStaffCodeAndDate(staffCode, dateFormat.parse(dateFormat.format(date)));
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
