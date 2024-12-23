/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommunicationNotificationService {
    public static final Logger log = LogManager.getLogger((String)CommunicationNotificationService.class.getName());

    public void createCommunicationNotification(CommunicationNotification var1, String var2);

    public void sentEmailCommunicationNotification(CommunicationNotification var1) throws Exception;

    public void sentSMSCommunicationNotification(CommunicationNotification var1, Set<String> var2) throws Exception;

    public void deleteCommunicationNotification(Long var1);

    public List<CommunicationNotification> communicationNotificationList();

    public List<CommunicationNotification> communicationNotificationListEager();

    public List<CommunicationNotification> communicationNotificationList(Long var1);

    public List<CommunicationNotification> communicationNotificationListEager(Long var1);

    public CommunicationNotification communicationNotificationById(Long var1);

    public CommunicationNotification communicationNotificationByIdEager(Long var1);

    public void updateCommunicationNotification(CommunicationNotification var1);

    public List<CommunicationNotification> communicationNotificationByUserIdEager(Long var1);

    public List<CommunicationNotification> communicationNotificationByEmailEager(String var1);
}
