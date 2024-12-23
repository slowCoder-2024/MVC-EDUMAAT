/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ModuleSkill;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ModuleSkillDAO
extends GenericDAO<ModuleSkill> {
    public ModuleSkillDAO() {
        super(ModuleSkill.class);
    }

    public ModuleSkill getModuleSkillById(Long id) {
        ModuleSkill instance = (ModuleSkill)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ModuleSkill", (Serializable)id);
        return instance;
    }
}
