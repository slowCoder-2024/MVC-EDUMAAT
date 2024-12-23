/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ReligionDAO;
import in.jdsoft.educationmanagement.school.model.Religion;
import in.jdsoft.educationmanagement.school.services.ReligionService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="religionService")
public class ReligionServiceImpl
implements ReligionService {
    @Autowired
    ReligionDAO religionDAO;

    @Override
    public void addReligion(Religion religion) {
        this.religionDAO.persist(religion);
    }

    @Override
    public ArrayList<Religion> getReligionList() {
        return (ArrayList)this.religionDAO.getList();
    }

    @Override
    public void deleteReligion(Long religionId) {
        this.religionDAO.delete(this.religionDAO.getReligionById(religionId));
    }

    @Override
    public void updateReligion(Religion religion) {
        this.religionDAO.update(religion);
    }

    @Override
    public Religion getReligionById(Long religionId) {
        return this.religionDAO.getReligionById(religionId);
    }
}
