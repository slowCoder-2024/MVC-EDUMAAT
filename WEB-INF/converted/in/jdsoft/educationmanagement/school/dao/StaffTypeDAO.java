/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffType;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffTypeDAO
extends GenericDAO<StaffType> {
    public StaffTypeDAO() {
        super(StaffType.class);
    }

    public StaffType getStaffTypeById(Long id) {
        StaffType instance = (StaffType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffType", (Serializable)id);
        return instance;
    }
}
