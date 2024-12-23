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
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class GradeSystemDAO
extends GenericDAO<GradeSystem> {
    public GradeSystemDAO() {
        super(GradeSystem.class);
    }

    public GradeSystem getGradeSystemById(Long id) {
        GradeSystem instance = (GradeSystem)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.GradeSystem", (Serializable)id);
        return instance;
    }

    public List<GradeSystem> getGradeSystemsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GradeSystem.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List gradeSystems = criteria.list();
        return gradeSystems;
    }
}
