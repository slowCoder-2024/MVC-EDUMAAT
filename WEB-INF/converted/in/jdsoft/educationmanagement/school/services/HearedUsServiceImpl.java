/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.HearedUsDAO;
import in.jdsoft.educationmanagement.school.model.HearedUs;
import in.jdsoft.educationmanagement.school.services.HearedUsService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="hearedUsService")
public class HearedUsServiceImpl
implements HearedUsService {
    @Autowired
    HearedUsDAO hearedUsDAO;

    @Override
    public void addHearedUs(HearedUs hearedUs) {
        this.hearedUsDAO.persist(hearedUs);
    }

    @Override
    public ArrayList<HearedUs> getHearedUsList() {
        return (ArrayList)this.hearedUsDAO.getList();
    }

    @Override
    public void deleteHearedUs(Long hearedUsId) {
        this.hearedUsDAO.delete(this.hearedUsDAO.getHearedUsById(hearedUsId));
    }

    @Override
    public void updateHearedUs(HearedUs hearedUs) {
        this.hearedUsDAO.update(hearedUs);
    }

    @Override
    public HearedUs getHearedUsById(Long hearedUsId) {
        return this.hearedUsDAO.getHearedUsById(hearedUsId);
    }
}
