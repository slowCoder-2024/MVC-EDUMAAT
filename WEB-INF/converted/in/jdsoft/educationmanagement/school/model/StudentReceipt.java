/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  org.hibernate.annotations.ForeignKey
 *  org.springframework.beans.factory.annotation.Autowired
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.components.NumberGenerator;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentInvoice;
import in.jdsoft.educationmanagement.school.model.StudentReceiptDetail;
import in.jdsoft.educationmanagement.school.model.StudentReceiptFine;
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
import org.hibernate.annotations.ForeignKey;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="tbl_student_receipt")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentReceipt
implements Serializable {
    @Autowired
    NumberGenerator numberGenerator;
    private static final long serialVersionUID = 1L;
    private Long receiptId;
    private Institution institution;
    private StudentInvoice studentInvoice;
    private String transactionNo;
    private PaymentMode paymentMode;
    private Date paymentReceivedDate;
    private Date paymentClearedDate;
    private Double amount;
    private Student student;
    private PaymentStatus paymentStatus;
    private String chequeNumber;
    private Date chequeDate;
    private String chequeBankName;
    private String chequeBranchName;
    private String ddNumber;
    private Date ddDate;
    private String ddBankName;
    private String ddBranchName;
    private String paymentGateway;
    private String paymentGatewayMode;
    private String comments;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private String receiptClearedBy;
    private String narration;
    private AcademicYear academicYear;
    private Set<StudentReceiptDetail> receiptDetails = new HashSet<StudentReceiptDetail>(0);
    private Set<StudentReceiptFine> receiptFines = new HashSet<StudentReceiptFine>(0);

    public StudentReceipt(Institution institution, AcademicYear academicYear, PaymentMode paymentMode, Date paymentReceivedDate, Double amount, Student student, PaymentStatus paymentStatus, String narration, String createdBy, String modifiedBy, StudentInvoice studentInvoice) {
        this.institution = institution;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.paymentReceivedDate = paymentReceivedDate;
        this.amount = amount;
        this.student = student;
        this.paymentStatus = paymentStatus;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.studentInvoice = studentInvoice;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.academicYear = academicYear;
        this.narration = narration;
    }

    public StudentReceipt(Institution institution, AcademicYear academicYear, PaymentMode paymentMode, Date chequeReceivedDate, Double amount, Student student, PaymentStatus paymentStatus, String chequeNumber, Date chequeDate, String chequeBankName, String chequeBranchName, String narration, String createdBy, String modifiedBy, StudentInvoice studentInvoice) {
        this.institution = institution;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.paymentReceivedDate = chequeReceivedDate;
        this.amount = amount;
        this.student = student;
        this.paymentStatus = paymentStatus;
        this.chequeNumber = chequeNumber;
        this.chequeDate = chequeDate;
        this.chequeBankName = chequeBankName;
        this.chequeBranchName = chequeBranchName;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.studentInvoice = studentInvoice;
        this.academicYear = academicYear;
        this.narration = narration;
    }

    public StudentReceipt(Institution institution, AcademicYear academicYear, PaymentMode paymentMode, Double amount, Student student, PaymentStatus paymentStatus, String ddNumber, Date ddDate, String ddBankName, String ddBranchName, Date ddReceivedDate, String narration, String createdBy, String modifiedBy, StudentInvoice studentInvoice) {
        this.institution = institution;
        this.transactionNo = Long.toString(System.currentTimeMillis());
        this.paymentMode = paymentMode;
        this.paymentReceivedDate = ddReceivedDate;
        this.amount = amount;
        this.student = student;
        this.paymentStatus = paymentStatus;
        this.ddNumber = ddNumber;
        this.ddDate = ddDate;
        this.ddBankName = ddBankName;
        this.ddBranchName = ddBranchName;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.studentInvoice = studentInvoice;
        this.academicYear = academicYear;
        this.narration = narration;
    }

    public StudentReceipt(Institution institution, String transactionNo, AcademicYear academicYear, PaymentMode paymentMode, Date paymentReceivedDate, Double amount, Student student, PaymentStatus paymentStatus, String narration, String paymentGateway, String paymentGatewayMode, String createdBy, String modifiedBy, StudentInvoice studentInvoice) {
        this.institution = institution;
        this.transactionNo = transactionNo;
        this.paymentMode = paymentMode;
        this.paymentReceivedDate = paymentReceivedDate;
        this.amount = amount;
        this.student = student;
        this.paymentStatus = paymentStatus;
        this.paymentGateway = paymentGateway;
        this.paymentGatewayMode = paymentGatewayMode;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.studentInvoice = studentInvoice;
        this.academicYear = academicYear;
        this.narration = narration;
    }

    public StudentReceipt() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_receipt_id", nullable=false)
    public Long getReceiptId() {
        return this.receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="studentReceiptsInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentReceipts")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_mode_id", nullable=false)
    @ForeignKey(name="studentReceiptsInPaymentmode")
    public PaymentMode getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Column(name="transaction_no", nullable=false, length=100)
    public String getTransactionNo() {
        return this.transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    @Column(name="payment_gateway", nullable=true, length=100)
    public String getPaymentGateway() {
        return this.paymentGateway;
    }

    public void setPaymentGateway(String paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @Column(name="dd_number", nullable=true, length=100)
    public String getDdNumber() {
        return this.ddNumber;
    }

    public void setDdNumber(String ddNumber) {
        this.ddNumber = ddNumber;
    }

    @Column(name="cheque_number", nullable=true, length=100)
    public String getChequeNumber() {
        return this.chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    @Column(name="total_receipt_amount", nullable=false)
    public Double getAmount() {
        return this.amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentReceiptsInStudent")
    @JsonManagedReference
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name="receipt_comments", nullable=true, length=100)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="payment_status_id", nullable=false)
    @ForeignKey(name="studentReceiptsInPaymentStatus")
    public PaymentStatus getPaymentStatus() {
        return this.paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="payment_received_date", nullable=false)
    public Date getPaymentReceivedDate() {
        return this.paymentReceivedDate;
    }

    public void setPaymentReceivedDate(Date paymentReceivedDate) {
        this.paymentReceivedDate = paymentReceivedDate;
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

    @Temporal(value=TemporalType.DATE)
    @Column(name="payment_cleared_date", nullable=true)
    public Date getPaymentClearedDate() {
        return this.paymentClearedDate;
    }

    public void setPaymentClearedDate(Date paymentClearedDate) {
        this.paymentClearedDate = paymentClearedDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="cheque_date", nullable=true)
    public Date getChequeDate() {
        return this.chequeDate;
    }

    public void setChequeDate(Date chequeDate) {
        this.chequeDate = chequeDate;
    }

    @Column(name="cheque_bank_name", nullable=true, length=100)
    public String getChequeBankName() {
        return this.chequeBankName;
    }

    public void setChequeBankName(String chequeBankName) {
        this.chequeBankName = chequeBankName;
    }

    @Column(name="cheque_branch_name", nullable=true, length=100)
    public String getChequeBranchName() {
        return this.chequeBranchName;
    }

    public void setChequeBranchName(String chequeBranchName) {
        this.chequeBranchName = chequeBranchName;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="dd_date", nullable=true)
    public Date getDDDate() {
        return this.ddDate;
    }

    public void setDDDate(Date ddDate) {
        this.ddDate = ddDate;
    }

    @Column(name="dd_bank_name", nullable=true, length=100)
    public String getDdBankName() {
        return this.ddBankName;
    }

    public void setDdBankName(String ddBankName) {
        this.ddBankName = ddBankName;
    }

    @Column(name="dd_branch_name", nullable=true, length=100)
    public String getDdBranchName() {
        return this.ddBranchName;
    }

    public void setDdBranchName(String ddBranchName) {
        this.ddBranchName = ddBranchName;
    }

    @Column(name="payment_gateway_mode", nullable=true, length=100)
    public String getPaymentGatewayMode() {
        return this.paymentGatewayMode;
    }

    public void setPaymentGatewayMode(String paymentGatewayMode) {
        this.paymentGatewayMode = paymentGatewayMode;
    }

    @Column(name="receipt_cleared_by", nullable=true, length=100)
    public String getReceiptClearedBy() {
        return this.receiptClearedBy;
    }

    public void setReceiptClearedBy(String receiptClearedBy) {
        this.receiptClearedBy = receiptClearedBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentReceipt", cascade={CascadeType.ALL})
    @ForeignKey(name="studentReceiptInStudentReceiptDetails")
    @OrderBy(value="student_receipt_detail_id ASC")
    public Set<StudentReceiptDetail> getReceiptDetails() {
        return this.receiptDetails;
    }

    public void setReceiptDetails(Set<StudentReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="studentReceiptsInAcademicYear")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentReceipts")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentReceipt", cascade={CascadeType.ALL})
    @ForeignKey(name="studentReceiptInStudentReceiptFines")
    @OrderBy(value="student_receipt_fine_id ASC")
    public Set<StudentReceiptFine> getReceiptFines() {
        return this.receiptFines;
    }

    public void setReceiptFines(Set<StudentReceiptFine> receiptFines) {
        this.receiptFines = receiptFines;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_invoice_id", nullable=false)
    @ForeignKey(name="studentReceiptInStudentInvoice")
    @JsonManagedReference
    public StudentInvoice getStudentInvoice() {
        return this.studentInvoice;
    }

    public void setStudentInvoice(StudentInvoice studentInvoice) {
        this.studentInvoice = studentInvoice;
    }

    @Column(name="narration", nullable=true, length=255)
    public String getNarration() {
        return this.narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }
}
