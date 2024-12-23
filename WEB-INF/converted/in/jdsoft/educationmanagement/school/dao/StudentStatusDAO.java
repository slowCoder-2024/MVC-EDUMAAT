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
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentStatusDAO
extends GenericDAO<StudentStatus> {
    public StudentStatusDAO() {
        super(StudentStatus.class);
    }

    public StudentStatus getStudentStatusById(Long id) {
        StudentStatus instance = (StudentStatus)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentStatus", (Serializable)id);
        return instance;
    }

    public StudentStatus getStudentStatusByName(String studentStatusTitle) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentStatus.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"statusTitle", (Object)studentStatusTitle)));
        StudentStatus studentStatus = (StudentStatus)criteria.uniqueResult();
        return studentStatus;
    }
}
