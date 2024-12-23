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
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_blood_group", uniqueConstraints={@UniqueConstraint(columnNames={"blood_group_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BloodGroup
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long bloodGroupId;
    private String bloodGroupName;
    private Set<Student> students = new LinkedHashSet<Student>();
    private Set<Staff> staffs = new LinkedHashSet<Staff>();
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);

    BloodGroup() {
    }

    public BloodGroup(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="blood_group_id", unique=true, nullable=false)
    public Long getBloodGroupId() {
        return this.bloodGroupId;
    }

    public void setBloodGroupId(Long bloodGroupId) {
        this.bloodGroupId = bloodGroupId;
    }

    @Column(name="blood_group_name", nullable=false, length=50)
    public String getBloodGroupName() {
        return this.bloodGroupName;
    }

    public void setBloodGroupName(String bloodGroupName) {
        this.bloodGroupName = bloodGroupName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="bloodGroup")
    @ForeignKey(name="bloodGroupInStudents")
    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="bloodGroup")
    @ForeignKey(name="bloodGroupInStaffs")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="bloodGroup")
    @ForeignKey(name="bloodGroupInStudentIDCardGenerations")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }
}
