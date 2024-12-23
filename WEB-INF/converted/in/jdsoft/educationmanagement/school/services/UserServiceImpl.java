/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.mail.MailSendException
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersDAO;
import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersHistoryDAO;
import in.jdsoft.educationmanagement.school.dao.CommunicationNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalMessageDAO;
import in.jdsoft.educationmanagement.school.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.PortalReplyMessageDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.dao.UserRoleDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffException;
import in.jdsoft.educationmanagement.school.exceptions.UserException;
import in.jdsoft.educationmanagement.school.exceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

@Service(value="userService")
public class UserServiceImpl
implements UserService {
    @Autowired
    UserDAO userDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    CommunicationNotificationDAO communicationNotificationDAO;
    @Autowired
    PortalNotificationDAO portalNotificationDAO;
    @Autowired
    PortalMessageDAO portalMessageDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    CommunicationFeedBackAndOthersDAO communicationFeedBackAndOthersDAO;
    @Autowired
    CommunicationFeedBackAndOthersHistoryDAO communicationFeedBackAndOthersHistoryDAO;
    @Autowired
    PortalReplyMessageDAO portalReplyMessageDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private UserRoleDAO userRoleDAO;

    @Override
    public User userByEmailEager(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            if (user != null) {
                Hibernate.initialize(user.getUserRoles());
                Hibernate.initialize((Object)user.getStaff());
                Hibernate.initialize((Object)user.getStudent());
                Hibernate.initialize(user.getApproverTo());
                Hibernate.initialize((Object)user.getInstitution());
                Hibernate.initialize(user.getCommunicationNotifications());
                for (CommunicationNotification communicationNotification : user.getCommunicationNotifications()) {
                    Hibernate.initialize((Object)communicationNotification);
                }
                Hibernate.initialize(user.getCommunicationNotificationArchives());
                for (CommunicationNotificationArchive communicationNotificationArchive : user.getCommunicationNotificationArchives()) {
                    Hibernate.initialize((Object)communicationNotificationArchive);
                }
                Hibernate.initialize(user.getPortalNotifications());
                for (PortalNotification portalNotification : user.getPortalNotifications()) {
                    Hibernate.initialize((Object)portalNotification);
                }
                Hibernate.initialize(user.getPortalTasks());
                for (PortalTask portalTask : user.getPortalTasks()) {
                    Hibernate.initialize((Object)portalTask);
                }
                Hibernate.initialize(user.getPortalMessages());
                for (PortalMessage portalMessage : user.getPortalMessages()) {
                    Hibernate.initialize((Object)portalMessage);
                }
                Hibernate.initialize(user.getCommunicationFeedBackAndOthers());
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers);
                }
                Hibernate.initialize(user.getCommunicationFeedBackAndOthersHistory());
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : user.getCommunicationFeedBackAndOthersHistory()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                }
                Hibernate.initialize(user.getPortalReplyMessages());
                for (PortalReplyMessage portalReplyMessage : user.getPortalReplyMessages()) {
                    Hibernate.initialize((Object)portalReplyMessage);
                }
                log.info((Object)("user with email=" + email + " has been reterived with its child objects"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by email=" + email + " with its child objects"), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userByEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            if (user != null) {
                log.info((Object)("user with email=" + email + " has been reterived"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by email=" + email), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userWithRolesAndPrivileges(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            if (user != null) {
                Set<UserRole> roles = user.getUserRoles();
                for (UserRole role : roles) {
                    Hibernate.initialize(role.getPrivileges());
                }
                log.info((Object)("user with email=" + email + " has been reterived with roles and privileges"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user  with roles and privileges by email=" + email), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Long createUser(User user) {
        try {
            User persistedUser = this.userDAO.save(user);
            Long userId = persistedUser.getUserId();
            log.info((Object)("User created with the id=" + userId));
            return userId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating User", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUser(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            if (user != null) {
                this.userDAO.delete(user);
                log.info((Object)("User with id=" + userId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting User", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> userList() {
        try {
            List<User> userList = this.userDAO.getList();
            Integer userListSize = userList.size();
            if (userListSize > 0) {
                log.info((Object)(userListSize + " user  records where reterived"));
            } else {
                log.info((Object)"No user  list available");
            }
            return userList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving user list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> userList(Long institutionId) throws UserException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<User> users = this.userDAO.getUserByInstitution(institution);
                Integer usersSize = users.size();
                if (usersSize > 0) {
                    log.info((Object)(usersSize + " user  records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No user Records found for institution " + institution.getInstitutionAliasName()));
                }
                return users;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new UserException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving  user of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userById(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            if (user != null) {
                log.info((Object)("User  with id=" + userId + " has been reterived"));
                return user;
            }
            log.info((Object)("No User with  id=" + userId + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user  by id=" + userId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            for (CommunicationNotification communicationNotification : user.getCommunicationNotifications()) {
                CommunicationNotification communicationNotificationObj = this.communicationNotificationDAO.getCommunicationNotificationById(communicationNotification.getCommunicationNotificationId());
                communicationNotificationObj.setTargetUsers(communicationNotification.getTargetUsers());
                this.communicationNotificationDAO.update(communicationNotificationObj);
            }
            for (PortalNotification portalNotification : user.getPortalNotifications()) {
                PortalNotification portalNotificationObj = this.portalNotificationDAO.getPortalNotificationById(portalNotification.getPortalNotificationId());
                portalNotificationObj.setTargetUsers(portalNotification.getTargetUsers());
                this.portalNotificationDAO.update(portalNotificationObj);
            }
            for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                CommunicationFeedBackAndOthers communicationFeedBackAndOthersObj = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersById(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersId());
                communicationFeedBackAndOthersObj.setTargetUsers(communicationFeedBackAndOthers.getTargetUsers());
                this.communicationFeedBackAndOthersDAO.update(communicationFeedBackAndOthersObj);
            }
            for (PortalMessage portalMessage : user.getPortalMessages()) {
                PortalMessage portalMessageObj = this.portalMessageDAO.getPortalMessageById(portalMessage.getPortalMessageId());
                portalMessageObj.setTargetUsers(portalMessage.getTargetUsers());
                this.portalMessageDAO.update(portalMessageObj);
            }
            for (PortalReplyMessage portalReplyMessage : user.getPortalReplyMessages()) {
                PortalReplyMessage portalReplyMessageObj = this.portalReplyMessageDAO.getPortalReplyMessageById(portalReplyMessage.getportalReplyMessageId());
                portalReplyMessageObj.setTargetUsers(portalReplyMessage.getTargetUsers());
                this.portalReplyMessageDAO.update(portalReplyMessageObj);
            }
            for (PortalTask portalTask : user.getPortalTasks()) {
                PortalTask portalTaskObj = this.portalTaskDAO.getPortalTaskById(portalTask.getPortalTaskId());
                portalTaskObj.setTargetUsers(portalTask.getTargetUsers());
                this.portalTaskDAO.update(portalTaskObj);
            }
            this.userDAO.update(user);
            Long userId = user.getUserId();
            if (userId != null) {
                log.info((Object)("User with id=" + userId + " has been updated"));
            } else {
                log.info((Object)"New User  has been added, because no user  found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating user", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> allStaffApproversList(Long institutionId) {
        ArrayList<User> users = new ArrayList<User>();
        try {
            log.info((Object)"Reteriving Approvers List of Institution");
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<Staff> staffs = this.staffDAO.getStaffsByDefaultUser("default", institution);
            for (Staff staff : staffs) {
                Hibernate.initialize((Object)staff.getUser());
                users.add(staff.getUser());
            }
            return users;
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating user", e.getCause());
            e.printStackTrace();
            return users;
        }
    }

    @Override
    public List<User> allStaffApproversLists() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            log.info((Object)"Reteriving Approvers List of Institution");
            List staffs = this.staffDAO.getList();
            for (Staff staff : staffs) {
                Hibernate.initialize((Object)staff.getUser());
                users.add(staff.getUser());
            }
            return users;
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating user", e.getCause());
            e.printStackTrace();
            return users;
        }
    }

    @Override
    public User userByIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            if (user != null) {
                Hibernate.initialize(user.getUserRoles());
                Hibernate.initialize((Object)user.getStaff());
                Hibernate.initialize((Object)user.getStudent());
                Hibernate.initialize(user.getApproverTo());
                Hibernate.initialize((Object)user.getInstitution());
                Hibernate.initialize(user.getCommunicationNotifications());
                for (CommunicationNotification communicationNotification : user.getCommunicationNotifications()) {
                    Hibernate.initialize((Object)communicationNotification);
                }
                Hibernate.initialize(user.getPortalTasks());
                for (PortalTask portalTask : user.getPortalTasks()) {
                    Hibernate.initialize((Object)portalTask);
                }
                Hibernate.initialize(user.getCommunicationNotificationArchives());
                for (CommunicationNotificationArchive communicationNotificationArchive : user.getCommunicationNotificationArchives()) {
                    Hibernate.initialize((Object)communicationNotificationArchive);
                }
                Hibernate.initialize(user.getPortalNotifications());
                for (PortalNotification portalNotification : user.getPortalNotifications()) {
                    Hibernate.initialize((Object)portalNotification);
                }
                Hibernate.initialize(user.getCommunicationFeedBackAndOthers());
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers);
                }
                Hibernate.initialize(user.getPortalMessages());
                for (PortalMessage portalMessage : user.getPortalMessages()) {
                    Hibernate.initialize((Object)portalMessage);
                }
                Hibernate.initialize(user.getPortalReplyMessages());
                for (PortalReplyMessage portalReplyMessage : user.getPortalReplyMessages()) {
                    Hibernate.initialize((Object)portalReplyMessage);
                }
                log.info((Object)("user with id =" + userId + " has been reterived with its child objects"));
                return user;
            }
            log.info((Object)("No user with id =" + userId + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by id =" + userId + " with its child objects"), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userCommunicationNotificationByEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            LinkedHashSet<CommunicationNotification> addCommunicationNotifications = new LinkedHashSet<CommunicationNotification>();
            if (user != null) {
                Hibernate.initialize(user.getUserRoles());
                Hibernate.initialize((Object)user.getStaff());
                Hibernate.initialize((Object)user.getStudent());
                Hibernate.initialize(user.getApproverTo());
                Hibernate.initialize((Object)user.getInstitution());
                Hibernate.initialize(user.getCommunicationNotifications());
                for (CommunicationNotification communicationNotification : user.getCommunicationNotifications()) {
                    if (communicationNotification.getCommunicationMessageMode().getCommunicationMessageModeId() != 1L) continue;
                    Hibernate.initialize((Object)communicationNotification);
                    addCommunicationNotifications.add(communicationNotification);
                }
                Hibernate.initialize(user.getCommunicationNotificationArchives());
                for (CommunicationNotificationArchive communicationNotificationArchive : user.getCommunicationNotificationArchives()) {
                    Hibernate.initialize((Object)communicationNotificationArchive);
                }
                user.setCommunicationNotifications(addCommunicationNotifications);
                log.info((Object)("user with email=" + email + " has been reterived with its communicationNotifications"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by email=" + email + " with its communicationNotifications"), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userCommunicationFeedBackAndOthersByEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            LinkedHashSet<CommunicationFeedBackAndOthers> addCommunicationFeedBackAndOthers = new LinkedHashSet<CommunicationFeedBackAndOthers>();
            if (user != null) {
                Hibernate.initialize(user.getUserRoles());
                Hibernate.initialize((Object)user.getStaff());
                Hibernate.initialize((Object)user.getStudent());
                Hibernate.initialize(user.getApproverTo());
                Hibernate.initialize((Object)user.getInstitution());
                Hibernate.initialize(user.getCommunicationNotifications());
                Hibernate.initialize(user.getCommunicationFeedBackAndOthers());
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers);
                }
                Hibernate.initialize(user.getCommunicationFeedBackAndOthersHistory());
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : user.getCommunicationFeedBackAndOthersHistory()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                }
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers);
                    if (communicationFeedBackAndOthers.getCommunicationMessageMode().getCommunicationMessageModeId() == 1L) continue;
                    addCommunicationFeedBackAndOthers.add(communicationFeedBackAndOthers);
                }
                user.setCommunicationFeedBackAndOthers(addCommunicationFeedBackAndOthers);
                log.info((Object)("user with email=" + email + " has been reterived with its communicationFeedBackAndOthers"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by email=" + email + " with its communicationFeedBackAndOthers"), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User userReceivedCommunicationFeedBackAndOthersByEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            LinkedHashSet<CommunicationFeedBackAndOthersHistory> addCommunicationFeedBackAndOthersHistorys = new LinkedHashSet<CommunicationFeedBackAndOthersHistory>();
            if (user != null) {
                Hibernate.initialize(user.getUserRoles());
                Hibernate.initialize((Object)user.getStaff());
                Hibernate.initialize((Object)user.getStudent());
                Hibernate.initialize(user.getApproverTo());
                Hibernate.initialize((Object)user.getInstitution());
                Hibernate.initialize(user.getCommunicationNotifications());
                Hibernate.initialize(user.getCommunicationFeedBackAndOthers());
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : user.getCommunicationFeedBackAndOthers()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers);
                }
                Hibernate.initialize(user.getCommunicationFeedBackAndOthersHistory());
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : user.getCommunicationFeedBackAndOthersHistory()) {
                    if (communicationFeedBackAndOthersHistory.getStatus() == 2) continue;
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                    addCommunicationFeedBackAndOthersHistorys.add(communicationFeedBackAndOthersHistory);
                }
                user.setCommunicationFeedBackAndOthersHistory(addCommunicationFeedBackAndOthersHistorys);
                log.info((Object)("user with email=" + email + " has been reterived with its communicationFeedBackAndOthers"));
                return user;
            }
            log.info((Object)("No user with email=" + email + " is available"));
            return user;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user by email=" + email + " with its communicationFeedBackAndOthers"), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<User> staffLeaveApprovar(String staffEMail, Long institutionId) throws StaffException {
        LinkedHashSet<User> users = new LinkedHashSet<User>();
        try {
            User user = this.userDAO.getUserByEmail(staffEMail);
            log.info((Object)"Reteriving Approvers List of Institution");
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<Staff> staffs = this.staffDAO.getStaffsByStatusAndInstitution(1, institution);
            for (Staff staff : staffs) {
                if (user.getEmail().equals(staff.getEmail())) continue;
                Hibernate.initialize((Object)staff.getUser());
                users.add(staff.getUser());
            }
            return users;
        }
        catch (Exception e) {
            log.error((Object)"Exception in fetching user", e.getCause());
            e.printStackTrace();
            return users;
        }
    }

    @Override
    public Message emailAvailablityCheck(String usernameEmail) {
        try {
            User user = this.userDAO.getUserByEmail(usernameEmail);
            if (user != null) {
                return new Message("failed", "Email id is already taken !! use different e-mail id");
            }
            return new Message("success", "Email Id is Available");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void resetPasswordByEmail(String userEmail) throws UserServiceExceptions, Exception {
        try {
            if (!this.validateEmail(userEmail).booleanValue()) {
                throw new UserServiceExceptions(new Message("failed", "No Matching Account Found With This E-mail Id"));
            }
            User user = this.userDAO.getUserByEmail(userEmail);
            this.emailHandler.sendEmail(userEmail, "Password Reset", "Username: " + user.getEmail() + "\nPassword: " + user.getPassword());
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new UserServiceExceptions(new Message("failed", "No Internet Connnetion Found ! Please Check The Connection"));
            }
            throw e;
        }
    }

    @Override
    public Boolean validateEmail(String usernameEmail) {
        User user = this.userDAO.getUserByEmail(usernameEmail);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public Set<Admission> getUsersAdmissionApplication(String email) {
        User user = this.userDAO.getUserByEmail(email);
        Hibernate.initialize(user.getUserAdmission());
        Set<Admission> admissions = user.getUserAdmission();
        for (Admission admission : admissions) {
            Hibernate.initialize((Object)admission.getAdmissionStatus());
        }
        return admissions;
    }

    @Override
    public User studentLeaveApprover(String studentEmail, Long institutionId) throws UserServiceExceptions {
        try {
            log.info((Object)"Reteriving Approvers of Institution");
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            User user = this.userDAO.getUserByEmailAndInstitutionAndStatus(studentEmail, institution, 1);
            return user;
        }
        catch (Exception e) {
            log.error((Object)"Exception in fetching user", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User tcApprover(Long institutionId) {
        try {
            log.info((Object)"Reteriving Default Approver of Institution");
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            User user = this.userDAO.getUserByDefaultUserAndInstitutionAndStatus("default", institution, 1);
            return user;
        }
        catch (Exception e) {
            log.error((Object)"Exception in fetching user", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public User principalRoleApproverByInstitution(Long institutionId) throws UserServiceExceptions {
        try {
            log.info((Object)"Reteriving Meeting Approver of Institution");
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            UserRole userRole = this.userRoleDAO.getUserRoleByTargetTypeAndInstitution(institution, "principal");
            User user = this.userDAO.getUserByUserRoleAndInstitution(institution, userRole);
            return user;
        }
        catch (Exception e) {
            log.error((Object)"Exception in fetching user", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> inventoryRequest() throws UserServiceExceptions {
        try {
            LinkedList<User> users = new LinkedList<User>();
            List<UserRole> userRoles = this.userRoleDAO.getUserRoleByTargetType("inventoryandassetadmin");
            for (UserRole userRole : userRoles) {
                System.out.println(userRole.getRoleName());
                users.add((User)((Object)this.userDAO.getUserBy(userRole)));
            }
            return users;
        }
        catch (Exception e) {
            log.error((Object)"Exception in fetching user", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
