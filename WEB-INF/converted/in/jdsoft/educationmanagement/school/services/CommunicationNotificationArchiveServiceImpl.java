/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CommunicationNotificationArchiveDAO;
import in.jdsoft.educationmanagement.school.dao.CommunicationNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CommunicationNotificationArchiveService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" CommunicationNotificationArchiveService")
public class CommunicationNotificationArchiveServiceImpl
implements CommunicationNotificationArchiveService {
    @Autowired
    private CommunicationNotificationArchiveDAO communicationNotificationArchiveDAO;
    @Autowired
    private CommunicationNotificationDAO communicationNotificationDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void createCommunicationNotificationArchive(CommunicationNotification communicationNotification, CommunicationNotificationArchive communicationNotificationArchive) {
        try {
            communicationNotificationArchive.setCommunicationNotification(communicationNotification);
            communicationNotificationArchive.setCreatedDate(communicationNotification.getCreatedDate());
            CommunicationNotificationArchive persistedCommunicationNotificationArchive = this.communicationNotificationArchiveDAO.save(communicationNotificationArchive);
            communicationNotification.setStatus(0);
            this.communicationNotificationDAO.saveOrUpdate(communicationNotification);
            Long communicationNotificationArchiveId = persistedCommunicationNotificationArchive.getCommunicationNotificationArchiveId();
            log.info((Object)(" CommunicationNotificationArchive is created with the id=" + communicationNotificationArchiveId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  CommunicationNotificationArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteCommunicationNotificationArchive(Long communicationNotificationArchiveId) {
        try {
            CommunicationNotificationArchive communicationNotificationArchive = this.communicationNotificationArchiveDAO.getCommunicationNotificationArchiveById(communicationNotificationArchiveId);
            if (communicationNotificationArchive != null) {
                this.communicationNotificationArchiveDAO.delete(communicationNotificationArchive);
                log.info((Object)(" CommunicationNotificationArchive with id=" + communicationNotificationArchiveId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  CommunicationNotificationArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotificationArchive> communicationNotificationArchiveList() {
        try {
            List<CommunicationNotificationArchive> communicationNotificationArchiveList = this.communicationNotificationArchiveDAO.getList();
            Integer listSize = communicationNotificationArchiveList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationNotificationArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotificationArchive(s) available");
            }
            return communicationNotificationArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotificationArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationNotificationArchive communicationNotificationArchiveById(Long communicationNotificationArchiveId) {
        try {
            CommunicationNotificationArchive communicationNotificationArchive = this.communicationNotificationArchiveDAO.getCommunicationNotificationArchiveById(communicationNotificationArchiveId);
            if (communicationNotificationArchive != null) {
                log.info((Object)(" CommunicationNotificationArchive with id=" + communicationNotificationArchiveId + " has been reterived"));
                return communicationNotificationArchive;
            }
            log.info((Object)("No  CommunicationNotificationArchive with  id=" + communicationNotificationArchiveId + " is available"));
            return communicationNotificationArchive;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationNotificationArchive by id=" + communicationNotificationArchiveId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCommunicationNotificationArchive(CommunicationNotificationArchive communicationNotificationArchive) {
        try {
            this.communicationNotificationArchiveDAO.saveOrUpdate(communicationNotificationArchive);
            Long communicationNotificationArchiveId = communicationNotificationArchive.getCommunicationNotificationArchiveId();
            if (communicationNotificationArchiveId != null) {
                log.info((Object)(" CommunicationNotificationArchive with id=" + communicationNotificationArchiveId + " has been updated"));
            } else {
                log.info((Object)"New  CommunicationNotificationArchive has been added, because no  CommunicationNotificationArchive found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  CommunicationNotificationArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotificationArchive> communicationNotificationArchiveByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<CommunicationNotificationArchive> communicationNotificationArchiveList = this.communicationNotificationArchiveDAO.getCommunicationNotificationArchivesByUser(user);
            Integer listSize = communicationNotificationArchiveList.size();
            if (listSize > 0) {
                for (CommunicationNotificationArchive communicationNotificationArchive : communicationNotificationArchiveList) {
                    Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotificationArchive.getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotificationArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotificationArchive(s) available");
            }
            return communicationNotificationArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotificationArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationNotificationArchive> communicationNotificationArchiveByEmailEager(String email) {
        try {
            List<CommunicationNotificationArchive> communicationNotificationArchiveList = this.communicationNotificationArchiveDAO.getCommunicationNotificationArchivesByEmail(email);
            Integer listSize = communicationNotificationArchiveList.size();
            if (listSize > 0) {
                for (CommunicationNotificationArchive communicationNotificationArchive : communicationNotificationArchiveList) {
                    Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationNotificationArchive.getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationNotificationArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationNotificationArchive(s) available");
            }
            return communicationNotificationArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationNotificationArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationNotificationArchive communicationNotificationArchiveByIdEager(Long communicationNotificationArchiveId) {
        try {
            CommunicationNotificationArchive communicationNotificationArchive = this.communicationNotificationArchiveDAO.getCommunicationNotificationArchiveById(communicationNotificationArchiveId);
            if (communicationNotificationArchive != null) {
                Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationMessageMode());
                Hibernate.initialize((Object)communicationNotificationArchive.getCommunicationTargetGroup());
                Hibernate.initialize(communicationNotificationArchive.getTargetUsers());
                log.info((Object)(" CommunicationNotificationArchive with id=" + communicationNotificationArchiveId + " has been reterived"));
                return communicationNotificationArchive;
            }
            log.info((Object)("No  CommunicationNotificationArchive with  id=" + communicationNotificationArchiveId + " is available"));
            return communicationNotificationArchive;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationNotificationArchive by id=" + communicationNotificationArchiveId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
