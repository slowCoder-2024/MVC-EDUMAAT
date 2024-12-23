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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetail;
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
@Table(name="tbl_class_section_term_exam_activity", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_term_exam_id", "term_exam_activity_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionTermExamActivity
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionTermExamActivityId;
    private ClassSectionTermExam classSectionTermExam;
    private String activityName;
    private double maximumMark;
    private Set<StudentMarksDetail> studentMarksDetails = new LinkedHashSet<StudentMarksDetail>();

    ClassSectionTermExamActivity() {
    }

    public ClassSectionTermExamActivity(ClassSectionTermExam classSectionTermExam, String activityName, double maximumMark) {
        this.classSectionTermExam = classSectionTermExam;
        this.activityName = activityName;
        this.maximumMark = maximumMark;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_term_exam_activity_id", nullable=false)
    public Long getClassSectionTermExamActivityId() {
        return this.classSectionTermExamActivityId;
    }

    public void setClassSectionTermExamActivityId(Long classSectionTermExamActivityId) {
        this.classSectionTermExamActivityId = classSectionTermExamActivityId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_id", nullable=false)
    @ForeignKey(name="classSectionTermExamInClassSectionTermExamActivity")
    public ClassSectionTermExam getClassSectionTermExam() {
        return this.classSectionTermExam;
    }

    public void setClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        this.classSectionTermExam = classSectionTermExam;
    }

    @Column(name="term_exam_activity_name", nullable=false, length=100)
    public String getActivityName() {
        return this.activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Column(name="maximum_mark", nullable=false, length=100)
    public double getMaximumMark() {
        return this.maximumMark;
    }

    public void setMaximumMark(double maximumMark) {
        this.maximumMark = maximumMark;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTermExamActivity")
    @ForeignKey(name="studentMarksDetailInClassSectionTermExamActivity")
    public Set<StudentMarksDetail> getStudentMarksDetails() {
        return this.studentMarksDetails;
    }

    public void setStudentMarksDetails(Set<StudentMarksDetail> studentMarksDetails) {
        this.studentMarksDetails = studentMarksDetails;
    }
}
