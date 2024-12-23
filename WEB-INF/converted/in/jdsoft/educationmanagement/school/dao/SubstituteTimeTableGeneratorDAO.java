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
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SubstituteTimeTableGeneratorDAO
extends GenericDAO<SubstituteTimeTableGenerator> {
    public SubstituteTimeTableGeneratorDAO() {
        super(SubstituteTimeTableGenerator.class);
    }

    public SubstituteTimeTableGenerator getSubstituteTimeTableGeneratorById(Long id) {
        SubstituteTimeTableGenerator instance = (SubstituteTimeTableGenerator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator", (Serializable)id);
        return instance;
    }

    public List<SubstituteTimeTableGenerator> getSubstituteTimeTableGeneratorByInstitutionAndActiveAcademicYear(Institution institution, AcademicYear academicYear) {
        List substituteTimeTableGenerators = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SubstituteTimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        substituteTimeTableGenerators = criteria.list();
        return substituteTimeTableGenerators;
    }

    public List<SubstituteTimeTableGenerator> getSubstituteTimeTableGeneratorByStaffAndDate(Staff staff, Date todayDate) {
        List substituteTimeTableGenerators = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SubstituteTimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        criteria.add((Criterion)Restrictions.ge((String)"substituteStartDate", (Object)todayDate));
        criteria.add((Criterion)Restrictions.le((String)"substituteEndDate", (Object)todayDate));
        substituteTimeTableGenerators = criteria.list();
        return substituteTimeTableGenerators;
    }

    public List<SubstituteTimeTableGenerator> getSubstituteTimeTableGeneratorByClassAndSectionAndDate(Class classes, Section section, Date todayDate) {
        List substituteTimeTableGenerators = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(SubstituteTimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"timeTableClass", (Object)classes));
        criteria.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        criteria.add((Criterion)Restrictions.ge((String)"substituteStartDate", (Object)todayDate));
        criteria.add((Criterion)Restrictions.le((String)"substituteEndDate", (Object)todayDate));
        substituteTimeTableGenerators = criteria.list();
        return substituteTimeTableGenerators;
    }
}
