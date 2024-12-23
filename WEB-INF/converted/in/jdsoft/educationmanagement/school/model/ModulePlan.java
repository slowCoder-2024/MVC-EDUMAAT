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
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.ModulePlanSchedule;
import java.io.Serializable;
import java.util.HashSet;
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

@Entity
@Table(name="tbl_module_plan")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ModulePlan
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long modulePlanId;
    private String purpose;
    private String modulePlanObjectives;
    private String modulePlanTeacherProcedure;
    private String modulePlanStudentActivities;
    private String assessment;
    private String referenceFramework;
    private String referenceMaterial;
    private String referenceHandout;
    private String referenceQuestions;
    private String aboutassignments;
    private Module module;
    private Set<ModulePlanSchedule> modulePlanSchedules = new HashSet<ModulePlanSchedule>(0);

    public ModulePlan(String purpose, String moduleObjectives, String moduleTeacherProcedure, String moduleStudentActivities, String assessment, String referenceFramework, String referenceMaterial, String referenceHandout, String referenceQuestions, String aboutassignments, Module module) {
        this.purpose = purpose;
        this.modulePlanObjectives = moduleObjectives;
        this.modulePlanTeacherProcedure = moduleTeacherProcedure;
        this.modulePlanStudentActivities = moduleStudentActivities;
        this.assessment = assessment;
        this.referenceFramework = referenceFramework;
        this.referenceMaterial = referenceMaterial;
        this.referenceHandout = referenceHandout;
        this.referenceQuestions = referenceQuestions;
        this.aboutassignments = aboutassignments;
        this.module = module;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="module_plan_id", unique=true, nullable=false)
    public Long getModulePlanId() {
        return this.modulePlanId;
    }

    public void setModulePlanId(Long modulePlanId) {
        this.modulePlanId = modulePlanId;
    }

    @Column(name="module_plan_purpose", nullable=false, length=255)
    public String getPurpose() {
        return this.purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Column(name="module_plan_objectives", nullable=false, length=255)
    public String getModulePlanObjectives() {
        return this.modulePlanObjectives;
    }

    public void setModulePlanObjectives(String modulePlanObjectives) {
        this.modulePlanObjectives = modulePlanObjectives;
    }

    @Column(name="module_plan_teacher_procedure", nullable=false, length=255)
    public String getModulePlanTeacherProcedure() {
        return this.modulePlanTeacherProcedure;
    }

    public void setModulePlanTeacherProcedure(String modulePlanTeacherProcedure) {
        this.modulePlanTeacherProcedure = modulePlanTeacherProcedure;
    }

    @Column(name="module_plan_student_activities", nullable=false, length=255)
    public String getModulePlanStudentActivities() {
        return this.modulePlanStudentActivities;
    }

    public void setModulePlanStudentActivities(String modulePlanStudentActivities) {
        this.modulePlanStudentActivities = modulePlanStudentActivities;
    }

    @Column(name="module_plan_assessment", nullable=false, length=150)
    public String getAssessment() {
        return this.assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    @Column(name="module_plan_reference_framework", nullable=true, length=120)
    public String getReferenceFramework() {
        return this.referenceFramework;
    }

    public void setReferenceFramework(String referenceFramework) {
        this.referenceFramework = referenceFramework;
    }

    @Column(name="module_plan_reference_material", nullable=true, length=120)
    public String getReferenceMaterial() {
        return this.referenceMaterial;
    }

    public void setReferenceMaterial(String referenceMaterial) {
        this.referenceMaterial = referenceMaterial;
    }

    @Column(name="module_plan_reference_handout", nullable=true, length=120)
    public String getReferenceHandout() {
        return this.referenceHandout;
    }

    public void setReferenceHandout(String referenceHandout) {
        this.referenceHandout = referenceHandout;
    }

    @Column(name="module_plan_reference_questions", nullable=true, length=120)
    public String getReferenceQuestions() {
        return this.referenceQuestions;
    }

    public void setReferenceQuestions(String referenceQuestions) {
        this.referenceQuestions = referenceQuestions;
    }

    @Column(name="module_plan_about_assignments", nullable=true, length=150)
    public String getAboutassignments() {
        return this.aboutassignments;
    }

    public void setAboutassignments(String aboutassignments) {
        this.aboutassignments = aboutassignments;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="modulePlan")
    public Set<ModulePlanSchedule> getModulePlanSchedules() {
        return this.modulePlanSchedules;
    }

    public void setModulePlanSchedules(Set<ModulePlanSchedule> modulePlanSchedules) {
        this.modulePlanSchedules = modulePlanSchedules;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="module_id", nullable=false)
    public Module getModule() {
        return this.module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
