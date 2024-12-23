/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Religion;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReligionService {
    public void addReligion(Religion var1);

    public ArrayList<Religion> getReligionList();

    public void deleteReligion(Long var1);

    public void updateReligion(Religion var1);

    public Religion getReligionById(Long var1);
}
