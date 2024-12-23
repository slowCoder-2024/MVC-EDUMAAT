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
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentMark;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentMarkDAO
extends GenericDAO<StudentMark> {
    public StudentMarkDAO() {
        super(StudentMark.class);
    }

    public StudentMark getStudentMarkById(Long id) {
        StudentMark instance = (StudentMark)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentMark", (Serializable)id);
        return instance;
    }

    public List<StudentMark> getStudentMarkBy(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMark.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        List studentMarks = criteria.list();
        return studentMarks;
    }

    public List<StudentMark> getStudentMarkBy(ClassSection ClassSection2, AcademicYear academicYear, ClassSectionTermExam classSectionTermExam, Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentMark.class);
        criteria.add((Criterion)Restrictions.eq((String)"classSection", (Object)ClassSection2));
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        criteria.add((Criterion)Restrictions.eq((String)"classSectionTermExam", (Object)classSectionTermExam));
        List studentMarks = criteria.list();
        return studentMarks;
    }
}
