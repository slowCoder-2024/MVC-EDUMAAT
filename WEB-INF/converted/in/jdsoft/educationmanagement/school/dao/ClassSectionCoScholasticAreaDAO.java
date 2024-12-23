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
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionCoScholasticAreaDAO
extends GenericDAO<ClassSectionCoScholasticArea> {
    public ClassSectionCoScholasticAreaDAO() {
        super(ClassSectionCoScholasticArea.class);
    }

    public ClassSectionCoScholasticArea getClassSectionCoScholasticAreaById(Long id) {
        ClassSectionCoScholasticArea instance = (ClassSectionCoScholasticArea)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticArea", (Serializable)id);
        return instance;
    }

    public List<ClassSectionCoScholasticArea> getClassSectionCoScholasticAreaBy(ClassSection classsection) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionCoScholasticArea.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classsection));
        List classSectionCoScholasticAreas = criteria.list();
        return classSectionCoScholasticAreas;
    }
}
