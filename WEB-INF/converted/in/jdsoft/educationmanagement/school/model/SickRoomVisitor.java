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
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_sick_room_visitor")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class SickRoomVisitor
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long sickRoomVisitorId;
    private String requestReason1;
    private String requestReason2;
    private String reasonDescription;
    private String actionTaken1;
    private String actionTaken2;
    private String actionDescription;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Time startTime;
    private Time endTime;
    private Date requisitionDate;
    private Staff staff;
    private Student student;
    private Institution institution;
    private AcademicYear academicYear;

    public SickRoomVisitor(String requestReason1, String requestReason2, String reasonDescription, String actionTaken1, String actionTaken2, String actionDescription, String createdBy, String modifiedBy, Time startTime, Time endTime, Date requisitionDate, Staff staff, Student student, Institution institution, AcademicYear academicYear) {
        this.requestReason1 = requestReason1;
        this.requestReason2 = requestReason2;
        this.reasonDescription = reasonDescription;
        this.actionTaken1 = actionTaken1;
        this.actionTaken2 = actionTaken2;
        this.actionDescription = actionDescription;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requisitionDate = requisitionDate;
        this.staff = staff;
        this.student = student;
        this.institution = institution;
        this.academicYear = academicYear;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public SickRoomVisitor() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sick_room_visitor_id", nullable=false)
    public Long getSickRoomVisitorId() {
        return this.sickRoomVisitorId;
    }

    public void setSickRoomVisitorId(Long sickRoomVisitorId) {
        this.sickRoomVisitorId = sickRoomVisitorId;
    }

    @Column(name="request_reason1", nullable=false)
    public String getRequestReason1() {
        return this.requestReason1;
    }

    public void setRequestReason1(String requestReason1) {
        this.requestReason1 = requestReason1;
    }

    @Column(name="request_reason2", nullable=true)
    public String getRequestReason2() {
        return this.requestReason2;
    }

    public void setRequestReason2(String requestReason2) {
        this.requestReason2 = requestReason2;
    }

    @Column(name="request_description", nullable=false)
    public String getReasonDescription() {
        return this.reasonDescription;
    }

    public void setReasonDescription(String reasonDescription) {
        this.reasonDescription = reasonDescription;
    }

    @Column(name="action_taken1", nullable=true)
    public String getActionTaken1() {
        return this.actionTaken1;
    }

    public void setActionTaken1(String actionTaken1) {
        this.actionTaken1 = actionTaken1;
    }

    @Column(name="action_taken2", nullable=false)
    public String getActionTaken2() {
        return this.actionTaken2;
    }

    public void setActionTaken2(String actionTaken2) {
        this.actionTaken2 = actionTaken2;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sickRoomVisitors")
    @JsonIdentityReference(alwaysAsId=true)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=true)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sickRoomVisitors")
    @JsonIdentityReference(alwaysAsId=true)
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Column(name="action_description", nullable=true)
    public String getActionDescription() {
        return this.actionDescription;
    }

    public void setActionDescription(String actionDescription) {
        this.actionDescription = actionDescription;
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
    @JoinColumn(name="institution_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sickRoomVisitors")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
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
    @JoinColumn(name="academic_year_id", nullable=false)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
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
    @Column(name="requisition_date", nullable=false)
    public Date getRequisitionDate() {
        return this.requisitionDate;
    }

    public void setRequisitionDate(Date requisitionDate) {
        this.requisitionDate = requisitionDate;
    }
}
