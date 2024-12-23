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
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionDAO
extends GenericDAO<ClassSection> {
    public ClassSectionDAO() {
        super(ClassSection.class);
    }

    public ClassSection getClassSectionById(Long id) {
        ClassSection instance = (ClassSection)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSection", (Serializable)id);
        return instance;
    }

    public List<ClassSection> getClasssSectionByClass(Class classs) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classs));
        List classSections = criteria.list();
        return classSections;
    }

    public List<ClassSection> getClasssSectionsByClassAndSection(Class classs, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"sectionClass", (Object)section));
        List classSections = criteria.list();
        return classSections;
    }

    public List<ClassSection> getClasssSectionsByClassAndStaff(Class classs, Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"classStaff", (Object)staff));
        List classSections = criteria.list();
        return classSections;
    }

    public ClassSection getClasssSectionByClassAndSection(Class classs, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"sectionClass", (Object)section));
        ClassSection classSection = (ClassSection)criteria.uniqueResult();
        return classSection;
    }

    public ArrayList<ClassSection> getclassSectionExamConfigStatus(Class Clazz) {
        Criteria classSectionCriteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSection.class);
        classSectionCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classSection", (Object)Clazz)).add((Criterion)Restrictions.eq((String)"classSectionExamConfigStatus", (Object)0)));
        ArrayList classSections = (ArrayList)classSectionCriteria.list();
        return classSections;
    }
}
