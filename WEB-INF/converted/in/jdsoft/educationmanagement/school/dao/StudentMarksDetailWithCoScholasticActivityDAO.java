/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticActivity;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StudentMarksDetailWithCoScholasticActivityDAO
extends GenericDAO<StudentMarksDetailWithCoScholasticActivity> {
    public StudentMarksDetailWithCoScholasticActivityDAO() {
        super(StudentMarksDetailWithCoScholasticActivity.class);
    }

    public StudentMarksDetailWithCoScholasticActivity getStudentMarksDetailWithCoScholasticActivityById(Long id) {
        StudentMarksDetailWithCoScholasticActivity instance = (StudentMarksDetailWithCoScholasticActivity)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticActivity", (Serializable)id);
        return instance;
    }
}
