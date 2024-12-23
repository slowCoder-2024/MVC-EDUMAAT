/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionModuleStaffDAO
extends GenericDAO<ClassSectionModuleStaff> {
    public ClassSectionModuleStaffDAO() {
        super(ClassSectionModuleStaff.class);
    }

    public ClassSectionModuleStaff getClassSectionModuleStaffById(Long id) {
        ClassSectionModuleStaff instance = (ClassSectionModuleStaff)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff", (Serializable)id);
        return instance;
    }
}
