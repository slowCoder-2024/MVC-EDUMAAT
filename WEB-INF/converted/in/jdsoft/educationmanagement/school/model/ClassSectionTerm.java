/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.CascadeType
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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticAreaExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
@Table(name="tbl_class_section_term", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_id", "term_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionTerm
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionTermId;
    private ClassSection classSection;
    private String termName;
    private Set<ClassSectionModuleExam> classSectionModuleExams = new LinkedHashSet<ClassSectionModuleExam>();
    private Set<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams = new LinkedHashSet<ClassSectionCoScholasticAreaExam>();
    private Set<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams = new LinkedHashSet<ClassSectionCoScholasticActivityExam>();
    private Set<ClassSectionTermExam> classSectionTermExams = new LinkedHashSet<ClassSectionTermExam>();

    ClassSectionTerm() {
    }

    public ClassSectionTerm(ClassSection classSection, String termName) {
        this.classSection = classSection;
        this.termName = termName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_term_id", nullable=false)
    public Long getClassSectionTermId() {
        return this.classSectionTermId;
    }

    public void setClassSectionTermId(Long classSectionTermId) {
        this.classSectionTermId = classSectionTermId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="classSectionInClassSectionTerm")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @Column(name="term_name", nullable=false, length=100)
    public String getTermName() {
        return this.termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTerm")
    @ForeignKey(name="classSectionModuleExamInClassSectionTerm")
    public Set<ClassSectionModuleExam> getClassSectionModuleExams() {
        return this.classSectionModuleExams;
    }

    public void setClassSectionModuleExams(Set<ClassSectionModuleExam> classSectionModuleExams) {
        this.classSectionModuleExams = classSectionModuleExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTerm")
    @ForeignKey(name="classSSectionCoScholasticAreaExamInClassSectionTerm")
    public Set<ClassSectionCoScholasticAreaExam> getClassSectionCoScholasticAreaExams() {
        return this.classSectionCoScholasticAreaExams;
    }

    public void setClassSectionCoScholasticAreaExams(Set<ClassSectionCoScholasticAreaExam> classSectionCoScholasticAreaExams) {
        this.classSectionCoScholasticAreaExams = classSectionCoScholasticAreaExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTerm")
    @ForeignKey(name="classSSectionCoScholasticActivityExamInClassSectionTerm")
    public Set<ClassSectionCoScholasticActivityExam> getClassSectionCoScholasticActivityExams() {
        return this.classSectionCoScholasticActivityExams;
    }

    public void setClassSectionCoScholasticActivityExams(Set<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExams) {
        this.classSectionCoScholasticActivityExams = classSectionCoScholasticActivityExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionTerm", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionTermExamInClassSectionTerm")
    @OrderBy(value="classSectionTermExamId")
    public Set<ClassSectionTermExam> getClassSectionTermExams() {
        return this.classSectionTermExams;
    }

    public void setClassSectionTermExams(Set<ClassSectionTermExam> classSectionTermExams) {
        this.classSectionTermExams = classSectionTermExams;
    }
}
