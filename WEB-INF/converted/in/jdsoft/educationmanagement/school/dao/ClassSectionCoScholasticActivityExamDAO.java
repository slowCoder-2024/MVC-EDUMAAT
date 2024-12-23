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
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionCoScholasticActivityExamDAO
extends GenericDAO<ClassSectionCoScholasticActivityExam> {
    public ClassSectionCoScholasticActivityExamDAO() {
        super(ClassSectionCoScholasticActivityExam.class);
    }

    public ClassSectionCoScholasticActivityExam getClassSectionCoScholasticActivityExamById(Long id) {
        ClassSectionCoScholasticActivityExam instance = (ClassSectionCoScholasticActivityExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam", (Serializable)id);
        return instance;
    }

    public List<ClassSectionCoScholasticActivityExam> getClassSectionCoScholasticActivityExamByClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionCoScholasticActivityExam.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List classSectionCoScholasticActivityExams = criteria.list();
        return classSectionCoScholasticActivityExams;
    }
}
