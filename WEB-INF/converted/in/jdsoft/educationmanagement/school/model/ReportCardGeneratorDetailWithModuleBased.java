/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetail;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue(value="reportcardgeneratordetailwithmodulebased")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ReportCardGeneratorDetailWithModuleBased
extends ReportCardGeneratorDetail {
    private static final long serialVersionUID = 1L;
    private ClassSectionModule classSectionModule;

    public ReportCardGeneratorDetailWithModuleBased(String formativeAssessmentGradeObtained, Double formativeAssessmentGradePointObtained, String summativeAssessmentGradeObtained, Double summativeAssessmentGradePointObtained, String overAllGradePointInGrade, Double overAllGradePointInPoint, ReportCardGenerator reportCardGenerator, ClassSectionModule classSectionModule) {
        super(formativeAssessmentGradeObtained, formativeAssessmentGradePointObtained, summativeAssessmentGradeObtained, summativeAssessmentGradePointObtained, overAllGradePointInGrade, overAllGradePointInPoint, reportCardGenerator);
        this.classSectionModule = classSectionModule;
    }

    public ReportCardGeneratorDetailWithModuleBased() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_module_id", nullable=true)
    @ForeignKey(name="classSectionModuleInReportCardGeneratorDetailWithModuleBased")
    public ClassSectionModule getClassSectionModule() {
        return this.classSectionModule;
    }

    public void setClassSectionModule(ClassSectionModule classSectionModule) {
        this.classSectionModule = classSectionModule;
    }
}
