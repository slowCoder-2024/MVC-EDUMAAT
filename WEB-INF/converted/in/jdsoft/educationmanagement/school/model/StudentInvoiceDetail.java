/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentPartialPaymentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_invoice_details")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentInvoiceDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentInvoiceDetailId;
    private StudentInvoice studentInvoice;
    private AcademicYear academicYear;
    private FeesItem feesItem;
    private double studentInvoiceElementAmount;
    private double studentInvoiceElementTaxAmount;
    private double studentInvoiceElementTotalAmount;
    private Integer studentInvoiceElementPaymentStatus;
    private String createdBy;
    private String modifiedBy;
    private Date generatedDate;
    private Date createdDate;
    private Date modifiedDate;
    private Date lastDateForPayment;
    private StudentReceiptDetail studentReceiptDetail;
    private StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail;
    private FeesPenaltySetting feesPenaltySetting;
    private Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptDetails = new LinkedHashSet<StudentFeeRefundReceiptDetail>();

    public StudentInvoiceDetail() {
    }

    public StudentInvoiceDetail(AcademicYear academicYear, StudentInvoice studentInvoice, FeesItem feesItem, double studentInvoiceElementAmount, double studentInvoiceElementTaxAmount, Integer studentInvoiceElementPaymentStatus, String createdBy, String modifiedBy) {
        this.studentInvoice = studentInvoice;
        this.academicYear = academicYear;
        this.feesItem = feesItem;
        this.studentInvoiceElementAmount = studentInvoiceElementAmount;
        this.studentInvoiceElementTaxAmount = studentInvoiceElementTaxAmount;
        this.studentInvoiceElementTotalAmount = studentInvoiceElementAmount + studentInvoiceElementTaxAmount;
        this.studentInvoiceElementPaymentStatus = studentInvoiceElementPaymentStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.generatedDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        Date d = new Date();
        d.setTime(d.getTime() + 2592000000L);
        this.lastDateForPayment = d;
    }

    public StudentInvoiceDetail(AcademicYear academicYear, StudentInvoice studentInvoice, FeesItem feesItem, double studentInvoiceElementAmount, double studentInvoiceElementTaxAmount, Integer studentInvoiceElementPaymentStatus, String createdBy, String modifiedBy, Long dueDays, FeesPenaltySetting feesPenaltySetting) {
        this.studentInvoice = studentInvoice;
        this.academicYear = academicYear;
        this.feesItem = feesItem;
        this.studentInvoiceElementAmount = studentInvoiceElementAmount;
        this.studentInvoiceElementTaxAmount = studentInvoiceElementTaxAmount;
        this.studentInvoiceElementTotalAmount = studentInvoiceElementAmount + studentInvoiceElementTaxAmount;
        this.studentInvoiceElementPaymentStatus = studentInvoiceElementPaymentStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.generatedDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        Date d = new Date();
        d.setTime(d.getTime() + dueDays * 24L * 60L * 60L * 1000L);
        this.lastDateForPayment = d;
        this.feesPenaltySetting = feesPenaltySetting;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_invoice_detail_id", nullable=false)
    public Long getStudentInvoiceDetailId() {
        return this.studentInvoiceDetailId;
    }

    public void setStudentInvoiceDetailId(Long studentInvoiceDetailId) {
        this.studentInvoiceDetailId = studentInvoiceDetailId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_invoice_id", nullable=false)
    @ForeignKey(name="studentInvoiceDetailsInStudentInvoice")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentInvoiceDetails")
    public StudentInvoice getStudentInvoice() {
        return this.studentInvoice;
    }

    public void setStudentInvoice(StudentInvoice studentInvoice) {
        this.studentInvoice = studentInvoice;
    }

    @Column(name="student_invoice_element_amount", nullable=false)
    public double getStudentInvoiceElementAmount() {
        return this.studentInvoiceElementAmount;
    }

    public void setStudentInvoiceElementAmount(double studentInvoiceElementAmount) {
        this.studentInvoiceElementAmount = studentInvoiceElementAmount;
    }

    @Column(name="student_invoice_element_tax_amount", nullable=false)
    public double getStudentInvoiceElementTaxAmount() {
        return this.studentInvoiceElementTaxAmount;
    }

    public void setStudentInvoiceElementTaxAmount(double studentInvoiceElementTaxAmount) {
        this.studentInvoiceElementTaxAmount = studentInvoiceElementTaxAmount;
    }

    @Column(name="student_invoice_element_total_amount", nullable=false)
    public double getStudentInvoiceElementTotalAmount() {
        return this.studentInvoiceElementTotalAmount;
    }

    public void setStudentInvoiceElementTotalAmount(double studentInvoiceElementTotalAmount) {
        this.studentInvoiceElementTotalAmount = studentInvoiceElementTotalAmount;
    }

    @Column(name="student_invoice_element_payment_status", nullable=false)
    public Integer getStudentInvoiceElementPaymentStatus() {
        return this.studentInvoiceElementPaymentStatus;
    }

    public void setStudentInvoiceElementPaymentStatus(Integer studentInvoiceElementPaymentStatus) {
        this.studentInvoiceElementPaymentStatus = studentInvoiceElementPaymentStatus;
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
    @ForeignKey(name="studentInvoiceItemsInFeesItem")
    @JsonManagedReference
    public FeesItem getFeesItem() {
        return this.feesItem;
    }

    public void setFeesItem(FeesItem feesItem) {
        this.feesItem = feesItem;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="generated_date", nullable=false)
    public Date getGeneratedDate() {
        return this.generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInStudentInvoiceDetail")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="last_date_for_payment", nullable=false)
    public Date getLastDateForPayment() {
        return this.lastDateForPayment;
    }

    public void setLastDateForPayment(Date lastDateForPayment) {
        this.lastDateForPayment = lastDateForPayment;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="student_receipt_detail_id", nullable=true)
    @ForeignKey(name="studentInvoiceDetailInStudentReceiptDetail")
    @JsonManagedReference
    public StudentReceiptDetail getStudentReceiptDetail() {
        return this.studentReceiptDetail;
    }

    public void setStudentReceiptDetail(StudentReceiptDetail studentReceiptDetail) {
        this.studentReceiptDetail = studentReceiptDetail;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="student_partial_payment_receipt_detail_id", nullable=true)
    @ForeignKey(name="studentInvoiceDetailInStudentPartialPaymentReceiptDetail")
    @JsonManagedReference
    public StudentPartialPaymentReceiptDetail getStudentPartialPaymentReceiptDetail() {
        return this.studentPartialPaymentReceiptDetail;
    }

    public void setStudentPartialPaymentReceiptDetail(StudentPartialPaymentReceiptDetail studentPartialPaymentReceiptDetail) {
        this.studentPartialPaymentReceiptDetail = studentPartialPaymentReceiptDetail;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fees_penalty_setting_id", nullable=false)
    @ForeignKey(name="feesPenaltySettingInStudentInvoiceDetail")
    public FeesPenaltySetting getFeesPenaltySetting() {
        return this.feesPenaltySetting;
    }

    public void setFeesPenaltySetting(FeesPenaltySetting feesPenaltySetting) {
        this.feesPenaltySetting = feesPenaltySetting;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentInvoiceDetail")
    @ForeignKey(name="studentInvoiceInStudentFeeRefundReceiptDetailss")
    @OrderBy(value="student_fee_refund_receipt_detail_id ASC")
    public Set<StudentFeeRefundReceiptDetail> getStudentFeeRefundReceiptDetails() {
        return this.studentFeeRefundReceiptDetails;
    }

    public void setStudentFeeRefundReceiptDetails(Set<StudentFeeRefundReceiptDetail> studentFeeRefundReceiptDetails) {
        this.studentFeeRefundReceiptDetails = studentFeeRefundReceiptDetails;
    }
}
