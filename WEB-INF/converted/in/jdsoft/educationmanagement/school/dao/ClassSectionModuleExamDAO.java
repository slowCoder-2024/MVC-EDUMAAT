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
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionModuleExamDAO
extends GenericDAO<ClassSectionModuleExam> {
    public ClassSectionModuleExamDAO() {
        super(ClassSectionModuleExam.class);
    }

    public ClassSectionModuleExam getClassSectionModuleExamById(Long id) {
        ClassSectionModuleExam instance = (ClassSectionModuleExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam", (Serializable)id);
        return instance;
    }

    public List<ClassSectionModuleExam> getClassSectionModuleExamByClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModuleExam.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List classSectionModuleExams = criteria.list();
        return classSectionModuleExams;
    }
}
