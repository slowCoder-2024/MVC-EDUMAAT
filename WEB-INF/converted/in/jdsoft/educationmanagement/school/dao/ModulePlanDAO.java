/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ModulePlan;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ModulePlanDAO
extends GenericDAO<ModulePlan> {
    public ModulePlanDAO() {
        super(ModulePlan.class);
    }

    public ModulePlan getLessonPlanById(Long id) {
        ModulePlan instance = (ModulePlan)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.model.ModulePlan", (Serializable)id);
        return instance;
    }
}
