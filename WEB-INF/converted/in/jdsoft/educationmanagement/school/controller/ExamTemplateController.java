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

import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Term;
import in.jdsoft.educationmanagement.school.model.TermExam;
import in.jdsoft.educationmanagement.school.services.ExamTemplateService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import java.util.Arrays;
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

@Controller(value="examTemplateController")
@RequestMapping(value={"exam/template"})
public class ExamTemplateController {
    private Logger log = LogManager.getLogger((String)ExamTemplateController.class.getName());
    @Autowired
    private ExamTemplateService examTemplateService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('examtemplate')")
    public ModelAndView displayExamTemplatePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed ExamTemplate page"));
            ModelAndView modelandview = new ModelAndView("examtemplate");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("examTemplateList", this.examTemplateService.examTemplateList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(value={"add"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('examtemplate/add')")
    public String addExamTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create ExamTemplate,Term,TermExam"));
            String examTemplateName = request.getParameter("examTemplateName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            ExamTemplate examTemplate = new ExamTemplate(examTemplateName, institution);
            String[] termIds = request.getParameterValues("termIds");
            String[] termExamIds = request.getParameterValues("termExamIds");
            LinkedHashSet<Term> addTerms = new LinkedHashSet<Term>();
            LinkedHashSet<TermExam> addTermExams = new LinkedHashSet<TermExam>();
            String[] stringArray = termIds;
            int n = termIds.length;
            int n2 = 0;
            while (n2 < n) {
                String term = stringArray[n2];
                String[] splitsterm = term.split(",");
                splitsterm = (String[])Arrays.stream(splitsterm).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                int k = 1;
                int i = 0;
                while (i < splitsterm.length) {
                    String termname = request.getParameter(splitsterm[i].toString());
                    Term termm = new Term(termname, examTemplate);
                    addTerms.add(termm);
                    String[] stringArray2 = termExamIds;
                    int n3 = termExamIds.length;
                    int n4 = 0;
                    while (n4 < n3) {
                        String termExam = stringArray2[n4];
                        String[] splitstermexamdatas = termExam.split("-");
                        splitstermexamdatas = (String[])Arrays.stream(splitstermexamdatas).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                        int j = 0;
                        while (j < splitstermexamdatas.length) {
                            String termExamName = "";
                            String termExamPercentage = "";
                            if (splitstermexamdatas[j].toString() != "" && splitstermexamdatas[j].contains("termExam" + k)) {
                                String[] splitstermexamdata = splitstermexamdatas[j].split(",");
                                splitstermexamdata = (String[])Arrays.stream(splitstermexamdata).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                int l = 0;
                                while (l < splitstermexamdata.length) {
                                    if (splitstermexamdata[l].contains("termExam" + k + "termExamPercentage")) {
                                        termExamPercentage = String.valueOf(termExamPercentage) + splitstermexamdata[l].toString() + "-";
                                    }
                                    if (splitstermexamdata[l].contains("termExam" + k + "termExamName")) {
                                        termExamName = String.valueOf(termExamName) + splitstermexamdata[l].toString() + "-";
                                    }
                                    ++l;
                                }
                                String[] curTermExamName = termExamName.split("-");
                                String[] curTermExamPercentage = termExamPercentage.split("-");
                                curTermExamName = (String[])Arrays.stream(curTermExamName).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                curTermExamPercentage = (String[])Arrays.stream(curTermExamPercentage).filter(s -> s != null && s.length() > 0).toArray(String[]::new);
                                int m = 0;
                                while (m < curTermExamName.length) {
                                    if (curTermExamName[m].toString() != "" && curTermExamPercentage[m].toString() != "") {
                                        String finalTermExamName = request.getParameter(curTermExamName[m].toString());
                                        Double finalTermExamPercentage = Double.parseDouble(request.getParameter(curTermExamPercentage[m].toString()));
                                        TermExam finalTermExam = new TermExam(finalTermExamName, finalTermExamPercentage, termm);
                                        addTermExams.add(finalTermExam);
                                    }
                                    ++m;
                                }
                            }
                            ++j;
                        }
                        ++n4;
                    }
                    ++k;
                    ++i;
                }
                ++n2;
            }
            this.examTemplateService.createExamTemplate(examTemplate, addTerms, addTermExams);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Exam Template Created Successfully...!"));
            return "redirect:/exam/template";
        }
        catch (Exception e) {
            if (e.getClass().equals(ExamTemplateException.class)) {
                ExamTemplateException examTemplateException = (ExamTemplateException)e;
                redirectAttributes.addFlashAttribute("message", (Object)examTemplateException.getCustomMessage());
                return "redirect:/exam/template";
            }
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('examtemplate/delete')")
    public String deleteExamTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long examTemplateId = Long.parseLong(request.getParameter("deleteExamTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting ExamTemplate,Term,TermExam with id=" + examTemplateId));
            this.examTemplateService.deleteExamTemplate(examTemplateId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Exam Template Deleted Successfully...!"));
            return "redirect:/exam/template";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Cannot be deleted"));
                    return "redirect:/exam/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"editRetrieve"}, method={RequestMethod.GET})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('examtemplate/view')")
    public ExamTemplate editExamTemplateRetrieve(HttpServletRequest request) {
        try {
            Long examTemplateId = Long.parseLong(request.getParameter("examTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving ExamTemplate,Term,TermExam with id=" + examTemplateId));
            return this.examTemplateService.examTemplateIdByEager(examTemplateId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"/update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('examtemplate/update')")
    public String updateExamTemplate(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long examTemplateId = Long.parseLong(request.getParameter("editExamTemplateId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating ExamTemplate,Term,TermExam with id=" + examTemplateId));
            return "redirect:/exam/template";
        }
        catch (Exception e) {
            e.printStackTrace();
            if (e.getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Already Exist"));
                    return "redirect:/exam/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }
}
