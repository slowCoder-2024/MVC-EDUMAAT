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
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
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
public class StudentInvoiceDetailDAO
extends GenericDAO<StudentInvoiceDetail> {
    public StudentInvoiceDetailDAO() {
        super(StudentInvoiceDetail.class);
    }

    public StudentInvoiceDetail getStudentInvoiceDetailById(Long id) {
        StudentInvoiceDetail instance = (StudentInvoiceDetail)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail", (Serializable)id);
        return instance;
    }

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceIdAndInvoiceStatus(StudentInvoice studentInvoice, Integer invoiceStatus) {
        Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
        invoiceDetailCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoice", (Object)studentInvoice)).add((Criterion)Restrictions.eq((String)"studentInvoiceElementPaymentStatus", (Object)invoiceStatus)));
        ArrayList studentInvoiceDetails = (ArrayList)invoiceDetailCriteria.list();
        return studentInvoiceDetails;
    }

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByInvoiceId(StudentInvoice studentInvoice) {
        Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
        invoiceDetailCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoice", (Object)studentInvoice)));
        ArrayList studentInvoiceDetails = (ArrayList)invoiceDetailCriteria.list();
        return studentInvoiceDetails;
    }

    public ArrayList<StudentInvoiceDetail> getStudentPendingInvoiceFeesItemsByStudentIvoice(StudentInvoice studentInvoice) {
        Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
        invoiceDetailCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoice", (Object)studentInvoice)));
        ArrayList studentInvoiceDetails = (ArrayList)invoiceDetailCriteria.list();
        return studentInvoiceDetails;
    }

    public StudentInvoiceDetail getStudentInvoiceDetailByDate(Long studentInvoiceDetailId, Date fromDate, Date toDate) {
        Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
        invoiceDetailCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentInvoiceDetailId", (Object)studentInvoiceDetailId)));
        invoiceDetailCriteria.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
        StudentInvoiceDetail studentInvoiceDetail = (StudentInvoiceDetail)invoiceDetailCriteria.uniqueResult();
        return studentInvoiceDetail;
    }

    public List<StudentInvoiceDetail> getStudentInvoiceDetailForFeesItemReport(AcademicYear academicYear, FeesItem feesItem, Institution institution, Integer invoiceDetailStatus) {
        List studentInvoiceDetails = null;
        try {
            Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
            invoiceDetailCriteria.createAlias("studentInvoice", "studentInvoice");
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"studentInvoice.institution", (Object)institution));
            and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
            and.add((Criterion)Restrictions.eq((String)"feesItem", (Object)feesItem));
            and.add((Criterion)Restrictions.eq((String)"studentInvoiceElementPaymentStatus", (Object)invoiceDetailStatus));
            invoiceDetailCriteria.add((Criterion)and);
            studentInvoiceDetails = invoiceDetailCriteria.list();
            return studentInvoiceDetails;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoiceDetails;
        }
    }

    public List<StudentInvoiceDetail> getStudentInvoiceDetailForFeesItemRefundReport(AcademicYear academicYear, FeesItem feesItem, Institution institution) {
        List studentInvoiceDetails = null;
        try {
            Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
            invoiceDetailCriteria.createAlias("studentInvoice", "studentInvoice");
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"studentInvoice.institution", (Object)institution));
            and.add((Criterion)Restrictions.eq((String)"academicYear", (Object)academicYear));
            and.add((Criterion)Restrictions.eq((String)"feesItem", (Object)feesItem));
            invoiceDetailCriteria.add((Criterion)and);
            studentInvoiceDetails = invoiceDetailCriteria.list();
            return studentInvoiceDetails;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoiceDetails;
        }
    }

    public List<StudentInvoiceDetail> getStudentInvoiceDetailForFeesItemReportByDateRange(Date fromDate, Date toDate, FeesItem feesItem, Institution institution, Integer invoiceDetailStatus) {
        List studentInvoiceDetails = null;
        try {
            Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
            invoiceDetailCriteria.createAlias("studentInvoice", "studentInvoice");
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"studentInvoice.institution", (Object)institution));
            and.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
            and.add((Criterion)Restrictions.eq((String)"feesItem", (Object)feesItem));
            and.add((Criterion)Restrictions.eq((String)"studentInvoiceElementPaymentStatus", (Object)invoiceDetailStatus));
            invoiceDetailCriteria.add((Criterion)and);
            studentInvoiceDetails = invoiceDetailCriteria.list();
            return studentInvoiceDetails;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoiceDetails;
        }
    }

    public List<StudentInvoiceDetail> getStudentInvoiceDetailForFeesItemRefundReportByDateRange(Date fromDate, Date toDate, FeesItem feesItem, Institution institution) {
        List studentInvoiceDetails = null;
        try {
            Criteria invoiceDetailCriteria = this.sessionFactory.getCurrentSession().createCriteria(StudentInvoiceDetail.class);
            invoiceDetailCriteria.createAlias("studentInvoice", "studentInvoice");
            Conjunction and = Restrictions.conjunction();
            and.add((Criterion)Restrictions.eq((String)"studentInvoice.institution", (Object)institution));
            and.add(Restrictions.between((String)"generatedDate", (Object)fromDate, (Object)toDate));
            and.add((Criterion)Restrictions.eq((String)"feesItem", (Object)feesItem));
            invoiceDetailCriteria.add((Criterion)and);
            studentInvoiceDetails = invoiceDetailCriteria.list();
            return studentInvoiceDetails;
        }
        catch (Exception e) {
            e.printStackTrace();
            return studentInvoiceDetails;
        }
    }
}
