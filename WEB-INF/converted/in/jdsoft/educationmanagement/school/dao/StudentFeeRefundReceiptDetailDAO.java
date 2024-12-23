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
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentFeeRefundReceiptDetailDAO
extends GenericDAO<StudentFeeRefundReceiptDetail> {
    public StudentFeeRefundReceiptDetailDAO() {
        super(StudentFeeRefundReceiptDetail.class);
    }

    public StudentFeeRefundReceiptDetail getStudentFeeRefundReceiptDetailById(Long id) {
        StudentFeeRefundReceiptDetail instance = (StudentFeeRefundReceiptDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail", (Serializable)id);
        return instance;
    }

    public StudentFeeRefundReceiptDetail getStudentFeeRefundReceiptDetailByDate(Date fromDate, Date toDate, Long StudentFeeRefundReceiptDetailId) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentFeeRefundReceiptDetailId", (Object)StudentFeeRefundReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 = (StudentFeeRefundReceiptDetail)receiptcriteria.uniqueResult();
        return StudentFeeRefundReceiptDetail2;
    }

    public StudentFeeRefundReceiptDetail getStudentFeeRefundReceiptDetailByDate(Date fromDate, Date toDate, Long StudentFeeRefundReceiptDetailId, StudentFeeRefundReceipt StudentFeeRefundReceipt2) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentFeeRefundReceiptDetailId", (Object)StudentFeeRefundReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentFeeRefundReceipt", (Object)StudentFeeRefundReceipt2)));
        StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 = (StudentFeeRefundReceiptDetail)receiptcriteria.uniqueResult();
        return StudentFeeRefundReceiptDetail2;
    }

    public StudentFeeRefundReceiptDetail getStudentFeeRefundReceiptDetailByStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetail", (Object)studentInvoiceDetail)));
        StudentFeeRefundReceiptDetail StudentFeeRefundReceiptDetail2 = (StudentFeeRefundReceiptDetail)receiptcriteria.uniqueResult();
        return StudentFeeRefundReceiptDetail2;
    }

    public List<StudentFeeRefundReceiptDetail> getStudentFeeRefundReceiptDetailListByStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentFeeRefundReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetail", (Object)studentInvoiceDetail)));
        List StudentFeeRefundReceiptDetail2 = receiptcriteria.list();
        return StudentFeeRefundReceiptDetail2;
    }
}
