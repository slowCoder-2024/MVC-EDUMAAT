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
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.StudentMark;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_assesment_type", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_id", "class_section_assesment_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionAssesmentType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionAssesmentTypeId;
    private String classSectionAssesmentName;
    private ClassSection classSection;
    private boolean gradeMethod;
    private GradeSystem gradeSystem;
    private Integer assessmentLimit;
    private Set<StudentMark> studentMarks = new LinkedHashSet<StudentMark>();

    ClassSectionAssesmentType() {
    }

    public ClassSectionAssesmentType(String classSectionAssesmentName, boolean gradeMethod, GradeSystem gradeSystem, Integer assessmentLimit) {
        this.classSectionAssesmentName = classSectionAssesmentName;
        this.assessmentLimit = assessmentLimit;
        this.gradeSystem = gradeSystem;
        this.gradeMethod = gradeMethod;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_assesment_type_id", nullable=false)
    public Long getClassSectionAssesmentTypeId() {
        return this.classSectionAssesmentTypeId;
    }

    public void setClassSectionAssesmentTypeId(Long classSectionAssesmentTypeId) {
        this.classSectionAssesmentTypeId = classSectionAssesmentTypeId;
    }

    @Column(name="class_section_assesment_name", nullable=false, length=100)
    public String getClassSectionAssesmentName() {
        return this.classSectionAssesmentName;
    }

    public void setClassSectionAssesmentName(String classSectionAssesmentName) {
        this.classSectionAssesmentName = classSectionAssesmentName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionAssesmentType")
    @JsonIdentityReference(alwaysAsId=true)
    @ForeignKey(name="classSectionInClassSectionAssesmentType")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @Column(name="is_grade_method", nullable=false)
    public boolean isGradeMethod() {
        return this.gradeMethod;
    }

    public void setGradeMethod(boolean gradeMethod) {
        this.gradeMethod = gradeMethod;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="grade_system_id", nullable=true)
    @ForeignKey(name="gradeSystemInClassSectionAssesmentType")
    public GradeSystem getGradeSystem() {
        return this.gradeSystem;
    }

    public void setGradeSystem(GradeSystem gradeSystem) {
        this.gradeSystem = gradeSystem;
    }

    @Column(name="assessment_limit", nullable=false, length=20)
    public Integer getAssessmentLimit() {
        return this.assessmentLimit;
    }

    public void setAssessmentLimit(Integer assessmentLimit) {
        this.assessmentLimit = assessmentLimit;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionAssesmentType")
    @ForeignKey(name="studentMarksInClassSectionAssessmentType")
    public Set<StudentMark> getStudentMarks() {
        return this.studentMarks;
    }

    public void setStudentMarks(Set<StudentMark> studentMarks) {
        this.studentMarks = studentMarks;
    }
}
