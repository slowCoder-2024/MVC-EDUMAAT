/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.reports.model.FourFieldReport;
import in.jdsoft.educationmanagement.school.reports.model.NineFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.InventoryItemIssueAndReturnMasterService;
import in.jdsoft.educationmanagement.school.services.InvoiceService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.StaffAppraisalService;
import in.jdsoft.educationmanagement.school.services.StaffAttendanceService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import in.jdsoft.educationmanagement.school.services.StudentAppraisalService;
import in.jdsoft.educationmanagement.school.services.StudentAttendanceService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="dashboardController")
@RequestMapping(value={"/dashboard"})
public class DashboardController {
    private Logger log = LogManager.getLogger((String)DashboardController.class.getName());
    @Autowired
    private StudentAttendanceService studentAttendanceService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private StaffAttendanceService staffAttendanceService;
    @Autowired
    private StaffTypeService staffTypeService;
    @Autowired
    private SpecialCategoryService specialCategoryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BloodGroupService bloodGroupService;
    @Autowired
    private ClassService classService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private InventoryItemIssueAndReturnMasterService inventoryItemIssueAndReturnMasterService;
    @Autowired
    private StudentAppraisalService studentAppraisalService;
    @Autowired
    private StaffAppraisalService staffAppraisalService;
    @Autowired
    private AcademicYearService academicYearService;

