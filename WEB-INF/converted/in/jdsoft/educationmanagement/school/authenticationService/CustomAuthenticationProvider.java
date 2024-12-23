/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.authentication.AuthenticationProvider
 *  org.springframework.security.authentication.BadCredentialsException
 *  org.springframework.security.authentication.UsernamePasswordAuthenticationToken
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.core.AuthenticationException
 *  org.springframework.security.core.userdetails.UserDetails
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.authenticationService;

import in.jdsoft.educationmanagement.school.services.CustomUserDetailsService;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider
implements AuthenticationProvider {
    @Autowired
    CustomUserDetailsService customUserDetailService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String)authentication.getCredentials();
        UserDetails user = this.customUserDetailService.loadUserByUsername(username);
        if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
            throw new BadCredentialsException("Invalid User Name");
        }
        if (!user.getPassword().equals(password)) {
            throw new BadCredentialsException("Invalid Password");
        }
        Collection authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken((Object)user, (Object)user.getPassword(), authorities);
    }

    public boolean supports(Class<?> authentication) {
        return true;
    }
}
