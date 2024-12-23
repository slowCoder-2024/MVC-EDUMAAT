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
import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersDAO;
import in.jdsoft.educationmanagement.school.dao.PortalMessageDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.CommunicationException;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersService;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

@Service(value=" CommunicationFeedBackAndOthersService")
public class CommunicationFeedBackAndOthersServiceImpl
implements CommunicationFeedBackAndOthersService {
    @Autowired
    private CommunicationFeedBackAndOthersDAO communicationFeedBackAndOthersDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private PortalMessageDAO portalMessageDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private SMSHandler smsHandler;

    @Override
    public void createCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers, String communicationLink) {
        try {
            PortalMessage portalMessage = new PortalMessage(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersSubject(), communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersMessage(), communicationFeedBackAndOthers.getTargetUsers(), communicationFeedBackAndOthers.getStatus(), communicationLink, communicationFeedBackAndOthers.getCreatedBy(), communicationFeedBackAndOthers.getInstitution());
            PortalMessage persistedPortalMessage = this.portalMessageDAO.save(portalMessage);
            communicationFeedBackAndOthers.setPortalMessage(persistedPortalMessage);
            CommunicationFeedBackAndOthers persistedCommunicationFeedBackAndOthers = this.communicationFeedBackAndOthersDAO.save(communicationFeedBackAndOthers);
            Long communicationFeedBackAndOthersId = persistedCommunicationFeedBackAndOthers.getCommunicationFeedBackAndOthersId();
            log.info((Object)(" CommunicationFeedBackAndOthers is created with the id=" + communicationFeedBackAndOthersId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  CommunicationFeedBackAndOthers", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void sentEmailCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers) throws Exception {
        try {
            String[] userMailIds = new String[communicationFeedBackAndOthers.getTargetUsers().size()];
            int i = 0;
            for (User user : communicationFeedBackAndOthers.getTargetUsers()) {
                userMailIds[i] = user.getEmail();
                ++i;
            }
            this.emailHandler.sendEmail(userMailIds, communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersSubject(), communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersMessage());
            log.info((Object)"Email CommunicationFeedBackAndOthers Sent Successfully");
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new CommunicationException(new Message("failure", "No Internet Connnetion Found..! Please Check The Connection..!"));
            }
            throw e;
        }
    }

    @Override
    public void sentSMSCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers, Set<String> userMobileNumbers) throws Exception {
        try {
            String currentUserMobile = "";
            for (String mobileNumber : userMobileNumbers) {
                currentUserMobile = String.valueOf(currentUserMobile) + "91" + mobileNumber + ",";
            }
            currentUserMobile = currentUserMobile.trim();
            currentUserMobile = currentUserMobile.substring(0, currentUserMobile.length() - 1);
            this.smsHandler.sentSMS(currentUserMobile, communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersMessage(), communicationFeedBackAndOthers.getInstitution().getInstitutionId());
            log.info((Object)"SMS CommunicationNotification Sent Successfully");
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating SMS CommunicationNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteCommunicationFeedBackAndOthers(Long communicationFeedBackAndOthersId) {
        try {
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersById(communicationFeedBackAndOthersId);
            if (communicationFeedBackAndOthers != null) {
                this.communicationFeedBackAndOthersDAO.delete(communicationFeedBackAndOthers);
                log.info((Object)(" CommunicationFeedBackAndOthers with id=" + communicationFeedBackAndOthersId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  CommunicationFeedBackAndOthers", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList() {
        try {
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getList();
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthers communicationFeedBackAndOthersById(Long communicationFeedBackAndOthersId) {
        try {
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersById(communicationFeedBackAndOthersId);
            if (communicationFeedBackAndOthers != null) {
                log.info((Object)(" CommunicationFeedBackAndOthers with id=" + communicationFeedBackAndOthersId + " has been reterived"));
                return communicationFeedBackAndOthers;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthers with  id=" + communicationFeedBackAndOthersId + " is available"));
            return communicationFeedBackAndOthers;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthers by id=" + communicationFeedBackAndOthersId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers communicationFeedBackAndOthers) {
        try {
            this.communicationFeedBackAndOthersDAO.saveOrUpdate(communicationFeedBackAndOthers);
            Long communicationFeedBackAndOthersId = communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersId();
            if (communicationFeedBackAndOthersId != null) {
                log.info((Object)(" CommunicationFeedBackAndOthers with id=" + communicationFeedBackAndOthersId + " has been updated"));
            } else {
                log.info((Object)"New  CommunicationFeedBackAndOthers has been added, because no  CommunicationFeedBackAndOthers found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  CommunicationFeedBackAndOthers", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersByUser(user);
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : communicationFeedBackAndOthersList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthers.getTargetUsers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getPortalMessage());
                    Hibernate.initialize(communicationFeedBackAndOthers.getPortalMessage().getTargetUsers());
                    Hibernate.initialize(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory());
                    for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()) {
                        Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    }
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersByEmailEager(String email) {
        try {
            Integer status = 1;
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersByEmailAndStatus(email, status);
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : communicationFeedBackAndOthersList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthers.getTargetUsers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getPortalMessage());
                    Hibernate.initialize(communicationFeedBackAndOthers.getPortalMessage().getTargetUsers());
                    Hibernate.initialize(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersArchive());
                    for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()) {
                        Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    }
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthers communicationFeedBackAndOthersByIdEager(Long communicationFeedBackAndOthersId) {
        try {
            CommunicationFeedBackAndOthers communicationFeedBackAndOthers = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersById(communicationFeedBackAndOthersId);
            if (communicationFeedBackAndOthers != null) {
                Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationMessageMode());
                Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationTargetGroup());
                Hibernate.initialize(communicationFeedBackAndOthers.getTargetUsers());
                Hibernate.initialize((Object)communicationFeedBackAndOthers.getPortalMessage());
                Hibernate.initialize(communicationFeedBackAndOthers.getPortalMessage().getTargetUsers());
                Hibernate.initialize(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory());
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                }
                log.info((Object)(" CommunicationFeedBackAndOthers with id=" + communicationFeedBackAndOthersId + " has been reterived"));
                return communicationFeedBackAndOthers;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthers with  id=" + communicationFeedBackAndOthersId + " is available"));
            return communicationFeedBackAndOthers;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthers by id=" + communicationFeedBackAndOthersId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersListEager() {
        try {
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getList();
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : communicationFeedBackAndOthersList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthers.getTargetUsers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getPortalMessage());
                    Hibernate.initialize(communicationFeedBackAndOthers.getPortalMessage().getTargetUsers());
                    Hibernate.initialize(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory());
                    for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()) {
                        Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    }
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersByInstituion(institution);
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList = this.communicationFeedBackAndOthersDAO.getCommunicationFeedBackAndOthersByInstituion(institution);
            Integer listSize = communicationFeedBackAndOthersList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthers communicationFeedBackAndOthers : communicationFeedBackAndOthersList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthers.getTargetUsers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthers.getPortalMessage());
                    Hibernate.initialize(communicationFeedBackAndOthers.getPortalMessage().getTargetUsers());
                    Hibernate.initialize(communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory());
                    for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthers.getCommunicationFeedBackAndOthersHistory()) {
                        Hibernate.initialize((Object)communicationFeedBackAndOthersHistory);
                    }
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthers records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthers(s) available");
            }
            return communicationFeedBackAndOthersList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthers list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
