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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffType;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDAO
extends GenericDAO<Staff> {
    public StaffDAO() {
        super(Staff.class);
    }

    public Staff getStaffById(Long id) {
        Staff instance = (Staff)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Staff", (Serializable)id);
        return instance;
    }

    public List<Staff> getStaffsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List staffs = criteria.list();
        return staffs;
    }

    public Staff getStaffByStaffCode(String staffCode) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        criteria.add((Criterion)Restrictions.eq((String)"staffCode", (Object)staffCode));
        Staff staff = (Staff)criteria.uniqueResult();
        return staff;
    }

    public Staff getStaffByStaffEmail(String staffEmail) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        criteria.add((Criterion)Restrictions.eq((String)"email", (Object)staffEmail));
        Staff staff = (Staff)criteria.uniqueResult();
        return staff;
    }

    public List<Staff> getStaffsByStatus(Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)1));
        List staffs = criteria.list();
        return staffs;
    }

    public List<Staff> getStaffsByStatusAndInstitution(Integer status, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)and);
        List staffs = criteria.list();
        return staffs;
    }

    public List<Staff> getStaffsByDefaultUser(String defaultUser, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"createdBy", (Object)defaultUser));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)and);
        List staffs = criteria.list();
        return staffs;
    }

    public List<Staff> getStaffsByStatusAndType(Integer status, StaffType staffType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"status", (Object)1));
        and.add((Criterion)Restrictions.eq((String)"staffType", (Object)staffType));
        criteria.add((Criterion)and);
        List staffs = criteria.list();
        return staffs;
    }

    public List<Staff> getStaffsByStaffDesignation(StaffDesignation staffDesignation) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Staff.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"staffDesignation", (Object)staffDesignation));
        criteria.add((Criterion)and);
        List staffs = criteria.list();
        return staffs;
    }
}
