/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import in.jdsoft.educationmanagement.school.services.ComplaintManagementService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.LinkedHashSet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="complaintManagementController")
@RequestMapping(value={"/complaintManagement"})
public class ComplaintManagementController {
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private UserService userService;
    @Autowired
    private AcademicYearService academicYearService;
    @Autowired
    private ComplaintManagementService complaintManagementService;

    @RequestMapping(method={RequestMethod.GET}, value={"/approvals"})
    public ModelAndView displayComplaintApprovalsPage(HttpServletRequest request) {
        try {
            String email = request.getSession().getAttribute("username").toString();
            ModelAndView modelandview = new ModelAndView("complaintapprover");
            modelandview.addObject("complaintApprovePendingList", this.complaintManagementService.complaintManagementListByApprover(email));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/requisition"})
    public ModelAndView displayComplaintRequisitionPage(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("complaintrequester");
            String email = request.getSession().getAttribute("username").toString();
            modelandview.addObject("complaintManagementLists", this.complaintManagementService.complaintManagementListByRequesterEmail(email));
            modelandview.addObject("complaintApprovedOrRejectedLists", this.complaintManagementService.complaintManagementApprovedAndRejectedLists(email));
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"/complaintRequest"}, method={RequestMethod.POST})
    public String addComplaintRequisition(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            String complaintStatus = "Pending";
            String complaintReason = request.getParameter("complaintReason");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            AcademicYear academicYear = this.academicYearService.getActiveAcademicYear();
            String email = request.getSession().getAttribute("username").toString();
            User requester = this.userService.userByEmailEager(email);
            User approver = this.userService.principalRoleApproverByInstitution(institutionId);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(approver);
            PortalTask portalTask = new PortalTask("Complaint Approval", "Complaint Approval", addUser, 1, "/complaintManagement/approvals", request.getSession().getAttribute("username").toString(), institution);
            ComplaintManagement complaintManagement = new ComplaintManagement(complaintReason, complaintStatus, email, email, requester, approver, institution, academicYear);
            this.complaintManagementService.createComplaintManagement(complaintManagement, portalTask);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Complaint Request Sent Successfully...!"));
            return "redirect:/complaintManagement/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/complaintManagement/requisition";
        }
    }

    @RequestMapping(value={"/cancel"}, method={RequestMethod.POST})
    public String cancelComplaint(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Long complaintId = Long.parseLong(request.getParameter("complaintId"));
            ComplaintManagement complaintManagement = this.complaintManagementService.complaintManagementByIdEager(complaintId);
            complaintManagement.setComplaintStatus("Cancelled");
            this.complaintManagementService.cancelComplaintManagement(complaintManagement);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Complaint Request Cancelled Successfully...!"));
            return "redirect:/complaintManagement/requisition";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/complaintManagement/requisition";
        }
    }

    @RequestMapping(value={"/updatestatus"}, method={RequestMethod.POST})
    public String updateComplaintApprovalsStatus(HttpServletRequest request) {
        try {
            Long complaintId = Long.parseLong(request.getParameter("complaintId"));
            String approverComment = request.getParameter("complaintApproverComment");
            String status = request.getParameter("complaintStatus");
            ComplaintManagement complaintManagement = this.complaintManagementService.complaintManagementByIdEager(complaintId);
            String email = request.getSession().getAttribute("username").toString();
            complaintManagement.setModifiedBy(email);
            complaintManagement.setComplaintStatus(status);
            complaintManagement.setActionTaken(approverComment);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(complaintManagement.getComplaintSender());
            PortalTask portalTask = new PortalTask("Complaint " + status, "Complaint " + status, addUser, 1, "/complaintManagement/requisition", complaintManagement.getComplaintReceiver().getEmail(), complaintManagement.getComplaintReceiver().getInstitution());
            this.complaintManagementService.updateComplaintManagement(complaintManagement, portalTask);
            return "redirect:/complaintManagement/approvals";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/complaintManagement/approvals";
        }
    }
}
