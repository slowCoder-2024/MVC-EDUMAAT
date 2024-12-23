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
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AdmissionDAO
extends GenericDAO<Admission> {
    public AdmissionDAO() {
        super(Admission.class);
    }

    public Admission getAdmissionById(Long id) {
        Admission instance = (Admission)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Admission", (Serializable)id);
        return instance;
    }

    public Admission getApplicantByApplicantCode(String applicantCode) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"admissionCode", (Object)applicantCode)));
        Admission admissionList = (Admission)applicantCriteria.uniqueResult();
        return admissionList;
    }

    public List<Admission> getApplicants(Class classz, Section section) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classz", (Object)classz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }

    public List<Admission> getApplicantsList(Class classz) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classz", (Object)classz)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }

    public List<Admission> getApplicantsByAcademicYear(AdmissionConfig admissionConfig) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"admissionConfig", (Object)admissionConfig)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }

    public List<Admission> getApplicantsByClass(Class classz) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classz", (Object)classz)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }

    public List<Admission> getApplicantsByClassAndAdmissionConfig(Class classz, AdmissionConfig admissionConfig) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"classz", (Object)classz)).add((Criterion)Restrictions.eq((String)"admissionConfig", (Object)admissionConfig)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }

    public List<Admission> getApplicantsBySection(Section section) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(Admission.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"section", (Object)section)));
        List admissionList = applicantCriteria.list();
        return admissionList;
    }
}
