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
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
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
@Table(name="tbl_student_receipt_fine")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentReceiptFine
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentReceiptFineId;
    private StudentReceipt studentReceipt;
    private AcademicYear academicYear;
    private Date paymentReceivedDate;
    private String fineTitle;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Double fineAmount;

    public StudentReceiptFine() {
    }

    public StudentReceiptFine(AcademicYear academicYear, StudentReceipt studentReceipt, Double fineAmount, Date paymentReceivedDate, String createdBy, String modifiedBy) {
        this.studentReceipt = studentReceipt;
        this.createdBy = createdBy;
        this.fineTitle = "Fine Amount";
        this.fineAmount = fineAmount;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.paymentReceivedDate = paymentReceivedDate;
        this.academicYear = academicYear;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_receipt_fine_id", nullable=false)
    public Long getStudentReceiptFineId() {
        return this.studentReceiptFineId;
    }

    public void setStudentReceiptFineId(Long studentReceiptFineId) {
        this.studentReceiptFineId = studentReceiptFineId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_receipt_id", nullable=false)
    @ForeignKey(name="studentReceiptFinesInStudentReceipt")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@receiptFines")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentReceipt getStudentReceipt() {
        return this.studentReceipt;
    }

    public void setStudentReceipt(StudentReceipt studentReceipt) {
        this.studentReceipt = studentReceipt;
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

    @Column(name="fine_amount", nullable=false)
    public Double getFineAmount() {
        return this.fineAmount;
    }

    public void setFineAmount(Double fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Column(name="fine_title", nullable=false, length=100)
    public String getFineTitle() {
        return this.fineTitle;
    }

    public void setFineTitle(String fineTitle) {
        this.fineTitle = fineTitle;
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
    @ForeignKey(name="academicYearInStudentReceiptFine")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentReceiptFines")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }
}
