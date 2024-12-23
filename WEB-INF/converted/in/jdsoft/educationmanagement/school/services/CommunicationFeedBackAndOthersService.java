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
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CommunicationFeedBackAndOthersService {
    public static final Logger log = LogManager.getLogger((String)CommunicationFeedBackAndOthersService.class.getName());

    public void createCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers var1, String var2);

    public void sentEmailCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers var1) throws Exception;

    public void sentSMSCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers var1, Set<String> var2) throws Exception;

    public void deleteCommunicationFeedBackAndOthers(Long var1);

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList();

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersListEager();

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersList(Long var1);

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersListEager(Long var1);

    public CommunicationFeedBackAndOthers communicationFeedBackAndOthersById(Long var1);

    public CommunicationFeedBackAndOthers communicationFeedBackAndOthersByIdEager(Long var1);

    public void updateCommunicationFeedBackAndOthers(CommunicationFeedBackAndOthers var1);

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersByUserIdEager(Long var1);

    public List<CommunicationFeedBackAndOthers> communicationFeedBackAndOthersByEmailEager(String var1);
}
