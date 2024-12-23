/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.SponserDAO;
import in.jdsoft.educationmanagement.school.model.Sponser;
import in.jdsoft.educationmanagement.school.services.SponserService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="sponserService")
public class SponserServiceImpl
implements SponserService {
    @Autowired
    SponserDAO sponserDAO;

    @Override
    public void addSponser(Sponser sponser) {
        this.sponserDAO.persist(sponser);
    }

    @Override
    public ArrayList<Sponser> getSponserList() {
        return (ArrayList)this.sponserDAO.getList();
    }

    @Override
    public void deleteSponser(Long sponserId) {
        this.sponserDAO.delete(this.sponserDAO.getSponserById(sponserId));
    }

    @Override
    public void updateSponser(Sponser sponser) {
        this.sponserDAO.update(sponser);
    }

    @Override
    public Sponser getSponserById(Long sponserId) {
        return this.sponserDAO.getSponserById(sponserId);
    }
}
