/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionConfigDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.PrivilegeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.PrivilegeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="privilegeService")
public class PrivilegeServiceImpl
implements PrivilegeService {
    @Autowired
    PrivilegeDAO privilegeDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    InstitutionConfigDetailsDAO institutionConfigDetailsDAO;

    @Override
    public List<Privilege> privilegeList() {
        try {
            List<Privilege> privilegeList = this.privilegeDAO.getList();
            Integer privilegeSize = privilegeList.size();
            if (privilegeSize > 0) {
                log.info((Object)(privilegeSize + " privilege records where reterived"));
            } else {
                log.info((Object)"No privilege(s) available");
            }
            return privilegeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving privilege list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Privilege privilegeById(Long privilegeId) {
        try {
            Privilege privilege = this.privilegeDAO.getPrivilegeById(privilegeId);
            if (privilege != null) {
                log.info((Object)("privilege with id=" + privilegeId + " has been reterived"));
                return privilege;
            }
            log.info((Object)("No privilege with  id=" + privilegeId + " is available"));
            return privilege;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving privilege by id=" + privilegeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> staffAndAdminPrivileges() {
        ArrayList<Privilege> privilegeList = new ArrayList<Privilege>();
        try {
            privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("admin"));
            privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("staff"));
            return privilegeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving privileges of staff and admin", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> privilegesBasedOn(String email, Long institutionConfigDetailsId) {
        ArrayList<Privilege> privilegeList = new ArrayList<Privilege>();
        try {
            User user = this.userDAO.getUserByEmail(email);
            for (UserRole userRole : user.getUserRoles()) {
                if (userRole.getTargetType().equals("superadmin")) {
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("superadmin"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("admin"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("staff"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("superstaff"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("feesadmin"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("principal"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("inventoryandassetadmin"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("libraryadmin"));
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("visitoradmin"));
                }
                if (!userRole.getTargetType().equals("admin")) continue;
                InstitutionConfigDetails institutionConfigDetails = this.institutionConfigDetailsDAO.getInstitutionConfigDetailsById(institutionConfigDetailsId);
                if (institutionConfigDetails.getFeeCollectionAdminType() == 0) {
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("feesadmin"));
                }
                if (institutionConfigDetails.getInventoryAndAssetAdminType() == 0) {
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("inventoryandassetadmin"));
                }
                if (institutionConfigDetails.getLibraryAdminType() == 0) {
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("libraryadmin"));
                }
                if (institutionConfigDetails.getVisitorAdminType() == 0) {
                    privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("visitoradmin"));
                }
                privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("admin"));
                privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("staff"));
                privilegeList.addAll(this.privilegeDAO.privilegesByTargetType("principal"));
            }
            return privilegeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving privileges of staff and admin", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
