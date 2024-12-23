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
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.ClassAndSectionException;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticActivityService;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticAreaService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleExamService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleSkillService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SectionService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.text.ParseException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="classSectionController")
@RequestMapping(value={"/classSection"})
public class ClassSectionController {
    private Logger log = LogManager.getLogger((String)ClassSectionController.class.getName());
    @Autowired
    ClassSectionService classSectionService;
    @Autowired
    ClassSectionTermExamService classSectionTermExamService;
    @Autowired
    ClassSectionModuleService classSectionModuleService;
    @Autowired
    ClassSectionModuleSkillService classSectionModuleSkillService;
    @Autowired
    ClassSectionCoScholasticActivityService classSectionCoScholasticActivityService;
    @Autowired
    ClassSectionCoScholasticAreaService ClassSectionCoScholasticAreaService;
    @Autowired
    ClassSectionModuleExamService classSectionModuleExamService;
    @Autowired
    StudentService studentService;
    @Autowired
    ClassService classService;
    @Autowired
    SectionService sectionService;
    @Autowired
    StaffService staffService;
    @Autowired
    InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET}, value={"/{classId}"})
    @ResponseBody
    public List<ClassSection> viewRetrieve(@PathVariable(value="classId") Long classId, HttpServletRequest request) {
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSection with id=" + classId));
        List<ClassSection> classSection = this.classSectionService.classSectionByClassId(classId);
        return classSection;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/staff/{classId}"})
    @ResponseBody
    public List<ClassSection> viewRetrieveClassSection(@PathVariable(value="classId") Long classId, HttpServletRequest request) {
        String email = request.getSession().getAttribute("username").toString();
        Staff staff = this.staffService.staffByEmailEager(email);
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSection with id=" + classId + " and Email=" + email));
        List<ClassSection> classSection = this.classSectionService.classSectionByClassIdAndStaffEager(classId, staff);
        return classSection;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/termAndExam"})
    @ResponseBody
    public Set<ClassSectionTermExam> classSectionTermAndExamByClassAndSectionId(HttpServletRequest request) {
        Long classId = Long.parseLong(request.getParameter("classId"));
        Long sectionId = Long.parseLong(request.getParameter("sectionId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSectionTermExamByClassId=" + classId + "And SectionId=" + sectionId));
        Set<ClassSectionTermExam> classSectionTermExams = this.classSectionService.classSectionTermAndExamByClassAndSectionId(classId, sectionId);
        return classSectionTermExams;
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/addTermExamActivityAndAssessmentTypeExamActivity"})
    public String createTermExamActivityAndAssessmentTypeExamActivity(HttpServletRequest request) {
        try {
            Object classSectionTermExam4;
            Object classSectionModuleId2;
            Object classSectionTermExamId3;
            Object classSectionTermExamActivity2;
            String[] termExamActivityDetails;
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            Class clazz = this.classService.classById(classId);
            Section section = this.sectionService.sectionById(sectionId);
            LinkedHashSet<ClassSectionTermExamActivity> classSectionTermExamActivitys = new LinkedHashSet<ClassSectionTermExamActivity>();
            String[] stringArray = termExamActivityDetails = request.getParameterValues("termExamActivityDetails");
            int n = termExamActivityDetails.length;
            int n2 = 0;
            while (n2 < n) {
                String[] classSectionTermExamActivityss;
                String classSectionTermExamActivityDetail = stringArray[n2];
                String[] stringArray2 = classSectionTermExamActivityss = classSectionTermExamActivityDetail.split(",");
                int n3 = classSectionTermExamActivityss.length;
                int n4 = 0;
                while (n4 < n3) {
                    classSectionTermExamActivity2 = stringArray2[n4];
                    String[] TermExamActivity = ((String)classSectionTermExamActivity2).split("-");
                    classSectionTermExamId3 = Long.parseLong(TermExamActivity[0]);
                    ClassSectionTermExam classSectionTermExam2 = this.classSectionTermExamService.classSectionTermExamById((Long)classSectionTermExamId3);
                    String activityName = TermExamActivity[1];
                    Double maximumMark = Double.parseDouble(TermExamActivity[2]);
                    ClassSectionTermExamActivity classSectionTermExamActivityz = new ClassSectionTermExamActivity(classSectionTermExam2, activityName, maximumMark);
                    classSectionTermExamActivitys.add(classSectionTermExamActivityz);
                    ++n4;
                }
                ++n2;
            }
            LinkedHashSet<ClassSectionModuleExam> classSectionModulesExams = new LinkedHashSet<ClassSectionModuleExam>();
            String[] assessmentTypeModulesBasedExamActivityDetails = request.getParameterValues("assessmentTypeModulesBasedExamActivityDetails");
            if (assessmentTypeModulesBasedExamActivityDetails != null) {
                classSectionTermExamActivity2 = assessmentTypeModulesBasedExamActivityDetails;
                int classSectionTermExamActivityss = assessmentTypeModulesBasedExamActivityDetails.length;
                int n5 = 0;
                while (n5 < classSectionTermExamActivityss) {
                    String[] assessmentTypeModulesBasedExamActivitys;
                    String assessmentTypeModulesBasedExamActivityDetail = classSectionTermExamActivity2[n5];
                    classSectionTermExamId3 = assessmentTypeModulesBasedExamActivitys = assessmentTypeModulesBasedExamActivityDetail.split(",");
                    int TermExamActivity = assessmentTypeModulesBasedExamActivitys.length;
                    int n6 = 0;
                    while (n6 < TermExamActivity) {
                        String[] modulesBasedTermExamIds;
                        String assessmentTypeModulesBasedExamActivity = classSectionTermExamId3[n6];
                        String[] modulesBasedExamActivity = assessmentTypeModulesBasedExamActivity.split("-");
                        classSectionModuleId2 = Long.parseLong(modulesBasedExamActivity[0]);
                        ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleById((Long)classSectionModuleId2);
                        String modulesBasedTermExams = modulesBasedExamActivity[1];
                        String[] stringArray3 = modulesBasedTermExamIds = modulesBasedTermExams.split("&");
                        int n7 = modulesBasedTermExamIds.length;
                        int n8 = 0;
                        while (n8 < n7) {
                            String modulesBasedTermExamId = stringArray3[n8];
                            Long classSectionTermExamId2 = Long.parseLong(modulesBasedTermExamId);
                            classSectionTermExam4 = this.classSectionTermExamService.classSectionTermExamById(classSectionTermExamId2);
                            ClassSectionModuleExam classSectionModuleExam = new ClassSectionModuleExam(classSectionModule, (ClassSectionTermExam)classSectionTermExam4);
                            classSectionModulesExams.add(classSectionModuleExam);
                            ++n8;
                        }
                        ++n6;
                    }
                    ++n5;
                }
            }
            LinkedHashSet<ClassSectionModuleSkillExam> classSectionModuleSkillExams = new LinkedHashSet<ClassSectionModuleSkillExam>();
            String[] assessmentTypeModuleAndSkillBasedExamActivityDetails = request.getParameterValues("assessmentTypeModuleAndSkillBasedExamActivityDetails");
            if (assessmentTypeModuleAndSkillBasedExamActivityDetails != null) {
                String[] assessmentTypeModulesBasedExamActivity = assessmentTypeModuleAndSkillBasedExamActivityDetails;
                int assessmentTypeModulesBasedExamActivitys = assessmentTypeModuleAndSkillBasedExamActivityDetails.length;
                int classSectionTermExamActivity2 = 0;
                while (classSectionTermExamActivity2 < assessmentTypeModulesBasedExamActivitys) {
                    String[] assessmentTypeModuleAndSkillBasedExamActivitys;
                    String assessmentTypeModuleAndSkillBasedExamActivityDetail = assessmentTypeModulesBasedExamActivity[classSectionTermExamActivity2];
                    classSectionModuleId2 = assessmentTypeModuleAndSkillBasedExamActivitys = assessmentTypeModuleAndSkillBasedExamActivityDetail.split(",");
                    int modulesBasedExamActivity = assessmentTypeModuleAndSkillBasedExamActivitys.length;
                    int classSectionTermExamId3 = 0;
                    while (classSectionTermExamId3 < modulesBasedExamActivity) {
                        String[] moduleAndSkillBasedTermExamIds;
                        String assessmentTypeModuleAndSkillBasedExamActivity = classSectionModuleId2[classSectionTermExamId3];
                        String[] moduleAndSkillBasedExamActivity = assessmentTypeModuleAndSkillBasedExamActivity.split("-");
                        Long classSectionModuleSkillId = Long.parseLong(moduleAndSkillBasedExamActivity[0]);
                        ClassSectionModuleSkill classSectionModuleSkill = this.classSectionModuleSkillService.classSectionModuleSkillById(classSectionModuleSkillId);
                        String moduleAndSkillBasedTermExams = moduleAndSkillBasedExamActivity[1];
                        classSectionTermExam4 = moduleAndSkillBasedTermExamIds = moduleAndSkillBasedTermExams.split("&");
                        int classSectionTermExamId2 = moduleAndSkillBasedTermExamIds.length;
                        int n9 = 0;
                        while (n9 < classSectionTermExamId2) {
                            String moduleAndSkillBasedTermExamId = classSectionTermExam4[n9];
                            Long classSectionTermExamId4 = Long.parseLong(moduleAndSkillBasedTermExamId);
                            ClassSectionTermExam classSectionTermExam3 = this.classSectionTermExamService.classSectionTermExamById(classSectionTermExamId4);
                            ClassSectionModuleSkillExam classSectionModuleSkillExam = new ClassSectionModuleSkillExam(classSectionModuleSkill, classSectionTermExam3);
                            classSectionModuleSkillExams.add(classSectionModuleSkillExam);
                            ++n9;
                        }
                        ++classSectionTermExamId3;
                    }
                    ++classSectionTermExamActivity2;
                }
            }
            LinkedHashSet<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams = new LinkedHashSet<ClassSectionCoScholasticAreaExam>();
            String[] assessmentTypeCoScholasticAreaExamActivityDetails = request.getParameterValues("assessmentTypeCoScholasticAreaExamActivityDetails");
            if (assessmentTypeCoScholasticAreaExamActivityDetails != null) {
                String[] stringArray4 = assessmentTypeCoScholasticAreaExamActivityDetails;
                int assessmentTypeModuleAndSkillBasedExamActivitys = assessmentTypeCoScholasticAreaExamActivityDetails.length;
                int assessmentTypeModulesBasedExamActivity = 0;
                while (assessmentTypeModulesBasedExamActivity < assessmentTypeModuleAndSkillBasedExamActivitys) {
                    String[] assessmentTypeCoScholasticAreaExamActivitys;
                    String assessmentTypeCoScholasticAreaExamActivityDetail = stringArray4[assessmentTypeModulesBasedExamActivity];
                    String[] stringArray5 = assessmentTypeCoScholasticAreaExamActivitys = assessmentTypeCoScholasticAreaExamActivityDetail.split(",");
                    int moduleAndSkillBasedExamActivity = assessmentTypeCoScholasticAreaExamActivitys.length;
                    int classSectionModuleId2 = 0;
                    while (classSectionModuleId2 < moduleAndSkillBasedExamActivity) {
                        String[] coScholasticAreaTermExamIds;
                        String assessmentTypeCoScholasticAreaExamActivity = stringArray5[classSectionModuleId2];
                        String[] coScholasticAreaExamActivity = assessmentTypeCoScholasticAreaExamActivity.split("-");
                        Long classSectionCoScholasticAreaId = Long.parseLong(coScholasticAreaExamActivity[0]);
                        ClassSectionCoScholasticArea classSectionCoScholasticArea = this.ClassSectionCoScholasticAreaService.classSectionCoScholasticAreaById(classSectionCoScholasticAreaId);
                        String coScholasticAreaTermExams = coScholasticAreaExamActivity[1];
                        String[] stringArray6 = coScholasticAreaTermExamIds = coScholasticAreaTermExams.split("&");
                        int classSectionTermExamId4 = coScholasticAreaTermExamIds.length;
                        int classSectionTermExam4 = 0;
                        while (classSectionTermExam4 < classSectionTermExamId4) {
                            String coScholasticAreaTermExamId = stringArray6[classSectionTermExam4];
                            Long classSectionTermExamId5 = Long.parseLong(coScholasticAreaTermExamId);
                            ClassSectionTermExam classSectionTermExam5 = this.classSectionTermExamService.classSectionTermExamById(classSectionTermExamId5);
                            ClassSectionCoScholasticAreaExam classSectionCoScholasticAreaExam = new ClassSectionCoScholasticAreaExam(classSectionCoScholasticArea, classSectionTermExam5);
                            classSectionCoScholasticAreaExams.add(classSectionCoScholasticAreaExam);
                            ++classSectionTermExam4;
                        }
                        ++classSectionModuleId2;
                    }
                    ++assessmentTypeModulesBasedExamActivity;
                }
            }
            LinkedHashSet<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams = new LinkedHashSet<ClassSectionCoScholasticActivityExam>();
            String[] assessmentTypeCoScholasticActivityExamActivityDetails = request.getParameterValues("assessmentTypeCoScholasticActivityExamActivityDetails");
            if (assessmentTypeCoScholasticActivityExamActivityDetails != null) {
                String[] stringArray7 = assessmentTypeCoScholasticActivityExamActivityDetails;
                int n10 = assessmentTypeCoScholasticActivityExamActivityDetails.length;
                int n11 = 0;
                while (n11 < n10) {
                    String[] assessmentTypeCoScholasticActivityExamActivitys;
                    String assessmentTypeCoScholasticActivityExamActivityDetail = stringArray7[n11];
                    String[] stringArray8 = assessmentTypeCoScholasticActivityExamActivitys = assessmentTypeCoScholasticActivityExamActivityDetail.split(",");
                    int n12 = assessmentTypeCoScholasticActivityExamActivitys.length;
                    int n13 = 0;
                    while (n13 < n12) {
                        String[] coScholasticActivityTermExamIds;
                        String assessmentTypeCoScholasticActivityExamActivity = stringArray8[n13];
                        String[] coScholasticActivityExamActivity = assessmentTypeCoScholasticActivityExamActivity.split("-");
                        Long classSectionCoScholasticActivityId = Long.parseLong(coScholasticActivityExamActivity[0]);
                        ClassSectionCoScholasticActivity classSectionCoScholasticActivity = this.classSectionCoScholasticActivityService.classSectionCoScholasticActivityById(classSectionCoScholasticActivityId);
                        String coScholasticActivityTermExams = coScholasticActivityExamActivity[1];
                        String[] stringArray9 = coScholasticActivityTermExamIds = coScholasticActivityTermExams.split("&");
                        int n14 = coScholasticActivityTermExamIds.length;
                        int n15 = 0;
                        while (n15 < n14) {
                            String coScholasticActivityTermExamId = stringArray9[n15];
                            Long classSectionTermExamId6 = Long.parseLong(coScholasticActivityTermExamId);
                            ClassSectionTermExam classSectionTermExam6 = this.classSectionTermExamService.classSectionTermExamById(classSectionTermExamId6);
                            ClassSectionCoScholasticActivityExam classSectionCoScholasticActivityExam = new ClassSectionCoScholasticActivityExam(classSectionCoScholasticActivity, classSectionTermExam6);
                            classSectionCoScholasticActivityExams.add(classSectionCoScholasticActivityExam);
                            ++n15;
                        }
                        ++n13;
                    }
                    ++n11;
                }
            }
            this.classSectionService.createTermExamActivityAndAssessmentTypeExamActivity(classSectionTermExamActivitys, classSectionModulesExams, classSectionModuleSkillExams, classSectionCoScholasticAreaExams, classSectionCoScholasticActivityExams, clazz, section);
            return "redirect:/class";
        }
        catch (Exception e) {
            return "redirect:/class";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classAndSection"})
    @ResponseBody
    public List<ClassSection> classSectionByClassAndSectionId(HttpServletRequest request) {
        Long classId = Long.parseLong(request.getParameter("classId"));
        Long sectionId = Long.parseLong(request.getParameter("sectionId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSection with classId=" + classId + " and sectionId" + sectionId));
        List<ClassSection> classSections = this.classSectionService.classSectionsByClassAndSectionId(classId, sectionId);
        return classSections;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionModule"})
    @ResponseBody
    public Set<ClassSectionModule> classSectionModuleByClassAndSectionId(HttpServletRequest request) {
        Long classId = Long.parseLong(request.getParameter("classId"));
        Long sectionId = Long.parseLong(request.getParameter("sectionId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSectionModule with classId=" + classId + " and sectionId" + sectionId));
        Set<ClassSectionModule> classSections = this.classSectionService.classSectionModuleEagerByClassAndSectionId(classId, sectionId);
        return classSections;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionModule/substitute"})
    @ResponseBody
    public Set<ClassSectionModule> substituteClassSectionModuleByClassAndSectionId(HttpServletRequest request) throws ParseException {
        Long classId = Long.parseLong(request.getParameter("classId"));
        Long sectionId = Long.parseLong(request.getParameter("sectionId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSectionModule with classId=" + classId + " and sectionId" + sectionId));
        Set<ClassSectionModule> classSections = this.classSectionService.substituteClassSectionModuleEagerByClassAndSectionId(classId, sectionId);
        return classSections;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionModuleDetails"})
    @ResponseBody
    public ClassSectionModule classSectionModuleByClassSectionModuleId(HttpServletRequest request) {
        Long classSectionModuleId = Long.parseLong(request.getParameter("classSectionModuleId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSectionModule with classSectionModuleId=" + classSectionModuleId));
        String staffEmail = request.getSession().getAttribute("username").toString();
        Staff staff = this.staffService.staffByEmailEager(staffEmail);
        ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleByIdAndStaffEager(classSectionModuleId, staff);
        return classSectionModule;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionTermExam"})
    @ResponseBody
    public List<ClassSectionModuleExam> classSectionModuleExamEagerByClassAndSectionTermExamId(HttpServletRequest request) {
        Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving ClassSectionModuleExam with classSectionTermExamId=" + classSectionTermExamId));
        List<ClassSectionModuleExam> classSectionModuleExams = this.classSectionModuleExamService.classSectionModuleExamEagerById(classSectionTermExamId);
        return classSectionModuleExams;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionAssessmentTypeWithExamActivity"})
    @ResponseBody
    public Map<String, Object> classSectionAssessmentTypeWithExamActivity(HttpServletRequest request) {
        Long classId = Long.parseLong(request.getParameter("classId"));
        Long sectionId = Long.parseLong(request.getParameter("sectionId"));
        Map<String, Object> classSectionAssessmentTypeExamActivity = this.classSectionService.classSectionAssessmentEagerByClassAndSectionId(classId, sectionId);
        return classSectionAssessmentTypeExamActivity;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/students"})
    @ResponseBody
    public List<Student> studentList(HttpServletRequest request) {
        List<Student> students = null;
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            students = this.studentService.activeStudentListByClassAndSectionId(classId, sectionId);
            return students;
        }
        catch (Exception e) {
            e.printStackTrace();
            return students;
        }
    }

    @RequestMapping(value={"classconfig"}, method={RequestMethod.POST})
    public String addClassAndSection(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String className = request.getParameter("className");
            String[] sectionIds = request.getParameterValues("sections");
            HashSet<Section> classSections = new HashSet<Section>(0);
            String[] stringArray = sectionIds;
            int n = sectionIds.length;
            int n2 = 0;
            while (n2 < n) {
                String sectionId = stringArray[n2];
                classSections.add(this.sectionService.sectionById(Long.parseLong(sectionId)));
                ++n2;
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            Long selectedClassStaffId = Long.parseLong(request.getParameter("selectedClassStaff"));
            Staff selectedClassStaff = this.staffService.staffById(selectedClassStaffId);
            Class clazz = new Class(className, institution, 0);
            this.classSectionService.createClassAndSectionConfig(clazz, classSections, selectedClassStaff);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Class and Section Configured Successfully...!"));
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            if (e.getClass().equals(ClassAndSectionException.class)) {
                ClassAndSectionException classAndSectionException = (ClassAndSectionException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)classAndSectionException.getCustomMessage());
                return "redirect:/class/classnandsection";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/class/classnandsection";
        }
    }
}
