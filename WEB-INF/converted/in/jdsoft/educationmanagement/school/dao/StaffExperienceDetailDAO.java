/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffExperienceDetail;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffExperienceDetailDAO
extends GenericDAO<StaffExperienceDetail> {
    public StaffExperienceDetailDAO() {
        super(StaffExperienceDetail.class);
    }

    public StaffExperienceDetail getStaffExperienceDetailById(Long id) {
        StaffExperienceDetail instance = (StaffExperienceDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffExperienceDetail", (Serializable)id);
        return instance;
    }
}
