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
import in.jdsoft.educationmanagement.school.exceptions.StudentInvoiceException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentInvoiceDAO
extends GenericDAO<StudentInvoice> {
    public StudentInvoiceDAO() {
        super(StudentInvoice.class);
    }

    public StudentInvoice getStudentInvoiceById(Long id) {
        StudentInvoice instance = (StudentInvoice)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentInvoice", (Serializable)id);
        return instance;
    }

    public ArrayList<StudentInvoice> getStudentPendingInvoices(Student student) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        invoicecriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"student", (Object)student)).add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)1)));
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        Collections.sort(studentInvoices, new Comparator<StudentInvoice>(){

            @Override
            public int compare(StudentInvoice o1, StudentInvoice o2) {
                return o1.getStudentInvoiceId().compareTo(o2.getStudentInvoiceId());
            }
        });
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForDueRange(Date startDate, Date endDate, Institution institution) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.ge((String)"generatedDate", (Object)startDate));
        and.add((Criterion)Restrictions.le((String)"generatedDate", (Object)endDate));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForDueRange(Date startDate, Date endDate) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.ge((String)"generatedDate", (Object)startDate));
        and.add((Criterion)Restrictions.le((String)"generatedDate", (Object)endDate));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getAllStudentInvoices(AcademicYear academicYear, Student student) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getAllStudentsInvoices(AcademicYear academicYear, Institution institution) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getAllStudentsInvoices(AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        invoicecriteria.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesInInstitutionAndByStatus(Institution institution, Integer invoiceStatus) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByAcademicYear(Student student, AcademicYear academicYear) throws StudentInvoiceException {
        try {
            Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
            and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
            invoicecriteria.add((Criterion)and);
            ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
            return studentInvoices;
        }
        catch (Exception re) {
            throw new StudentInvoiceException(new Message("failure", "Cannot delete invoices first delete receipts "));
        }
    }

    public List<StudentInvoice> getStudentInvoicesByAcademicYearAndInvoiceStatus(Student student, AcademicYear academicYear, Integer invoiceStatus) throws StudentInvoiceException {
        try {
            Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
            and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
            and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
            invoicecriteria.add((Criterion)and);
            ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
            return studentInvoices;
        }
        catch (Exception re) {
            throw new StudentInvoiceException(new Message("failure", "Cannot delete invoices first delete receipts "));
        }
    }

    public List<StudentInvoice> getStudentInvoicesByClassAndAcademicYearAndInvoiceStatus(StudentStatus studentStatus, Class classes, AcademicYear academicYear, Integer invoiceStatus) throws StudentInvoiceException {
        try {
            Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class).createAlias("student", "student");
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"student.studentClass", (Object)classes));
            and.add((Criterion)Restrictions.eq((String)"student.studentStatus", (Object)studentStatus));
            and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
            and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
            invoicecriteria.add((Criterion)and);
            ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
            return studentInvoices;
        }
        catch (Exception re) {
            throw new StudentInvoiceException(new Message("failure", "Cannot delete invoices first delete receipts "));
        }
    }

    public List<StudentInvoice> getStudentInvoicesForReporting(Institution institution, FeesTerm feesTerm, AcademicYear academicYear, Integer invoiceStatus) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForRefundReporting(Institution institution, FeesTerm feesTerm, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByPartiallyAndFullyForReporting(Institution institution, FeesTerm feesTerm, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByPartiallyAndFullyForReporting(FeesTerm feesTerm, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForReportingByDateRange(Date fromDate, Date toDate, Institution institution, FeesTerm feesTerm, Integer invoiceStatus) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
        and.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForRefundReportingByDateRange(Date fromDate, Date toDate, Institution institution, FeesTerm feesTerm) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"feesTerm", (Object)feesTerm));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForReportingInAllTerms(Institution institution, AcademicYear academicYear, Integer invoiceStatus) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForReporting(Student student, Institution institution, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByAcademicYear(AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByAcademicYearAndStudent(Student student, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesByStudentAndAcademicYear(Student student, AcademicYear academicYear) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForReportingByAcademicYear(AcademicYear academicYear, Institution institution) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }

    public List<StudentInvoice> getStudentInvoicesForReportingInAllTermsByDateRange(Date fromDate, Date toDate, Institution institution, Integer invoiceStatus) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoice.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"invoiceStatus", (Object)invoiceStatus));
        and.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
        invoicecriteria.add((Criterion)and);
        ArrayList studentInvoices = (ArrayList)invoicecriteria.list();
        return studentInvoices;
    }
}
