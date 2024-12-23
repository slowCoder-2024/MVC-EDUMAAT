/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PortalTask;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PortalTaskService {
    public static final Logger log = LogManager.getLogger((String)PortalTaskService.class.getName());

    public void createPortalTask(PortalTask var1);

    public void deletePortalTask(Long var1);

    public List<PortalTask> portalTaskList();

    public List<PortalTask> portalTaskListEager();

    public List<PortalTask> portalTaskList(Long var1);

    public List<PortalTask> portalTaskListEager(Long var1);

    public PortalTask portalTaskById(Long var1);

    public PortalTask portalTaskByIdEager(Long var1);

    public void updatePortalTask(PortalTask var1);

    public List<PortalTask> portalTaskByUserIdEager(Long var1);

    public List<PortalTask> portalTaskByEmailEager(String var1);
}
