/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PortalReplyMessageDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PortalReplyMessageService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" PortalReplyMessageService")
public class PortalReplyMessageServiceImpl
implements PortalReplyMessageService {
    @Autowired
    private PortalReplyMessageDAO PortalReplyMessageDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;

    @Override
    public void createPortalReplyMessage(PortalReplyMessage PortalReplyMessage2) {
        try {
            PortalReplyMessage persistedPortalReplyMessage = this.PortalReplyMessageDAO.save(PortalReplyMessage2);
            Long PortalReplyMessageId = persistedPortalReplyMessage.getportalReplyMessageId();
            log.info((Object)(" PortalReplyMessage is created with the id=" + PortalReplyMessageId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  PortalReplyMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePortalReplyMessage(Long PortalReplyMessageId) {
        try {
            PortalReplyMessage PortalReplyMessage2 = this.PortalReplyMessageDAO.getPortalReplyMessageById(PortalReplyMessageId);
            if (PortalReplyMessage2 != null) {
                this.PortalReplyMessageDAO.delete(PortalReplyMessage2);
                log.info((Object)(" PortalReplyMessage with id=" + PortalReplyMessageId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  PortalReplyMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageList() {
        try {
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getList();
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalReplyMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalReplyMessage portalReplyMessageById(Long PortalReplyMessageId) {
        try {
            PortalReplyMessage PortalReplyMessage2 = this.PortalReplyMessageDAO.getPortalReplyMessageById(PortalReplyMessageId);
            if (PortalReplyMessage2 != null) {
                log.info((Object)(" PortalReplyMessage with id=" + PortalReplyMessageId + " has been reterived"));
                return PortalReplyMessage2;
            }
            log.info((Object)("No  PortalReplyMessage with  id=" + PortalReplyMessageId + " is available"));
            return PortalReplyMessage2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalReplyMessage by id=" + PortalReplyMessageId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePortalReplyMessage(PortalReplyMessage PortalReplyMessage2) {
        try {
            this.PortalReplyMessageDAO.saveOrUpdate(PortalReplyMessage2);
            Long PortalReplyMessageId = PortalReplyMessage2.getportalReplyMessageId();
            if (PortalReplyMessageId != null) {
                log.info((Object)(" PortalReplyMessage with id=" + PortalReplyMessageId + " has been updated"));
            } else {
                log.info((Object)"New  PortalReplyMessage has been added, because no  PortalReplyMessage found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  PortalReplyMessage", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getPortalReplyMessagesByUser(user);
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                for (PortalReplyMessage PortalReplyMessage2 : PortalReplyMessageList) {
                    Hibernate.initialize(PortalReplyMessage2.getTargetUsers());
                    Hibernate.initialize((Object)PortalReplyMessage2.getInstitution());
                }
                log.info((Object)(listSize + "  PortalReplyMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageByEmailEager(String email) {
        try {
            Integer status = 1;
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getPortalReplyMessagesByEmailAndStatus(email, status);
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                for (PortalReplyMessage PortalReplyMessage2 : PortalReplyMessageList) {
                    Hibernate.initialize(PortalReplyMessage2.getTargetUsers());
                    Hibernate.initialize((Object)PortalReplyMessage2.getInstitution());
                }
                log.info((Object)(listSize + "  PortalReplyMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalReplyMessage portalReplyMessageByIdEager(Long PortalReplyMessageId) {
        try {
            PortalReplyMessage PortalReplyMessage2 = this.PortalReplyMessageDAO.getPortalReplyMessageById(PortalReplyMessageId);
            if (PortalReplyMessage2 != null) {
                Hibernate.initialize(PortalReplyMessage2.getTargetUsers());
                Hibernate.initialize((Object)PortalReplyMessage2.getInstitution());
                log.info((Object)(" PortalReplyMessage with id=" + PortalReplyMessageId + " has been reterived"));
                return PortalReplyMessage2;
            }
            log.info((Object)("No  PortalReplyMessage with  id=" + PortalReplyMessageId + " is available"));
            return PortalReplyMessage2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalReplyMessage by id=" + PortalReplyMessageId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageListEager() {
        try {
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getList();
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                for (PortalReplyMessage PortalReplyMessage2 : PortalReplyMessageList) {
                    Hibernate.initialize(PortalReplyMessage2.getTargetUsers());
                    Hibernate.initialize((Object)PortalReplyMessage2.getInstitution());
                }
                log.info((Object)(listSize + "  PortalReplyMessage records where reterived"));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getPortalReplyMessagesByInstituion(institution);
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalReplyMessage records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalReplyMessage> portalReplyMessageListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalReplyMessage> PortalReplyMessageList = this.PortalReplyMessageDAO.getPortalReplyMessagesByInstituion(institution);
            Integer listSize = PortalReplyMessageList.size();
            if (listSize > 0) {
                for (PortalReplyMessage PortalReplyMessage2 : PortalReplyMessageList) {
                    Hibernate.initialize(PortalReplyMessage2.getTargetUsers());
                    Hibernate.initialize((Object)PortalReplyMessage2.getInstitution());
                }
                log.info((Object)(listSize + "  PortalReplyMessage records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalReplyMessage(s) available");
            }
            return PortalReplyMessageList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalReplyMessage list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
