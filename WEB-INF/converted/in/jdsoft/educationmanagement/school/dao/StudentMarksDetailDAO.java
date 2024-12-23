/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StudentMarksDetailDAO
extends GenericDAO<StudentMarksDetail> {
    public StudentMarksDetailDAO() {
        super(StudentMarksDetail.class);
    }

    public StudentMarksDetail getStudentMarksDetailById(Long id) {
        StudentMarksDetail instance = (StudentMarksDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMarksDetail", (Serializable)id);
        return instance;
    }
}
