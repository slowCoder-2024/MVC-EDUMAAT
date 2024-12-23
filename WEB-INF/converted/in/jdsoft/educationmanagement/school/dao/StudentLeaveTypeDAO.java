/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentLeaveType;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StudentLeaveTypeDAO
extends GenericDAO<StudentLeaveType> {
    public StudentLeaveTypeDAO() {
        super(StudentLeaveType.class);
    }

    public StudentLeaveType getStudentLeaveTypeById(Long id) {
        StudentLeaveType instance = (StudentLeaveType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentLeaveType", (Serializable)id);
        return instance;
    }
}
