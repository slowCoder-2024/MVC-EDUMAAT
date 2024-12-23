/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.Admission;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_admission_fees_payment_details", uniqueConstraints={@UniqueConstraint(columnNames={"admission_id", "transaction_code"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionFeesPaymentDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long feesPaymentId;
    private Admission admission;
    private double amountPaid;
    private String transactionCode;
    private String transactionStatus;
    private String bankName;
    private String paymentMode;
    private String IFSCCode;

    public AdmissionFeesPaymentDetails() {
    }

    public AdmissionFeesPaymentDetails(Admission admission, double amountPaid, String transactionCode, String transactionStatus, String bankName, String paymentMode, String iFSCCode) {
        this.admission = admission;
        this.amountPaid = amountPaid;
        this.transactionCode = transactionCode;
        this.transactionStatus = transactionStatus;
        this.bankName = bankName;
        this.paymentMode = paymentMode;
        this.IFSCCode = iFSCCode;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fees_payment_id", nullable=false)
    public Long getFeesPaymentId() {
        return this.feesPaymentId;
    }

    public void setFeesPaymentId(Long feesPaymentId) {
        this.feesPaymentId = feesPaymentId;
    }

    @OneToOne
    @JoinColumn(name="admission_id", nullable=false)
    public Admission getAdmission() {
        return this.admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @Column(name="fees_paid", nullable=false)
    public double getAmountPaid() {
        return this.amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    @Column(name="transaction_code", nullable=false, length=30)
    public String getTransactionCode() {
        return this.transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    @Column(name="transaction_status", nullable=false, length=10)
    public String getTransactionStatus() {
        return this.transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    @Column(name="bank_name", nullable=false, length=30)
    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name="payment_mode", nullable=false, length=20)
    public String getPaymentMode() {
        return this.paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Column(name="ifsc_code", nullable=false, length=20)
    public String getIFSCCode() {
        return this.IFSCCode;
    }

    public void setIFSCCode(String iFSCCode) {
        this.IFSCCode = iFSCCode;
    }
}
