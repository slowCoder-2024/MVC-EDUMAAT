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

import in.jdsoft.educationmanagement.school.exceptions.SMSGatewayDetailsException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SMSGatewayDetails;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.SMSGatewayDetailsService;
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

@Controller(value="sMSGatewayController")
@RequestMapping(value={"/smsgatewaydetails"})
public class SMSGatewayController {
    private Logger log = LogManager.getLogger((String)SMSGatewayController.class.getName());
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private SMSGatewayDetailsService sMSGatewayDetailsService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayHousePage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed smsgatewaydetails page"));
            ModelAndView modelandview = new ModelAndView("smsgatewaydetails");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("sMSGatewayDetails", this.sMSGatewayDetailsService.sMSGatewayDetailsListByInstitution(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    public String createSMSGatewayDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create smsgatewaydetails"));
            String smsGatewayDetailUserName = request.getParameter("smsgatewayusername");
            String smsGatewayDetailPassword = request.getParameter("smsgatewaypassword");
            String smsGatewayDetailSenderId = request.getParameter("smsgatewaysenderid");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            if (!this.sMSGatewayDetailsService.sMSGatewayDetailsListByInstitution(institutionId).isEmpty()) {
                throw new SMSGatewayDetailsException(new Message("failure", "Already Exist"));
            }
            SMSGatewayDetails smsGatewayDetails = new SMSGatewayDetails(smsGatewayDetailUserName.trim(), smsGatewayDetailPassword.trim(), smsGatewayDetailSenderId.trim(), institution);
            this.sMSGatewayDetailsService.createSMSGatewayDetails(smsGatewayDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "SMSGateway Details Created Successfully...!"));
            return "redirect:/smsgatewaydetails";
        }
        catch (Exception e) {
            if (e.getClass().equals(SMSGatewayDetailsException.class)) {
                SMSGatewayDetailsException se = (SMSGatewayDetailsException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)se.getCustomMessage());
                return "redirect:/smsgatewaydetails";
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Created...!"));
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            return "redirect:/smsgatewaydetails";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public SMSGatewayDetails sMSGatewayDetailsById(@PathVariable(value="id") Long sMSGatewayDetailsId, HttpServletRequest request) {
        SMSGatewayDetails sMSGatewayDetails = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving smsgatewaydetails with id=" + sMSGatewayDetailsId));
            sMSGatewayDetails = this.sMSGatewayDetailsService.sMSGatewayDetailsById(sMSGatewayDetailsId);
            return sMSGatewayDetails;
        }
        catch (Exception e) {
            return sMSGatewayDetails;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    public String deleteSMSGatewayDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long sMSGatewayDetailsId = Long.parseLong(request.getParameter("deletesmsgatewaydetailsId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting SMSGatewayDetails with id=" + sMSGatewayDetailsId));
            this.sMSGatewayDetailsService.deleteSMSGatewayDetails(sMSGatewayDetailsId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "SMSGateway Details Deleted Successfully...!"));
            return "redirect:/smsgatewaydetails";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Deleted...!"));
            e.printStackTrace();
            return "redirect:/smsgatewaydetails";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    public String updateSMSGatewayDetails(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long sMSGatewayDetailsId = Long.parseLong(request.getParameter("smsgatewaydetailsId").toString());
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating SMSGatewayDetails with id=" + sMSGatewayDetailsId));
            SMSGatewayDetails sMSGatewayDetails = this.sMSGatewayDetailsService.sMSGatewayDetailsById(sMSGatewayDetailsId);
            String smsGatewayDetailUserName = request.getParameter("editsmsgatewayusername");
            String smsGatewayDetailPassword = request.getParameter("editsmsgatewaypassword");
            String smsGatewayDetailSenderId = request.getParameter("editsmsgatewaysenderid");
            sMSGatewayDetails.setSmsGatewayPassword(smsGatewayDetailPassword);
            sMSGatewayDetails.setSmsGatewaySenderId(smsGatewayDetailSenderId);
            sMSGatewayDetails.setSmsGatewayUserName(smsGatewayDetailUserName);
            this.sMSGatewayDetailsService.updateSMSGatewayDetails(sMSGatewayDetails);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "SMSGateway Details Updated Successfully...!"));
            return "redirect:/smsgatewaydetails";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Updated...!"));
            e.printStackTrace();
            return "redirect:/smsgatewaydetails";
        }
    }
}
