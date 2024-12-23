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
import in.jdsoft.educationmanagement.school.model.Staff;
import java.io.Serializable;
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
@Table(name="tbl_staff_experience_detail")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffExperienceDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffExperienceDetailId;
    private String workedOrganisation;
    private Date startDate;
    private Date endDate;
    private String staffPreviousDesignation;
    private Double inPreviousExperience;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Staff staff;

    public StaffExperienceDetail(String workedOrganisation, Date startDate, Date endDate, String staffPreviousDesignation, Double inPreviousExperience, String createdBy) {
        this.workedOrganisation = workedOrganisation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.staffPreviousDesignation = staffPreviousDesignation;
        this.inPreviousExperience = inPreviousExperience;
        this.createdBy = createdBy;
        this.modifiedBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    StaffExperienceDetail() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_experience_detail_id", nullable=false)
    public Long getStaffExperienceDetailId() {
        return this.staffExperienceDetailId;
    }

    public void setStaffExperienceDetailId(Long staffExperienceDetailId) {
        this.staffExperienceDetailId = staffExperienceDetailId;
    }

    @Column(name="staff_worked_organisation_name", nullable=true, length=255)
    public String getWorkedOrganisation() {
        return this.workedOrganisation;
    }

    public void setWorkedOrganisation(String workedOrganisation) {
        this.workedOrganisation = workedOrganisation;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_experience_detail_start_date", nullable=true)
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_experience_detail_end_date", nullable=true)
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name="staff_previous_designation", nullable=true, length=200)
    public String getStaffPreviousDesignation() {
        return this.staffPreviousDesignation;
    }

    public void setStaffPreviousDesignation(String staffPreviousDesignation) {
        this.staffPreviousDesignation = staffPreviousDesignation;
    }

    @Column(name="staff_previous_experience", nullable=true, length=100)
    public Double getInPreviousExperience() {
        return this.inPreviousExperience;
    }

    public void setInPreviousExperience(Double inPreviousExperience) {
        this.inPreviousExperience = inPreviousExperience;
    }

    @Column(name="staff_experience_detail_createdBy", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="staff_experience_detail_modifiedBy", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_experience_detail_created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="staff_experience_detail_last_modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffExperienceDetails")
    @JsonIdentityReference(alwaysAsId=true)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
