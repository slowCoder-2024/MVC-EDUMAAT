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
import in.jdsoft.educationmanagement.school.model.UserRole;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserRoleDAO
extends GenericDAO<UserRole> {
    public UserRoleDAO() {
        super(UserRole.class);
    }

    public UserRole getUserRoleById(Long id) {
        UserRole instance = (UserRole)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.UserRole", (Serializable)id);
        return instance;
    }

    public List<UserRole> getUserRoleByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List userRoles = criteria.list();
        return userRoles;
    }

    public List<UserRole> getUserRolesByTargetTypeAndInstitution(Institution institution, String targetType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"targetType", (Object)targetType));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)and);
        List userRoles = criteria.list();
        return userRoles;
    }

    public List<UserRole> nonDefaultUserRoles(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"defaultRole", (Object)false));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)and);
        List userRoles = criteria.list();
        return userRoles;
    }

    public UserRole getUserRoleByTargetTypeAndInstitution(Institution institution, String targetType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"targetType", (Object)targetType));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)and);
        UserRole userRole = (UserRole)criteria.uniqueResult();
        return userRole;
    }

    public List<UserRole> getUserRoleByTargetType(String targetType) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(UserRole.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"targetType", (Object)targetType));
        criteria.add((Criterion)and);
        List userRoles = criteria.list();
        return userRoles;
    }
}
