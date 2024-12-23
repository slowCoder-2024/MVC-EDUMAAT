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
 *  javax.persistence.JoinColumn
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.PaymentStatus;
import in.jdsoft.educationmanagement.school.model.StudentFeeRefundReceipt;
import in.jdsoft.educationmanagement.school.model.StudentReceipt;
import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_payment_mode")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PaymentMode
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long paymentModeId;
    private String paymentModeTitle;
    private Integer visibility;
    private Set<PaymentStatus> paymentStatusType = new HashSet<PaymentStatus>(0);
    private Set<StudentReceipt> studentReceipts = new HashSet<StudentReceipt>(0);
    private Set<StudentFeeRefundReceipt> studentFeeRefundReceipts = new HashSet<StudentFeeRefundReceipt>(0);
    private Set<InventoryReceipt> inventoryReceipts = new LinkedHashSet<InventoryReceipt>();

    public PaymentMode() {
    }

    public PaymentMode(String paymentModeTitle, Integer visibility) {
        this.paymentModeTitle = paymentModeTitle;
        this.visibility = visibility;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="payment_mode_id", nullable=false)
    public Long getPaymentModeId() {
        return this.paymentModeId;
    }

    public void setPaymentModeId(Long paymentModeId) {
        this.paymentModeId = paymentModeId;
    }

    @Column(name="payment_mode_title", nullable=false, length=100)
    public String getPaymentModeTitle() {
        return this.paymentModeTitle;
    }

    public void setPaymentModeTitle(String paymentModeTitle) {
        this.paymentModeTitle = paymentModeTitle;
    }

    @Column(name="payment_mode_visibility", nullable=false)
    public Integer getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_payment_mode_and_payment_status_mapping", joinColumns={@JoinColumn(name="payment_mode_id", updatable=false)}, inverseJoinColumns={@JoinColumn(name="payment_status_id", updatable=false)})
    @ForeignKey(name="paymentModesInPaymentStatuses")
    @OrderBy(value="payment_status_id ASC")
    public Set<PaymentStatus> getPaymentStatusType() {
        return this.paymentStatusType;
    }

    public void setPaymentStatusType(Set<PaymentStatus> paymentStatusType) {
        this.paymentStatusType = paymentStatusType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="paymentMode")
    @ForeignKey(name="paymentModeInStudentReceipts")
    public Set<StudentReceipt> getStudentReceipts() {
        return this.studentReceipts;
    }

    public void setStudentReceipts(Set<StudentReceipt> studentReceipts) {
        this.studentReceipts = studentReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="paymentMode")
    @ForeignKey(name="paymentModeInInventoryReceipts")
    public Set<InventoryReceipt> getInventoryReceipts() {
        return this.inventoryReceipts;
    }

    public void setInventoryReceipts(Set<InventoryReceipt> inventoryReceipts) {
        this.inventoryReceipts = inventoryReceipts;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="paymentMode")
    @ForeignKey(name="paymentModeInStudentFeeRefundReceipts")
    public Set<StudentFeeRefundReceipt> getStudentFeeRefundReceipts() {
        return this.studentFeeRefundReceipts;
    }

    public void setStudentFeeRefundReceipts(Set<StudentFeeRefundReceipt> studentFeeRefundReceipts) {
        this.studentFeeRefundReceipts = studentFeeRefundReceipts;
    }
}
