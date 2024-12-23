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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class SickRoomVisitorDAO
extends GenericDAO<SickRoomVisitor> {
    public SickRoomVisitorDAO() {
        super(SickRoomVisitor.class);
    }

    public SickRoomVisitor getSickRoomVisitorById(Long id) {
        SickRoomVisitor instance = (SickRoomVisitor)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.SickRoomVisitor", (Serializable)id);
        return instance;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStudentAndAcademicYearAndInstitution(Student student, AcademicYear academicYear, Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student", (Object)student)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStaffAndAcademicYearAndInstitution(Staff staff, AcademicYear academicYear, Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"staff", (Object)staff)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStudentAndAcademicYear(Student student, AcademicYear academicYear) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student", (Object)student)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStaffAndAcademicYear(Staff staff, AcademicYear academicYear) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"staff", (Object)staff)).add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByAcademicYearAndInstitution(AcademicYear academicYear, Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear)).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByInstitution(Institution institution) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStudent(Student student) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student", (Object)student)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }

    public List<SickRoomVisitor> getSickRoomVisitorByStaff(Staff staff) {
        Criteria applicantCriteria = this.sessionFactory.getCurrentSession().createCriteria(SickRoomVisitor.class);
        applicantCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"staff", (Object)staff)));
        List sickRoomVisitorList = applicantCriteria.list();
        return sickRoomVisitorList;
    }
}
