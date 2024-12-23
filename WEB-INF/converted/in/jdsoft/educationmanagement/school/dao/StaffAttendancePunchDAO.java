/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffAttendancePunch;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAttendancePunchDAO
extends GenericDAO<StaffAttendancePunch> {
    public StaffAttendancePunchDAO() {
        super(StaffAttendancePunch.class);
    }

    public StaffAttendancePunch getStaffAttendancePunchById(Long id) {
        StaffAttendancePunch instance = (StaffAttendancePunch)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffAttendancePunch", (Serializable)id);
        return instance;
    }
}
