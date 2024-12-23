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
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SectionService;
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

@Controller(value="sectionController")
@RequestMapping(value={"/section"})
public class SectionController {
    private Logger log = LogManager.getLogger((String)SectionController.class.getName());
    @Autowired
    private SectionService sectionService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('section')")
    public ModelAndView displaySectionPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed section page"));
            ModelAndView modelandview = new ModelAndView("section");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("sections", this.sectionService.sectionList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('section/add')")
    public String createSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create section"));
            String sectionName = request.getParameter("sectionName");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            this.sectionService.createSection(new Section(sectionName, institution));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Section Created Successfully...!"));
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            return "redirect:/class/classnandsection";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('section/view')")
    public Section sectionById(@PathVariable(value="id") Long sectionId, HttpServletRequest request) {
        Section section = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving section with id=" + sectionId));
            section = this.sectionService.sectionById(sectionId);
            return section;
        }
        catch (Exception e) {
            return section;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('section/delete')")
    public String deleteSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long sectionId = Long.parseLong(request.getParameter("deleteSectionId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting section with id=" + sectionId));
            this.sectionService.deleteSection(sectionId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Section Deleted Successfully...!"));
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/class/classnandsection";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('section/update')")
    public String updateSection(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long sectionId = Long.parseLong(request.getParameter("updateSectionId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating section with id=" + sectionId));
            Section section = this.sectionService.sectionById(sectionId);
            String updatedSectionName = request.getParameter("editSectionName");
            section.setSectionName(updatedSectionName);
            this.sectionService.updateSection(section);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Section Updated Successfully...!"));
            return "redirect:/class/classnandsection";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/class/classnandsection";
        }
    }
}
