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
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
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
@Table(name="tbl_staff_leave_type")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class StaffLeaveType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long staffLeaveTypeId;
    private String staffLeaveType;
    private Set<StaffLeaveRequisition> staffLeaveRequisitions = new HashSet<StaffLeaveRequisition>();

    public StaffLeaveType() {
    }

    public StaffLeaveType(String staffLeaveType) {
        this.staffLeaveType = staffLeaveType;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="staff_leave_type_id", nullable=false)
    public Long getStaffLeaveTypeId() {
        return this.staffLeaveTypeId;
    }

    public void setStaffLeaveTypeId(Long staffLeaveTypeId) {
        this.staffLeaveTypeId = staffLeaveTypeId;
    }

    @Column(name="staff_leave_type", nullable=false, length=25)
    public String getStaffLeaveType() {
        return this.staffLeaveType;
    }

    public void setStaffLeaveType(String staffLeaveType) {
        this.staffLeaveType = staffLeaveType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="staffLeaveType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@staffLeaveType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StaffLeaveRequisition> getStaffLeaveRequisitions() {
        return this.staffLeaveRequisitions;
    }

    public void setStaffLeaveRequisitions(Set<StaffLeaveRequisition> staffLeaveRequisitions) {
        this.staffLeaveRequisitions = staffLeaveRequisitions;
    }
}
