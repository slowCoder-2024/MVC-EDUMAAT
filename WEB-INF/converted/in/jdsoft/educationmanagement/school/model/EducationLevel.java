/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import in.jdsoft.educationmanagement.school.model.EducationLevelSubject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_education_level", uniqueConstraints={@UniqueConstraint(columnNames={"education_level_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class EducationLevel
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long educationLevelId;
    private String educationLevelTitle;
    private Set<Admission> admissions = new HashSet<Admission>(0);
    private Set<EducationLevelSubject> educationLevelSubjects = new HashSet<EducationLevelSubject>(0);
    private Set<AdmissionEducationLevelDetails> admissionEducationLevelDetails = new HashSet<AdmissionEducationLevelDetails>(0);

    public EducationLevel() {
    }

    public EducationLevel(String educationLevelTitle) {
        this.educationLevelTitle = WordUtils.capitalize((String)educationLevelTitle);
    }

    public EducationLevel(String educationLevelTitle, Set<EducationLevelSubject> educationLevelSubjects) {
        this.educationLevelTitle = educationLevelTitle;
        this.educationLevelSubjects = educationLevelSubjects;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="education_level_id", nullable=false)
    public Long getEducationLevelId() {
        return this.educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    @Column(name="education_level_title", nullable=false, length=100)
    public String getEducationLevelTitle() {
        return this.educationLevelTitle;
    }

    public void setEducationLevelTitle(String educationLevelTitle) {
        this.educationLevelTitle = WordUtils.capitalize((String)educationLevelTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="educationLevel")
    @JsonManagedReference
    @OrderBy(value="educationLevelSubjectId ASC")
    public Set<EducationLevelSubject> getEducationLevelSubjects() {
        return this.educationLevelSubjects;
    }

    public void setEducationLevelSubjects(Set<EducationLevelSubject> educationLevelSubjects) {
        this.educationLevelSubjects = educationLevelSubjects;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="educationLevel")
    public Set<AdmissionEducationLevelDetails> getAdmissionEducationLevelDetails() {
        return this.admissionEducationLevelDetails;
    }

    public void setAdmissionEducationLevelDetails(Set<AdmissionEducationLevelDetails> admissionEducationLevelDetails) {
        this.admissionEducationLevelDetails = admissionEducationLevelDetails;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="educationLevel")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@educationLevel")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }
}
