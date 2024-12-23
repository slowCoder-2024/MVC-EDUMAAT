/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommunicationFeedBackAndOthersArchiveService {
    public static final Logger log = LogManager.getLogger((String)CommunicationFeedBackAndOthersArchiveService.class.getName());

    public void createCommunicationFeedBackAndOthersArchive(CommunicationFeedBackAndOthers var1, CommunicationFeedBackAndOthersArchive var2);

    public void deleteCommunicationFeedBackAndOthersArchive(Long var1);

    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveList();

    public CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchiveById(Long var1);

    public CommunicationFeedBackAndOthersArchive communicationFeedBackAndOthersArchiveByIdEager(Long var1);

    public void updateCommunicationFeedBackAndOthersArchive(CommunicationFeedBackAndOthersArchive var1);

    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveByUserIdEager(Long var1);

    public List<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchiveByEmailEager(String var1);
}
