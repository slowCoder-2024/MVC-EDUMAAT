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
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionCoScholasticAreaExamDAO
extends GenericDAO<ClassSectionCoScholasticAreaExam> {
    public ClassSectionCoScholasticAreaExamDAO() {
        super(ClassSectionCoScholasticAreaExam.class);
    }

    public ClassSectionCoScholasticAreaExam getClassSectionCoScholasticAreaExamById(Long id) {
        ClassSectionCoScholasticAreaExam instance = (ClassSectionCoScholasticAreaExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam", (Serializable)id);
        return instance;
    }

    public List<ClassSectionCoScholasticAreaExam> getClassSectionCoScholasticAreaExamByClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionCoScholasticAreaExam.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List classSectionCoScholasticAreaExams = criteria.list();
        return classSectionCoScholasticAreaExams;
    }
}
