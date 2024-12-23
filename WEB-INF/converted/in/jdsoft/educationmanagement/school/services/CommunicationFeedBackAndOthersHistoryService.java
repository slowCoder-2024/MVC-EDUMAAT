/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommunicationFeedBackAndOthersHistoryService {
    public static final Logger log = LogManager.getLogger((String)CommunicationFeedBackAndOthersHistoryService.class.getName());

    public void createCommunicationFeedBackAndOthersHistory(CommunicationFeedBackAndOthersHistory var1, Institution var2);

    public void deleteCommunicationFeedBackAndOthersHistory(Long var1);

    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryList();

    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryListEager();

    public CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryById(Long var1);

    public CommunicationFeedBackAndOthersHistory communicationFeedBackAndOthersHistoryByIdEager(Long var1);

    public void updateCommunicationFeedBackAndOthersHistory(CommunicationFeedBackAndOthersHistory var1);

    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryByUserIdEager(Long var1);

    public List<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistoryByEmailEager(String var1);
}
