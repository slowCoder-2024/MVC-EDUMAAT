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

import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
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
@RequestMapping(value={"/specialCategory"})
public class SpecialCategoryController {
    private Logger log = LogManager.getLogger((String)SpecialCategoryController.class.getName());
    @Autowired
    SpecialCategoryService specialCategoryService;
    @Autowired
    InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('specialcategory')")
    public ModelAndView displaySpecialCategoryPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed special category page"));
            ModelAndView modelandview = new ModelAndView("specialcategory");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("specialCategories", this.specialCategoryService.specialCategoryList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('specialcategory/add')")
    public String createSpecialCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create special category"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            String specialCategoryName = request.getParameter("specialCategoryName");
            SpecialCategory specialCategory = new SpecialCategory(specialCategoryName, institution);
            this.specialCategoryService.createSpecialCategory(specialCategory);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Special Category Created Successfully...!"));
            return "redirect:/specialCategory";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/specialCategory";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('specialcategory/view')")
    public SpecialCategory SpecialCategoryById(@PathVariable(value="id") Long specialCategoryId, HttpServletRequest request) {
        SpecialCategory specialCategory = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving special category with id=" + specialCategoryId));
            specialCategory = this.specialCategoryService.specialCategoryById(specialCategoryId);
            return specialCategory;
        }
        catch (Exception e) {
            return specialCategory;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('specialcategory/delete')")
    public String deleteSpecialCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long specialCategoryId = Long.parseLong(request.getParameter("deleteSpecialCategoryId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username") + " deleting special category with id=" + specialCategoryId));
            this.specialCategoryService.deleteSpecialCategory(specialCategoryId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Special Category Deleted Successfully...!"));
            return "redirect:/specialCategory";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/specialCategory";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('specialcategory/update')")
    public String updateSpecialCategory(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long specialCategoryId = Long.parseLong(request.getParameter("updateSpecialCategoryId"));
            String updatedSpecialCategoryName = request.getParameter("editSpecialCategoryName");
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating special category with id=" + specialCategoryId));
            SpecialCategory specialCategory = this.specialCategoryService.specialCategoryById(specialCategoryId);
            specialCategory.setSpecialCategoryName(updatedSpecialCategoryName);
            this.specialCategoryService.updateSpecialCategory(specialCategory);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Special Category Updated Successfully...!"));
            return "redirect:/specialCategory";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/specialCategory";
        }
    }
}
