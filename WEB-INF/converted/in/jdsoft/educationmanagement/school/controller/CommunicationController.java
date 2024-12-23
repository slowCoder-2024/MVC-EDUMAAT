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

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.exceptions.CommunicationException;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.ClassService;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersArchiveService;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersHistoryService;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersService;
import in.jdsoft.educationmanagement.school.services.CommunicationMessageModeService;
import in.jdsoft.educationmanagement.school.services.CommunicationNotificationArchiveService;
import in.jdsoft.educationmanagement.school.services.CommunicationNotificationService;
import in.jdsoft.educationmanagement.school.services.CommunicationTargetGroupService;
import in.jdsoft.educationmanagement.school.services.InstitutionConfigDetailsService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PortalMessageService;
import in.jdsoft.educationmanagement.school.services.PortalNotificationService;
import in.jdsoft.educationmanagement.school.services.PortalReplyMessageService;
import in.jdsoft.educationmanagement.school.services.PortalTaskService;
import in.jdsoft.educationmanagement.school.services.StaffService;
import in.jdsoft.educationmanagement.school.services.StaffTypeService;
import in.jdsoft.educationmanagement.school.services.StudentService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="communicationController")
@RequestMapping(value={"/communication"})
public class CommunicationController {
    private Logger log = LogManager.getLogger((String)CommunicationController.class.getName());
    @Autowired
    private CommunicationMessageModeService communicationMessageModeService;
    @Autowired
    private CommunicationTargetGroupService communicationTargetGroupService;
    @Autowired
    private StaffTypeService staffTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommunicationNotificationService communicationNotificationService;
    @Autowired
    private CommunicationNotificationArchiveService communicationNotificationArchiveService;
    @Autowired
    private CommunicationFeedBackAndOthersArchiveService communicationFeedBackAndOthersArchiveService;
    @Autowired
    private ClassService classService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private PortalNotificationService portalNotificationService;
    @Autowired
    private PortalMessageService portalMessageService;
    @Autowired
    private PortalReplyMessageService portalReplyMessageService;
    @Autowired
    private CommunicationFeedBackAndOthersService communicationFeedBackAndOthersService;
    @Autowired
    private CommunicationFeedBackAndOthersHistoryService communicationFeedBackAndOthersHistoryService;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private PortalTaskService portalTaskService;
    @Autowired
    InstitutionConfigDetailsService institutionConfigDetailsService;

