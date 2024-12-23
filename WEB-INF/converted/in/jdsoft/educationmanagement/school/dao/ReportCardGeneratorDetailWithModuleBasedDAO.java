/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetailWithModuleBased;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCardGeneratorDetailWithModuleBasedDAO
extends GenericDAO<ReportCardGeneratorDetailWithModuleBased> {
    public ReportCardGeneratorDetailWithModuleBasedDAO() {
        super(ReportCardGeneratorDetailWithModuleBased.class);
    }

    public ReportCardGeneratorDetailWithModuleBased getReportCardGeneratorDetailById(Long id) {
        ReportCardGeneratorDetailWithModuleBased instance = (ReportCardGeneratorDetailWithModuleBased)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetailWithModuleBased", (Serializable)id);
        return instance;
    }
}
