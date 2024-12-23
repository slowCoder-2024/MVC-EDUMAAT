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
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ExamTemplateDAO
extends GenericDAO<ExamTemplate> {
    public ExamTemplateDAO() {
        super(ExamTemplate.class);
    }

    public ExamTemplate getExamTemplateById(Long id) {
        ExamTemplate instance = (ExamTemplate)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ExamTemplate", (Serializable)id);
        return instance;
    }

    public List<ExamTemplate> getExamTemplatesByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ExamTemplate.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List examTemplates = criteria.list();
        return examTemplates;
    }
}
