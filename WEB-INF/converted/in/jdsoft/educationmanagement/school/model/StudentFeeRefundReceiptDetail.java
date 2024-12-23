/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_fee_refund_receipt_detail")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentFeeRefundReceiptDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentFeeRefundReceiptDetailId;
    private AcademicYear academicYear;
    private PaymentStatus paymentStatus;
    private StudentFeeRefundReceipt studentFeeRefundReceipt;
    private FeesItem feesItem;
    private StudentInvoiceDetail studentInvoiceDetail;
    private boolean discountApplied;
    private String discountType;
    private Double discountAmount;
    private String discountPercentage;
    private Double actualReceiptAmount;
    private Double paidReceiptAmount;
    private Date paymentReceivedDate;
    private Date paymentClearedDate;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

    public StudentFeeRefundReceiptDetail() {
    }

    public StudentFeeRefundReceiptDetail(AcademicYear academicYear, StudentFeeRefundReceipt studentFeeRefundReceipt, StudentInvoiceDetail studentInvoiceDetail, FeesItem feesItem, boolean discountApplied, String discountType, String discountPercentage, Double discountAmount, Double actualReceiptAmount, Double paidReceiptAmount, Date paymentReceivedDate, PaymentStatus paymentStatus, String createdBy, String modifiedBy) {
        this.studentFeeRefundReceipt = studentFeeRefundReceipt;
        this.academicYear = academicYear;
        this.studentInvoiceDetail = studentInvoiceDetail;
        this.feesItem = feesItem;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.discountAmount = discountAmount;
        this.discountType = discountType;
        this.discountPercentage = discountPercentage;
        this.discountApplied = discountApplied;
        this.actualReceiptAmount = actualReceiptAmount;
        this.paidReceiptAmount = paidReceiptAmount;
        this.paymentReceivedDate = paymentReceivedDate;
        this.paymentStatus = paymentStatus;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_fee_refund_receipt_detail_id", nullable=false)
    public Long getStudentFeeRefundReceiptDetailId() {
        return this.studentFeeRefundReceiptDetailId;
    }

    public void setStudentFeeRefundReceiptDetailId(Long studentFeeRefundReceiptDetailId) {
        this.studentFeeRefundReceiptDetailId = studentFeeRefundReceiptDetailId;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fees_item_id", nullable=false)
    @ForeignKey(name="feesTemplateItemInStudentFeeRefundReceiptDetail")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentFeeRefundReceiptsItems")
    @JsonIdentityReference(alwaysAsId=true)
    public FeesItem getFeesItem() {
        return this.feesItem;
    }

    public void setFeesItem(FeesItem feesItem) {
        this.feesItem = feesItem;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_invoice_detail_id", nullable=false)
    @ForeignKey(name="studentFeeRefundReceiptDetailInStudentInvoiceDetail")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentFeeRefundReceiptDetails")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentInvoiceDetail getStudentInvoiceDetail() {
        return this.studentInvoiceDetail;
    }

    public void setStudentInvoiceDetail(StudentInvoiceDetail studentInvoiceDetail) {
        this.studentInvoiceDetail = studentInvoiceDetail;
    }

    @Column(name="discount_type", nullable=true, length=100)
    public String getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @Column(name="discount_amount", nullable=true)
    public Double getDiscountAmount() {
        return this.discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Column(name="discount_percentage", nullable=true, length=100)
    public String getDiscountPercentage() {
        return this.discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Column(name="disount_applied", nullable=false)
    public boolean isDiscountApplied() {
        return this.discountApplied;
    }

    public void setDiscountApplied(boolean discountApplied) {
        this.discountApplied = discountApplied;
    }

    @Column(name="actual_receipt_amount", nullable=false)
    public Double getActualReceiptAmount() {
        return this.actualReceiptAmount;
    }

    public void setActualReceiptAmount(Double actualReceiptAmount) {
        this.actualReceiptAmount = actualReceiptAmount;
    }

    @Column(name="paid_receipt_amount", nullable=false)
    public Double getPaidReceiptAmount() {
        return this.paidReceiptAmount;
    }

    public void setPaidReceiptAmount(Double paidReceiptAmount) {
        this.paidReceiptAmount = paidReceiptAmount;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="payment_received_date", nullable=false)
    public Date getPaymentReceivedDate() {
        return this.paymentReceivedDate;
    }

    public void setPaymentReceivedDate(Date paymentReceivedDate) {
        this.paymentReceivedDate = paymentReceivedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInStudentFeeRefundReceiptDetail")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_status_id", nullable=false)
    @ForeignKey(name="paymentStatusInStudentReceiptDetail")
    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="payment_cleared_date", nullable=true)
    public Date getPaymentClearedDate() {
        return this.paymentClearedDate;
    }

    public void setPaymentClearedDate(Date paymentClearedDate) {
        this.paymentClearedDate = paymentClearedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_fee_refund_receipt_id", nullable=false)
    @ForeignKey(name="studentFeeRefundReceiptDetailsInStudentReceipt")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentFeeRefundReceiptDetails")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentFeeRefundReceipt getStudentFeeRefundReceipt() {
        return this.studentFeeRefundReceipt;
    }

    public void setStudentFeeRefundReceipt(StudentFeeRefundReceipt studentFeeRefundReceipt) {
        this.studentFeeRefundReceipt = studentFeeRefundReceipt;
    }
}
