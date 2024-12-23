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
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToOne
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
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_purchase_requisition")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PurchaseRequisition
implements Serializable {
    private Long purchaseRequisitionId;
    private Double quantity;
    private String inventoryItemName;
    private String description;
    private String purchaseReason;
    private User purchaseRequistionBy;
    private User purchaseApproverBy;
    private String approvalStatus;
    private Date expectedDate;
    private String approvedBy;
    private Date createdDate;
    private Date modifiedDate;
    private PortalTask portalTask;
    private String approverComment;
    private RequisitionType requisitionType;
    private static final long serialVersionUID = 1L;

    public PurchaseRequisition(Double quantity, String inventoryItemName, String description, String purchaseReason, User purchaseRequistionBy, User purchaseApproverBy, String approvalStatus, Date expectedDate, PortalTask portalTask, RequisitionType requisitionType) {
        this.quantity = quantity;
        this.inventoryItemName = inventoryItemName;
        this.description = description;
        this.purchaseReason = purchaseReason;
        this.purchaseRequistionBy = purchaseRequistionBy;
        this.purchaseApproverBy = purchaseApproverBy;
        this.approvalStatus = approvalStatus;
        this.expectedDate = expectedDate;
        this.approvedBy = "Pending";
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.portalTask = portalTask;
        this.requisitionType = requisitionType;
    }

    public PurchaseRequisition() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="purchase_requisition_id", unique=true, nullable=false)
    public Long getPurchaseRequisitionId() {
        return this.purchaseRequisitionId;
    }

    public void setPurchaseRequisitionId(Long purchaseRequisitionId) {
        this.purchaseRequisitionId = purchaseRequisitionId;
    }

    @Column(name="inventory_item_name", nullable=false, length=255)
    public String getInventoryItemName() {
        return this.inventoryItemName;
    }

    public void setInventoryItemName(String inventoryItemName) {
        this.inventoryItemName = inventoryItemName;
    }

    @Column(name="quantity", nullable=false, length=50)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name="description", nullable=true, length=255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="purchase_reason", nullable=false, length=255)
    public String getPurchaseReason() {
        return this.purchaseReason;
    }

    public void setPurchaseReason(String purchaseReason) {
        this.purchaseReason = purchaseReason;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="purchase_requistion_user_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@purchaseRequistionsBy")
    @JsonIdentityReference(alwaysAsId=true)
    public User getPurchaseRequistionBy() {
        return this.purchaseRequistionBy;
    }

    public void setPurchaseRequistionBy(User purchaseRequistionBy) {
        this.purchaseRequistionBy = purchaseRequistionBy;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="purchase_approver_user_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@purchaseApproversBy")
    @JsonIdentityReference(alwaysAsId=true)
    public User getPurchaseApproverBy() {
        return this.purchaseApproverBy;
    }

    public void setPurchaseApproverBy(User purchaseApproverBy) {
        this.purchaseApproverBy = purchaseApproverBy;
    }

    @Column(name="approval_status", nullable=false)
    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="expected_date", nullable=false)
    public Date getExpectedDate() {
        return this.expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Column(name="approval_by", nullable=false)
    public String getApprovedBy() {
        return this.approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    @Temporal(value=TemporalType.DATE)
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

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="purchaseRequisitonInPotalTask")
    @JoinColumn(name="portal_task_id", nullable=false)
    public PortalTask getPortalTask() {
        return this.portalTask;
    }

    public void setPortalTask(PortalTask portalTask) {
        this.portalTask = portalTask;
    }

    @Column(name="approver_comments", nullable=true)
    public String getApproverComment() {
        return this.approverComment;
    }

    public void setApproverComment(String approverComment) {
        this.approverComment = approverComment;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="requisition_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@purchaseRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public RequisitionType getRequisitionType() {
        return this.requisitionType;
    }

    public void setRequisitionType(RequisitionType requisitionType) {
        this.requisitionType = requisitionType;
    }
}
