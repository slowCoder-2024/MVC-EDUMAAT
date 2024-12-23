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
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentLeaveRequisitionDAO
extends GenericDAO<StudentLeaveRequisition> {
    public StudentLeaveRequisitionDAO() {
        super(StudentLeaveRequisition.class);
    }

    public StudentLeaveRequisition getStudentLeaveRequisitionById(Long id) {
        StudentLeaveRequisition instance = (StudentLeaveRequisition)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition", (Serializable)id);
        return instance;
    }

    public List<StudentLeaveRequisition> getStudentLeaveRequisitionList(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentLeaveRequisition.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        List studentLeaveRequisitions = criteria.list();
        return studentLeaveRequisitions;
    }

    public List<StudentLeaveRequisition> getStudentLeaveRequisitionByStudentEmailAndAttendanceMonth(Student student, Date attendanceMonth, String approvalStatus) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria studentModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentLeaveRequisition.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)approvalStatus));
        and.add(Restrictions.between((String)"studentLeaveStartDate", (Object)monthStartDate, (Object)monthEndDate));
        and.add(Restrictions.between((String)"studentLeaveEndDate", (Object)monthStartDate, (Object)monthEndDate));
        studentModuleAttendanceCriteria.add((Criterion)and);
        return studentModuleAttendanceCriteria.list();
    }

    public List<StudentLeaveRequisition> getStudentLeaveRequisitionByStudentEmailAndAttendanceDate(Student student, Date attendanceDate, String approvalStatus) {
        Criteria studentModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentLeaveRequisition.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"approvalStatus", (Object)approvalStatus));
        and.add((Criterion)Restrictions.ge((String)"studentLeaveStartDate", (Object)attendanceDate));
        and.add((Criterion)Restrictions.le((String)"studentLeaveEndDate", (Object)attendanceDate));
        studentModuleAttendanceCriteria.add((Criterion)and);
        return studentModuleAttendanceCriteria.list();
    }
}
