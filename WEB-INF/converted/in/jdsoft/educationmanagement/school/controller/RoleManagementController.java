/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.controller.ModuleController;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Privilege;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.InstitutionService;
import in.jdsoft.educationmanagement.school.services.PrivilegeService;
import in.jdsoft.educationmanagement.school.services.UserRoleService;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="roleManagementController")
@RequestMapping(value={"/rolemanagement"})
public class RoleManagementController {
    private Logger log = LogManager.getLogger((String)ModuleController.class.getName());
    @Autowired
    PrivilegeService privilegeService;
    @Autowired
    InstitutionService institutionService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(method={RequestMethod.GET})
    @PreAuthorize(value="hasAuthority('rolemanagement')")
    public ModelAndView displayRoleManagementPage(HttpServletRequest request) throws Exception {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " has viewed role management page"));
            ModelAndView modelandview = new ModelAndView("rolemanagement");
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            modelandview.addObject("privileges", this.privilegeService.privilegesBasedOn(request.getSession().getAttribute("username").toString(), Long.parseLong(request.getSession().getAttribute("institutionConfigDetailsId").toString())));
            modelandview.addObject("userRoles", this.userRoleService.nonDefaultUserRoles(institutionId));
            return modelandview;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception", e.getCause());
            throw e;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/add"})
    @PreAuthorize(value="hasAuthority('rolemanagement/add')")
    public String createUserRole(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " trying to create new user role"));
            String userRoleName = request.getParameter("roleName");
            String[] privilegeId = request.getParameterValues("selectedPrivilegeId");
            HashSet<Privilege> privileges = new HashSet<Privilege>();
            String[] stringArray = privilegeId;
            int n = privilegeId.length;
            int n2 = 0;
            while (n2 < n) {
                String privilege = stringArray[n2];
                String[] privilegeeId = privilege.split(",");
                int i = 0;
                while (i < privilegeeId.length) {
                    privileges.add(this.privilegeService.privilegeById(Long.parseLong(privilegeeId[i])));
                    ++i;
                }
                ++n2;
            }
            Long institutionId = Long.parseLong(request.getSession().getAttribute("instituteId").toString());
            Institution institution = this.institutionService.institutionById(institutionId);
            UserRole userRole = new UserRole(userRoleName, institution, privileges, "staff", false);
            this.userRoleService.createUserRole(userRole);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Role Created Successfully...!"));
            return "redirect:/rolemanagement";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/rolemanagement";
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    @PreAuthorize(value="hasAuthority('rolemanagement/view')")
    public UserRole userRoleById(@PathVariable(value="id") Long userRoleId, HttpServletRequest request) {
        UserRole userRole = null;
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving user role with id=" + userRoleId));
            userRole = this.userRoleService.userRoleByIdEager(userRoleId);
            return userRole;
        }
        catch (Exception e) {
            return userRole;
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/update"})
    @PreAuthorize(value="hasAuthority('rolemanagement/update')")
    public String updateUserRole(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            String[] privilegeIds;
            Long userRoleId = Long.parseLong(request.getParameter("updateUserRoleId"));
            UserRole userRole = this.userRoleService.userRoleByIdEager(userRoleId);
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " updating userrole with id=" + userRoleId));
            String roleName = request.getParameter("editRoleName");
            userRole.setRoleName(roleName);
            userRole.getPrivileges().clear();
            String[] stringArray = privilegeIds = request.getParameterValues("selectedEditPrivilegeId");
            int n = privilegeIds.length;
            int n2 = 0;
            while (n2 < n) {
                String privilege = stringArray[n2];
                String[] privilegeeId = privilege.split(",");
                int i = 0;
                while (i < privilegeeId.length) {
                    Privilege selectedprivilege = this.privilegeService.privilegeById(Long.parseLong(privilegeeId[i]));
                    userRole.getPrivileges().add(selectedprivilege);
                    ++i;
                }
                ++n2;
            }
            this.userRoleService.updateUserRole(userRole);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Role Updated Successfully...!"));
            return "redirect:/rolemanagement";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/rolemanagement";
        }
    }

    @RequestMapping(method={RequestMethod.POST}, value={"/delete"})
    @PreAuthorize(value="hasAuthority('rolemanagement/delete')")
    public String deleteUserRole(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            Long userRoleId = Long.parseLong(request.getParameter("deleteUserRoleId"));
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " deleting user role with id=" + userRoleId));
            this.userRoleService.deleteUserRole(userRoleId);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "Role Deleted Successfully...!"));
            return "redirect:/rolemanagement";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Cannot Be Done...!"));
            e.printStackTrace();
            return "redirect:/rolemanagement";
        }
    }
}
