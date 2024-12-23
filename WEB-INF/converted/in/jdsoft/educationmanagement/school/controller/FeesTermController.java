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

import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
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
@RequestMapping(value={"/feesTerm"})
public class FeesTermController {
    private Logger log = LogManager.getLogger((String)FeesTermController.class.getName());
    @Autowired
    FeesTermService feesTermService;
    @Autowired
    InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('feesterm')")
    public ModelAndView displayAcademicYearPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed Fees Term page"));
            ModelAndView modelandview = new ModelAndView("feesterm");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("feesTerms", this.feesTermService.feesTermList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('feesterm/add')")
    public String createFeesTerm(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create Fees Term"));
            String feesTermName = request.getParameter("feesTermName");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            this.feesTermService.createFeesTerm(new FeesTerm(feesTermName, institution));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Category Created Successfully...!"));
            return "redirect:/feesTerm";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/feesTerm";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('feesterm/view')")
    public FeesTerm feesTermById(@PathVariable(value="id") Long feesTermId, HttpServletRequest request) {
        FeesTerm feesTerm = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving fees term with id=" + feesTermId));
            feesTerm = this.feesTermService.feesTermById(feesTermId);
            return feesTerm;
        }
        catch (Exception e) {
            return feesTerm;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('feesterm/delete')")
    public String deleteSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesTermId = Long.parseLong(request.getParameter("feesTermid"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting fees term with id=" + feesTermId));
            this.feesTermService.deleteFeesTerm(feesTermId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Category Deleted Successfully...!"));
            return "redirect:/feesTerm";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/feesTerm";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('feesterm/update')")
    public String updateSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long feesTermId = Long.parseLong(request.getParameter("updateFeesTermId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating fees term with id=" + feesTermId));
            FeesTerm feesTerm = this.feesTermService.feesTermById(feesTermId);
            String updatedFeesTermName = request.getParameter("editFeesTermName");
            feesTerm.setFeesTermName(updatedFeesTermName);
            this.feesTermService.update(feesTerm);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Fees Category Updated Successfully...!"));
            return "redirect:/feesTerm";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/feesTerm";
        }
    }
}
