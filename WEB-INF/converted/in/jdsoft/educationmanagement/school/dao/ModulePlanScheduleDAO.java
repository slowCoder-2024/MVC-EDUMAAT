/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ModulePlanSchedule;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ModulePlanScheduleDAO
extends GenericDAO<ModulePlanSchedule> {
    public ModulePlanScheduleDAO() {
        super(ModulePlanSchedule.class);
    }

    public ModulePlanSchedule getLessonPlanScheduleById(Long id) {
        ModulePlanSchedule instance = (ModulePlanSchedule)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.model.ModulePlanSchedule", (Serializable)id);
        return instance;
    }
}
