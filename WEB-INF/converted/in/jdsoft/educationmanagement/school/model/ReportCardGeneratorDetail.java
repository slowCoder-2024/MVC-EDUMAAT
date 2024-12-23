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
 *  javax.persistence.DiscriminatorColumn
 *  javax.persistence.DiscriminatorType
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Inheritance
 *  javax.persistence.InheritanceType
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_report_card_generator_detail")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=255)
@DiscriminatorValue(value="report_card_generator_detail")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ReportCardGeneratorDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long reportCardDetailId;
    public String formativeAssessmentGradeObtained;
    public Double formativeAssessmentGradePointObtained;
    public String summativeAssessmentGradeObtained;
    public Double summativeAssessmentGradePointObtained;
    public String overAllGradePointInGrade;
    public Double overAllGradePointInPoint;
    private ReportCardGenerator reportCardGenerator;

    public ReportCardGeneratorDetail(String formativeAssessmentGradeObtained, Double formativeAssessmentGradePointObtained, String summativeAssessmentGradeObtained, Double summativeAssessmentGradePointObtained, String overAllGradePointInGrade, Double overAllGradePointInPoint, ReportCardGenerator reportCardGenerator) {
        this.formativeAssessmentGradeObtained = formativeAssessmentGradeObtained;
        this.formativeAssessmentGradePointObtained = formativeAssessmentGradePointObtained;
        this.summativeAssessmentGradeObtained = summativeAssessmentGradeObtained;
        this.summativeAssessmentGradePointObtained = summativeAssessmentGradePointObtained;
        this.overAllGradePointInGrade = overAllGradePointInGrade;
        this.overAllGradePointInPoint = overAllGradePointInPoint;
        this.reportCardGenerator = reportCardGenerator;
    }

    public ReportCardGeneratorDetail() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="report_card_detail_id", nullable=false)
    public Long getReportCardDetailId() {
        return this.reportCardDetailId;
    }

    public void setReportCardDetailId(Long reportCardDetailId) {
        this.reportCardDetailId = reportCardDetailId;
    }

    @Column(name="formative_assessment_grade_Obtained", nullable=false, length=255)
    public String getFormativeAssessmentGradeObtained() {
        return this.formativeAssessmentGradeObtained;
    }

    public void setFormativeAssessmentGradeObtained(String formativeAssessmentGradeObtained) {
        this.formativeAssessmentGradeObtained = formativeAssessmentGradeObtained;
    }

    @Column(name="formative_assessment_grade_point_obtained", nullable=false, length=255)
    public Double getFormativeAssessmentGradePointObtained() {
        return this.formativeAssessmentGradePointObtained;
    }

    public void setFormativeAssessmentGradePointObtained(Double formativeAssessmentGradePointObtained) {
        this.formativeAssessmentGradePointObtained = formativeAssessmentGradePointObtained;
    }

    @Column(name="summative_assessment_grade_Obtained", nullable=false, length=255)
    public String getSummativeAssessmentGradeObtained() {
        return this.summativeAssessmentGradeObtained;
    }

    public void setSummativeAssessmentGradeObtained(String summativeAssessmentGradeObtained) {
        this.summativeAssessmentGradeObtained = summativeAssessmentGradeObtained;
    }

    @Column(name="summative_assessment_grade_point_obtained", nullable=false, length=255)
    public Double getSummativeAssessmentGradePointObtained() {
        return this.summativeAssessmentGradePointObtained;
    }

    public void setSummativeAssessmentGradePointObtained(Double summativeAssessmentGradePointObtained) {
        this.summativeAssessmentGradePointObtained = summativeAssessmentGradePointObtained;
    }

    @Column(name="overall_grade_point_in_grade", nullable=false, length=255)
    public String getOverAllGradePointInGrade() {
        return this.overAllGradePointInGrade;
    }

    public void setOverAllGradePointInGrade(String overAllGradePointInGrade) {
        this.overAllGradePointInGrade = overAllGradePointInGrade;
    }

    @Column(name="overall_grade_point_in_point", nullable=false, length=255)
    public Double getOverAllGradePointInPoint() {
        return this.overAllGradePointInPoint;
    }

    public void setOverAllGradePointInPoint(Double overAllGradePointInPoint) {
        this.overAllGradePointInPoint = overAllGradePointInPoint;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@reportCardGeneratorDetails")
    @JsonIdentityReference(alwaysAsId=true)
    @JoinColumn(name="report_card_generator_id", nullable=false)
    public ReportCardGenerator getReportCardGenerator() {
        return this.reportCardGenerator;
    }

    public void setReportCardGenerator(ReportCardGenerator reportCardGenerator) {
        this.reportCardGenerator = reportCardGenerator;
    }
}
