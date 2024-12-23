/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Conjunction
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Disjunction
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
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAttendanceType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentAttendanceDAO
extends GenericDAO<StudentAttendance> {
    public StudentAttendanceDAO() {
        super(StudentAttendance.class);
    }

    public StudentAttendance getStudentAttendanceById(Long id) {
        StudentAttendance instance = (StudentAttendance)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentAttendance", (Serializable)id);
        return instance;
    }

    public List<StudentAttendance> studentAttendanceByDateAndType(Date date, Institution institution, Set<StudentAttendanceType> studentAttendanceTypes) {
        Criteria studentAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentAttendanceDate", (Object)date));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        Disjunction or = Restrictions.disjunction();
        for (StudentAttendanceType studentAttendanceType2 : studentAttendanceTypes) {
            or.add((Criterion)Restrictions.eq((String)"studentAttendanceType", (Object)studentAttendanceType2));
        }
        and.add((Criterion)or);
        studentAttendanceCriteria.add((Criterion)and);
        List studentAttendance = studentAttendanceCriteria.list();
        return studentAttendance;
    }

    public List<StudentAttendance> studentAttendanceByDateAndTypeAndClass(Date date, Class classes, Set<StudentAttendanceType> studentAttendanceTypes) {
        Criteria studentAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentAttendanceDate", (Object)date));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        Disjunction or = Restrictions.disjunction();
        for (StudentAttendanceType studentAttendanceType2 : studentAttendanceTypes) {
            or.add((Criterion)Restrictions.eq((String)"studentAttendanceType", (Object)studentAttendanceType2));
        }
        and.add((Criterion)or);
        studentAttendanceCriteria.add((Criterion)and);
        List studentAttendance = studentAttendanceCriteria.list();
        return studentAttendance;
    }

    public List<StudentAttendance> getStudentAttendanceByStudentEmailAndAttendanceMonth(Student student, Date attendanceMonth) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add(Restrictions.between((String)"studentAttendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public List<StudentAttendance> getLongAbsentStudentList(Student student, Date attendanceMonth, StudentAttendanceType studentAttendanceType) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add(Restrictions.between((String)"studentAttendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        and.add((Criterion)Restrictions.eq((String)"studentAttendanceType", (Object)studentAttendanceType));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public List<StudentAttendance> getStudentAttendanceByStudentEmailAndClassAndSectionAndAttendanceMonth(Student student, Class classs, Section section, Date attendanceMonth, AcademicYear academicYear) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add(Restrictions.between((String)"studentAttendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public List<StudentAttendance> getStudentAttendanceByClassAndSectionAndAttendanceMonth(Class classs, Section section, Date attendanceMonth) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add(Restrictions.between((String)"studentAttendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public List<StudentAttendance> getStudentAttendanceByAttendanceStartDateAndEndDateAndStudent(Student student, Date attendanceStartDate, Date attendanceEndDate, AcademicYear academicYear) {
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add(Restrictions.between((String)"studentAttendanceDate", (Object)attendanceStartDate, (Object)attendanceEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public List<StudentAttendance> getStudentAttendanceByClassAndSectionAndAttendanceDate(Class classs, Section section, Date attendanceDate) {
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add((Criterion)Restrictions.eq((String)"studentAttendanceDate", (Object)attendanceDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public StudentAttendance getStudentAttendanceByStudentAndAcademicYearAndAttendanceDate(Student student, AcademicYear academicYear, Date attendanceDate) {
        Criteria studentModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"studentAttendanceDate", (Object)attendanceDate));
        studentModuleAttendanceCriteria.add((Criterion)and);
        return (StudentAttendance)studentModuleAttendanceCriteria.uniqueResult();
    }
}
