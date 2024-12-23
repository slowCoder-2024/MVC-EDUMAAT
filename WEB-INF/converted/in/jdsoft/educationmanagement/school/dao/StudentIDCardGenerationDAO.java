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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentIDCardGenerationDAO
extends GenericDAO<StudentIDCardGeneration> {
    public StudentIDCardGenerationDAO() {
        super(StudentIDCardGeneration.class);
    }

    public StudentIDCardGeneration getStudentIDCardGenerationById(Long id) {
        StudentIDCardGeneration instance = (StudentIDCardGeneration)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration", (Serializable)id);
        return instance;
    }

    public List<StudentIDCardGeneration> getStudentIDCardGenerationByClassAndSectionAndAcademicYear(Class classz, Section section, AcademicYear academicYear, Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentIDCardGeneration.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List studentIDCardGenerationList = applicantCriteria.list();
        return studentIDCardGenerationList;
    }
}
