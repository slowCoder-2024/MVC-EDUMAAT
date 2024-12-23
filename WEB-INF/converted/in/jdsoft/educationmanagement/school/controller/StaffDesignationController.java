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
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.StaffDesignationService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="staffDesignationController")
@RequestMapping(value={"/staffdesignation"})
public class StaffDesignationController {
    private Logger log = LogManager.getLogger((String)StaffDesignationController.class.getName());
    @Autowired
    StaffTypeService staffTypeService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    StaffDesignationService staffDesignationService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayStaffDesignationPage(HttpServletRequest request) throws Exception {
        try {
            ModelAndView modelandview = new ModelAndView("staffdesignation");
            modelandview.addObject("staffTypes", this.staffTypeService.staffTypeList());
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("staffDesignations", this.staffDesignationService.staffDesignationListEager(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    public String createStaffDesignation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create staff designation"));
            Long staffTypeId = Long.parseLong(request.getParameter("staffTypeId"));
            StaffType staffType = this.staffTypeService.staffTypeById(staffTypeId);
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            String createdBy = request.getSession().getAttribute("username").toString();
            String staffDesignationName = request.getParameter("staffDesignationName");
            StaffDesignation staffDesignation = new StaffDesignation(staffDesignationName, createdBy, staffType, institution);
            this.staffDesignationService.createStaffDesignation(staffDesignation);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Designation Created Successfully...!"));
            return "redirect:/staffdesignation";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staffdesignation";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/stafftype/{id}"})
    @ResponseBody
    public List<StaffDesignation> staffDesignationByStaffType(@PathVariable(value="id") Long staffTypeId, HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to reterive staff designation from staff type"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            return this.staffDesignationService.staffDesignationList(institutionId, staffTypeId);
        }
        catch (Exception e) {
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public StaffDesignation staffDesignationById(@PathVariable(value="id") Long staffDesignationId, HttpServletRequest request) {
        StaffDesignation staffDesignation = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving staff designation with id=" + staffDesignationId));
            staffDesignation = this.staffDesignationService.staffDesignationByIdEager(staffDesignationId);
            return staffDesignation;
        }
        catch (Exception e) {
            return staffDesignation;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    public String deleteStaffDesignation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long staffDesignationId = Long.parseLong(request.getParameter("deleteStaffDesignationId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting staff designation with id=" + staffDesignationId));
            this.staffDesignationService.deleteStaffDesignation(staffDesignationId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Designation Deleted Successfully...!"));
            return "redirect:/staffdesignation";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staffdesignation";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    public String updateStaffDesignation(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long staffDesignationId = Long.parseLong(request.getParameter("updateDesignationId"));
            Long updatedStaffTypeId = Long.parseLong(request.getParameter("editStaffTypeId"));
            String updatedStaffDesignationName = request.getParameter("editStaffDesignationName");
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating staff designation with id=" + staffDesignationId));
            StaffType staffType = null;
            if (updatedStaffTypeId != null) {
                staffType = this.staffTypeService.staffTypeById(updatedStaffTypeId);
            }
            StaffDesignation staffDesignation = null;
            staffDesignation = this.staffDesignationService.staffDesignationById(staffDesignationId);
            staffDesignation.setStaffType(staffType);
            staffDesignation.setStaffDesignationName(updatedStaffDesignationName);
            this.staffDesignationService.updateStaffDesignation(staffDesignation);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Staff Designation Updated Successfully...!"));
            return "redirect:/staffdesignation";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/staffdesignation";
        }
    }
}
