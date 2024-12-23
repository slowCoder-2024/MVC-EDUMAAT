/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
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
@Table(name="tbl_staff_appraisal")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class StaffAppraisal
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffAppraisalId;
    private String appraisalTerm;
    private String relationshipRating;
    private String relationshipComments;
    private String teachingRating;
    private String teachingComments;
    private String researchAndHigherQualificationRating;
    private String researchAndHigherQualificationComments;
    private String initiativeAndOrganizationRating;
    private String initiativeAndOrganizationComments;
    private String innovationRating;
    private String innovationComments;
    private String punctualityRating;
    private String punctualityComments;
    private String goalAlignmentRating;
    private String goalAlignmentComments;
    private String appraisalCreatedByUser;
    private String recommendations;
    private String appraisalStatus;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private Staff staff;
    private Institution institution;
    private AcademicYear academicYear;

    public StaffAppraisal(String appraisalTerm, String relationshipRating, String relationshipComments, String teachingRating, String teachingComments, String researchAndHigherQualificationRating, String researchAndHigherQualificationComments, String initiativeAndOrganizationRating, String initiativeAndOrganizationComments, String innovationRating, String innovationComments, String punctualityRating, String punctualityComments, String goalAlignmentRating, String goalAlignmentComments, String appraisalCreatedByUser, String recommendations, String appraisalStatus, Staff staff, AcademicYear academicYear, Institution institution, String createdBy, String modifiedBy) {
        this.appraisalTerm = appraisalTerm;
        this.relationshipRating = relationshipRating;
        this.relationshipComments = relationshipComments;
        this.setTeachingRating(teachingRating);
        this.setTeachingComments(teachingComments);
        this.researchAndHigherQualificationRating = researchAndHigherQualificationRating;
        this.researchAndHigherQualificationComments = researchAndHigherQualificationComments;
        this.initiativeAndOrganizationRating = initiativeAndOrganizationRating;
        this.initiativeAndOrganizationComments = initiativeAndOrganizationComments;
        this.innovationRating = innovationRating;
        this.innovationComments = innovationComments;
        this.setPunctualityRating(punctualityRating);
        this.setPunctualityComments(punctualityComments);
        this.setGoalAlignmentRating(goalAlignmentRating);
        this.goalAlignmentComments = goalAlignmentComments;
        this.appraisalCreatedByUser = appraisalCreatedByUser;
        this.recommendations = recommendations;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.appraisalStatus = appraisalStatus;
        this.staff = staff;
        this.institution = institution;
        this.academicYear = academicYear;
        this.modifiedBy = modifiedBy;
        this.createdBy = createdBy;
    }

    public StaffAppraisal() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_appraisal_id", unique=true, nullable=false)
    public Long getStaffAppraisalId() {
        return this.staffAppraisalId;
    }

    public void setStaffAppraisalId(Long staffAppraisalId) {
        this.staffAppraisalId = staffAppraisalId;
    }

    @Column(name="appraisal_term", nullable=false, length=50)
    public String getAppraisalTerm() {
        return this.appraisalTerm;
    }

    public void setAppraisalTerm(String appraisalTerm) {
        this.appraisalTerm = appraisalTerm;
    }

    @Column(name="aspect_one_relationship_rating", nullable=false, length=20)
    public String getRelationshipRating() {
        return this.relationshipRating;
    }

    public void setRelationshipRating(String relationshipRating) {
        this.relationshipRating = relationshipRating;
    }

    @Column(name="aspect_one_relationship_comments", nullable=false, length=100)
    public String getRelationshipComments() {
        return this.relationshipComments;
    }

    public void setRelationshipComments(String relationshipComments) {
        this.relationshipComments = relationshipComments;
    }

    @Column(name="aspect_two_teaching_rating", nullable=false, length=20)
    public String getTeachingRating() {
        return this.teachingRating;
    }

    public void setTeachingRating(String teachingRating) {
        this.teachingRating = teachingRating;
    }

    @Column(name="aspect_two_teaching_comments", nullable=false, length=100)
    public String getTeachingComments() {
        return this.teachingComments;
    }

    public void setTeachingComments(String teachingComments) {
        this.teachingComments = teachingComments;
    }

    @Column(name="aspect_three_research_and_higher_qualification_rating", nullable=false, length=20)
    public String getResearchAndHigherQualificationRating() {
        return this.researchAndHigherQualificationRating;
    }

    public void setResearchAndHigherQualificationRating(String researchAndHigherQualificationRating) {
        this.researchAndHigherQualificationRating = researchAndHigherQualificationRating;
    }

    @Column(name="aspect_three_research_and_higher_qualification_comments", nullable=false, length=100)
    public String getResearchAndHigherQualificationComments() {
        return this.researchAndHigherQualificationComments;
    }

    public void setResearchAndHigherQualificationComments(String researchAndHigherQualificationComments) {
        this.researchAndHigherQualificationComments = researchAndHigherQualificationComments;
    }

    @Column(name="aspect_four_initiative_and_organization_rating", nullable=false, length=20)
    public String getInitiativeAndOrganizationRating() {
        return this.initiativeAndOrganizationRating;
    }

    public void setInitiativeAndOrganizationRating(String initiativeAndOrganizationRating) {
        this.initiativeAndOrganizationRating = initiativeAndOrganizationRating;
    }

    @Column(name="aspect_four_initiative_and_organization_comments", nullable=false, length=100)
    public String getInitiativeAndOrganizationComments() {
        return this.initiativeAndOrganizationComments;
    }

    public void setInitiativeAndOrganizationComments(String initiativeAndOrganizationComments) {
        this.initiativeAndOrganizationComments = initiativeAndOrganizationComments;
    }

    @Column(name="aspect_five_innovation_rating", nullable=false, length=20)
    public String getInnovationRating() {
        return this.innovationRating;
    }

    public void setInnovationRating(String innovationRating) {
        this.innovationRating = innovationRating;
    }

    @Column(name="aspect_five_innovation_comments", nullable=false, length=100)
    public String getInnovationComments() {
        return this.innovationComments;
    }

    public void setInnovationComments(String innovationComments) {
        this.innovationComments = innovationComments;
    }

    @Column(name="aspect_six_punctuality_rating", nullable=false, length=20)
    public String getPunctualityRating() {
        return this.punctualityRating;
    }

    public void setPunctualityRating(String punctualityRating) {
        this.punctualityRating = punctualityRating;
    }

    @Column(name="aspect_six_punctuality_comments", nullable=false, length=100)
    public String getPunctualityComments() {
        return this.punctualityComments;
    }

    public void setPunctualityComments(String punctualityComments) {
        this.punctualityComments = punctualityComments;
    }

    @Column(name="aspect_seven_goal_alignment_rating", nullable=false, length=20)
    public String getGoalAlignmentRating() {
        return this.goalAlignmentRating;
    }

    public void setGoalAlignmentRating(String goalAlignmentRating) {
        this.goalAlignmentRating = goalAlignmentRating;
    }

    @Column(name="aspect_seven_goal_alignment_comments", nullable=false, length=100)
    public String getGoalAlignmentComments() {
        return this.goalAlignmentComments;
    }

    public void setGoalAlignmentComments(String goalAlignmentComments) {
        this.goalAlignmentComments = goalAlignmentComments;
    }

    @Column(name="appraisal_created_by_user", nullable=false, length=30)
    public String getAppraisalCreatedByUser() {
        return this.appraisalCreatedByUser;
    }

    public void setAppraisalCreatedByUser(String appraisalCreatedByUser) {
        this.appraisalCreatedByUser = appraisalCreatedByUser;
    }

    @Column(name="recommendations", nullable=false, length=100)
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
    @JoinColumn(name="staff_id", nullable=false)
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
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
}
