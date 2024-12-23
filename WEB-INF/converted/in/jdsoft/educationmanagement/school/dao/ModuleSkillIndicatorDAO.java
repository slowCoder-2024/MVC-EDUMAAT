/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ModuleSkillIndicator;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ModuleSkillIndicatorDAO
extends GenericDAO<ModuleSkillIndicator> {
    public ModuleSkillIndicatorDAO() {
        super(ModuleSkillIndicator.class);
    }

    public ModuleSkillIndicator getAssesmentTypeById(Long id) {
        ModuleSkillIndicator instance = (ModuleSkillIndicator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ModuleSkillIndicator", (Serializable)id);
        return instance;
    }
}
