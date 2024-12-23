/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.core.io.InputStreamSource
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.components;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamSource;
import org.springframework.web.multipart.MultipartFile;

class EmailHandler.1
implements InputStreamSource {
    private final /* synthetic */ MultipartFile val$attachFile;

    EmailHandler.1(MultipartFile multipartFile) {
        this.val$attachFile = multipartFile;
    }

    public InputStream getInputStream() throws IOException {
        return this.val$attachFile.getInputStream();
    }
}
