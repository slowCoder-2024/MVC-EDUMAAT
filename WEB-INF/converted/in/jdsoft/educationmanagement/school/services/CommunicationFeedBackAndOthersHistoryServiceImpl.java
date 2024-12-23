/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersHistoryDAO;
import in.jdsoft.educationmanagement.school.dao.PortalReplyMessageDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersHistoryService;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" CommunicationFeedBackAndOthersHistoryService")
public class CommunicationFeedBackAndOthersHistoryServiceImpl
implements CommunicationFeedBackAndOthersHistoryService {
    @Autowired
    private CommunicationFeedBackAndOthersHistoryDAO communicationFeedBackAndOthersHistoryDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    PortalReplyMessageDAO portalReplyMessageDAO;

    @Override
    public void createCommunicationFeedBackAndOthersHistory(CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory, Institution institution) {
        try {
            LinkedHashSet<User> user = new LinkedHashSet<User>();
            user.add(communicationFeedBackAndOthersHistory.getTargetUser());
            PortalReplyMessage portalReplyMessage = new PortalReplyMessage(communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistorySubject(), communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistoryMessage(), user, communicationFeedBackAndOthersHistory.getStatus(), "/communication", communicationFeedBackAndOthersHistory.getCreatedBy(), institution);
            PortalReplyMessage persistedPortalReplyMessage = this.portalReplyMessageDAO.save(portalReplyMessage);
            communicationFeedBackAndOthersHistory.setPortalReplyMessage(persistedPortalReplyMessage);
            communicationFeedBackAndOthersHistory.setMessageLink("/communication");
            CommunicationFeedBackAndOthersHistory persistedCommunicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryDAO.save(communicationFeedBackAndOthersHistory);
            Long communicationFeedBackAndOthersHistoryId = persistedCommunicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistoryId();
            log.info((Object)(" CommunicationFeedBackAndOthersHistory is created with the id=" + communicationFeedBackAndOthersHistoryId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  CommunicationFeedBackAndOthersHistory", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteCommunicationFeedBackAndOthersHistory(Long communicationFeedBackAndOthersHistoryId) {
        try {
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryDAO.getCommunicationFeedBackAndOthersHistoryById(communicationFeedBackAndOthersHistoryId);
            if (communicationFeedBackAndOthersHistory != null) {
                this.communicationFeedBackAndOthersHistoryDAO.delete(communicationFeedBackAndOthersHistory);
                log.info((Object)(" CommunicationFeedBackAndOthersHistory with id=" + communicationFeedBackAndOthersHistoryId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  CommunicationFeedBackAndOthersHistory", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList() {
        try {
            List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList = this.communicationFeedBackAndOthersHistoryDAO.getList();
            Integer listSize = communicationFeedBackAndOthersHistoryList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersHistory records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersHistory(s) available");
            }
            return communicationFeedBackAndOthersHistoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersHistory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryById(Long communicationFeedBackAndOthersHistoryId) {
        try {
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryDAO.getCommunicationFeedBackAndOthersHistoryById(communicationFeedBackAndOthersHistoryId);
            if (communicationFeedBackAndOthersHistory != null) {
                log.info((Object)(" CommunicationFeedBackAndOthersHistory with id=" + communicationFeedBackAndOthersHistoryId + " has been reterived"));
                return communicationFeedBackAndOthersHistory;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthersHistory with  id=" + communicationFeedBackAndOthersHistoryId + " is available"));
            return communicationFeedBackAndOthersHistory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthersHistory by id=" + communicationFeedBackAndOthersHistoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCommunicationFeedBackAndOthersHistory(CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory) {
        try {
            this.communicationFeedBackAndOthersHistoryDAO.saveOrUpdate(communicationFeedBackAndOthersHistory);
            Long communicationFeedBackAndOthersHistoryId = communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthersHistoryId();
            if (communicationFeedBackAndOthersHistoryId != null) {
                log.info((Object)(" CommunicationFeedBackAndOthersHistory with id=" + communicationFeedBackAndOthersHistoryId + " has been updated"));
            } else {
                log.info((Object)"New  CommunicationFeedBackAndOthersHistory has been added, because no  CommunicationFeedBackAndOthersHistory found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  CommunicationFeedBackAndOthersHistory", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList = this.communicationFeedBackAndOthersHistoryDAO.getCommunicationFeedBackAndOthersHistoryByUser(user);
            Integer listSize = communicationFeedBackAndOthersHistoryList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthersHistoryList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getPortalReplyMessage().getInstitution());
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersHistory records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersHistory(s) available");
            }
            return communicationFeedBackAndOthersHistoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersHistory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryByEmailEager(String email) {
        try {
            List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList = this.communicationFeedBackAndOthersHistoryDAO.getCommunicationFeedBackAndOthersHistoryByEmail(email);
            Integer listSize = communicationFeedBackAndOthersHistoryList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthersHistoryList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getPortalReplyMessage().getInstitution());
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersHistory records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersHistory(s) available");
            }
            return communicationFeedBackAndOthersHistoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersHistory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryByIdEager(Long communicationFeedBackAndOthersHistoryId) {
        try {
            CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory = this.communicationFeedBackAndOthersHistoryDAO.getCommunicationFeedBackAndOthersHistoryById(communicationFeedBackAndOthersHistoryId);
            if (communicationFeedBackAndOthersHistory != null) {
                Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getPortalReplyMessage().getInstitution());
                log.info((Object)(" CommunicationFeedBackAndOthersHistory with id=" + communicationFeedBackAndOthersHistoryId + " has been reterived"));
                return communicationFeedBackAndOthersHistory;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthersHistory with  id=" + communicationFeedBackAndOthersHistoryId + " is available"));
            return communicationFeedBackAndOthersHistory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthersHistory by id=" + communicationFeedBackAndOthersHistoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryListEager() {
        try {
            List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList = this.communicationFeedBackAndOthersHistoryDAO.getList();
            Integer listSize = communicationFeedBackAndOthersHistoryList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistory : communicationFeedBackAndOthersHistoryList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getCommunicationFeedBackAndOthers());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getTargetUser());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersHistory.getPortalReplyMessage().getInstitution());
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersHistory records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersHistory(s) available");
            }
            return communicationFeedBackAndOthersHistoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersHistory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
