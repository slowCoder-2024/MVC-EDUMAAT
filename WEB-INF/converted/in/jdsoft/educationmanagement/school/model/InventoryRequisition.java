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
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.PortalTask;
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
@Table(name="tbl_inventory_requisition")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryRequisition
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long InventoryRequisitionId;
    private InventoryItemMaster inventoryItemId;
    private Double quantity;
    private String description;
    private String inventoryRequisitionReason;
    private User inventoryRequistionBy;
    private User inventoryRequisitionApproverBy;
    private String approvalStatus;
    private String approvedBy;
    private Date createdDate;
    private Date modifiedDate;
    private PortalTask portalTask;
    private String approverComment;

    public InventoryRequisition(InventoryItemMaster inventoryItemId, Double quantity, String description, String inventoryRequisitionReason, User inventoryRequistionBy, String approvalStatus, User inventoryRequisitionApproverBy, PortalTask portalTask) {
        this.inventoryItemId = inventoryItemId;
        this.quantity = quantity;
        this.description = description;
        this.inventoryRequisitionReason = inventoryRequisitionReason;
        this.inventoryRequistionBy = inventoryRequistionBy;
        this.approvalStatus = approvalStatus;
        this.inventoryRequisitionApproverBy = inventoryRequisitionApproverBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.portalTask = portalTask;
    }

    public InventoryRequisition() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_requisition_id", nullable=false)
    public Long getInventoryRequisitionId() {
        return this.InventoryRequisitionId;
    }

    public void setInventoryRequisitionId(Long inventoryRequisitionId) {
        this.InventoryRequisitionId = inventoryRequisitionId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_item_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryItemMaster getInventoryItemId() {
        return this.inventoryItemId;
    }

    public void setInventoryItemId(InventoryItemMaster inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
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

    @Column(name="inventory_requisition_reason", nullable=false, length=255)
    public String getInventoryRequisitionReason() {
        return this.inventoryRequisitionReason;
    }

    public void setInventoryRequisitionReason(String inventoryRequisitionReason) {
        this.inventoryRequisitionReason = inventoryRequisitionReason;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_requistion_user_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryRequistionsBy")
    @JsonIdentityReference(alwaysAsId=true)
    public User getInventoryRequistionBy() {
        return this.inventoryRequistionBy;
    }

    public void setInventoryRequistionBy(User inventoryRequistionBy) {
        this.inventoryRequistionBy = inventoryRequistionBy;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_requistion_approver_user_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryRequistionApproversBy")
    @JsonIdentityReference(alwaysAsId=true)
    public User getInventoryRequisitionApproverBy() {
        return this.inventoryRequisitionApproverBy;
    }

    public void setInventoryRequisitionApproverBy(User inventoryRequisitionApproverBy) {
        this.inventoryRequisitionApproverBy = inventoryRequisitionApproverBy;
    }

    @Column(name="approval_status", nullable=false)
    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Column(name="approval_by", nullable=true)
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
    @ForeignKey(name="inventoryRequisitonInPotalTask")
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
}
