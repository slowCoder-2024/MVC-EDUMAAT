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

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.FeesTermService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
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

@Controller
@RequestMapping(value={"/academicYear"})
public class AcademicYearController {
    private Logger log = LogManager.getLogger((String)AcademicYearController.class.getName());
    @Autowired
    AcademicYearService academicYearService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    FeesTermService feesTermService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('academicyear')")
    public ModelAndView displayAcademicYearPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Academic Year page"));
            ModelAndView modelandview = new ModelAndView("academicYear");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("academicYears", this.academicYearService.academicYearList());
            modelandview.addObject("feesTerms", this.feesTermService.feesTermList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('academicyear/add')")
    public String createAcademicYear(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create academic year"));
            String academicYearTitle = request.getParameter("academicYearTitle");
            Integer academicYearStatus = Integer.parseInt(request.getParameter("academicYearStatus"));
            Long instituteId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Long totalWorkingDays = Long.parseLong(request.getParameter("academicYearTotalWorkingDays"));
            Institution institution = this.institutionService.institutionById(instituteId);
            AcademicYear academicYear = new AcademicYear(academicYearTitle, academicYearStatus, totalWorkingDays, institution);
            this.academicYearService.createAcademicYear(academicYear);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Academic Year Created Successfully...!"));
            return "redirect:/academicYear";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/academicYear";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('academicyear/view')")
    public AcademicYear academicYearById(@PathVariable(value="id") Long academicYearId, HttpServletRequest request) {
        AcademicYear academicYear = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving academic year with id=" + academicYearId));
            academicYear = this.academicYearService.academicYearById(academicYearId);
            return academicYear;
        }
        catch (Exception e) {
            return academicYear;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('academicyear/delete')")
    public String deleteAcademicYear(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long academicYearId = Long.parseLong(request.getParameter("deleteAcademicYearId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting academic year with id=" + academicYearId));
            this.academicYearService.deleteAcademicYear(academicYearId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Academic Year Deleted Successfully...!"));
            return "redirect:/academicYear";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/academicYear";
        }
    }

    @RequestMapping(value={"editUpdate"}, method={RequestMethod.POST})
    public String editAcademicYearUpdate(HttpServletRequest request, HttpServletRequest response, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long academicYearId = Long.parseLong(request.getParameter("updateAcademicYearId"));
            String editAcademicYearTitle = request.getParameter("editAcademicYearTitle");
            Integer editAcademicYearStatus = Integer.parseInt(request.getParameter("editAcademicYearStatus"));
            Long totalWorkingDays = Long.parseLong(request.getParameter("editAcademicYearTotalWorkingDays"));
            AcademicYear academicYear = this.academicYearService.academicYearById(academicYearId);
            academicYear.setAcademicYearTitle(editAcademicYearTitle);
            academicYear.setAcademicYearStatus(editAcademicYearStatus);
            academicYear.setTotalWorkingDays(totalWorkingDays);
            this.academicYearService.updateAcademicYear(academicYear);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Academic Year Updated Successfully...!"));
            return "redirect:/academicYear";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/academicYear";
        }
    }
}
