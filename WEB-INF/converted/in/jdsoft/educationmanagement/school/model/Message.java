/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import org.apache.commons.lang.WordUtils;

public class Message {
    private String status;
    private String message;

    public Message(String status, String message) {
        this.status = status;
        this.message = WordUtils.capitalize((String)message);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = WordUtils.capitalize((String)message);
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
