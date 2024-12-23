/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class FileUploadHandler {
    public File createFolderIfNotExist(String folderPath) {
        File fileDir = new File(folderPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public String uploadFile(byte[] bytes, String applicationRoot, String folderPath, String fileName) throws IOException {
        try (FilterOutputStream stream = null;){
            String location = String.valueOf(applicationRoot) + "/" + folderPath;
            String changedFileName = Long.toString(System.currentTimeMillis()).concat(fileName);
            String savePath = String.valueOf(folderPath) + changedFileName;
            File f = this.createFolderIfNotExist(location);
            File file = new File(f, changedFileName);
            stream = new BufferedOutputStream(new FileOutputStream(file));
            stream.write(bytes);
            String string = savePath;
            return string;
        }
    }
}
