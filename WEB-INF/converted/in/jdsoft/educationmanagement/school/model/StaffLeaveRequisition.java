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
import in.jdsoft.educationmanagement.school.model.StaffLeaveType;
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
@Table(name="tbl_staff_leave_requisition")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffLeaveRequisition
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffLeaveRequisitionId;
    private StaffLeaveType staffLeaveType;
    private String staffLeaveReason;
    private Staff staff;
    private User leaveApprover;
    private String approvalStatus;
    private Date staffLeaveStartDate;
    private Date staffLeaveEndDate;
    private String approvedBy;
    private Date createdDate;
    private Date modifiedDate;
    private PortalTask portalTask;
    private Date partiallyLeaveStartDate;
    private Date partiallyLeaveEndDate;
    private String approverComment;
    private RequisitionType requisitionType;
    private String createdBy;
    private String modifiedBy;

    public StaffLeaveRequisition(RequisitionType requisitionType, StaffLeaveType staffLeaveType, String staffLeaveReason, Staff staff, User leaveApprover, String approvalStatus, Date staffLeaveStartDate, Date staffLeaveEndDate, String createdBy, String modifiedBy) {
        this.staffLeaveType = staffLeaveType;
        this.staffLeaveReason = staffLeaveReason;
        this.staff = staff;
        this.leaveApprover = leaveApprover;
        this.approvalStatus = approvalStatus;
        this.staffLeaveStartDate = staffLeaveStartDate;
        this.staffLeaveEndDate = staffLeaveEndDate;
        this.approvedBy = "Pending";
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.requisitionType = requisitionType;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
    }

    public StaffLeaveRequisition() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_leave_requisition_id", nullable=false)
    public Long getStaffLeaveRequisitionId() {
        return this.staffLeaveRequisitionId;
    }

    public void setStaffLeaveRequisitionId(Long staffLeaveRequisitionId) {
        this.staffLeaveRequisitionId = staffLeaveRequisitionId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_leave_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffLeaveRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffLeaveType getStaffLeaveType() {
        return this.staffLeaveType;
    }

    public void setStaffLeaveType(StaffLeaveType staffLeaveType) {
        this.staffLeaveType = staffLeaveType;
    }

    @Column(name="staff_leave_reason", nullable=false)
    public String getStaffLeaveReason() {
        return this.staffLeaveReason;
    }

    public void setStaffLeaveReason(String staffLeaveReason) {
        this.staffLeaveReason = staffLeaveReason;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffLeaveRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
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

    @Temporal(value=TemporalType.DATE)
    @Column(name="leave_start_date", nullable=false)
    public Date getStaffLeaveStartDate() {
        return this.staffLeaveStartDate;
    }

    public void setStaffLeaveStartDate(Date staffLeaveStartDate) {
        this.staffLeaveStartDate = staffLeaveStartDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="leave_end_date", nullable=false)
    public Date getStaffLeaveEndDate() {
        return this.staffLeaveEndDate;
    }

    public void setStaffLeaveEndDate(Date staffLeaveEndDate) {
        this.staffLeaveEndDate = staffLeaveEndDate;
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
    @JoinColumn(name="approver_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffLeaveRequistions")
    @JsonIdentityReference(alwaysAsId=true)
    public User getLeaveApprover() {
        return this.leaveApprover;
    }

    public void setLeaveApprover(User leaveApprover) {
        this.leaveApprover = leaveApprover;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="communicationNotificationInPotalTask")
    @JoinColumn(name="portal_task_id", nullable=false)
    public PortalTask getPortalTask() {
        return this.portalTask;
    }

    public void setPortalTask(PortalTask portalTask) {
        this.portalTask = portalTask;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="partially_leave_start_date", nullable=true)
    public Date getPartiallyLeaveStartDate() {
        return this.partiallyLeaveStartDate;
    }

    public void setPartiallyLeaveStartDate(Date partiallyLeaveStartDate) {
        this.partiallyLeaveStartDate = partiallyLeaveStartDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="partially_leave_end_date", nullable=true)
    public Date getPartiallyLeaveEndDate() {
        return this.partiallyLeaveEndDate;
    }

    public void setPartiallyLeaveEndDate(Date partiallyLeaveEndDate) {
        this.partiallyLeaveEndDate = partiallyLeaveEndDate;
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
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffLeaveRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public RequisitionType getRequisitionType() {
        return this.requisitionType;
    }

    public void setRequisitionType(RequisitionType requisitionType) {
        this.requisitionType = requisitionType;
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
}
