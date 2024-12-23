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
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
extends GenericDAO<User> {
    public UserDAO() {
        super(User.class);
    }

    public User getUserByEmail(String email) {
        Criteria emailcriteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        emailcriteria.add((Criterion)Restrictions.eq((String)"email", (Object)email));
        User user = (User)emailcriteria.uniqueResult();
        return user;
    }

    public User getUserById(Long id) {
        User instance = (User)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.User", (Serializable)id);
        return instance;
    }

    public List<User> getUserByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List users = criteria.list();
        return users;
    }

    public List<User> getUserBy(UserRole userRole) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class).createAlias("userRoles", "userRole");
        criteria.add((Criterion)Restrictions.eq((String)"userRole", (Object)userRole));
        List users = criteria.list();
        return users;
    }

    public User getUserByEmailAndInstitutionAndStatus(String email, Institution institution, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"email", (Object)email));
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        User user = (User)criteria.uniqueResult();
        return user;
    }

    public User getUserByDefaultUserAndInstitutionAndStatus(String defaultUser, Institution institution, Integer status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"createdBy", (Object)defaultUser));
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        User user = (User)criteria.uniqueResult();
        return user;
    }

    public User getUserByUserRoleAndInstitution(Institution institution, UserRole userRole) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(User.class).createAlias("userRoles", "userRole");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"userRole.targetType", (Object)userRole.getTargetType())));
        studentCriteria.add((Criterion)and);
        return (User)studentCriteria.uniqueResult();
    }
}
