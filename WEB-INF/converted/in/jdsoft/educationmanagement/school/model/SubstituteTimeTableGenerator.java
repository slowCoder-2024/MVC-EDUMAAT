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
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.Section;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_substitute_time_table_generator")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class SubstituteTimeTableGenerator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long substituteTimTableGeneratorHourId;
    private String subjectName;
    private String hourTitle;
    private String dayName;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Date substituteStartDate;
    private Date substituteEndDate;
    private Module module;
    private Class timeTableClass;
    private Section section;
    private AcademicYear academicYear;
    private Institution institution;
    private Staff staff;

    public SubstituteTimeTableGenerator(String subjectName, String hourTitle, String dayName, String createdBy, String modifiedBy, Date substituteStartDate, Date substituteEndDate, Module module, Class timeTableClass, Section section, AcademicYear academicYear, Institution institution, Staff staff) {
        this.subjectName = subjectName;
        this.hourTitle = hourTitle;
        this.dayName = dayName;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.substituteStartDate = substituteStartDate;
        this.substituteEndDate = substituteEndDate;
        this.module = module;
        this.timeTableClass = timeTableClass;
        this.section = section;
        this.academicYear = academicYear;
        this.institution = institution;
        this.staff = staff;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    SubstituteTimeTableGenerator() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="substitute_time_table_generator_id", nullable=false)
    public Long getSubstituteTimTableGeneratorHourId() {
        return this.substituteTimTableGeneratorHourId;
    }

    public void setSubstituteTimTableGeneratorHourId(Long substituteTimTableGeneratorHourId) {
        this.substituteTimTableGeneratorHourId = substituteTimTableGeneratorHourId;
    }

    @Column(name="substitute_time_table_generator_subject_name", nullable=false, length=150)
    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Column(name="substitute_time_table_generator_hour_title", nullable=false, length=150)
    public String getHourTitle() {
        return this.hourTitle;
    }

    public void setHourTitle(String hourTitle) {
        this.hourTitle = hourTitle;
    }

    @Column(name="substitute_time_table_generator_day_name", nullable=false, length=150)
    public String getDayName() {
        return this.dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    @Column(name="created_by", nullable=false, length=50)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false, length=19)
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
    @JoinColumn(name="module_id", nullable=true)
    @ForeignKey(name="substituteTimeTableGeneratorInModule")
    @JsonBackReference
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="timtable_class_id", nullable=false, referencedColumnName="class_id")
    @ForeignKey(name="substituteTimeTableGeneratorInClass")
    public Class getTimeTableClass() {
        return this.timeTableClass;
    }

    public void setTimeTableClass(Class timeTableClass) {
        this.timeTableClass = timeTableClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    @ForeignKey(name="substituteTimeTableGeneratorInSection")
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="substituteTimeTableGeneratorInAcademicYear")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@substituteTimeTableGenerators")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="substituteTimeTableGeneratorInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@substituteTimeTableGenerators")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=false)
    @ForeignKey(name="substituteTimeTableGeneratorInStaff")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@substituteTimeTableGenerators")
    @JsonIdentityReference(alwaysAsId=true)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="substitute_start_date", nullable=false)
    public Date getSubstituteStartDate() {
        return this.substituteStartDate;
    }

    public void setSubstituteStartDate(Date substituteStartDate) {
        this.substituteStartDate = substituteStartDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="substitute_end_date", nullable=false)
    public Date getSubstituteEndDate() {
        return this.substituteEndDate;
    }

    public void setSubstituteEndDate(Date substituteEndDate) {
        this.substituteEndDate = substituteEndDate;
    }
}
