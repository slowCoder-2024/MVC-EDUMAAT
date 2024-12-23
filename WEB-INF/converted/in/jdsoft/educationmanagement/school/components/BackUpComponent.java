/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class BackUpComponent {
    static int BUFFER = 0xA00000;

    public String getData(String host, String port, String user, String password, String db) throws Exception {
        int count;
        Process run = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump --host=" + host + " --port=" + port + " --user=" + user + " --password=" + password + " --compact --databases --add-drop-table --complete-insert --extended-insert " + "--skip-comments --skip-triggers " + db);
        InputStream in = run.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuffer temp = new StringBuffer();
        char[] cbuf = new char[BUFFER];
        while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
            temp.append(cbuf, 0, count);
        }
        br.close();
        in.close();
        return temp.toString();
    }

    public File createFolderIfNotExist(String folderPath) {
        File fileDir = new File(folderPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public String FileName() {
        String filename = "backup.sql";
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = df.format(new Date());
        date = date.replaceAll("/", "");
        date = date.replaceAll(":", "");
        date = date.replaceAll(" ", "");
        return String.valueOf(date) + filename;
    }

    public String ChangedFileName(String str) {
        str = str.replaceAll("[0-9]", "");
        return str;
    }
}
