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
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.controller.ExamController;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SickRoomVisitorService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="sickRoomVisitorController")
@RequestMapping(value={"/sickroomvisitor"})
public class SickRoomVisitorController {
    private Logger log = LogManager.getLogger((String)ExamController.class.getName());
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private SickRoomVisitorService sickRoomVisitorService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayVisitorPage(HttpServletRequest request) throws Exception {
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has sick room visitor page"));
        ModelAndView modelandview = new ModelAndView("sickroomvisitor");
        modelandview.addObject("sickRoomVisitorList", this.sickRoomVisitorService.sickRoomVisitorListEager());
        return modelandview;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/managesickroomvisitor"})
    public ModelAndView displayUserBasedVisitorPage(HttpServletRequest request) throws Exception {
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has user based sick room visitor page"));
        String email = request.getSession().getAttribute("username").toString();
        Staff staff = null;
        Student student = null;
        if (this.staffService.staffByEmailEager(email) != null) {
            staff = this.staffService.staffByEmailEager(email);
        } else if (this.studentService.studentByEmailEager(email) != null) {
            student = this.studentService.studentByEmailEager(email);
        }
        ModelAndView modelandview = new ModelAndView("managesickroomvisitor");
        if (student != null) {
            modelandview.addObject("sickRoomVisitorList", this.sickRoomVisitorService.sickRoomVisitorListByStudentEmail(email));
        } else if (staff != null) {
            modelandview.addObject("sickRoomVisitorList", this.sickRoomVisitorService.sickRoomVisitorListByStaffEmail(email));
        }
        modelandview.addObject("academicYears", this.academicYearService.academicYearList());
        return modelandview;
    }

    @RequestMapping(value={"/add"}, method={RequestMethod.POST})
    public String addSickRoomVisitor(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String createdBy = request.getSession().getAttribute("username").toString();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm");
            String studentOrStaffCode = request.getParameter("studentOrStaffCode");
            Staff staff = null;
            Student student = null;
            if (this.staffService.staffByStaffCode(studentOrStaffCode) != null) {
                staff = this.staffService.staffByStaffCode(studentOrStaffCode);
            } else if (this.studentService.studentByAdmissionNoEager(studentOrStaffCode) != null) {
                student = this.studentService.studentByAdmissionNoEager(studentOrStaffCode);
            }
            String reasonForVisit1 = request.getParameter("reasonForVisit1");
            String reasonForVisit2 = request.getParameter("reasonForVisit2");
            String reasonDescription = request.getParameter("reasonDescription");
            String actionTaken1 = request.getParameter("actionTaken1");
            String actionTaken2 = request.getParameter("actionTaken2");
            String actionDescription = request.getParameter("actionDescription");
            String requisitionDate = request.getParameter("requisitionDate");
            Date date = formatter.parse(requisitionDate);
            String inTime = request.getParameter("checkInTime");
            String outTime = request.getParameter("checkOutTime");
            SickRoomVisitor sickRoomVisitor = new SickRoomVisitor(reasonForVisit1, reasonForVisit2, reasonDescription, actionTaken1, actionTaken2, actionDescription, createdBy, createdBy, new Time(timeformatter.parse(inTime).getTime()), new Time(timeformatter.parse(outTime).getTime()), date, staff, student, institution, academicYear);
            this.sickRoomVisitorService.createSickRoomVisitor(sickRoomVisitor);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "SickRoom Visitor Information Added Successfully...!"));
            return "redirect:/sickroomvisitor";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/sickroomvisitor";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    public String deleteSickRoomVisitor(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long deleteSickRoomVisitorId = Long.parseLong(request.getParameter("deleteSickRoomVisitorId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting sick room visitor with id=" + deleteSickRoomVisitorId));
            this.sickRoomVisitorService.deleteSickRoomVisitor(deleteSickRoomVisitorId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "SickRoom Visitor Information Deleted Successfully...!"));
            return "redirect:/sickroomvisitor";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/sickroomvisitor";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/managesickroomvisitor/academicYear"})
    @ResponseBody
    public List<SickRoomVisitor> displaySickRoomVisitorByAcademicYearPage(HttpServletRequest request) throws Exception {
        try {
            ArrayList<SickRoomVisitor> sickRoomVisitorList = new ArrayList<SickRoomVisitor>();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has sick room visitor by academic year page"));
            Long academicYearId = Long.parseLong(request.getParameter("academicYearId").toString());
            String email = request.getSession().getAttribute("username").toString();
            if (this.staffService.staffByEmailEager(email) != null) {
                sickRoomVisitorList.addAll(this.sickRoomVisitorService.sickRoomVisitorListByStaffEmailAndAcademicYear(email, academicYearId));
            } else if (this.studentService.studentByEmailEager(email) != null) {
                sickRoomVisitorList.addAll(this.sickRoomVisitorService.sickRoomVisitorListByStudentEmailAndAcademicYear(email, academicYearId));
            }
            return sickRoomVisitorList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
