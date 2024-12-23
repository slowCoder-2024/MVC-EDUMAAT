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
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class TCRequisitionDAO
extends GenericDAO<TCRequisition> {
    public TCRequisitionDAO() {
        super(TCRequisition.class);
    }

    public TCRequisition getTCRequisitionById(Long id) {
        TCRequisition instance = (TCRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.TCRequisition", (Serializable)id);
        return instance;
    }

    public List<TCRequisition> getTCRequisitionList(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndStatus(Student student, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"tcApprover", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"tcApprover", (Object)user));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndAcademicYear(AcademicYear academicYear) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndAcademicYearAndClassAndSection(AcademicYear academicYear, Class classs, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }

    public List<TCRequisition> getTCRequisitionListAndAcademicYearAndAdmissionNumber(AcademicYear academicYear, String admissionNumber) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(TCRequisition.class).createAlias("student", "student");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student.admissionNo", (Object)admissionNumber)));
        criteria.add((Criterion)and);
        List TCRequisitions = criteria.list();
        return TCRequisitions;
    }
}
