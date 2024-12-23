/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.controller.ExamController;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import in.jdsoft.educationmanagement.school.model.VisitorType;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.VisitorManagementService;
import in.jdsoft.educationmanagement.school.services.VisitorTypeService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="visitorManagementController")
@RequestMapping(value={"/visitormanagement"})
public class VisitorManagementController {
    private Logger log = LogManager.getLogger((String)ExamController.class.getName());
    @Autowired
    private VisitorTypeService visitorTypeService;
    @Autowired
    private VisitorManagementService visitorManagementService;
    @Autowired
    private InstitutionService institutionService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayVisitorPage(HttpServletRequest request) throws Exception {
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has visitor management page"));
        ModelAndView modelandview = new ModelAndView("visitormanagementsystem");
        modelandview.addObject("visitorTypes", this.visitorTypeService.visitorTypeList());
        Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
        modelandview.addObject("visitorManagementList", this.visitorManagementService.visitorManagementListByInsitution(institutionId));
        return modelandview;
    }

    @RequestMapping(value={"/add"}, method={RequestMethod.POST})
    public String addVisitor(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String createdBy = request.getSession().getAttribute("username").toString();
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat timeformatter = new SimpleDateFormat("HH:mm");
            VisitorType visitorType = this.visitorTypeService.visitorTypeById(Long.parseLong(request.getParameter("visitorType")));
            String visitorName = request.getParameter("visitorname");
            String visitorEmail = request.getParameter("visitoremail");
            String visitorMobileNumber = request.getParameter("visitormobilenumber");
            String whomToMeet = request.getParameter("visitorwhomtomeet");
            String purposeOfMeet = request.getParameter("visitorpurposeofvisit");
            String meetingDate = request.getParameter("visitorDate");
            Date date = formatter.parse(meetingDate);
            String inTime = request.getParameter("visitorcheckintime");
            String outTime = request.getParameter("visitorcheckouttime");
            Date checkInDate = timeformatter.parse(inTime);
            Date checkOutTime = timeformatter.parse(outTime);
            VisitorManagement visitorManagement = new VisitorManagement(visitorName, visitorType, institution, visitorEmail, visitorMobileNumber, whomToMeet, purposeOfMeet, date, checkInDate, checkOutTime, createdBy, createdBy);
            String applicationRootPath = request.getRealPath("/");
            String imagelocation = "/resources/themes/images/visitor-QRcode-image/";
            String QRCodeImageLocation = String.valueOf(applicationRootPath) + "@" + imagelocation;
            VisitorIDCardGeneration visitorIDCardGeneration = new VisitorIDCardGeneration(visitorManagement, institution, createdBy, createdBy);
            visitorIDCardGeneration.setQrImage(QRCodeImageLocation);
            visitorManagement.setVisitorIDCardGeneration(visitorIDCardGeneration);
            this.visitorManagementService.createVisitorManagement(visitorManagement);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Visitor Information Added Successfully...!"));
            return "redirect:/visitormanagement";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/visitormanagement";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/view"})
    public ModelAndView displayVisitorManagementViewPage(HttpServletRequest request) throws Exception {
        this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has visitor management view page"));
        ModelAndView modelandview = new ModelAndView("viewvisitormanagement");
        Long visitorManagementId = Long.parseLong(request.getParameter("visitorManagementId"));
        modelandview.addObject("visitorManagementList", (Object)this.visitorManagementService.visitorManagementByIdEager(visitorManagementId));
        return modelandview;
    }

    @RequestMapping(value={"printPage"})
    public ModelAndView printPageReceipt(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has visitor management view page"));
            ModelAndView modelandview = new ModelAndView("viewvisitormanagement");
            Long visitorManagementId = Long.parseLong(request.getParameter("visitorManagementId"));
            modelandview.addObject("visitorManagementList", (Object)this.visitorManagementService.visitorManagementByIdEager(visitorManagementId));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
