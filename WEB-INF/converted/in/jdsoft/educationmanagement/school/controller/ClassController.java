/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.ClassException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.ModuleSkill;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.CoScholasticActivityService;
import in.jdsoft.educationmanagement.school.services.CoScholasticAreaService;
import in.jdsoft.educationmanagement.school.services.ExamTemplateService;
import in.jdsoft.educationmanagement.school.services.GradeSystemService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ModuleService;
import in.jdsoft.educationmanagement.school.services.ModuleSkillService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="classController")
@RequestMapping(value={"/class"})
public class ClassController {
    private Logger log = LogManager.getLogger((String)ClassController.class.getName());
    @Autowired
    InstitutionService institutionService;
    @Autowired
    SectionService sectionService;
    @Autowired
    ExamTemplateService examTemplateService;
    @Autowired
    GradeSystemService gradeSystemService;
    @Autowired
    StaffService staffService;
    @Autowired
    ModuleService moduleService;
    @Autowired
    ModuleSkillService moduleSkillService;
    @Autowired
    CoScholasticActivityService coScholasticActivityService;
    @Autowired
    CoScholasticAreaService coScholasticAreaService;
    @Autowired
    ClassService classService;
    @Autowired
    AcademicYearService academicYearService;
    @Autowired
    ClassSectionService classSectionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('class')")
    public ModelAndView displayClassPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed class page"));
            ModelAndView modelandview = new ModelAndView("class");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classListWithOutExamConfigured", this.classService.classzByExamConfigStatusEager(institutionId, 1));
            modelandview.addObject("classListWithExamConfigured", this.classService.classzByExamConfigStatusEager(institutionId, 0));
            modelandview.addObject("classes", this.classService.classList(institutionId));
            modelandview.addObject("sections", this.sectionService.sectionList(institutionId));
            modelandview.addObject("examTemplates", this.examTemplateService.examTemplateList(institutionId));
            modelandview.addObject("gradeSystems", this.gradeSystemService.gradeSystemList(institutionId));
            modelandview.addObject("staffLists", this.staffService.staffList(institutionId));
            modelandview.addObject("moduleLists", this.moduleService.moduleList(institutionId));
            modelandview.addObject("moduleSkillServices", this.moduleSkillService.moduleSkillList());
            modelandview.addObject("coScholasticActivityServices", this.coScholasticActivityService.coScholasticActivityList());
            modelandview.addObject("coScholasticAreaServices", this.coScholasticAreaService.coScholasticAreaList());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classnandsection"})
    @PreAuthorize(value="hasAuthority('class')")
    public ModelAndView displayClassAndSectionPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed class page"));
            ModelAndView modelandview = new ModelAndView("classAndSection");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("classList", this.classService.classList(institutionId));
            modelandview.addObject("sectionList", this.sectionService.sectionList(institutionId));
            modelandview.addObject("staffLists", this.staffService.staffList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    public String createClass(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String className = request.getParameter("className");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            this.classService.createClass(new Class(className, institution, 2));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Class Created Successfully...!"));
            return "redirect:/class";
        }
        catch (Exception e) {
            if (e.getClass().equals(ClassException.class)) {
                ClassException classException = (ClassException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)classException.getCustomMessage());
                return "redirect:/class";
            }
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/configureClassWithAssessmentType"})
    public String configureClassWithAssessmentType(HttpServletRequest request) {
        try {
            Object moduleId2;
            String[] classSectionAssesmentName2;
            Object assessmenttype2;
            Long selectedClassId = Long.parseLong(request.getParameter("selectedClass"));
            Class clazz = this.classService.classById(selectedClassId);
            Long selectedSectionId = Long.parseLong(request.getParameter("section"));
            Section section = this.sectionService.sectionById(selectedSectionId);
            Long selectedClassStaffId = Long.parseLong(request.getParameter("selectedClassStaff"));
            Staff selectedClassStaff = this.staffService.staffById(selectedClassStaffId);
            ExamTemplate examtemplate = this.examTemplateService.examTemplateIdByEager(Long.parseLong(request.getParameter("examTemplate")));
            String[] assessmentDetails = request.getParameterValues("assessmentDetails");
            LinkedHashSet<ClassSectionAssesmentType> classSectionAssesmentTypes = new LinkedHashSet<ClassSectionAssesmentType>();
            String[] stringArray = assessmentDetails;
            int n = assessmentDetails.length;
            int n2 = 0;
            while (n2 < n) {
                String[] assessmenttypes;
                String assessmentDetail = stringArray[n2];
                String[] stringArray2 = assessmenttypes = assessmentDetail.split(",");
                int n3 = assessmenttypes.length;
                int n4 = 0;
                while (n4 < n3) {
                    assessmenttype2 = stringArray2[n4];
                    String[] assessment = ((String)assessmenttype2).split("-");
                    classSectionAssesmentName2 = assessment[0];
                    boolean gradeMethod = Boolean.parseBoolean(assessment[1]);
                    Long gradeSystemId = Long.parseLong(assessment[2]);
                    GradeSystem gradeSystem = this.gradeSystemService.gradeSystemById(gradeSystemId);
                    Integer assessmentLimit = Integer.parseInt(assessment[3]);
                    ClassSectionAssesmentType classSectionAssesmentType = new ClassSectionAssesmentType((String)classSectionAssesmentName2, gradeMethod, gradeSystem, assessmentLimit);
                    classSectionAssesmentTypes.add(classSectionAssesmentType);
                    ++n4;
                }
                ++n2;
            }
            LinkedHashSet<ClassSectionModule> classSectionModules = new LinkedHashSet<ClassSectionModule>();
            String[] modulesBasedDetails = request.getParameterValues("modulesBasedDetails");
            if (modulesBasedDetails != null) {
                assessmenttype2 = modulesBasedDetails;
                int assessmenttypes = modulesBasedDetails.length;
                int n5 = 0;
                while (n5 < assessmenttypes) {
                    String[] modulesBaseds;
                    String modulesBasedDetail = assessmenttype2[n5];
                    classSectionAssesmentName2 = modulesBaseds = modulesBasedDetail.split(",");
                    int assessment = modulesBaseds.length;
                    int n6 = 0;
                    while (n6 < assessment) {
                        String modulesBased = classSectionAssesmentName2[n6];
                        String[] data = modulesBased.split("-");
                        moduleId2 = Long.parseLong(data[0]);
                        Module module = this.moduleService.moduleById((Long)moduleId2);
                        Long staffId = Long.parseLong(data[1]);
                        Staff staff = this.staffService.staffById(staffId);
                        boolean skillBased = Boolean.parseBoolean("false");
                        ClassSectionModule classSectionModule = new ClassSectionModule(module, skillBased);
                        ClassSectionModuleStaff classSectionModuleStaff = new ClassSectionModuleStaff(classSectionModule, staff, this.academicYearService.getActiveAcademicYear());
                        classSectionModule.setClassSectionModuleStaff(classSectionModuleStaff);
                        classSectionModules.add(classSectionModule);
                        ++n6;
                    }
                    ++n5;
                }
            }
            LinkedHashSet<ClassSectionCoScholasticActivity> classSectionCoScholasticActivitys = new LinkedHashSet<ClassSectionCoScholasticActivity>();
            String[] coScholasticActivityDetails = request.getParameterValues("coScholasticActivityDetails");
            if (coScholasticActivityDetails != null) {
                String[] modulesBased = coScholasticActivityDetails;
                int modulesBaseds = coScholasticActivityDetails.length;
                int assessmenttype2 = 0;
                while (assessmenttype2 < modulesBaseds) {
                    String[] coScholasticActivitysIds;
                    String coScholasticActivityDetail = modulesBased[assessmenttype2];
                    moduleId2 = coScholasticActivitysIds = coScholasticActivityDetail.split(",");
                    int data = coScholasticActivitysIds.length;
                    int classSectionAssesmentName2 = 0;
                    while (classSectionAssesmentName2 < data) {
                        String coScholasticActivityId = moduleId2[classSectionAssesmentName2];
                        Long coScholasticActivity = Long.parseLong(coScholasticActivityId);
                        CoScholasticActivity coScholasticActivitys = this.coScholasticActivityService.coScholasticActivityById(coScholasticActivity);
                        ClassSectionCoScholasticActivity classSectionCoScholasticActivity = new ClassSectionCoScholasticActivity(coScholasticActivitys);
                        classSectionCoScholasticActivitys.add(classSectionCoScholasticActivity);
                        ++classSectionAssesmentName2;
                    }
                    ++assessmenttype2;
                }
            }
            LinkedHashSet<ClassSectionCoScholasticArea> classSectionCoScholasticAreas = new LinkedHashSet<ClassSectionCoScholasticArea>();
            String[] coScholasticAreaDetails = request.getParameterValues("coScholasticAreaDetails");
            if (coScholasticAreaDetails != null) {
                String[] stringArray3 = coScholasticAreaDetails;
                int coScholasticActivitysIds = coScholasticAreaDetails.length;
                int modulesBased = 0;
                while (modulesBased < coScholasticActivitysIds) {
                    String[] coScholasticAreaIds;
                    String coScholasticAreaDetail = stringArray3[modulesBased];
                    String[] stringArray4 = coScholasticAreaIds = coScholasticAreaDetail.split(",");
                    int coScholasticActivity = coScholasticAreaIds.length;
                    int moduleId2 = 0;
                    while (moduleId2 < coScholasticActivity) {
                        String coScholasticAreaId = stringArray4[moduleId2];
                        Long coScholasticArea = Long.parseLong(coScholasticAreaId);
                        CoScholasticArea coScholasticAreas = this.coScholasticAreaService.coScholasticAreaById(coScholasticArea);
                        ClassSectionCoScholasticArea classSectionCoScholasticArea = new ClassSectionCoScholasticArea(coScholasticAreas);
                        classSectionCoScholasticAreas.add(classSectionCoScholasticArea);
                        ++moduleId2;
                    }
                    ++modulesBased;
                }
            }
            String[] moduleAndSkillBasedDetails = request.getParameterValues("moduleAndSkillBasedDetails");
            LinkedHashSet<ClassSectionModule> classSectionModulesWithSkillSet = new LinkedHashSet<ClassSectionModule>();
            if (moduleAndSkillBasedDetails != null) {
                String[] stringArray5 = moduleAndSkillBasedDetails;
                int n7 = moduleAndSkillBasedDetails.length;
                int n8 = 0;
                while (n8 < n7) {
                    String[] moduleAndSkillBaseds;
                    String moduleAndSkillBasedDetail = stringArray5[n8];
                    String[] stringArray6 = moduleAndSkillBaseds = moduleAndSkillBasedDetail.split(",");
                    int n9 = moduleAndSkillBaseds.length;
                    int n10 = 0;
                    while (n10 < n9) {
                        String[] moduleskillIds;
                        String moduleAndSkillBased = stringArray6[n10];
                        String[] moduleAndSkillBasedData = moduleAndSkillBased.split("-");
                        Long moduleId3 = Long.parseLong(moduleAndSkillBasedData[0]);
                        Module module = this.moduleService.moduleById(moduleId3);
                        Long staffId = Long.parseLong(moduleAndSkillBasedData[2]);
                        Staff staff = this.staffService.staffById(staffId);
                        boolean skillBased = Boolean.parseBoolean("true");
                        ClassSectionModule classSectionModuleWithSkills = new ClassSectionModule(module, skillBased);
                        ClassSectionModuleStaff classSectionModuleStaff = new ClassSectionModuleStaff(classSectionModuleWithSkills, staff, this.academicYearService.getActiveAcademicYear());
                        classSectionModuleWithSkills.setClassSectionModuleStaff(classSectionModuleStaff);
                        String moduleSkillsId = moduleAndSkillBasedData[1];
                        String[] stringArray7 = moduleskillIds = moduleSkillsId.split("&");
                        int n11 = moduleskillIds.length;
                        int n12 = 0;
                        while (n12 < n11) {
                            String moduleskillId = stringArray7[n12];
                            ModuleSkill moduleSkill = this.moduleSkillService.moduleSkillById(Long.parseLong(moduleskillId));
                            ClassSectionModuleSkill classSectionModuleSkill = new ClassSectionModuleSkill(classSectionModuleWithSkills, moduleSkill);
                            classSectionModuleWithSkills.getClassSectionModuleSkills().add(classSectionModuleSkill);
                            ++n12;
                        }
                        classSectionModulesWithSkillSet.add(classSectionModuleWithSkills);
                        ++n10;
                    }
                    ++n8;
                }
            }
            this.classService.configureClassWithAssessmentType(clazz, section, examtemplate, selectedClassStaff, classSectionAssesmentTypes, classSectionModules, classSectionCoScholasticActivitys, classSectionCoScholasticAreas, classSectionModulesWithSkillSet);
            return "redirect:/class";
        }
        catch (Exception e) {
            return "redirect:/class";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deleteClassWithOutConfig"})
    public String deleteClassWithoutConfig(HttpServletRequest request) {
        try {
            Long classId = Long.parseLong(request.getParameter("deleteClassId"));
            System.out.println(classId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting class with id=" + classId));
            this.classService.deleteClass(classId);
            return "redirect:/class";
        }
        catch (Exception e) {
            return "redirect:/class";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deleteClassWithConfig"})
    public String deleteClassWithConfig(HttpServletRequest request) {
        try {
            Long classId = Long.parseLong(request.getParameter("dedeleteClassId"));
            System.out.println(classId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting class with id=" + classId));
            this.classService.deleteClass(classId);
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            return "redirect:/class/classnandsection";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/sections"})
    @ResponseBody
    public List<ClassSection> sectionInClass(HttpServletRequest request) {
        List<ClassSection> classSections = new ArrayList<ClassSection>();
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving sections of  class with class id=" + classId));
            classSections = this.classSectionService.classSectionByClassIdEager(classId);
            return classSections;
        }
        catch (Exception e) {
            return classSections;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classeager/{id}"})
    @ResponseBody
    public Class classById(@PathVariable(value="id") Long classId, HttpServletRequest request) {
        Class clazz = null;
        try {
            clazz = this.classService.classById(classId);
            return clazz;
        }
        catch (Exception e) {
            return clazz;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    public String updateClassSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long updateClassId = Long.parseLong(request.getParameter("updateClassId"));
            Class clazz = this.classService.classById(updateClassId);
            String updatedClassName = request.getParameter("editClassName");
            String[] sectionIds = request.getParameterValues("editSections");
            HashSet<Section> classSections = new HashSet<Section>(0);
            String[] stringArray = sectionIds;
            int n = sectionIds.length;
            int n2 = 0;
            while (n2 < n) {
                String sectionId = stringArray[n2];
                classSections.add(this.sectionService.sectionById(Long.parseLong(sectionId)));
                ++n2;
            }
            clazz.setClassName(updatedClassName);
            Long staffId = Long.parseLong(request.getParameter("editSelectedClassStaff"));
            Staff classStaff = this.staffService.staffById(staffId);
            this.classService.updateClassSection(clazz, classSections, classStaff);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Course and Semester/Year Updated Successfully...!"));
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/class/classnandsection";
        }
    }
}
