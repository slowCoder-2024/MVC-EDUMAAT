/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.core.GrantedAuthority
 *  org.springframework.security.core.authority.SimpleGrantedAuthority
 *  org.springframework.security.core.userdetails.User
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.security.core.userdetails.UserDetailsService
 *  org.springframework.security.core.userdetails.UsernameNotFoundException
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
implements UserDetailsService {
    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        User user = this.userService.userWithRolesAndPrivileges(emailId);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email Id");
        }
        boolean status = false;
        if (user.getStatus() == 1) {
            status = true;
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), status, true, true, true, this.getAuthorities(user.getUserRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<UserRole> userRoles) {
        return this.getGrantedAuthorities(this.getPrivileges(userRoles));
    }

    private List<String> getPrivileges(Collection<UserRole> userRoles) {
        ArrayList<String> privileges = new ArrayList<String>();
        ArrayList<Privilege> collection = new ArrayList<Privilege>();
        for (UserRole role : userRoles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getPrivilegeName());
        }
        return privileges;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String privilege : privileges) {
            authorities.add((GrantedAuthority)new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
