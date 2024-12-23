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
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
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
public class StudentReceiptDAO
extends GenericDAO<StudentReceipt> {
    public StudentReceiptDAO() {
        super(StudentReceipt.class);
    }

    public StudentReceipt getStudentReceiptById(Long id) {
        StudentReceipt instance = (StudentReceipt)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentReceipt", (Serializable)id);
        return instance;
    }

    public List<StudentReceipt> getStudentReceiptByPaymentModeAndStatus(PaymentMode paymentMode, PaymentStatus paymentStatus) {
        Criteria studentReceiptCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        studentReceiptCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"paymentMode", (Object)paymentMode)).add((Criterion)Restrictions.eq((String)"paymentStatus", (Object)paymentStatus)));
        List studentReceipts = studentReceiptCriteria.list();
        return studentReceipts;
    }

    public List<StudentReceipt> getStudentReceiptInInstitutionAndByStatus(Institution institution, PaymentStatus paymentStatus) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"paymentStatus", (Object)paymentStatus));
        receiptcriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)receiptcriteria.list();
        return studentReceipts;
    }

    public List<StudentReceipt> getAllStudentReceipts(AcademicYear academicYear, Student student) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)invoicecriteria.list();
        return studentReceipts;
    }

    public List<StudentReceipt> getAllStudentsReceipts(AcademicYear academicYear, Institution institution) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)invoicecriteria.list();
        return studentReceipts;
    }

    public List<StudentReceipt> getStudentReceiptListByStudentInvoice(StudentInvoice studentInvoice) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentInvoice", (Object)studentInvoice));
        invoicecriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)invoicecriteria.list();
        return studentReceipts;
    }

    public List<StudentReceipt> getStudentReceiptByDate(Date startDate, Date endDate, Institution institution) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.ge((String)"paymentReceivedDate", (Object)startDate));
        and.add((Criterion)Restrictions.le((String)"paymentReceivedDate", (Object)endDate));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        receiptcriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)receiptcriteria.list();
        return studentReceipts;
    }

    public ArrayList<StudentReceipt> getStudentReceiptByPaymentAndInstitution(Institution institution, PaymentMode paymentMode) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"paymentMode", (Object)paymentMode));
        receiptcriteria.add((Criterion)and);
        ArrayList studentReceipts = (ArrayList)receiptcriteria.list();
        return studentReceipts;
    }
}
