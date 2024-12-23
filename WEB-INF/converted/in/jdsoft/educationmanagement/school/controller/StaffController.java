/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.components.SMSHandler;
import in.jdsoft.educationmanagement.school.controller.StaffDesignationController;
import in.jdsoft.educationmanagement.school.exceptions.SMSGatewayDetailsException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.model.StaffBankDetail;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffLeaveType;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.reports.model.SevenFieldReports;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassSectionAssessmentTypeService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamActivityService;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.DocumentService;
import in.jdsoft.educationmanagement.school.services.DocumentTypeService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.MeetingRequisitionService;
import in.jdsoft.educationmanagement.school.services.ModuleService;
import in.jdsoft.educationmanagement.school.services.RequisitionTypeService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.StaffAppraisalService;
import in.jdsoft.educationmanagement.school.services.StaffBankDetailService;
import in.jdsoft.educationmanagement.school.services.StaffDesignationService;
import in.jdsoft.educationmanagement.school.services.StaffExperienceDetailService;
import in.jdsoft.educationmanagement.school.services.StaffLeaveRequisitionService;
import in.jdsoft.educationmanagement.school.services.StaffLeaveTypeService;
import in.jdsoft.educationmanagement.school.services.StaffModuleAttendanceService;
import in.jdsoft.educationmanagement.school.services.StaffModuleWiseMarkSystemService;
import in.jdsoft.educationmanagement.school.services.StaffMovementRequisitionService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceTypeService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.TCRequisitionService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="staffController")
@RequestMapping(value={"/staff"})
public class StaffController {
    private Logger log = LogManager.getLogger((String)StaffDesignationController.class.getName());
    @Autowired
    StaffService staffService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    GeographicalLocationService geographicalLocationService;
    @Autowired
    StaffTypeService staffTypeService;
    @Autowired
    StaffDesignationService staffDesignationService;
    @Autowired
    UserService userService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    BloodGroupService bloodGroupService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    HashGenerator hashGenerator;
    @Autowired
    FileUploadHandler fileUploadHandler;
    @Autowired
    ModuleService moduleService;
    @Autowired
    StudentAttendanceTypeService studentAttendanceTypeService;
    @Autowired
    StaffBankDetailService staffBankDetailService;
    @Autowired
    StaffExperienceDetailService staffExperienceDetailService;
    @Autowired
    StudentService studentServices;
    @Autowired
    StaffModuleAttendanceService staffModuleAttendanceService;
    @Autowired
    ClassSectionModuleService classSectionModuleService;
    @Autowired
    AcademicYearService academicYearServices;
    @Autowired
    StaffLeaveRequisitionService staffLeaveRequisitionService;
    @Autowired
    StaffLeaveTypeService staffLeaveTypeService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ClassSectionAssessmentTypeService classSectionAssessmentTypeService;
    @Autowired
    private ClassSectionTermExamService classSectionTermExamService;
    @Autowired
    private ClassSectionTermExamActivityService classSectionTermExamActivityService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private ClassSectionService classSectionService;
    @Autowired
    private StaffModuleWiseMarkSystemService StaffModuleWiseMarkSystemService;
    @Autowired
    private RequisitionTypeService requisitionTypeService;
    @Autowired
    private TCRequisitionService tcRequisitionService;
    @Autowired
    private StaffMovementRequisitionService staffMovementRequisitionService;
    @Autowired
    private MeetingRequisitionService meetingRequisitionService;
    @Autowired
    private StaffAppraisalService staffAppraisalService;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private SMSHandler smsHandler;
    @Autowired
    private DocumentService documentService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayStaffPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff page"));
            ModelAndView modelandview = new ModelAndView("managestaff");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("categories", this.categoryService.categoryList());
            modelandview.addObject("countries", this.geographicalLocationService.countryList());
            modelandview.addObject("staffs", this.staffService.staffListEager(institutionId));
            modelandview.addObject("staffTypes", this.staffTypeService.staffTypeList());
            modelandview.addObject("approvers", this.userService.allStaffApproversLists());
            modelandview.addObject("userRoles", this.userRoleService.userRolesForSuperStaffsOrStaffs(institutionId));
            modelandview.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            modelandview.addObject("staffDesignations", this.staffDesignationService.staffDesignationList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/timetable"})
    public ModelAndView displayStaffTimeTablePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff timetable page"));
            ModelAndView modelandview = new ModelAndView("stafftimetable");
            String staffEmail = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(staffEmail);
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/feesdashboard"})
    public ModelAndView displayFeesAdminPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed fees dashboard page"));
            ModelAndView modelandview = new ModelAndView("charts");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staffappraisal"})
    public ModelAndView displayStaffAppraisalPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff appraisal page"));
            ModelAndView modelandview = new ModelAndView("staffappraisal");
            modelandview.addObject("staffList", this.staffService.staffList());
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/transactiondetails"})
    public ModelAndView displayTransactionDetailsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed transaction page"));
            ModelAndView modelandview = new ModelAndView("transactiondetails");
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/checksmsbalance"}, method={RequestMethod.GET})
    @ResponseBody
    public String checkSMSBalance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String str = this.smsHandler.checkSMSBalance(institutionId);
            return str;
        }
        catch (Exception e) {
            if (e.getClass().equals(SMSGatewayDetailsException.class)) {
                SMSGatewayDetailsException ee = (SMSGatewayDetailsException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)ee.getCustomMessage());
                return null;
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Error..!"));
            return null;
        }
    }

    @RequestMapping(value={"/addStaffAppraisal"}, method={RequestMethod.POST})
    public String addStaffAppraisal(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String staffCode = request.getParameter("staffCode");
            String appraisalTerm = request.getParameter("appraisalTerm");
            String relationshipRating = request.getParameter("relationshipRating");
            String relationshipComments = request.getParameter("relationshipComments");
            String teachingRating = request.getParameter("teachingRating");
            String teachingComments = request.getParameter("teachingComments");
            String researchAndHigherQualificationRating = request.getParameter("researchAndHigherQualificationRating");
            String researchAndHigherQualificationComments = request.getParameter("researchAndHigherQualificationComments");
            String initiativeAndOrganizationRating = request.getParameter("initiativeAndOrganizationRating");
            String initiativeAndOrganizationComments = request.getParameter("initiativeAndOrganizationComments");
            String innovationRating = request.getParameter("innovationRating");
            String innovationComments = request.getParameter("innovationComments");
            String punctualityRating = request.getParameter("punctualityRating");
            String punctualityComments = request.getParameter("punctualityComments");
            String goalAlignmentRating = request.getParameter("goalAlignmentRating");
            String goalAlignmentcomments = request.getParameter("goalAlignmentcomments");
            String recommendations = request.getParameter("recommendations");
            String appraisalStatus = request.getParameter("appraisalStatus");
            String appraisalCreatedByUser = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByStaffCode(staffCode);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            StaffAppraisal staffAppraisal = new StaffAppraisal(appraisalTerm, relationshipRating, relationshipComments, teachingRating, teachingComments, researchAndHigherQualificationRating, researchAndHigherQualificationComments, initiativeAndOrganizationRating, initiativeAndOrganizationComments, innovationRating, innovationComments, punctualityRating, punctualityComments, goalAlignmentRating, goalAlignmentcomments, appraisalCreatedByUser, recommendations, appraisalStatus, staff, academicYear, institution, appraisalCreatedByUser, appraisalCreatedByUser);
            this.staffAppraisalService.createStaffAppraisal(staffAppraisal);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Appraisal Created Successfully...!"));
            return "redirect:/staff/staffappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/staff/staffappraisal";
        }
    }

    @RequestMapping(value={"/getStaffAppraisalList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StaffAppraisal> getStaffAppraisalList(HttpServletRequest request) throws ServletException, IOException {
        List<Object> staffAppraisalList = new ArrayList();
        try {
            String academicYear = request.getParameter("academicYearId");
            String staffCode = request.getParameter("getStaffCode");
            if (staffCode != null && !staffCode.isEmpty()) {
                if (this.staffAppraisalService.staffAppraisalListByStaffCode(staffCode) != null) {
                    staffAppraisalList = this.staffAppraisalService.staffAppraisalListByStaffCode(staffCode);
                }
            } else if (academicYear.equals("all")) {
                staffAppraisalList = this.staffAppraisalService.staffAppraisalList();
            } else {
                Long academicYearId = Long.parseLong(academicYear);
                if (this.staffAppraisalService.staffAppraisalListByAcademicYear(academicYearId) != null) {
                    staffAppraisalList.addAll(this.staffAppraisalService.staffAppraisalListByAcademicYear(academicYearId));
                }
            }
            return staffAppraisalList;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/editStaffAppraisal"}, method={RequestMethod.GET})
    @ResponseBody
    public StaffAppraisal editStaffAppraisal(HttpServletRequest request) {
        try {
            Long staffAppraisalId = Long.parseLong(request.getParameter("staffAppraisalId"));
            StaffAppraisal staffAppraisal = this.staffAppraisalService.staffAppraisalById(staffAppraisalId);
            return staffAppraisal;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/updateStaffAppraisal"}, method={RequestMethod.POST})
    public String updateStaffAppraisal(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String editStaffCode = request.getParameter("editStaffId");
            String editAppraisalTerm = request.getParameter("editAppraisalTerm");
            String editRelationshipRating = request.getParameter("editRelationshipRating");
            String editRelationshipComments = request.getParameter("editRelationshipComments");
            String editTeachingRating = request.getParameter("editTeachingRating");
            String editTeachingComments = request.getParameter("editTeachingComments");
            String editResearchAndHigherQualificationRating = request.getParameter("editResearchAndHigherQualificationRating");
            String editResearchAndHigherQualificationComments = request.getParameter("editResearchAndHigherQualificationComments");
            String editInitiativeAndOrganizationRating = request.getParameter("editInitiativeAndOrganizationRating");
            String editInitiativeAndOrganizationComments = request.getParameter("editInitiativeAndOrganizationComments");
            String editInnovationRating = request.getParameter("editInnovationRating");
            String editInnovationComments = request.getParameter("editInnovationComments");
            String editPunctualityRating = request.getParameter("editPunctualityRating");
            String editPunctualityComments = request.getParameter("editPunctualityComments");
            String editGoalAlignmentRating = request.getParameter("editGoalAlignmentRating");
            String editGoalAlignmentcomments = request.getParameter("editGoalAlignmentcomments");
            String editRecommendations = request.getParameter("editRecommendations");
            String editAppraisalStatus = request.getParameter("editAppraisalStatus");
            String appraisalCreatedByUser = request.getSession().getAttribute("username").toString();
            Long staffAppraisalId = Long.parseLong(request.getParameter("updateStaffAppraisalId"));
            Staff staff = this.staffService.staffByStaffCode(editStaffCode);
            StaffAppraisal staffAppraisal = this.staffAppraisalService.staffAppraisalById(staffAppraisalId);
            staffAppraisal.setAppraisalTerm(editAppraisalTerm);
            staffAppraisal.setRelationshipRating(editRelationshipRating);
            staffAppraisal.setRelationshipComments(editRelationshipComments);
            staffAppraisal.setTeachingRating(editTeachingRating);
            staffAppraisal.setTeachingComments(editTeachingComments);
            staffAppraisal.setResearchAndHigherQualificationRating(editResearchAndHigherQualificationRating);
            staffAppraisal.setResearchAndHigherQualificationComments(editResearchAndHigherQualificationComments);
            staffAppraisal.setInitiativeAndOrganizationRating(editInitiativeAndOrganizationRating);
            staffAppraisal.setInitiativeAndOrganizationComments(editInitiativeAndOrganizationComments);
            staffAppraisal.setInnovationRating(editInnovationRating);
            staffAppraisal.setInnovationComments(editInnovationComments);
            staffAppraisal.setPunctualityRating(editPunctualityRating);
            staffAppraisal.setPunctualityComments(editPunctualityComments);
            staffAppraisal.setGoalAlignmentRating(editGoalAlignmentRating);
            staffAppraisal.setGoalAlignmentComments(editGoalAlignmentcomments);
            staffAppraisal.setRecommendations(editRecommendations);
            staffAppraisal.setAppraisalStatus(editAppraisalStatus);
            staffAppraisal.setModifiedBy(appraisalCreatedByUser);
            staffAppraisal.setStaff(staff);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            staffAppraisal.setAcademicYear(academicYear);
            staffAppraisal.setInstitution(institution);
            this.staffAppraisalService.updateStaffAppraisal(staffAppraisal);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Appraisal Updated Successfully...!"));
            return "redirect:/staff/staffappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/staff/staffappraisal";
        }
    }

    @RequestMapping(value={"/staffappraisaldelete"}, method={RequestMethod.POST})
    public String deleteStaffAppraisal(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long deleteStaffAppraisalId = Long.parseLong(request.getParameter("deleteStaffAppraisalId"));
            this.staffAppraisalService.deleteStaffAppraisal(deleteStaffAppraisalId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Appraisal Deleted Successfully...!"));
            return "redirect:/staff/staffappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/staff/staffappraisal";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/attendancereport"})
    public ModelAndView displayAttendanceReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed attendance report page"));
            ModelAndView modelandview = new ModelAndView("attendancereport");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/attendancepercentagereport"})
    public ModelAndView displayAttendancePercentageReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed attendance percentage report page"));
            ModelAndView modelandview = new ModelAndView("attendancepercentagereport");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/tcapprovedreport"})
    public ModelAndView displayTransferCertificateApprovedReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed transfer certificate approved report page"));
            ModelAndView modelandview = new ModelAndView("tcapprovedreport");
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            modelandview.addObject("classes", this.classService.classList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/tcapprovedlist/reports"})
    public ModelAndView displayStaffViewTransferCertificateApprovedReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed transfer certificate approved report page"));
            String email = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(email);
            LinkedHashSet<Class> classList = new LinkedHashSet<Class>();
            if (staff != null) {
                for (ClassSection classSection : staff.getClassSections()) {
                    if (this.classService.classById(classSection.getClassSection().getClassId()) == null) continue;
                    classList.add(this.classService.classById(classSection.getClassSection().getClassId()));
                }
            }
            ModelAndView modelandview = new ModelAndView("tcapprovedreportbystaff");
            modelandview.addObject("classes", classList);
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/charts"})
    public ModelAndView displayChartsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed charts page"));
            ModelAndView modelandview = new ModelAndView("charts");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/feescharts"})
    public ModelAndView displayAdminFeesChartsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed charts page"));
            ModelAndView modelandview = new ModelAndView("feescharts");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            modelandview.addObject("institution", (Object)this.institutionService.institutionById(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/charts/{id}"})
    public ModelAndView displayFeesChartsPage(HttpServletRequest request, @PathVariable(value="id") Long instituteId) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed charts page"));
            ModelAndView modelandview = new ModelAndView("institutionfeescharts");
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("academicYearList", this.academicYearService.academicYearList());
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            modelandview.addObject("institution", (Object)this.institutionService.institutionById(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/inventorycharts"})
    public ModelAndView displayInventoryChartsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed inventory charts page"));
            ModelAndView modelandview = new ModelAndView("inventorycharts");
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/inventorycharts/{id}"})
    public ModelAndView displayDashboardInventoryChartsPage(HttpServletRequest request, @PathVariable(value="id") Long instituteId) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed inventory charts page"));
            ModelAndView modelandview = new ModelAndView("inventorycharts");
            modelandview.addObject("institution", (Object)this.institutionService.institutionById(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/moduleattendancereport"})
    public ModelAndView displayModuleAttendanceReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed module attendance report page"));
            ModelAndView modelandview = new ModelAndView("moduleattendancereport");
            String staffEmail = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(staffEmail);
            modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/moduleattendancepercentagereport"})
    public ModelAndView displayModuleAttendancePercentageReportPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed module attendance percentage report page"));
            ModelAndView modelandview = new ModelAndView("moduleattendancepercentagereport");
            String staffEmail = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(staffEmail);
            modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/profile"})
    public ModelAndView displayStaffProfilePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff profile page"));
            ModelAndView modelandview = new ModelAndView("staffprofile");
            String staffEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("staff", (Object)this.staffService.staffByEmailEager(staffEmail));
            modelandview.addObject("countries", this.geographicalLocationService.countryList());
            modelandview.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    public String createStaff(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="documents") MultipartFile[] documents, @RequestParam(value="staffProfilePic") MultipartFile multipartFile) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create staff"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String staffCode = request.getParameter("staffCode");
            String firstName = request.getParameter("staffFirstName");
            String lastName = request.getParameter("staffLastName");
            String gender = request.getParameter("staffGender");
            Date dateOfBirth = formatter.parse(request.getParameter("staffDOB"));
            String contact = request.getParameter("staffContact");
            String eMail = request.getParameter("staffEmail");
            String accessNo = request.getParameter("staffAccessId");
            String parentOrGuardianFirstName = request.getParameter("staffParentOrGuardianFirstName");
            String parentOrGuardianLastName = request.getParameter("staffParentOrGuardianLastName");
            String staffAddressLine1 = request.getParameter("staffAddressLine1");
            String staffAddressLine2 = request.getParameter("staffAddressLine2");
            String country = request.getParameter("staffCountry");
            String state = request.getParameter("staffState");
            String city = request.getParameter("staffCity");
            String postCode = request.getParameter("staffPostCode");
            String staffPANNumber = request.getParameter("staffPANNo");
            String staffPFNumber = request.getParameter("staffPFAccountNo");
            Date joinedDate = null;
            if (request.getParameter("staffJoinedDate") != null && !request.getParameter("staffJoinedDate").isEmpty()) {
                joinedDate = formatter.parse(request.getParameter("staffJoinedDate"));
            }
            String createdBy = request.getSession().getAttribute("username").toString();
            Integer status = Integer.parseInt(request.getParameter("staffStatus"));
            BloodGroup bloodGroup = null;
            if (request.getParameter("staffBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("staffBloodGroupId")));
            }
            User approver = null;
            if (request.getParameter("approverId") != null) {
                Long userId = Long.parseLong(request.getParameter("approverId"));
                approver = this.userService.userById(userId);
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            StaffType staffType = null;
            if (request.getParameter("staffTypeId") != null) {
                Long staffTypeId = Long.parseLong(request.getParameter("staffTypeId"));
                staffType = this.staffTypeService.staffTypeById(staffTypeId);
            }
            StaffDesignation staffDesignation = null;
            if (request.getParameter("staffDesignationId") != null) {
                Long staffDesignationId = Long.parseLong(request.getParameter("staffDesignationId"));
                staffDesignation = this.staffDesignationService.staffDesignationById(staffDesignationId);
            }
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            String[] userRoleId = request.getParameterValues("userRoleId");
            HashSet<UserRole> userRoles = new HashSet<UserRole>();
            String[] stringArray = userRoleId;
            int n = userRoleId.length;
            int n2 = 0;
            while (n2 < n) {
                String roleId = stringArray[n2];
                userRoles.add(this.userRoleService.userRoleById(Long.parseLong(roleId)));
                ++n2;
            }
            String defaultPssword = "staff";
            String profilePath = null;
            profilePath = multipartFile != null && !multipartFile.isEmpty() ? this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", multipartFile.getOriginalFilename()) : "/resources/themes/images/profile-pic/a.png";
            String hash = this.hashGenerator.encoder(defaultPssword);
            User user = new User(userRoles, String.valueOf(firstName) + " " + lastName, eMail, defaultPssword, createdBy, status, hash, profilePath, institution);
            Staff staff = new Staff(staffCode, firstName, lastName, gender, dateOfBirth, contact, eMail, accessNo, parentOrGuardianFirstName, parentOrGuardianLastName, staffAddressLine1, staffAddressLine2, country, state, city, postCode, staffPANNumber, staffPFNumber, joinedDate, createdBy, status, bloodGroup, approver, user, institution, staffType, staffDesignation, category);
            String[] documentTypes = request.getParameterValues("documenttypes");
            String[] splitsDocumentType = null;
            String[] stringArray2 = documentTypes;
            int n3 = documentTypes.length;
            int n4 = 0;
            while (n4 < n3) {
                String olddocumentType = stringArray2[n4];
                splitsDocumentType = olddocumentType.split(",");
                splitsDocumentType = (String[])Arrays.stream(splitsDocumentType).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                ++n4;
            }
            int documenti = 0;
            LinkedHashSet<Document> staffdocuments = new LinkedHashSet<Document>();
            if (documents != null) {
                MultipartFile[] multipartFileArray = documents;
                int n5 = documents.length;
                int n6 = 0;
                while (n6 < n5) {
                    MultipartFile document = multipartFileArray[n6];
                    if (!document.isEmpty()) {
                        String picturePath = "";
                        if (document != null && !document.isEmpty()) {
                            picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-document/document/" + staff.getFirstName() + staff.getStaffCode() + "/", document.getOriginalFilename());
                        }
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                        }
                        DocumentType documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[documenti])));
                        Document documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                        System.out.println(document.getOriginalFilename());
                        documentnew.setStaff(staff);
                        staffdocuments.add(documentnew);
                        ++documenti;
                    }
                    ++n6;
                }
            }
            HashSet<StaffExperienceDetail> staffExperiences = new HashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("experience");
            if (experiences != null) {
                int i = 1;
                while (i <= experiences.length) {
                    String workedOrganisation = request.getParameter("organizationName" + i);
                    Double inPreviousExperience = Double.parseDouble(request.getParameter("workExp" + i));
                    Date startDate = formatter.parse(request.getParameter("staffESD" + i));
                    Date endDate = formatter.parse(request.getParameter("staffEED" + i));
                    String staffPreviousDesignation = request.getParameter("workDesignation" + i);
                    StaffExperienceDetail staffExperience = new StaffExperienceDetail(workedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, createdBy);
                    staffExperiences.add(staffExperience);
                    ++i;
                }
            }
            String bankName = request.getParameter("staffBankName");
            String bankAccountNo = null;
            if (request.getParameter("staffBankAccountNo") != null) {
                bankAccountNo = request.getParameter("staffBankAccountNo");
            }
            String bankIFSCCode = request.getParameter("staffBankIFSC");
            StaffBankDetail staffBankDetail = new StaffBankDetail(bankName, bankAccountNo, bankIFSCCode, createdBy);
            this.staffService.createStaffAndDocuments(staff, staffExperiences, staffBankDetail, staffdocuments);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Created Successfully...!"));
            return "redirect:/staff";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/staff";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    public String updateStaff(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="editStaffProfilePic") MultipartFile multipartFile, @RequestParam(value="documents") MultipartFile[] documents) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to update staff"));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long staffId = Long.parseLong(request.getParameter("updateStaffId"));
            Long userId = Long.parseLong(request.getParameter("updateUserId"));
            Long staffBankDetailId = Long.parseLong(request.getParameter("updateStaffBankDetailId"));
            String staffCode = request.getParameter("editStaffCode");
            String firstName = request.getParameter("editStaffFirstName");
            String lastName = request.getParameter("editStaffLastName");
            String gender = request.getParameter("editStaffGender");
            Date dateOfBirth = formatter.parse(request.getParameter("editStaffDOB"));
            String contact = request.getParameter("editStaffContact");
            String eMail = request.getParameter("editStaffEmail");
            String accessNo = request.getParameter("editStaffAccessId");
            String parentOrGuardianFirstName = request.getParameter("editStaffParentOrGuardianFirstName");
            String parentOrGuardianLastName = request.getParameter("editStaffParentOrGuardianLastName");
            String staffAddressLine1 = request.getParameter("editStaffAddressLine1");
            String staffAddressLine2 = request.getParameter("editStaffAddressLine2");
            String country = request.getParameter("editStaffCountry");
            String state = request.getParameter("editStaffState");
            String city = request.getParameter("editStaffCity");
            String postCode = request.getParameter("editStaffPostCode");
            String staffPANNumber = request.getParameter("editStaffPANNo");
            String staffPFNumber = request.getParameter("editStaffPFAccountNo");
            Date joinedDate = null;
            if (request.getParameter("editStaffJoinedDate") != null && !request.getParameter("editStaffJoinedDate").isEmpty()) {
                joinedDate = formatter.parse(request.getParameter("editStaffJoinedDate"));
            }
            Integer status = Integer.parseInt(request.getParameter("editStaffStatus"));
            Long approverId = Long.parseLong(request.getParameter("editApproverId"));
            User approver = this.userService.userById(approverId);
            Long staffTypeId = Long.parseLong(request.getParameter("editStaffTypeId"));
            StaffType staffType = this.staffTypeService.staffTypeById(staffTypeId);
            Long staffDesignationId = Long.parseLong(request.getParameter("editStaffDesignationId"));
            StaffDesignation staffDesignation = this.staffDesignationService.staffDesignationById(staffDesignationId);
            String modifiedBy = request.getSession().getAttribute("username").toString();
            Long categoryId = Long.parseLong(request.getParameter("editCategoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            String[] userRoleId = request.getParameterValues("editUserRoleId");
            HashSet<UserRole> userRoles = new HashSet<UserRole>();
            String[] stringArray = userRoleId;
            int n = userRoleId.length;
            int n2 = 0;
            while (n2 < n) {
                String roleId = stringArray[n2];
                userRoles.add(this.userRoleService.userRoleById(Long.parseLong(roleId)));
                ++n2;
            }
            Staff staff = this.staffService.staffByIdEager(staffId);
            BloodGroup bloodGroup = null;
            if (request.getParameter("editStaffBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("editStaffBloodGroupId")));
            }
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setParentOrGuardianFirstName(parentOrGuardianFirstName);
            staff.setParentOrGuardianLastName(parentOrGuardianLastName);
            staff.setGender(gender);
            staff.setDateOfBirth(dateOfBirth);
            staff.setEmail(eMail);
            staff.setContact(contact);
            staff.setStaffAddressLine1(staffAddressLine1);
            staff.setStaffAddressLine2(staffAddressLine2);
            staff.setCountry(country);
            staff.setState(state);
            staff.setCity(city);
            staff.setPostCode(postCode);
            staff.setStaffPANNumber(staffPANNumber);
            staff.setStaffPFNumber(staffPFNumber);
            staff.setBloodGroup(bloodGroup);
            staff.setModifiedBy(modifiedBy);
            staff.setStaffCode(staffCode);
            staff.setAccessNo(accessNo);
            staff.setJoinedDate(joinedDate);
            staff.setStatus(status);
            staff.setApprover(approver);
            staff.setStaffType(staffType);
            staff.setStaffDesignation(staffDesignation);
            staff.setCategory(category);
            String profilePath = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", multipartFile.getOriginalFilename());
            }
            User user = this.userService.userById(userId);
            if (profilePath != "") {
                user.setProfilePicturePath(profilePath);
            }
            String userName = request.getParameter("adminName");
            String password = request.getParameter("adminPassword");
            String hash = this.hashGenerator.encoder(password);
            user.setUserRoles(userRoles);
            user.setName(userName);
            user.setPassword(password);
            user.setEmail(eMail);
            user.setModifiedBy(modifiedBy);
            user.setHash(hash);
            user.setStaff(staff);
            user.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            String bankName = request.getParameter("editStaffBankName");
            String bankAccountNo = null;
            if (request.getParameter("editStaffBankAccountNo") != null) {
                bankAccountNo = request.getParameter("editStaffBankAccountNo");
            }
            String bankIFSCCode = request.getParameter("editStaffBankIFSC");
            StaffBankDetail staffBankDetail = this.staffBankDetailService.staffBankDetailById(staffBankDetailId);
            staffBankDetail.setBankName(bankName);
            staffBankDetail.setBankAccountNo(bankAccountNo);
            staffBankDetail.setBankIFSCCode(bankIFSCCode);
            String[] documentTypes = request.getParameterValues("editdocumenttypes");
            String[] splitsDocumentType = null;
            String[] stringArray2 = documentTypes;
            int n3 = documentTypes.length;
            int n4 = 0;
            while (n4 < n3) {
                String olddocumentType = stringArray2[n4];
                splitsDocumentType = olddocumentType.split(",");
                splitsDocumentType = (String[])Arrays.stream(splitsDocumentType).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                ++n4;
            }
            System.out.println(splitsDocumentType.length);
            int di = 0;
            LinkedHashSet<Document> staffdocuments = new LinkedHashSet<Document>();
            if (splitsDocumentType.length > 0 && documents != null) {
                System.out.println(documents.length);
                MultipartFile[] multipartFileArray = documents;
                int n5 = documents.length;
                int n6 = 0;
                while (n6 < n5) {
                    DocumentType documentType;
                    MultipartFile document = multipartFileArray[n6];
                    String picturePath = "";
                    if (document != null && !document.isEmpty()) {
                        picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-document/document/" + staff.getFirstName() + staff.getStaffCode() + "/", document.getOriginalFilename());
                    }
                    if (this.documentService.documentByDocumentTypeAndStaff((documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[di])))).getDocumentTypeId(), staff.getStaffId()) != null) {
                        Document documentnew;
                        System.out.println("Enter If");
                        Document documentnewold = null;
                        if (picturePath != "") {
                            documentnewold = this.documentService.documentByDocumentTypeAndStaff(documentType.getDocumentTypeId(), staff.getStaffId());
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            staffdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        } else {
                            documentnewold = this.documentService.documentByDocumentTypeAndStaff(documentType.getDocumentTypeId(), staff.getStaffId());
                            documentnew = new Document(documentType, documentnewold.getDocumentName(), documentnewold.getDocumentPath());
                            staffdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        }
                    } else {
                        Document documentnew;
                        System.out.println("Enter Else");
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                            documentnew = new Document(documentType, "a.png", picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStaff(staff);
                            staffdocuments.add(documentnew);
                        } else {
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStaff(staff);
                            staffdocuments.add(documentnew);
                        }
                    }
                    ++di;
                    ++n6;
                }
            }
            LinkedHashSet<StaffExperienceDetail> staffExperiences = new LinkedHashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("staffExperienceIdArray");
            if (experiences != null) {
                String[] stringArray3 = experiences;
                int n7 = experiences.length;
                int n8 = 0;
                while (n8 < n7) {
                    String experienceId = stringArray3[n8];
                    String[] splitexperiences = experienceId.split("/");
                    splitexperiences = (String[])Arrays.stream(splitexperiences).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    int i = 0;
                    while (i < splitexperiences.length) {
                        String[] experience = splitexperiences[i].split(",");
                        experience = (String[])Arrays.stream(experience).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                        int j = 0;
                        while (j < experience.length) {
                            if (experience[j].contains("editOrganizationName")) {
                                String[] workedOrganisation = experience[j].split("-");
                                if (workedOrganisation.length > 1) {
                                    Long staffExperienceDetailId = Long.parseLong(workedOrganisation[1].toString());
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = this.staffExperienceDetailService.staffExperienceDetailById(staffExperienceDetailId);
                                    staffExperience.setStaffExperienceDetailId(staffExperienceDetailId);
                                    staffExperience.setWorkedOrganisation(currentworkedOrganisation);
                                    staffExperience.setInPreviousExperience(inPreviousExperience);
                                    staffExperience.setStartDate(startDate);
                                    staffExperience.setEndDate(endDate);
                                    staffExperience.setStaffPreviousDesignation(staffPreviousDesignation);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                } else {
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = new StaffExperienceDetail(currentworkedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, modifiedBy);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                }
                            }
                            ++j;
                        }
                        ++i;
                    }
                    ++n8;
                }
            }
            staff.setUser(user);
            staff.setStaffBankDetail(staffBankDetail);
            this.staffService.updateStaff(staff, staffExperiences, staffBankDetail, staffdocuments);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Details Updated Successfully...!"));
            return "redirect:/staff";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/staff";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    public String deleteStaff(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long staffId = Long.parseLong(request.getParameter("deleteStaffId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting staff with id=" + staffId));
            this.staffService.deleteStaff(staffId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Deleted Successfully...!"));
            return "redirect:/staff";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/staff";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"moduleattendance"})
    public ModelAndView displayStaffModulePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff Module page"));
            ModelAndView modelandview = new ModelAndView("staffmoduleattendance");
            String userName = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(userName);
            modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"moduleattendance/add"})
    public String addStaffHourAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] studentAttendanceIds;
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has added new staff module attendance"));
            Long csmId = Long.parseLong(request.getParameter("classSectionModuleId"));
            ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleById(csmId);
            ArrayList<StaffModuleAttendance> staffModuleAttendances = new ArrayList<StaffModuleAttendance>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            AcademicYear academicYear = this.academicYearServices.getActiveAcademicYear();
            String time = request.getParameter("attendanceTime");
            String date = request.getParameter("attendanceDate");
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");
            Date d1 = format.parse(time);
            Time attendanceTime = new Time(d1.getTime());
            String[] stringArray = studentAttendanceIds = request.getParameter("studentAndAttendanceIds").split(",");
            int n = studentAttendanceIds.length;
            int n2 = 0;
            while (n2 < n) {
                String studentAttendanceId = stringArray[n2];
                String[] studentAndAttendanceIds = studentAttendanceId.split("-");
                Long studentId = Long.parseLong(studentAndAttendanceIds[0]);
                Long studentAttendanceTypeId = Long.parseLong(studentAndAttendanceIds[1]);
                Student student = this.studentServices.studentByIdEager(studentId);
                Class studentClass = student.getStudentClass();
                Section section = student.getSection();
                Date attendanceDate = formatter.parse(date);
                StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeService.studentAttendanceTypeById(studentAttendanceTypeId);
                StaffModuleAttendance staffModuleAttendance = new StaffModuleAttendance(student, studentClass, section, classSectionModule, attendanceDate, attendanceTime, academicYear, studentAttendanceType);
                staffModuleAttendances.add(staffModuleAttendance);
                ++n2;
            }
            this.staffModuleAttendanceService.addStaffModuleAttendance(staffModuleAttendances);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Attendance Updated"));
            return "redirect:/staff/moduleattendance";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/staff/moduleattendance";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"moduleattendance/delete"})
    public String deleteStaffHourAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has delete staff module attendance"));
            Long deleteStaffModuleAttendanceId = Long.parseLong(request.getParameter("deleteStudentAttendanceId"));
            this.staffModuleAttendanceService.deleteStaffModuleAttendance(deleteStaffModuleAttendanceId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Attendance Deleted Successfully...!"));
            return "redirect:/staff/moduleattendancereport";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/staff/moduleattendancereport";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"moduleattendance/deleteAll"})
    public String deleteAllStaffHourAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has delete staff module attendance"));
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
            this.staffModuleAttendanceService.deleteAllStaffModuleAttendance(deleteAttendanceIds);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Attendance Deleted Successfully...!"));
            return "redirect:/staff/moduleattendancereport";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/staff/moduleattendancereport";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"moduleattendance/retreiveModuleAttendance"})
    @ResponseBody
    public StaffModuleAttendance retreiveStaffHourAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has retreive staff module attendance"));
            Long staffModuleAttendanceId = Long.parseLong(request.getParameter("staffModuleAttendanceId"));
            StaffModuleAttendance staffModuleAttendance = this.staffModuleAttendanceService.staffModuleAttendanceById(staffModuleAttendanceId);
            return staffModuleAttendance;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"moduleattendance/update"})
    public String updateStaffHourAttendance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has update existing staff module attendance"));
            String[] staffModuleAttendanceIds = request.getParameter("updateStudentAttendanceId").split(",");
            staffModuleAttendanceIds = (String[])Arrays.stream(staffModuleAttendanceIds).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            StaffModuleAttendance staffModuleAttendance = null;
            String[] stringArray = staffModuleAttendanceIds;
            int n = staffModuleAttendanceIds.length;
            int n2 = 0;
            while (n2 < n) {
                String staffModuleAttendanceId = stringArray[n2];
                String[] studentAndAttendanceIds = staffModuleAttendanceId.split("-");
                Long attendanceId = Long.parseLong(studentAndAttendanceIds[0]);
                Long studentAttendanceTypeId = Long.parseLong(studentAndAttendanceIds[1]);
                StudentAttendanceType studentAttendanceType = this.studentAttendanceTypeService.studentAttendanceTypeById(studentAttendanceTypeId);
                staffModuleAttendance = this.staffModuleAttendanceService.staffModuleAttendanceById(attendanceId);
                staffModuleAttendance.setStudentAttendanceType(studentAttendanceType);
                ++n2;
            }
            this.staffModuleAttendanceService.updateStaffModuleAttendance(staffModuleAttendance);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Attendance Updated"));
            return "redirect:/staff/moduleattendancereport";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            this.log.error((Object)"Exception", e.getCause());
            return "redirect:/staff/moduleattendancereport";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/moduleplan"})
    public ModelAndView displayModulePlanPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed module plan page"));
            ModelAndView modelandview = new ModelAndView("moduleplan");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("modules", this.moduleService.moduleList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public Staff viewRetrieve(@PathVariable(value="id") Long staffId, HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff with id=" + staffId));
            Staff staff = this.staffService.staffByIdEager(staffId);
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staffdetails"})
    @ResponseBody
    public Staff viewStaff(HttpServletRequest request) {
        try {
            String staffEmail = request.getParameter("email");
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff with email=" + staffEmail));
            Staff staff = this.staffService.staffByEmailEager(staffEmail);
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staffdetailsbyemail"})
    @ResponseBody
    public Staff viewStaffByEmail(HttpServletRequest request) {
        try {
            String staffEmail = request.getParameter("email");
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff with email=" + staffEmail));
            Staff staff = this.staffService.staffByEmail(staffEmail);
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staffdesignation/{staffdesignationid}"})
    @ResponseBody
    public List<Staff> staffByStaffDesignation(@PathVariable(value="staffdesignationid") Long staffDesignationId, HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff with staff designation id=" + staffDesignationId));
            List<Staff> staff = this.staffService.staffByStaffDesignationEager(staffDesignationId);
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/stafflist"})
    @ResponseBody
    public List<Staff> getStaff(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff List"));
            List<Staff> staff = this.staffService.staffListEager();
            return staff;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"profile/update"}, method={RequestMethod.POST})
    public String updateStaffProfile(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="documents") MultipartFile[] documents, @RequestParam(value="staffProfilePic") MultipartFile multipartFile) throws Exception {
        try {
            Object documentType;
            Long staffId = Long.parseLong(request.getParameter("updateStaffId"));
            Long userId = Long.parseLong(request.getParameter("updateUserId"));
            Long staffBankDetailId = Long.parseLong(request.getParameter("updateStaffBankDetailId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating Staff Profile with id=" + staffId));
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String firstName = request.getParameter("staffFirstName");
            String lastName = request.getParameter("staffLastName");
            String gender = request.getParameter("staffGender");
            Date dateOfBirth = formatter.parse(request.getParameter("staffDOB"));
            String contact = request.getParameter("staffContact");
            String eMail = request.getParameter("staffEmail");
            String parentOrGuardianFirstName = request.getParameter("staffParentOrGuardianFirstName");
            String parentOrGuardianLastName = request.getParameter("staffParentOrGuardianLastName");
            String staffAddressLine1 = request.getParameter("staffAddressLine1");
            String staffAddressLine2 = request.getParameter("staffAddressLine2");
            String country = request.getParameter("staffCountry");
            String state = request.getParameter("staffState");
            String city = request.getParameter("staffCity");
            String postCode = request.getParameter("staffPostCode");
            String staffPANNumber = request.getParameter("staffPANNo");
            String staffPFNumber = request.getParameter("staffPFAccountNo");
            BloodGroup bloodGroup = null;
            if (request.getParameter("staffBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("staffBloodGroupId")));
            }
            String profilePath = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-profile/", multipartFile.getOriginalFilename());
            }
            Staff staff = this.staffService.staffByIdEager(staffId);
            staff.setFirstName(firstName.trim());
            staff.setLastName(lastName);
            staff.setParentOrGuardianFirstName(parentOrGuardianFirstName);
            staff.setParentOrGuardianLastName(parentOrGuardianLastName);
            staff.setGender(gender);
            staff.setDateOfBirth(dateOfBirth);
            staff.setEmail(eMail);
            staff.setContact(contact);
            staff.setStaffAddressLine1(staffAddressLine1);
            staff.setStaffAddressLine2(staffAddressLine2);
            staff.setCountry(country);
            staff.setState(state);
            staff.setCity(city);
            staff.setPostCode(postCode);
            staff.setStaffPANNumber(staffPANNumber);
            staff.setStaffPFNumber(staffPFNumber);
            staff.setBloodGroup(bloodGroup);
            String modifiedBy = request.getSession().getAttribute("username").toString();
            staff.setModifiedBy(modifiedBy);
            User user = this.userService.userById(userId);
            if (profilePath != "") {
                user.setProfilePicturePath(profilePath);
            }
            String userName = request.getParameter("adminName");
            String password = request.getParameter("adminPassword");
            String hash = this.hashGenerator.encoder(password);
            user.setName(userName);
            user.setPassword(password);
            user.setEmail(eMail);
            user.setModifiedBy(modifiedBy);
            user.setHash(hash);
            user.setStaff(staff);
            user.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            String[] documentTypes = request.getParameterValues("editdocumenttypes");
            String[] splitsDocumentType = null;
            String[] stringArray = documentTypes;
            int n = documentTypes.length;
            int n2 = 0;
            while (n2 < n) {
                String olddocumentType = stringArray[n2];
                splitsDocumentType = olddocumentType.split(",");
                splitsDocumentType = (String[])Arrays.stream(splitsDocumentType).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                ++n2;
            }
            System.out.println(splitsDocumentType.length);
            int di = 0;
            LinkedHashSet<Document> staffdocuments = new LinkedHashSet<Document>();
            if (splitsDocumentType.length > 0 && documents != null) {
                System.out.println(documents.length);
                MultipartFile[] multipartFileArray = documents;
                int n3 = documents.length;
                int n4 = 0;
                while (n4 < n3) {
                    MultipartFile document = multipartFileArray[n4];
                    String picturePath = "";
                    if (document != null && !document.isEmpty()) {
                        picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/staff-document/document/" + staff.getFirstName() + staff.getStaffCode() + "/", document.getOriginalFilename());
                    }
                    if (this.documentService.documentByDocumentTypeAndStaff(((DocumentType)(documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[di]))))).getDocumentTypeId(), staff.getStaffId()) != null) {
                        Document documentnew;
                        System.out.println("Enter If");
                        Document documentnewold = null;
                        if (picturePath != "") {
                            documentnewold = this.documentService.documentByDocumentTypeAndStaff(((DocumentType)documentType).getDocumentTypeId(), staff.getStaffId());
                            documentnew = new Document((DocumentType)documentType, document.getOriginalFilename(), picturePath);
                            staffdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        } else {
                            documentnewold = this.documentService.documentByDocumentTypeAndStaff(((DocumentType)documentType).getDocumentTypeId(), staff.getStaffId());
                            documentnew = new Document((DocumentType)documentType, documentnewold.getDocumentName(), documentnewold.getDocumentPath());
                            staffdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        }
                    } else {
                        Document documentnew;
                        System.out.println("Enter Else");
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                            documentnew = new Document((DocumentType)documentType, "a.png", picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStaff(staff);
                            staffdocuments.add(documentnew);
                        } else {
                            documentnew = new Document((DocumentType)documentType, document.getOriginalFilename(), picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStaff(staff);
                            staffdocuments.add(documentnew);
                        }
                    }
                    ++di;
                    ++n4;
                }
            }
            LinkedHashSet<StaffExperienceDetail> staffExperiences = new LinkedHashSet<StaffExperienceDetail>();
            String[] experiences = request.getParameterValues("staffExperienceIdArray");
            if (experiences != null) {
                documentType = experiences;
                int picturePath = experiences.length;
                int n5 = 0;
                while (n5 < picturePath) {
                    String experienceId = documentType[n5];
                    String[] splitexperiences = experienceId.split("/");
                    splitexperiences = (String[])Arrays.stream(splitexperiences).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    int i = 0;
                    while (i < splitexperiences.length) {
                        String[] experience = splitexperiences[i].split(",");
                        experience = (String[])Arrays.stream(experience).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                        int j = 0;
                        while (j < experience.length) {
                            if (experience[j].contains("organizationName")) {
                                String[] workedOrganisation = experience[j].split("-");
                                if (workedOrganisation.length > 1) {
                                    Long staffExperienceDetailId = Long.parseLong(workedOrganisation[1].toString());
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = this.staffExperienceDetailService.staffExperienceDetailById(staffExperienceDetailId);
                                    staffExperience.setStaffExperienceDetailId(staffExperienceDetailId);
                                    staffExperience.setWorkedOrganisation(currentworkedOrganisation);
                                    staffExperience.setInPreviousExperience(inPreviousExperience);
                                    staffExperience.setStartDate(startDate);
                                    staffExperience.setEndDate(endDate);
                                    staffExperience.setStaffPreviousDesignation(staffPreviousDesignation);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                } else {
                                    String currentworkedOrganisation = request.getParameter(experience[0].toString());
                                    Double inPreviousExperience = Double.parseDouble(request.getParameter(experience[1].toString()));
                                    Date startDate = formatter.parse(request.getParameter(experience[2].toString()));
                                    Date endDate = formatter.parse(request.getParameter(experience[3].toString()));
                                    String staffPreviousDesignation = request.getParameter(experience[4].toString());
                                    StaffExperienceDetail staffExperience = new StaffExperienceDetail(currentworkedOrganisation, startDate, endDate, staffPreviousDesignation, inPreviousExperience, modifiedBy);
                                    staffExperience.setStaff(staff);
                                    staffExperiences.add(staffExperience);
                                }
                            }
                            ++j;
                        }
                        ++i;
                    }
                    ++n5;
                }
            }
            String bankName = request.getParameter("staffBankName");
            String bankAccountNo = null;
            if (request.getParameter("staffBankAccountNo") != null) {
                bankAccountNo = request.getParameter("staffBankAccountNo");
            }
            String bankIFSCCode = request.getParameter("staffBankIFSC");
            StaffBankDetail staffBankDetail = this.staffBankDetailService.staffBankDetailById(staffBankDetailId);
            staffBankDetail.setBankName(bankName);
            staffBankDetail.setBankAccountNo(bankAccountNo);
            staffBankDetail.setBankIFSCCode(bankIFSCCode);
            staffBankDetail.setStaff(staff);
            staff.setUser(user);
            this.staffService.updateStaffAndDocuments(staff, staffExperiences, staffBankDetail, staffdocuments);
            HttpSession session = request.getSession();
            session.setAttribute("username", (Object)eMail);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Profile Updated Successfully...!"));
            return "redirect:/staff/profile";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/profile";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staffattendancedetails"})
    public ModelAndView displayStaffAttendanceDetailsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed staff attendance details page"));
            ModelAndView modelandview = new ModelAndView("staffattendancedetails");
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveParticularStaffModuleAttendancePercentageReports"})
    @ResponseBody
    public List<SevenFieldReports> retrieveParticularStaffModuleAttendancePercentageReports(HttpServletRequest request) throws Exception {
        try {
            ArrayList<SevenFieldReports> studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular Staff Module Attendance Percentage Reports"));
            AcademicYear academicYear = this.academicYearServices.getActiveAcademicYear();
            Long classSectionModuleId = Long.parseLong(request.getParameter("classSectionModuleId"));
            ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleByIdEager(classSectionModuleId);
            studentAttendanceList = this.staffModuleAttendanceService.studentListByAcademicYearAndClassAndSection(classSectionModule.getClassSection().getClassSection(), classSectionModule.getClassSection().getSectionClass(), academicYear, classSectionModule);
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStaffModuleAttendanceList"})
    @ResponseBody
    public ArrayList<StaffModuleAttendance> viewStaffModuleAttendanceRetrieve(HttpServletRequest request) throws Exception {
        try {
            ArrayList<StaffModuleAttendance> staffModuleAttendanceList = new ArrayList<StaffModuleAttendance>();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Staff Module Attendance List"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            String studentEmail = request.getSession().getAttribute("username").toString();
            String reportType = request.getParameter("reportType");
            if (reportType.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = request.getParameter("fromDate");
                String endDate = request.getParameter("toDate");
                Date attendanceStartDate = formatter.parse(startDate);
                Date attendanceEndDate = formatter.parse(endDate);
                staffModuleAttendanceList.addAll(this.staffModuleAttendanceService.staffModuleAttendanceByStudentEmailAndAttendanceStartDateAndAttendanceEndDateEager(studentEmail, institution, attendanceStartDate, attendanceEndDate));
            } else if (reportType.equals("monthly")) {
                String monthDate = request.getParameter("monthDate");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                Date attendanceMonthDate = formatter.parse(monthDate);
                staffModuleAttendanceList.addAll(this.staffModuleAttendanceService.staffModuleAttendanceByStudentEmailAndAttendanceMonthEager(studentEmail, institution, attendanceMonthDate));
            }
            return staffModuleAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStaffModuleAttendanceByAcademicYearAndClassAndSectionAndModule"})
    @ResponseBody
    public List<SevenFieldReports> retrieveParticularAcademicYearAndClassAndSectionAndModuleStaffModuleAttendanceRetrieve(HttpServletRequest request) throws Exception {
        try {
            ArrayList<SevenFieldReports> studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular AcademicYear And Class And Section Staff Module Attendance List"));
            Long classId = Long.parseLong(request.getParameter("moduleClassId"));
            Class classs = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("moduleSectionId"));
            Section section = this.sectionService.sectionById(sectionId);
            Long academicYearId = Long.parseLong(request.getParameter("moduleAcademicYearId"));
            Long moduleId = Long.parseLong(request.getParameter("moduleId"));
            Module module = this.moduleService.moduleById(moduleId);
            AcademicYear academicYear = this.academicYearServices.academicYearById(academicYearId);
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(classId, sectionId);
            ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleByClassSectionAndModule(classSection, module);
            studentAttendanceList = this.staffModuleAttendanceService.studentListByAcademicYearAndClassAndSection(classs, section, academicYear, classSectionModule);
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStaffModuleAttendanceByAcademicYearAndStudentEmail"})
    @ResponseBody
    public List<SevenFieldReports> retrieveStaffModuleAttendanceByAcademicYearAndStudentEmail(HttpServletRequest request) throws Exception {
        try {
            ArrayList<SevenFieldReports> studentAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Particular Staff Module Attendance List By AcademicYear And Student Email"));
            String studentEmail = request.getSession().getAttribute("username").toString();
            Long academicYearId = Long.parseLong(request.getParameter("moduleAcademicYearId"));
            AcademicYear academicYear = this.academicYearServices.academicYearById(academicYearId);
            studentAttendanceList = this.staffModuleAttendanceService.staffModuleAttendanceByAcademicYearAndStudentEmail(academicYear, studentEmail);
            return studentAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveClassAndSectionStaffModuleAttendanceList"})
    @ResponseBody
    public ArrayList<StaffModuleAttendance> viewClassAndSectionStaffModuleAttendanceRetrieve(HttpServletRequest request) throws Exception {
        try {
            ArrayList staffModuleAttendanceList = new ArrayList();
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Class and Section Staff Module Attendance List"));
            String reportType = request.getParameter("reportType");
            Long classId = Long.parseLong(request.getParameter("classId"));
            Class classs = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            Section section = this.sectionService.sectionById(sectionId);
            if (reportType.equals("dateRange")) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String startDate = request.getParameter("fromDate");
                String endDate = request.getParameter("toDate");
                Date attendanceStartDate = formatter.parse(startDate);
                Date attendanceEndDate = formatter.parse(endDate);
                staffModuleAttendanceList = (ArrayList)this.staffModuleAttendanceService.staffModuleAttendanceByClassAndSectionAndAttendanceStartDateAndAttendanceEndDateEager(classs, section, attendanceStartDate, attendanceEndDate);
            } else if (reportType.equals("monthly")) {
                String monthDate = request.getParameter("monthDate");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
                Date attendanceMonthDate = formatter.parse(monthDate);
                staffModuleAttendanceList = (ArrayList)this.staffModuleAttendanceService.staffModuleAttendanceByClassAndSectionAndAttendanceMonthEager(classs, section, attendanceMonthDate);
            }
            return staffModuleAttendanceList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/requisition"})
    public ModelAndView displayStaffRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("requisition");
            modelandview.addObject("staffLeaveTypeList", this.staffLeaveTypeService.staffLeaveTypeList());
            String staffEmail = request.getSession().getAttribute("username").toString();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            User user = this.userService.userByEmailEager(staffEmail);
            modelandview.addObject("requisitionTypeList", this.requisitionTypeService.requisitionTypeListByUser(user));
            modelandview.addObject("approvers", this.userService.staffLeaveApprovar(staffEmail, institutionId));
            modelandview.addObject("staffLeaveRequistions", this.staffService.staffLeaveRequests(staffEmail));
            modelandview.addObject("staffLeaveRequestApprovedAndRejectedLists", this.staffService.staffLeaveRequestApprovedAndRejectedLists(staffEmail));
            modelandview.addObject("staffMovementRequistions", this.staffService.staffMovementRequests(staffEmail));
            modelandview.addObject("staffMovementRequestApprovedAndRejectedLists", this.staffService.staffMovementRequestApprovedAndRejectedLists(staffEmail));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/meeting/requisition"})
    public ModelAndView displaySickRoomRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("meetingrequisition");
            String staffEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(staffEmail);
            modelandview.addObject("requisitionTypeList", this.requisitionTypeService.requisitionTypeListByUser(user));
            modelandview.addObject("meetingRequisitions", this.meetingRequisitionService.meetingRequisitionListByRequesterEmail(staffEmail));
            modelandview.addObject("meetingRequisitionApprovedAndRejectedLists", this.meetingRequisitionService.meetingRequestApprovedAndRejectedLists(staffEmail));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/requisition/staffLeaveRequest"}, method={RequestMethod.POST})
    public String addStaffLeaveRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            StaffLeaveType staffLeaveType = this.staffLeaveTypeService.staffLeaveTypeById(Long.parseLong(request.getParameter("staffLeaveType")));
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedRequisitionTypeId")));
            String approvalStatus = "Pending";
            String staffLeaveReason = request.getParameter("staffLeaveReason");
            String staffLeaveStartAndEndDate = request.getParameter("staffLeaveStartAndEndDate");
            Staff staff = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString()).getStaff();
            User leaveApprover = staff.getApprover();
            String[] dates = staffLeaveStartAndEndDate.split("-");
            Date staffLeaveStartDate = formatter.parse(dates[0].trim());
            Date staffLeaveEndDate = formatter.parse(dates[1].trim());
            String email = request.getSession().getAttribute("username").toString();
            StaffLeaveRequisition staffLeaveRequisition = new StaffLeaveRequisition(requisitionType, staffLeaveType, staffLeaveReason, staff, leaveApprover, approvalStatus, staffLeaveStartDate, staffLeaveEndDate, email, email);
            this.staffLeaveRequisitionService.createStaffLeaveRequisition(staffLeaveRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Leave Request Sent Successfully...!"));
            return "redirect:/staff/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/requisition";
        }
    }

    @RequestMapping(value={"/requisition/staffMovementRequest"}, method={RequestMethod.POST})
    public String addStaffMovementRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedMovementRequisitionTypeId")));
            String approvalStatus = "Pending";
            String staffMovementRequisitionReason = request.getParameter("staffMovementRequisitionReason");
            Staff staff = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString()).getStaff();
            User MovementApprover = staff.getApprover();
            String date = request.getParameter("staffMovementRequisitionDate");
            String startTime = request.getParameter("staffInTime");
            String endTime = request.getParameter("staffOutTime");
            Date MovementRequisitionDate = formatter.parse(date);
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String createdBy = request.getSession().getAttribute("username").toString();
            StaffMovementRequisition staffMovementRequisition = new StaffMovementRequisition(staff, staffMovementRequisitionReason, requisitionType, MovementRequisitionDate, new Time(timeFormat.parse(startTime).getTime()), new Time(timeFormat.parse(endTime).getTime()), MovementApprover, approvalStatus, createdBy, createdBy);
            this.staffMovementRequisitionService.createStaffMovementRequisition(staffMovementRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Movement Request Sent Successfully...!"));
            return "redirect:/staff/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/requisition";
        }
    }

    @RequestMapping(value={"/requisition/meetingRequest"}, method={RequestMethod.POST})
    public String addSickRoomRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedMeetingRequisitionTypeId")));
            String approvalStatus = "Pending";
            String meetingRequisitionReason = request.getParameter("meetingRequisitionReason");
            User requester = this.userService.userByEmailEager(request.getSession().getAttribute("username").toString());
            User approver = this.userService.principalRoleApproverByInstitution(institutionId);
            String date = request.getParameter("meetingRequisitionDate");
            String startTime = request.getParameter("fromTime");
            String endTime = request.getParameter("toTime");
            Date meetingRequisitionRequisitionDate = formatter.parse(date);
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String createdBy = request.getSession().getAttribute("username").toString();
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            MeetingRequisition meetingRequest = new MeetingRequisition(meetingRequisitionReason, requisitionType, meetingRequisitionRequisitionDate, new Time(timeFormat.parse(startTime).getTime()), new Time(timeFormat.parse(endTime).getTime()), requester, approver, approvalStatus, institution, academicYear, createdBy, createdBy);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(meetingRequest.getMeetingApprover());
            PortalTask portalTask = new PortalTask("Meeting Approval", "Meeting Approval", addUser, 1, "/staff/meeting/approvals", request.getSession().getAttribute("username").toString(), meetingRequest.getInstitution());
            this.meetingRequisitionService.createMeetingRequisition(meetingRequest, portalTask);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Meeting Request Sent Successfully...!"));
            return "redirect:/staff/meeting/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/meeting/requisition";
        }
    }

    @RequestMapping(value={"/requisition/staffLeaveRequest/cancel"}, method={RequestMethod.POST})
    public String cancelStaffLeaveRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long staffLeaveRequistionId = Long.parseLong(request.getParameter("staffLeaveRequisitionId"));
            StaffLeaveRequisition staffLeaveRequisition = this.staffLeaveRequisitionService.staffLeaveRequisitionByIdEager(staffLeaveRequistionId);
            staffLeaveRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            staffLeaveRequisition.setModifiedBy(email);
            this.staffLeaveRequisitionService.cancelStaffLeaveRequisition(staffLeaveRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Leave Request Cancelled Successfully...!"));
            return "redirect:/staff/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/requisition";
        }
    }

    @RequestMapping(value={"/requisition/staffMovementRequest/cancel"}, method={RequestMethod.POST})
    public String cancelStaffMovementRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long staffMovementRequistionId = Long.parseLong(request.getParameter("staffMovementRequisitionId"));
            StaffMovementRequisition staffMovementRequisition = this.staffMovementRequisitionService.staffMovementRequisitionByIdEager(staffMovementRequistionId);
            staffMovementRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            staffMovementRequisition.setModifiedBy(email);
            this.staffMovementRequisitionService.cancelStaffMovementRequisition(staffMovementRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Movement Request Cancelled Successfully...!"));
            return "redirect:/staff/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/requisition";
        }
    }

    @RequestMapping(value={"/requisition/meetingRequest/cancel"}, method={RequestMethod.POST})
    public String cancelSickRoomRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long meetingRequisitionId = Long.parseLong(request.getParameter("meetingRequisitionId"));
            MeetingRequisition meetingRequisition = this.meetingRequisitionService.meetingRequisitionByIdEager(meetingRequisitionId);
            meetingRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            meetingRequisition.setModifiedBy(email);
            this.meetingRequisitionService.cancelMeetingRequisition(meetingRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Meeting Request Cancelled Successfully...!"));
            return "redirect:/staff/meeting/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/meeting/requisition";
        }
    }

    @RequestMapping(value={"/approvals"})
    public ModelAndView displayApprovalsPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("approvals");
            modelandview.addObject("leaveApporvalsList", this.staffService.staffLeaveApprovals(request.getSession().getAttribute("username").toString()));
            modelandview.addObject("tcApprovalsList", this.tcRequisitionService.tcRequisitionListByTCApprover(request.getSession().getAttribute("username").toString()));
            modelandview.addObject("movementApprovalsList", this.staffMovementRequisitionService.staffMovementRequisitionListByMovementApprover(request.getSession().getAttribute("username").toString()));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/meeting/approvals"})
    public ModelAndView displaySickRoomApprovalsPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("meetingapprovals");
            modelandview.addObject("meetingRequisitionApprovalsList", this.meetingRequisitionService.meetingRequisitionListByApprover(request.getSession().getAttribute("username").toString()));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/approvals/updatestatus"}, method={RequestMethod.POST})
    public String updateApprovalsStatus(HttpServletRequest request) {
        try {
            Long staffLeaveRequisitionId = Long.parseLong(request.getParameter("staffLeaveRequisitionId"));
            String approverComment = request.getParameter("approverComment");
            String status = request.getParameter("staffLeaveRequisitionStatus");
            StaffLeaveRequisition staffLeaveRequisition = this.staffLeaveRequisitionService.staffLeaveRequisitionByIdEager(staffLeaveRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            staffLeaveRequisition.setApprovedBy(email);
            staffLeaveRequisition.setApprovalStatus(status);
            staffLeaveRequisition.setApproverComment(approverComment);
            staffLeaveRequisition.setModifiedBy(email);
            this.staffLeaveRequisitionService.updateStaffLeaveRequisition(staffLeaveRequisition);
            return "redirect:/staff/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/staff/approvals";
        }
    }

    @RequestMapping(value={"/approvals/staffMovement/updatestatus"}, method={RequestMethod.POST})
    public String updateStaffMovementApprovalsStatus(HttpServletRequest request) {
        try {
            Long staffMovementRequisitionId = Long.parseLong(request.getParameter("staffMovementRequisitionId"));
            String approverComment = request.getParameter("staffMovementApproverComment");
            String status = request.getParameter("staffMovementRequisitionStatus");
            StaffMovementRequisition staffMovementRequisition = this.staffMovementRequisitionService.staffMovementRequisitionByIdEager(staffMovementRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            staffMovementRequisition.setApprovedBy(email);
            staffMovementRequisition.setApprovalStatus(status);
            staffMovementRequisition.setApproverComment(approverComment);
            staffMovementRequisition.setModifiedBy(email);
            this.staffMovementRequisitionService.updateStaffMovementRequisition(staffMovementRequisition);
            return "redirect:/staff/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/staff/approvals";
        }
    }

    @RequestMapping(value={"/approvals/transfercertificate/updatestatus"}, method={RequestMethod.POST})
    public String updateTCApprovalsStatus(HttpServletRequest request) {
        try {
            Long tcRequisitionId = Long.parseLong(request.getParameter("tcRequisitionId"));
            String approverComment = request.getParameter("tcApproverComment");
            String status = request.getParameter("tcRequisitionStatus");
            TCRequisition tcRequisition = this.tcRequisitionService.tcRequisitionByIdEager(tcRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            tcRequisition.setApprovedBy(email);
            tcRequisition.setApprovalStatus(status);
            tcRequisition.setApproverComment(approverComment);
            tcRequisition.setModifiedBy(email);
            this.tcRequisitionService.updateTCRequisition(tcRequisition);
            return "redirect:/staff/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/staff/approvals";
        }
    }

    @RequestMapping(value={"/approvals/meeting/updatestatus"}, method={RequestMethod.POST})
    public String updateSickRoomApprovalsStatus(HttpServletRequest request) {
        try {
            Long meetingRequisitionId = Long.parseLong(request.getParameter("meetingRequisitionId"));
            String approverComment = request.getParameter("meetingApproverComment");
            String status = request.getParameter("meetingRequisitionStatus");
            MeetingRequisition meetingRequisition = this.meetingRequisitionService.meetingRequisitionByIdEager(meetingRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            meetingRequisition.setApprovedBy(email);
            meetingRequisition.setApprovalStatus(status);
            meetingRequisition.setApproverComment(approverComment);
            meetingRequisition.setModifiedBy(email);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(meetingRequisition.getMeetingRequester());
            PortalTask portalTask = new PortalTask("Meeting " + status, "Meeting " + status, addUser, 1, "/staff/meeting/requisition", email, meetingRequisition.getInstitution());
            this.meetingRequisitionService.updateMeetingRequisition(meetingRequisition, portalTask);
            return "redirect:/staff/meeting/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/staff/meeting/approvals";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"modulemarkupdate"})
    public ModelAndView displayStaffModuleMarkUpdatePage(HttpServletRequest request) throws Exception {
        try {
            ModelAndView modelandview = new ModelAndView("staffmodulemarkupdate");
            String userName = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(userName);
            modelandview.addObject("staffClassSectionModules", staff.getStaffClassSectionModules());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/moduleMark/save"}, method={RequestMethod.POST})
    public String moduleMarkSave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long classSectionAssessmentTypeId = Long.parseLong(request.getParameter("assessmentType"));
            ClassSectionAssesmentType classSectionAssessmentType = this.classSectionAssessmentTypeService.classSectionAssesmentTypeEagerBy(classSectionAssessmentTypeId);
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            ClassSectionTermExam classSectionTermExam = this.classSectionTermExamService.classSectionTermExamById(classSectionTermExamId);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(classId, sectionId);
            LinkedHashSet<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds = new LinkedHashSet<StudentMarksDetailWithModuleBased>();
            LinkedHashSet<StudentMark> studentMarks = new LinkedHashSet<StudentMark>();
            String[] moduleBasedMarksUpdateDetails = request.getParameterValues("moduleBasedMarksUpdateDetails");
            Long classSectionModuleId = Long.parseLong(request.getParameter("classSectionModuleId"));
            ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleById(classSectionModuleId);
            String[] stringArray = moduleBasedMarksUpdateDetails;
            int n = moduleBasedMarksUpdateDetails.length;
            int n2 = 0;
            while (n2 < n) {
                String[] moduleBasedMarksUpdates;
                String moduleBasedMarksUpdateDetail = stringArray[n2];
                String[] stringArray2 = moduleBasedMarksUpdates = moduleBasedMarksUpdateDetail.split(",");
                int n3 = moduleBasedMarksUpdates.length;
                int n4 = 0;
                while (n4 < n3) {
                    String moduleBasedMarksUpdate = stringArray2[n4];
                    String[] moduleBased = moduleBasedMarksUpdate.split("-");
                    Double assessmentMark = Double.parseDouble(moduleBased[2]);
                    Long classSectionTermExamActivityId = Long.parseLong(moduleBased[0]);
                    ClassSectionTermExamActivity classSectionTermExamActivity = this.classSectionTermExamActivityService.classSectionTermExamActivityById(classSectionTermExamActivityId);
                    Long studentId = Long.parseLong(moduleBased[1]);
                    Student student = this.studentServices.studentById(studentId);
                    StudentMark studentMark = new StudentMark(student, classSection, classSectionAssessmentType, classSectionTermExam, academicYear, institution);
                    studentMarks.add(studentMark);
                    StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBased = new StudentMarksDetailWithModuleBased(assessmentMark, classSectionTermExamActivity, classSectionModule);
                    studentMarksDetailWithModuleBaseds.add(studentMarksDetailWithModuleBased);
                    ++n4;
                }
                ++n2;
            }
            this.StaffModuleWiseMarkSystemService.saveModuleWiseMark(studentMarks, studentMarksDetailWithModuleBaseds);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Marks Saved Successfully...!"));
            return "redirect:/staff/modulemarkupdate";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staff/modulemarkupdate";
        }
    }
}
