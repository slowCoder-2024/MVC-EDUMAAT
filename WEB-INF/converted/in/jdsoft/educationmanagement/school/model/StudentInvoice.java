/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
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
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 *  org.springframework.beans.factory.annotation.Autowired
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.components.NumberGenerator;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentInvoiceDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="tbl_student_invoice", uniqueConstraints={@UniqueConstraint(columnNames={"invoice_no"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentInvoice
implements Serializable {
    @Autowired
    NumberGenerator numberGenerator;
    private static final long serialVersionUID = 1L;
    private Long studentInvoiceId;
    private Student student;
    private AcademicYear academicYear;
    private FeesTerm feesTerm;
    private String invoiceNo;
    private Integer invoiceStatus;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date generatedDate;
    private Date modifiedDate;
    private Date lastDateForPayment;
    private Institution institution;
    private double invoiceAmount;
    private boolean discountApplicable;
    private StudentReceipt studentReceipt;
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);
    private Set<StudentInvoiceDetail> studentInvoiceDetails = new HashSet<StudentInvoiceDetail>(0);
    private FeesPenaltySetting feesPenaltySetting;

    public StudentInvoice() {
    }

    public StudentInvoice(Student student, AcademicYear academicYear, FeesTerm feesTerm, Integer invoiceStatus, String createdBy, String modifiedBy, Institution institution, boolean discountApplicable) {
        this.student = student;
        this.invoiceNo = Long.toString(System.currentTimeMillis());
        this.invoiceStatus = invoiceStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.generatedDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        Date d = new Date();
        d.setTime(d.getTime() + 2592000000L);
        this.lastDateForPayment = d;
        this.institution = institution;
        this.academicYear = academicYear;
        this.feesTerm = feesTerm;
        this.discountApplicable = discountApplicable;
    }

    public StudentInvoice(Student student, AcademicYear academicYear, FeesTerm feesTerm, Integer invoiceStatus, String createdBy, String modifiedBy, Institution institution, boolean discountApplicable, Long dueDays, FeesPenaltySetting feesPenaltySetting) {
        this.student = student;
        this.invoiceNo = Long.toString(System.currentTimeMillis());
        this.invoiceStatus = invoiceStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.generatedDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        Date d = new Date();
        d.setTime(d.getTime() + dueDays * 24L * 60L * 60L * 1000L);
        this.lastDateForPayment = d;
        this.institution = institution;
        this.academicYear = academicYear;
        this.feesTerm = feesTerm;
        this.discountApplicable = discountApplicable;
        this.feesPenaltySetting = feesPenaltySetting;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_invoice_id", nullable=false)
    public Long getStudentInvoiceId() {
        return this.studentInvoiceId;
    }

    public void setStudentInvoiceId(Long studentInvoiceId) {
        this.studentInvoiceId = studentInvoiceId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentInvoicesInStudent")
    @JsonManagedReference
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name="invoice_no", nullable=false, length=100)
    public String getInvoiceNo() {
        return this.invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    @Column(name="invoice_status", nullable=false)
    public Integer getInvoiceStatus() {
        return this.invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
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
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="studentInvoicesInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentInvoice", cascade={CascadeType.ALL, CascadeType.REMOVE})
    @ForeignKey(name="studentInvoiceInStudentInvoiceDetails")
    @OrderBy(value="student_invoice_detail_id ASC")
    public Set<StudentInvoiceDetail> getStudentInvoiceDetails() {
        return this.studentInvoiceDetails;
    }

    public void setStudentInvoiceDetails(Set<StudentInvoiceDetail> studentInvoiceDetails) {
        this.studentInvoiceDetails = studentInvoiceDetails;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="studentInvoicesInAcademicYear")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentInvoices")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @Column(name="invoice_amount", nullable=false)
    public double getInvoiceAmount() {
        return this.invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fees_term_id", nullable=false)
    @ForeignKey(name="feesTermInStudentInvoice")
    public FeesTerm getFeesTerm() {
        return this.feesTerm;
    }

    public void setFeesTerm(FeesTerm feesTerm) {
        this.feesTerm = feesTerm;
    }

    @Column(name="discount_applicable", nullable=false)
    public boolean isDiscountApplicable() {
        return this.discountApplicable;
    }

    public void setDiscountApplicable(boolean discountApplicable) {
        this.discountApplicable = discountApplicable;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="generated_date", nullable=false)
    public Date getGeneratedDate() {
        return this.generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JsonBackReference
    public StudentReceipt getStudentReceipt() {
        return this.studentReceipt;
    }

    public void setStudentReceipt(StudentReceipt studentReceipt) {
        this.studentReceipt = studentReceipt;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="last_date_for_payment", nullable=false)
    public Date getLastDateForPayment() {
        return this.lastDateForPayment;
    }

    public void setLastDateForPayment(Date lastDateForPayment) {
        this.lastDateForPayment = lastDateForPayment;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fees_penalty_setting_id", nullable=false)
    @ForeignKey(name="feesPenaltySettingInStudentInvoice")
    public FeesPenaltySetting getFeesPenaltySetting() {
        return this.feesPenaltySetting;
    }

    public void setFeesPenaltySetting(FeesPenaltySetting feesPenaltySetting) {
        this.feesPenaltySetting = feesPenaltySetting;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentInvoice")
    @ForeignKey(name="studentInvoiceInStudentFeeRefundReceipts")
    @OrderBy(value="student_fee_refund_receipt_id ASC")
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
