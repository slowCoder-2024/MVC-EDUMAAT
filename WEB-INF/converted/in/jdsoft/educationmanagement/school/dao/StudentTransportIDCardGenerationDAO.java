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
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentTransportIDCardGenerationDAO
extends GenericDAO<StudentTransportIDCardGeneration> {
    public StudentTransportIDCardGenerationDAO() {
        super(StudentTransportIDCardGeneration.class);
    }

    public StudentTransportIDCardGeneration getStudentTransportIDCardGenerationById(Long id) {
        StudentTransportIDCardGeneration instance = (StudentTransportIDCardGeneration)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration", (Serializable)id);
        return instance;
    }

    public List<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(Class classz, Section section, AcademicYear academicYear, Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentTransportIDCardGeneration.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List StudentTransportIDCardGenerationList = applicantCriteria.list();
        return StudentTransportIDCardGenerationList;
    }

    public List<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerationByClassAndSectionAndAcademicYear(Class classz, Section section, AcademicYear academicYear) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentTransportIDCardGeneration.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)));
        List StudentTransportIDCardGenerationList = applicantCriteria.list();
        return StudentTransportIDCardGenerationList;
    }

    public List<StudentTransportIDCardGeneration> getStudentTransportIDCardGenerationByClassAndSectionAndFeesTerm(Class classz, Section section, FeesTerm feesTerm) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentTransportIDCardGeneration.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm)));
        List StudentTransportIDCardGenerationList = applicantCriteria.list();
        return StudentTransportIDCardGenerationList;
    }
}
