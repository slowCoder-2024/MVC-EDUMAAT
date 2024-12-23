/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CommunicationMessageModeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.dao.UserRoleDAO;
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.CommunicationMessageModeService;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="CommunicationMessageModeService")
public class CommunicationMessageModeServiceImpl
implements CommunicationMessageModeService {
    @Autowired
    CommunicationMessageModeDAO CommunicationMessageModeDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    UserRoleDAO userRoleDAO;

    @Override
    public List<CommunicationMessageMode> communicationMessageModeList() {
        try {
            List<CommunicationMessageMode> communicationMessageModeList = this.CommunicationMessageModeDAO.getList();
            Integer communicationMessageModeSize = communicationMessageModeList.size();
            if (communicationMessageModeSize > 0) {
                log.info((Object)(communicationMessageModeSize + " CommunicationMessageMode records where reterived"));
            } else {
                log.info((Object)"No CommunicationMessageMode(s) available");
            }
            return communicationMessageModeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving CommunicationMessageMode list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationMessageMode communicationMessageModeById(Long communicationMessageModeId) {
        try {
            CommunicationMessageMode communicationMessageMode = this.CommunicationMessageModeDAO.getCommunicationMessageModeById(communicationMessageModeId);
            if (communicationMessageMode != null) {
                log.info((Object)("CommunicationMessageMode with id=" + communicationMessageModeId + " has been reterived"));
                return communicationMessageMode;
            }
            log.info((Object)("No CommunicationMessageMode with  id=" + communicationMessageModeId + " is available"));
            return communicationMessageMode;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving CommunicationMessageMode by id=" + communicationMessageModeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationMessageMode> communicationMessageModeList(String userEmail) {
        try {
            List<CommunicationMessageMode> communicationMessageModeList = this.CommunicationMessageModeDAO.getList();
            Integer communicationMessageModeSize = communicationMessageModeList.size();
            if (communicationMessageModeSize > 0) {
                Iterator communicationMessageModes = communicationMessageModeList.iterator();
                while (communicationMessageModes.hasNext()) {
                    CommunicationMessageMode communicationMessageMode = (CommunicationMessageMode)communicationMessageModes.next();
                    User user = this.userDAO.getUserByEmail(userEmail);
                    Hibernate.initialize(user.getUserRoles());
                    for (UserRole userRole : user.getUserRoles()) {
                        if (userRole.getTargetType().equals("admin") || userRole.getTargetType().equals("staff") || userRole.getTargetType().equals("superadmin") || userRole.getTargetType().equals("principal") || userRole.getTargetType().equals("feesadmin") || userRole.getTargetType().equals("inventoryandassetadmin") || userRole.getTargetType().equals("visitoradmin") || userRole.getTargetType().equals("libraryadmin") || userRole.getTargetType().equals("superstaff") || communicationMessageMode.getCommunicationMessageModeId() != 1L) continue;
                        communicationMessageModes.remove();
                    }
                }
                log.info((Object)(communicationMessageModeSize + " CommunicationMessageMode records where reterived"));
            } else {
                log.info((Object)"No CommunicationMessageMode(s) available");
            }
            return communicationMessageModeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving CommunicationMessageMode list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
