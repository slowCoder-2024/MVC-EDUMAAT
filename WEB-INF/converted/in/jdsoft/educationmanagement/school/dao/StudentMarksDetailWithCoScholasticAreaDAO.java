/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticArea;
import java.io.Serializable;

public class StudentMarksDetailWithCoScholasticAreaDAO
extends GenericDAO<StudentMarksDetailWithCoScholasticArea> {
    public StudentMarksDetailWithCoScholasticAreaDAO() {
        super(StudentMarksDetailWithCoScholasticArea.class);
    }

    public StudentMarksDetailWithCoScholasticArea getStudentMarksDetailWithCoScholasticAreaById(Long id) {
        StudentMarksDetailWithCoScholasticArea instance = (StudentMarksDetailWithCoScholasticArea)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithCoScholasticArea", (Serializable)id);
        return instance;
    }
}
