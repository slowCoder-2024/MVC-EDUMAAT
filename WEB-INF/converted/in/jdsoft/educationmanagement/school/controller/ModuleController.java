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
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.ModuleService;
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

@Controller(value="moduleController")
@RequestMapping(value={"/module"})
public class ModuleController {
    private Logger log = LogManager.getLogger((String)ModuleController.class.getName());
    @Autowired
    ModuleService moduleService;
    @Autowired
    InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('module')")
    public ModelAndView displayModulePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed module page"));
            ModelAndView modelandview = new ModelAndView("module");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("modules", this.moduleService.moduleList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('module/add')")
    public String createModule(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create module"));
            String moduleName = request.getParameter("moduleName");
            String moduleCode = request.getParameter("moduleCode");
            Long totalNumberOfHours = Long.parseLong(request.getParameter("moduleTotalNumberOfHours"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            this.moduleService.createModule(new Module(moduleName, moduleCode, institution, totalNumberOfHours));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Created Successfully...!"));
            return "redirect:/module";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/module";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('module/view')")
    public Module moduleById(@PathVariable(value="id") Long moduleId, HttpServletRequest request) {
        Module module = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving module with id=" + moduleId));
            module = this.moduleService.moduleById(moduleId);
            return module;
        }
        catch (Exception e) {
            return module;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('module/update')")
    public String updateModule(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long moduleId = Long.parseLong(request.getParameter("updateModuleId").toString());
            Module module = this.moduleService.moduleById(moduleId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating module with id=" + moduleId));
            String moduleName = request.getParameter("editModuleName");
            String moduleCode = request.getParameter("editModuleCode");
            Long totalNumberOfHours = Long.parseLong(request.getParameter("editModuleTotalNumberOfHours"));
            module.setModuleName(moduleName);
            module.setModuleCode(moduleCode);
            module.setTotalNumberOfHours(totalNumberOfHours);
            this.moduleService.update(module);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Updated Successfully...!"));
            return "redirect:/module";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/module";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('module/delete')")
    public String deleteModule(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long moduleId = Long.parseLong(request.getParameter("deleteModuleId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting module with id=" + moduleId));
            this.moduleService.deleteModule(moduleId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Module Updated Successfully...!"));
            return "redirect:/module";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/module";
        }
    }
}
