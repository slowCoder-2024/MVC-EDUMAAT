/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_admission_education_level_detail", uniqueConstraints={@UniqueConstraint(columnNames={"admission_id", "degree_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionEducationLevelDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionAcademicDetailId;
    private Admission admission;
    private EducationLevel educationLevel;
    private String degreeName;
    private String rollNo;
    private String certificateNo;
    private Date startedDate;
    private Date completedDate;
    private Double marksObtained;
    private Double percentage;
    private Double cgpa;
    private String boardOrUniversity;
    private String institutionName;
    private String yearOfPassing;
    private String markType;
    private String institutionCountry;
    private String institutionState;
    private String institutionCity;
    private Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects = new HashSet<AdmissionEducationLevelSubjects>(0);

    public AdmissionEducationLevelDetails() {
    }

    public AdmissionEducationLevelDetails(Admission admission, EducationLevel educationLevel, String degreeName, String rollNo, String certificateNo, Date startedDate, Date completedDate, double marksObtained, double percentage, double cgpa, String boardOrUniversity, String institutionCountry, String institutionState, String institutionCity, String institutionName, String yearOfPassing, String markType) {
        this.admission = admission;
        this.degreeName = WordUtils.capitalize((String)degreeName);
        this.rollNo = rollNo;
        this.certificateNo = certificateNo;
        this.startedDate = startedDate;
        this.completedDate = completedDate;
        this.marksObtained = marksObtained;
        this.percentage = percentage;
        this.cgpa = cgpa;
        this.boardOrUniversity = boardOrUniversity;
        this.institutionCountry = institutionCountry;
        this.institutionState = institutionState;
        this.institutionCity = institutionCity;
        this.educationLevel = educationLevel;
        this.institutionName = institutionName;
        this.yearOfPassing = yearOfPassing;
        this.markType = markType;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_education_level_id", unique=true, nullable=false)
    public Long getAdmissionAcademicDetailId() {
        return this.admissionAcademicDetailId;
    }

    public void setAdmissionAcademicDetailId(Long admissionAcademicDetailId) {
        this.admissionAcademicDetailId = admissionAcademicDetailId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="admissionAcademicsDetails")
    @JsonIdentityReference(alwaysAsId=true)
    public Admission getAdmission() {
        return this.admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @Column(name="degree_name", nullable=false, length=150)
    public String getDegreeName() {
        return this.degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = WordUtils.capitalize((String)degreeName);
    }

    @Column(name="roll_no", nullable=false, length=30)
    public String getRollNo() {
        return this.rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    @Column(name="certificate_no", nullable=true, length=30)
    public String getCertificateNo() {
        return this.certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="started_date", nullable=true)
    public Date getStartedDate() {
        return this.startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="completed_date", nullable=true)
    public Date getCompletedDate() {
        return this.completedDate;
    }

    public void setCompletedDate(Date completedDate) {
        this.completedDate = completedDate;
    }

    @Column(name="marks_obtained", nullable=false)
    public Double getMarksObtained() {
        return this.marksObtained;
    }

    public void setMarksObtained(Double marksObtained) {
        this.marksObtained = marksObtained;
    }

    @Column(name="percentage", nullable=true, precision=2)
    public Double getPercentage() {
        return this.percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Column(name="cgpa", nullable=true, precision=2)
    public Double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    @Column(name="board_or_university", nullable=false)
    public String getBoardOrUniversity() {
        return this.boardOrUniversity;
    }

    public void setBoardOrUniversity(String boardOrUniversity) {
        this.boardOrUniversity = boardOrUniversity;
    }

    @Column(name="institution_country", nullable=false)
    public String getInstitutionCountry() {
        return this.institutionCountry;
    }

    public void setInstitutionCountry(String institutionCountry) {
        this.institutionCountry = institutionCountry;
    }

    @Column(name="institution_state", nullable=false)
    public String getInstitutionState() {
        return this.institutionState;
    }

    public void setInstitutionState(String institutionState) {
        this.institutionState = institutionState;
    }

    @Column(name="institution_city", nullable=false)
    public String getInstitutionCity() {
        return this.institutionCity;
    }

    public void setInstitutionCity(String institutionCity) {
        this.institutionCity = institutionCity;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="education_level_id", nullable=true)
    public EducationLevel getEducationLevel() {
        return this.educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admissionEducationLevelDetail")
    @OrderBy(value="admissionEducationLevelSubjectId ASC")
    public Set<AdmissionEducationLevelSubjects> getAdmissionEducationLevelSubjects() {
        return this.admissionEducationLevelSubjects;
    }

    public void setAdmissionEducationLevelSubjects(Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects) {
        this.admissionEducationLevelSubjects = admissionEducationLevelSubjects;
    }

    @Column(name="institution_name", nullable=false)
    public String getInstitutionName() {
        return this.institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    @Column(name="year_of_passing", nullable=false)
    public String getYearOfPassing() {
        return this.yearOfPassing;
    }

    public void setYearOfPassing(String yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    @Column(name="markType", nullable=false)
    public String getMarkType() {
        return this.markType;
    }

    public void setMarkType(String markType) {
        this.markType = markType;
    }
}
