/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersArchiveDAO;
import in.jdsoft.educationmanagement.school.dao.CommunicationFeedBackAndOthersDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.CommunicationFeedBackAndOthersArchiveService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" CommunicationFeedBackAndOthersArchiveService")
public class CommunicationFeedBackAndOthersArchiveServiceImpl
implements CommunicationFeedBackAndOthersArchiveService {
    @Autowired
    private CommunicationFeedBackAndOthersArchiveDAO communicationFeedBackAndOthersArchiveDAO;
    @Autowired
    private CommunicationFeedBackAndOthersDAO communicationFeedBackAndOthersDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public void createCommunicationFeedBackAndOthersArchive(CommunicationFeedBackAndOthers communicationFeedBackAndOthers, CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive) {
        try {
            communicationFeedBackAndOthersArchive.setCommunicationFeedBackAndOthers(communicationFeedBackAndOthers);
            communicationFeedBackAndOthersArchive.setCreatedDate(communicationFeedBackAndOthers.getCreatedDate());
            CommunicationFeedBackAndOthersArchive persistedCommunicationFeedBackAndOthersArchive = this.communicationFeedBackAndOthersArchiveDAO.save(communicationFeedBackAndOthersArchive);
            communicationFeedBackAndOthers.setStatus(0);
            this.communicationFeedBackAndOthersDAO.saveOrUpdate(communicationFeedBackAndOthers);
            Long communicationFeedBackAndOthersArchiveId = persistedCommunicationFeedBackAndOthersArchive.getCommunicationFeedBackAndOthersArchiveId();
            log.info((Object)(" CommunicationFeedBackAndOthersArchive is created with the id=" + communicationFeedBackAndOthersArchiveId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  CommunicationFeedBackAndOthersArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteCommunicationFeedBackAndOthersArchive(Long communicationFeedBackAndOthersArchiveId) {
        try {
            CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive = this.communicationFeedBackAndOthersArchiveDAO.getCommunicationFeedBackAndOthersArchiveById(communicationFeedBackAndOthersArchiveId);
            if (communicationFeedBackAndOthersArchive != null) {
                this.communicationFeedBackAndOthersArchiveDAO.delete(communicationFeedBackAndOthersArchive);
                log.info((Object)(" CommunicationFeedBackAndOthersArchive with id=" + communicationFeedBackAndOthersArchiveId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  CommunicationFeedBackAndOthersArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveList() {
        try {
            List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveList = this.communicationFeedBackAndOthersArchiveDAO.getList();
            Integer listSize = communicationFeedBackAndOthersArchiveList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersArchive(s) available");
            }
            return communicationFeedBackAndOthersArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchiveById(Long communicationFeedBackAndOthersArchiveId) {
        try {
            CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive = this.communicationFeedBackAndOthersArchiveDAO.getCommunicationFeedBackAndOthersArchiveById(communicationFeedBackAndOthersArchiveId);
            if (communicationFeedBackAndOthersArchive != null) {
                log.info((Object)(" CommunicationFeedBackAndOthersArchive with id=" + communicationFeedBackAndOthersArchiveId + " has been reterived"));
                return communicationFeedBackAndOthersArchive;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthersArchive with  id=" + communicationFeedBackAndOthersArchiveId + " is available"));
            return communicationFeedBackAndOthersArchive;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthersArchive by id=" + communicationFeedBackAndOthersArchiveId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateCommunicationFeedBackAndOthersArchive(CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive) {
        try {
            this.communicationFeedBackAndOthersArchiveDAO.saveOrUpdate(communicationFeedBackAndOthersArchive);
            Long communicationFeedBackAndOthersArchiveId = communicationFeedBackAndOthersArchive.getCommunicationFeedBackAndOthersArchiveId();
            if (communicationFeedBackAndOthersArchiveId != null) {
                log.info((Object)(" CommunicationFeedBackAndOthersArchive with id=" + communicationFeedBackAndOthersArchiveId + " has been updated"));
            } else {
                log.info((Object)"New  CommunicationFeedBackAndOthersArchive has been added, because no  CommunicationFeedBackAndOthersArchive found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  CommunicationFeedBackAndOthersArchive", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveList = this.communicationFeedBackAndOthersArchiveDAO.getCommunicationFeedBackAndOthersArchivesByUser(user);
            Integer listSize = communicationFeedBackAndOthersArchiveList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive : communicationFeedBackAndOthersArchiveList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthersArchive.getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersArchive(s) available");
            }
            return communicationFeedBackAndOthersArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveByEmailEager(String email) {
        try {
            List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveList = this.communicationFeedBackAndOthersArchiveDAO.getCommunicationFeedBackAndOthersArchivesByEmail(email);
            Integer listSize = communicationFeedBackAndOthersArchiveList.size();
            if (listSize > 0) {
                for (CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive : communicationFeedBackAndOthersArchiveList) {
                    Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationMessageMode());
                    Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationTargetGroup());
                    Hibernate.initialize(communicationFeedBackAndOthersArchive.getTargetUsers());
                }
                log.info((Object)(listSize + "  CommunicationFeedBackAndOthersArchive records where reterived"));
            } else {
                log.info((Object)"No  CommunicationFeedBackAndOthersArchive(s) available");
            }
            return communicationFeedBackAndOthersArchiveList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  CommunicationFeedBackAndOthersArchive list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchiveByIdEager(Long communicationFeedBackAndOthersArchiveId) {
        try {
            CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchive = this.communicationFeedBackAndOthersArchiveDAO.getCommunicationFeedBackAndOthersArchiveById(communicationFeedBackAndOthersArchiveId);
            if (communicationFeedBackAndOthersArchive != null) {
                Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationMessageMode());
                Hibernate.initialize((Object)communicationFeedBackAndOthersArchive.getCommunicationTargetGroup());
                Hibernate.initialize(communicationFeedBackAndOthersArchive.getTargetUsers());
                log.info((Object)(" CommunicationFeedBackAndOthersArchive with id=" + communicationFeedBackAndOthersArchiveId + " has been reterived"));
                return communicationFeedBackAndOthersArchive;
            }
            log.info((Object)("No  CommunicationFeedBackAndOthersArchive with  id=" + communicationFeedBackAndOthersArchiveId + " is available"));
            return communicationFeedBackAndOthersArchive;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  CommunicationFeedBackAndOthersArchive by id=" + communicationFeedBackAndOthersArchiveId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
