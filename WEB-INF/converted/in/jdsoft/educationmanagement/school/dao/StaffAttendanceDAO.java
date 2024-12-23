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
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAttendance;
import in.jdsoft.educationmanagement.school.model.StaffType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffAttendanceDAO
extends GenericDAO<StaffAttendance> {
    public StaffAttendanceDAO() {
        super(StaffAttendance.class);
    }

    public StaffAttendance getStaffAttendanceById(Long id) {
        StaffAttendance instance = (StaffAttendance)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffAttendance", (Serializable)id);
        return instance;
    }

    public StaffAttendance getStaffAttendance(AcademicYear academicYear, Date date, Staff staff) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAttendance.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"date", (Object)date));
        criteria.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        StaffAttendance staffAttendance = (StaffAttendance)criteria.uniqueResult();
        return staffAttendance;
    }

    public List<StaffAttendance> getStaffAttendance(Date date) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAttendance.class);
        criteria.add((Criterion)Restrictions.eq((String)"date", (Object)date));
        List staffAttendances = criteria.list();
        return staffAttendances;
    }

    public List<StaffAttendance> staffAttendanceByDate(Date date, Institution institution, StaffType staffType) {
        Criteria staffAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAttendance.class).createAlias("staff", "s");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"date", (Object)date));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"s.staffType", (Object)staffType));
        staffAttendanceCriteria.add((Criterion)and);
        List staffAttendance = staffAttendanceCriteria.list();
        return staffAttendance;
    }

    public List<StaffAttendance> getStaffAttendanceByStaffEmailAndAttendanceMonth(Staff staff, Date attendanceMonth) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"staff", (Object)staff));
        and.add(Restrictions.between((String)"date", (Object)monthStartDate, (Object)monthEndDate));
        staffAttendanceCriteria.add((Criterion)and);
        return staffAttendanceCriteria.list();
    }
}
