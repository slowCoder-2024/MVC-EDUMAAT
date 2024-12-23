/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleSkill;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class StudentMarksDetailWithModuleSkillDAO
extends GenericDAO<StudentMarksDetailWithModuleSkill> {
    public StudentMarksDetailWithModuleSkillDAO() {
        super(StudentMarksDetailWithModuleSkill.class);
    }

    public StudentMarksDetailWithModuleSkill getStudentMarksDetailWithModuleSkillById(Long id) {
        StudentMarksDetailWithModuleSkill instance = (StudentMarksDetailWithModuleSkill)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleSkill", (Serializable)id);
        return instance;
    }
}
