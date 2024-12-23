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
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAppraisalDAO
extends GenericDAO<StaffAppraisal> {
    public StaffAppraisalDAO() {
        super(StaffAppraisal.class);
    }

    public StaffAppraisal getStaffAppraisalById(Long id) {
        StaffAppraisal instance = (StaffAppraisal)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffAppraisal", (Serializable)id);
        return instance;
    }

    public List<StaffAppraisal> getStaffAppraisalListByStaff(Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        List staffs = criteria.list();
        return staffs;
    }

    public List<StaffAppraisal> getStaffAppraisalListByAcademicYear(AcademicYear academicYear) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        List staffs = criteria.list();
        return staffs;
    }

    public List<StaffAppraisal> getStaffAppraisalListByAcademicYearAndEmail(AcademicYear academicYear, Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        List staffs = criteria.list();
        return staffs;
    }
}
