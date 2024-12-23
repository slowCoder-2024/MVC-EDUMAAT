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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.Staff;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ClassSectionModuleDAO
extends GenericDAO<ClassSectionModule> {
    public ClassSectionModuleDAO() {
        super(ClassSectionModule.class);
    }

    public ClassSectionModule getClassSectionModuleById(Long id) {
        ClassSectionModule instance = (ClassSectionModule)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.ClassSectionModule", (Serializable)id);
        return instance;
    }

    public List<ClassSectionModule> getClassSectionModuleBy(ClassSection classsection, boolean skillBased) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModule.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classSection", (Object)classsection)).add((Criterion)Restrictions.eq((String)"skillBased", (Object)skillBased)));
        List classSectionModules = criteria.list();
        return classSectionModules;
    }

    public ClassSectionModule getClassSectionModuleByIdAndStaff(Long classSectionModuleId, Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModule.class).createAlias("classSectionModuleStaff", "csms");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"classSectionModuleId", (Object)classSectionModuleId));
        and.add((Criterion)Restrictions.eq((String)"csms.staff", (Object)staff));
        criteria.add((Criterion)and);
        ClassSectionModule classSectionModule = (ClassSectionModule)criteria.uniqueResult();
        return classSectionModule;
    }

    public ClassSectionModule getClassSectionModuleByClassSectionAndModule(ClassSection classSection, Module module) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModule.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"classSection", (Object)classSection));
        and.add((Criterion)Restrictions.eq((String)"module", (Object)module));
        criteria.add((Criterion)and);
        ClassSectionModule classSectionModule = (ClassSectionModule)criteria.uniqueResult();
        return classSectionModule;
    }

    public List<ClassSectionModule> getClassSectionModuleByClassSection(ClassSection classSection) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(ClassSectionModule.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"classSection", (Object)classSection));
        criteria.add((Criterion)and);
        ArrayList classSectionModule = new ArrayList();
        classSectionModule = (ArrayList)criteria.list();
        return classSectionModule;
    }
}
