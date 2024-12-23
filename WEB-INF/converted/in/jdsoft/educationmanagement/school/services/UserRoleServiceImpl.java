/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PrivilegeDAO;
import in.jdsoft.educationmanagement.school.dao.UserRoleDAO;
import in.jdsoft.educationmanagement.school.exceptions.UserRoleException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="userRoleService")
public class UserRoleServiceImpl
implements UserRoleService {
    @Autowired
    private UserRoleDAO userRoleDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private PrivilegeDAO privilegeDAO;

    @Override
    public Long createUserRole(UserRole userRole) {
        try {
            UserRole persistedUserRole = this.userRoleDAO.save(userRole);
            Long userRoleId = persistedUserRole.getRoleId();
            log.info((Object)("User Role created with the id=" + userRoleId));
            return userRoleId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating User Role", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteUserRole(Long userRoleId) {
        try {
            UserRole userRole = this.userRoleDAO.getUserRoleById(userRoleId);
            if (userRole != null) {
                this.userRoleDAO.delete(userRole);
                log.info((Object)("User Role with id=" + userRoleId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting User Role", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserRole> userRoleList() {
        try {
            List<UserRole> userRoleList = this.userRoleDAO.getList();
            Integer userRoleListSize = userRoleList.size();
            if (userRoleListSize > 0) {
                log.info((Object)(userRoleListSize + " user role records where reterived"));
            } else {
                log.info((Object)"No user role list available");
            }
            return userRoleList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving user role list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserRole> userRoleList(Long institutionId) throws UserRoleException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<UserRole> userRoles = this.userRoleDAO.getUserRoleByInstitution(institution);
                Integer userRolesSize = userRoles.size();
                if (userRolesSize > 0) {
                    log.info((Object)(userRolesSize + " user roles records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No user roles Records found for institution " + institution.getInstitutionAliasName()));
                }
                return userRoles;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new UserRoleException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving  user roles of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserRole userRoleById(Long userRoleId) {
        try {
            UserRole userRole = this.userRoleDAO.getUserRoleById(userRoleId);
            if (userRole != null) {
                log.info((Object)("User Role with id=" + userRoleId + " has been reterived"));
                return userRole;
            }
            log.info((Object)("No User Role with  id=" + userRoleId + " is available"));
            return userRole;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user role by id=" + userRoleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserRole userRoleByIdEager(Long userRoleId) {
        try {
            UserRole userRole = this.userRoleDAO.getUserRoleById(userRoleId);
            if (userRole != null) {
                Hibernate.initialize(userRole.getPrivileges());
                Hibernate.initialize((Object)userRole.getInstitution());
                Hibernate.initialize(userRole.getUsers());
                log.info((Object)("User Role with id=" + userRoleId + " has been reterived with childs"));
                return userRole;
            }
            log.info((Object)("No User Role with  id=" + userRoleId + " is available"));
            return userRole;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving user role with childs by id=" + userRoleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        try {
            this.userRoleDAO.saveOrUpdate(userRole);
            Long roleId = userRole.getRoleId();
            if (roleId != null) {
                log.info((Object)("User Role with id=" + roleId + " has been updated"));
            } else {
                log.info((Object)"New User Role has been added, because no user role found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating user role", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> defaultAdminPrivileges() {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType("admin");
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving admin default privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> defaultStaffPrivileges() {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType("staff");
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff default privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> defaultStudentPrivileges() {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType("student");
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving student default privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> defaultParentPrivileges() {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType("parent");
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving parent default privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> privilegesByTargetType(String type) {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType(type);
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserRole> userRolesForStaffs(Long institutionId) {
        ArrayList<UserRole> roles = new ArrayList<UserRole>();
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "principal"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "admin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "staff"));
            return roles;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff user roles", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserRole> userRolesForSuperStaffsOrStaffs(Long institutionId) {
        ArrayList<UserRole> roles = new ArrayList<UserRole>();
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "feesadmin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "superadmin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "superstaff"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "inventoryandassetadmin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "libraryadmin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "visitoradmin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "principal"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "admin"));
            roles.addAll(this.userRoleDAO.getUserRolesByTargetTypeAndInstitution(institution, "staff"));
            return roles;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff user roles", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<UserRole> nonDefaultUserRoles(Long institutionId) {
        ArrayList<UserRole> roles = new ArrayList();
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            roles = this.userRoleDAO.nonDefaultUserRoles(institution);
            return roles;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving non default user roles", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Privilege> defaultPrincipalPrivileges() {
        List<Privilege> privileges = null;
        try {
            privileges = this.privilegeDAO.privilegesByTargetType("principal");
            return privileges;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving principal default privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public UserRole userRoleBy(String targetType, Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            return this.userRoleDAO.getUserRoleByTargetTypeAndInstitution(institution, targetType);
        }
        catch (Exception e) {
            log.error((Object)"Exception in privileges", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
