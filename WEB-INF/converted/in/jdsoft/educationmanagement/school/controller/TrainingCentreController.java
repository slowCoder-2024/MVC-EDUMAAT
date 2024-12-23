/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.servlet.ModelAndView
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.AdmissionRuleHandler;
import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.components.HashGenerator;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.AdmissionService;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.EducationLevelService;
import in.jdsoft.educationmanagement.school.services.GeographicalLocationService;
import in.jdsoft.educationmanagement.school.services.HearedUsService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ReligionService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import in.jdsoft.educationmanagement.school.services.SponserService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.StudentStatusService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import in.jdsoft.educationmanagement.school.services.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value={"/trainingcentre"})
public class TrainingCentreController {
    @Autowired
    private EmailHandler emailComponent;
    @Autowired
    private UserService userService;
    @Autowired
    private AdmissionService admissionService;
    @Autowired
    private GeographicalLocationService geographicalLocationService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SpecialCategoryService specialCategoryService;
    @Autowired
    private SponserService sponserService;
    @Autowired
    private HearedUsService hearedUsService;
    @Autowired
    private EducationLevelService educationLevelService;
    @Autowired
    private ClassService classService;
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ReligionService religionService;
    @Autowired
    private AdmissionRuleHandler admissionRuleHandler;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private HashGenerator hashGenerator;
    @Autowired
    private BloodGroupService bloodGroupService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentStatusService studentStatusService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private FileUploadHandler fileUploadHandler;

    @RequestMapping(value={"newenquiryregister"})
    public ModelAndView displayNewEnquiryRegisterPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("enquiryregisterform");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("categoryList", this.categoryService.categoryList());
            modelandview.addObject("specialCategoryList", this.specialCategoryService.specialCategoryList());
            modelandview.addObject("countryList", this.geographicalLocationService.countryList());
            modelandview.addObject("stateList", this.geographicalLocationService.stateList());
            modelandview.addObject("cityList", this.geographicalLocationService.cityList());
            modelandview.addObject("sponserList", this.sponserService.getSponserList());
            modelandview.addObject("hearedUsType", this.hearedUsService.getHearedUsList());
            modelandview.addObject("educationQualificationLevelList", this.educationLevelService.getEducationLevelList());
            modelandview.addObject("classList", this.classService.classList(instituteId));
            modelandview.addObject("sectionList", this.sectionService.sectionList(instituteId));
            modelandview.addObject("bloodGroupList", this.bloodGroupService.bloodGroupList());
            modelandview.addObject("academicYearList", (Object)this.academicYearService.getActiveAcademicYear());
            modelandview.addObject("studentStatusList", this.studentStatusService.studentStatusList());
            modelandview.addObject("studentList", this.studentService.studentList());
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
