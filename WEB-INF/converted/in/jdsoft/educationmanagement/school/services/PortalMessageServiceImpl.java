/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PortalMessageDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PortalMessageService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" PortalMessageService")
public class PortalMessageServiceImpl
implements PortalMessageService {
    @Autowired
    private PortalMessageDAO PortalMessageDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;

    @Override
    public void createPortalMessage(PortalMessage portalMessage) {
        try {
            PortalMessage persistedPortalMessage = this.PortalMessageDAO.save(portalMessage);
            Long portalMessageId = persistedPortalMessage.getPortalMessageId();
            log.info((Object)(" PortalMessage is created with the id=" + portalMessageId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  PortalMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePortalMessage(Long portalMessageId) {
        try {
            PortalMessage PortalMessage2 = this.PortalMessageDAO.getPortalMessageById(portalMessageId);
            if (PortalMessage2 != null) {
                this.PortalMessageDAO.delete(PortalMessage2);
                log.info((Object)(" PortalMessage with id=" + portalMessageId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  PortalMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageList() {
        try {
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getList();
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalMessage portalMessageById(Long portalMessageId) {
        try {
            PortalMessage portalMessage = this.PortalMessageDAO.getPortalMessageById(portalMessageId);
            if (portalMessage != null) {
                log.info((Object)(" PortalMessage with id=" + portalMessageId + " has been reterived"));
                return portalMessage;
            }
            log.info((Object)("No  PortalMessage with  id=" + portalMessageId + " is available"));
            return portalMessage;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalMessage by id=" + portalMessageId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePortalMessage(PortalMessage portalMessage) {
        try {
            this.PortalMessageDAO.saveOrUpdate(portalMessage);
            Long portalMessageId = portalMessage.getPortalMessageId();
            if (portalMessageId != null) {
                log.info((Object)(" PortalMessage with id=" + portalMessageId + " has been updated"));
            } else {
                log.info((Object)"New  PortalMessage has been added, because no  PortalMessage found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  PortalMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getPortalMessagesByUser(user);
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                for (PortalMessage portalMessage : portalMessageList) {
                    Hibernate.initialize(portalMessage.getTargetUsers());
                    Hibernate.initialize((Object)portalMessage.getInstitution());
                }
                log.info((Object)(listSize + "  PortalMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageByEmailEager(String email) {
        try {
            Integer status = 1;
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getPortalMessagesByEmailAndStatus(email, status);
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                for (PortalMessage portalMessage : portalMessageList) {
                    Hibernate.initialize(portalMessage.getTargetUsers());
                    Hibernate.initialize((Object)portalMessage.getInstitution());
                }
                log.info((Object)(listSize + "  PortalMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalMessage portalMessageByIdEager(Long portalMessageId) {
        try {
            PortalMessage portalMessage = this.PortalMessageDAO.getPortalMessageById(portalMessageId);
            if (portalMessage != null) {
                Hibernate.initialize(portalMessage.getTargetUsers());
                Hibernate.initialize((Object)portalMessage.getInstitution());
                log.info((Object)(" PortalMessage with id=" + portalMessageId + " has been reterived"));
                return portalMessage;
            }
            log.info((Object)("No  PortalMessage with  id=" + portalMessageId + " is available"));
            return portalMessage;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalMessage by id=" + portalMessageId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageListEager() {
        try {
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getList();
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                for (PortalMessage portalMessage : portalMessageList) {
                    Hibernate.initialize(portalMessage.getTargetUsers());
                    Hibernate.initialize((Object)portalMessage.getInstitution());
                }
                log.info((Object)(listSize + "  PortalMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getPortalMessagesByInstituion(institution);
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalMessage records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalMessage> portalMessageListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalMessage> portalMessageList = this.PortalMessageDAO.getPortalMessagesByInstituion(institution);
            Integer listSize = portalMessageList.size();
            if (listSize > 0) {
                for (PortalMessage portalMessage : portalMessageList) {
                    Hibernate.initialize(portalMessage.getTargetUsers());
                    Hibernate.initialize((Object)portalMessage.getInstitution());
                }
                log.info((Object)(listSize + "  PortalMessage records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalMessage(s) available");
            }
            return portalMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