    @RequestMapping(method={RequestMethod.GET})
    public ModelAndView displayCommunicationPage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed communication page"));
            ModelAndView modelandview = new ModelAndView("communication");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            String email = request.getSession().getAttribute("username").toString();
            this.emailHandler.setMailFrom(email);
            boolean feesadmin = false;
            boolean inventoryandassetadmin = false;
            boolean superadmin = false;
            boolean libraryadmin = false;
            boolean visitoradmin = false;
            InstitutionConfigDetails institutionConfigDetails = this.institutionConfigDetailsService.institutionConfigDetailsById(Long.parseLong(request.getSession().getAttribute("institutionConfigDetailsId").toString()));
            User user = this.userService.userByEmailEager(email);
            for (UserRole userRoles : user.getUserRoles()) {
                if (userRoles.getRoleName().equals("FeesAdmin")) {
                    feesadmin = true;
                }
                if (userRoles.getRoleName().equals("InventoryandAssetAdmin")) {
                    inventoryandassetadmin = true;
                }
                if (userRoles.getRoleName().equals("SuperAdministrator")) {
                    superadmin = true;
                }
                if (userRoles.getRoleName().equals("LibraryAdmin")) {
                    libraryadmin = true;
                }
                if (!userRoles.getRoleName().equals("VisitorAdmin")) continue;
                visitoradmin = true;
            }
            if (superadmin && institutionConfigDetails.isMultiInstitutions()) {
                modelandview.addObject("classes", this.classService.classList());
            } else if (visitoradmin && institutionConfigDetails.getVisitorAdminType() == 1) {
                modelandview.addObject("classes", this.classService.classList());
            } else if (libraryadmin && institutionConfigDetails.getLibraryAdminType() == 1) {
                modelandview.addObject("classes", this.classService.classList());
            } else if (inventoryandassetadmin && institutionConfigDetails.getInventoryAndAssetAdminType() == 1) {
                modelandview.addObject("classes", this.classService.classList());
            } else if (feesadmin && institutionConfigDetails.getFeeCollectionAdminType() == 1) {
                modelandview.addObject("classes", this.classService.classList());
            } else {
                modelandview.addObject("classes", this.classService.classList(institutionId));
            }
            modelandview.addObject("communicationMessageMode", this.communicationMessageModeService.communicationMessageModeList(email));
            modelandview.addObject("commnunicationTargetGroup", this.communicationTargetGroupService.communicationTargetGroupList(email));
            modelandview.addObject("staffTypes", this.staffTypeService.staffTypeList());
            modelandview.addObject("communicationSentNotifications", this.communicationNotificationService.communicationNotificationByEmailEager(email));
            modelandview.addObject("communicationSentMessages", this.communicationFeedBackAndOthersService.communicationFeedBackAndOthersByEmailEager(email));
            modelandview.addObject("communicationRepliedMessages", this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryByEmailEager(email));
            modelandview.addObject("user", (Object)this.userService.userByEmailEager(email));
            modelandview.addObject("receivedCommunicationNotifications", (Object)this.userService.userCommunicationNotificationByEmail(email));
            modelandview.addObject("receivedCommunicationFeedBackAndOthers", (Object)this.userService.userCommunicationFeedBackAndOthersByEmail(email));
            modelandview.addObject("repliedCommunicationFeedBackAndOthers", (Object)this.userService.userReceivedCommunicationFeedBackAndOthersByEmail(email));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            e.printStackTrace();
            throw null;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/usercommunicationnotification"})
    public String userRemoveCommunicationNotification(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to delete CommunicationNotification"));
            Long communicationNotificationId = Long.parseLong(request.getParameter("communicationNotificationId"));
            CommunicationNotification communicationNotification = this.communicationNotificationService.communicationNotificationByIdEager(communicationNotificationId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            LinkedHashSet<CommunicationNotification> addCommunicationNotifications = new LinkedHashSet<CommunicationNotification>();
            LinkedHashSet<PortalNotification> addPortalNotifications = new LinkedHashSet<PortalNotification>();
            for (User user1 : communicationNotification.getTargetUsers()) {
                if (user.getUserId() == user1.getUserId()) continue;
                addUsers.add(user1);
            }
            PortalNotification portalNotification = this.portalNotificationService.portalNotificationByIdEager(communicationNotification.getPortalNotification().getPortalNotificationId());
            portalNotification.setTargetUsers(addUsers);
            addPortalNotifications.add(portalNotification);
            communicationNotification.getPortalNotification().setTargetUsers(addUsers);
            communicationNotification.setTargetUsers(addUsers);
            addCommunicationNotifications.add(communicationNotification);
            user.setPortalNotifications(addPortalNotifications);
            user.setCommunicationNotifications(addCommunicationNotifications);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/usercommunicationmessage"})
    public String userRemoveCommunicationFeedBackAndOthers(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to delete CommunicationFeedBackAndOthers"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationMessageId"));
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersService.communicationFeedBackAndOthersByIdEager(communicationMessageId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            LinkedHashSet<CommunicationFeedBackAndOthers> addCommunicationFeedBackAndOthers = new LinkedHashSet<CommunicationFeedBackAndOthers>();
            LinkedHashSet<PortalMessage> addPortalMessages = new LinkedHashSet<PortalMessage>();
            for (User user1 : communicationFeedBackAndOthers.getTargetUsers()) {
                if (user.getUserId() == user1.getUserId()) continue;
                addUsers.add(user1);
            }
            PortalMessage portalMessage = this.portalMessageService.portalMessageByIdEager(communicationFeedBackAndOthers.getPortalMessage().getPortalMessageId());
            portalMessage.setTargetUsers(addUsers);
            addPortalMessages.add(portalMessage);
            communicationFeedBackAndOthers.getPortalMessage().setTargetUsers(addUsers);
            communicationFeedBackAndOthers.setTargetUsers(addUsers);
            addCommunicationFeedBackAndOthers.add(communicationFeedBackAndOthers);
            user.setPortalMessages(addPortalMessages);
            user.setCommunicationFeedBackAndOthers(addCommunicationFeedBackAndOthers);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userportalnotification"})
    public String userRemovePortalNotification(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change PortalNotification"));
            Long portalNotificationId = Long.parseLong(request.getParameter("portalNotificationId"));
            PortalNotification portalNotification = this.portalNotificationService.portalNotificationByIdEager(portalNotificationId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            LinkedHashSet<PortalNotification> addPortalNotifications = new LinkedHashSet<PortalNotification>();
            for (User checkuser : portalNotification.getTargetUsers()) {
                if (user.getUserId() == checkuser.getUserId()) continue;
                addUsers.add(checkuser);
            }
            portalNotification.setTargetUsers(addUsers);
            addPortalNotifications.add(portalNotification);
            user.setPortalNotifications(addPortalNotifications);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userallportalnotification"})
    public String userRemoveAllPortalNotification(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change AllPortalNotification"));
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<PortalNotification> addPortalNotifications = new LinkedHashSet<PortalNotification>();
            for (PortalNotification portalNotification : user.getPortalNotifications()) {
                LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
                PortalNotification checkPortalNotification = this.portalNotificationService.portalNotificationByIdEager(portalNotification.getPortalNotificationId());
                for (User checkuser : checkPortalNotification.getTargetUsers()) {
                    if (user.getUserId() == checkuser.getUserId()) continue;
                    addUsers.add(checkuser);
                }
                checkPortalNotification.setTargetUsers(addUsers);
                addPortalNotifications.add(checkPortalNotification);
            }
            user.setPortalNotifications(addPortalNotifications);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userportaltask"})
    public String userRemovePortalTask(HttpServletRequest request) {
        String redirectPath = "/";
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change PortalTask"));
            Long portalTaskId = Long.parseLong(request.getParameter("portalTaskId"));
            PortalTask portalTask = this.portalTaskService.portalTaskByIdEager(portalTaskId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            LinkedHashSet<PortalTask> addPortalTasks = new LinkedHashSet<PortalTask>();
            for (User checkuser : portalTask.getTargetUsers()) {
                if (user.getUserId() == checkuser.getUserId()) continue;
                addUsers.add(checkuser);
            }
            redirectPath = portalTask.getPortalTaskLink();
            portalTask.setTargetUsers(addUsers);
            addPortalTasks.add(portalTask);
            user.setPortalTasks(addPortalTasks);
            this.userService.updateUser(user);
            return "redirect:" + redirectPath;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:" + redirectPath;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userreplymessage"})
    public String userRemoveReplyMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change ReplyMessage"));
            Long replyMessageId = Long.parseLong(request.getParameter("replyMessageId"));
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryById(replyMessageId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            PortalReplyMessage portalReplyMessage = this.portalReplyMessageService.portalReplyMessageByIdEager(communicationFeedBackAndOthersHistory.getPortalReplyMessage().getportalReplyMessageId());
            portalReplyMessage.setTargetUsers(null);
            LinkedHashSet<PortalReplyMessage> addPortalReplyMessages = new LinkedHashSet<PortalReplyMessage>();
            addPortalReplyMessages.add(portalReplyMessage);
            user.setPortalReplyMessages(addPortalReplyMessages);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userallreplymessage"})
    public String userRemoveAllReplyMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change AllReplyMessage"));
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<PortalReplyMessage> addPortalReplyMessages = new LinkedHashSet<PortalReplyMessage>();
            LinkedHashSet<CommunicationFeedBackAndOthersHistory> addCommunicationFeedBackAndOthersHistorys = new LinkedHashSet<CommunicationFeedBackAndOthersHistory>();
            for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : user.getCommunicationFeedBackAndOthersHistory()) {
                CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryObj = this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryById(communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistoryId());
                PortalReplyMessage portalReplyMessage = this.portalReplyMessageService.portalReplyMessageByIdEager(communicationFeedBackAndOthersHistoryObj.getPortalReplyMessage().getportalReplyMessageId());
                portalReplyMessage.setTargetUsers(null);
                addPortalReplyMessages.add(portalReplyMessage);
                addCommunicationFeedBackAndOthersHistorys.add(communicationFeedBackAndOthersHistoryObj);
            }
            user.setPortalReplyMessages(addPortalReplyMessages);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userportalmessage"})
    public String userRemovePortalMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change PortalMessage"));
            Long portalMessageId = Long.parseLong(request.getParameter("portalMessageId"));
            PortalMessage portalMessage = this.portalMessageService.portalMessageByIdEager(portalMessageId);
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            LinkedHashSet<PortalMessage> addPortalMessages = new LinkedHashSet<PortalMessage>();
            for (User checkuser : portalMessage.getTargetUsers()) {
                if (user.getUserId() == checkuser.getUserId()) continue;
                addUsers.add(checkuser);
            }
            portalMessage.setTargetUsers(addUsers);
            addPortalMessages.add(portalMessage);
            user.setPortalMessages(addPortalMessages);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/userallportalmessage"})
    public String userRemoveAllPortalMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change AllPortalMessage"));
            String userEmail = request.getSession().getAttribute("username").toString();
            User user = this.userService.userByEmailEager(userEmail);
            LinkedHashSet<PortalMessage> addPortalMessages = new LinkedHashSet<PortalMessage>();
            for (PortalMessage portalMessage : user.getPortalMessages()) {
                LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
                PortalMessage checkPortalMessage = this.portalMessageService.portalMessageByIdEager(portalMessage.getPortalMessageId());
                for (User checkuser : checkPortalMessage.getTargetUsers()) {
                    if (user.getUserId() == checkuser.getUserId()) continue;
                    addUsers.add(checkuser);
                }
                checkPortalMessage.setTargetUsers(addUsers);
                addPortalMessages.add(checkPortalMessage);
            }
            user.setPortalMessages(addPortalMessages);
            this.userService.updateUser(user);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deletesentnotification"})
    public String deleteSentCommunicationNotification(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change CommunicationNotification"));
            Long communicationNotificationId = Long.parseLong(request.getParameter("communicationNotificationId"));
            CommunicationNotification communicationNotification = this.communicationNotificationService.communicationNotificationById(communicationNotificationId);
            communicationNotification.setStatus(0);
            this.communicationNotificationService.updateCommunicationNotification(communicationNotification);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deletesentmessage"})
    public String deleteSentCommunicationMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change CommunicationFeedBackAndOthers"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationMessageId"));
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersService.communicationFeedBackAndOthersById(communicationMessageId);
            communicationFeedBackAndOthers.setStatus(0);
            this.communicationFeedBackAndOthersService.updateCommunicationFeedBackAndOthers(communicationFeedBackAndOthers);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deleterepliedmessage"})
    public String deleteRepliedCommunicationMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change CommunicationFeedBackAndOthersHistory"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationRepliedMessageId"));
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryById(communicationMessageId);
            communicationFeedBackAndOthersHistory.setStatus(2);
            this.communicationFeedBackAndOthersHistoryService.updateCommunicationFeedBackAndOthersHistory(communicationFeedBackAndOthersHistory);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/deletesentreplymessage"})
    public String deleteSentRepliedCommunicationMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to change CommunicationFeedBackAndOthersHistory"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationRepliedMessageId"));
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryById(communicationMessageId);
            communicationFeedBackAndOthersHistory.setStatus(0);
            this.communicationFeedBackAndOthersHistoryService.updateCommunicationFeedBackAndOthersHistory(communicationFeedBackAndOthersHistory);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/repliedmessage"})
    public String repliedCommunicationMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create CommunicationFeedBackAndOthersHistory"));
            String createdBy = request.getSession().getAttribute("username").toString();
            Integer status = 1;
            String message = request.getParameter("replyMessages");
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationRepliedMessageId"));
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryService.communicationFeedBackAndOthersHistoryByIdEager(communicationMessageId);
            User targetUser = this.userService.userByEmail(communicationFeedBackAndOthersHistory.getCreatedBy());
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryObj = new CommunicationFeedBackAndOthersHistory(communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistorySubject(), message, createdBy, status, targetUser, communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
            this.communicationFeedBackAndOthersHistoryService.createCommunicationFeedBackAndOthersHistory(communicationFeedBackAndOthersHistoryObj, communicationFeedBackAndOthersHistory.getPortalReplyMessage().getInstitution());
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/replycommunicationmessage"})
    public String replyCommunicationMessage(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reply CommunicationMessage"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationMessageId"));
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersService.communicationFeedBackAndOthersByIdEager(communicationMessageId);
            String createdBy = request.getSession().getAttribute("username").toString();
            Integer status = 1;
            User targetUser = this.userService.userByEmail(communicationFeedBackAndOthers.getCreatedBy());
            String message = request.getParameter("replyMessage");
            String communicationSubject = communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersSubject();
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = new CommunicationFeedBackAndOthersHistory(communicationSubject, message, createdBy, status, targetUser, communicationFeedBackAndOthers);
            this.communicationFeedBackAndOthersHistoryService.createCommunicationFeedBackAndOthersHistory(communicationFeedBackAndOthersHistory, communicationFeedBackAndOthers.getInstitution());
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/sentnotificationmovetoarchive"})
    public String moveSentCommunicationNotificationArchive(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying CommunicationNotification move to CommunicationNotificationArchive"));
            Long communicationNotificationId = Long.parseLong(request.getParameter("communicationNotificationId"));
            CommunicationNotification communicationNotification = this.communicationNotificationService.communicationNotificationByIdEager(communicationNotificationId);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            for (User user : communicationNotification.getTargetUsers()) {
                addUsers.add(this.userService.userById(user.getUserId()));
            }
            CommunicationNotificationArchive communicationNotificationArchive = new CommunicationNotificationArchive(communicationNotification.getCommunicationNotificationSubject(), communicationNotification.getCommunicationNotificationMessage(), communicationNotification.getCreatedBy(), communicationNotification.getStatus(), communicationNotification.getCommunicationTargetGroup(), communicationNotification.getCommunicationMessageMode(), addUsers, communicationNotification.getInstitution());
            this.communicationNotificationArchiveService.createCommunicationNotificationArchive(communicationNotification, communicationNotificationArchive);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/sentmessagemovetoarchive"})
    public String moveSentCommunicationMessageArchive(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying CommunicationNotification move to CommunicationNotificationArchive"));
            Long communicationMessageId = Long.parseLong(request.getParameter("communicationMessageId"));
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersService.communicationFeedBackAndOthersByIdEager(communicationMessageId);
            LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
            for (User user : communicationFeedBackAndOthers.getTargetUsers()) {
                addUsers.add(this.userService.userById(user.getUserId()));
            }
            CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive = new CommunicationFeedBackAndOthersArchive(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersSubject(), communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersMessage(), communicationFeedBackAndOthers.getCreatedBy(), communicationFeedBackAndOthers.getStatus(), communicationFeedBackAndOthers.getCommunicationTargetGroup(), communicationFeedBackAndOthers.getCommunicationMessageMode(), addUsers, communicationFeedBackAndOthers.getInstitution());
            this.communicationFeedBackAndOthersArchiveService.createCommunicationFeedBackAndOthersArchive(communicationFeedBackAndOthers, communicationFeedBackAndOthersArchive);
            return "redirect:/communication";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/communication";
        }
    }

