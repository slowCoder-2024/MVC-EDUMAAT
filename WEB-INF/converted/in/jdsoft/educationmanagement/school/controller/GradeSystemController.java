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

import in.jdsoft.educationmanagement.school.exceptions.GradeSystemException;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.GradeSystemService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
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

@Controller(value="gradeSystemController")
@RequestMapping(value={"gradesystem/template"})
public class GradeSystemController {
    private Logger log = LogManager.getLogger((String)GradeSystemController.class.getName());
    @Autowired
    private GradeSystemService gradeSystemService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('gradetemplate')")
    public ModelAndView displayGradeSystemPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed GradeSystem page"));
            ModelAndView modelandview = new ModelAndView("gradesystemtemplate");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("gradeSystemList", this.gradeSystemService.gradeSystemList(instituteId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(value={"add"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('gradetemplate/add')")
    public String addGradeSystem(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create GradeSystem,GradeSystemDetail"));
            String gradeSystemName = request.getParameter("gradeSystemName");
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(instituteId);
            GradeSystem gradeSystem = new GradeSystem(gradeSystemName, institution);
            String[] gradeSystemIds = request.getParameterValues("gradeSystemIds");
            LinkedHashSet<GradeSystemDetail> gradeSystemDetails = new LinkedHashSet<GradeSystemDetail>();
            String[] stringArray = gradeSystemIds;
            int n = gradeSystemIds.length;
            int n2 = 0;
            while (n2 < n) {
                String gradeSystemId = stringArray[n2];
                String[] splitsgradesytem = gradeSystemId.split("-");
                int k = 1;
                int i = 0;
                while (i < splitsgradesytem.length) {
                    if (splitsgradesytem[i].toString() != "") {
                        String gradetitle = request.getParameter("gradeSystemTitle" + k);
                        Double marksfrom = Double.parseDouble(request.getParameter("marksFrom" + k));
                        Double marksto = Double.parseDouble(request.getParameter("marksTo" + k));
                        Double gradePoint = Double.parseDouble(request.getParameter("gradePoint" + k));
                        GradeSystemDetail gradeSystemDetail = new GradeSystemDetail(gradeSystem, gradetitle, marksfrom, marksto, gradePoint);
                        gradeSystemDetails.add(gradeSystemDetail);
                        ++k;
                    }
                    ++i;
                }
                ++n2;
            }
            this.gradeSystemService.createGradeSystem(gradeSystem, gradeSystemDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Grade System Created Successfully...!"));
            return "redirect:/gradesystem/template";
        }
        catch (Exception e) {
            if (e.getClass().equals(GradeSystemException.class)) {
                GradeSystemException gradeSystemException = (GradeSystemException)e;
                redirectAttributes.addFlashAttribute("message", (Object)gradeSystemException.getCustomMessage());
                return "redirect:/gradesystem/template";
            }
            throw e;
        }
    }

    @RequestMapping(value={"delete"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('gradetemplate/delete')")
    public String deleteGradeSystem(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long gradeSystemId = Long.parseLong(request.getParameter("deleteGradeSystemId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting GradeSystem,GradeSystemDetail with id=" + gradeSystemId));
            this.gradeSystemService.deleteGradeSystem(gradeSystemId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Grade System Created Successfully...!"));
            return "redirect:/gradesystem/template";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Cannot be deleted"));
                    return "redirect:/gradesystem/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"editRetrieve"}, method={RequestMethod.GET})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('gradetemplate/view')")
    public GradeSystem editGradeSystemRetrieve(HttpServletRequest request) {
        try {
            Long gradeSystemId = Long.parseLong(request.getParameter("gradeSystemId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " retrieving GradeSystem,GradeSystemDetail with id=" + gradeSystemId));
            return this.gradeSystemService.gradeSystemIdByEager(gradeSystemId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(value={"update"}, method={RequestMethod.POST})
    @PreAuthorize(value="hasAuthority('gradetemplate/update')")
    public String updateGradeSystem(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long gradeSystemId = Long.parseLong(request.getParameter("gradeSystemId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating GradeSystem,GradeSystemDetail with id=" + gradeSystemId));
            return "redirect:/gradesystem/template";
        }
        catch (DataIntegrityViolationException e) {
            if (((Object)((Object)e)).getClass().equals(DataIntegrityViolationException.class)) {
                Throwable cause = e.getCause();
                if (cause.getClass().equals(ConstraintViolationException.class)) {
                    redirectAttributes.addFlashAttribute("errorMessage", (Object)new Message("constraintViolation", "Already Exist"));
                    return "redirect:/gradesystem/template";
                }
                throw e;
            }
            e.printStackTrace();
            throw e;
        }
    }
}
