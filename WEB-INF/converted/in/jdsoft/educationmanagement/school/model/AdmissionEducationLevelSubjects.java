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
 *  javax.persistence.Table
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_admission_education_level_subject")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionEducationLevelSubjects
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionEducationLevelSubjectId;
    private AdmissionEducationLevelDetails admissionEducationLevelDetail;
    private Admission admission;
    private double subjectMarks;
    private String admissionEducationLevelSubjectTitle;

    public AdmissionEducationLevelSubjects() {
    }

    public AdmissionEducationLevelSubjects(AdmissionEducationLevelDetails admissionEducationLevelDetail, Admission admission, double subjectMarks, String admissionEducationLevelSubjectTitle) {
        this.admissionEducationLevelDetail = admissionEducationLevelDetail;
        this.admission = admission;
        this.subjectMarks = subjectMarks;
        this.admissionEducationLevelSubjectTitle = WordUtils.capitalize((String)admissionEducationLevelSubjectTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_education_level_subject_id", nullable=false)
    public Long getAdmissionEducationLevelSubjectId() {
        return this.admissionEducationLevelSubjectId;
    }

    public void setAdmissionEducationLevelSubjectId(Long admissionEducationLevelSubjectId) {
        this.admissionEducationLevelSubjectId = admissionEducationLevelSubjectId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_education_level_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="admissionEducationLevelSubjects")
    @JsonIdentityReference(alwaysAsId=true)
    public AdmissionEducationLevelDetails getAdmissionEducationLevelDetail() {
        return this.admissionEducationLevelDetail;
    }

    public void setAdmissionEducationLevelDetail(AdmissionEducationLevelDetails admissionEducationLevelDetail) {
        this.admissionEducationLevelDetail = admissionEducationLevelDetail;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="admission_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="admissionEducationLevelSubjects")
    @JsonIdentityReference(alwaysAsId=true)
    public Admission getAdmission() {
        return this.admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @Column(name="subject_marks", nullable=false)
    public double getSubjectMarks() {
        return this.subjectMarks;
    }

    public void setSubjectMarks(double sujectMarks) {
        this.subjectMarks = sujectMarks;
    }

    @Column(name="subject_title", nullable=false)
    public String getAdmissionEducationLevelSubjectTitle() {
        return this.admissionEducationLevelSubjectTitle;
    }

    public void setAdmissionEducationLevelSubjectTitle(String admissionEducationLevelSubjectTitle) {
        this.admissionEducationLevelSubjectTitle = WordUtils.capitalize((String)admissionEducationLevelSubjectTitle);
    }
}
