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
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommunicationNotificationArchiveService {
    public static final Logger log = LogManager.getLogger((String)CommunicationNotificationArchiveService.class.getName());

    public void createCommunicationNotificationArchive(CommunicationNotification var1, CommunicationNotificationArchive var2);

    public void deleteCommunicationNotificationArchive(Long var1);

    public List<CommunicationNotificationArchive> communicationNotificationArchiveList();

    public CommunicationNotificationArchive communicationNotificationArchiveById(Long var1);

    public CommunicationNotificationArchive communicationNotificationArchiveByIdEager(Long var1);

    public void updateCommunicationNotificationArchive(CommunicationNotificationArchive var1);

    public List<CommunicationNotificationArchive> communicationNotificationArchiveByUserIdEager(Long var1);

    public List<CommunicationNotificationArchive> communicationNotificationArchiveByEmailEager(String var1);
}
