/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionModuleSkillDAO
extends GenericDAO<ClassSectionModuleSkill> {
    public ClassSectionModuleSkillDAO() {
        super(ClassSectionModuleSkill.class);
    }

    public ClassSectionModuleSkill getClassSectionModuleSkillById(Long id) {
        ClassSectionModuleSkill instance = (ClassSectionModuleSkill)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill", (Serializable)id);
        return instance;
    }
}
