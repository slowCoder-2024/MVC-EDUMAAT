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
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class GradeSystemDetailDAO
extends GenericDAO<GradeSystemDetail> {
    public GradeSystemDetailDAO() {
        super(GradeSystemDetail.class);
    }

    public GradeSystemDetail getGradeSystemDetailById(Long id) {
        GradeSystemDetail instance = (GradeSystemDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.GradeSystemDetail", (Serializable)id);
        return instance;
    }

    public GradeSystemDetail getGradeByMark(Double mark, GradeSystem gradeSystem) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GradeSystemDetail.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"gradeSystem", (Object)gradeSystem)));
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.le((String)"fromMarks", (Object)mark)));
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.ge((String)"toMarks", (Object)mark)));
        GradeSystemDetail grade = (GradeSystemDetail)criteria.uniqueResult();
        return grade;
    }

    public GradeSystemDetail getGradeByPoint(Double point, GradeSystem gradeSystem) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(GradeSystemDetail.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"gradeSystem", (Object)gradeSystem)));
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"gradePoint", (Object)point)));
        GradeSystemDetail grade = (GradeSystemDetail)criteria.uniqueResult();
        return grade;
    }
}
