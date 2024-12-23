/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PortalNotificationService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" PortalNotificationService")
public class PortalNotificationServiceImpl
implements PortalNotificationService {
    @Autowired
    private PortalNotificationDAO PortalNotificationDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;

    @Override
    public void createPortalNotification(PortalNotification portalNotification) {
        try {
            PortalNotification persistedPortalNotification = this.PortalNotificationDAO.save(portalNotification);
            Long portalNotificationId = persistedPortalNotification.getPortalNotificationId();
            log.info((Object)(" PortalNotification is created with the id=" + portalNotificationId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  PortalNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePortalNotification(Long portalNotificationId) {
        try {
            PortalNotification PortalNotification2 = this.PortalNotificationDAO.getPortalNotificationById(portalNotificationId);
            if (PortalNotification2 != null) {
                this.PortalNotificationDAO.delete(PortalNotification2);
                log.info((Object)(" PortalNotification with id=" + portalNotificationId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  PortalNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationList() {
        try {
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getList();
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalNotification records where reterived"));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalNotification portalNotificationById(Long portalNotificationId) {
        try {
            PortalNotification portalNotification = this.PortalNotificationDAO.getPortalNotificationById(portalNotificationId);
            if (portalNotification != null) {
                log.info((Object)(" PortalNotification with id=" + portalNotificationId + " has been reterived"));
                return portalNotification;
            }
            log.info((Object)("No  PortalNotification with  id=" + portalNotificationId + " is available"));
            return portalNotification;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalNotification by id=" + portalNotificationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePortalNotification(PortalNotification portalNotification) {
        try {
            this.PortalNotificationDAO.saveOrUpdate(portalNotification);
            Long portalNotificationId = portalNotification.getPortalNotificationId();
            if (portalNotificationId != null) {
                log.info((Object)(" PortalNotification with id=" + portalNotificationId + " has been updated"));
            } else {
                log.info((Object)"New  PortalNotification has been added, because no  PortalNotification found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  PortalNotification", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getPortalNotificationsByUser(user);
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                for (PortalNotification portalNotification : portalNotificationList) {
                    Hibernate.initialize(portalNotification.getTargetUsers());
                    Hibernate.initialize((Object)portalNotification.getInstitution());
                }
                log.info((Object)(listSize + "  PortalNotification records where reterived"));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationByEmailEager(String email) {
        try {
            Integer status = 1;
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getPortalNotificationsByEmailAndStatus(email, status);
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                for (PortalNotification portalNotification : portalNotificationList) {
                    Hibernate.initialize(portalNotification.getTargetUsers());
                    Hibernate.initialize((Object)portalNotification.getInstitution());
                }
                log.info((Object)(listSize + "  PortalNotification records where reterived"));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalNotification portalNotificationByIdEager(Long portalNotificationId) {
        try {
            PortalNotification portalNotification = this.PortalNotificationDAO.getPortalNotificationById(portalNotificationId);
            if (portalNotification != null) {
                Hibernate.initialize(portalNotification.getTargetUsers());
                Hibernate.initialize((Object)portalNotification.getInstitution());
                log.info((Object)(" PortalNotification with id=" + portalNotificationId + " has been reterived"));
                return portalNotification;
            }
            log.info((Object)("No  PortalNotification with  id=" + portalNotificationId + " is available"));
            return portalNotification;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalNotification by id=" + portalNotificationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationListEager() {
        try {
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getList();
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                for (PortalNotification portalNotification : portalNotificationList) {
                    Hibernate.initialize(portalNotification.getTargetUsers());
                    Hibernate.initialize((Object)portalNotification.getInstitution());
                }
                log.info((Object)(listSize + "  PortalNotification records where reterived"));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getPortalNotificationsByInstituion(institution);
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalNotification records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalNotification> portalNotificationListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalNotification> portalNotificationList = this.PortalNotificationDAO.getPortalNotificationsByInstituion(institution);
            Integer listSize = portalNotificationList.size();
            if (listSize > 0) {
                for (PortalNotification portalNotification : portalNotificationList) {
                    Hibernate.initialize(portalNotification.getTargetUsers());
                    Hibernate.initialize((Object)portalNotification.getInstitution());
                }
                log.info((Object)(listSize + "  PortalNotification records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalNotification(s) available");
            }
            return portalNotificationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalNotification list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
