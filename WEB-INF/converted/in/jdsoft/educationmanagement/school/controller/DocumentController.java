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

import in.jdsoft.educationmanagement.school.model.DocumentType;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.DocumentTypeService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
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

@Controller(value="documentController")
@RequestMapping(value={"/document"})
public class DocumentController {
    private Logger log = LogManager.getLogger((String)DocumentController.class.getName());
    @Autowired
    private DocumentTypeService documentTypeService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET}, value={"/type"})
    public ModelAndView displaySectionPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed document type page"));
            ModelAndView modelandview = new ModelAndView("documenttype");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("documentTypes", this.documentTypeService.documentTypeList(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/add"})
    public String createDocumentType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create document type"));
            String documentTypeName = request.getParameter("documentTypeName");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            this.documentTypeService.createDocumentType(new DocumentType(documentTypeName, 0, this.institutionService.institutionById(institutionId)));
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "DocumentType Created Successfully...!"));
            return "redirect:/document/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            e.printStackTrace();
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/type/{id}"})
    @ResponseBody
    public DocumentType documentTypeById(@PathVariable(value="id") Long documentTypeId, HttpServletRequest request) {
        DocumentType documentType = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving documentType with id=" + documentTypeId));
            documentType = this.documentTypeService.documentTypeById(documentTypeId);
            return documentType;
        }
        catch (Exception e) {
            return documentType;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/type/list"})
    @ResponseBody
    public List<DocumentType> documentTypeList(HttpServletRequest request) {
        List<DocumentType> documentType = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving documentTypeList"));
            documentType = this.documentTypeService.documentTypeList();
            return documentType;
        }
        catch (Exception e) {
            return documentType;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/delete"})
    public String deleteDocumentType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long documentTypeId = Long.parseLong(request.getParameter("deleteDocumentTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting documentType with id=" + documentTypeId));
            this.documentTypeService.deleteDocumentType(documentTypeId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "DocumentType Deleted Successfully...!"));
            return "redirect:/document/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/document/type";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/type/update"})
    public String updateDocumentType(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long documentTypeId = Long.parseLong(request.getParameter("updateDocumentTypeId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating documentType with id=" + documentTypeId));
            DocumentType documentType = this.documentTypeService.documentTypeById(documentTypeId);
            String updatedDocumentTypeName = request.getParameter("editDocumentTypeName");
            documentType.setDocumentTypeTitle(updatedDocumentTypeName);
            this.documentTypeService.updateDocumentType(documentType);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "DocumentType Updated Successfully...!"));
            return "redirect:/document/type";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/document/type";
        }
    }
}
