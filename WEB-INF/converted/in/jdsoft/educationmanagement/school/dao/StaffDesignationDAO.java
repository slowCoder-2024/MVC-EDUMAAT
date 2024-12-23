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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffType;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffDesignationDAO
extends GenericDAO<StaffDesignation> {
    public StaffDesignationDAO() {
        super(StaffDesignation.class);
    }

    public StaffDesignation getStaffDesignationById(Long id) {
        StaffDesignation instance = (StaffDesignation)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffDesignation", (Serializable)id);
        return instance;
    }

    public List<StaffDesignation> getStaffDesignationByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffDesignation.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List staffDesignations = criteria.list();
        return staffDesignations;
    }

    public List<StaffDesignation> getStaffDesignationByInstitutionAndStaffType(Institution institution, StaffType staffType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StaffDesignation.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)).add((Criterion)Restrictions.eq((String)"staffType", (Object)staffType)));
        List staffDesignations = criteria.list();
        return staffDesignations;
    }
}
