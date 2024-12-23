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
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
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
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_portal_task")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class PortalTask
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long portalTaskId;
    private String portalTaskSubject;
    private String portalTaskMessage;
    private Set<User> targetUsers = new LinkedHashSet<User>();
    private Integer portalTaskStatus;
    private String portalTaskLink;
    private Date createdDate;
    private String createdBy;
    private Institution institution;
    private StaffLeaveRequisition staffLeaveRequisition;
    private StudentLeaveRequisition studentLeaveRequisition;
    private TCRequisition tcRequisition;
    private StudentMovementRequisition studentMovementRequisition;
    private StaffMovementRequisition staffMovementRequisition;
    private PurchaseRequisition purchaseRequistion;
    private InventoryRequisition inventoryRequisition;
    private ComplaintManagement complaintManagement;
    private MeetingRequisition meetingRequisition;

    public PortalTask() {
    }

    public PortalTask(String TaskSubject, String TaskMessage, Set<User> targetUsers, Integer TaskStatus, String TaskLink, String createdBy, Institution institution) {
        this.portalTaskSubject = TaskSubject;
        this.portalTaskMessage = TaskMessage;
        this.targetUsers = targetUsers;
        this.portalTaskStatus = TaskStatus;
        this.portalTaskLink = TaskLink;
        this.createdDate = new Date(Calendar.getInstance().getTime().getTime());
        this.setCreatedBy(createdBy);
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="portal_task_id", nullable=false)
    public Long getPortalTaskId() {
        return this.portalTaskId;
    }

    public void setPortalTaskId(Long portalTaskId) {
        this.portalTaskId = portalTaskId;
    }

    @Column(name="portal_task_message", nullable=false, length=255)
    public String getPortalTaskMessage() {
        return this.portalTaskMessage;
    }

    public void setPortalTaskMessage(String portalTaskMessage) {
        this.portalTaskMessage = portalTaskMessage;
    }

    @Column(name="portal_task_status", nullable=false)
    public Integer getPortalTaskStatus() {
        return this.portalTaskStatus;
    }

    public void setPortalTaskStatus(Integer portalTaskStatus) {
        this.portalTaskStatus = portalTaskStatus;
    }

    @Column(name="portal_task_link", nullable=false, length=255)
    public String getPortalTaskLink() {
        return this.portalTaskLink;
    }

    public void setPortalTaskLink(String portalTaskLink) {
        this.portalTaskLink = portalTaskLink;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="portal_task_subject", nullable=false, length=100)
    public String getPortalTaskSubject() {
        return this.portalTaskSubject;
    }

    public void setPortalTaskSubject(String portalTaskSubject) {
        this.portalTaskSubject = portalTaskSubject;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_portal_task_users", joinColumns={@JoinColumn(name="portal_task_id", updatable=true, nullable=true)}, inverseJoinColumns={@JoinColumn(name="target_user_id", referencedColumnName="user_id", updatable=true, nullable=true)})
    @ForeignKey(name="PortalTaskInUser")
    public Set<User> getTargetUsers() {
        return this.targetUsers;
    }

    public void setTargetUsers(Set<User> targetUsers) {
        this.targetUsers = targetUsers;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="portalTaskInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTasks")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInStaffLeaveRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffLeaveRequisition getStaffLeaveRequisition() {
        return this.staffLeaveRequisition;
    }

    public void setStaffLeaveRequisition(StaffLeaveRequisition staffLeaveRequisition) {
        this.staffLeaveRequisition = staffLeaveRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInStudentLeaveRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentLeaveRequisition getStudentLeaveRequisition() {
        return this.studentLeaveRequisition;
    }

    public void setStudentLeaveRequisition(StudentLeaveRequisition studentLeaveRequisition) {
        this.studentLeaveRequisition = studentLeaveRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInTCRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public TCRequisition getTcRequisition() {
        return this.tcRequisition;
    }

    public void setTcRequisition(TCRequisition tcRequisition) {
        this.tcRequisition = tcRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInStudentMovementRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public StudentMovementRequisition getStudentMovementRequisition() {
        return this.studentMovementRequisition;
    }

    public void setStudentMovementRequisition(StudentMovementRequisition studentMovementRequisition) {
        this.studentMovementRequisition = studentMovementRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInStaffMovementRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public StaffMovementRequisition getStaffMovementRequisition() {
        return this.staffMovementRequisition;
    }

    public void setStaffMovementRequisition(StaffMovementRequisition staffMovementRequisition) {
        this.staffMovementRequisition = staffMovementRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInPurchaseRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public PurchaseRequisition getPurchaseRequistion() {
        return this.purchaseRequistion;
    }

    public void setPurchaseRequistion(PurchaseRequisition purchaseRequistion) {
        this.purchaseRequistion = purchaseRequistion;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInInventoryRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryRequisition getInventoryRequisition() {
        return this.inventoryRequisition;
    }

    public void setInventoryRequisition(InventoryRequisition inventoryRequisition) {
        this.inventoryRequisition = inventoryRequisition;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInComplaintManagement")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public ComplaintManagement getComplaintManagement() {
        return this.complaintManagement;
    }

    public void setComplaintManagement(ComplaintManagement complaintManagement) {
        this.complaintManagement = complaintManagement;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="portalTask")
    @ForeignKey(name="portalTaskInMeetingRequisition")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@portalTask")
    @JsonIdentityReference(alwaysAsId=true)
    public MeetingRequisition getMeetingRequisition() {
        return this.meetingRequisition;
    }

    public void setMeetingRequisition(MeetingRequisition meetingRequisition) {
        this.meetingRequisition = meetingRequisition;
    }
}
