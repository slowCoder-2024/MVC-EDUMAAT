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
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.StaffModuleAttendance;
import in.jdsoft.educationmanagement.school.model.StudentAppraisal;
import in.jdsoft.educationmanagement.school.model.StudentAttendance;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_section", uniqueConstraints={@UniqueConstraint(columnNames={"section_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class Section
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long sectionId;
    private String sectionName;
    private Institution institution;
    private Set<ClassSection> classSections = new LinkedHashSet<ClassSection>();
    private Set<StaffModuleAttendance> staffModuleAttendances = new LinkedHashSet<StaffModuleAttendance>();
    private Set<StudentAttendance> studentAttendances = new LinkedHashSet<StudentAttendance>();
    private Set<TCRequisition> tCRequisitions = new LinkedHashSet<TCRequisition>(0);
    private Set<StudentMovementRequisition> studentMovementRequisitions = new LinkedHashSet<StudentMovementRequisition>(0);
    private Set<StudentAppraisal> studentAppraisals = new LinkedHashSet<StudentAppraisal>();
    private Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators = new LinkedHashSet<SubstituteTimeTableGenerator>();

    Section() {
    }

    public Section(String sectionName, Institution institution) {
        this.sectionName = sectionName;
        this.institution = institution;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="section_id", nullable=false)
    public Long getSectionId() {
        return this.sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    @Column(name="section_name", nullable=false, length=50)
    public String getSectionName() {
        return this.sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="sectionsInInstitution")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@sections")
    @JsonIdentityReference(alwaysAsId=true)
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToMany(mappedBy="sectionClass")
    public Set<ClassSection> getClassSections() {
        return this.classSections;
    }

    public void setClassSections(Set<ClassSection> classSections) {
        this.classSections = classSections;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="staffModuleAteendanceInSection")
    public Set<StaffModuleAttendance> getStaffModuleAttendances() {
        return this.staffModuleAttendances;
    }

    public void setStaffModuleAttendances(Set<StaffModuleAttendance> staffModuleAttendances) {
        this.staffModuleAttendances = staffModuleAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="studentAttendanceInSection")
    public Set<StudentAttendance> getStudentAttendances() {
        return this.studentAttendances;
    }

    public void setStudentAttendances(Set<StudentAttendance> studentAttendances) {
        this.studentAttendances = studentAttendances;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="sectionInTCRequisition")
    @OrderBy(value="transferCertificateRequisitionId ASC")
    public Set<TCRequisition> gettCRequisitions() {
        return this.tCRequisitions;
    }

    public void settCRequisitions(Set<TCRequisition> tCRequisitions) {
        this.tCRequisitions = tCRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="sectionInStudentMovementRequisition")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="sectionInStudentAppraisal")
    public Set<StudentAppraisal> getStudentAppraisals() {
        return this.studentAppraisals;
    }

    public void setStudentAppraisals(Set<StudentAppraisal> studentAppraisals) {
        this.studentAppraisals = studentAppraisals;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="section")
    @ForeignKey(name="sectionInSubstituteTimeTableGenerator")
    public Set<SubstituteTimeTableGenerator> getSubstituteTimeTableGenerators() {
        return this.substituteTimeTableGenerators;
    }

    public void setSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) {
        this.substituteTimeTableGenerators = substituteTimeTableGenerators;
    }
}
