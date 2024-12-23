/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.AdmissionProcessStatusDAO;
import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.school.model.Class;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionConfigDAO
extends GenericDAO<AdmissionConfig> {
    @Autowired
    AdmissionProcessStatusDAO admissionProcessStatusDAO;

    public AdmissionConfigDAO() {
        super(AdmissionConfig.class);
    }

    public AdmissionConfig getAdmissionConfigById(Long id) {
        AdmissionConfig instance = (AdmissionConfig)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.AdmissionConfig", (Serializable)id);
        return instance;
    }

    public AdmissionConfig getCurrentAdmissionConfig() {
        AdmissionProcessStatus admissionConfigOnGoing = this.admissionProcessStatusDAO.getAdmissionProcessStatusById(3L);
        AdmissionProcessStatus admissionConfigOnHold = this.admissionProcessStatusDAO.getAdmissionProcessStatusById(1L);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
        criteria.add((Criterion)Restrictions.or((Criterion)Restrictions.eq((String)"admissionProcessStatus", (Object)admissionConfigOnGoing), (Criterion)Restrictions.eq((String)"admissionProcessStatus", (Object)admissionConfigOnHold)));
        AdmissionConfig admissionConfig = (AdmissionConfig)criteria.uniqueResult();
        return admissionConfig;
    }

    public List<AdmissionConfig> getCurrentAdmissionConfigList() {
        AdmissionProcessStatus admissionConfigOnGoing = this.admissionProcessStatusDAO.getAdmissionProcessStatusById(3L);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
        criteria.add((Criterion)Restrictions.and((Criterion[])new Criterion[]{Restrictions.eq((String)"admissionProcessStatus", (Object)admissionConfigOnGoing)}));
        List admissionConfig = criteria.list();
        return admissionConfig;
    }

    public List<AdmissionConfig> getAdmissionConfigList() {
        AdmissionProcessStatus admissionConfigOnGoing = this.admissionProcessStatusDAO.getAdmissionProcessStatusById(3L);
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
        criteria.add((Criterion)Restrictions.and((Criterion[])new Criterion[]{Restrictions.eq((String)"admissionProcessStatus", (Object)admissionConfigOnGoing)}));
        List admissionConfig = criteria.list();
        return admissionConfig;
    }

    public List<AdmissionConfig> getAdmissionConfigListByClassz(Set<Class> classz) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
        criteria.add((Criterion)Restrictions.and((Criterion[])new Criterion[]{Restrictions.eq((String)"classes", classz)}));
        List admissionConfig = criteria.list();
        return admissionConfig;
    }

    public AdmissionConfig getAdmissionConfigByAdmissionConfigName(String admissionConfigName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(AdmissionConfig.class);
        criteria.add((Criterion)Restrictions.eq((String)"applicationCodeFormat", (Object)admissionConfigName));
        AdmissionConfig admissionConfig = (AdmissionConfig)criteria.uniqueResult();
        return admissionConfig;
    }
}
