/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 *  org.hibernate.annotations.OrderBy
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name="tbl_time_table_generator")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TimeTableGenerator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long timeTableGeneratorId;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private ClassSection classSection;
    private Institution institution;
    private AcademicYear academicYear;
    private Set<TimeTableGeneratorDays> timeTableGeneratorDays = new LinkedHashSet<TimeTableGeneratorDays>();

    public TimeTableGenerator(String createdBy, ClassSection classSection, Institution institution, AcademicYear academicYear) {
        this.createdBy = createdBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.modifiedBy = createdBy;
        this.classSection = classSection;
        this.institution = institution;
        this.academicYear = academicYear;
    }

    TimeTableGenerator() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="time_table_generator_id", nullable=false)
    public Long getTimeTableGeneratorId() {
        return this.timeTableGeneratorId;
    }

    public void setTimeTableGeneratorId(Long timeTableGeneratorId) {
        this.timeTableGeneratorId = timeTableGeneratorId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="classSectionInTimeTableGenerator")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @Column(name="created_by", nullable=false, length=50)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false, length=19)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name="modified_by", nullable=false, length=50)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE}, mappedBy="timeTableGenerator")
    @ForeignKey(name="timeTableGeneratorDaysInTimeTableGenerator")
    @OrderBy(clause="time_table_generator_day_id ASC")
    public Set<TimeTableGeneratorDays> getTimeTableGeneratorDays() {
        return this.timeTableGeneratorDays;
    }

    public void setTimeTableGeneratorDays(Set<TimeTableGeneratorDays> timeTableGeneratorDays) {
        this.timeTableGeneratorDays = timeTableGeneratorDays;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInTimeTableGenerator")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="academicYearInTimeTableGenerator")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }
}
