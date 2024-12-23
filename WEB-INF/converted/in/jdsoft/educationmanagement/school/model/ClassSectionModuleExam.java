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
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
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
@Table(name="tbl_class_section_module_exam", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_term_id", "class_section_term_exam_id", "class_section_module_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionModuleExam
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionModuleExamId;
    private ClassSectionModule classSectionModule;
    private ClassSectionTerm classSectionTerm;
    private ClassSectionTermExam classSectionTermExam;

    ClassSectionModuleExam() {
    }

    public ClassSectionModuleExam(ClassSectionModule classSectionModule, ClassSectionTermExam classSectionTermExam) {
        this.classSectionModule = classSectionModule;
        this.classSectionTermExam = classSectionTermExam;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_module_exam_id", nullable=false)
    public Long getClassSectionModuleExamId() {
        return this.classSectionModuleExamId;
    }

    public void setClassSectionModuleExamId(Long classSectionModuleExamId) {
        this.classSectionModuleExamId = classSectionModuleExamId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_module_id", nullable=false)
    @ForeignKey(name="classSectionModuleInClassSectionModuleExam")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionModuleExams")
    @JsonIdentityReference(alwaysAsId=true)
    public ClassSectionModule getClassSectionModule() {
        return this.classSectionModule;
    }

    public void setClassSectionModule(ClassSectionModule classSectionModule) {
        this.classSectionModule = classSectionModule;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_id", nullable=false)
    @ForeignKey(name="classSectionTermInClassSectionModuleExam")
    public ClassSectionTerm getClassSectionTerm() {
        return this.classSectionTerm;
    }

    public void setClassSectionTerm(ClassSectionTerm classSectionTerm) {
        this.classSectionTerm = classSectionTerm;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_term_exam_id", nullable=false)
    @ForeignKey(name="classSectionTermExamInClassSectionModuleExam")
    public ClassSectionTermExam getClassSectionTermExam() {
        return this.classSectionTermExam;
    }

    public void setClassSectionTermExam(ClassSectionTermExam classSectionTermExam) {
        this.classSectionTermExam = classSectionTermExam;
    }
}
