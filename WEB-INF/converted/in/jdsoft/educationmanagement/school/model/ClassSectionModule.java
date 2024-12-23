/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
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
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleExam;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleStaff;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.ReportCardGeneratorDetailWithModuleBased;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
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
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_module", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_id", "module_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionModule
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionModuleId;
    private boolean skillBased;
    private ClassSection classSection;
    private Module module;
    private Integer status;
    private Set<ClassSectionModuleSkill> classSectionModuleSkills = new LinkedHashSet<ClassSectionModuleSkill>();
    private Set<ClassSectionModuleExam> classSectionModuleExams = new LinkedHashSet<ClassSectionModuleExam>();
    private Set<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
    private ClassSectionModuleStaff classSectionModuleStaff;
    private Set<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds = new LinkedHashSet<StudentMarksDetailWithModuleBased>();
    private Set<ReportCardGeneratorDetailWithModuleBased> ReportCardGeneratorDetailWithModuleBaseds = new LinkedHashSet<ReportCardGeneratorDetailWithModuleBased>();

    ClassSectionModule() {
    }

    public ClassSectionModule(Module module, boolean skillBased) {
        this.module = module;
        this.skillBased = skillBased;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_module_id", nullable=false)
    public Long getClassSectionModuleId() {
        return this.classSectionModuleId;
    }

    public void setClassSectionModuleId(Long classSectionModuleId) {
        this.classSectionModuleId = classSectionModuleId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="class_section_id", nullable=false)
    @ForeignKey(name="classSectionInClassSectionModule")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionModules")
    @JsonIdentityReference(alwaysAsId=true)
    @OrderBy(value="classSectionId ASC")
    public ClassSection getClassSection() {
        return this.classSection;
    }

    public void setClassSection(ClassSection classSection) {
        this.classSection = classSection;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id", nullable=false)
    @ForeignKey(name="moduleInClassSectionModule")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionModules")
    @JsonIdentityReference(alwaysAsId=true)
    @OrderBy(value="moduleId ASC")
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Column(name="is_skill_based", nullable=false)
    public boolean isSkillBased() {
        return this.skillBased;
    }

    public void setSkillBased(boolean skillBased) {
        this.skillBased = skillBased;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModule", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionModuleSkillInClassSectionModule")
    public Set<ClassSectionModuleSkill> getClassSectionModuleSkills() {
        return this.classSectionModuleSkills;
    }

    public void setClassSectionModuleSkills(Set<ClassSectionModuleSkill> classSectionModuleSkills) {
        this.classSectionModuleSkills = classSectionModuleSkills;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModule", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    @ForeignKey(name="classSectionModuleExamInClassSectionModule")
    public Set<ClassSectionModuleExam> getClassSectionModuleExams() {
        return this.classSectionModuleExams;
    }

    public void setClassSectionModuleExams(Set<ClassSectionModuleExam> classSectionModuleExams) {
        this.classSectionModuleExams = classSectionModuleExams;
    }

    @Column(name="status", nullable=false)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="classSectionModule", cascade={CascadeType.ALL})
    @JsonManagedReference
    public ClassSectionModuleStaff getClassSectionModuleStaff() {
        return this.classSectionModuleStaff;
    }

    public void setClassSectionModuleStaff(ClassSectionModuleStaff classSectionModuleStaff) {
        this.classSectionModuleStaff = classSectionModuleStaff;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModule")
    @ForeignKey(name="staffModuleAttendanceInClassSectionModule")
    public Set<StaffModuleAttendance> getStaffModuleAttendances() {
        return this.staffModuleAttendances;
    }

    public void setStaffModuleAttendances(Set<StaffModuleAttendance> staffModuleAttendances) {
        this.staffModuleAttendances = staffModuleAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModule")
    @ForeignKey(name="studentMarksModuleBasedDetailInClassSectionModule")
    public Set<StudentMarksDetailWithModuleBased> getStudentMarksDetailWithModuleBaseds() {
        return this.studentMarksDetailWithModuleBaseds;
    }

    public void setStudentMarksDetailWithModuleBaseds(Set<StudentMarksDetailWithModuleBased> studentMarksDetailWithModuleBaseds) {
        this.studentMarksDetailWithModuleBaseds = studentMarksDetailWithModuleBaseds;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classSectionModule")
    @ForeignKey(name="reportCardGeneratorsModuleBasedDetailInClassSectionModule")
    public Set<ReportCardGeneratorDetailWithModuleBased> getReportCardGeneratorDetailWithModuleBaseds() {
        return this.ReportCardGeneratorDetailWithModuleBaseds;
    }

    public void setReportCardGeneratorDetailWithModuleBaseds(Set<ReportCardGeneratorDetailWithModuleBased> reportCardGeneratorDetailWithModuleBaseds) {
        this.ReportCardGeneratorDetailWithModuleBaseds = reportCardGeneratorDetailWithModuleBaseds;
    }
}
