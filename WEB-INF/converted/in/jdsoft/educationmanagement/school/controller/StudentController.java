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
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.security.access.prepost.PreAuthorize
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
import in.jdsoft.educationmanagement.school.exceptions.StudentException;
import in.jdsoft.educationmanagement.school.exceptions.StudentHostelIDCardGenerationException;
import in.jdsoft.educationmanagement.school.exceptions.StudentIDCardGenerationException;
import in.jdsoft.educationmanagement.school.exceptions.StudentTransportIDCardGenerationException;
import in.jdsoft.educationmanagement.school.exceptions.TransferCertificateRequisitionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Document;
import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Houses;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentHostelIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentLeaveType;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.AdmissionService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.DocumentService;
import in.jdsoft.educationmanagement.school.services.DocumentTypeService;
import in.jdsoft.educationmanagement.school.services.FeesTermService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.HousesService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.RequisitionTypeService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StudentAppraisalService;
import in.jdsoft.educationmanagement.school.services.StudentHostelIDCardGenerationService;
import in.jdsoft.educationmanagement.school.services.StudentIDCardGenerationService;
import in.jdsoft.educationmanagement.school.services.StudentLeaveRequisitionService;
import in.jdsoft.educationmanagement.school.services.StudentLeaveTypeService;
import in.jdsoft.educationmanagement.school.services.StudentMovementRequisitionService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.StudentStatusService;
import in.jdsoft.educationmanagement.school.services.StudentTransportIDCardGenerationService;
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
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="studentController")
@RequestMapping(value={"/student"})
public class StudentController {
    private Logger log = LogManager.getLogger((String)StudentController.class.getName());
    @Autowired
    private StudentService studentService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GeographicalLocationService geographicalLocationService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private BloodGroupService bloodGroupService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private HashGenerator hashGenerator;
    @Autowired
    private FileUploadHandler fileUploadHandler;
    @Autowired
    private StudentStatusService studentStatusService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private SpecialCategoryService specialCategoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private StudentIDCardGenerationService studentIDCardGenerationService;
    @Autowired
    private StudentLeaveRequisitionService studentLeaveRequisitionService;
    @Autowired
    private StudentLeaveTypeService studentLeaveTypeService;
    @Autowired
    private RequisitionTypeService requisitionTypeService;
    @Autowired
    private TCRequisitionService tcRequisitionService;
    @Autowired
    private StudentMovementRequisitionService studentMovementRequisitionService;
    @Autowired
    private HousesService houseService;
    @Autowired
    private ClassSectionService classSectionService;
    @Autowired
    private StudentAppraisalService studentAppraisalService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private FeesTermService feesTermService;
    @Autowired
    private StudentTransportIDCardGenerationService studentTransportIDCardGenerationService;
    @Autowired
    private StudentHostelIDCardGenerationService studentHostelIDCardGenerationService;

