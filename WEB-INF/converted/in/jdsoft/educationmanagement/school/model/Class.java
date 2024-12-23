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
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class", uniqueConstraints={@UniqueConstraint(columnNames={"class_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Class
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classId;
    private String className;
    private Institution institution;
    private Integer classExamConfigStatus;
    private Set<ClassSection> classSections = new LinkedHashSet<ClassSection>();
    private Set<Student> joinedStudents = new LinkedHashSet<Student>();
    private Set<Student> students = new LinkedHashSet<Student>();
    private Set<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
    private Set<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
    private Set<Admission> admissions = new LinkedHashSet<Admission>(0);
    private Set<AdmissionConfig> admissionConfigs = new LinkedHashSet<AdmissionConfig>();
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<StudentAppraisal> studentAppraisals = new LinkedHashSet<StudentAppraisal>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();

    public Class(String className, Institution institution, Integer classExamConfigStatus) {
        this.className = className;
        this.institution = institution;
        this.classExamConfigStatus = classExamConfigStatus;
    }

    Class() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_id", nullable=false)
    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Column(name="class_name", nullable=false, length=100)
    public String getClassName() {
        return this.className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="classInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classes")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="joinedClass")
    @ForeignKey(name="joinedclassInStudents")
    public Set<Student> getJoinedStudents() {
        return this.joinedStudents;
    }

    public void setJoinedStudents(Set<Student> joinedStudents) {
        this.joinedStudents = joinedStudents;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="classInStudents")
    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy="classSection", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    public Set<ClassSection> getClassSections() {
        return this.classSections;
    }

    public void setClassSections(Set<ClassSection> classSections) {
        this.classSections = classSections;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="staffModuleAttendanceInClass")
    public Set<StaffModuleAttendance> getStaffModuleAttendances() {
        return this.staffModuleAttendances;
    }

    public void setStaffModuleAttendances(Set<StaffModuleAttendance> staffModuleAttendances) {
        this.staffModuleAttendances = staffModuleAttendances;
    }

    @Column(name="class_exam_config_status", nullable=false)
    public Integer getClassExamConfigStatus() {
        return this.classExamConfigStatus;
    }

    public void setClassExamConfigStatus(Integer classExamConfigStatus) {
        this.classExamConfigStatus = classExamConfigStatus;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="studentAttendanceInClass")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="classz")
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="classes")
    @ForeignKey(name="classInAdmissionConfig")
    public Set<AdmissionConfig> getAdmissionConfigs() {
        return this.admissionConfigs;
    }

    public void setAdmissionConfigs(Set<AdmissionConfig> admissionConfigs) {
        this.admissionConfigs = admissionConfigs;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="classInStudentIDCardGenerations")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="classInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="classInStudentMovementRequisition")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentClass")
    @ForeignKey(name="classInStudentAppraisal")
    public Set<StudentAppraisal> getStudentAppraisals() {
        return this.studentAppraisals;
    }

    public void setStudentAppraisals(Set<StudentAppraisal> studentAppraisals) {
        this.studentAppraisals = studentAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="timeTableClass")
    @ForeignKey(name="classInStudentAppraisal")
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }
}
