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
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionAssesmentTypeDAO
extends GenericDAO<ClassSectionAssesmentType> {
    public ClassSectionAssesmentTypeDAO() {
        super(ClassSectionAssesmentType.class);
    }

    public ClassSectionAssesmentType getClassSectionAssesmentTypeById(Long id) {
        ClassSectionAssesmentType instance = (ClassSectionAssesmentType)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType", (Serializable)id);
        return instance;
    }

    public ClassSectionAssesmentType getClassSectionAssesmentType(ClassSection classSection) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionAssesmentType.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classSection", (Object)classSection)));
        ClassSectionAssesmentType classSectionAssesmentType = (ClassSectionAssesmentType)criteria.uniqueResult();
        return classSectionAssesmentType;
    }
}
