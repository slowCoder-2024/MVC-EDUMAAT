/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAttendanceConfigurationDAO
extends GenericDAO<StaffAttendanceConfiguration> {
    public StaffAttendanceConfiguration getStaffAttendanceConfigurationById(Long id) {
        StaffAttendanceConfiguration instance = (StaffAttendanceConfiguration)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffAttendanceConfiguration", (Serializable)id);
        return instance;
    }
}
