/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PortalNotification;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PortalNotificationService {
    public static final Logger log = LogManager.getLogger((String)PortalNotificationService.class.getName());

    public void createPortalNotification(PortalNotification var1);

    public void deletePortalNotification(Long var1);

    public List<PortalNotification> portalNotificationList();

    public List<PortalNotification> portalNotificationListEager();

    public List<PortalNotification> portalNotificationList(Long var1);

    public List<PortalNotification> portalNotificationListEager(Long var1);

    public PortalNotification portalNotificationById(Long var1);

    public PortalNotification portalNotificationByIdEager(Long var1);

    public void updatePortalNotification(PortalNotification var1);

    public List<PortalNotification> portalNotificationByUserIdEager(Long var1);

    public List<PortalNotification> portalNotificationByEmailEager(String var1);
}
