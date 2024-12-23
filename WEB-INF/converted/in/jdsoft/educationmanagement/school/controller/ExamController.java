/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
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

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassSectionAssessmentTypeService;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticActivityExamService;
import in.jdsoft.educationmanagement.school.services.ClassSectionCoScholasticAreaExamService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleExamService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleSkillExamService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamActivityService;
import in.jdsoft.educationmanagement.school.services.ClassSectionTermExamService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ReportCardGeneratorService;
import in.jdsoft.educationmanagement.school.services.StudentGPAndCGPAService;
import in.jdsoft.educationmanagement.school.services.StudentMarkService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller(value="examController")
@RequestMapping(value={"exam"})
public class ExamController {
    private Logger log = LogManager.getLogger((String)ExamController.class.getName());
    @Autowired
    private ClassService classService;
    @Autowired
    private ClassSectionService classSectionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassSectionAssessmentTypeService classSectionAssessmentTypeService;
    @Autowired
    private ClassSectionTermExamService classSectionTermExamService;
    @Autowired
    private ClassSectionTermExamActivityService classSectionTermExamActivityService;
    @Autowired
    private ClassSectionModuleExamService classSectionModuleExamService;
    @Autowired
    private ClassSectionModuleSkillExamService classSectionModuleSkillExamService;
    @Autowired
    private ClassSectionCoScholasticAreaExamService classSectionCoScholasticAreaExamService;
    @Autowired
    private ClassSectionCoScholasticActivityExamService classSectionCoScholasticActivityExamService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private StudentMarkService studentMarkService;
    @Autowired
    private ClassSectionModuleService classSectionModuleService;
    @Autowired
    private StudentGPAndCGPAService studentGPAndCGPAService;
    @Autowired
    private ReportCardGeneratorService reportCardGeneratorService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayExamPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed exam result page"));
            ModelAndView modelandview = new ModelAndView("exam");
            modelandview.addObject("classes", this.classService.classList());
            modelandview.addObject("academicYear", (Object)this.academicYearService.getActiveAcademicYear());
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
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

