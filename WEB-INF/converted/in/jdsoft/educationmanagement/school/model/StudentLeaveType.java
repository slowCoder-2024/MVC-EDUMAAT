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
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student_leave_type")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentLeaveType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentLeaveTypeId;
    private String studentLeaveType;
    private Set<StudentLeaveRequisition> studentLeaveRequisitions = new HashSet<StudentLeaveRequisition>();

    public StudentLeaveType() {
    }

    public StudentLeaveType(String studentLeaveType) {
        this.studentLeaveType = studentLeaveType;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_leave_type_id", nullable=false)
    public Long getStudentLeaveTypeId() {
        return this.studentLeaveTypeId;
    }

    public void setStudentLeaveTypeId(Long studentLeaveTypeId) {
        this.studentLeaveTypeId = studentLeaveTypeId;
    }

    @Column(name="student_leave_type", nullable=false, length=25)
    public String getStudentLeaveType() {
        return this.studentLeaveType;
    }

    public void setStudentLeaveType(String studentLeaveType) {
        this.studentLeaveType = studentLeaveType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentLeaveType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@studentLeaveType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StudentLeaveRequisition> getStudentLeaveRequisitions() {
        return this.studentLeaveRequisitions;
    }

    public void setStudentLeaveRequisitions(Set<StudentLeaveRequisition> studentLeaveRequisitions) {
        this.studentLeaveRequisitions = studentLeaveRequisitions;
    }
}