    @RequestMapping(method={RequestMethod.GET}, value={"managestudent"})
    @PreAuthorize(value="hasAuthority('managestudent')")
    public ModelAndView displayManageStudentPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student page"));
            ModelAndView modelandview = new ModelAndView("managestudent");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String eMail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(eMail);
            boolean superadmin = false;
            for (UserRole userRoles : user.getUserRoles()) {
                if (!userRoles.getRoleName().equals("SuperAdministrator")) continue;
                superadmin = true;
            }
            modelandview.addObject("categories", this.categoryService.categoryList());
            modelandview.addObject("countries", this.geographicalLocationService.countryList());
            modelandview.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("studentStatus", this.studentStatusService.studentStatusList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            modelandview.addObject("sections", this.sectionService.sectionList());
            modelandview.addObject("joinedclasses", this.classService.classList());
            if (superadmin) {
                modelandview.addObject("studentList", this.studentService.studentListEager(institutionId));
                modelandview.addObject("userRoles", this.userRoleService.userRoleList(institutionId));
                modelandview.addObject("classes", this.classService.classList());
                modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList());
                modelandview.addObject("houseList", this.houseService.housesList());
                modelandview.addObject("documentTypeList", this.documentTypeService.documentTypeList());
            } else {
                modelandview.addObject("studentList", this.studentService.studentListEager(institutionId));
                modelandview.addObject("userRoles", this.userRoleService.userRoleList(institutionId));
                modelandview.addObject("classes", this.classService.classList(institutionId));
                modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList(institutionId));
                modelandview.addObject("houseList", this.houseService.housesList(institutionId));
                modelandview.addObject("documentTypeList", this.documentTypeService.documentTypeList(institutionId));
            }
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"studentpromotion"})
    public ModelAndView displayManageStudentPromotionPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student promotion page"));
            ModelAndView modelandview = new ModelAndView("studentpromotion");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String eMail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(eMail);
            boolean superadmin = false;
            for (UserRole userRoles : user.getUserRoles()) {
                if (!userRoles.getRoleName().equals("SuperAdministrator")) continue;
                superadmin = true;
            }
            if (superadmin) {
                modelandview.addObject("currentclasses", this.classService.classList());
                modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList());
            } else {
                modelandview.addObject("currentclasses", this.classService.classList(institutionId));
                modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList(institutionId));
            }
            modelandview.addObject("classes", this.classService.classList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"studentappraisal"})
    public ModelAndView displayStudentAppraisalPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student appraisal page"));
            ModelAndView modelandview = new ModelAndView("studentappraisal");
            modelandview.addObject("studentList", this.studentService.studentList());
            modelandview.addObject("classes", this.classService.classList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studentappraisal/reports"})
    public ModelAndView displayStudentAppraisalByStaffPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student appraisal page"));
            String email = request.getSession().getAttribute("username").toString();
            Staff staff = this.staffService.staffByEmailEager(email);
            LinkedHashSet<Student> studentList = new LinkedHashSet<Student>();
            LinkedHashSet<Class> classList = new LinkedHashSet<Class>();
            if (staff != null) {
                for (ClassSection classSection : staff.getClassSections()) {
                    if (!this.studentService.activeStudentListByClassAndSectionId(classSection.getClassSection().getClassId(), classSection.getSectionClass().getSectionId()).isEmpty()) {
                        studentList.addAll(this.studentService.activeStudentListByClassAndSectionId(classSection.getClassSection().getClassId(), classSection.getSectionClass().getSectionId()));
                    }
                    if (this.classService.classById(classSection.getClassSection().getClassId()) == null) continue;
                    classList.add(this.classService.classById(classSection.getClassSection().getClassId()));
                }
            }
            ModelAndView modelandview = new ModelAndView("studentappraisalbystaff");
            modelandview.addObject("studentList", studentList);
            modelandview.addObject("classes", classList);
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/studentAppraisalList"}, method={RequestMethod.GET})
    @ResponseBody
    public List<StudentAppraisal> getStudentPerformanceList(HttpServletRequest request) throws ServletException, IOException {
        ArrayList<StudentAppraisal> studentAppraisals = new ArrayList<StudentAppraisal>();
        try {
            String classNameOrId = request.getParameter("class");
            String admissionNo = null;
            if (!request.getParameter("admissionNumber").isEmpty()) {
                admissionNo = request.getParameter("admissionNumber");
                if (this.studentAppraisalService.studentAppraisalListByStudentAdmissionNumber(admissionNo) != null) {
                    studentAppraisals.addAll(this.studentAppraisalService.studentAppraisalListByStudentAdmissionNumber(admissionNo));
                }
            } else if (classNameOrId.equals("all")) {
                studentAppraisals.addAll(this.studentAppraisalService.studentAppraisalList());
            } else {
                String[] sections;
                Long classId = Long.parseLong(classNameOrId);
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String selectedsectionId = stringArray[n2];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentAppraisalService.studentAppraisalListByClassAndSection(classId, sectionId) != null) {
                        studentAppraisals.addAll(this.studentAppraisalService.studentAppraisalListByClassAndSection(classId, sectionId));
                    }
                    ++n2;
                }
            }
            return studentAppraisals;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/addStudentAppraisal"}, method={RequestMethod.POST})
    public String addStudentAppraisal(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String createdByUser = request.getSession().getAttribute("username").toString();
            String admissionNo = request.getParameter("studentAdmissionNumber");
            String appraisalTerm = request.getParameter("appraisalTerm");
            String relationshipRating = request.getParameter("relationshipRating");
            String relationshipComments = request.getParameter("relationshipComments");
            String attitudeRating = request.getParameter("attitudeRating");
            String attitudeComments = request.getParameter("attitudeComments");
            String academicRating = request.getParameter("academicRating");
            String academicComments = request.getParameter("academicComments");
            String initiativeRating = request.getParameter("initiativeRating");
            String initiativeComments = request.getParameter("initiativeComments");
            String creativityRating = request.getParameter("creativityRating");
            String creativityComments = request.getParameter("creativityComments");
            String punctualityRating = request.getParameter("punctualityRating");
            String punctualityComments = request.getParameter("punctualityComments");
            String sportsAndSocialRating = request.getParameter("sportsAndSocialRating");
            String sportsAndSocialComments = request.getParameter("sportsAndSocialComments");
            String recommentation = request.getParameter("recommentation");
            String appraisalStatus = request.getParameter("appraisalStatus");
            String appraisalCreatedByUser = request.getSession().getAttribute("username").toString();
            Student student = this.studentService.studentByAdmissionNo(admissionNo);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            StudentAppraisal studentAppraisal = new StudentAppraisal(appraisalTerm, relationshipRating, relationshipComments, attitudeRating, attitudeComments, academicRating, academicComments, initiativeRating, initiativeComments, creativityRating, creativityComments, punctualityRating, punctualityComments, sportsAndSocialRating, sportsAndSocialComments, appraisalCreatedByUser, recommentation, appraisalStatus, student, student.getStudentClass(), student.getSection(), academicYear, institution, createdByUser, createdByUser);
            this.studentAppraisalService.createStudentAppraisal(studentAppraisal);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Appraisal Created Successfully...!"));
            return "redirect:/student/studentappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/student/studentappraisal";
        }
    }

    @RequestMapping(value={"/editStudentPerformance"}, method={RequestMethod.GET})
    @ResponseBody
    public StudentAppraisal editStudentAppraisal(HttpServletRequest request) {
        try {
            Long studentAppraisalId = Long.parseLong(request.getParameter("studentAppraisalId"));
            StudentAppraisal studentAppraisal = this.studentAppraisalService.studentAppraisalById(studentAppraisalId);
            return studentAppraisal;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentappraisaldelete"}, method={RequestMethod.POST})
    public String deleteStudentPerformance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long studentAppraisalId = Long.parseLong(request.getParameter("deleteStudentAppraisalId"));
            this.studentAppraisalService.deleteStudentAppraisal(studentAppraisalId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Appraisal Deleted Successfully...!"));
            return "redirect:/student/studentappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/student/studentappraisal";
        }
    }

    @RequestMapping(value={"/updateStudentAppraisal"}, method={RequestMethod.POST})
    public String updateStudentPerformance(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String studentAdmissionNumber = request.getParameter("editStudentAdmissionNumber");
            String appraisalTerm = request.getParameter("editAppraisalTerm");
            String relationshipRating = request.getParameter("editRelationshipRating");
            String relationshipComments = request.getParameter("editRelationshipComments");
            String attitudeRating = request.getParameter("editAttitudeRating");
            String attitudeComments = request.getParameter("editAttitudeComments");
            String academicRating = request.getParameter("editAcademicRating");
            String academicComments = request.getParameter("editAcademicComments");
            String initiativeRating = request.getParameter("editInitiativeRating");
            String initiativeComments = request.getParameter("editInitiativeComments");
            String creativityRating = request.getParameter("editCreativityRating");
            String creativityComments = request.getParameter("editCreativityComments");
            String punctualityRating = request.getParameter("editPunctualityRating");
            String punctualityComments = request.getParameter("editPunctualityComments");
            String sportsAndSocialRating = request.getParameter("editSportsAndSocialRating");
            String sportsAndSocialComments = request.getParameter("editSportsAndSocialComments");
            String recommentation = request.getParameter("editRecommentation");
            String appraisalStatus = request.getParameter("editAppraisalStatus");
            String modifiedByUser = request.getSession().getAttribute("username").toString();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            Long studentAppraisalId = Long.parseLong(request.getParameter("updateStudentAppraisalId"));
            StudentAppraisal studentAppraisal = this.studentAppraisalService.studentAppraisalById(studentAppraisalId);
            Student student = this.studentService.studentByAdmissionNo(studentAdmissionNumber);
            studentAppraisal.setStudent(student);
            studentAppraisal.setAppraisalTerm(appraisalTerm);
            studentAppraisal.setRelationshipRating(relationshipRating);
            studentAppraisal.setRelationshipComments(relationshipComments);
            studentAppraisal.setAttitudeRating(attitudeRating);
            studentAppraisal.setAttitudeComments(attitudeComments);
            studentAppraisal.setAcademicRating(academicRating);
            studentAppraisal.setAcademicComments(academicComments);
            studentAppraisal.setInitiativeRating(initiativeRating);
            studentAppraisal.setInitiativeComments(initiativeComments);
            studentAppraisal.setCreativityRating(creativityRating);
            studentAppraisal.setCreativityComments(creativityComments);
            studentAppraisal.setPunctualityRating(punctualityRating);
            studentAppraisal.setPunctualityComments(punctualityComments);
            studentAppraisal.setSportsAndSocialRating(sportsAndSocialRating);
            studentAppraisal.setSportsAndSocialComments(sportsAndSocialComments);
            studentAppraisal.setRecommendations(recommentation);
            studentAppraisal.setAppraisalStatus(appraisalStatus);
            studentAppraisal.setAcademicYear(academicYear);
            studentAppraisal.setInstitution(institution);
            studentAppraisal.setModifiedBy(modifiedByUser);
            studentAppraisal.setStudentClass(student.getStudentClass());
            studentAppraisal.setSection(student.getSection());
            this.studentAppraisalService.updateStudentAppraisal(studentAppraisal);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Appraisal Updated Successfully...!"));
            return "redirect:/student/studentappraisal";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
            e.printStackTrace();
            return "redirect:/student/studentappraisal";
        }
    }

    @RequestMapping(value={"/studentpromotion/update"}, method={RequestMethod.POST})
    public String studentPromotion(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] studentIds = request.getParameterValues("selectedStudentIds");
            Long classId = Long.parseLong(request.getParameter("promotionclassList"));
            Class classes = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("promotionsectionList"));
            Section section = this.sectionService.sectionById(sectionId);
            String[] stringArray = studentIds;
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                String studetId = stringArray[n2];
                String[] stuid = studetId.split(",");
                stuid = (String[])Arrays.stream(stuid).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                Long[] deleteStudentIds = new Long[stuid.length];
                int i = 0;
                while (i < stuid.length) {
                    deleteStudentIds[i] = Long.parseLong(stuid[i].toString());
                    ++i;
                }
                this.studentService.promoteListOfStudents(deleteStudentIds, classes, section);
                ++n2;
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Students Promoted Successfully...!"));
            return "redirect:/student/studentpromotion";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentpromotion";
            }
            e.printStackTrace();
            return "redirect:/student/studentpromotion";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/timetable"})
    public ModelAndView displayStudentTimeTablePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student timetable page"));
            ModelAndView modelandview = new ModelAndView("studenttimetable");
            String studentEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("student", (Object)this.studentService.studentByEmailEager(studentEmail));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studentidcardgeneration"})
    public ModelAndView displayStudentIdCardGenerationPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student id card generation page"));
            ModelAndView modelandview = new ModelAndView("studentidcardgeneration");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classes", this.classService.classList());
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            if (request.getSession().getAttribute("feeadminadmintype").toString().equals("1")) {
                modelandview.addObject("feesTerms", this.feesTermService.feesTermList());
            } else {
                modelandview.addObject("feesTerms", this.feesTermService.feesTermList(institutionId));
            }
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/studentidcardgeneration/preview"})
    public ModelAndView displayStudentIdCardGenerationViewPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student id card generation view page"));
            ModelAndView modelandview = new ModelAndView("viewstudentidcardgeneration");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String studentIDCardDetails = request.getParameter("studentIDCardManagementDetails");
            String[] ids = studentIDCardDetails.split("-");
            String classId = ids[0].toString();
            String sectionId = ids[1].toString();
            String academicYearId = ids[2].toString();
            modelandview.addObject("studentIDCardGenerationLists", this.studentIDCardGenerationService.studentIDCardGenerationListByClassAndSectionAndAcademicYear(Long.parseLong(classId), Long.parseLong(sectionId), Long.parseLong(academicYearId), institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/studenthostelidcardgeneration/preview"})
    public ModelAndView displayStudentHostelIdCardGenerationViewPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student id card generation view page"));
            ModelAndView modelandview = new ModelAndView("viewstudenthostelidcardgeneration");
            String studentHostelIDCardManagementDetails = request.getParameter("studentHostelIDCardManagementDetails");
            String[] ids = studentHostelIDCardManagementDetails.split("-");
            String classId = ids[0].toString();
            String sectionId = ids[1].toString();
            String criteriaId = ids[2].toString();
            if (criteriaId.equals("academicyear")) {
                String academicYearId = ids[3].toString();
                modelandview.addObject("studentHostelIDCardGenerationLists", this.studentHostelIDCardGenerationService.StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(Long.parseLong(classId), Long.parseLong(sectionId), Long.parseLong(academicYearId)));
            } else if (criteriaId.equals("feescategory")) {
                String feesTermId = ids[4].toString();
                modelandview.addObject("studentHostelIDCardGenerationLists", this.studentHostelIDCardGenerationService.StudentHostelIDCardGenerationListByClassAndSectionAndFeesTerm(Long.parseLong(classId), Long.parseLong(sectionId), Long.parseLong(feesTermId)));
            }
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/studenttransportidcardgeneration/preview"})
    public ModelAndView displayStudentTransportIdCardGenerationViewPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student id card generation view page"));
            ModelAndView modelandview = new ModelAndView("viewstudenttransportidcardgeneration");
            String studentTransportIDCardManagementDetails = request.getParameter("studentTransportIDCardManagementDetails");
            String[] ids = studentTransportIDCardManagementDetails.split("-");
            String classId = ids[0].toString();
            String sectionId = ids[1].toString();
            String criteriaId = ids[2].toString();
            if (criteriaId.equals("academicyear")) {
                String academicYearId = ids[3].toString();
                modelandview.addObject("studentTransportIDCardGenerationLists", this.studentTransportIDCardGenerationService.StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(Long.parseLong(classId), Long.parseLong(sectionId), Long.parseLong(academicYearId)));
            } else if (criteriaId.equals("feescategory")) {
                String feesTermId = ids[4].toString();
                modelandview.addObject("studentTransportIDCardGenerationLists", this.studentTransportIDCardGenerationService.StudentTransportIDCardGenerationListByClassAndSectionAndFeesTerm(Long.parseLong(classId), Long.parseLong(sectionId), Long.parseLong(feesTermId)));
            }
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"/studentidcardgeneration/add"}, method={RequestMethod.POST})
    public String createStudentIDCardGeneration(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentIDCardGeneration"));
            Long classId = Long.parseLong(request.getParameter("moduleClassId"));
            Class classes = this.classService.classById(classId);
            Long sectionId = Long.parseLong(request.getParameter("moduleSectionId"));
            Section section = this.sectionService.sectionById(sectionId);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            Long academicYearId = Long.parseLong(request.getParameter("moduleAcademicYearId"));
            AcademicYear academicYear = this.academicYearService.academicYearById(academicYearId);
            List<Object> students = new ArrayList();
            students = this.studentService.activeStudentListByClassAndSectionAndInstitution(classId, sectionId, institutionId);
            LinkedHashSet<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>();
            String createdBy = request.getSession().getAttribute("username").toString();
            for (Student student : students) {
                StudentStatus studentStatus = null;
                if (student.getStudentStatus() != null) {
                    studentStatus = student.getStudentStatus();
                }
                BloodGroup bloodGroup = null;
                if (student.getBloodGroup() != null) {
                    bloodGroup = student.getBloodGroup();
                }
                Class studentClass = null;
                if (classes != null) {
                    studentClass = classes;
                }
                Section studentSection = null;
                if (section != null) {
                    studentSection = section;
                }
                String applicationRootPath = request.getRealPath("/");
                String imagelocation = "/resources/themes/images/student-barcode-image/" + studentClass.getClassName() + "/" + studentSection.getSectionName() + "/";
                String barCodeImageLocation = String.valueOf(applicationRootPath) + "@" + imagelocation;
                StudentIDCardGeneration studentIDCardGeneration = new StudentIDCardGeneration(student, academicYear, studentStatus, bloodGroup, institution, studentClass, studentSection, student.getFirstName(), student.getLastName(), student.getParentGuardianFirstName(), student.getParentGuardianLastName(), student.getParentGuardianEmail(), student.getSex(), student.getBirthDate(), student.getAddressLine1(), student.getAddressLine2(), student.getCity(), student.getState(), student.getCountry(), student.getPostcode(), student.getEmail(), student.getContact(), student.getParentContact(), createdBy, createdBy, student.getAdmissionNo(), student.getRollNo(), institution.getInstitutionAddressline1(), institution.getInstitutionAddressline2(), institution.getInstitutionCity(), institution.getInstitutionState(), institution.getInstitutionCountry(), institution.getInstitutionPostcode(), institution.getInstitutionEmail(), institution.getInstitutionPostcode(), institution.getAuthorizedSignature(), institution.getInstitutionName(), institution.getInstitutionLogo());
                studentIDCardGeneration.setBarCodeImage(barCodeImageLocation);
                studentIDCardGenerations.add(studentIDCardGeneration);
            }
            this.studentIDCardGenerationService.createBarCodeAndBarCodeImage(studentIDCardGenerations);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student ID Card Generated Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentIDCardGenerationException.class)) {
                StudentIDCardGenerationException studentIDCardGenerationException = (StudentIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(value={"/studentidcardgeneration/delete"}, method={RequestMethod.POST})
    public String createStudentIDCardDelete(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentIDCardDelete"));
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
            this.studentIDCardGenerationService.deleteStudentIDCard(classId, sectionId, academicYearId, institutionId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student ID Card Deleted Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentIDCardGenerationException.class)) {
                StudentIDCardGenerationException studentIDCardGenerationException = (StudentIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studentidcardgeneration/view"})
    @ResponseBody
    public List<StudentIDCardGeneration> viewStudentIDCardGenerationList(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to view studentIDCardGeneration"));
            Long classId = Long.parseLong(request.getParameter("overAllClassId"));
            Long sectionId = Long.parseLong(request.getParameter("overAllSectionId"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long academicYearId = Long.parseLong(request.getParameter("overAllAcademicYearId"));
            ArrayList<StudentIDCardGeneration> studentIDCardGenerationList = new ArrayList();
            studentIDCardGenerationList = this.studentIDCardGenerationService.studentIDCardGenerationListByClassAndSectionAndAcademicYear(classId, sectionId, academicYearId, institutionId);
            return studentIDCardGenerationList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/studenttrasportidcardgeneration/add"}, method={RequestMethod.POST})
    public String createStudentTransportIDCardGeneration(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentTransportIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentIDCardGeneration"));
            String criteria = request.getParameter("transportidgenerationcriteriaId");
            AcademicYear academicYear = null;
            FeesTerm feesTerm = null;
            if (criteria.equals("academicyear")) {
                Long academicYearId = Long.parseLong(request.getParameter("transportIDCardGenerationAcademicYearId"));
                academicYear = this.academicYearService.academicYearById(academicYearId);
            } else if (criteria.equals("feescategory")) {
                Long feesTermId = Long.parseLong(request.getParameter("transportIDCardGenerationFeesTermId"));
                feesTerm = this.feesTermService.feesTermById(feesTermId);
            }
            String admissionNo = request.getParameter("transportIDCardGenerationAdmissionNumber");
            Student student = this.studentService.studentByAdmissionNoEager(admissionNo);
            Long classId = student.getStudentClass().getClassId();
            Long sectionId = student.getSection().getSectionId();
            Class classes = this.classService.classById(classId);
            Section section = this.sectionService.sectionById(sectionId);
            Long institutionId = student.getInstitution().getInstitutionId();
            Institution institution = this.institutionService.institutionById(institutionId);
            String createdBy = request.getSession().getAttribute("username").toString();
            Class studentClass = null;
            if (classes != null) {
                studentClass = classes;
            }
            Section studentSection = null;
            if (section != null) {
                studentSection = section;
            }
            String applicationRootPath = request.getRealPath("/");
            String imagelocation = "/resources/themes/images/student-transport-barcode-image/" + studentClass.getClassName() + "/" + studentSection.getSectionName() + "/";
            String barCodeImageLocation = String.valueOf(applicationRootPath) + "@" + imagelocation;
            StudentTransportIDCardGeneration studentTransportIDCardGeneration = new StudentTransportIDCardGeneration(academicYear, institution, studentClass, studentSection, student, feesTerm, createdBy, createdBy);
            studentTransportIDCardGeneration.setBarCodeImage(barCodeImageLocation);
            this.studentTransportIDCardGenerationService.createBarCodeAndBarCodeImage(studentTransportIDCardGeneration);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Transport ID Card Generated Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentTransportIDCardGenerationException.class)) {
                StudentTransportIDCardGenerationException studentTransportIDCardGenerationException = (StudentTransportIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentTransportIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studenttransportidcardgeneration/view"})
    @ResponseBody
    public List<StudentTransportIDCardGeneration> viewStudentTransportIDCardGenerationList(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to view studentTransportIDCardGeneration"));
            List<StudentTransportIDCardGeneration> studentTransportIDCardGenerationList = new ArrayList<StudentTransportIDCardGeneration>();
            String criteria = request.getParameter("transportidviewcriteriaId");
            Long classId = Long.parseLong(request.getParameter("transportIDCardViewClassId"));
            Long sectionId = Long.parseLong(request.getParameter("transportIDCardViewSectionId"));
            Long academicYearId = null;
            Long feesTermId = null;
            if (criteria.equals("academicyear")) {
                academicYearId = Long.parseLong(request.getParameter("transportIDCardViewAcademicYearId"));
                studentTransportIDCardGenerationList = this.studentTransportIDCardGenerationService.StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(classId, sectionId, academicYearId);
            } else if (criteria.equals("feescategory")) {
                feesTermId = Long.parseLong(request.getParameter("transportIDCardViewFeesTermId"));
                studentTransportIDCardGenerationList = this.studentTransportIDCardGenerationService.StudentTransportIDCardGenerationListByClassAndSectionAndFeesTerm(classId, sectionId, feesTermId);
            }
            return studentTransportIDCardGenerationList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/studenttransportidcardgeneration/delete"}, method={RequestMethod.POST})
    public String createStudentTransportIDCardDelete(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentTransportIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentTransportIDCardDelete"));
            String criteria = request.getParameter("transportiddeletecriteriaId");
            Long classId = Long.parseLong(request.getParameter("transportIDCardDeleteClassId"));
            Long sectionId = Long.parseLong(request.getParameter("transportIDCardDeleteSectionId"));
            Long academicYearId = null;
            Long feesTermId = null;
            if (criteria.equals("academicyear")) {
                academicYearId = Long.parseLong(request.getParameter("transportIDCardDeleteAcademicYearId"));
                this.studentTransportIDCardGenerationService.deleteStudentTransportIDCardByClassAndSectionAndAcademicYear(classId, sectionId, academicYearId);
            } else if (criteria.equals("feescategory")) {
                feesTermId = Long.parseLong(request.getParameter("transportIDCardDeleteFeesCategoryId"));
                this.studentTransportIDCardGenerationService.deleteStudentTransportIDCardByClassAndSectionAndFeesTerm(classId, sectionId, feesTermId);
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Transport ID Card Deleted Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentTransportIDCardGenerationException.class)) {
                StudentTransportIDCardGenerationException studentTransportIDCardGenerationException = (StudentTransportIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentTransportIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(value={"/studenthostelidcardgeneration/add"}, method={RequestMethod.POST})
    public String createStudentHostelIDCardGeneration(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentTransportIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentHostelIDCardGeneration"));
            String criteria = request.getParameter("hostelidgenerationcriteriaId");
            AcademicYear academicYear = null;
            FeesTerm feesTerm = null;
            if (criteria.equals("academicyear")) {
                Long academicYearId = Long.parseLong(request.getParameter("hostelIDCardGenerationAcademicYearId"));
                academicYear = this.academicYearService.academicYearById(academicYearId);
            } else if (criteria.equals("feescategory")) {
                Long feesTermId = Long.parseLong(request.getParameter("hostelIDCardGenerationFeesTermId"));
                feesTerm = this.feesTermService.feesTermById(feesTermId);
            }
            String admissionNo = request.getParameter("hostelIDCardGenerationAdmissionNumber");
            Student student = this.studentService.studentByAdmissionNoEager(admissionNo);
            Long classId = student.getStudentClass().getClassId();
            Long sectionId = student.getSection().getSectionId();
            Class classes = this.classService.classById(classId);
            Section section = this.sectionService.sectionById(sectionId);
            Long institutionId = student.getInstitution().getInstitutionId();
            Institution institution = this.institutionService.institutionById(institutionId);
            String createdBy = request.getSession().getAttribute("username").toString();
            Class studentClass = null;
            if (classes != null) {
                studentClass = classes;
            }
            Section studentSection = null;
            if (section != null) {
                studentSection = section;
            }
            String applicationRootPath = request.getRealPath("/");
            String imagelocation = "/resources/themes/images/student-hostel-barcode-image/" + studentClass.getClassName() + "/" + studentSection.getSectionName() + "/";
            String barCodeImageLocation = String.valueOf(applicationRootPath) + "@" + imagelocation;
            StudentHostelIDCardGeneration studentHostelIDCardGeneration = new StudentHostelIDCardGeneration(academicYear, institution, studentClass, studentSection, student, feesTerm, createdBy, createdBy);
            studentHostelIDCardGeneration.setBarCodeImage(barCodeImageLocation);
            this.studentHostelIDCardGenerationService.createBarCodeAndBarCodeImage(studentHostelIDCardGeneration);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Hostel ID Card Generated Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentHostelIDCardGenerationException.class)) {
                StudentHostelIDCardGenerationException studentHostelIDCardGenerationException = (StudentHostelIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentHostelIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studenthostelidcardgeneration/view"})
    @ResponseBody
    public List<StudentHostelIDCardGeneration> viewStudentHostelIDCardGenerationList(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to view studentTransportIDCardGeneration"));
            List<StudentHostelIDCardGeneration> studentHostelIDCardGenerationList = new ArrayList<StudentHostelIDCardGeneration>();
            String criteria = request.getParameter("hostelidviewcriteriaId");
            Long classId = Long.parseLong(request.getParameter("hostelIDCardViewClassId"));
            Long sectionId = Long.parseLong(request.getParameter("hostelIDCardViewSectionId"));
            Long academicYearId = null;
            Long feesTermId = null;
            if (criteria.equals("academicyear")) {
                academicYearId = Long.parseLong(request.getParameter("hostelIDCardViewAcademicYearId"));
                studentHostelIDCardGenerationList = this.studentHostelIDCardGenerationService.StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(classId, sectionId, academicYearId);
            } else if (criteria.equals("feescategory")) {
                feesTermId = Long.parseLong(request.getParameter("hostelIDCardViewFeesTermId"));
                studentHostelIDCardGenerationList = this.studentHostelIDCardGenerationService.StudentHostelIDCardGenerationListByClassAndSectionAndFeesTerm(classId, sectionId, feesTermId);
            }
            return studentHostelIDCardGenerationList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/studenthostelidcardgeneration/delete"}, method={RequestMethod.POST})
    public String createStudentHostelIDCardDelete(HttpServletRequest request, RedirectAttributes redirectAttributes) throws StudentTransportIDCardGenerationException, Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create studentHostelIDCardDelete"));
            String criteria = request.getParameter("hosteliddeletecriteriaId");
            Long classId = Long.parseLong(request.getParameter("hostelIDCardDeleteClassId"));
            Long sectionId = Long.parseLong(request.getParameter("hostelIDCardDeleteSectionId"));
            Long academicYearId = null;
            Long feesTermId = null;
            if (criteria.equals("academicyear")) {
                academicYearId = Long.parseLong(request.getParameter("hostelIDCardDeleteAcademicYearId"));
                this.studentHostelIDCardGenerationService.deleteStudentHostelIDCardByClassAndSectionAndAcademicYear(classId, sectionId, academicYearId);
            } else if (criteria.equals("feescategory")) {
                feesTermId = Long.parseLong(request.getParameter("hostelIDCardDeleteFeesCategoryId"));
                this.studentHostelIDCardGenerationService.deleteStudentHostelIDCardByClassAndSectionAndFeesTerm(classId, sectionId, feesTermId);
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Hostel ID Card Deleted Successfully...!"));
            return "redirect:/student/studentidcardgeneration";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done"));
                return "redirect:/student/studentidcardgeneration";
            }
            if (e.getClass().equals(StudentHostelIDCardGenerationException.class)) {
                StudentHostelIDCardGenerationException studentHostelIDCardGenerationException = (StudentHostelIDCardGenerationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentHostelIDCardGenerationException.getCustomMessage());
                return "redirect:/student/studentidcardgeneration";
            }
            e.printStackTrace();
            return "redirect:/student/studentidcardgeneration";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/parenttimetable"})
    public ModelAndView displayStudentParentTimeTablePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed parent timetable page"));
            ModelAndView modelandview = new ModelAndView("parenttimetable");
            String parentEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("student", (Object)this.studentService.studentByParentEmailEager(parentEmail));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/studentattendancedetails"})
    public ModelAndView displayStudentViewDetailsPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student attendance details page"));
            ModelAndView modelandview = new ModelAndView("studentattendancedetails");
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/profile"})
    public ModelAndView displayStudentProfilePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed student profile page"));
            ModelAndView modelandview = new ModelAndView("studentprofile");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String studentEmail = request.getSession().getAttribute("username").toString();
            modelandview.addObject("student", (Object)this.studentService.studentByEmailEager(studentEmail));
            modelandview.addObject("categories", this.categoryService.categoryList());
            modelandview.addObject("countries", this.geographicalLocationService.countryList());
            modelandview.addObject("userRoles", this.userRoleService.userRoleList(institutionId));
            modelandview.addObject("bloodGroups", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("studentStatus", this.studentStatusService.studentStatusList());
            modelandview.addObject("classes", this.classService.classList(institutionId));
            modelandview.addObject("sections", this.sectionService.sectionList());
            modelandview.addObject("academicYears", this.academicYearService.academicYearList(institutionId));
            modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList(institutionId));
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
    @PreAuthorize(value="hasAuthority('managestudent/add')")
    public String createStudent(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="documents") MultipartFile[] documents, @RequestParam(value="studentProfilePic") MultipartFile multipartFile, @RequestParam(value="studentSignature") MultipartFile scannedSignature, @RequestParam(value="parentProfilePic") MultipartFile parentProfilePicture) throws Exception {
        String redirectString = "redirect:/student/managestudent";
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create student"));
            Admission admission = null;
            if (request.getParameter("applicantCode") != "" && request.getParameter("applicantCode") != null) {
                admission = this.admissionService.getFullAdmissionDetailsByApplicantCode(request.getParameter("applicantCode"));
                redirectString = "redirect:/admissions/newadmission";
            }
            Long joinClassId = Long.parseLong(request.getParameter("joinedClass"));
            Class joinedClass = this.classService.classById(joinClassId);
            Long sectionId = Long.parseLong(request.getParameter("joinedSection"));
            Section studentSection = this.sectionService.sectionById(sectionId);
            Long categoryId = Long.parseLong(request.getParameter("categoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            String[] specialCategoryIds = request.getParameterValues("specialCategoryId");
            HashSet<SpecialCategory> specialCategories = new HashSet<SpecialCategory>();
            String[] stringArray = specialCategoryIds;
            int n = specialCategoryIds.length;
            int n2 = 0;
            while (n2 < n) {
                String specialCategoryId = stringArray[n2];
                specialCategories.add(this.specialCategoryService.specialCategoryById(Long.parseLong(specialCategoryId)));
                ++n2;
            }
            Long houseId = Long.parseLong(request.getParameter("houseId"));
            Houses house = this.houseService.housesById(houseId);
            Long studentStatusId = Long.parseLong(request.getParameter("studentStatus"));
            StudentStatus studentStatus = this.studentStatusService.studentStatusById(studentStatusId);
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String parentGuardianFirstName = request.getParameter("parentOrGuardianFirstName");
            String parentGuardianLastName = request.getParameter("parentOrGuardianLastName");
            String parentGuardianEmail = request.getParameter("parentOrGuardianEmail");
            String sex = request.getParameter("studentGender");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long aadharCardNumber = null;
            if (!request.getParameter("aadharCardNumber").isEmpty()) {
                aadharCardNumber = Long.parseLong(request.getParameter("aadharCardNumber"));
            }
            Date birthDate = formatter.parse(request.getParameter("dateOfBirth"));
            Double fathersIncome = null;
            if (!request.getParameter("fatherIncome").isEmpty()) {
                fathersIncome = Double.parseDouble(request.getParameter("fatherIncome"));
            }
            Double mothersIncome = null;
            if (!request.getParameter("motherIncome").isEmpty()) {
                mothersIncome = Double.parseDouble(request.getParameter("motherIncome"));
            }
            BloodGroup bloodGroup = null;
            if (request.getParameter("bloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("bloodGroupId")));
            }
            String addressLine1 = request.getParameter("addressLine1");
            String addressLine2 = request.getParameter("addressLine2");
            String country = request.getParameter("country");
            String state = request.getParameter("state");
            String city = request.getParameter("city");
            String postcode = request.getParameter("postCode");
            String email = request.getParameter("eMail");
            String contact = request.getParameter("contact");
            String passportNumber = request.getParameter("passportNo");
            Date joinedDate = formatter.parse(request.getParameter("joinedDate"));
            String accessNo = request.getParameter("studentAccessNo");
            String admissionNo = request.getParameter("studentAdmissionNo");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            Long academicYearId = Long.parseLong(request.getParameter("academicYearId"));
            AcademicYear academicYear = this.academicYearService.academicYearById(academicYearId);
            String createdBy = request.getSession().getAttribute("username").toString();
            String rollNo = null;
            if (!request.getParameter("rollNo").isEmpty()) {
                rollNo = request.getParameter("rollNo");
            }
            String profilePath = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-profile/", multipartFile.getOriginalFilename());
            }
            if (admission != null && profilePath == "") {
                profilePath = admission.getCandidatePhotoPath();
            }
            if (profilePath == "") {
                profilePath = "/resources/themes/images/profile-pic/a.png";
            }
            String studentSignature = "";
            if (scannedSignature != null && !scannedSignature.isEmpty()) {
                studentSignature = this.fileUploadHandler.uploadFile(scannedSignature.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-signature/", scannedSignature.getOriginalFilename());
            }
            if (admission != null && studentSignature == "") {
                studentSignature = admission.getScannedSignaturePath();
            }
            if (studentSignature == "") {
                studentSignature = "/resources/themes/images/profile-pic/a.png";
            }
            String parentContact = request.getParameter("parentContact");
            HashSet<UserRole> userRoles = new HashSet<UserRole>();
            userRoles.add(this.userRoleService.userRoleBy("student", institutionId));
            String defaultPssword = "student";
            String hash = this.hashGenerator.encoder(defaultPssword);
            User user = null;
            String parentProfilePath = "";
            if (parentProfilePicture != null && !parentProfilePicture.isEmpty()) {
                parentProfilePath = this.fileUploadHandler.uploadFile(parentProfilePicture.getBytes(), request.getRealPath("/"), "/resources/themes/images/parent-profile/", parentProfilePicture.getOriginalFilename());
            }
            if (parentProfilePath == "") {
                parentProfilePath = "/resources/themes/images/profile-pic/a.png";
            }
            String defaultParentPssword = "parent";
            HashSet<UserRole> parentUserRoles = new HashSet<UserRole>();
            parentUserRoles.add(this.userRoleService.userRoleBy("parent", institutionId));
            String parentHash = this.hashGenerator.encoder(defaultPssword);
            User parentUser = new User(parentUserRoles, String.valueOf(parentGuardianFirstName) + " " + parentGuardianLastName, parentGuardianEmail, defaultParentPssword, createdBy, 1, parentHash, parentProfilePath, institution);
            Student student = new Student(house, academicYear, joinedClass, studentSection, joinedClass, category, specialCategories, studentStatus, firstName, lastName, parentGuardianFirstName, parentGuardianLastName, parentGuardianEmail, sex, birthDate, fathersIncome, mothersIncome, addressLine1, addressLine2, city, state, country, postcode, email, contact, passportNumber, joinedDate, studentSignature, bloodGroup, accessNo, admissionNo, rollNo, parentContact, institution, createdBy, createdBy, aadharCardNumber);
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
            int i = 0;
            LinkedHashSet<Document> studentdocuments = new LinkedHashSet<Document>();
            if (documents != null) {
                MultipartFile[] multipartFileArray = documents;
                int n5 = documents.length;
                int n6 = 0;
                while (n6 < n5) {
                    MultipartFile document = multipartFileArray[n6];
                    if (!document.isEmpty()) {
                        String picturePath = "";
                        if (document != null && !document.isEmpty()) {
                            picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-document/document/" + student.getFirstName() + student.getAdmissionNo() + "/", document.getOriginalFilename());
                        }
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                        }
                        DocumentType documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[i])));
                        Document documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                        System.out.println(document.getOriginalFilename());
                        documentnew.setStudent(student);
                        studentdocuments.add(documentnew);
                        ++i;
                    }
                    ++n6;
                }
            }
            if (admission != null) {
                user = admission.getUser();
                user.setUserId(admission.getUser().getUserId());
                user.setEmail(email);
                user.setName(String.valueOf(firstName) + " " + lastName);
                user.setCreatedBy(createdBy);
                user.setProfilePicturePath(profilePath);
                user.setInstitution(institution);
                user.setUserRoles(userRoles);
                this.studentService.createStudentWithAdmissionAndDocuments(student, user, parentUser, admission, studentdocuments);
            } else {
                user = new User(userRoles, String.valueOf(firstName) + " " + lastName, email, defaultPssword, createdBy, 1, hash, profilePath, institution);
                this.studentService.createStudentAndDocuments(student, user, parentUser, studentdocuments);
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Created Successfully...!"));
            return redirectString;
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return redirectString;
        }
    }

    @RequestMapping(value={"/delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('managestudent/delete')")
    public String deleteStudent(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long studentId = Long.parseLong(request.getParameter("deleteStudentId"));
            this.studentService.deleteStudent(studentId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting student with id=" + studentId));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Deleted Successfully...!"));
            return "redirect:/student/managestudent";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"bulkdelete"}, method={RequestMethod.POST})
    public String deleteBulkStudent(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String[] studentIds;
            String[] stringArray = studentIds = request.getParameterValues("selectedStudentIds");
            int n = studentIds.length;
            int n2 = 0;
            while (n2 < n) {
                String studetId = stringArray[n2];
                String[] stuid = studetId.split(",");
                stuid = (String[])Arrays.stream(stuid).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                Long[] deleteStudentIds = new Long[stuid.length];
                int i = 0;
                while (i < stuid.length) {
                    deleteStudentIds[i] = Long.parseLong(stuid[i].toString());
                    ++i;
                }
                this.studentService.deleteListOfStudents(deleteStudentIds);
                ++n2;
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Students Deleted Successfully...!"));
            return "redirect:/student/managestudent";
        }
        catch (Exception e) {
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted"));
                return "redirect:/student/managestudent";
            }
            e.printStackTrace();
            return "redirect:/student/managestudent";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public Student editStudentRetrieve(@PathVariable(value="id") Long studentId, HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student with id=" + studentId));
            return this.studentService.studentByIdEager(studentId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('managestudent/update')")
    public String updateStudent(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="documents") MultipartFile[] documents, @RequestParam(value="editStudentProfilePic") MultipartFile multipartFile, @RequestParam(value="editScannedSignature") MultipartFile scannedSignature, @RequestParam(value="editParentProfilePic") MultipartFile parentProfilePicture) throws Exception {
        try {
            Long studentId = Long.parseLong(request.getParameter("updateStudentId"));
            Long userId = Long.parseLong(request.getParameter("updateUserId"));
            Long parentUserId = Long.parseLong(request.getParameter("updateParentUserId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating Student with id=" + studentId));
            Long joinClassId = Long.parseLong(request.getParameter("editJoinedClass"));
            Class joinedClass = this.classService.classById(joinClassId);
            Long studentClassId = Long.parseLong(request.getParameter("editStudentClass"));
            Class studentClass = this.classService.classById(studentClassId);
            Long sectionId = Long.parseLong(request.getParameter("editJoinedSection"));
            Section studentSection = this.sectionService.sectionById(sectionId);
            Long categoryId = Long.parseLong(request.getParameter("editCategoryId"));
            Category category = this.categoryService.categoryById(categoryId);
            Long houseId = Long.parseLong(request.getParameter("editHouseId"));
            Houses house = this.houseService.housesById(houseId);
            String[] specialCategoryIds = request.getParameterValues("editSpecialCategoryId");
            HashSet<SpecialCategory> specialCategories = new HashSet<SpecialCategory>();
            String[] stringArray = specialCategoryIds;
            int n = specialCategoryIds.length;
            int n2 = 0;
            while (n2 < n) {
                String specialCategoryId = stringArray[n2];
                specialCategories.add(this.specialCategoryService.specialCategoryById(Long.parseLong(specialCategoryId)));
                ++n2;
            }
            Long studentStatusId = Long.parseLong(request.getParameter("editStudentStatus"));
            StudentStatus studentStatus = this.studentStatusService.studentStatusById(studentStatusId);
            String firstName = request.getParameter("editFirstName");
            String lastName = request.getParameter("editLastName");
            String parentGuardianFirstName = request.getParameter("editParentOrGuardianFirstName");
            String parentGuardianLastName = request.getParameter("editParentOrGuardianLastName");
            String parentGuardianEmail = request.getParameter("editParentOrGuardianEmail");
            String sex = request.getParameter("editStudentGender");
            Long aadharCardNumber = null;
            if (!request.getParameter("editAadharCardNumber").isEmpty()) {
                aadharCardNumber = Long.parseLong(request.getParameter("editAadharCardNumber"));
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = formatter.parse(request.getParameter("editDateOfBirth"));
            Double fathersIncome = null;
            if (!request.getParameter("editFatherIncome").isEmpty()) {
                fathersIncome = Double.parseDouble(request.getParameter("editFatherIncome"));
            }
            Double mothersIncome = null;
            if (!request.getParameter("editMotherIncome").isEmpty()) {
                mothersIncome = Double.parseDouble(request.getParameter("editMotherIncome"));
            }
            BloodGroup bloodGroup = null;
            if (request.getParameter("editBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("editBloodGroupId")));
            }
            String addressLine1 = request.getParameter("editStudentAddressLine1");
            String addressLine2 = request.getParameter("editStudentAddressLine2");
            String country = request.getParameter("editStudentCountry");
            String state = request.getParameter("editStudentState");
            String city = request.getParameter("editStudentCity");
            String postcode = request.getParameter("editStudentPostCode");
            String email = request.getParameter("editEMail");
            String contact = request.getParameter("editContact");
            String passportNumber = request.getParameter("editPassportNo");
            Date joinedDate = formatter.parse(request.getParameter("editJoinedDate"));
            String accessNo = request.getParameter("editStudentAccessNo");
            String admissionNo = request.getParameter("editStudentAdmissionNo");
            Long academicYearId = Long.parseLong(request.getParameter("editAcademicYearId"));
            AcademicYear academicYear = this.academicYearService.academicYearById(academicYearId);
            String modifiedBy = request.getSession().getAttribute("username").toString();
            String rollNo = null;
            if (!request.getParameter("editRollNo").isEmpty()) {
                rollNo = request.getParameter("editRollNo");
            }
            String profilePath = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-profile/", multipartFile.getOriginalFilename());
            }
            String studentSignature = "";
            if (scannedSignature != null && !scannedSignature.isEmpty()) {
                studentSignature = this.fileUploadHandler.uploadFile(scannedSignature.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-signature/", scannedSignature.getOriginalFilename());
            }
            String parentContact = request.getParameter("editParentContact");
            Student student = this.studentService.studentById(studentId);
            Student student1 = this.studentService.studentByIdEager(studentId);
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
            int i = 0;
            LinkedHashSet<Document> studentdocuments = new LinkedHashSet<Document>();
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
                        picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-document/document/" + student.getFirstName() + student.getAdmissionNo() + "/", document.getOriginalFilename());
                    }
                    if (this.documentService.documentByDocumentTypeAndStudent((documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[i])))).getDocumentTypeId(), student.getStudentId()) != null) {
                        Document documentnew;
                        System.out.println("Enter If");
                        Document documentnewold = null;
                        if (picturePath != "") {
                            documentnewold = this.documentService.documentByDocumentTypeAndStudent(documentType.getDocumentTypeId(), student.getStudentId());
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            studentdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        } else {
                            documentnewold = this.documentService.documentByDocumentTypeAndStudent(documentType.getDocumentTypeId(), student.getStudentId());
                            documentnew = new Document(documentType, documentnewold.getDocumentName(), documentnewold.getDocumentPath());
                            studentdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        }
                    } else {
                        Document documentnew;
                        System.out.println("Enter Else");
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                            documentnew = new Document(documentType, "a.png", picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStudent(student);
                            studentdocuments.add(documentnew);
                        } else {
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStudent(student);
                            studentdocuments.add(documentnew);
                        }
                    }
                    ++i;
                    ++n6;
                }
            }
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setParentGuardianFirstName(parentGuardianFirstName);
            student.setParentGuardianLastName(parentGuardianLastName);
            student.setParentGuardianEmail(parentGuardianEmail);
            student.setSex(sex);
            student.setBirthDate(birthDate);
            student.setEmail(email);
            student.setParentContact(parentContact);
            student.setContact(contact);
            student.setCategory(category);
            student.setSpecialCategories(specialCategories);
            student.setFathersIncome(fathersIncome);
            student.setMothersIncome(mothersIncome);
            student.setAddressLine1(addressLine1);
            student.setAddressLine2(addressLine2);
            student.setCountry(country);
            student.setState(state);
            student.setCity(city);
            student.setPostcode(postcode);
            student.setJoinedClass(joinedClass);
            student.setStudentClass(studentClass);
            student.setSection(studentSection);
            student.setJoinedAcademicYear(academicYear);
            student.setRollNo(rollNo);
            student.setJoinedDate(joinedDate);
            student.setAccessNo(accessNo);
            student.setAdmissionNo(admissionNo);
            student.setAadharCardNumber(aadharCardNumber);
            if (studentSignature != "") {
                student.setScannedSignature(studentSignature);
            }
            student.setHouses(house);
            student.setStudentStatus(studentStatus);
            student.setBloodGroup(bloodGroup);
            student.setPassportNumber(passportNumber);
            student.setModifiedBy(modifiedBy);
            student.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            String userName = request.getParameter("adminName");
            String password = request.getParameter("adminPassword");
            String userStatus = request.getParameter("userStatus");
            String hash = this.hashGenerator.encoder(password);
            User user = this.userService.userById(userId);
            if (profilePath != "") {
                user.setProfilePicturePath(profilePath);
            }
            user.setName(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setModifiedBy(modifiedBy);
            user.setStatus(Integer.parseInt(userStatus));
            user.setHash(hash);
            user.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            String parentProfilePath = "";
            if (parentProfilePicture != null && !parentProfilePicture.isEmpty()) {
                parentProfilePath = this.fileUploadHandler.uploadFile(parentProfilePicture.getBytes(), request.getRealPath("/"), "/resources/themes/images/parent-profile/", parentProfilePicture.getOriginalFilename());
            }
            String parentUserName = request.getParameter("parentAdminName");
            String parentUserPassword = request.getParameter("parentAdminPassword");
            String parentStatus = request.getParameter("parentStatus");
            String parentHash = this.hashGenerator.encoder(parentUserPassword);
            User parentUser = this.userService.userById(parentUserId);
            if (parentProfilePath != "") {
                parentUser.setProfilePicturePath(parentProfilePath);
            }
            parentUser.setEmail(parentGuardianEmail);
            parentUser.setName(parentUserName);
            parentUser.setPassword(parentUserPassword);
            parentUser.setModifiedBy(modifiedBy);
            parentUser.setHash(parentHash);
            parentUser.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            parentUser.setStatus(Integer.parseInt(parentStatus));
            student.setDocuments(student1.getDocuments());
            System.out.println(studentdocuments.size());
            this.studentService.updateStudent(student, user, parentUser, studentdocuments);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Student Updated Successfully...!"));
            return "redirect:/student/managestudent";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/student/managestudent";
        }
    }

    @RequestMapping(value={"profile/update"}, method={RequestMethod.POST})
    public String updateStudentProfile(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="documents") MultipartFile[] documents, @RequestParam(value="editStudentProfilePic") MultipartFile multipartFile, @RequestParam(value="editScannedSignature") MultipartFile scannedSignature) throws Exception {
        try {
            Long studentId = Long.parseLong(request.getParameter("updateStudentId"));
            Long userId = Long.parseLong(request.getParameter("updateUserId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating Student with id=" + studentId));
            String firstName = request.getParameter("editFirstName");
            String lastName = request.getParameter("editLastName");
            String parentGuardianFirstName = request.getParameter("editParentOrGuardianFirstName");
            String parentGuardianLastName = request.getParameter("editParentOrGuardianLastName");
            String parentGuardianEmail = request.getParameter("editParentOrGuardianEmail");
            String sex = request.getParameter("editStudentGender");
            Long aadharCardNumber = null;
            if (!request.getParameter("editAadharCardNumber").isEmpty()) {
                aadharCardNumber = Long.parseLong(request.getParameter("editAadharCardNumber"));
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date birthDate = formatter.parse(request.getParameter("editDateOfBirth"));
            Double fathersIncome = null;
            if (!request.getParameter("editFatherIncome").isEmpty()) {
                fathersIncome = Double.parseDouble(request.getParameter("editFatherIncome"));
            }
            Double mothersIncome = null;
            if (!request.getParameter("editMotherIncome").isEmpty()) {
                mothersIncome = Double.parseDouble(request.getParameter("editMotherIncome"));
            }
            BloodGroup bloodGroup = null;
            if (request.getParameter("editBloodGroupId") != null) {
                bloodGroup = this.bloodGroupService.bloodGroupById(Long.parseLong(request.getParameter("editBloodGroupId")));
            }
            String addressLine1 = request.getParameter("editStudentAddressLine1");
            String addressLine2 = request.getParameter("editStudentAddressLine2");
            String country = request.getParameter("editStudentCountry");
            String state = request.getParameter("editStudentState");
            String city = request.getParameter("editStudentCity");
            String postcode = request.getParameter("editStudentPostCode");
            String email = request.getParameter("editEMail");
            String contact = request.getParameter("editContact");
            String passportNumber = request.getParameter("editPassportNo");
            String modifiedBy = request.getSession().getAttribute("username").toString();
            String profilePath = "";
            if (multipartFile != null && !multipartFile.isEmpty()) {
                profilePath = this.fileUploadHandler.uploadFile(multipartFile.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-profile/", multipartFile.getOriginalFilename());
            }
            String studentSignature = "";
            if (scannedSignature != null && !scannedSignature.isEmpty()) {
                studentSignature = this.fileUploadHandler.uploadFile(scannedSignature.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-signature/", scannedSignature.getOriginalFilename());
            }
            String parentContact = request.getParameter("editParentContact");
            Student student = this.studentService.studentById(studentId);
            student.setFirstName(firstName.trim());
            student.setLastName(lastName);
            student.setParentGuardianFirstName(parentGuardianFirstName);
            student.setParentGuardianLastName(parentGuardianLastName);
            student.setParentGuardianEmail(parentGuardianEmail);
            student.setSex(sex);
            student.setBirthDate(birthDate);
            student.setEmail(email);
            student.setParentContact(parentContact);
            student.setContact(contact);
            student.setFathersIncome(fathersIncome);
            student.setMothersIncome(mothersIncome);
            student.setAddressLine1(addressLine1);
            student.setAddressLine2(addressLine2);
            student.setCountry(country);
            student.setState(state);
            student.setCity(city);
            student.setPostcode(postcode);
            student.setAadharCardNumber(aadharCardNumber);
            if (studentSignature != "") {
                student.setScannedSignature(studentSignature);
            }
            student.setBloodGroup(bloodGroup);
            student.setPassportNumber(passportNumber);
            student.setModifiedBy(modifiedBy);
            student.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            User user = this.userService.userById(userId);
            if (profilePath != "") {
                user.setProfilePicturePath(profilePath);
            }
            Student student1 = this.studentService.studentByIdEager(studentId);
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
            int i = 0;
            LinkedHashSet<Document> studentdocuments = new LinkedHashSet<Document>();
            if (splitsDocumentType.length > 0 && documents != null) {
                System.out.println(documents.length);
                MultipartFile[] multipartFileArray = documents;
                int n3 = documents.length;
                int n4 = 0;
                while (n4 < n3) {
                    DocumentType documentType;
                    MultipartFile document = multipartFileArray[n4];
                    String picturePath = "";
                    if (document != null && !document.isEmpty()) {
                        picturePath = this.fileUploadHandler.uploadFile(document.getBytes(), request.getRealPath("/"), "/resources/themes/images/student-document/document/" + student.getFirstName() + student.getAdmissionNo() + "/", document.getOriginalFilename());
                    }
                    if (this.documentService.documentByDocumentTypeAndStudent((documentType = this.documentTypeService.documentTypeById(Long.parseLong(request.getParameter(splitsDocumentType[i])))).getDocumentTypeId(), student.getStudentId()) != null) {
                        Document documentnew;
                        System.out.println("Enter If");
                        Document documentnewold = null;
                        if (picturePath != "") {
                            documentnewold = this.documentService.documentByDocumentTypeAndStudent(documentType.getDocumentTypeId(), student.getStudentId());
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            studentdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        } else {
                            documentnewold = this.documentService.documentByDocumentTypeAndStudent(documentType.getDocumentTypeId(), student.getStudentId());
                            documentnew = new Document(documentType, documentnewold.getDocumentName(), documentnewold.getDocumentPath());
                            studentdocuments.add(documentnew);
                            System.out.println(document.getOriginalFilename());
                        }
                    } else {
                        Document documentnew;
                        System.out.println("Enter Else");
                        if (picturePath == "") {
                            picturePath = "/resources/themes/images/profile-pic/a.png";
                            documentnew = new Document(documentType, "a.png", picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStudent(student);
                            studentdocuments.add(documentnew);
                        } else {
                            documentnew = new Document(documentType, document.getOriginalFilename(), picturePath);
                            System.out.println(document.getOriginalFilename());
                            documentnew.setStudent(student);
                            studentdocuments.add(documentnew);
                        }
                    }
                    ++i;
                    ++n4;
                }
            }
            String userName = request.getParameter("adminName");
            String password = request.getParameter("adminPassword");
            String hash = this.hashGenerator.encoder(password);
            user.setName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setModifiedBy(modifiedBy);
            user.setHash(hash);
            user.setModifiedDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            student.setDocuments(student1.getDocuments());
            this.studentService.updateStudentProfileAndDocuments(student, user, studentdocuments);
            HttpSession session = request.getSession();
            session.setAttribute("username", (Object)email);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Profile Updated Successfully...!"));
            return "redirect:/student/profile";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/student/profile";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/retrieveStudentList"})
    @ResponseBody
    public List<Student> editStudentRetrieve(HttpServletRequest request) throws Exception {
        try {
            Long classId = Long.parseLong(request.getParameter("class"));
            Long sectionId = Long.parseLong(request.getParameter("section"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student with classid=" + classId + " and sectionid" + sectionId));
            return this.studentService.studentListByClassAndSection(classId, sectionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"editReterive"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<Student> editReterive(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String eMail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(eMail);
            boolean superadmin = false;
            for (UserRole userRoles : user.getUserRoles()) {
                if (!userRoles.getRoleName().equals("SuperAdministrator")) continue;
                superadmin = true;
            }
            ArrayList<Student> students = new ArrayList<Student>();
            String classId = request.getParameter("classList");
            String category = request.getParameter("categoryList");
            String admissionNo = null;
            if (request.getParameter("selectedAdmissionNo") != null) {
                admissionNo = request.getParameter("selectedAdmissionNo");
            }
            Long specialCategoryId = null;
            if (request.getParameter("specialCategoryList") != null) {
                specialCategoryId = Long.parseLong(request.getParameter("specialCategoryList"));
            }
            if (classId.equals("all")) {
                if (superadmin) {
                    return (ArrayList)this.studentService.studentListEager();
                }
                return (ArrayList)this.studentService.studentListEager(Long.parseLong(request.getSession().getAttribute("instituteId").toString()));
            }
            if (category.equals("all")) {
                String[] sections;
                Long classid = Long.parseLong(classId);
                String[] stringArray = sections = request.getParameterValues("sectionList");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String selectedsectionId = stringArray[n2];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentService.studentListByClassAndSectionEager(classid, sectionId) != null) {
                        students.addAll(this.studentService.studentListByClassAndSectionEager(classid, sectionId));
                    }
                    ++n2;
                }
                return students;
            }
            if (category.equals("specificstudent")) {
                String[] sections;
                Long classid = Long.parseLong(classId);
                String[] stringArray = sections = request.getParameterValues("sectionList");
                int n = sections.length;
                int n3 = 0;
                while (n3 < n) {
                    String selectedsectionId = stringArray[n3];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentService.studentListByClassAndSectionAndAdmissionNoEager(classid, sectionId, admissionNo) != null) {
                        students.add(this.studentService.studentListByClassAndSectionAndAdmissionNoEager(classid, sectionId, admissionNo));
                    }
                    ++n3;
                }
                return students;
            }
            if (category.equals("specialcategory")) {
                String[] sections;
                Long classid = Long.parseLong(classId);
                String[] stringArray = sections = request.getParameterValues("sectionList");
                int n = sections.length;
                int n4 = 0;
                while (n4 < n) {
                    String selectedsectionId = stringArray[n4];
                    Long sectionId = Long.parseLong(selectedsectionId);
                    if (this.studentService.studentsByClassSectionAndSpecialCategory(classid, sectionId, specialCategoryId) != null) {
                        students.addAll(this.studentService.studentsByClassSectionAndSpecialCategory(classid, sectionId, specialCategoryId));
                    }
                    ++n4;
                }
                return students;
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException studentException = (StudentException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentException.getCustomMessage());
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/documentuploadpending"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<Student> getStudentListRetreiveByDocumentUploadPending(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String eMail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(eMail);
            boolean superadmin = false;
            for (UserRole userRoles : user.getUserRoles()) {
                if (!userRoles.getRoleName().equals("SuperAdministrator")) continue;
                superadmin = true;
            }
            LinkedHashSet<Student> students = new LinkedHashSet<Student>();
            Long documentTypeId = Long.parseLong(request.getParameter("documentTypeId"));
            String classId = request.getParameter("class");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String admissionNo = null;
            if (request.getParameter("admissionNo") != "") {
                admissionNo = request.getParameter("admissionNo");
            }
            if (request.getParameter("admissionNo") != "") {
                Student student = this.studentService.studentByAdmissionNoEager(admissionNo);
                if (this.documentService.documentByDocumentTypeAndStudentAdmissionNo(documentTypeId, admissionNo) == null) {
                    students.add(student);
                }
            } else if (classId.equals("all")) {
                List<Student> studentList = null;
                studentList = superadmin ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                for (Student student : studentList) {
                    if (this.documentService.documentByDocumentTypeAndStudent(documentTypeId, student.getStudentId()) != null) continue;
                    students.add(student);
                }
            } else {
                String[] sections;
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String section = stringArray[n2];
                    Long sectionId = Long.parseLong(section);
                    List<Student> studentList = this.studentService.studentListByClassAndSectionEager(Long.parseLong(classId), sectionId);
                    for (Student student : studentList) {
                        if (this.documentService.documentByDocumentTypeAndStudent(documentTypeId, student.getStudentId()) != null) continue;
                        students.add(student);
                    }
                    ++n2;
                }
            }
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentpromotionlist"}, method={RequestMethod.GET})
    @ResponseBody
    public ArrayList<Student> getStudentPromotionListRetreive(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            ArrayList<Student> students = new ArrayList<Student>();
            String classId = request.getParameter("classList");
            Long studentStatus = 1L;
            String category = request.getParameter("categoryList");
            String admissionNo = null;
            if (request.getParameter("selectedAdmissionNo") != null) {
                admissionNo = request.getParameter("selectedAdmissionNo");
            }
            Long specialCategoryId = null;
            if (request.getParameter("specialCategoryList") != null) {
                specialCategoryId = Long.parseLong(request.getParameter("specialCategoryList"));
            }
            if (category.equals("all")) {
                Long sectionId;
                Long classid = Long.parseLong(classId);
                if (this.studentService.studentListByClassAndSectionAndStudentStatusEager(classid, sectionId = Long.valueOf(Long.parseLong(request.getParameter("sectionList"))), studentStatus) != null) {
                    students.addAll(this.studentService.studentListByClassAndSectionAndStudentStatusEager(classid, sectionId, studentStatus));
                }
                return students;
            }
            if (category.equals("specificstudent")) {
                Long sectionId;
                Long classid = Long.parseLong(classId);
                if (this.studentService.studentListByClassAndSectionAndAdmissionNoAndStudentStatusEager(classid, sectionId = Long.valueOf(Long.parseLong(request.getParameter("sectionList"))), admissionNo, studentStatus) != null) {
                    students.add(this.studentService.studentListByClassAndSectionAndAdmissionNoAndStudentStatusEager(classid, sectionId, admissionNo, studentStatus));
                }
                return students;
            }
            if (category.equals("specialcategory")) {
                Long sectionId;
                Long classid = Long.parseLong(classId);
                if (this.studentService.studentsByClassSectionAndSpecialCategoryAndStudentStatus(classid, sectionId = Long.valueOf(Long.parseLong(request.getParameter("sectionList"))), specialCategoryId, studentStatus) != null) {
                    students.addAll(this.studentService.studentsByClassSectionAndSpecialCategoryAndStudentStatus(classid, sectionId, specialCategoryId, studentStatus));
                }
                return students;
            }
            return students;
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException studentException = (StudentException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentException.getCustomMessage());
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/tcapprovedlist"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<TCRequisition> getTCApprovedListRetreive(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            LinkedHashSet<TCRequisition> tcRequisitionStudents = new LinkedHashSet<TCRequisition>();
            String classId = request.getParameter("class");
            Long academicYearId = Long.parseLong(request.getParameter("overAllAcademicYearId"));
            String admissionNo = null;
            if (request.getParameter("admissionNo") != "") {
                admissionNo = request.getParameter("admissionNo");
            }
            if (request.getParameter("admissionNo") != "") {
                tcRequisitionStudents.addAll(this.tcRequisitionService.tcRequisitionListByAcademicYearAndAdmissionNo(academicYearId, admissionNo));
            } else if (classId.equals("all")) {
                tcRequisitionStudents.addAll(this.tcRequisitionService.tcRequisitionListByAcademicYearAndAllClass(academicYearId));
            } else {
                String[] sections;
                String[] stringArray = sections = request.getParameterValues("section");
                int n = sections.length;
                int n2 = 0;
                while (n2 < n) {
                    String section = stringArray[n2];
                    Long sectionId = Long.parseLong(section);
                    tcRequisitionStudents.addAll(this.tcRequisitionService.tcRequisitionListByAcademicYearAndClassAndSection(academicYearId, Long.parseLong(classId), sectionId));
                    ++n2;
                }
            }
            return tcRequisitionStudents;
        }
        catch (Exception e) {
            if (e.getClass().equals(TransferCertificateRequisitionException.class)) {
                TransferCertificateRequisitionException transferCertificateRequisitionException = (TransferCertificateRequisitionException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)transferCertificateRequisitionException.getCustomMessage());
                return null;
            }
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classAndSection"})
    @ResponseBody
    public List<Student> getStudentsList(HttpServletRequest request) throws Exception {
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student with classid=" + classId + " and sectionid" + sectionId));
            return this.studentService.studentListByClassAndSectionEager(classId, sectionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/list"})
    @ResponseBody
    public List<Student> getStudents(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Students"));
            return this.studentService.studentListEager();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classsection/{id}"})
    @ResponseBody
    public List<Student> activeStudentsByClassSectionModuleId(@PathVariable(value="id") Long classSectionModuleId, HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving Student list with class section module id=" + classSectionModuleId));
            return this.studentService.activeStudentListByClassSectionModuleId(classSectionModuleId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/studentExcelFormat"}, method={RequestMethod.GET})
    public ModelAndView downloadStudentExcelFormat(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return new ModelAndView("studentExcelFormat", "studentList", this.studentService.studentList(institutionId));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/studentAdmissionDetailExcelFormat"}, method={RequestMethod.POST})
    public ModelAndView downloadStudentAdmissionDetailExcelFormat(HttpServletRequest request) {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return new ModelAndView("studentAdmissionDetails", "studentList", this.studentService.studentList(institutionId));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/excelDownload"}, method={RequestMethod.POST})
    public ModelAndView downloadStudentExcelWithDatat(HttpServletRequest request) throws Exception {
        try {
            ArrayList students = new ArrayList();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String classId = request.getParameter("classList");
            String category = request.getParameter("categoryList");
            String admissionNo = null;
            if (request.getParameter("selectedAdmissionNo") != null) {
                admissionNo = request.getParameter("selectedAdmissionNo");
            }
            Long specialCategoryId = null;
            SpecialCategory specialCategory = null;
            if (request.getParameter("specialCategoryList") != null) {
                specialCategoryId = Long.parseLong(request.getParameter("specialCategoryList"));
                specialCategory = this.specialCategoryService.specialCategoryById(specialCategoryId);
            }
            if (classId.equals("all")) {
                return new ModelAndView("studentDetails", "studentList", this.studentService.studentListEager(institutionId));
            }
            if (category.equals("all")) {
                Long classid = Long.parseLong(classId);
                Long sectionId = Long.parseLong(request.getParameter("sectionList"));
                return new ModelAndView("studentDetails", "studentList", this.studentService.studentListByClassAndSectionEager(classid, sectionId));
            }
            if (category.equals("specificstudent")) {
                Long classid = Long.parseLong(classId);
                Long sectionId = Long.parseLong(request.getParameter("sectionList"));
                ArrayList<Student> students1 = new ArrayList<Student>();
                students1.add(this.studentService.studentListByClassAndSectionAndAdmissionNoEager(classid, sectionId, admissionNo));
                return new ModelAndView("studentDetails", "studentList", students1);
            }
            if (category.equals("specialcategory")) {
                Long classid = Long.parseLong(classId);
                Long sectionId = Long.parseLong(request.getParameter("sectionList"));
                return new ModelAndView("studentDetails", "studentList", this.studentService.studentsByClassSectionAndSpecialCategoryEager(classid, sectionId, specialCategory.getSpecialCategoryId()));
            }
            return new ModelAndView("studentDetails", "studentList", students);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/uploadStudentExcel"}, method={RequestMethod.POST})
    public String studentBulkUpload(@RequestParam(value="studentExcelfile") MultipartFile studentExcelFile, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String createdBy = request.getSession().getAttribute("username").toString();
            this.studentService.studentBulkUpload(studentExcelFile, institutionId, createdBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Uploaded Successfully"));
            return "redirect:/student/managestudent";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException studentException = (StudentException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentException.getCustomMessage());
                return "redirect:/student/managestudent";
            }
            e.printStackTrace();
            return "redirect:/student/managestudent";
        }
    }

    @RequestMapping(value={"/updateStudentExcel"}, method={RequestMethod.POST})
    public String studentBulkUpdate(@RequestParam(value="studentBulkUpdate") MultipartFile studentExcelFile, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        try {
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String createdBy = request.getSession().getAttribute("username").toString();
            this.studentService.studentBulkUpdate(studentExcelFile, institutionId, createdBy);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Updated Successfully"));
            return "redirect:/student/managestudent";
        }
        catch (Exception e) {
            if (e.getClass().equals(StudentException.class)) {
                StudentException studentException = (StudentException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)studentException.getCustomMessage());
                return "redirect:/student/managestudent";
            }
            e.printStackTrace();
            return "redirect:/student/managestudent";
        }
    }

    @RequestMapping(value={"/leave/requisition"})
    public ModelAndView displayStudentRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("studentleaverequisition");
            modelandview.addObject("studentLeaveTypeList", this.studentLeaveTypeService.studentLeaveTypeList());
            String studentEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(studentEmail);
            modelandview.addObject("requisitionTypeList", this.requisitionTypeService.requisitionTypeListByUser(user));
            modelandview.addObject("studentLeaveRequistions", this.studentService.studentLeaveRequests(studentEmail));
            modelandview.addObject("studentLeaveRequestApprovedAndRejectedLists", this.studentService.studentLeaveRequestApprovedAndRejectedLists(studentEmail));
            modelandview.addObject("studentMovementRequistions", this.studentService.studentMovementRequests(studentEmail));
            modelandview.addObject("studentMovementRequestApprovedAndRejectedLists", this.studentService.studentMovementRequestApprovedAndRejectedLists(studentEmail));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/transfercertificate/requisition"})
    public ModelAndView displayStudentTCRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("parenttcrequisition");
            String parentEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(parentEmail);
            modelandview.addObject("requisitionTypeList", this.requisitionTypeService.requisitionTypeListByUser(user));
            modelandview.addObject("tcRequisitions", this.tcRequisitionService.tcRequisitionListByStudentEmail(parentEmail));
            modelandview.addObject("tcRequestApprovedAndRejectedLists", this.tcRequisitionService.tcRequestApprovedAndRejectedLists(parentEmail));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/transfercertificate/request"}, method={RequestMethod.POST})
    public String addStaffLeaveRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedRequisitionTypeId")));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String approvalStatus = "Pending";
            String reason = request.getParameter("tcReason");
            User tcApprover = this.userService.principalRoleApproverByInstitution(institutionId);
            String parentEmail = request.getSession().getAttribute("username").toString();
            Student student = this.studentService.studentByParentEmailEager(parentEmail);
            Class studentClass = student.getStudentClass();
            Section section = student.getSection();
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            String createdBy = request.getSession().getAttribute("username").toString();
            TCRequisition tcRequisition = new TCRequisition(reason, requisitionType, student, tcApprover, approvalStatus, institution, academicYear, studentClass, section, createdBy, createdBy);
            this.tcRequisitionService.createTCRequisition(tcRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Transfer Certificate Request Sent Successfully...!"));
            return "redirect:/student/transfercertificate/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/transfercertificate/requisition";
        }
    }

    @RequestMapping(value={"/transfercertificate/requestcancel"}, method={RequestMethod.POST})
    public String cancelTCRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long tcRequisitionId = Long.parseLong(request.getParameter("tcRequisitionId"));
            TCRequisition tcRequisition = this.tcRequisitionService.tcRequisitionByIdEager(tcRequisitionId);
            tcRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            tcRequisition.setModifiedBy(email);
            this.tcRequisitionService.cancelTCRequisition(tcRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Transfer Certificate Request Cancelled Successfully...!"));
            return "redirect:/student/transfercertificate/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/transfercertificate/requisition";
        }
    }

    @RequestMapping(value={"/leave/requisition/studentLeaveRequest"}, method={RequestMethod.POST})
    public String addStudentLeaveRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedRequisitionTypeId")));
            StudentLeaveType staffLeaveType = this.studentLeaveTypeService.studentLeaveTypeById(Long.parseLong(request.getParameter("studentLeaveType")));
            String approvalStatus = "Pending";
            String studentLeaveReason = request.getParameter("studentLeaveReason");
            String studentLeaveStartAndEndDate = request.getParameter("studentLeaveStartAndEndDate");
            Student student = this.studentService.studentByEmailEager(request.getSession().getAttribute("username").toString());
            Class studentClass = student.getStudentClass();
            Section section = student.getSection();
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(studentClass.getClassId(), section.getSectionId());
            User leaveApprover = this.userService.userByEmail(classSection.getClassStaff().getEmail());
            String[] dates = studentLeaveStartAndEndDate.split("-");
            Date staffLeaveStartDate = formatter.parse(dates[0].trim());
            Date staffLeaveEndDate = formatter.parse(dates[1].trim());
            String email = request.getSession().getAttribute("username").toString();
            StudentLeaveRequisition studentLeaveRequisition = new StudentLeaveRequisition(requisitionType, staffLeaveType, studentLeaveReason, student, leaveApprover, approvalStatus, staffLeaveStartDate, staffLeaveEndDate, email, email);
            this.studentLeaveRequisitionService.createStudentLeaveRequisition(studentLeaveRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Leave Request Sent Successfully...!"));
            return "redirect:/student/leave/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/leave/requisition";
        }
    }

    @RequestMapping(value={"/leave/requisition/studentLeaveRequest/cancel"}, method={RequestMethod.POST})
    public String cancelStudentLeaveRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long studentLeaveRequistionId = Long.parseLong(request.getParameter("studentLeaveRequisitionId"));
            StudentLeaveRequisition studentLeaveRequisition = this.studentLeaveRequisitionService.studentLeaveRequisitionByIdEager(studentLeaveRequistionId);
            studentLeaveRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            studentLeaveRequisition.setModifiedBy(email);
            this.studentLeaveRequisitionService.cancelStudentLeaveRequisition(studentLeaveRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Leave Request Cancelled Successfully...!"));
            return "redirect:/student/leave/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/leave/requisition";
        }
    }

    @RequestMapping(value={"/studentMovementrequisition/studentMovementRequest"}, method={RequestMethod.POST})
    public String addStudentMomentRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            RequisitionType requisitionType = this.requisitionTypeService.requisitionTypeById(Long.parseLong(request.getParameter("selectedMovementRequisitionTypeId")));
            String approvalStatus = "Pending";
            String studentMomentRequisitionReason = request.getParameter("studentMovementRequisitionReason");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String email = request.getSession().getAttribute("username").toString();
            Student student = this.studentService.studentByEmailEager(email);
            Class studentClass = student.getStudentClass();
            Section section = student.getSection();
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(studentClass.getClassId(), section.getSectionId());
            User momentApprover = this.userService.userByEmail(classSection.getClassStaff().getEmail());
            String date = request.getParameter("studentMovementRequisitionDate");
            String startTime = request.getParameter("studentInTime");
            String endTime = request.getParameter("studentOutTime");
            Date momentRequisitionDate = formatter.parse(date);
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String createdBy = request.getSession().getAttribute("username").toString();
            StudentMovementRequisition momentRequisition = new StudentMovementRequisition(studentMomentRequisitionReason, requisitionType, momentRequisitionDate, new Time(timeFormat.parse(startTime).getTime()), new Time(timeFormat.parse(endTime).getTime()), student, momentApprover, approvalStatus, institution, academicYear, studentClass, section, createdBy, createdBy);
            this.studentMovementRequisitionService.createStudentMovementRequisition(momentRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Moment Request Sent Successfully...!"));
            return "redirect:/student/leave/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/leave/requisition";
        }
    }

    @RequestMapping(value={"/studentMovementRequisition/studentMovementRequest/cancel"}, method={RequestMethod.POST})
    public String cancelStudentMomentRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long studentMomentRequistionId = Long.parseLong(request.getParameter("studentMovementRequisitionId"));
            StudentMovementRequisition momentRequisition = this.studentMovementRequisitionService.studentMovementRequisitionByIdEager(studentMomentRequistionId);
            momentRequisition.setApprovalStatus("Cancelled");
            String email = request.getSession().getAttribute("username").toString();
            momentRequisition.setModifiedBy(email);
            this.studentMovementRequisitionService.cancelStudentMovementRequisition(momentRequisition);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Moment Request Cancelled Successfully...!"));
            return "redirect:/student/leave/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/student/leave/requisition";
        }
    }

    @RequestMapping(value={"/leave/approvals"})
    public ModelAndView displayApprovalsPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("studentleaveapprovals");
            modelandview.addObject("leaveApporvalsList", this.studentService.studentLeaveApprovals(request.getSession().getAttribute("username").toString()));
            modelandview.addObject("studentMovementApporvalsList", this.studentService.studentMovementApprovals(request.getSession().getAttribute("username").toString()));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/leave/approvals/updatestatus"}, method={RequestMethod.POST})
    public String updateApprovalsStatus(HttpServletRequest request) {
        try {
            Long studentLeaveRequisitionId = Long.parseLong(request.getParameter("studentLeaveRequisitionId"));
            String status = request.getParameter("studentLeaveRequisitionStatus");
            String approverComment = request.getParameter("approverComment");
            StudentLeaveRequisition studentLeaveRequisition = this.studentLeaveRequisitionService.studentLeaveRequisitionByIdEager(studentLeaveRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            studentLeaveRequisition.setApprovedBy(email);
            studentLeaveRequisition.setApprovalStatus(status);
            studentLeaveRequisition.setApproverComment(approverComment);
            studentLeaveRequisition.setModifiedBy(email);
            this.studentLeaveRequisitionService.updateStudentLeaveRequisition(studentLeaveRequisition);
            return "redirect:/student/leave/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/student/leave/approvals";
        }
    }

    @RequestMapping(value={"/studentMovement/approvals/updatestatus"}, method={RequestMethod.POST})
    public String updateMomentApprovalsStatus(HttpServletRequest request) {
        try {
            Long studentMomentRequisitionId = Long.parseLong(request.getParameter("studentMovementRequisitionId"));
            String status = request.getParameter("studentMovementRequisitionStatus");
            String approverComment = request.getParameter("studentMovementApproverComment");
            StudentMovementRequisition studentMomentRequisition = this.studentMovementRequisitionService.studentMovementRequisitionByIdEager(studentMomentRequisitionId);
            String email = request.getSession().getAttribute("username").toString();
            studentMomentRequisition.setApprovedBy(email);
            studentMomentRequisition.setApprovalStatus(status);
            studentMomentRequisition.setApproverComment(approverComment);
            studentMomentRequisition.setModifiedBy(email);
            this.studentMovementRequisitionService.updateStudentMovementRequisition(studentMomentRequisition);
            return "redirect:/student/leave/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/student/leave/approvals";
        }
    }
}
