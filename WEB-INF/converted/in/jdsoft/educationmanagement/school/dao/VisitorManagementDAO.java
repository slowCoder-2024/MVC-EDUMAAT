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
import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class VisitorManagementDAO
extends GenericDAO<VisitorManagement> {
    public VisitorManagementDAO() {
        super(VisitorManagement.class);
    }

    public VisitorManagement getVisitorManagementById(Long id) {
        VisitorManagement instance = (VisitorManagement)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.VisitorManagement", (Serializable)id);
        return instance;
    }

    public List<VisitorManagement> getVisitorManagementByInstitution(Institution institution) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(VisitorManagement.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        receiptcriteria.add((Criterion)and);
        ArrayList visitorManagements = (ArrayList)receiptcriteria.list();
        return visitorManagements;
    }
}
