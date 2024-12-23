/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CommunicationTargetGroupDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.CommunicationTargetGroupService;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="CommunicationTargetGroupService")
public class CommunicationTargetGroupServiceImpl
implements CommunicationTargetGroupService {
    @Autowired
    CommunicationTargetGroupDAO CommunicationTargetGroupDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public List<CommunicationTargetGroup> communicationTargetGroupList() {
        try {
            List<CommunicationTargetGroup> communicationTargetGroupList = this.CommunicationTargetGroupDAO.getList();
            Integer communicationTargetGroupSize = communicationTargetGroupList.size();
            if (communicationTargetGroupSize > 0) {
                log.info((Object)(communicationTargetGroupSize + " CommunicationTargetGroup records where reterived"));
            } else {
                log.info((Object)"No CommunicationTargetGroup(s) available");
            }
            return communicationTargetGroupList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving CommunicationTargetGroup list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CommunicationTargetGroup communicationTargetGroupById(Long communicationTargetGroupId) {
        try {
            CommunicationTargetGroup communicationTargetGroup = this.CommunicationTargetGroupDAO.getCommunicationTargetGroupById(communicationTargetGroupId);
            if (communicationTargetGroup != null) {
                log.info((Object)("CommunicationTargetGroup with id=" + communicationTargetGroupId + " has been reterived"));
                return communicationTargetGroup;
            }
            log.info((Object)("No CommunicationTargetGroup with  id=" + communicationTargetGroupId + " is available"));
            return communicationTargetGroup;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving CommunicationTargetGroup by id=" + communicationTargetGroupId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CommunicationTargetGroup> communicationTargetGroupList(String eMail) {
        try {
            List<CommunicationTargetGroup> communicationTargetGroupList = this.CommunicationTargetGroupDAO.getList();
            Integer communicationTargetGroupSize = communicationTargetGroupList.size();
            if (communicationTargetGroupSize > 0) {
                Iterator communicationTargetGroups = communicationTargetGroupList.iterator();
                while (communicationTargetGroups.hasNext()) {
                    CommunicationTargetGroup communicationTargetGroup = (CommunicationTargetGroup)communicationTargetGroups.next();
                    User user = this.userDAO.getUserByEmail(eMail);
                    Hibernate.initialize(user.getUserRoles());
                    for (UserRole userRole : user.getUserRoles()) {
                        if (!(userRole.getTargetType().equals("admin") || userRole.getTargetType().equals("superadmin") || userRole.getTargetType().equals("principal"))) {
                            if (userRole.getTargetType().equals("student")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 9L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("staff")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 9L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("parent")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 9L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("feesadmin")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 9L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 5L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("inventoryandassetadmin")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 9L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 5L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("visitoradmin")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 9L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("libraryadmin")) {
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 9L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L) {
                                    communicationTargetGroups.remove();
                                    continue;
                                }
                                if (communicationTargetGroup.getCommunicationTargetGroupId() != 5L) continue;
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (!userRole.getTargetType().equals("superstaff")) continue;
                            if (communicationTargetGroup.getCommunicationTargetGroupId() == 1L) {
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (communicationTargetGroup.getCommunicationTargetGroupId() == 8L) {
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (communicationTargetGroup.getCommunicationTargetGroupId() == 9L) {
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (communicationTargetGroup.getCommunicationTargetGroupId() == 4L) {
                                communicationTargetGroups.remove();
                                continue;
                            }
                            if (communicationTargetGroup.getCommunicationTargetGroupId() != 5L) continue;
                            communicationTargetGroups.remove();
                            continue;
                        }
                        if (!userRole.getTargetType().equals("admin") && !userRole.getTargetType().equals("superadmin") && !userRole.getTargetType().equals("principal") || communicationTargetGroup.getCommunicationTargetGroupId() != 9L) continue;
                        communicationTargetGroups.remove();
                    }
                }
                log.info((Object)(communicationTargetGroupSize + " CommunicationTargetGroup records where reterived"));
            } else {
                log.info((Object)"No CommunicationTargetGroup(s) available");
            }
            return communicationTargetGroupList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving CommunicationTargetGroup list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
