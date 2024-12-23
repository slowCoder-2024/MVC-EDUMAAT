/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
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
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Staff;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_class_section_module_staff", uniqueConstraints={@UniqueConstraint(columnNames={"class_section_module_id", "staff_id", "academic_year_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class ClassSectionModuleStaff
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long classSectionModuleStaffId;
    private ClassSectionModule classSectionModule;
    private Staff staff;
    private AcademicYear academicYear;

    ClassSectionModuleStaff() {
    }

    public ClassSectionModuleStaff(ClassSectionModule classSectionModule, Staff staff, AcademicYear academicYear) {
        this.classSectionModule = classSectionModule;
        this.staff = staff;
        this.academicYear = academicYear;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="class_section_module_staff_id", nullable=false)
    public Long getClassSectionModuleStaffId() {
        return this.classSectionModuleStaffId;
    }

    public void setClassSectionModuleStaffId(Long classSectionModuleStaffId) {
        this.classSectionModuleStaffId = classSectionModuleStaffId;
    }

    @OneToOne(fetch=FetchType.LAZY, cascade={CascadeType.REMOVE})
    @JoinColumn(name="class_section_module_id", nullable=true)
    @ForeignKey(name="classSectionModuleInClassSectionModuleStaff")
    @OrderBy(value="classSectionModuleId ASC")
    @JsonBackReference
    public ClassSectionModule getClassSectionModule() {
        return this.classSectionModule;
    }

    public void setClassSectionModule(ClassSectionModule classSectionModule) {
        this.classSectionModule = classSectionModule;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="staff_id", nullable=true)
    @ForeignKey(name="staffInClassSectionModuleStaff")
    public Staff getStaff() {
        return this.staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=true)
    @ForeignKey(name="academicYearInClassSectionModuleStaff")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@classSectionModulesStaff")
    @JsonIdentityReference(alwaysAsId=true)
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
    }
}