    @RequestMapping(value={"/todayattendance/{id}"})
    public ModelAndView home(HttpServletRequest request, @PathVariable(value="id") Long instituteId) {
        try {
            ModelAndView modelandview = new ModelAndView("todayattendance");
            modelandview.addObject("institution", (Object)this.institutionService.institutionById(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studentAttendanceInPercentage/today"})
    @ResponseBody
    public String studentCurrentDateAttendance(HttpServletRequest request) throws Exception {
        String studentAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student current attendance"));
            Long institutionId = null;
            institutionId = request.getParameter("institutionId") != null && !request.getParameter("institutionId").isEmpty() ? Long.valueOf(Long.parseLong(request.getParameter("institutionId"))) : Long.valueOf(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            studentAttendancePercentage = this.studentAttendanceService.studentAttendancePercentageByCurrentDate(institutionId);
            return studentAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return studentAttendancePercentage;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/chartstudentAttendanceInPercentage/today"})
    @ResponseBody
    public ThreeFieldReports chartStudentCurrentDateAttendance(HttpServletRequest request) throws Exception {
        ThreeFieldReports studentAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student current attendance"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            studentAttendancePercentage = this.studentAttendanceService.chartStudentAttendancePercentageByCurrentDate(institutionId);
            return studentAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return studentAttendancePercentage;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/teachingStaffAttendanceInPercentage/today"})
    @ResponseBody
    public String teachingStaffCurrentDateAttendance(HttpServletRequest request) throws Exception {
        String teachingStaffAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed teaching Staff current attendance"));
            Long institutionId = null;
            institutionId = request.getParameter("institutionId") != null && !request.getParameter("institutionId").isEmpty() ? Long.valueOf(Long.parseLong(request.getParameter("institutionId"))) : Long.valueOf(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            Institution institution = this.institutionService.institutionById(institutionId);
            StaffType staffType = this.staffTypeService.staffTypeById(1L);
            teachingStaffAttendancePercentage = this.staffAttendanceService.staffAttendancePercentageByCurrentDate(institution, staffType);
            return teachingStaffAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            return teachingStaffAttendancePercentage;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/chartteachingStaffAttendanceInPercentage/today"})
    @ResponseBody
    public TwoFieldReport chartteachingStaffCurrentDateAttendance(HttpServletRequest request) throws Exception {
        TwoFieldReport teachingStaffAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed teaching Staff current attendance"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            StaffType staffType = this.staffTypeService.staffTypeById(1L);
            teachingStaffAttendancePercentage = this.staffAttendanceService.chartStaffAttendancePercentageByCurrentDate(institution, staffType);
            return teachingStaffAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            return teachingStaffAttendancePercentage;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/otherStaffAttendanceInPercentage/today"})
    @ResponseBody
    public String otherStaffCurrentDateAttendance(HttpServletRequest request) throws Exception {
        String otherStaffAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed non teaching Staff current attendance"));
            Long institutionId = null;
            institutionId = request.getParameter("institutionId") != null && !request.getParameter("institutionId").isEmpty() ? Long.valueOf(Long.parseLong(request.getParameter("institutionId"))) : Long.valueOf(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            Institution institution = this.institutionService.institutionById(institutionId);
            StaffType staffType = this.staffTypeService.staffTypeById(2L);
            otherStaffAttendancePercentage = this.staffAttendanceService.staffAttendancePercentageByCurrentDate(institution, staffType);
            return otherStaffAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return otherStaffAttendancePercentage;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/chartotherStaffAttendanceInPercentage/today"})
    @ResponseBody
    public TwoFieldReport chartotherStaffCurrentDateAttendance(HttpServletRequest request) throws Exception {
        TwoFieldReport otherStaffAttendancePercentage = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed non teaching Staff current attendance"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            StaffType staffType = this.staffTypeService.staffTypeById(2L);
            otherStaffAttendancePercentage = this.staffAttendanceService.chartStaffAttendancePercentageByCurrentDate(institution, staffType);
            return otherStaffAttendancePercentage;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return otherStaffAttendancePercentage;
        }
    }

    @RequestMapping(value={"/studentRatioFromSpecialCategory"}, method={RequestMethod.GET})
    @ResponseBody
    public ThreeFieldReports getStudentRatioFromSpecialCategory(HttpServletRequest request) {
        try {
            Long specialCategoryId = Long.parseLong(request.getParameter("specialCategory"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.specialCategoryService.getStudentRatioFromSpecialCategoryByInstitution(specialCategoryId, institutionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentRatioFromCategory"}, method={RequestMethod.GET})
    @ResponseBody
    public ThreeFieldReports getStudentRatioFromCategory(HttpServletRequest request) {
        try {
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.categoryService.getStudentRatioFromCategoryAndInstitution(categoryId, institutionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentRatioFromClass"}, method={RequestMethod.GET})
    @ResponseBody
    public ThreeFieldReports getStudentRatioFromClass(HttpServletRequest request) {
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            return this.classService.getStudentRatioFromClass(classId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentRatioFromBloodGroup"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCount(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.bloodGroupService.getBloodGroupWiseStudentCountByInstitution(institutionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAcademicYearAndInstitution"}, method={RequestMethod.GET})
    @ResponseBody
    public TwoFieldReport getAcademicYearAndInstitutionWisePendingAndPaidStudentCount(HttpServletRequest request) {
        try {
            Long academicYearId = Long.parseLong(request.getParameter("academicYear"));
            Long institutionId = Long.parseLong(request.getParameter("institutionId"));
            return this.invoiceService.pendingAndPaidStudentCountByAcademicYearAndInstitution(this.academicYearService.academicYearById(academicYearId), institutionId, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAcademicYear"}, method={RequestMethod.GET})
    @ResponseBody
    public TwoFieldReport getAcademicYearWisePendingAndPaidStudentCount(HttpServletRequest request) {
        try {
            Long academicYearId = Long.parseLong(request.getParameter("academicYear"));
            return this.invoiceService.pendingAndPaidStudentCountByAcademicYear(this.academicYearService.academicYearById(academicYearId), 0);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAllAcademicYear"}, method={RequestMethod.GET})
    @ResponseBody
    public List<ThreeFieldReports> getAllAcademicYearWisePendingAndPaidStudentCount(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.invoiceService.pendingAndPaidStudentCountByAllAcademicYear(institutionId, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAllClass"}, method={RequestMethod.GET})
    @ResponseBody
    public List<ThreeFieldReports> getAllClassWisePendingAndPaidStudentCount(HttpServletRequest request) {
        List<ThreeFieldReports> addThreeFieldReports = null;
        try {
            if (this.academicYearService.getActiveAcademicYear() != null) {
                addThreeFieldReports = this.invoiceService.pendingAndPaidStudentCountByAllClass(this.academicYearService.getActiveAcademicYear(), 0);
            }
            return addThreeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addThreeFieldReports;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAllClassByActiveAcademicYear"}, method={RequestMethod.GET})
    @ResponseBody
    public List<ThreeFieldReports> getAllClassWisePendingAndPaidStudentCountByActiveAcademicYear(HttpServletRequest request) {
        List<ThreeFieldReports> addThreeFieldReports = null;
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (this.academicYearService.getActiveAcademicYear() != null) {
                addThreeFieldReports = this.invoiceService.pendingAndPaidStudentCountByAllClassByActiveAcademicYear(institutionId, this.academicYearService.getActiveAcademicYear(), 0);
            }
            return addThreeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/pendingAndPaidStudentRatioFromAllClassByInstitution"}, method={RequestMethod.GET})
    @ResponseBody
    public List<ThreeFieldReports> getAllClassWisePendingAndPaidStudentCountByInstitution(HttpServletRequest request) {
        List<ThreeFieldReports> addThreeFieldReports = null;
        try {
            Long institutionId = null;
            if (request.getParameter("institutionId") != null && !request.getParameter("institutionId").isEmpty()) {
                institutionId = Long.parseLong(request.getParameter("institutionId"));
            }
            if (this.invoiceService.pendingAndPaidStudentCountByAllClassByInstitution(institutionId, 0) != null) {
                addThreeFieldReports = this.invoiceService.pendingAndPaidStudentCountByAllClassByInstitution(institutionId, 0);
            }
            return addThreeFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentRadioFromClassByInstitution"}, method={RequestMethod.GET})
    @ResponseBody
    public List<FourFieldReport> getStudentRadioFromClassByInstitution(HttpServletRequest request) {
        List<FourFieldReport> addFourFieldReport = null;
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (this.classService.getStudentRatioFromClassByInstitution(institutionId) != null) {
                addFourFieldReport = this.classService.getStudentRatioFromClassByInstitution(institutionId);
            }
            return addFourFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addFourFieldReport;
        }
    }

    @RequestMapping(value={"/todayStudentAttendanceRadioFromClassByInstitution"}, method={RequestMethod.GET})
    @ResponseBody
    public List<FourFieldReport> getTodayStudentAttstudentAttendanceInPercentageendanceRadioFromClassByInstitution(HttpServletRequest request) {
        List<FourFieldReport> addFourFieldReport = null;
        try {
            Long institutionId = null;
            institutionId = request.getParameter("institutionId") != null && !request.getParameter("institutionId").isEmpty() ? Long.valueOf(Long.parseLong(request.getParameter("institutionId"))) : Long.valueOf(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            if (this.studentAttendanceService.todayAttendanceByClassWiseByInstitution(institutionId) != null) {
                addFourFieldReport = this.studentAttendanceService.todayAttendanceByClassWiseByInstitution(institutionId);
            }
            return addFourFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addFourFieldReport;
        }
    }

    @RequestMapping(value={"/todayStudentAttendanceRadioFromClass"}, method={RequestMethod.GET})
    @ResponseBody
    public List<FourFieldReport> getTodayStudentAttendanceRadioFromClass(HttpServletRequest request) {
        List<FourFieldReport> addFourFieldReport = null;
        try {
            if (this.studentAttendanceService.todayAttendanceByClassWise() != null) {
                addFourFieldReport = this.studentAttendanceService.todayAttendanceByClassWise();
            }
            return addFourFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addFourFieldReport;
        }
    }

    @RequestMapping(value={"/longAbsentStudentList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<NineFieldReports> getLongAbsentStudentList(HttpServletRequest request) throws Exception {
        List<NineFieldReports> addNineFieldReports = null;
        try {
            if (this.studentAttendanceService.studentAttendanceListByLongAbsentStudentListByDefaultMonth() != null) {
                addNineFieldReports = this.studentAttendanceService.studentAttendanceListByLongAbsentStudentListByDefaultMonth();
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addNineFieldReports;
        }
    }

    @RequestMapping(value={"/longAbsentStudentList/selectedMonth"}, method={RequestMethod.GET})
    @ResponseBody
    public List<NineFieldReports> getLongAbsentStudentListBySelectedMonth(HttpServletRequest request) throws Exception {
        List<NineFieldReports> addNineFieldReports = null;
        try {
            String date = request.getParameter("selectedMonth");
            SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
            Date attendanceMonthDate = formatter.parse(date);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            if (this.studentAttendanceService.studentAttendanceListByLongAbsentStudentListBySelectedMonthAndInstitution(attendanceMonthDate, institutionId) != null) {
                addNineFieldReports = this.studentAttendanceService.studentAttendanceListByLongAbsentStudentListBySelectedMonthAndInstitution(attendanceMonthDate, institutionId);
            }
            return addNineFieldReports;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addNineFieldReports;
        }
    }

    @RequestMapping(value={"/inventoryItemCount"}, method={RequestMethod.GET})
    @ResponseBody
    public List<TwoFieldReport> getInventoryItemCount() {
        List<TwoFieldReport> addTwoFieldReport = null;
        try {
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemReport() != null) {
                addTwoFieldReport = this.inventoryItemIssueAndReturnMasterService.inventoryItemReport();
            }
            return addTwoFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addTwoFieldReport;
        }
    }

    @RequestMapping(value={"/inventoryItemPercentage"}, method={RequestMethod.GET})
    @ResponseBody
    public String getInventoryItemPercentage() {
        try {
            String str = null;
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemPercentage() != null) {
                str = this.inventoryItemIssueAndReturnMasterService.inventoryItemPercentage();
            }
            return str;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/inventoryItemIssueCount"}, method={RequestMethod.GET})
    @ResponseBody
    public List<TwoFieldReport> getInventoryItemIssueCount() {
        List<TwoFieldReport> addTwoFieldReport = null;
        try {
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemIssuedReport() != null) {
                addTwoFieldReport = this.inventoryItemIssueAndReturnMasterService.inventoryItemIssuedReport();
            }
            return addTwoFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addTwoFieldReport;
        }
    }

    @RequestMapping(value={"/inventoryItemIssuedPercentage"}, method={RequestMethod.GET})
    @ResponseBody
    public String getInventoryItemIssuePercentage() {
        try {
            String str = null;
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemIssuedPercentage() != null) {
                str = this.inventoryItemIssueAndReturnMasterService.inventoryItemIssuedPercentage();
            }
            return str;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/inventoryItemReturnCount"}, method={RequestMethod.GET})
    @ResponseBody
    public List<TwoFieldReport> getInventoryItemReturnCount() {
        List<TwoFieldReport> addTwoFieldReport = null;
        try {
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnedReport() != null) {
                addTwoFieldReport = this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnedReport();
            }
            return addTwoFieldReport;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addTwoFieldReport;
        }
    }

    @RequestMapping(value={"/inventoryItemReturnedPercentage"}, method={RequestMethod.GET})
    @ResponseBody
    public String getInventoryItemReturnPercentage() {
        try {
            String str = null;
            if (this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnPercentage() != null) {
                str = this.inventoryItemIssueAndReturnMasterService.inventoryItemReturnPercentage();
            }
            return str;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentAppraisalList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentAppraisal> getStudentAppraisalList(HttpServletRequest request) {
        List<StudentAppraisal> addStudentAppraisal = null;
        try {
            String email = request.getSession().getAttribute("username").toString();
            Long acadmicYearId = Long.parseLong(request.getParameter("academicYear"));
            if (this.studentAppraisalService.studentAppraisalListByAcademicYearAndEmail(acadmicYearId, email) != null) {
                addStudentAppraisal = this.studentAppraisalService.studentAppraisalListByAcademicYearAndEmail(acadmicYearId, email);
            }
            return addStudentAppraisal;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addStudentAppraisal;
        }
    }

    @RequestMapping(value={"/staffAppraisalList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StaffAppraisal> getStaffAppraisalList(HttpServletRequest request) {
        List<StaffAppraisal> addStaffAppraisal = null;
        try {
            String email = request.getSession().getAttribute("username").toString();
            Long acadmicYearId = Long.parseLong(request.getParameter("academicYear"));
            if (this.staffAppraisalService.staffAppraisalListByAcademicYearAndEmail(acadmicYearId, email) != null) {
                addStaffAppraisal = this.staffAppraisalService.staffAppraisalListByAcademicYearAndEmail(acadmicYearId, email);
            }
            return addStaffAppraisal;
        }
        catch (Exception e) {
            e.printStackTrace();
            return addStaffAppraisal;
        }
    }
}
