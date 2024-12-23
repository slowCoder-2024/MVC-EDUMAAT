/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletException
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.core.Authentication
 *  org.springframework.security.web.DefaultRedirectStrategy
 *  org.springframework.security.web.RedirectStrategy
 *  org.springframework.security.web.authentication.AuthenticationSuccessHandler
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.authenticationService;

import in.jdsoft.educationmanagement.school.model.InstitutionConfigDetails;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InstitutionConfigDetailsService;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler
implements AuthenticationSuccessHandler {
    @Autowired
    UserService userService;
    @Autowired
    InstitutionConfigDetailsService institutionConfigDetailsService;
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User customUser;
        block2: {
            HttpSession session = request.getSession();
            customUser = this.userService.userByEmailEager(request.getParameter("username"));
            InstitutionConfigDetails institutionConfigDetail = this.institutionConfigDetailsService.institutionConfigDetailsById(1L);
            session.setAttribute("institutionConfigDetailsId", (Object)institutionConfigDetail.getInstitutionConfigDetailsId());
            session.setAttribute("institutiontype", (Object)institutionConfigDetail.isMultiInstitutions());
            session.setAttribute("feeadminadmintype", (Object)institutionConfigDetail.getFeeCollectionAdminType());
            session.setAttribute("invandassetadmintype", (Object)institutionConfigDetail.getInventoryAndAssetAdminType());
            session.setAttribute("libraryadmintype", (Object)institutionConfigDetail.getLibraryAdminType());
            session.setAttribute("visitoradmintype", (Object)institutionConfigDetail.getVisitorAdminType());
            session.setAttribute("username", (Object)customUser.getEmail());
            session.setAttribute("name", (Object)customUser.getName());
            session.setAttribute("profile", (Object)customUser.getProfilePicturePath());
            session.setAttribute("instituteId", (Object)customUser.getInstitution().getInstitutionId());
            session.setAttribute("logo", (Object)customUser.getInstitution().getInstitutionLogo());
            session.setAttribute("authenticated", (Object)"false");
            session.setAttribute("theme", (Object)"themes/staff");
            session.setAttribute("institutioncurrency", (Object)customUser.getInstitution().getCurrencyCode());
            session.setAttribute("institutioncode", (Object)customUser.getInstitution().getInstitutionCode());
            session.setAttribute("institutionname", (Object)customUser.getInstitution().getInstitutionName());
            try {
                session.setAttribute("lastlogin", (Object)customUser.getLastLogin());
            }
            catch (NullPointerException e) {
                if (!e.getClass().equals(NullPointerException.class)) break block2;
                session.setAttribute("lastlogin", (Object)"Never");
            }
        }
        customUser.setLastLogin(new Timestamp(Calendar.getInstance().getTime().getTime()));
        this.userService.updateUser(customUser);
        this.redirectStrategy.sendRedirect(request, response, "/home");
    }

    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    public RedirectStrategy getRedirectStrategy() {
        return this.redirectStrategy;
    }
}