    @RequestMapping(method={RequestMethod.GET}, value={"/assessmentType"})
    @ResponseBody
    public Set<ClassSectionAssesmentType> assessmentType(HttpServletRequest request) throws Exception {
        try {
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            return this.classSectionAssessmentTypeService.AssessmentTypeById(classId, sectionId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionTermExamActivity"})
    @ResponseBody
    public List<ClassSectionTermExamActivity> classSectionTermExamActivity(HttpServletRequest request) throws Exception {
        try {
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            return this.classSectionTermExamActivityService.classSectionTermExamActivityByclassSectionTermExamIdId(classSectionTermExamId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public ClassSectionAssesmentType classSectionAssessmentTypeById(@PathVariable(value="id") Long classSectionAssessmentTypeId, HttpServletRequest request) {
        ClassSectionAssesmentType classSectionAssesmentType = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving classSectionAssessmentTypeEager with id=" + classSectionAssessmentTypeId));
            classSectionAssesmentType = this.classSectionAssessmentTypeService.classSectionAssesmentTypeEagerBy(classSectionAssessmentTypeId);
            return classSectionAssesmentType;
        }
        catch (Exception e) {
            return classSectionAssesmentType;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionModuleExamEager"})
    @ResponseBody
    public List<ClassSectionModuleExam> classSectionModuleExamEager(HttpServletRequest request) throws Exception {
        try {
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            return this.classSectionModuleExamService.classSectionModuleExamEagerById(classSectionTermExamId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionModuleSkillExamEager"})
    @ResponseBody
    public List<ClassSectionModuleSkillExam> classSectionModuleSkillExamEager(HttpServletRequest request) throws Exception {
        try {
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            return this.classSectionModuleSkillExamService.classSectionModuleSkillExamEagerById(classSectionTermExamId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionCoScholasticAreaExamEager"})
    @ResponseBody
    public List<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExamEager(HttpServletRequest request) throws Exception {
        try {
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            return this.classSectionCoScholasticAreaExamService.classSectionCoScholasticAreaExamEagerById(classSectionTermExamId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/classSectionCoScholasticActivityExamEager"})
    @ResponseBody
    public List<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExamEager(HttpServletRequest request) throws Exception {
        try {
            Long classSectionTermExamId = Long.parseLong(request.getParameter("classSectionTermExamId"));
            return this.classSectionCoScholasticActivityExamService.classSectionCoScholasticActivityExamEagerById(classSectionTermExamId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/save"})
    public String saveStudentMark(HttpServletRequest request) {
        try {
            String[] moduleBasedMarksUpdateDetails;
            Long studentId = Long.parseLong(request.getParameter("studentId"));
            Student student = this.studentService.studentById(studentId);
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
            StudentMark studentMarks = new StudentMark(student, classSection, classSectionAssessmentType, classSectionTermExam, academicYear, institution);
            LinkedHashSet<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds = new LinkedHashSet<StudentMarksDetailWithModuleBased>();
            String[] stringArray = moduleBasedMarksUpdateDetails = request.getParameterValues("moduleBasedMarksUpdateDetails");
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
                    Long classSectionModuleId = Long.parseLong(moduleBased[1]);
                    ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleById(classSectionModuleId);
                    StudentMarksDetailWithModuleBased studentMarksDetailWithModuleBased = new StudentMarksDetailWithModuleBased(assessmentMark, classSectionTermExamActivity, classSectionModule);
                    studentMarksDetailWithModuleBaseds.add(studentMarksDetailWithModuleBased);
                    ++n4;
                }
                ++n2;
            }
            this.studentMarkService.saveStudentMarks(studentMarks, studentMarksDetailWithModuleBaseds);
            return "redirect:/exam";
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/studentGPAndCGPACalculation"})
    public String studentGPAndCGPACalculation(HttpServletRequest request) throws Exception {
        try {
            Long classId = Long.parseLong(request.getParameter("currClass"));
            Long sectionId = Long.parseLong(request.getParameter("currSection"));
            String[] formativeassessments = request.getParameterValues("formativeassessment");
            String[] summativeassessments = request.getParameterValues("summativeassessment");
            ArrayList<ClassSectionTermExam> classSectionTermExamFormativeAssessmentsIds = new ArrayList<ClassSectionTermExam>();
            ArrayList<ClassSectionTermExam> classSectionTermExamSummativeAssessmentsIds = new ArrayList<ClassSectionTermExam>();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(classId, sectionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            String[] stringArray = formativeassessments;
            int n = formativeassessments.length;
            int n2 = 0;
            while (n2 < n) {
                String formativeassessment = stringArray[n2];
                ClassSectionTermExam formativeassessmentId = this.classSectionTermExamService.classSectionTermExamById(Long.parseLong(formativeassessment));
                classSectionTermExamFormativeAssessmentsIds.add(formativeassessmentId);
                ++n2;
            }
            stringArray = summativeassessments;
            n = summativeassessments.length;
            n2 = 0;
            while (n2 < n) {
                String summativeassessment = stringArray[n2];
                ClassSectionTermExam summativeassessmentId = this.classSectionTermExamService.classSectionTermExamById(Long.parseLong(summativeassessment));
                classSectionTermExamSummativeAssessmentsIds.add(summativeassessmentId);
                ++n2;
            }
            ReportCardGenerator reportCardGenerator = new ReportCardGenerator(classSection, academicYear, institution);
            this.studentGPAndCGPAService.GenerateGPAndCGPA(reportCardGenerator, classSectionTermExamFormativeAssessmentsIds, classSectionTermExamSummativeAssessmentsIds);
            return "redirect:/exam";
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"reportCard/{id}"})
    @ResponseBody
    public ReportCardGenerator reportCardGeneratorEagerByStudentId(@PathVariable(value="id") Long studentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        try {
            Student student = this.studentService.studentById(studentId);
            return this.reportCardGeneratorService.reportCardGeneratorEagerByStudent(student);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"studentMark/{id}"})
    @ResponseBody
    public Set<StudentMark> studentMarkEagerByStudentId(@PathVariable(value="id") Long studentId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
        try {
            Student student = this.studentService.studentById(studentId);
            return this.studentMarkService.getStudentMarkEager(student);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
