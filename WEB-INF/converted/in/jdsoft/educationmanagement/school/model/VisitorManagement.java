/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.VisitorIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.VisitorType;
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
@Table(name="tbl_visitor_management")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class VisitorManagement
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long visitorManagmentId;
    private String visitorName;
    private VisitorType visitorType;
    private String visitorEmail;
    private String visitorMobileNumber;
    private String visitorWhomToMeet;
    private String visitorPurposeOfVisit;
    private Date visitDate;
    private Date visitCheckInTime;
    private Date visitCheckOutTime;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private VisitorIDCardGeneration visitorIDCardGeneration;
    private Institution institution;

    public VisitorManagement(String visitorName, VisitorType visitorType, Institution institution, String visitorEmail, String visitorMobileNumber, String visitorWhomToMeet, String visitorPurposeOfVisit, Date visitDate, Date visitCheckInTime, Date visitCheckOutTime, String createdBy, String modifiedBy) {
        this.institution = institution;
        this.visitorName = visitorName;
        this.visitorType = visitorType;
        this.visitorEmail = visitorEmail;
        this.visitorMobileNumber = visitorMobileNumber;
        this.visitorWhomToMeet = visitorWhomToMeet;
        this.visitorPurposeOfVisit = visitorPurposeOfVisit;
        this.visitDate = visitDate;
        this.visitCheckInTime = visitCheckInTime;
        this.visitCheckOutTime = visitCheckOutTime;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public VisitorManagement() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="visitor_management_id", nullable=false)
    public Long getVisitorManagmentId() {
        return this.visitorManagmentId;
    }

    public void setVisitorManagmentId(Long visitorManagmentId) {
        this.visitorManagmentId = visitorManagmentId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="visitor_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@VisitorManagements")
    @JsonIdentityReference(alwaysAsId=true)
    public VisitorType getVisitorType() {
        return this.visitorType;
    }

    public void setVisitorType(VisitorType visitorType) {
        this.visitorType = visitorType;
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

    @Column(name="visitor_name", nullable=false, length=255)
    public String getVisitorName() {
        return this.visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    @Column(name="visitor_email", nullable=false, length=255)
    public String getVisitorEmail() {
        return this.visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    @Column(name="visitor_mobile_number", nullable=false, length=255)
    public String getVisitorMobileNumber() {
        return this.visitorMobileNumber;
    }

    public void setVisitorMobileNumber(String visitorMobileNumber) {
        this.visitorMobileNumber = visitorMobileNumber;
    }

    @Column(name="visitor_whom_to_meet", nullable=false, length=255)
    public String getVisitorWhomToMeet() {
        return this.visitorWhomToMeet;
    }

    public void setVisitorWhomToMeet(String visitorWhomToMeet) {
        this.visitorWhomToMeet = visitorWhomToMeet;
    }

    @Column(name="visitor_purpose_of_visit", nullable=false, length=255)
    public String getVisitorPurposeOfVisit() {
        return this.visitorPurposeOfVisit;
    }

    public void setVisitorPurposeOfVisit(String visitorPurposeOfVisit) {
        this.visitorPurposeOfVisit = visitorPurposeOfVisit;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="visit_date", nullable=false)
    public Date getVisitDate() {
        return this.visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Temporal(value=TemporalType.TIME)
    @Column(name="visitor_check_in_time", nullable=false)
    public Date getVisitCheckInTime() {
        return this.visitCheckInTime;
    }

    public void setVisitCheckInTime(Date visitCheckInTime) {
        this.visitCheckInTime = visitCheckInTime;
    }

    @Temporal(value=TemporalType.TIME)
    @Column(name="visitor_check_out_time", nullable=false)
    public Date getVisitCheckOutTime() {
        return this.visitCheckOutTime;
    }

    public void setVisitCheckOutTime(Date visitCheckOutTime) {
        this.visitCheckOutTime = visitCheckOutTime;
    }

    @Column(name="created_by", nullable=true, length=255)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=true, length=255)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="visitorIDCardGenerationId", nullable=true)
    @ForeignKey(name="visitorIDCardGenerationInvisitorManagement")
    @JsonManagedReference
    public VisitorIDCardGeneration getVisitorIDCardGeneration() {
        return this.visitorIDCardGeneration;
    }

    public void setVisitorIDCardGeneration(VisitorIDCardGeneration visitorIDCardGeneration) {
        this.visitorIDCardGeneration = visitorIDCardGeneration;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@VisitorManagements")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }
}
