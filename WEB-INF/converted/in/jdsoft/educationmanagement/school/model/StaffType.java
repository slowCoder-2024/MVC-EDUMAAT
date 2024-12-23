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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_staff_type", uniqueConstraints={@UniqueConstraint(columnNames={"staff_type_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffTypeId;
    private String staffTypeName;
    Set<Staff> staffs = new LinkedHashSet<Staff>();
    Set<StaffDesignation> staffDesignations = new LinkedHashSet<StaffDesignation>();

    public StaffType(String staffTypeName) {
        this.staffTypeName = staffTypeName;
    }

    StaffType() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_type_id", nullable=false)
    public Long getStaffTypeId() {
        return this.staffTypeId;
    }

    public void setStaffTypeId(Long staffTypeId) {
        this.staffTypeId = staffTypeId;
    }

    @Column(name="staff_type_name", nullable=false, length=100)
    public String getStaffTypeName() {
        return this.staffTypeName;
    }

    public void setStaffTypeName(String staffTypeName) {
        this.staffTypeName = staffTypeName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staffType")
    @ForeignKey(name="staffInStaffType")
    public Set<Staff> getStaffs() {
        return this.staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staffType")
    @ForeignKey(name="staffDesignationInStaffType")
    public Set<StaffDesignation> getStaffDesignations() {
        return this.staffDesignations;
    }

    public void setStaffDesignations(Set<StaffDesignation> staffDesignations) {
        this.staffDesignations = staffDesignations;
    }
}
