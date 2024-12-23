/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetail;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCardGeneratorDetailDAO
extends GenericDAO<ReportCardGeneratorDetail> {
    public ReportCardGeneratorDetailDAO() {
        super(ReportCardGeneratorDetail.class);
    }

    public ReportCardGeneratorDetail getReportCardGeneratorDetailById(Long id) {
        ReportCardGeneratorDetail instance = (ReportCardGeneratorDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetail", (Serializable)id);
        return instance;
    }
}
