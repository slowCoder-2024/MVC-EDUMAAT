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
import in.jdsoft.educationmanagement.school.model.License;
import java.io.Serializable;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class LicenseDAO
extends GenericDAO<License> {
    public LicenseDAO() {
        super(License.class);
    }

    public License getLicenseById(Long id) {
        License instance = (License)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.License", (Serializable)id);
        return instance;
    }

    public ArrayList<License> getLicensesBy(String customerCode, String licenseCode, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(License.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"customerCode", (Object)customerCode)).add((Criterion)Restrictions.eq((String)"licenseCode", (Object)licenseCode)).add((Criterion)Restrictions.eq((String)"status", (Object)status)));
        ArrayList license = (ArrayList)criteria.list();
        return license;
    }

    public License getLicenseBy(String customerCode, String licenseCode, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(License.class);
        criteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"customerCode", (Object)customerCode)).add((Criterion)Restrictions.eq((String)"licenseCode", (Object)licenseCode)).add((Criterion)Restrictions.eq((String)"status", (Object)status)));
        License license = (License)criteria.uniqueResult();
        return license;
    }

    public License getLicenseByStatus(String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(License.class);
        criteria.add((Criterion)Restrictions.eq((String)"status", (Object)status));
        License license = (License)criteria.uniqueResult();
        return license;
    }
}
