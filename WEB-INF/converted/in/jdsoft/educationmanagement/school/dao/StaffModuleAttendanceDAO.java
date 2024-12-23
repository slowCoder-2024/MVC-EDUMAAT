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
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StaffModuleAttendanceDAO
extends GenericDAO<StaffModuleAttendance> {
    public StaffModuleAttendanceDAO() {
        super(StaffModuleAttendance.class);
    }

    public StaffModuleAttendance getStaffModuleAttendanceById(Long id) {
        StaffModuleAttendance instance = (StaffModuleAttendance)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StaffModuleAttendance", (Serializable)id);
        return instance;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByStudentEmailAndAttendanceStartDateAndAttendanceEndDate(Student student, Date AttendanceStartDate, Date AttendanceEndDate) {
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add(Restrictions.between((String)"attendanceDate", (Object)AttendanceStartDate, (Object)AttendanceEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByStudentEmailAndClassAndSectionAndAttendanceStartDateAndAttendanceEndDate(Student student, Class classes, Section section, Date AttendanceStartDate, Date AttendanceEndDate, AcademicYear academicYear) {
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add((Criterion)Restrictions.eq((String)"acdemicYear", (Object)academicYear));
        and.add(Restrictions.between((String)"attendanceDate", (Object)AttendanceStartDate, (Object)AttendanceEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByClassAndSectionAndAttendanceStartDateAndAttendanceEndDate(Class classs, Section section, Date AttendanceStartDate, Date AttendanceEndDate) {
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add(Restrictions.between((String)"attendanceDate", (Object)AttendanceStartDate, (Object)AttendanceEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByStudentEmailAndAttendanceMonth(Student student, Date attendanceMonth) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add(Restrictions.between((String)"attendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByStudentEmailAndClassAndSectionAndAttendanceMonth(Student student, Class classes, Section section, Date attendanceMonth, AcademicYear academicYear) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add((Criterion)Restrictions.eq((String)"acdemicYear", (Object)academicYear));
        and.add(Restrictions.between((String)"attendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByClassAndSectionAndAttendanceMonth(Class classs, Section section, Date attendanceMonth) {
        Date monthStartDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth(), 1);
        Date monthEndDate = new Date(attendanceMonth.getYear(), attendanceMonth.getMonth() + 1, 0);
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add(Restrictions.between((String)"attendanceDate", (Object)monthStartDate, (Object)monthEndDate));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }

    public List<StaffModuleAttendance> getStaffModuleAttendanceByClassAndSectionAndAcademicYearAndClassSectionModule(Class classs, Section section, ClassSectionModule classSectionModule, AcademicYear academicYear, Student student) {
        ArrayList staffModuleAttendances = new ArrayList();
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(StaffModuleAttendance.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        and.add((Criterion)Restrictions.eq((String)"classSectionModule", (Object)classSectionModule));
        and.add((Criterion)Restrictions.eq((String)"acdemicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        staffModuleAttendanceCriteria.add((Criterion)and);
        staffModuleAttendances = (ArrayList)staffModuleAttendanceCriteria.list();
        return staffModuleAttendances;
    }
}
