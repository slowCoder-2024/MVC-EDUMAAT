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
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import java.io.Serializable;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentPartialPaymentReceiptDetailDAO
extends GenericDAO<StudentPartialPaymentReceiptDetail> {
    public StudentPartialPaymentReceiptDetailDAO() {
        super(StudentPartialPaymentReceiptDetail.class);
    }

    public StudentPartialPaymentReceiptDetail getStudentPartialPaymentReceiptDetailById(Long id) {
        StudentPartialPaymentReceiptDetail instance = (StudentPartialPaymentReceiptDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail", (Serializable)id);
        return instance;
    }

    public StudentPartialPaymentReceiptDetail getStudentPartialPaymentReceiptDetailByDate(Date fromDate, Date toDate, Long studentPartialPaymentReceiptDetailId) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentPartialPaymentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentPartialPaymentReceiptDetailId", (Object)studentPartialPaymentReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        StudentPartialPaymentReceiptDetail StudentPartialPaymentReceiptDetail2 = (StudentPartialPaymentReceiptDetail)receiptcriteria.uniqueResult();
        return StudentPartialPaymentReceiptDetail2;
    }

    public StudentPartialPaymentReceiptDetail getStudentPartialPaymentReceiptDetailByDate(Date fromDate, Date toDate, Long studentPartialPaymentReceiptDetailId, StudentReceiptDetail studentReceiptDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentPartialPaymentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentPartialPaymentReceiptDetailId", (Object)studentPartialPaymentReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentReceiptDetail", (Object)studentReceiptDetail)));
        StudentPartialPaymentReceiptDetail StudentPartialPaymentReceiptDetail2 = (StudentPartialPaymentReceiptDetail)receiptcriteria.uniqueResult();
        return StudentPartialPaymentReceiptDetail2;
    }

    public StudentPartialPaymentReceiptDetail getStudentPartialPaymentReceiptDetailByStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentPartialPaymentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetail", (Object)studentInvoiceDetail)));
        StudentPartialPaymentReceiptDetail StudentPartialPaymentReceiptDetail2 = (StudentPartialPaymentReceiptDetail)receiptcriteria.uniqueResult();
        return StudentPartialPaymentReceiptDetail2;
    }
}
