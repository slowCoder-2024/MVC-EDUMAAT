/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class HashGenerator {
    public String encoder(String s) {
        BCryptPasswordEncoder pencode = new BCryptPasswordEncoder();
        return pencode.encode((CharSequence)s);
    }
}
