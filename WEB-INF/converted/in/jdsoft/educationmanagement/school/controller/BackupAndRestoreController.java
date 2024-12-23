/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  org.apache.commons.dbcp.BasicDataSource
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.stereotype.Controller
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RequestMethod
 *  org.springframework.web.bind.annotation.RequestParam
 *  org.springframework.web.multipart.MultipartFile
 *  org.springframework.web.servlet.ModelAndView
 *  org.springframework.web.servlet.mvc.support.RedirectAttributes
 */
package in.jdsoft.educationmanagement.school.controller;

import in.jdsoft.educationmanagement.school.components.BackUpComponent;
import in.jdsoft.educationmanagement.school.components.BackUpComponent2;
import in.jdsoft.educationmanagement.school.model.Message;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value={"/BackupAndRestore"})
public class BackupAndRestoreController {
    @Autowired
    BackUpComponent backUpComponent;
    @Autowired
    BasicDataSource basicDataSource;
    @Autowired
    BackUpComponent2 backUpComponent2;

    @RequestMapping
    @PreAuthorize(value="hasAuthority('backup')")
    public ModelAndView displayBackupAndRestore(HttpServletRequest request) {
        try {
            ModelAndView modelandview = new ModelAndView("backupandrecover");
            return modelandview;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value={"backup"}, method={RequestMethod.POST})
    public String Backup(HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        try {
            Properties prop = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/db.properties");
            prop.load(in);
            String db_name = prop.getProperty("db.databasename");
            try {
                byte[] data1 = this.backUpComponent2.getData("localhost", "3306", this.basicDataSource.getUsername(), this.basicDataSource.getPassword(), db_name).getBytes();
                File f = this.backUpComponent.createFolderIfNotExist(request.getRealPath("/resources/backup/"));
                File file = new File(f, this.backUpComponent.FileName());
                FileOutputStream dest = new FileOutputStream(file);
                ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(dest));
                zip.setMethod(8);
                zip.setLevel(9);
                zip.putNextEntry(new ZipEntry("data.sql"));
                zip.write(data1);
                zip.close();
                dest.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            redirectAttributes.addFlashAttribute("alert", (Object)new Message("success", "BackUp Done"));
            return "redirect:/BackupAndRestore";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "redirect:/BackupAndRestore";
        }
    }

    @RequestMapping(value={"restore"}, method={RequestMethod.POST})
    public String Restore(HttpServletRequest request, @RequestParam(value="restorefile") MultipartFile multipartFile) throws Exception {
        try {
            String str = multipartFile.getOriginalFilename();
            str = str.replaceAll("[0-9]", "");
            try {
                String line;
                String[] cmd = new String[]{"C:\\xampp\\mysql\\bin\\mysql", "edumaat_db", "--user=edumaat", "--password=edumaat", "-e", "\"source " + str + "\""};
                Process proc = Runtime.getRuntime().exec(cmd);
                InputStream inputstream = proc.getInputStream();
                InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
                BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
                while ((line = bufferedreader.readLine()) != null) {
                    System.out.println(line);
                }
                try {
                    if (proc.waitFor() != 0) {
                        System.err.println("exit value = " + proc.exitValue());
                    }
                }
                catch (InterruptedException e) {
                    System.err.println(e);
                    throw e;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return "redirect:/BackupAndRestore";
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
