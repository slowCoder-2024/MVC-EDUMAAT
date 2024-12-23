/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
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
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetail;
import in.jdsoft.educationmanagement.school.model.Student;
import java.io.Serializable;
import java.util.LinkedHashSet;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_report_card_generator", uniqueConstraints={@UniqueConstraint(columnNames={"student_id", "report_card_generator_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ReportCardGenerator
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long reportCardGeneratorId;
    private Student student;
    private ClassSection classSection;
    private String cGPAGradeObtained;
    private Double cGPAGradePointObtained;
    private Double cGPAGradePercentageObtained;
    private AcademicYear academicYear;
    private Institution institution;
    private Set<ReportCardGeneratorDetail> reportCardGeneratorDetails = new LinkedHashSet<ReportCardGeneratorDetail>();

    public ReportCardGenerator(ClassSection classSection, AcademicYear academicYear, Institution institution) {
        this.classSection = classSection;
        this.academicYear = academicYear;
        this.institution = institution;
    }

    public ReportCardGenerator() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="report_card_generator_id", nullable=false)
    public Long getReportCardGeneratorId() {
        return this.reportCardGeneratorId;
    }

    public void setReportCardGeneratorId(Long reportCardGeneratorId) {
        this.reportCardGeneratorId = reportCardGeneratorId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id", nullable=false)
    @ForeignKey(name="studentInReportCardGenerator")
    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="ClassSectionInReportCardGenerator")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @Column(name="cgpa_grade_obtained", nullable=true, length=255)
    public String getcGPAGradeObtained() {
        return this.cGPAGradeObtained;
    }

    public void setcGPAGradeObtained(String cGPAGradeObtained) {
        this.cGPAGradeObtained = cGPAGradeObtained;
    }

    @Column(name="cgpa_grade_point_obtained", nullable=true, length=255)
    public Double getcGPAGradePointObtained() {
        return this.cGPAGradePointObtained;
    }

    public void setcGPAGradePointObtained(Double cGPAGradePointObtained) {
        this.cGPAGradePointObtained = cGPAGradePointObtained;
    }

    @Column(name="cgpa_percentage_obtained", nullable=true, length=255)
    public Double getcGPAGradePercentageObtained() {
        return this.cGPAGradePercentageObtained;
    }

    public void setcGPAGradePercentageObtained(Double cGPAGradePercentageObtained) {
        this.cGPAGradePercentageObtained = cGPAGradePercentageObtained;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="AcademicYearInReportCardGenerator")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="institutionInReportCardGenerator")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="reportCardGenerator")
    @ForeignKey(name="reportCardGeneratorDetailInReportCardGenerator")
    @OrderBy(value="reportCardDetailId ASC")
    public Set<ReportCardGeneratorDetail> getReportCardGeneratorDetails() {
        return this.reportCardGeneratorDetails;
    }

    public void setReportCardGeneratorDetails(Set<ReportCardGeneratorDetail> reportCardGeneratorDetails) {
        this.reportCardGeneratorDetails = reportCardGeneratorDetails;
    }
}
