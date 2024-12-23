/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StaffLeaveType;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StaffLeaveTypeDAO
extends GenericDAO<StaffLeaveType> {
    public StaffLeaveTypeDAO() {
        super(StaffLeaveType.class);
    }

    public StaffLeaveType getStaffLeaveTypeById(Long id) {
        StaffLeaveType instance = (StaffLeaveType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffLeaveType", (Serializable)id);
        return instance;
    }
}
