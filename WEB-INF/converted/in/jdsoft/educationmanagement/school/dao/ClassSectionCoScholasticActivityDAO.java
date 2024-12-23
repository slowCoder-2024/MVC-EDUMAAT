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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionCoScholasticActivityDAO
extends GenericDAO<ClassSectionCoScholasticActivity> {
    public ClassSectionCoScholasticActivityDAO() {
        super(ClassSectionCoScholasticActivity.class);
    }

    public ClassSectionCoScholasticActivity getClassSectionCoScholasticActivityById(Long id) {
        ClassSectionCoScholasticActivity instance = (ClassSectionCoScholasticActivity)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity", (Serializable)id);
        return instance;
    }

    public List<ClassSectionCoScholasticActivity> getClassSectionCoScholasticActivityBy(ClassSection classsection) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionCoScholasticActivity.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classsection));
        List classSectionCoScholasticActivitys = criteria.list();
        return classSectionCoScholasticActivitys;
    }
}
