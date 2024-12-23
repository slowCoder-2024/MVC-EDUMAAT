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
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionModuleSkillExamDAO
extends GenericDAO<ClassSectionModuleSkillExam> {
    public ClassSectionModuleSkillExamDAO() {
        super(ClassSectionModuleSkillExam.class);
    }

    public ClassSectionModuleSkillExam getClassSectionModuleSkillExamById(Long id) {
        ClassSectionModuleSkillExam instance = (ClassSectionModuleSkillExam)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam", (Serializable)id);
        return instance;
    }

    public List<ClassSectionModuleSkillExam> getClassSectionModuleSkillExamByClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModuleSkillExam.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List classSectionModuleSkillExams = criteria.list();
        return classSectionModuleSkillExams;
    }
}
