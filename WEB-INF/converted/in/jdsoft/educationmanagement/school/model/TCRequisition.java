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
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
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
@Table(name="tbl_transfer_certificate_requisition")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TCRequisition
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long transferCertificateRequisitionId;
    private String requestReason;
    private Student student;
    private User tcApprover;
    private String approvalStatus;
    private String approvedBy;
    private Date createdDate;
    private Date modifiedDate;
    private PortalTask portalTask;
    private String createdBy;
    private String modifiedBy;
    private String approverComment;
    private Institution institution;
    private AcademicYear academicYear;
    private Class studentClass;
    private Section section;
    private RequisitionType requisitionType;

    public TCRequisition(String requestReason, RequisitionType requisitionType, Student student, User leaveApprover, String approvalStatus, Institution institution, AcademicYear academicYear, Class studentClass, Section section, String createdBy, String modifiedBy) {
        this.requestReason = requestReason;
        this.student = student;
        this.tcApprover = leaveApprover;
        this.approvalStatus = approvalStatus;
        this.approvedBy = "Pending";
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.academicYear = academicYear;
        this.institution = institution;
        this.requisitionType = requisitionType;
        this.studentClass = studentClass;
        this.section = section;
    }

    public TCRequisition() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tc_requisition_id", nullable=false)
    public Long getTransferCertificateRequisitionId() {
        return this.transferCertificateRequisitionId;
    }

    public void setTransferCertificateRequisitionId(Long transferCertificateRequisitionId) {
        this.transferCertificateRequisitionId = transferCertificateRequisitionId;
    }

    @Column(name="request_reason", nullable=false)
    public String getRequestReason() {
        return this.requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
    @JoinColumn(name="tc_approver_id", nullable=false, referencedColumnName="user_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@tCRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public User getTcApprover() {
        return this.tcApprover;
    }

    public void setTcApprover(User tcApprover) {
        this.tcApprover = tcApprover;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @ForeignKey(name="tCRequisitonInPotalTask")
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
    @JoinColumn(name="institution_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@tCRequisitions")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="requisition_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@tCRequisitions")
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id", nullable=false)
    @ForeignKey(name="studentClassInTCRequisition")
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="sectionInTCRequisition")
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
