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
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import in.jdsoft.educationmanagement.school.model.StudentMark;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_student_marks_details")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=255)
@DiscriminatorValue(value="student_marks_details")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentMarksDetail
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentMarksDetailsId;
    private String termExamGradeObtained;
    private Double termExamMarkObtained;
    private Double termExamGradePointObtained;
    private ClassSectionTermExamActivity classSectionTermExamActivity;
    private StudentMark studentMark;

    public StudentMarksDetail(Double termExamMarkObtained, ClassSectionTermExamActivity classSectionTermExamActivity) {
        this.termExamMarkObtained = termExamMarkObtained;
        this.classSectionTermExamActivity = classSectionTermExamActivity;
    }

    public StudentMarksDetail() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_marks_details_id", nullable=false)
    public Long getStudentMarksDetailsId() {
        return this.studentMarksDetailsId;
    }

    public void setStudentMarksDetailsId(Long studentMarksDetailsId) {
        this.studentMarksDetailsId = studentMarksDetailsId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_activity_id", nullable=false)
    @ForeignKey(name="classSectionTermExamActivityInStudentMarksDetails")
    public ClassSectionTermExamActivity getClassSectionTermExamActivity() {
        return this.classSectionTermExamActivity;
    }

    public void setClassSectionTermExamActivity(ClassSectionTermExamActivity classSectionTermExamActivity) {
        this.classSectionTermExamActivity = classSectionTermExamActivity;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentMarksDetails")
    @JsonIdentityReference(alwaysAsId=true)
    @JoinColumn(name="student_mark_id", nullable=false)
    public StudentMark getStudentMark() {
        return this.studentMark;
    }

    public void setStudentMark(StudentMark studentMark) {
        this.studentMark = studentMark;
    }

    @Column(name="term_exam_grade_obtained", nullable=false, length=255)
    public String getTermExamGradeObtained() {
        return this.termExamGradeObtained;
    }

    public void setTermExamGradeObtained(String termExamGradeObtained) {
        this.termExamGradeObtained = termExamGradeObtained;
    }

    @Column(name="term_exam_mark_obtained", nullable=false, length=255)
    public Double getTermExamMarkObtained() {
        return this.termExamMarkObtained;
    }

    public void setTermExamMarkObtained(Double termExamMarkObtained) {
        this.termExamMarkObtained = termExamMarkObtained;
    }

    @Column(name="term_exam_grade_point_obtained", nullable=false, length=255)
    public Double getTermExamGradePointObtained() {
        return this.termExamGradePointObtained;
    }

    public void setTermExamGradePointObtained(Double termExamGradePointObtained) {
        this.termExamGradePointObtained = termExamGradePointObtained;
    }
}
