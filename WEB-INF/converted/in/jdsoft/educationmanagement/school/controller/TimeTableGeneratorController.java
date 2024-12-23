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
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleService;
import in.jdsoft.educationmanagement.school.services.ClassSectionService;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ModuleService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.SubstituteTimeTableGeneratorService;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorDaysService;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorHoursService;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorService;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="timeTableGeneratorController")
@RequestMapping(value={"timetable/generator"})
public class TimeTableGeneratorController {
    private Logger log = LogManager.getLogger((String)TimeTableGeneratorController.class.getName());
    @Autowired
    private TimeTableGeneratorService timeTableGeneratorService;
    @Autowired
    private TimeTableTemplateService timeTableTemplateService;
    @Autowired
    private ClassService classService;
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private ClassSectionService classSectionService;
    @Autowired
    private ClassSectionModuleService classSectionModuleService;
    @Autowired
    private TimeTableGeneratorDaysService timeTableGeneratorDayService;
    @Autowired
    private TimeTableGeneratorHoursService timeTableGeneratorHourService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private SubstituteTimeTableGeneratorService substituteTimeTableGeneratorService;
    @Autowired
    private StaffService staffService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('timetablegenerator')")
    public ModelAndView displayTimeTableGeneratorPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed TimeTableGenerator page"));
            ModelAndView modelandview = new ModelAndView("timetablegenerator");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AcademicYear academicYear = null;
            if (this.academicYearService.getActiveAcademicYear() != null) {
                academicYear = this.academicYearService.getActiveAcademicYear();
            }
            modelandview.addObject("timeTableTemplateList", this.timeTableTemplateService.timeTableTemplateList(instituteId));
            modelandview.addObject("modules", this.moduleService.moduleList(instituteId));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            modelandview.addObject("timeTableGeneratorList", this.timeTableGeneratorService.timeTableGeneratorListEager(instituteId, academicYear));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/automatic"})
    @PreAuthorize(value="hasAuthority('timetablegenerator')")
    public ModelAndView displayAutomaticTimeTableGeneratorPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed AutomaticTimeTableGenerator page"));
            ModelAndView modelandview = new ModelAndView("automatictimetablegenerator");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AcademicYear academicYear = null;
            if (this.academicYearService.getActiveAcademicYear() != null) {
                academicYear = this.academicYearService.getActiveAcademicYear();
            }
            modelandview.addObject("timeTableTemplateList", this.timeTableTemplateService.timeTableTemplateList(instituteId));
            modelandview.addObject("modules", this.moduleService.moduleList(instituteId));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            modelandview.addObject("timeTableGeneratorList", this.timeTableGeneratorService.timeTableGeneratorListEager(instituteId, academicYear));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/substitute"})
    public ModelAndView displaySubstituteTimeTableGeneratorPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed SubstituteTimeTableGenerator page"));
            ModelAndView modelandview = new ModelAndView("substitutetimetablegenerator");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AcademicYear academicYear = null;
            if (this.academicYearService.getActiveAcademicYear() != null) {
                academicYear = this.academicYearService.getActiveAcademicYear();
            }
            modelandview.addObject("timeTableTemplateList", this.timeTableTemplateService.timeTableTemplateList(instituteId));
            modelandview.addObject("modules", this.moduleService.moduleList(instituteId));
            modelandview.addObject("classes", this.classService.classList(instituteId));
            modelandview.addObject("timeTableGeneratorList", this.timeTableGeneratorService.timeTableGeneratorListEager(instituteId, academicYear));
            modelandview.addObject("substituteTimeTableGeneratorList", this.substituteTimeTableGeneratorService.substituteTimeTableGeneratorListByInstitutionAndAcademicYearEager(instituteId, academicYear));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"/automatic/add"}, method={RequestMethod.POST})
    public String addAutomaticTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            Long classId = Long.parseLong(request.getParameter("classId"));
            List<ClassSection> classSections = this.classSectionService.classSectionByClassIdEager(classId);
            Long timeTableTemplateId = Long.parseLong(request.getParameter("timetabletemplate"));
            TimeTableTemplate timeTableTemplate = this.timeTableTemplateService.timeTableTemplateIdByEager(timeTableTemplateId);
            ArrayList<String> curtimeTableDayTitle = new ArrayList<String>();
            for (TimeTableTemplateDays timeTableTemplateDays : timeTableTemplate.getTimeTableTemplateDays()) {
                curtimeTableDayTitle.add(timeTableTemplateDays.getTimeTableTemplateDayName());
            }
            String[] addtimeTableDayTitle = curtimeTableDayTitle.toArray(new String[0]);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            ArrayList<String> curtimeTableHourTitle = new ArrayList<String>();
            for (TimeTableTemplateHours timeTableTemplateHours : timeTableTemplate.getTimeTableTemplateHours()) {
                String starttime = timeTableTemplateHours.getTimeTableTemplateHourStartTime().toString();
                String endTime = timeTableTemplateHours.getTimeTableTemplateHourEndTime().toString();
                starttime = starttime.substring(0, starttime.length() - 3);
                endTime = endTime.substring(0, endTime.length() - 3);
                curtimeTableHourTitle.add(String.valueOf(starttime) + "-" + endTime);
            }
            String[] addtimeTableHourTitle = curtimeTableHourTitle.toArray(new String[0]);
            for (ClassSection curclassSection : classSections) {
                LinkedHashSet<TimeTableGeneratorDays> addTimeTableDays = new LinkedHashSet<TimeTableGeneratorDays>();
                LinkedHashSet<TimeTableGeneratorHours> addTimeTableHours = new LinkedHashSet<TimeTableGeneratorHours>();
                Set<ClassSectionModule> classSectionModules = curclassSection.getClassSectionModules();
                ArrayList<String> curmodules = new ArrayList<String>();
                for (ClassSectionModule classSectionModule : classSectionModules) {
                    curmodules.add(String.valueOf(classSectionModule.getModule().getModuleName()) + "-" + classSectionModule.getClassSectionModuleStaff().getStaff().getFirstName());
                }
                String[] modules = curmodules.toArray(new String[0]);
                String createdBy = request.getSession().getAttribute("username").toString();
                TimeTableGenerator newTimeTableGenerator = new TimeTableGenerator(createdBy, curclassSection, institution, academicYear);
                String[] timeTableDayTitle = new String[addtimeTableDayTitle.length];
                int daycount = 0;
                while (daycount < addtimeTableDayTitle.length) {
                    timeTableDayTitle[daycount] = addtimeTableDayTitle[daycount];
                    TimeTableGeneratorDays timeTableGeneratorDay = new TimeTableGeneratorDays(timeTableDayTitle[daycount], newTimeTableGenerator);
                    addTimeTableDays.add(timeTableGeneratorDay);
                    String[][] timeTableHourTitle = new String[addtimeTableDayTitle.length][addtimeTableHourTitle.length];
                    int hourcount = 0;
                    while (hourcount < addtimeTableHourTitle.length) {
                        String random;
                        String dayName = timeTableDayTitle[daycount];
                        String hourTime = addtimeTableHourTitle[hourcount];
                        dayName = dayName.trim();
                        hourTime = hourTime.trim();
                        timeTableHourTitle[daycount][hourcount] = random = modules[new Random().nextInt(modules.length)];
                        LinkedHashSet<TimeTableGeneratorDays> addTimeTableGeneratorDays = new LinkedHashSet<TimeTableGeneratorDays>();
                        if (this.timeTableGeneratorDayService.timeTableGeneratorDayByName(dayName) != null) {
                            for (TimeTableGeneratorDays timeTableGeneratorDays : this.timeTableGeneratorDayService.timeTableGeneratorDayByName(dayName)) {
                                addTimeTableGeneratorDays.add(timeTableGeneratorDays);
                            }
                        }
                        LinkedHashSet<TimeTableGeneratorHours> addTimeTableGeneratorHours = new LinkedHashSet<TimeTableGeneratorHours>();
                        if (this.timeTableGeneratorHourService.timeTableGeneratorHourByTitleAndTimeTableGeneratorDay(hourTime, addTimeTableGeneratorDays) != null) {
                            for (TimeTableGeneratorHours timeTableGeneratorHours : this.timeTableGeneratorHourService.timeTableGeneratorHourByTitleAndTimeTableGeneratorDay(hourTime, addTimeTableGeneratorDays)) {
                                addTimeTableGeneratorHours.add(timeTableGeneratorHours);
                            }
                        }
                        LinkedHashSet<String> subject = new LinkedHashSet<String>();
                        if (addTimeTableGeneratorDays.size() > 0 && addTimeTableGeneratorHours.size() > 0 && this.timeTableGeneratorService.timeTableGeneratorByTimeTableGeneratorDayAndTimeTableGeneratorHourEager(addTimeTableGeneratorDays, addTimeTableGeneratorHours) != null) {
                            Set<TimeTableGenerator> timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorByTimeTableGeneratorDayAndTimeTableGeneratorHourEager(addTimeTableGeneratorDays, addTimeTableGeneratorHours);
                            for (TimeTableGenerator timeTableGenerators : timeTableGenerator) {
                                for (TimeTableGeneratorDays timeTableGeneratorDays : timeTableGenerators.getTimeTableGeneratorDays()) {
                                    for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDays.getTimeTableGeneratorHours()) {
                                        if (!timeTableGeneratorDays.getTimeTableGeneratorDayName().equals(dayName) || !hourTime.equals(timeTableGeneratorHours.getHourTitle())) continue;
                                        subject.add(timeTableGeneratorHours.getsubjectName());
                                    }
                                }
                            }
                        }
                        if (subject.size() > 0 && subject.contains(timeTableHourTitle[daycount][hourcount])) {
                            while (subject.contains(timeTableHourTitle[daycount][hourcount])) {
                                String newrandom;
                                String[] duplicatemodules = modules;
                                ArrayList<String> list = new ArrayList<String>(Arrays.asList(duplicatemodules));
                                int i = 0;
                                while (i < modules.length) {
                                    if (subject.contains(modules[i]) && subject.contains(timeTableHourTitle[daycount][hourcount])) {
                                        list.remove(modules[i]);
                                    }
                                    ++i;
                                }
                                duplicatemodules = list.toArray(new String[0]);
                                timeTableHourTitle[daycount][hourcount] = newrandom = duplicatemodules[new Random().nextInt(duplicatemodules.length)];
                            }
                        }
                        if (timeTableHourTitle[daycount][hourcount] != null) {
                            String[] moduleName = timeTableHourTitle[daycount][hourcount].split("-");
                            Module module = this.moduleService.moduleByModuleNameAndInstitution(moduleName[0].toString(), instituteId);
                            TimeTableGeneratorHours timeTableGeneratorHour = new TimeTableGeneratorHours(timeTableHourTitle[daycount][hourcount], hourTime, timeTableGeneratorDay);
                            timeTableGeneratorHour.setModule(module);
                            addTimeTableHours.add(timeTableGeneratorHour);
                        }
                        ++hourcount;
                    }
                    ++daycount;
                }
                this.timeTableGeneratorService.createTimeTableGenerator(newTimeTableGenerator, addTimeTableDays, addTimeTableHours);
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Generated Successfully...!"));
            return "redirect:/timetable/generator/automatic";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/automatic/delete"}, method={RequestMethod.POST})
    public String deleteAutomaticTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("deleteTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            this.timeTableGeneratorService.deleteTimeTableGenerator(timeTableGeneratorId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Deleted Successfully...!"));
            return "redirect:/timetable/generator/automatic";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/substitute/delete"}, method={RequestMethod.POST})
    public String deleteSubstituteTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long substituteTimeTableGeneratorId = Long.parseLong(request.getParameter("deleteSubstituteTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting SubstituteTimeTableGenerator with id=" + substituteTimeTableGeneratorId));
            this.substituteTimeTableGeneratorService.deleteSubstituteTimeTableGenerator(substituteTimeTableGeneratorId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Deleted Successfully...!"));
            return "redirect:/timetable/generator/substitute";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/substitute/add"}, method={RequestMethod.POST})
    public String createSubstituteTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("updateTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            String createdBy = request.getSession().getAttribute("username").toString();
            String substituteStartAndEndDate = request.getParameter("substituteStartAndEndDate");
            String[] dates = substituteStartAndEndDate.split("-");
            Date substituteStartDate = formatter.parse(dates[0].trim());
            Date substituteEndDate = formatter.parse(dates[1].trim());
            String[] timeTableDays = request.getParameterValues("editTimeTableDays");
            String[] timeTableHourSubjects = request.getParameterValues("editTimeTableHourSubjects");
            String[] timeTableDayIds = request.getParameterValues("timeTableDayIds");
            String[] timeTableHourIds = request.getParameterValues("timeTableHourIds");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableDays = new LinkedHashSet<TimeTableGeneratorDays>();
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableHours = new LinkedHashSet<TimeTableGeneratorHours>();
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorIdByEager(timeTableGeneratorId);
            timeTableGenerator.setAcademicYear(academicYear);
            String[] timeTableGenratorDayId = null;
            TimeTableGeneratorDays timeTableGeneratorDay = null;
            LinkedHashSet<SubstituteTimeTableGenerator> addSubstituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();
            String[] stringArray = timeTableDayIds;
            int n = timeTableDayIds.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableDayId = stringArray[n2];
                if (timeTableDayId.toString() != "" && !timeTableDayId.toString().isEmpty()) {
                    timeTableGenratorDayId = timeTableDayId.split(",");
                }
                ++n2;
            }
            String[] timeTableGeneratorHourSubjectId = null;
            String[] stringArray2 = timeTableHourIds;
            int n3 = timeTableHourIds.length;
            n = 0;
            while (n < n3) {
                String timeTableHourSubjectId = stringArray2[n];
                if (timeTableHourSubjectId.toString() != "" && !timeTableHourSubjectId.toString().isEmpty()) {
                    timeTableGeneratorHourSubjectId = timeTableHourSubjectId.split("-");
                }
                ++n;
            }
            timeTableGenratorDayId = (String[])Arrays.stream(timeTableGenratorDayId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            timeTableGeneratorHourSubjectId = (String[])Arrays.stream(timeTableGeneratorHourSubjectId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            stringArray2 = timeTableDays;
            n3 = timeTableDays.length;
            n = 0;
            while (n < n3) {
                String timeTableDay = stringArray2[n];
                if (timeTableDay != "" && !timeTableDay.isEmpty()) {
                    String[] splitsDay = timeTableDay.split(",");
                    int i = 0;
                    while (i < splitsDay.length) {
                        if (splitsDay[i].toString() != "" && !splitsDay[i].toString().isEmpty()) {
                            if (timeTableGenratorDayId[i].toString() != "" && !timeTableGenratorDayId[i].toString().isEmpty()) {
                                timeTableGeneratorDay = this.timeTableGeneratorDayService.timeTableGeneratorDayByTimeTableGeneratorAndTimeTableGeneratorDayId(Long.parseLong(timeTableGenratorDayId[i].toString()), timeTableGenerator.getTimeTableGeneratorId());
                                timeTableGeneratorDay.setTimeTableGeneratorDayName(splitsDay[i].toString());
                                addTimeTableDays.add(timeTableGeneratorDay);
                            }
                            String[] stringArray3 = timeTableHourSubjects;
                            int n4 = timeTableHourSubjects.length;
                            int n5 = 0;
                            while (n5 < n4) {
                                String timeTableHourSubject = stringArray3[n5];
                                String[] splitsHourSubject = timeTableHourSubject.split("/");
                                if ((splitsHourSubject = (String[])Arrays.stream(splitsHourSubject).filter(s -> s != null && s.length() > 0).toArray(String[]::new))[i].toString() != "" && !splitsHourSubject[i].toString().isEmpty()) {
                                    String[] splitSubjects = splitsHourSubject[i].split(",");
                                    splitSubjects = (String[])Arrays.stream(splitSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    String[] splitHourSubjects = timeTableGeneratorHourSubjectId[i].split(",");
                                    splitHourSubjects = (String[])Arrays.stream(splitHourSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    int j = 0;
                                    while (j < splitSubjects.length) {
                                        if (splitSubjects[j].toString() != "" && !splitSubjects[j].toString().isEmpty()) {
                                            String[] moduleName = splitSubjects[j].split("-");
                                            if (moduleName[0].toString().equals("Break") || moduleName[0].toString().equals("Lunch")) {
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            } else {
                                                Module module = this.moduleService.moduleByModuleNameAndInstitution(moduleName[0].toString(), instituteId);
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                timeTableGeneratorHour.setModule(module);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                                if (this.timeTableGeneratorHourService.substituteTimeTableGeneratorHourChecking(timeTableGeneratorHour.getHourTitle(), splitSubjects[j].toString(), timeTableGeneratorDay) == null) {
                                                    ClassSectionModule classSectionModule = this.classSectionModuleService.classSectionModuleByClassSectionAndModule(timeTableGenerator.getClassSection(), module);
                                                    Staff staff = this.staffService.staffByEmailEager(classSectionModule.getClassSectionModuleStaff().getStaff().getEmail());
                                                    SubstituteTimeTableGenerator substituteTimeTableGenerator = new SubstituteTimeTableGenerator(splitSubjects[j].toString(), timeTableGeneratorHour.getHourTitle(), timeTableGeneratorDay.getTimeTableGeneratorDayName(), createdBy, createdBy, substituteStartDate, substituteEndDate, module, timeTableGenerator.getClassSection().getClassSection(), timeTableGenerator.getClassSection().getSectionClass(), academicYear, institution, staff);
                                                    addSubstituteTimeTableGenerators.add(substituteTimeTableGenerator);
                                                }
                                            }
                                        }
                                        ++j;
                                    }
                                }
                                ++n5;
                            }
                        }
                        ++i;
                    }
                }
                ++n;
            }
            this.substituteTimeTableGeneratorService.createSubstituteTimeTableGenerators(addSubstituteTimeTableGenerators);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Substitute Successfully...!"));
            return "redirect:/timetable/generator/substitute";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"automatic/update"}, method={RequestMethod.POST})
    public String updateAutomaticTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("updateTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            String[] timeTableDays = request.getParameterValues("editTimeTableDays");
            String[] timeTableHourSubjects = request.getParameterValues("editTimeTableHourSubjects");
            String[] timeTableDayIds = request.getParameterValues("timeTableDayIds");
            String[] timeTableHourIds = request.getParameterValues("timeTableHourIds");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableDays = new LinkedHashSet<TimeTableGeneratorDays>();
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableHours = new LinkedHashSet<TimeTableGeneratorHours>();
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorIdByEager(timeTableGeneratorId);
            timeTableGenerator.setAcademicYear(academicYear);
            String[] timeTableGenratorDayId = null;
            TimeTableGeneratorDays timeTableGeneratorDay = null;
            String[] stringArray = timeTableDayIds;
            int n = timeTableDayIds.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableDayId = stringArray[n2];
                if (timeTableDayId.toString() != "" && !timeTableDayId.toString().isEmpty()) {
                    timeTableGenratorDayId = timeTableDayId.split(",");
                }
                ++n2;
            }
            String[] timeTableGeneratorHourSubjectId = null;
            String[] stringArray2 = timeTableHourIds;
            int n3 = timeTableHourIds.length;
            n = 0;
            while (n < n3) {
                String timeTableHourSubjectId = stringArray2[n];
                if (timeTableHourSubjectId.toString() != "" && !timeTableHourSubjectId.toString().isEmpty()) {
                    timeTableGeneratorHourSubjectId = timeTableHourSubjectId.split("-");
                }
                ++n;
            }
            timeTableGenratorDayId = (String[])Arrays.stream(timeTableGenratorDayId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            timeTableGeneratorHourSubjectId = (String[])Arrays.stream(timeTableGeneratorHourSubjectId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            stringArray2 = timeTableDays;
            n3 = timeTableDays.length;
            n = 0;
            while (n < n3) {
                String timeTableDay = stringArray2[n];
                if (timeTableDay != "" && !timeTableDay.isEmpty()) {
                    String[] splitsDay = timeTableDay.split(",");
                    int i = 0;
                    while (i < splitsDay.length) {
                        if (splitsDay[i].toString() != "" && !splitsDay[i].toString().isEmpty()) {
                            if (timeTableGenratorDayId[i].toString() != "" && !timeTableGenratorDayId[i].toString().isEmpty()) {
                                timeTableGeneratorDay = this.timeTableGeneratorDayService.timeTableGeneratorDayByTimeTableGeneratorAndTimeTableGeneratorDayId(Long.parseLong(timeTableGenratorDayId[i].toString()), timeTableGenerator.getTimeTableGeneratorId());
                                timeTableGeneratorDay.setTimeTableGeneratorDayName(splitsDay[i].toString());
                                addTimeTableDays.add(timeTableGeneratorDay);
                            }
                            String[] stringArray3 = timeTableHourSubjects;
                            int n4 = timeTableHourSubjects.length;
                            int n5 = 0;
                            while (n5 < n4) {
                                String timeTableHourSubject = stringArray3[n5];
                                String[] splitsHourSubject = timeTableHourSubject.split("/");
                                if ((splitsHourSubject = (String[])Arrays.stream(splitsHourSubject).filter(s -> s != null && s.length() > 0).toArray(String[]::new))[i].toString() != "" && !splitsHourSubject[i].toString().isEmpty()) {
                                    String[] splitSubjects = splitsHourSubject[i].split(",");
                                    splitSubjects = (String[])Arrays.stream(splitSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    String[] splitHourSubjects = timeTableGeneratorHourSubjectId[i].split(",");
                                    splitHourSubjects = (String[])Arrays.stream(splitHourSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    int j = 0;
                                    while (j < splitSubjects.length) {
                                        if (splitSubjects[j].toString() != "" && !splitSubjects[j].toString().isEmpty()) {
                                            String[] moduleName = splitSubjects[j].split("-");
                                            if (moduleName[0].toString().equals("Break") || moduleName[0].toString().equals("Lunch")) {
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                timeTableGeneratorHour.setModule(null);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            } else {
                                                Module module = this.moduleService.moduleByModuleNameAndInstitution(moduleName[0].toString(), instituteId);
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                timeTableGeneratorHour.setModule(module);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            }
                                        }
                                        ++j;
                                    }
                                }
                                ++n5;
                            }
                        }
                        ++i;
                    }
                }
                ++n;
            }
            this.timeTableGeneratorService.updateTimeTableGenerator(timeTableGenerator, addTimeTableDays, addTimeTableHours);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Updated Successfully...!"));
            return "redirect:/timetable/generator/automatic";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"add"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetablegenerator/add')")
    public String addTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            int i;
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            String[] timeTableDays = request.getParameterValues("timeTableDays");
            String[] timeTableHourSubjects = request.getParameterValues("timeTableHourSubjects");
            String[] timeTableHourTitles = request.getParameterValues("timeTableHourTitles");
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableDays = new LinkedHashSet<TimeTableGeneratorDays>();
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableHours = new LinkedHashSet<TimeTableGeneratorHours>();
            String createdBy = request.getSession().getAttribute("username").toString();
            Long classId = Long.parseLong(request.getParameter("classId"));
            Long sectionId = Long.parseLong(request.getParameter("sectionId"));
            ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(classId, sectionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            TimeTableGenerator newTimeTableGenerator = new TimeTableGenerator(createdBy, classSection, institution, academicYear);
            String[] curTimeTableHourTitle = new String[1];
            String[] stringArray = timeTableHourTitles;
            int n = timeTableHourTitles.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableHourTitle = stringArray[n2];
                if (timeTableHourTitle != "" && !timeTableHourTitle.isEmpty()) {
                    String[] splitstimeTableHourTitle = timeTableHourTitle.split(",");
                    splitstimeTableHourTitle = (String[])Arrays.stream(splitstimeTableHourTitle).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    curTimeTableHourTitle = new String[splitstimeTableHourTitle.length];
                    i = 0;
                    while (i < splitstimeTableHourTitle.length) {
                        curTimeTableHourTitle[i] = splitstimeTableHourTitle[i];
                        ++i;
                    }
                }
                ++n2;
            }
            stringArray = timeTableDays;
            n = timeTableDays.length;
            n2 = 0;
            while (n2 < n) {
                String timeTableDay = stringArray[n2];
                if (timeTableDay != "" && !timeTableDay.isEmpty()) {
                    String[] splitsDay = timeTableDay.split(",");
                    i = 0;
                    while (i < splitsDay.length) {
                        if (splitsDay[i].toString() != "" && !splitsDay[i].toString().isEmpty()) {
                            TimeTableGeneratorDays timeTableGeneratorDay = new TimeTableGeneratorDays(splitsDay[i].toString(), newTimeTableGenerator);
                            addTimeTableDays.add(timeTableGeneratorDay);
                            String[] stringArray2 = timeTableHourSubjects;
                            int n3 = timeTableHourSubjects.length;
                            int n4 = 0;
                            while (n4 < n3) {
                                String timeTableHourSubject = stringArray2[n4];
                                String[] splitsHourSubject = timeTableHourSubject.split("/");
                                if (splitsHourSubject[i].toString() != "" && !splitsHourSubject[i].toString().isEmpty()) {
                                    String[] splitSubjects = splitsHourSubject[i].split(",");
                                    splitSubjects = (String[])Arrays.stream(splitSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    int j = 0;
                                    while (j < splitSubjects.length) {
                                        if (splitSubjects[j].toString() != "" && !splitSubjects[j].toString().isEmpty()) {
                                            String[] moduleName = splitSubjects[j].split("-");
                                            if (moduleName[0].toString().equals("Break") || moduleName[0].toString().equals("Lunch")) {
                                                TimeTableGeneratorHours timeTableGeneratorHour = new TimeTableGeneratorHours(splitSubjects[j].toString(), curTimeTableHourTitle[j], timeTableGeneratorDay);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            } else {
                                                Module module = this.moduleService.moduleByModuleNameAndInstitution(moduleName[0].toString(), instituteId);
                                                TimeTableGeneratorHours timeTableGeneratorHour = new TimeTableGeneratorHours(splitSubjects[j].toString(), curTimeTableHourTitle[j], timeTableGeneratorDay);
                                                timeTableGeneratorHour.setModule(module);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            }
                                        }
                                        ++j;
                                    }
                                }
                                ++n4;
                            }
                        }
                        ++i;
                    }
                }
                ++n2;
            }
            this.timeTableGeneratorService.createTimeTableGenerator(newTimeTableGenerator, addTimeTableDays, addTimeTableHours);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Generated Successfully...!"));
            return "redirect:/timetable/generator";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"classAndSection"}, method={RequestMethod.GET})
    @ResponseBody
    public TimeTableGenerator editTimeTableGeneratorRetrieve(HttpServletRequest request) {
        try {
            TimeTableGenerator timeTableGenerator = null;
            if (request.getParameter("classId") != null && request.getParameter("classId") != "" && request.getParameter("sectionId") != "" && request.getParameter("sectionId") != null) {
                Long classId = Long.parseLong(request.getParameter("classId"));
                Long sectionId = Long.parseLong(request.getParameter("sectionId"));
                ClassSection classSection = this.classSectionService.classSectionByClassAndSectionId(classId, sectionId);
                timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorEagerByClassSectionId(classSection.getClassSectionId());
                this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving TimeTableGenerator with class id=" + classId + "and section id=" + sectionId));
            }
            return timeTableGenerator;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"class"}, method={RequestMethod.GET})
    @ResponseBody
    public TimeTableGenerator timeTableGeneratorRetrieveByClass(HttpServletRequest request) {
        try {
            TimeTableGenerator timeTableGenerator = null;
            if (request.getParameter("classId") != null && request.getParameter("classId") != "") {
                Long classId = Long.parseLong(request.getParameter("classId"));
                List<ClassSection> classSections = this.classSectionService.classSectionByClassId(classId);
                if (classSections.size() > 0) {
                    for (ClassSection classSection : classSections) {
                        if (this.timeTableGeneratorService.timeTableGeneratorEagerByClassSectionId(classSection.getClassSectionId()) == null) continue;
                        timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorEagerByClassSectionId(classSection.getClassSectionId());
                        break;
                    }
                }
                this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving TimeTableGenerator with class id=" + classId));
            }
            return timeTableGenerator;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/checkTimeTableConstraint"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<TimeTableGenerator> retrieveTesting(HttpServletRequest request) {
        try {
            String dayName = request.getParameter("day");
            String hourTime = request.getParameter("hourtime");
            dayName = dayName.trim();
            hourTime = hourTime.trim();
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableGeneratorDays = new LinkedHashSet<TimeTableGeneratorDays>();
            for (TimeTableGeneratorDays timeTableGeneratorDays : this.timeTableGeneratorDayService.timeTableGeneratorDayByName(dayName)) {
                addTimeTableGeneratorDays.add(timeTableGeneratorDays);
            }
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableGeneratorHours = new LinkedHashSet<TimeTableGeneratorHours>();
            for (TimeTableGeneratorHours timeTableGeneratorHours : this.timeTableGeneratorHourService.timeTableGeneratorHourByTitleAndTimeTableGeneratorDay(hourTime, addTimeTableGeneratorDays)) {
                addTimeTableGeneratorHours.add(timeTableGeneratorHours);
            }
            Set<TimeTableGenerator> timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorByTimeTableGeneratorDayAndTimeTableGeneratorHourEager(addTimeTableGeneratorDays, addTimeTableGeneratorHours);
            return timeTableGenerator;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"classSection"}, method={RequestMethod.GET})
    @ResponseBody
    public Set<TimeTableGenerator> timeTableGeneratorRetrieveByClassSection(HttpServletRequest request) {
        try {
            String[] classSectionIds = request.getParameterValues("classSectionIds");
            ClassSection classSection = null;
            HashSet<TimeTableGenerator> timeTableGenerator = new HashSet<TimeTableGenerator>();
            String[] stringArray = classSectionIds;
            int n = classSectionIds.length;
            int n2 = 0;
            while (n2 < n) {
                String classSectionId = stringArray[n2];
                if (classSectionId != "" && !classSectionId.isEmpty()) {
                    String[] splitsClassSectionId = classSectionId.split(",");
                    splitsClassSectionId = (String[])Arrays.stream(splitsClassSectionId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                    int i = 0;
                    while (i < splitsClassSectionId.length) {
                        classSection = this.classSectionService.classSectionByIdEager(Long.parseLong(splitsClassSectionId[i].toString()));
                        if (this.timeTableGeneratorService.timeTableGeneratorEagerByClassSectionId(classSection.getClassSectionId()) != null) {
                            TimeTableGenerator currentTimeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorEagerByClassSectionId(classSection.getClassSectionId());
                            currentTimeTableGenerator.setClassSection(classSection);
                            timeTableGenerator.add(currentTimeTableGenerator);
                        }
                        ++i;
                    }
                }
                ++n2;
            }
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving TimeTableGenerator with ClassSection id=" + classSection.getClassSectionId()));
            return timeTableGenerator;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"editRetrieve"}, method={RequestMethod.GET})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('timetablegenerator/view')")
    public TimeTableGenerator timeTableGeneratorRetrieve(HttpServletRequest request) {
        try {
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("timeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            return this.timeTableGeneratorService.timeTableGeneratorIdByEager(timeTableGeneratorId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetablegenerator/delete')")
    public String deleteTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("deleteTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            this.timeTableGeneratorService.deleteTimeTableGenerator(timeTableGeneratorId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Deleted Successfully...!"));
            return "redirect:/timetable/generator";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetablegenerator/update')")
    public String updateTimeTableGenerator(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableGeneratorId = Long.parseLong(request.getParameter("updateTimeTableGeneratorId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours with id=" + timeTableGeneratorId));
            String[] timeTableDays = request.getParameterValues("editTimeTableDays");
            String[] timeTableHourSubjects = request.getParameterValues("editTimeTableHourSubjects");
            String[] timeTableDayIds = request.getParameterValues("timeTableDayIds");
            String[] timeTableHourIds = request.getParameterValues("timeTableHourIds");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            LinkedHashSet<TimeTableGeneratorDays> addTimeTableDays = new LinkedHashSet<TimeTableGeneratorDays>();
            LinkedHashSet<TimeTableGeneratorHours> addTimeTableHours = new LinkedHashSet<TimeTableGeneratorHours>();
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorService.timeTableGeneratorIdByEager(timeTableGeneratorId);
            timeTableGenerator.setAcademicYear(academicYear);
            String[] timeTableGenratorDayId = null;
            TimeTableGeneratorDays timeTableGeneratorDay = null;
            String[] stringArray = timeTableDayIds;
            int n = timeTableDayIds.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableDayId = stringArray[n2];
                if (timeTableDayId.toString() != "" && !timeTableDayId.toString().isEmpty()) {
                    timeTableGenratorDayId = timeTableDayId.split(",");
                }
                ++n2;
            }
            String[] timeTableGeneratorHourSubjectId = null;
            String[] stringArray2 = timeTableHourIds;
            int n3 = timeTableHourIds.length;
            n = 0;
            while (n < n3) {
                String timeTableHourSubjectId = stringArray2[n];
                if (timeTableHourSubjectId.toString() != "" && !timeTableHourSubjectId.toString().isEmpty()) {
                    timeTableGeneratorHourSubjectId = timeTableHourSubjectId.split("-");
                }
                ++n;
            }
            timeTableGenratorDayId = (String[])Arrays.stream(timeTableGenratorDayId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            timeTableGeneratorHourSubjectId = (String[])Arrays.stream(timeTableGeneratorHourSubjectId).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
            stringArray2 = timeTableDays;
            n3 = timeTableDays.length;
            n = 0;
            while (n < n3) {
                String timeTableDay = stringArray2[n];
                if (timeTableDay != "" && !timeTableDay.isEmpty()) {
                    String[] splitsDay = timeTableDay.split(",");
                    int i = 0;
                    while (i < splitsDay.length) {
                        if (splitsDay[i].toString() != "" && !splitsDay[i].toString().isEmpty()) {
                            if (timeTableGenratorDayId[i].toString() != "" && !timeTableGenratorDayId[i].toString().isEmpty()) {
                                timeTableGeneratorDay = this.timeTableGeneratorDayService.timeTableGeneratorDayByTimeTableGeneratorAndTimeTableGeneratorDayId(Long.parseLong(timeTableGenratorDayId[i].toString()), timeTableGenerator.getTimeTableGeneratorId());
                                timeTableGeneratorDay.setTimeTableGeneratorDayName(splitsDay[i].toString());
                                addTimeTableDays.add(timeTableGeneratorDay);
                            }
                            String[] stringArray3 = timeTableHourSubjects;
                            int n4 = timeTableHourSubjects.length;
                            int n5 = 0;
                            while (n5 < n4) {
                                String timeTableHourSubject = stringArray3[n5];
                                String[] splitsHourSubject = timeTableHourSubject.split("/");
                                if ((splitsHourSubject = (String[])Arrays.stream(splitsHourSubject).filter(s -> s != null && s.length() > 0).toArray(String[]::new))[i].toString() != "" && !splitsHourSubject[i].toString().isEmpty()) {
                                    String[] splitSubjects = splitsHourSubject[i].split(",");
                                    splitSubjects = (String[])Arrays.stream(splitSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    String[] splitHourSubjects = timeTableGeneratorHourSubjectId[i].split(",");
                                    splitHourSubjects = (String[])Arrays.stream(splitHourSubjects).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                    int j = 0;
                                    while (j < splitSubjects.length) {
                                        if (splitSubjects[j].toString() != "" && !splitSubjects[j].toString().isEmpty()) {
                                            String[] moduleName = splitSubjects[j].split("-");
                                            if (moduleName[0].toString().equals("Break") || moduleName[0].toString().equals("Lunch")) {
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                timeTableGeneratorHour.setModule(null);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            } else {
                                                Module module = this.moduleService.moduleByModuleNameAndInstitution(moduleName[0].toString(), instituteId);
                                                TimeTableGeneratorHours timeTableGeneratorHour = this.timeTableGeneratorHourService.timeTableGeneratorHourByTimeTableGeneratorDayAndTimeTableGeneratorHourId(Long.parseLong(splitHourSubjects[j].toString()), timeTableGeneratorDay.getTimeTableGeneratorDayId());
                                                timeTableGeneratorHour.setsubjectName(splitSubjects[j].toString());
                                                timeTableGeneratorHour.setModule(module);
                                                addTimeTableHours.add(timeTableGeneratorHour);
                                            }
                                        }
                                        ++j;
                                    }
                                }
                                ++n5;
                            }
                        }
                        ++i;
                    }
                }
                ++n;
            }
            this.timeTableGeneratorService.updateTimeTableGenerator(timeTableGenerator, addTimeTableDays, addTimeTableHours);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Updated Successfully...!"));
            return "redirect:/timetable/generator";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            throw e;
        }
    }
}
