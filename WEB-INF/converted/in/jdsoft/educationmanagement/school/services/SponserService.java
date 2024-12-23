/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Sponser;
import java.util.ArrayList;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SponserService {
    public void addSponser(Sponser var1);

    public ArrayList<Sponser> getSponserList();

    public void deleteSponser(Long var1);

    public void updateSponser(Sponser var1);

    public Sponser getSponserById(Long var1);
}
