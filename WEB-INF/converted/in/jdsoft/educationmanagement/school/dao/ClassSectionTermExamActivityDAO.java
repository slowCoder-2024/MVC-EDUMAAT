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
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionTermExamActivityDAO
extends GenericDAO<ClassSectionTermExamActivity> {
    public ClassSectionTermExamActivityDAO() {
        super(ClassSectionTermExamActivity.class);
    }

    public ClassSectionTermExamActivity getClassSectionTermExamActivityById(Long id) {
        ClassSectionTermExamActivity instance = (ClassSectionTermExamActivity)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity", (Serializable)id);
        return instance;
    }

    public List<ClassSectionTermExamActivity> getClassSectionTermExamActivityByClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionTermExamActivity.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List classSectionTermExamActivitys = criteria.list();
        return classSectionTermExamActivitys;
    }
}
