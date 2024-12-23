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
@Table(name="tbl_student_status", uniqueConstraints={@UniqueConstraint(columnNames={"status_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StudentStatus
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long studentStatusId;
    private String statusTitle;
    private Set<Student> students = new LinkedHashSet<Student>();
    private Set<StudentIDCardGeneration> studentIDCardGenerations = new LinkedHashSet<StudentIDCardGeneration>(0);

    StudentStatus() {
    }

    public StudentStatus(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_status_id", unique=true, nullable=false)
    public Long getStudentStatusId() {
        return this.studentStatusId;
    }

    public void setStudentStatusId(Long studentStatusId) {
        this.studentStatusId = studentStatusId;
    }

    @Column(name="status_title", nullable=false, length=100)
    public String getStatusTitle() {
        return this.statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentStatus")
    @ForeignKey(name="studentStatusInStudents")
    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="studentStatus")
    @ForeignKey(name="studentStatusInStudentIDCardGenerations")
    @OrderBy(value="studentIDCardGenerationId ASC")
    public Set<StudentIDCardGeneration> getStudentIDCardGenerations() {
        return this.studentIDCardGenerations;
    }

    public void setStudentIDCardGenerations(Set<StudentIDCardGeneration> studentIDCardGenerations) {
        this.studentIDCardGenerations = studentIDCardGenerations;
    }
}
