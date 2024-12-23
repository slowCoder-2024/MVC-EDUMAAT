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
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkillExam;
import in.jdsoft.educationmanagement.school.model.ModuleSkill;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleSkill;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_module_skill", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_module_id", "module_skill_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionModuleSkill
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionModuleSkillId;
    private ClassSectionModule classSectionModule;
    private ModuleSkill moduleSkill;
    private Set<ClassSectionModuleSkillExam> classSectionModuleSkillExams = new LinkedHashSet<ClassSectionModuleSkillExam>();
    private Set<StudentMarksDetailWithModuleSkill> studentMarksDetailWithModuleSkills = new LinkedHashSet<StudentMarksDetailWithModuleSkill>();

    ClassSectionModuleSkill() {
    }

    public ClassSectionModuleSkill(ClassSectionModule classSectionModule, ModuleSkill moduleSkill) {
        this.classSectionModule = classSectionModule;
        this.moduleSkill = moduleSkill;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_module_skill_id", nullable=false)
    public Long getClassSectionModuleSkillId() {
        return this.classSectionModuleSkillId;
    }

    public void setClassSectionModuleSkillId(Long classSectionModuleSkillId) {
        this.classSectionModuleSkillId = classSectionModuleSkillId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_module_id", nullable=false)
    @ForeignKey(name="classSectionModuleInClassSectionModuleSkill")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionModuleSkills")
    @JsonIdentityReference(alwaysAsId=true)
    public ClassSectionModule getClassSectionModule() {
        return this.classSectionModule;
    }

    public void setClassSectionModule(ClassSectionModule classSectionModule) {
        this.classSectionModule = classSectionModule;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_skill_id", nullable=false)
    @ForeignKey(name="moduleSkillInClassSectionModuleSkill")
    public ModuleSkill getModuleSkill() {
        return this.moduleSkill;
    }

    public void setModuleSkill(ModuleSkill moduleSkill) {
        this.moduleSkill = moduleSkill;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModuleSkill", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionModuleSkillExamInClassSectionModuleSkill")
    public Set<ClassSectionModuleSkillExam> getClassSectionModuleSkillExams() {
        return this.classSectionModuleSkillExams;
    }

    public void setClassSectionModuleSkillExams(Set<ClassSectionModuleSkillExam> classSectionModuleSkillExams) {
        this.classSectionModuleSkillExams = classSectionModuleSkillExams;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModuleSkill")
    @ForeignKey(name="studentMarksModuleSkillDetailInClassSectionModuleSkill")
    public Set<StudentMarksDetailWithModuleSkill> getStudentMarksDetailWithModuleSkills() {
        return this.studentMarksDetailWithModuleSkills;
    }

    public void setStudentMarksDetailWithModuleSkills(Set<StudentMarksDetailWithModuleSkill> studentMarksDetailWithModuleSkills) {
        this.studentMarksDetailWithModuleSkills = studentMarksDetailWithModuleSkills;
    }
}
