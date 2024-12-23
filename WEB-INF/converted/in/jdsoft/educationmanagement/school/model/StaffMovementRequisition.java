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
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Time;
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
@Table(name="tbl_staff_movement_requisition")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffMovementRequisition
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffMovementRequisitionId;
    private String requestReason;
    private User staffMovementApprover;
    private String approvalStatus;
    private String approvedBy;
    private Date createdDate;
    private Date modifiedDate;
    private PortalTask portalTask;
    private String createdBy;
    private String modifiedBy;
    private Time startTime;
    private Time endTime;
    private String approverComment;
    private RequisitionType requisitionType;
    private Date staffMovementRequisitionDate;
    private Staff staff;

    public StaffMovementRequisition(Staff staff, String requestReason, RequisitionType requisitionType, Date momentRequisitionDate, Time startTime, Time endTime, User leaveApprover, String approvalStatus, String createdBy, String modifiedBy) {
        this.requestReason = requestReason;
        this.setStaffMovementApprover(leaveApprover);
        this.approvalStatus = approvalStatus;
        this.approvedBy = "Pending";
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.requisitionType = requisitionType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.setStaffMovementRequisitionDate(momentRequisitionDate);
        this.staff = staff;
    }

    public StaffMovementRequisition() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_movement_requisition_id", nullable=false)
    public Long getStaffMovementRequisitionId() {
        return this.staffMovementRequisitionId;
    }

    public void setStaffMovementRequisitionId(Long staffMovementRequisitionId) {
        this.staffMovementRequisitionId = staffMovementRequisitionId;
    }

    @Column(name="request_reason", nullable=false)
    public String getRequestReason() {
        return this.requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Column(name="approval_status", nullable=false)
    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_movement_approver_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffMovementRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public User getStaffMovementApprover() {
        return this.staffMovementApprover;
    }

    public void setStaffMovementApprover(User staffMovementApprover) {
        this.staffMovementApprover = staffMovementApprover;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="staffMovementRequisitonInPotalTask")
    @JoinColumn(name="portal_task_id", nullable=false)
    public PortalTask getPortalTask() {
        return this.portalTask;
    }

    public void setPortalTask(PortalTask portalTask) {
        this.portalTask = portalTask;
    }

    @Column(name="created_by", nullable=false)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=false)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="requisition_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffMovementRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public RequisitionType getRequisitionType() {
        return this.requisitionType;
    }

    public void setRequisitionType(RequisitionType requisitionType) {
        this.requisitionType = requisitionType;
    }

    @Column(name="approver_comments", nullable=true)
    public String getApproverComment() {
        return this.approverComment;
    }

    public void setApproverComment(String approverComment) {
        this.approverComment = approverComment;
    }

    @Column(name="start_time", nullable=false)
    public Time getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    @Column(name="end_time", nullable=false)
    public Time getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="movement_requisition_date", nullable=false)
    public Date getStaffMovementRequisitionDate() {
        return this.staffMovementRequisitionDate;
    }

    public void setStaffMovementRequisitionDate(Date staffMovementRequisitionDate) {
        this.staffMovementRequisitionDate = staffMovementRequisitionDate;
    }
}
