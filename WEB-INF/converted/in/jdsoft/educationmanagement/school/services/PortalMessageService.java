/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PortalMessage;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PortalMessageService {
    public static final Logger log = LogManager.getLogger((String)PortalMessageService.class.getName());

    public void createPortalMessage(PortalMessage var1);

    public void deletePortalMessage(Long var1);

    public List<PortalMessage> portalMessageList();

    public List<PortalMessage> portalMessageListEager();

    public List<PortalMessage> portalMessageList(Long var1);

    public List<PortalMessage> portalMessageListEager(Long var1);

    public PortalMessage portalMessageById(Long var1);

    public PortalMessage portalMessageByIdEager(Long var1);

    public void updatePortalMessage(PortalMessage var1);

    public List<PortalMessage> portalMessageByUserIdEager(Long var1);

    public List<PortalMessage> portalMessageByEmailEager(String var1);
}
