/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.HearedUs;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface HearedUsService {
    public void addHearedUs(HearedUs var1);

    public ArrayList<HearedUs> getHearedUsList();

    public void deleteHearedUs(Long var1);

    public void updateHearedUs(HearedUs var1);

    public HearedUs getHearedUsById(Long var1);
}
