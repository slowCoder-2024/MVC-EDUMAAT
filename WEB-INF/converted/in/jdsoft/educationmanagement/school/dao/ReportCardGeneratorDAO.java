/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ReportCardGeneratorDAO
extends GenericDAO<ReportCardGenerator> {
    public ReportCardGeneratorDAO() {
        super(ReportCardGenerator.class);
    }

    public ReportCardGenerator getReportCardGeneratorById(Long id) {
        ReportCardGenerator instance = (ReportCardGenerator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ReportCardGenerator", (Serializable)id);
        return instance;
    }

    public ReportCardGenerator getReportCardGeneratorByStudent(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ReportCardGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        ReportCardGenerator ReportCardGenerators = (ReportCardGenerator)criteria.uniqueResult();
        return ReportCardGenerators;
    }
}
