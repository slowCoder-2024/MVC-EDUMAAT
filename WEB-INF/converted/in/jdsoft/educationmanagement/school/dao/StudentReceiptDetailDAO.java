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
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentReceiptDetailDAO
extends GenericDAO<StudentReceiptDetail> {
    public StudentReceiptDetailDAO() {
        super(StudentReceiptDetail.class);
    }

    public StudentReceiptDetail getStudentReceiptDetailById(Long id) {
        StudentReceiptDetail instance = (StudentReceiptDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentReceiptDetail", (Serializable)id);
        return instance;
    }

    public StudentReceiptDetail getStudentReceiptDetailByDate(Date fromDate, Date toDate, Long studentReceiptDetailId) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentReceiptDetailId", (Object)studentReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        StudentReceiptDetail studentReceiptDetail = (StudentReceiptDetail)receiptcriteria.uniqueResult();
        return studentReceiptDetail;
    }

    public StudentReceiptDetail getStudentReceiptDetailByDate(Date fromDate, Date toDate, Long studentReceiptDetailId, StudentReceipt StudentReceipt2) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentReceiptDetailId", (Object)studentReceiptDetailId)));
        receiptcriteria.add(Restrictions.between((String)"paymentClearedDate", (Object)fromDate, (Object)toDate));
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentReceipt", (Object)StudentReceipt2)));
        StudentReceiptDetail studentReceiptDetail = (StudentReceiptDetail)receiptcriteria.uniqueResult();
        return studentReceiptDetail;
    }

    public StudentReceiptDetail getStudentReceiptDetailByStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetail", (Object)studentInvoiceDetail)));
        StudentReceiptDetail studentReceiptDetail = (StudentReceiptDetail)receiptcriteria.uniqueResult();
        return studentReceiptDetail;
    }

    public List<StudentReceiptDetail> getStudentReceiptDetailListByStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        Criteria receiptcriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentReceiptDetail.class);
        receiptcriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetail", (Object)studentInvoiceDetail)));
        List studentReceiptDetail = receiptcriteria.list();
        return studentReceiptDetail;
    }
}