    /*
     * WARNING - void declaration
     */
    @RequestMapping(method={RequestMethod.POST}, value={"/newcommunication"})
    public String createCommunication(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            CommunicationMessageMode communicationMessageMode;
            Long messageModeId;
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create new Communication"));
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            String email = request.getSession().getAttribute("username").toString();
            String createdBy = request.getSession().getAttribute("username").toString();
            Integer status = 1;
            String messageCategory = request.getParameter("messageModeId");
            boolean checkMultiInstitution = false;
            boolean feesadmin = false;
            boolean inventoryandassetadmin = false;
            boolean superadmin = false;
            boolean libraryadmin = false;
            boolean visitoradmin = false;
            InstitutionConfigDetails institutionConfigDetails = this.institutionConfigDetailsService.institutionConfigDetailsById(Long.parseLong(request.getSession().getAttribute("institutionConfigDetailsId").toString()));
            User institutionUser = this.userService.userByEmailEager(email);
            for (UserRole userRoles : institutionUser.getUserRoles()) {
                if (userRoles.getRoleName().equals("FeesAdmin")) {
                    feesadmin = true;
                }
                if (userRoles.getRoleName().equals("InventoryandAssetAdmin")) {
                    inventoryandassetadmin = true;
                }
                if (userRoles.getRoleName().equals("SuperAdministrator")) {
                    superadmin = true;
                }
                if (userRoles.getRoleName().equals("LibraryAdmin")) {
                    libraryadmin = true;
                }
                if (!userRoles.getRoleName().equals("VisitorAdmin")) continue;
                visitoradmin = true;
            }
            if (superadmin && institutionConfigDetails.isMultiInstitutions()) {
                checkMultiInstitution = true;
            } else if (visitoradmin && institutionConfigDetails.getVisitorAdminType() == 1) {
                checkMultiInstitution = true;
            } else if (libraryadmin && institutionConfigDetails.getLibraryAdminType() == 1) {
                checkMultiInstitution = true;
            } else if (inventoryandassetadmin && institutionConfigDetails.getInventoryAndAssetAdminType() == 1) {
                checkMultiInstitution = true;
            } else if (feesadmin && institutionConfigDetails.getFeeCollectionAdminType() == 1) {
                checkMultiInstitution = true;
            }
            if (messageCategory.equals("portal")) {
                messageModeId = Long.parseLong(request.getParameter("messageTypeId"));
                communicationMessageMode = null;
                if (request.getParameter("messageModeId") != null) {
                    communicationMessageMode = this.communicationMessageModeService.communicationMessageModeById(messageModeId);
                }
                String communicationSubject = request.getParameter("communicationSubject");
                String communicationMessage = request.getParameter("message");
                Long targetGroupId = Long.parseLong(request.getParameter("communicationTargetGroupId"));
                CommunicationTargetGroup communicationTargetGroup = null;
                if (request.getParameter("communicationTargetGroupId") != null) {
                    communicationTargetGroup = this.communicationTargetGroupService.communicationTargetGroupById(targetGroupId);
                }
                LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
                if (communicationMessageMode.getCommunicationMessageModeId() == 1L && communicationMessageMode.getCommunicationMessageModeId() != null) {
                    CommunicationNotification communicationNotification = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_72;
                        String[] targetUsers = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var26_72 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_72].toString())));
                            ++var26_72;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> staffs = new ArrayList();
                        staffs = checkMultiInstitution ? this.staffService.staffListEager() : this.staffService.staffListEager(institutionId);
                        for (Staff staff : staffs) {
                            if (email.equals(staff.getEmail())) continue;
                            addUsers.add(this.userService.userById(staff.getUser().getUserId()));
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> users = new ArrayList();
                        users = checkMultiInstitution ? this.userService.userList() : this.userService.userList(institutionId);
                        for (User user : users) {
                            if (email.equals(user.getEmail())) continue;
                            addUsers.add(user);
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_78;
                        String[] targetUsers = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var26_78 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_78].toString())));
                            ++var26_78;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_80;
                        String[] targetUsers = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var26_80 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_80].toString())));
                            ++var26_80;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationNotificationService.createCommunicationNotification(communicationNotification, "/communication");
                } else {
                    CommunicationFeedBackAndOthers communicationFeedBackAndOthers = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_82;
                        String[] targetUsers = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var26_82 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_82].toString())));
                            ++var26_82;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> staffs = new ArrayList();
                        staffs = checkMultiInstitution ? this.staffService.staffListEager() : this.staffService.staffListEager(institutionId);
                        for (Staff staff : staffs) {
                            if (email.equals(staff.getEmail())) continue;
                            addUsers.add(this.userService.userById(staff.getUser().getUserId()));
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> users = new ArrayList();
                        users = checkMultiInstitution ? this.userService.userList() : this.userService.userList(institutionId);
                        for (User user : users) {
                            if (email.equals(user.getEmail())) continue;
                            addUsers.add(user);
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentList() : this.studentService.studentList(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_88;
                        String[] targetUsers = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var26_88 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_88].toString())));
                            ++var26_88;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_90;
                        String[] targetUsers = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var26_90 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_90].toString())));
                            ++var26_90;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationFeedBackAndOthersService.createCommunicationFeedBackAndOthers(communicationFeedBackAndOthers, "/communication");
                }
            } else if (messageCategory.equals("email")) {
                messageModeId = Long.parseLong(request.getParameter("messageTypeId"));
                communicationMessageMode = null;
                if (request.getParameter("messageModeId") != null) {
                    communicationMessageMode = this.communicationMessageModeService.communicationMessageModeById(messageModeId);
                }
                String communicationSubject = request.getParameter("communicationSubject");
                String communicationMessage = request.getParameter("message");
                Long targetGroupId = Long.parseLong(request.getParameter("communicationTargetGroupId"));
                CommunicationTargetGroup communicationTargetGroup = null;
                if (request.getParameter("communicationTargetGroupId") != null) {
                    communicationTargetGroup = this.communicationTargetGroupService.communicationTargetGroupById(targetGroupId);
                }
                LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
                if (communicationMessageMode.getCommunicationMessageModeId() == 1L && communicationMessageMode.getCommunicationMessageModeId() != null) {
                    CommunicationNotification communicationNotification = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_92;
                        String[] targetUsers = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var26_92 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_92].toString())));
                            ++var26_92;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> staffs = new ArrayList();
                        staffs = checkMultiInstitution ? this.staffService.staffListEager() : this.staffService.staffListEager(institutionId);
                        for (Staff staff : staffs) {
                            if (email.equals(staff.getEmail())) continue;
                            addUsers.add(this.userService.userById(staff.getUser().getUserId()));
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        ArrayList users = new ArrayList();
                        if (checkMultiInstitution) {
                            this.userService.userList();
                        } else {
                            this.userService.userList(institutionId);
                        }
                        for (User user : users) {
                            if (email.equals(user.getEmail())) continue;
                            addUsers.add(user);
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentList() : this.studentService.studentList(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_98;
                        String[] targetUsers = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var26_98 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_98].toString())));
                            ++var26_98;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_100;
                        String[] targetUsers = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var26_100 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_100].toString())));
                            ++var26_100;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationNotificationService.sentEmailCommunicationNotification(communicationNotification);
                } else {
                    CommunicationFeedBackAndOthers communicationFeedBackAndOthers = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_102;
                        String[] targetUsers = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var26_102 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_102].toString())));
                            ++var26_102;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> staffs = new ArrayList();
                        staffs = checkMultiInstitution ? this.staffService.staffListEager() : this.staffService.staffListEager(institutionId);
                        for (Staff staff : staffs) {
                            if (email.equals(staff.getEmail())) continue;
                            addUsers.add(this.userService.userById(staff.getUser().getUserId()));
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> users = new ArrayList();
                        users = checkMultiInstitution ? this.userService.userList() : this.userService.userList(institutionId);
                        for (User user : users) {
                            if (email.equals(user.getEmail())) continue;
                            addUsers.add(user);
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentListEager() : this.studentService.studentListEager(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        List<Object> students = new ArrayList();
                        students = checkMultiInstitution ? this.studentService.studentList() : this.studentService.studentList(institutionId);
                        for (Student student : students) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_108;
                        String[] targetUsers = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var26_108 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_108].toString())));
                            ++var26_108;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_110;
                        String[] targetUsers = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var26_110 < targetUsers.length) {
                            addUsers.add(this.userService.userById(Long.parseLong(targetUsers[var26_110].toString())));
                            ++var26_110;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationFeedBackAndOthersService.sentEmailCommunicationFeedBackAndOthers(communicationFeedBackAndOthers);
                }
            } else if (messageCategory.equals("sms")) {
                messageModeId = Long.parseLong(request.getParameter("messageTypeId"));
                communicationMessageMode = null;
                LinkedHashSet<String> userMobileNumbers = new LinkedHashSet<String>();
                if (request.getParameter("messageModeId") != null) {
                    communicationMessageMode = this.communicationMessageModeService.communicationMessageModeById(messageModeId);
                }
                String communicationSubject = request.getParameter("communicationSubject");
                String communicationMessage = request.getParameter("message");
                Long targetGroupId = Long.parseLong(request.getParameter("communicationTargetGroupId"));
                CommunicationTargetGroup communicationTargetGroup = null;
                if (request.getParameter("communicationTargetGroupId") != null) {
                    communicationTargetGroup = this.communicationTargetGroupService.communicationTargetGroupById(targetGroupId);
                }
                LinkedHashSet<User> addUsers = new LinkedHashSet<User>();
                if (communicationMessageMode.getCommunicationMessageModeId() == 1L && communicationMessageMode.getCommunicationMessageModeId() != null) {
                    CommunicationNotification communicationNotification = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_166;
                        String[] stringArray = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var27_166 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_166].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStaff().getContact());
                            ++var27_166;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_115;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Staff> list = this.staffService.staffListEager();
                        } else {
                            List<Staff> list = this.staffService.staffListEager(institutionId);
                        }
                        for (Staff staff : var26_115) {
                            if (email.equals(staff.getEmail())) continue;
                            User user = this.userService.userByIdEager(staff.getUser().getUserId());
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStaff().getContact());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_119;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<User> list = this.userService.userList();
                        } else {
                            List<User> list = this.userService.userList(institutionId);
                        }
                        for (User user : var26_119) {
                            if (email.equals(user.getEmail())) continue;
                            User user1 = this.userService.userByIdEager(user.getUserId());
                            addUsers.add(user1);
                            if (user1.getStaff() != null) {
                                userMobileNumbers.add(user1.getStaff().getContact());
                                continue;
                            }
                            if (user1.getStudent() != null) {
                                userMobileNumbers.add(user1.getStudent().getContact());
                                continue;
                            }
                            userMobileNumbers.add(user1.getStudent().getContact());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_123;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Student> list = this.studentService.studentListEager();
                        } else {
                            List<Student> list = this.studentService.studentListEager(institutionId);
                        }
                        for (Student student : var26_123) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                            userMobileNumbers.add(student.getParentContact());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_127;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Student> list = this.studentService.studentList();
                        } else {
                            List<Student> list = this.studentService.studentList(institutionId);
                        }
                        for (Student student : var26_127) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                            userMobileNumbers.add(student.getContact());
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_172;
                        String[] stringArray = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var27_172 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_172].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStudent().getParentContact());
                            ++var27_172;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_174;
                        String[] stringArray = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var27_174 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_174].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStudent().getContact());
                            ++var27_174;
                        }
                        communicationNotification = new CommunicationNotification(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationNotificationService.sentSMSCommunicationNotification(communicationNotification, userMobileNumbers);
                } else {
                    CommunicationFeedBackAndOthers communicationFeedBackAndOthers = null;
                    if (communicationTargetGroup.getCommunicationTargetGroupId() == 6L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_176;
                        String[] stringArray = request.getParameterValues("targetUserId");
                        boolean bl = false;
                        while (var27_176 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_176].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStaff().getContact());
                            ++var27_176;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 2L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_134;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Staff> list = this.staffService.staffListEager();
                        } else {
                            List<Staff> list = this.staffService.staffListEager(institutionId);
                        }
                        for (Staff staff : var26_134) {
                            if (email.equals(staff.getEmail())) continue;
                            User user = this.userService.userByIdEager(staff.getUser().getUserId());
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStaff().getContact());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L && communicationTargetGroup.getCommunicationTargetGroupId() != null || communicationTargetGroup.getCommunicationTargetGroupId() == 8L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_138;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<User> list = this.userService.userList();
                        } else {
                            List<User> list = this.userService.userList(institutionId);
                        }
                        for (User user : var26_138) {
                            if (email.equals(user.getEmail())) continue;
                            User user1 = this.userService.userByIdEager(user.getUserId());
                            addUsers.add(user1);
                            if (user1.getStaff() != null) {
                                userMobileNumbers.add(user1.getStaff().getContact());
                                continue;
                            }
                            if (user1.getStudent() != null) {
                                userMobileNumbers.add(user1.getStudent().getContact());
                                continue;
                            }
                            userMobileNumbers.add(user1.getStudent().getContact());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_142;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Student> list = this.studentService.studentListEager();
                        } else {
                            List<Student> list = this.studentService.studentListEager(institutionId);
                        }
                        for (Student student : var26_142) {
                            if (email.equals(student.getParentUser().getEmail())) continue;
                            addUsers.add(student.getParentUser());
                            userMobileNumbers.add(student.getParentContact());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 3L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var26_146;
                        ArrayList arrayList = new ArrayList();
                        if (checkMultiInstitution) {
                            List<Student> list = this.studentService.studentList();
                        } else {
                            List<Student> list = this.studentService.studentList(institutionId);
                        }
                        for (Student student : var26_146) {
                            if (email.equals(student.getEmail())) continue;
                            addUsers.add(student.getUser());
                            userMobileNumbers.add(student.getContact());
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 5L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_182;
                        String[] stringArray = request.getParameterValues("targetParentId");
                        boolean bl = false;
                        while (var27_182 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_182].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStudent().getParentContact());
                            ++var27_182;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    } else if (communicationTargetGroup.getCommunicationTargetGroupId() == 7L && communicationTargetGroup.getCommunicationTargetGroupId() != null) {
                        void var27_184;
                        String[] stringArray = request.getParameterValues("targetStudentId");
                        boolean bl = false;
                        while (var27_184 < stringArray.length) {
                            User user = this.userService.userByIdEager(Long.parseLong(stringArray[var27_184].toString()));
                            addUsers.add(user);
                            userMobileNumbers.add(user.getStudent().getContact());
                            ++var27_184;
                        }
                        communicationFeedBackAndOthers = new CommunicationFeedBackAndOthers(communicationSubject, communicationMessage, createdBy, status, communicationTargetGroup, communicationMessageMode, addUsers, institution);
                    }
                    this.communicationFeedBackAndOthersService.sentSMSCommunicationFeedBackAndOthers(communicationFeedBackAndOthers, userMobileNumbers);
                }
            }
            return "redirect:/communication";
        }
        catch (Exception e) {
            if (e.getClass().equals(CommunicationException.class)) {
                CommunicationException ex = (CommunicationException)e;
                redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", ex.getMessage()));
                return "redirect:/communication";
            }
            e.printStackTrace();
            return "redirect:/communication";
        }
    }
}
