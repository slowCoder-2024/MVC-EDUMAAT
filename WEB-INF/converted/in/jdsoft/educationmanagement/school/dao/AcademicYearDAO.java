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
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AcademicYearDAO
extends GenericDAO<AcademicYear> {
    public AcademicYearDAO() {
        super(AcademicYear.class);
    }

    public AcademicYear getAcademicYearById(Long id) {
        AcademicYear instance = (AcademicYear)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AcademicYear", (Serializable)id);
        return instance;
    }

    public AcademicYear getAcademiYearByAcademicYearTitle(String academicYearTitle) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"academicYearTitle", (Object)academicYearTitle)));
        AcademicYear academicYear = (AcademicYear)criteria.uniqueResult();
        return academicYear;
    }

    public List<AcademicYear> getAcademicYearByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List academicYears = criteria.list();
        return academicYears;
    }

    public AcademicYear getActiveAcademicYear(Institution institution) {
        AcademicYear academicYear = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"academicYearStatus", (Object)1)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        academicYear = (AcademicYear)criteria.uniqueResult();
        return academicYear;
    }

    public AcademicYear getActiveAcademicYear() {
        AcademicYear academicYear = null;
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"academicYearStatus", (Object)1)));
        academicYear = (AcademicYear)criteria.uniqueResult();
        return academicYear;
    }

    public AcademicYear getAcademiYearByAcademicYearTitleAndInstitution(String academicYearTitle, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AcademicYear.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"academicYearTitle", (Object)academicYearTitle)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        AcademicYear academicYear = (AcademicYear)criteria.uniqueResult();
        return academicYear;
    }
}
