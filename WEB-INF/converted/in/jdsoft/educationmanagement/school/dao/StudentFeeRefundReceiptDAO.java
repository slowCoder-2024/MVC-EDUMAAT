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
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
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
public class StudentFeeRefundReceiptDAO
extends GenericDAO<StudentFeeRefundReceipt> {
    public StudentFeeRefundReceiptDAO() {
        super(StudentFeeRefundReceipt.class);
    }

    public StudentFeeRefundReceipt getStudentFeeRefundReceiptById(Long id) {
        StudentFeeRefundReceipt instance = (StudentFeeRefundReceipt)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt", (Serializable)id);
        return instance;
    }

    public List<StudentFeeRefundReceipt> getStudentFeeRefundReceiptByPaymentModeAndStatus(PaymentMode paymentMode, PaymentStatus paymentStatus) {
        Criteria StudentFeeRefundReceiptCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        StudentFeeRefundReceiptCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"paymentMode", (Object)paymentMode)).add((Criterion)Restrictions.eq((String)"paymentStatus", (Object)paymentStatus)));
        List StudentFeeRefundReceipts = StudentFeeRefundReceiptCriteria.list();
        return StudentFeeRefundReceipts;
    }

    public List<StudentFeeRefundReceipt> getStudentFeeRefundReceiptInInstitutionAndByStatus(Institution institution, PaymentStatus paymentStatus) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"paymentStatus", (Object)paymentStatus));
        receiptcriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)receiptcriteria.list();
        return StudentFeeRefundReceipts;
    }

    public List<StudentFeeRefundReceipt> getAllStudentFeeRefundReceipts(AcademicYear academicYear, Student student) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"student", (Object)student));
        invoicecriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)invoicecriteria.list();
        return StudentFeeRefundReceipts;
    }

    public List<StudentFeeRefundReceipt> getAllStudentsReceipts(AcademicYear academicYear, Institution institution) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        invoicecriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)invoicecriteria.list();
        return StudentFeeRefundReceipts;
    }

    public List<StudentFeeRefundReceipt> getStudentFeeRefundReceiptListByStudentInvoice(StudentInvoice studentInvoice) {
        Criteria invoicecriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentInvoice", (Object)studentInvoice));
        invoicecriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)invoicecriteria.list();
        return StudentFeeRefundReceipts;
    }

    public List<StudentFeeRefundReceipt> getStudentFeeRefundReceiptByDate(Date startDate, Date endDate, Institution institution) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.ge((String)"paymentReceivedDate", (Object)startDate));
        and.add((Criterion)Restrictions.le((String)"paymentReceivedDate", (Object)endDate));
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        receiptcriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)receiptcriteria.list();
        return StudentFeeRefundReceipts;
    }

    public ArrayList<StudentFeeRefundReceipt> getStudentFeeRefundReceiptByPaymentAndInstitution(Institution institution, PaymentMode paymentMode) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceipt.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"paymentMode", (Object)paymentMode));
        receiptcriteria.add((Criterion)and);
        ArrayList StudentFeeRefundReceipts = (ArrayList)receiptcriteria.list();
        return StudentFeeRefundReceipts;
    }
}
