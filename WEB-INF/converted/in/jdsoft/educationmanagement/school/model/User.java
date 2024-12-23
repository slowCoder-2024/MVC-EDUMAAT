/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
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
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AssetRegister;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthers;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersArchive;
import in.jdsoft.educationmanagement.school.model.CommunicationFeedBackAndOthersHistory;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationNotificationArchive;
import in.jdsoft.educationmanagement.school.model.ComplaintManagement;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.MeetingRequisition;
import in.jdsoft.educationmanagement.school.model.PortalMessage;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.PortalReplyMessage;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.UserRole;
import java.io.Serializable;
import java.sql.Timestamp;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_users", uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class User
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String name;
    private String email;
    private String password;
    private String hash;
    private String createdBy;
    private Date createdDate;
    private Integer status;
    private Date modifiedDate;
    private String modifiedBy;
    private Date lastLogin;
    private String profilePicturePath;
    private Institution institution;
    private Set<UserRole> userRoles = new LinkedHashSet<UserRole>();
    private Staff staff;
    private Student student;
    private Set<Staff> approverTo;
    private Set<CommunicationNotification> communicationNotifications = new LinkedHashSet<CommunicationNotification>();
    private Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers = new LinkedHashSet<CommunicationFeedBackAndOthers>();
    private Set<CommunicationNotificationArchive> communicationNotificationArchives = new LinkedHashSet<CommunicationNotificationArchive>();
    private Set<PortalNotification> portalNotifications = new LinkedHashSet<PortalNotification>();
    private Set<PortalMessage> portalMessages = new LinkedHashSet<PortalMessage>();
    private Set<PortalTask> portalTasks = new LinkedHashSet<PortalTask>();
    private Set<PortalReplyMessage> portalReplyMessages = new LinkedHashSet<PortalReplyMessage>();
    private Set<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistory = new LinkedHashSet<CommunicationFeedBackAndOthersHistory>();
    private Set<CommunicationFeedBackAndOthersArchive> CommunicationFeedBackAndOthersArchives = new LinkedHashSet<CommunicationFeedBackAndOthersArchive>();
    private Set<StaffLeaveRequisition> staffLeaveRequistions = new LinkedHashSet<StaffLeaveRequisition>();
    private Set<Admission> userAdmission = new LinkedHashSet<Admission>();
    private Set<StudentLeaveRequisition> studentLeaveRequistions = new LinkedHashSet<StudentLeaveRequisition>();
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<StaffMovementRequisition> staffMovementRequisitions = new LinkedHashSet<StaffMovementRequisition>(0);
    private Set<MeetingRequisition> meetingApprovers = new LinkedHashSet<MeetingRequisition>(0);
    private Set<MeetingRequisition> meetingRequesters = new LinkedHashSet<MeetingRequisition>(0);
    private Set<PurchaseRequisition> purchaseRequistionsBy = new LinkedHashSet<PurchaseRequisition>();
    private Set<PurchaseRequisition> purchaseApproversBy = new LinkedHashSet<PurchaseRequisition>();
    private Set<InventoryRequisition> inventoryRequisitionsBy = new LinkedHashSet<InventoryRequisition>();
    private Set<InventoryRequisition> inventoryRequisitionApproversBy = new LinkedHashSet<InventoryRequisition>();
    private Set<InventoryItemIssueMaster> issueToUsers = new LinkedHashSet<InventoryItemIssueMaster>();
    private Set<InventoryItemIssueMaster> inchargeUsers = new LinkedHashSet<InventoryItemIssueMaster>();
    private Set<InventoryItemReturnMaster> returnedBy = new LinkedHashSet<InventoryItemReturnMaster>();
    private Set<ComplaintManagement> complaintSenders = new LinkedHashSet<ComplaintManagement>(0);
    private Set<ComplaintManagement> complaintReceivers = new LinkedHashSet<ComplaintManagement>(0);
    private Set<AssetRegister> assetRegister = new LinkedHashSet<AssetRegister>();

    User() {
    }

    public User(Set<UserRole> userRoles, String name, String email, String password, String createdBy, Integer status, String hash, String profilePicturePath, Institution institution) {
        this.name = WordUtils.capitalize((String)name);
        this.email = email.toLowerCase();
        this.password = password;
        this.userRoles = userRoles;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.hash = hash;
        this.profilePicturePath = profilePicturePath;
        this.institution = institution;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", nullable=false)
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name="name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = WordUtils.capitalize((String)name);
    }

    @Column(name="email")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="created_by", length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date")
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="status")
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="last_login")
    public Date getLastLogin() {
        return this.lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@users")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Column(name="hash_key", nullable=false)
    public String getHash() {
        return this.hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Column(name="profile_picture", nullable=false)
    public String getProfilePicturePath() {
        return this.profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        this.profilePicturePath = profilePicturePath;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_user_and_role_mapping", joinColumns={@JoinColumn(name="user_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="user_role_id", updatable=true)})
    public Set<UserRole> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Column(name="modified_by", length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@user")
    @JsonIdentityReference(alwaysAsId=true)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="approver")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@approver")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<Staff> getApproverTo() {
        return this.approverTo;
    }

    public void setApproverTo(Set<Staff> approverTo) {
        this.approverTo = approverTo;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="user")
    @JsonBackReference
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInCommunicationNotifications")
    @OrderBy(value="createdDate DESC")
    public Set<CommunicationNotification> getCommunicationNotifications() {
        return this.communicationNotifications;
    }

    public void setCommunicationNotifications(Set<CommunicationNotification> communicationNotifications) {
        this.communicationNotifications = communicationNotifications;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInCommunicationNotificationArchives")
    public Set<CommunicationNotificationArchive> getCommunicationNotificationArchives() {
        return this.communicationNotificationArchives;
    }

    public void setCommunicationNotificationArchives(Set<CommunicationNotificationArchive> communicationNotificationArchives) {
        this.communicationNotificationArchives = communicationNotificationArchives;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInPortalNotifications")
    @OrderBy(value="createdDate DESC")
    public Set<PortalNotification> getPortalNotifications() {
        return this.portalNotifications;
    }

    public void setPortalNotifications(Set<PortalNotification> portalNotifications) {
        this.portalNotifications = portalNotifications;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInCommunicationFeedBackAndOthers")
    @OrderBy(value="createdDate DESC")
    public Set<CommunicationFeedBackAndOthers> getCommunicationFeedBackAndOthers() {
        return this.communicationFeedBackAndOthers;
    }

    public void setCommunicationFeedBackAndOthers(Set<CommunicationFeedBackAndOthers> communicationFeedBackAndOthers) {
        this.communicationFeedBackAndOthers = communicationFeedBackAndOthers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="targetUser")
    @ForeignKey(name="userInCommunicationFeedBackAndOthersHistory")
    @OrderBy(value="createdDate DESC")
    public Set<CommunicationFeedBackAndOthersHistory> getCommunicationFeedBackAndOthersHistory() {
        return this.communicationFeedBackAndOthersHistory;
    }

    public void setCommunicationFeedBackAndOthersHistory(Set<CommunicationFeedBackAndOthersHistory> communicationFeedBackAndOthersHistory) {
        this.communicationFeedBackAndOthersHistory = communicationFeedBackAndOthersHistory;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInPortalMessages")
    @OrderBy(value="createdDate DESC")
    public Set<PortalMessage> getPortalMessages() {
        return this.portalMessages;
    }

    public void setPortalMessages(Set<PortalMessage> portalMessages) {
        this.portalMessages = portalMessages;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInCommunicationFeedBackAndOthersArchives")
    public Set<CommunicationFeedBackAndOthersArchive> getCommunicationFeedBackAndOthersArchives() {
        return this.CommunicationFeedBackAndOthersArchives;
    }

    public void setCommunicationFeedBackAndOthersArchives(Set<CommunicationFeedBackAndOthersArchive> communicationFeedBackAndOthersArchives) {
        this.CommunicationFeedBackAndOthersArchives = communicationFeedBackAndOthersArchives;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInPortalReplyMessages")
    @OrderBy(value="createdDate DESC")
    public Set<PortalReplyMessage> getPortalReplyMessages() {
        return this.portalReplyMessages;
    }

    public void setPortalReplyMessages(Set<PortalReplyMessage> portalReplyMessages) {
        this.portalReplyMessages = portalReplyMessages;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="leaveApprover")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@leaveApprover")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StaffLeaveRequisition> getStaffLeaveRequistions() {
        return this.staffLeaveRequistions;
    }

    public void setStaffLeaveRequistions(Set<StaffLeaveRequisition> staffLeaveRequistions) {
        this.staffLeaveRequistions = staffLeaveRequistions;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="targetUsers")
    @ForeignKey(name="userInPortalTasks")
    @OrderBy(value="createdDate DESC")
    public Set<PortalTask> getPortalTasks() {
        return this.portalTasks;
    }

    public void setPortalTasks(Set<PortalTask> portalTasks) {
        this.portalTasks = portalTasks;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="user")
    public Set<Admission> getUserAdmission() {
        return this.userAdmission;
    }

    public void setUserAdmission(Set<Admission> userAdmission) {
        this.userAdmission = userAdmission;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="leaveApprover")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@leaveApprover")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StudentLeaveRequisition> getStudentLeaveRequistions() {
        return this.studentLeaveRequistions;
    }

    public void setStudentLeaveRequistions(Set<StudentLeaveRequisition> studentLeaveRequistions) {
        this.studentLeaveRequistions = studentLeaveRequistions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="tcApprover")
    @ForeignKey(name="userInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="movementApprover")
    @ForeignKey(name="userInStudentMovementRequisition")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staffMovementApprover")
    @ForeignKey(name="userInStaffMovementRequisition")
    @OrderBy(value="staffMovementRequisitionId ASC")
    public Set<StaffMovementRequisition> getStaffMovementRequisitions() {
        return this.staffMovementRequisitions;
    }

    public void setStaffMovementRequisitions(Set<StaffMovementRequisition> staffMovementRequisitions) {
        this.staffMovementRequisitions = staffMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="meetingApprover")
    @ForeignKey(name="userInMeetingRequisition")
    @OrderBy(value="meetingRequisitionId ASC")
    public Set<MeetingRequisition> getMeetingApprovers() {
        return this.meetingApprovers;
    }

    public void setMeetingApprovers(Set<MeetingRequisition> meetingApprovers) {
        this.meetingApprovers = meetingApprovers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="meetingRequester")
    @ForeignKey(name="userInMeetingRequisition")
    @OrderBy(value="meetingRequisitionId ASC")
    public Set<MeetingRequisition> getMeetingRequesters() {
        return this.meetingRequesters;
    }

    public void setMeetingRequesters(Set<MeetingRequisition> meetingRequesters) {
        this.meetingRequesters = meetingRequesters;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="purchaseRequistionBy")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@purchaseRequistionBy")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<PurchaseRequisition> getPurchaseRequistions() {
        return this.purchaseRequistionsBy;
    }

    public void setPurchaseRequistions(Set<PurchaseRequisition> purchaseRequistionsBy) {
        this.purchaseRequistionsBy = purchaseRequistionsBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="purchaseApproverBy")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@purchaseApproverBy")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<PurchaseRequisition> getPurchaseApproversBy() {
        return this.purchaseApproversBy;
    }

    public void setPurchaseApproversBy(Set<PurchaseRequisition> purchaseApproversBy) {
        this.purchaseApproversBy = purchaseApproversBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryRequistionBy")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryRequistionBy")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<InventoryRequisition> getInventoryRequisitionBy() {
        return this.inventoryRequisitionsBy;
    }

    public void setInventoryRequisitionBy(Set<InventoryRequisition> inventoryRequisitionsBy) {
        this.inventoryRequisitionsBy = inventoryRequisitionsBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryRequisitionApproverBy")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryRequisitionApproverBy")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<InventoryRequisition> getInventoryRequisitionApproversBy() {
        return this.inventoryRequisitionApproversBy;
    }

    public void setInventoryRequisitionApproversBy(Set<InventoryRequisition> inventoryRequisitionApproversBy) {
        this.inventoryRequisitionApproversBy = inventoryRequisitionApproversBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="issueToUser")
    public Set<InventoryItemIssueMaster> getIssueToUsers() {
        return this.issueToUsers;
    }

    public void setIssueToUsers(Set<InventoryItemIssueMaster> issueToUsers) {
        this.issueToUsers = issueToUsers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inCharge")
    public Set<InventoryItemIssueMaster> getInchargeUsers() {
        return this.inchargeUsers;
    }

    public void setInchargeUsers(Set<InventoryItemIssueMaster> inchargeUsers) {
        this.inchargeUsers = inchargeUsers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="returnedBy")
    public Set<InventoryItemReturnMaster> getReturnedBy() {
        return this.returnedBy;
    }

    public void setReturnedBy(Set<InventoryItemReturnMaster> returnedBy) {
        this.returnedBy = returnedBy;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="complaintSender")
    @ForeignKey(name="userIncomplaintManagment")
    @OrderBy(value="complaintId ASC")
    public Set<ComplaintManagement> getComplaintSenders() {
        return this.complaintSenders;
    }

    public void setComplaintSenders(Set<ComplaintManagement> complaintSenders) {
        this.complaintSenders = complaintSenders;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="complaintReceiver")
    @ForeignKey(name="userInComplaintManagement")
    @OrderBy(value="complaintId ASC")
    public Set<ComplaintManagement> getComplaintReceivers() {
        return this.complaintReceivers;
    }

    public void setComplaintReceivers(Set<ComplaintManagement> complaintReceivers) {
        this.complaintReceivers = complaintReceivers;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inCharge")
    public Set<AssetRegister> getAssetRegister() {
        return this.assetRegister;
    }

    public void setAssetRegister(Set<AssetRegister> assetRegister) {
        this.assetRegister = assetRegister;
    }
}
