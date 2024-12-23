/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionTermExamDAO
extends GenericDAO<ClassSectionTermExam> {
    public ClassSectionTermExamDAO() {
        super(ClassSectionTermExam.class);
    }

    public ClassSectionTermExam getClassSectionTermExamById(Long id) {
        ClassSectionTermExam instance = (ClassSectionTermExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionTermExam", (Serializable)id);
        return instance;
    }
}
