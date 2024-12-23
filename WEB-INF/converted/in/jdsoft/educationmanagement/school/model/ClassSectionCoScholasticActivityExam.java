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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivity;
import in.jdsoft.educationmanagement.school.model.ClassSectionTerm;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_coscholastic_activity_exam", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_coscholastic_activity_id", "class_section_term_id", "class_section_term_exam_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionCoScholasticActivityExam
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionCoScholasticActivityExamId;
    private ClassSectionCoScholasticActivity classSectionCoScholasticActivity;
    private ClassSectionTerm classSectionTerm;
    private ClassSectionTermExam classSectionTermExam;

    ClassSectionCoScholasticActivityExam() {
    }

    public ClassSectionCoScholasticActivityExam(ClassSectionCoScholasticActivity classSectionCoScholasticActivity, ClassSectionTermExam classSectionTermExam) {
        this.classSectionCoScholasticActivity = classSectionCoScholasticActivity;
        this.classSectionTermExam = classSectionTermExam;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_coscholastic_activity_exam_id", nullable=false)
    public Long getClassSectionCoScholasticActivityExamId() {
        return this.classSectionCoScholasticActivityExamId;
    }

    public void setClassSectionCoScholasticActivityExamId(Long classSectionCoScholasticActivityExamId) {
        this.classSectionCoScholasticActivityExamId = classSectionCoScholasticActivityExamId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_coscholastic_activity_id", nullable=false)
    @ForeignKey(name="classSectionCoScholasticActivityInClassSectionCoScholasticActivityExam")
    public ClassSectionCoScholasticActivity getClassSectionCoScholasticActivity() {
        return this.classSectionCoScholasticActivity;
    }

    public void setClassSectionCoScholasticActivity(ClassSectionCoScholasticActivity classSectionCoScholasticActivity) {
        this.classSectionCoScholasticActivity = classSectionCoScholasticActivity;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_id", nullable=false)
    @ForeignKey(name="classSectionTermInClassSectionCoScholasticActivityExam")
    public ClassSectionTerm getClassSectionTerm() {
        return this.classSectionTerm;
    }

    public void setClassSectionTerm(ClassSectionTerm classSectionTerm) {
        this.classSectionTerm = classSectionTerm;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_id", nullable=false)
    @ForeignKey(name="classSectionTermExamInClassSectionCoScholasticActivityExam")
    public ClassSectionTermExam getClassSectionTermExam() {
        return this.classSectionTermExam;
    }

    public void setClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        this.classSectionTermExam = classSectionTermExam;
    }
}
