/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Conjunction
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassDAO
extends GenericDAO<Class> {
    public ClassDAO() {
        super(Class.class);
    }

    public Class getClassById(Long id) {
        Class instance = (Class)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Class", (Serializable)id);
        return instance;
    }

    public Class getClassByClassNameAndInstitution(String className, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Class.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"className", (Object)className)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        Class clazz = (Class)criteria.uniqueResult();
        return clazz;
    }

    public Class getClassByClassName(String className) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Class.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"className", (Object)className)));
        Class clazz = (Class)criteria.uniqueResult();
        return clazz;
    }

    public List<Class> getClasssByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Class.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List classs = criteria.list();
        return classs;
    }

    public List<Class> getClasszByExamConfigStatus(Institution institution, Integer classExamConfigStatus) {
        Criteria classCriteria = this.sessionFactory.getCurrentSession().createCriteria(Class.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"classExamConfigStatus", (Object)classExamConfigStatus));
        classCriteria.add((Criterion)and);
        return classCriteria.list();
    }
}
