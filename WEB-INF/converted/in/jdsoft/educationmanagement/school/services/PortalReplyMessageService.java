/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PortalReplyMessageService {
    public static final Logger log = LogManager.getLogger((String)PortalReplyMessageService.class.getName());

    public void createPortalReplyMessage(PortalReplyMessage var1);

    public void deletePortalReplyMessage(Long var1);

    public List<PortalReplyMessage> portalReplyMessageList();

    public List<PortalReplyMessage> portalReplyMessageListEager();

    public List<PortalReplyMessage> portalReplyMessageList(Long var1);

    public List<PortalReplyMessage> portalReplyMessageListEager(Long var1);

    public PortalReplyMessage portalReplyMessageById(Long var1);

    public PortalReplyMessage portalReplyMessageByIdEager(Long var1);

    public void updatePortalReplyMessage(PortalReplyMessage var1);

    public List<PortalReplyMessage> portalReplyMessageByUserIdEager(Long var1);

    public List<PortalReplyMessage> portalReplyMessageByEmailEager(String var1);
}
