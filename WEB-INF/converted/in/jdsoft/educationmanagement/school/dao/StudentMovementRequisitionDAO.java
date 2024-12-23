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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentMovementRequisitionDAO
extends GenericDAO<StudentMovementRequisition> {
    public StudentMovementRequisitionDAO() {
        super(StudentMovementRequisition.class);
    }

    public StudentMovementRequisition getStudentMovementRequisitionById(Long id) {
        StudentMovementRequisition instance = (StudentMovementRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMovementRequisition", (Serializable)id);
        return instance;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionList(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndStatus(Student student, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListByStatusAndInstitution(Institution institution, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListByStatusAndInstitutionAndCurrentDate(Institution institution, String status, Date date) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        criteria.add((Criterion)Restrictions.eq((String)"studentMovementDate", (Object)date));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndStatusAndTime(Student student, String status, Time time, Date date) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        criteria.add((Criterion)Restrictions.ge((String)"startTime", (Object)time));
        criteria.add((Criterion)Restrictions.le((String)"endTime", (Object)time));
        criteria.add((Criterion)Restrictions.eq((String)"studentMovementDate", (Object)date));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndUserAndStatus(User user, String status) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"movementApprover", (Object)user));
        criteria.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)status));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndUser(User user) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"momentApprover", (Object)user));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndAcademicYear(AcademicYear academicYear) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndAcademicYearAndClassAndSection(AcademicYear academicYear, Class classs, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        criteria.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }

    public List<StudentMovementRequisition> getStudentMovementRequisitionListAndAcademicYearAndAdmissionNumber(AcademicYear academicYear, String admissionNumber) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMovementRequisition.class).createAlias("student", "student");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student.admissionNo", (Object)admissionNumber)));
        criteria.add((Criterion)and);
        List StudentMovementRequisitions = criteria.list();
        return StudentMovementRequisitions;
    }
}
