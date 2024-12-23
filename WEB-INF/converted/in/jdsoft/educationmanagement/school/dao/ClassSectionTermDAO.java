/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionTermDAO
extends GenericDAO<ClassSectionTerm> {
    public ClassSectionTermDAO() {
        super(ClassSectionTerm.class);
    }

    public ClassSectionTerm getClassSectionTermById(Long id) {
        ClassSectionTerm instance = (ClassSectionTerm)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionTerm", (Serializable)id);
        return instance;
    }
}
