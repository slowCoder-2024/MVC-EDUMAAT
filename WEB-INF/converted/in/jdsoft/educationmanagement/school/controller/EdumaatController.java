/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.model.Message;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller(value="edumaatController")
@RequestMapping(value={"/edumaat"})
public class EdumaatController {
    @Autowired
    EmailHandler emailHandler;

    @RequestMapping(method={RequestMethod.GET}, value={"/helpdesk"})
    public ModelAndView displayVisitorPage(HttpServletRequest request) throws Exception {
        return new ModelAndView("helpdesk");
    }

    @RequestMapping(method={RequestMethod.POST}, value={"issue/add"})
    public String createIssue(HttpServletRequest request, RedirectAttributes redirectAttributes, @RequestParam(value="attachment") MultipartFile attachment) {
        try {
            String cc = request.getParameter("cc");
            String message = request.getParameter("message");
            this.emailHandler.sendEmail("arun.balaji@jdsoft.in", cc, "arunbalajicse@gmail.com", "Help Desk", message, attachment);
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", " Email Send Successfully...!"));
            return "redirect:/edumaat/helpdesk";
        }
        catch (Exception e) {
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("failure", "Mail not sended...!"));
            e.printStackTrace();
            return "redirect:/edumaat/helpdesk";
        }
    }
}
