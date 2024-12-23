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
import in.jdsoft.educationmanagement.school.components.SMSHandler;
import in.jdsoft.educationmanagement.school.dao.CommunicationNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.CommunicationException;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CommunicationNotificationService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

@Service(value=" CommunicationNotificationService")
public class CommunicationNotificationServiceImpl
implements CommunicationNotificationService {
    @Autowired
    private CommunicationNotificationDAO communicationNotificationDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private PortalNotificationDAO portalNotificationDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private SMSHandler smsHandler;

    @Override
    public void createCommunicationNotification(CommunicationNotification communicationNotification, String communicationLink) {
        try {
            PortalNotification portalNotification = new PortalNotification(communicationNotification.getCommunicationNotificationSubject(), communicationNotification.getCommunicationNotificationMessage(), communicationNotification.getTargetUsers(), communicationNotification.getStatus(), communicationLink, communicationNotification.getCreatedBy(), communicationNotification.getInstitution());
            PortalNotification persistedPortalNotification = this.portalNotificationDAO.save(portalNotification);
            communicationNotification.setPortalNotification(persistedPortalNotification);
            CommunicationNotification persistedCommunicationNotification = this.communicationNotificationDAO.save(communicationNotification);
            Long communicationNotificationId = persistedCommunicationNotification.getCommunicationNotificationId();
            log.info((Object)(" CommunicationNotification is created with the id=" + communicationNotificationId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  CommunicationNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sentEmailCommunicationNotification(CommunicationNotification communicationNotification) throws Exception {
        try {
            String[] userMailIds = new String[communicationNotification.getTargetUsers().size()];
            int i = 0;
            for (User user : communicationNotification.getTargetUsers()) {
                userMailIds[i] = user.getEmail();
                ++i;
            }
            this.emailHandler.sendEmail(userMailIds, communicationNotification.getCommunicationNotificationSubject(), communicationNotification.getCommunicationNotificationMessage());
            log.info((Object)"Email CommunicationNotification Sent Successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new CommunicationException(new Message("failure", "No Internet Connnetion Found..! Please Check The Connection..!"));
            }
            throw e;
        }
    }

    @Override
    public void sentSMSCommunicationNotification(CommunicationNotification communicationNotification, Set<String> userMobileNumbers) throws Exception {
        try {
            String currentUserMobile = "";
            for (String mobileNumber : userMobileNumbers) {
                currentUserMobile = String.valueOf(currentUserMobile) + "91" + mobileNumber + ",";
            }
            currentUserMobile = currentUserMobile.trim();
            currentUserMobile = currentUserMobile.substring(0, currentUserMobile.length() - 1);
            String message = communicationNotification.getCommunicationNotificationMessage();
            this.smsHandler.sentSMS(currentUserMobile, message, communicationNotification.getInstitution().getInstitutionId());
            log.info((Object)"SMS CommunicationNotification Sent Successfully");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating SMS CommunicationNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteCommunicationNotification(Long communicationNotificationId) {
        try {
            CommunicationNotification communicationNotification = this.communicationNotificationDAO.getCommunicationNotificationById(communicationNotificationId);
            if (communicationNotification != null) {
                this.communicationNotificationDAO.delete(communicationNotification);
                log.info((Object)(" CommunicationNotification with id=" + communicationNotificationId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  CommunicationNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationList() {
        try {
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getList();
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationNotification records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationNotification communicationNotificationById(Long communicationNotificationId) {
        try {
            CommunicationNotification communicationNotification = this.communicationNotificationDAO.getCommunicationNotificationById(communicationNotificationId);
            if (communicationNotification != null) {
                log.info((Object)(" CommunicationNotification with id=" + communicationNotificationId + " has been reterived"));
                return communicationNotification;
            }
            log.info((Object)("No  CommunicationNotification with  id=" + communicationNotificationId + " is available"));
            return communicationNotification;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationNotification by id=" + communicationNotificationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCommunicationNotification(CommunicationNotification communicationNotification) {
        try {
            this.communicationNotificationDAO.saveOrUpdate(communicationNotification);
            Long communicationNotificationId = communicationNotification.getCommunicationNotificationId();
            if (communicationNotificationId != null) {
                log.info((Object)(" CommunicationNotification with id=" + communicationNotificationId + " has been updated"));
            } else {
                log.info((Object)"New  CommunicationNotification has been added, because no  CommunicationNotification found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  CommunicationNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getCommunicationNotificationsByUser(user);
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                for (CommunicationNotification communicationNotification : communicationNotificationList) {
                    Hibernate.initialize((Object)communicationNotification.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotification.getTargetUsers());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationNotificationArchive());
                    Hibernate.initialize((Object)communicationNotification.getPortalNotification());
                    Hibernate.initialize(communicationNotification.getPortalNotification().getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotification records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationByEmailEager(String email) {
        try {
            Integer status = 1;
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getCommunicationNotificationsByEmailAndStatus(email, status);
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                for (CommunicationNotification communicationNotification : communicationNotificationList) {
                    Hibernate.initialize((Object)communicationNotification.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotification.getTargetUsers());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationNotificationArchive());
                    Hibernate.initialize((Object)communicationNotification.getPortalNotification());
                    Hibernate.initialize(communicationNotification.getPortalNotification().getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotification records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationNotification communicationNotificationByIdEager(Long communicationNotificationId) {
        try {
            CommunicationNotification communicationNotification = this.communicationNotificationDAO.getCommunicationNotificationById(communicationNotificationId);
            if (communicationNotification != null) {
                Hibernate.initialize((Object)communicationNotification.getCommunicationMessageMode());
                Hibernate.initialize((Object)communicationNotification.getCommunicationTargetGroup());
                Hibernate.initialize(communicationNotification.getTargetUsers());
                Hibernate.initialize((Object)communicationNotification.getCommunicationNotificationArchive());
                Hibernate.initialize((Object)communicationNotification.getPortalNotification());
                Hibernate.initialize(communicationNotification.getPortalNotification().getTargetUsers());
                log.info((Object)(" CommunicationNotification with id=" + communicationNotificationId + " has been reterived"));
                return communicationNotification;
            }
            log.info((Object)("No  CommunicationNotification with  id=" + communicationNotificationId + " is available"));
            return communicationNotification;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationNotification by id=" + communicationNotificationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationListEager() {
        try {
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getList();
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                for (CommunicationNotification communicationNotification : communicationNotificationList) {
                    Hibernate.initialize((Object)communicationNotification.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotification.getTargetUsers());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationNotificationArchive());
                    Hibernate.initialize((Object)communicationNotification.getPortalNotification());
                    Hibernate.initialize(communicationNotification.getPortalNotification().getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotification records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getCommunicationNotificationsByInstituion(institution);
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationNotification records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotification> communicationNotificationListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<CommunicationNotification> communicationNotificationList = this.communicationNotificationDAO.getCommunicationNotificationsByInstituion(institution);
            Integer listSize = communicationNotificationList.size();
            if (listSize > 0) {
                for (CommunicationNotification communicationNotification : communicationNotificationList) {
                    Hibernate.initialize((Object)communicationNotification.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotification.getTargetUsers());
                    Hibernate.initialize((Object)communicationNotification.getCommunicationNotificationArchive());
                    Hibernate.initialize((Object)communicationNotification.getPortalNotification());
                    Hibernate.initialize(communicationNotification.getPortalNotification().getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotification records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  CommunicationNotification(s) available");
            }
            return communicationNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
