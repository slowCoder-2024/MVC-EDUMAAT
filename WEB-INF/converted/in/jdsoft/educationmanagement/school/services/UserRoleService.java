/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.UserRoleException;
import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRoleService {
    public static final Logger log = LogManager.getLogger((String)UserService.class.getName());

    public Long createUserRole(UserRole var1);

    public void deleteUserRole(Long var1);

    public List<UserRole> userRoleList();

    public List<UserRole> userRoleList(Long var1) throws UserRoleException;

    public UserRole userRoleById(Long var1);

    public UserRole userRoleByIdEager(Long var1);

    public void updateUserRole(UserRole var1);

    public List<Privilege> privilegesByTargetType(String var1);

    public List<Privilege> defaultAdminPrivileges();

    public List<Privilege> defaultStaffPrivileges();

    public List<Privilege> defaultStudentPrivileges();

    public List<Privilege> defaultParentPrivileges();

    public List<UserRole> userRolesForStaffs(Long var1);

    public List<UserRole> nonDefaultUserRoles(Long var1);

    public List<Privilege> defaultPrincipalPrivileges();

    public List<UserRole> userRolesForSuperStaffsOrStaffs(Long var1);

    public UserRole userRoleBy(String var1, Long var2);
}
