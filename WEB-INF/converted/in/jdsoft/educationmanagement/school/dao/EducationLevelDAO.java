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
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class EducationLevelDAO
extends GenericDAO<EducationLevel> {
    public EducationLevelDAO() {
        super(EducationLevel.class);
    }

    public EducationLevel getEducationLevelById(Long id) {
        EducationLevel instance = (EducationLevel)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.EducationLevel", (Serializable)id);
        return instance;
    }

    public EducationLevel getEducationLevelByEducationLevelName(String educationLevelName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(EducationLevel.class);
        criteria.add((Criterion)Restrictions.eq((String)"educationLevelTitle", (Object)educationLevelName));
        EducationLevel educationLevel = (EducationLevel)criteria.uniqueResult();
        return educationLevel;
    }
}
