/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.dao.DataIntegrityViolationException
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateDaysService;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateHoursService;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="timeTableTemplateController")
@RequestMapping(value={"timetable/template"})
public class TimeTableTemplateController {
    private Logger log = LogManager.getLogger((String)TimeTableTemplateController.class.getName());
    @Autowired
    private TimeTableTemplateService timeTableTemplateService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private TimeTableTemplateDaysService timeTableTemplateDaysService;
    @Autowired
    private TimeTableTemplateHoursService timeTableTemplateHoursService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('timetabletemplate')")
    public ModelAndView displayTimeTablePage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed TimeTableTemplate page"));
            ModelAndView modelandview = new ModelAndView("timetabletemplate");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("timeTableTemplateList", this.timeTableTemplateService.timeTableTemplateList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"add"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetabletemplate/add')")
    public String addTimeTableTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours"));
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            String timeTableTemplateName = request.getParameter("timeTableTemplateName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            TimeTableTemplate timeTableTemplate = new TimeTableTemplate(timeTableTemplateName, institution);
            String[] timeTableDayIds = request.getParameterValues("timeTableDayIds");
            String[] timeTableHourIds = request.getParameterValues("timeTableHourIds");
            LinkedHashSet<TimeTableTemplateDays> addTimeTableDays = new LinkedHashSet<TimeTableTemplateDays>();
            LinkedHashSet<TimeTableTemplateHours> addTimeTableHours = new LinkedHashSet<TimeTableTemplateHours>();
            String[] stringArray = timeTableDayIds;
            int n = timeTableDayIds.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableDay = stringArray[n2];
                String[] splitsDay = timeTableDay.split(",");
                int i = 0;
                while (i < splitsDay.length) {
                    String dayName = request.getParameter(splitsDay[i].toString());
                    if (dayName != "" && dayName != null) {
                        TimeTableTemplateDays timeTableDayy = new TimeTableTemplateDays(dayName, timeTableTemplate);
                        addTimeTableDays.add(timeTableDayy);
                    }
                    ++i;
                }
                ++n2;
            }
            stringArray = timeTableHourIds;
            n = timeTableHourIds.length;
            n2 = 0;
            while (n2 < n) {
                String timeTableHour = stringArray[n2];
                String[] splitsHour = timeTableHour.split("-");
                int j = 0;
                while (j < splitsHour.length) {
                    String dubHourTitle = "";
                    String dubStartTime = "";
                    String dubEndTime = "";
                    if (splitsHour[j].toString() != "") {
                        String[] splitsHours = splitsHour[j].split(",");
                        int l = 0;
                        while (l < splitsHours.length) {
                            if (splitsHours[l].contains("hourName")) {
                                dubHourTitle = String.valueOf(dubHourTitle) + splitsHours[l].toString() + "-";
                            }
                            if (splitsHours[l].contains("startTime")) {
                                dubStartTime = String.valueOf(dubStartTime) + splitsHours[l].toString() + "-";
                            }
                            if (splitsHours[l].contains("endTime")) {
                                dubEndTime = String.valueOf(dubEndTime) + splitsHours[l].toString() + "-";
                            }
                            ++l;
                        }
                        String[] hourTitle = dubHourTitle.split("-");
                        String[] startTime = dubStartTime.split("-");
                        String[] endTime = dubEndTime.split("-");
                        int m = 0;
                        while (m < hourTitle.length) {
                            if (hourTitle[m].toString() != "" && startTime[m].toString() != "" && endTime.toString() != "") {
                                String hourTitleName = request.getParameter(hourTitle[m].toString());
                                Date hourStartTime = formatter.parse(request.getParameter(startTime[m].toString()));
                                Date hourEndTime = formatter.parse(request.getParameter(endTime[m].toString()));
                                TimeTableTemplateHours timeTableHourss = new TimeTableTemplateHours(hourTitleName, hourStartTime, hourEndTime, timeTableTemplate);
                                addTimeTableHours.add(timeTableHourss);
                            }
                            ++m;
                        }
                    }
                    ++j;
                }
                ++n2;
            }
            this.timeTableTemplateService.createTimeTableTemplate(timeTableTemplate, addTimeTableDays, addTimeTableHours);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Template Created Successfully...!"));
            return "redirect:/timetable/template";
        }
        catch (Exception e) {
            if (e.getClass().equals(TimeTableTemplateException.class)) {
                TimeTableTemplateException timeTableTemplateException = (TimeTableTemplateException)e;
                redirectAttributes.addFlashAttribute("message", (Object)timeTableTemplateException.getCustomMessage());
                return "redirect:/timetable/template";
            }
            throw e;
        }
    }

    @RequestMapping(value={"editRetrieve"}, method={RequestMethod.GET})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('timetabletemplate/view')")
    public TimeTableTemplate editTimeTableTemplateRetrieve(HttpServletRequest request) {
        try {
            Long timeTableTemplateId = Long.parseLong(request.getParameter("timeTableTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours with id=" + timeTableTemplateId));
            return this.timeTableTemplateService.timeTableTemplateIdByEager(timeTableTemplateId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetabletemplate/delete')")
    public String deleteTimeTableTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableTemplateId = Long.parseLong(request.getParameter("deleteTimeTableTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours with id=" + timeTableTemplateId));
            this.timeTableTemplateService.deleteTimeTableTemplate(timeTableTemplateId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "TimeTable Template Deleted Successfully...!"));
            return "redirect:/timetable/template";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Cannot be deleted"));
                    return "redirect:/timetable/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('timetabletemplate/update')")
    public String updateTimeTableTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long timeTableTemplateId = Long.parseLong(request.getParameter("updatetimeTableTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours with id=" + timeTableTemplateId));
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            String timeTableTemplateName = request.getParameter("edittimeTableTemplateName");
            TimeTableTemplate timeTableTemplate = this.timeTableTemplateService.timeTableTemplateIdByEager(timeTableTemplateId);
            timeTableTemplate.setTimeTableName(timeTableTemplateName);
            String[] timeTableDayIds = request.getParameterValues("edittimeTableDayIds");
            String[] timeTableHourIds = request.getParameterValues("edittimeTableHourIds");
            LinkedHashSet<TimeTableTemplateDays> addTimeTableDays = new LinkedHashSet<TimeTableTemplateDays>();
            LinkedHashSet<TimeTableTemplateHours> addTimeTableHours = new LinkedHashSet<TimeTableTemplateHours>();
            String[] stringArray = timeTableDayIds;
            int n = timeTableDayIds.length;
            int n2 = 0;
            while (n2 < n) {
                String timeTableDay = stringArray[n2];
                String[] splitsDay = timeTableDay.split(",");
                int i = 0;
                while (i < splitsDay.length) {
                    String dayName;
                    String[] timetableday = splitsDay[i].split("-");
                    if (timetableday.length > 1) {
                        dayName = request.getParameter(splitsDay[i].toString());
                        if (dayName != "" && dayName != null) {
                            TimeTableTemplateDays timeTableTemplateDay = this.timeTableTemplateDaysService.timeTableTemplateDaysById(Long.parseLong(timetableday[1].toString()));
                            if (timeTableTemplateDay != null) {
                                timeTableTemplateDay.setTimeTableTemplateDayName(dayName);
                                timeTableTemplateDay.setTimeTableTemplate(timeTableTemplate);
                                addTimeTableDays.add(timeTableTemplateDay);
                            } else {
                                TimeTableTemplateDays timeTableDayy = new TimeTableTemplateDays(dayName, timeTableTemplate);
                                addTimeTableDays.add(timeTableDayy);
                            }
                        }
                    } else {
                        dayName = request.getParameter(timetableday[0].toString());
                        if (dayName != "" && dayName != null) {
                            TimeTableTemplateDays timeTableDayy = new TimeTableTemplateDays(dayName, timeTableTemplate);
                            addTimeTableDays.add(timeTableDayy);
                        }
                    }
                    ++i;
                }
                ++n2;
            }
            stringArray = timeTableHourIds;
            n = timeTableHourIds.length;
            n2 = 0;
            while (n2 < n) {
                String timeTableHour = stringArray[n2];
                String[] splitsHour = timeTableHour.split("/");
                int j = 0;
                while (j < splitsHour.length) {
                    String dubHourTitle = "";
                    String dubStartTime = "";
                    String dubEndTime = "";
                    if (splitsHour[j].toString() != "") {
                        String[] splitsHours = splitsHour[j].split(",");
                        int l = 0;
                        while (l < splitsHours.length) {
                            if (splitsHours[l].contains("hourName")) {
                                dubHourTitle = String.valueOf(dubHourTitle) + splitsHours[l].toString() + ",";
                            }
                            if (splitsHours[l].contains("startTime")) {
                                dubStartTime = String.valueOf(dubStartTime) + splitsHours[l].toString() + ",";
                            }
                            if (splitsHours[l].contains("endTime")) {
                                dubEndTime = String.valueOf(dubEndTime) + splitsHours[l].toString() + ",";
                            }
                            ++l;
                        }
                        String[] hourTitle = dubHourTitle.split(",");
                        String[] startTime = dubStartTime.split(",");
                        String[] endTime = dubEndTime.split(",");
                        int m = 0;
                        while (m < hourTitle.length) {
                            if (hourTitle[m].toString() != "" && startTime[m].toString() != "" && endTime.toString() != "") {
                                TimeTableTemplateHours timeTableHours;
                                Date hourEndTime;
                                Date hourStartTime;
                                String hourName;
                                String[] timetablehour = hourTitle[m].split("-");
                                String[] timetablestartTime = startTime[m].split("-");
                                String[] timetableendTime = endTime[m].split("-");
                                if (timetablehour.length > 1 && timetablestartTime.length > 1 && timetableendTime.length > 1) {
                                    hourName = request.getParameter(hourTitle[m].toString());
                                    hourStartTime = formatter.parse(request.getParameter(startTime[m].toString()));
                                    hourEndTime = formatter.parse(request.getParameter(endTime[m].toString()));
                                    timeTableHours = this.timeTableTemplateHoursService.timeTableTemplateHoursById(Long.parseLong(timetablehour[1].toString()));
                                    if (timeTableHours != null) {
                                        timeTableHours.setTimeTableTemplateHourName(hourName);
                                        timeTableHours.setTimeTableTemplateHourStartTime(hourStartTime);
                                        timeTableHours.setTimeTableTemplateHourEndTime(hourEndTime);
                                        timeTableHours.setTimeTableTemplate(timeTableTemplate);
                                        addTimeTableHours.add(timeTableHours);
                                    } else {
                                        TimeTableTemplateHours timeTableHours1 = new TimeTableTemplateHours(hourName, hourStartTime, hourEndTime, timeTableTemplate);
                                        addTimeTableHours.add(timeTableHours1);
                                    }
                                } else {
                                    hourName = request.getParameter(timetablehour[0].toString());
                                    hourStartTime = formatter.parse(request.getParameter(timetablestartTime[0].toString()));
                                    hourEndTime = formatter.parse(request.getParameter(timetableendTime[0].toString()));
                                    timeTableHours = new TimeTableTemplateHours(hourName, hourStartTime, hourEndTime, timeTableTemplate);
                                    addTimeTableHours.add(timeTableHours);
                                }
                            }
                            ++m;
                        }
                    }
                    ++j;
                }
                ++n2;
            }
            timeTableTemplate.setTimeTableTemplateDays(addTimeTableDays);
            timeTableTemplate.setTimeTableTemplateHours(addTimeTableHours);
            return "redirect:/timetable/template";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Already Exist"));
                    return "redirect:/timetable/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }
}
