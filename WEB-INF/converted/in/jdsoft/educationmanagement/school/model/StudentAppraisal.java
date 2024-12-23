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
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
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
@Table(name="tbl_student_appraisal")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class StudentAppraisal
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentAppraisalId;
    private String appraisalTerm;
    private String relationshipRating;
    private String relationshipComments;
    private String attitudeRating;
    private String attitudeComments;
    private String academicRating;
    private String academicComments;
    private String initiativeRating;
    private String initiativeComments;
    private String creativityRating;
    private String creativityComments;
    private String punctualityRating;
    private String punctualityComments;
    private String sportsAndSocialRating;
    private String sportsAndSocialComments;
    private String appraisalCreatedByUser;
    private String recommendations;
    private String appraisalStatus;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Student student;
    private Institution institution;
    private AcademicYear academicYear;
    private Class studentClass;
    private Section section;

    public StudentAppraisal(String appraisalTerm, String relationshipRating, String relationshipComments, String attitudeRating, String attitudeComments, String academicRating, String academicComments, String initiativeRating, String initiativeComments, String creativityRating, String creativityComments, String punctualityRating, String punctualityComments, String sportsAndSocialRating, String sportsAndSocialComments, String appraisalCreatedByUser, String recommendations, String appraisalStatus, Student student, Class studentClass, Section section, AcademicYear academicYear, Institution institution, String createdBy, String modifiedBy) {
        this.appraisalTerm = appraisalTerm;
        this.relationshipRating = relationshipRating;
        this.relationshipComments = relationshipComments;
        this.attitudeRating = attitudeRating;
        this.attitudeComments = attitudeComments;
        this.academicRating = academicRating;
        this.academicComments = academicComments;
        this.initiativeRating = initiativeRating;
        this.initiativeComments = initiativeComments;
        this.creativityRating = creativityRating;
        this.creativityComments = creativityComments;
        this.punctualityRating = punctualityRating;
        this.punctualityComments = punctualityComments;
        this.sportsAndSocialRating = sportsAndSocialRating;
        this.sportsAndSocialComments = sportsAndSocialComments;
        this.appraisalCreatedByUser = appraisalCreatedByUser;
        this.recommendations = recommendations;
        this.appraisalStatus = appraisalStatus;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.student = student;
        this.institution = institution;
        this.academicYear = academicYear;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
        this.studentClass = studentClass;
        this.section = section;
    }

    public StudentAppraisal() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_performance_id", unique=true, nullable=false)
    public Long getStudentAppraisalId() {
        return this.studentAppraisalId;
    }

    public void setStudentAppraisalId(Long studentAppraisalId) {
        this.studentAppraisalId = studentAppraisalId;
    }

    @Column(name="appraisal_term", nullable=false, length=30)
    public String getAppraisalTerm() {
        return this.appraisalTerm;
    }

    public void setAppraisalTerm(String appraisalTerm) {
        this.appraisalTerm = appraisalTerm;
    }

    @Column(name="aspect_two_relationship_rating", nullable=false, length=20)
    public String getRelationshipRating() {
        return this.relationshipRating;
    }

    public void setRelationshipRating(String relationshipRating) {
        this.relationshipRating = relationshipRating;
    }

    @Column(name="aspect_two_relationship_comments", nullable=false, length=150)
    public String getRelationshipComments() {
        return this.relationshipComments;
    }

    public void setRelationshipComments(String relationshipComments) {
        this.relationshipComments = relationshipComments;
    }

    @Column(name="aspect_one_attitude_rating", nullable=false, length=20)
    public String getAttitudeRating() {
        return this.attitudeRating;
    }

    public void setAttitudeRating(String attitudeRating) {
        this.attitudeRating = attitudeRating;
    }

    @Column(name="aspect_one_attitude_comments", nullable=false, length=150)
    public String getAttitudeComments() {
        return this.attitudeComments;
    }

    public void setAttitudeComments(String attitudeComments) {
        this.attitudeComments = attitudeComments;
    }

    @Column(name="aspect_three_initiative_rating", nullable=false, length=20)
    public String getInitiativeRating() {
        return this.initiativeRating;
    }

    public void setInitiativeRating(String initiativeRating) {
        this.initiativeRating = initiativeRating;
    }

    @Column(name="aspect_three_initiative_comments", nullable=false, length=150)
    public String getInitiativeComments() {
        return this.initiativeComments;
    }

    public void setInitiativeComments(String initiativeComments) {
        this.initiativeComments = initiativeComments;
    }

    @Column(name="aspect_six_creativity_rating", nullable=false, length=20)
    public String getCreativityRating() {
        return this.creativityRating;
    }

    public void setCreativityRating(String creativityRating) {
        this.creativityRating = creativityRating;
    }

    @Column(name="aspect_six_creativity_comments", nullable=false, length=150)
    public String getCreativityComments() {
        return this.creativityComments;
    }

    public void setCreativityComments(String creativityComments) {
        this.creativityComments = creativityComments;
    }

    @Column(name="aspect_five_academic_rating", nullable=false, length=20)
    public String getAcademicRating() {
        return this.academicRating;
    }

    public void setAcademicRating(String academicRating) {
        this.academicRating = academicRating;
    }

    @Column(name="aspect_five_academic_comments", nullable=false, length=150)
    public String getAcademicComments() {
        return this.academicComments;
    }

    public void setAcademicComments(String academicComments) {
        this.academicComments = academicComments;
    }

    @Column(name="aspect_four_punctuality_rating", nullable=false, length=20)
    public String getPunctualityRating() {
        return this.punctualityRating;
    }

    public void setPunctualityRating(String punctualityRating) {
        this.punctualityRating = punctualityRating;
    }

    @Column(name="aspect_four_punctuality_comments", nullable=false, length=150)
    public String getPunctualityComments() {
        return this.punctualityComments;
    }

    public void setPunctualityComments(String punctualityComments) {
        this.punctualityComments = punctualityComments;
    }

    @Column(name="aspect_seven_sports_and_social_rating", nullable=false, length=20)
    public String getSportsAndSocialRating() {
        return this.sportsAndSocialRating;
    }

    public void setSportsAndSocialRating(String sportsAndSocialRating) {
        this.sportsAndSocialRating = sportsAndSocialRating;
    }

    @Column(name="aspect_seven_sports_and_social_comments", nullable=false, length=150)
    public String getSportsAndSocialComments() {
        return this.sportsAndSocialComments;
    }

    public void setSportsAndSocialComments(String sportsAndSocialComments) {
        this.sportsAndSocialComments = sportsAndSocialComments;
    }

    @Column(name="appraisal_created_by_user", nullable=false, length=30)
    public String getAppraisalCreatedByUser() {
        return this.appraisalCreatedByUser;
    }

    public void setAppraisalCreatedByUser(String appraisalCreatedByUser) {
        this.appraisalCreatedByUser = appraisalCreatedByUser;
    }

    @Column(name="recommendations", nullable=false, length=150)
    public String getRecommendations() {
        return this.recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    @Column(name="appraisal_status", nullable=false, length=20)
    public String getAppraisalStatus() {
        return this.appraisalStatus;
    }

    public void setAppraisalStatus(String appraisalStatus) {
        this.appraisalStatus = appraisalStatus;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="appraisal_created_date", nullable=false, length=10)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAppraisals")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentAppraisals")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
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

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_id", nullable=false)
    public Class getStudentClass() {
        return this.studentClass;
    }

    public void setStudentClass(Class studentClass) {
        this.studentClass = studentClass;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="section_id", nullable=false)
    public Section getSection() {
        return this.section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
