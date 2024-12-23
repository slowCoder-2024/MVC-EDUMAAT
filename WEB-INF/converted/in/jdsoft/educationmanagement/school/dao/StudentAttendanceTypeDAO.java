/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentAttendanceTypeDAO
extends GenericDAO<StudentAttendanceType> {
    public StudentAttendanceTypeDAO() {
        super(StudentAttendanceType.class);
    }

    public StudentAttendanceType getStudentAttendanceTypeById(Long id) {
        StudentAttendanceType instance = (StudentAttendanceType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentAttendanceType", (Serializable)id);
        return instance;
    }

    public StudentAttendanceType getStudentAttendanceTypeByName(String attendanceTypeName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendanceType.class);
        criteria.add((Criterion)Restrictions.eq((String)"studentAttendanceTypeName", (Object)attendanceTypeName));
        StudentAttendanceType studentAttendanceType = (StudentAttendanceType)criteria.uniqueResult();
        return studentAttendanceType;
    }
}
