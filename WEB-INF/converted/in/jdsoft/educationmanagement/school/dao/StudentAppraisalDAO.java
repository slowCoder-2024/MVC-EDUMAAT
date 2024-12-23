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
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentAppraisalDAO
extends GenericDAO<StudentAppraisal> {
    public StudentAppraisalDAO() {
        super(StudentAppraisal.class);
    }

    public StudentAppraisal getStudentAppraisalById(Long id) {
        StudentAppraisal instance = (StudentAppraisal)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentAppraisal", (Serializable)id);
        return instance;
    }

    public List<StudentAppraisal> getStudentAppraisalListByStudent(Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        List staffs = criteria.list();
        return staffs;
    }

    public List<StudentAppraisal> getStudentAppraisalListByClassAndSection(Class classes, Section section) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        criteria.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        List staffs = criteria.list();
        return staffs;
    }

    public List<StudentAppraisal> getStudentAppraisalListByAcademicYearAndEmail(AcademicYear academicYear, Student student) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(StudentAppraisal.class);
        criteria.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        criteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        List studentAppraisals = criteria.list();
        return studentAppraisals;
    }
}
