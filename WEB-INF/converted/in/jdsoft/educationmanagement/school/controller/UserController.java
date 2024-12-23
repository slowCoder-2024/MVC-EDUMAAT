/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.ResponseBody
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.exceptions.UserServiceExceptions;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.UserService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="userController")
@RequestMapping(value={"/user"})
public class UserController {
    private Logger log = LogManager.getLogger((String)UserController.class.getName());
    @Autowired
    UserService userService;

    @RequestMapping(method={RequestMethod.GET}, value={"/{id}"})
    @ResponseBody
    public User viewRetrieve(@PathVariable(value="id") Long userId, HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving User with id=" + userId));
            User user = this.userService.userById(userId);
            return user;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/userdetails"})
    @ResponseBody
    public User getUserDetail(HttpServletRequest request) {
        User user;
        block4: {
            try {
                user = null;
                HttpSession session = request.getSession();
                if (session != null) break block4;
                return null;
            }
            catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        String email = request.getSession().getAttribute("username").toString();
        if (!email.isEmpty() && email != null) {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving User"));
            user = this.userService.userByEmailEager(email);
        }
        return user;
    }

    @RequestMapping(method={RequestMethod.GET}, value={"/list"})
    @ResponseBody
    public List<User> viewRetrieve(HttpServletRequest request) {
        try {
            this.log.info((Object)("User " + request.getSession().getAttribute("username").toString() + " reteriving Users"));
            List<User> user = this.userService.userList();
            return user;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"forgotPassword"}, method={RequestMethod.POST})
    public String forgotPassword(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
        try {
            String userEmail = request.getParameter("e_mail");
            this.userService.resetPasswordByEmail(userEmail);
            attributes.addFlashAttribute("message", (Object)new Message("success", "Your login details have been send to your e-mail successfully"));
            return "redirect:/";
        }
        catch (Exception e) {
            if (e.getClass().equals(UserServiceExceptions.class)) {
                UserServiceExceptions userex = (UserServiceExceptions)e;
                attributes.addFlashAttribute("message", (Object)userex.getCustomMessage());
                return "redirect:/";
            }
            throw e;
        }
    }
}
