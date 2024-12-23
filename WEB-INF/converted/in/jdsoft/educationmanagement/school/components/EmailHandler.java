/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.mail.internet.MimeMessage
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.core.io.InputStreamSource
 *  org.springframework.mail.SimpleMailMessage
 *  org.springframework.mail.javamail.JavaMailSender
 *  org.springframework.mail.javamail.MimeMessageHelper
 *  org.springframework.stereotype.Component
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.IOException;
import java.io.InputStream;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class EmailHandler {
    @Autowired
    JavaMailSender mailSender;
    private static String mailTo;
    private static String mailFrom;
    private static String message;
    private static String projectPath;

    public JavaMailSender getMailSender() {
        return this.mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        EmailHandler.mailTo = mailTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        EmailHandler.message = message;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        EmailHandler.mailFrom = mailFrom;
    }

    public void sendEmail(String mailTo, String subject, String message) throws Exception {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(mailTo);
            msg.setFrom(mailFrom);
            msg.setText(message);
            msg.setSubject(subject);
            this.mailSender.send(msg);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void sendEmail(String[] mailTo, String subject, String message) throws Exception {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(mailTo);
            msg.setFrom(mailFrom);
            msg.setSubject(subject);
            msg.setText(message);
            this.mailSender.send(msg);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public String getProjectPath() {
        projectPath = "http://123.63.174.115:8080/";
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        EmailHandler.projectPath = projectPath;
    }

    public void sendEmail(String to, String cc, String subject, String content) throws Exception {
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            if (!cc.isEmpty()) {
                mimeMessageHelper.setCc(cc);
            }
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            this.mailSender.send(mimeMessage);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void sendEmail(String to, String cc, String bcc, String subject, String content, final MultipartFile attachFile) throws Exception {
        try {
            MimeMessage mimeMessage = this.mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            if (!cc.isEmpty()) {
                mimeMessageHelper.setCc(cc);
            }
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content, true);
            mimeMessageHelper.setBcc(bcc);
            String attachName = attachFile.getOriginalFilename();
            if (!attachFile.isEmpty()) {
                mimeMessageHelper.addAttachment(attachName, new InputStreamSource(){

                    public InputStream getInputStream() throws IOException {
                        return attachFile.getInputStream();
                    }
                });
            }
            this.mailSender.send(mimeMessage);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
