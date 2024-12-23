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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TimeTableGeneratorDAO
extends GenericDAO<TimeTableGenerator> {
    public TimeTableGeneratorDAO() {
        super(TimeTableGenerator.class);
    }

    public TimeTableGenerator getTimeTableGeneratorById(Long id) {
        TimeTableGenerator instance = (TimeTableGenerator)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TimeTableGenerator", (Serializable)id);
        return instance;
    }

    public TimeTableGenerator getTimeTableGeneratorsByClassSection(ClassSection classSection) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)classSection));
        TimeTableGenerator timeTableGenerator = (TimeTableGenerator)criteria.uniqueResult();
        return timeTableGenerator;
    }

    public List<TimeTableGenerator> getTimeTableGeneratorsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List timeTableGenerators = criteria.list();
        return timeTableGenerators;
    }

    public List<TimeTableGenerator> getTimeTableGeneratorsByInstitutionAndActiveAcademicYear(Institution institution, AcademicYear academicYear) {
        List timeTableGenerators = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TimeTableGenerator.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        timeTableGenerators = criteria.list();
        return timeTableGenerators;
    }
}
