/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Component
 */
package in.jdsoft.educationmanagement.school.components;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
    private static Long admissionNumber = 4999L;

    public Long generateAdmissionNumber() {
        Random rand = new Random();
        Integer randLong = rand.nextInt(999999);
        admissionNumber = admissionNumber + (long)randLong.intValue();
        return admissionNumber;
    }
}
