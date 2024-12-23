/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.ManyToMany
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.PaymentMode;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_payment_status")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PaymentStatus
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long paymentStatusId;
    private String paymentStatusTitle;
    private Set<PaymentMode> paymentModes = new HashSet<PaymentMode>(0);
    private Set<StudentReceipt> studentReceipts = new HashSet<StudentReceipt>(0);
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);

    public PaymentStatus() {
    }

    public PaymentStatus(String paymentStatusTitle) {
        this.paymentStatusTitle = paymentStatusTitle;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_status_id", nullable=false)
    public Long getPaymentStatusId() {
        return this.paymentStatusId;
    }

    public void setPaymentStatusId(Long paymentStatusId) {
        this.paymentStatusId = paymentStatusId;
    }

    @Column(name="payment_status_title", nullable=false, length=100)
    public String getPaymentStatusTitle() {
        return this.paymentStatusTitle;
    }

    public void setPaymentStatusTitle(String paymentStatusTitle) {
        this.paymentStatusTitle = paymentStatusTitle;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="paymentStatusType")
    @ForeignKey(name="paymentStatusesInPaymentModes")
    public Set<PaymentMode> getPaymentModes() {
        return this.paymentModes;
    }

    public void setPaymentModes(Set<PaymentMode> paymentModes) {
        this.paymentModes = paymentModes;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="paymentStatus")
    @ForeignKey(name="paymentStatusInStudentReceipts")
    public Set<StudentReceipt> getStudentReceipts() {
        return this.studentReceipts;
    }

    public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
        this.studentReceipts = studentReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="paymentStatus")
    @ForeignKey(name="paymentStatusInStudentFeeRefundReceipts")
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
