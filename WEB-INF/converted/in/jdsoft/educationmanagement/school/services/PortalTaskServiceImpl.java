/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PortalTaskService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value=" PortalTaskService")
public class PortalTaskServiceImpl
implements PortalTaskService {
    @Autowired
    private PortalTaskDAO PortalTaskDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private InstitutionService institutionService;

    @Override
    public void createPortalTask(PortalTask portalTask) {
        try {
            PortalTask persistedPortalTask = this.PortalTaskDAO.save(portalTask);
            Long portalTaskId = persistedPortalTask.getPortalTaskId();
            log.info((Object)(" PortalTask is created with the id=" + portalTaskId));
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  PortalTask", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePortalTask(Long portalTaskId) {
        try {
            PortalTask PortalTask2 = this.PortalTaskDAO.getPortalTaskById(portalTaskId);
            if (PortalTask2 != null) {
                this.PortalTaskDAO.delete(PortalTask2);
                log.info((Object)(" PortalTask with id=" + portalTaskId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  PortalTask", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskList() {
        try {
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getList();
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalTask records where reterived"));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalTask portalTaskById(Long portalTaskId) {
        try {
            PortalTask portalTask = this.PortalTaskDAO.getPortalTaskById(portalTaskId);
            if (portalTask != null) {
                log.info((Object)(" PortalTask with id=" + portalTaskId + " has been reterived"));
                return portalTask;
            }
            log.info((Object)("No  PortalTask with  id=" + portalTaskId + " is available"));
            return portalTask;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalTask by id=" + portalTaskId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePortalTask(PortalTask portalTask) {
        try {
            this.PortalTaskDAO.saveOrUpdate(portalTask);
            Long portalTaskId = portalTask.getPortalTaskId();
            if (portalTaskId != null) {
                log.info((Object)(" PortalTask with id=" + portalTaskId + " has been updated"));
            } else {
                log.info((Object)"New  PortalTask has been added, because no  PortalTask found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  PortalTask", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskByUserIdEager(Long userId) {
        try {
            User user = this.userDAO.getUserById(userId);
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getPortalTasksByUser(user);
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                for (PortalTask portalTask : portalTaskList) {
                    Hibernate.initialize(portalTask.getTargetUsers());
                    Hibernate.initialize((Object)portalTask.getInstitution());
                }
                log.info((Object)(listSize + "  PortalTask records where reterived"));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskByEmailEager(String email) {
        try {
            Integer status = 1;
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getPortalTasksByEmailAndStatus(email, status);
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                for (PortalTask portalTask : portalTaskList) {
                    Hibernate.initialize(portalTask.getTargetUsers());
                    Hibernate.initialize((Object)portalTask.getInstitution());
                }
                log.info((Object)(listSize + "  PortalTask records where reterived"));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PortalTask portalTaskByIdEager(Long portalTaskId) {
        try {
            PortalTask portalTask = this.PortalTaskDAO.getPortalTaskById(portalTaskId);
            if (portalTask != null) {
                Hibernate.initialize(portalTask.getTargetUsers());
                Hibernate.initialize((Object)portalTask.getInstitution());
                log.info((Object)(" PortalTask with id=" + portalTaskId + " has been reterived"));
                return portalTask;
            }
            log.info((Object)("No  PortalTask with  id=" + portalTaskId + " is available"));
            return portalTask;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  PortalTask by id=" + portalTaskId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskListEager() {
        try {
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getList();
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                for (PortalTask portalTask : portalTaskList) {
                    Hibernate.initialize(portalTask.getTargetUsers());
                    Hibernate.initialize((Object)portalTask.getInstitution());
                }
                log.info((Object)(listSize + "  PortalTask records where reterived"));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskList(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getPortalTasksByInstituion(institution);
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + "  PortalTask records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PortalTask> portalTaskListEager(Long institutionId) {
        try {
            Institution institution = this.institutionService.institutionById(institutionId);
            List<PortalTask> portalTaskList = this.PortalTaskDAO.getPortalTasksByInstituion(institution);
            Integer listSize = portalTaskList.size();
            if (listSize > 0) {
                for (PortalTask portalTask : portalTaskList) {
                    Hibernate.initialize(portalTask.getTargetUsers());
                    Hibernate.initialize((Object)portalTask.getInstitution());
                }
                log.info((Object)(listSize + "  PortalTask records reterived with institution id=" + institutionId));
            } else {
                log.info((Object)"No  PortalTask(s) available");
            }
            return portalTaskList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  PortalTask list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
