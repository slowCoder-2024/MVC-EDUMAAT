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
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.StaffLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StaffMovementRequisition;
import in.jdsoft.educationmanagement.school.model.StudentLeaveRequisition;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import java.io.Serializable;
import java.util.HashSet;
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

@Entity
@Table(name="tbl_requisition_type")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class RequisitionType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long requisitionTypeId;
    private String requisitionType;
    private Set<StudentLeaveRequisition> studentLeaveRequisitions = new HashSet<StudentLeaveRequisition>();
    private Set<StaffLeaveRequisition> staffLeaveRequisitions = new HashSet<StaffLeaveRequisition>();
    private Set<TCRequisition> tcRequisitions = new HashSet<TCRequisition>();
    private Set<StudentMovementRequisition> studentMovementRequisitions = new HashSet<StudentMovementRequisition>();
    private Set<StaffMovementRequisition> staffMomentRequisitions = new HashSet<StaffMovementRequisition>();
    private Set<PurchaseRequisition> purchaseRequisitions = new LinkedHashSet<PurchaseRequisition>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="requisition_type_id", nullable=false)
    public Long getRequisitionTypeId() {
        return this.requisitionTypeId;
    }

    public void setRequisitionTypeId(Long requisitionTypeId) {
        this.requisitionTypeId = requisitionTypeId;
    }

    @Column(name="requisition_type", nullable=false, length=200)
    public String getRequisitionType() {
        return this.requisitionType;
    }

    public void setRequisitionType(String requisitionType) {
        this.requisitionType = requisitionType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StudentLeaveRequisition> getStudentLeaveRequisitions() {
        return this.studentLeaveRequisitions;
    }

    public void setStudentLeaveRequisitions(Set<StudentLeaveRequisition> studentLeaveRequisitions) {
        this.studentLeaveRequisitions = studentLeaveRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StaffLeaveRequisition> getStaffLeaveRequisitions() {
        return this.staffLeaveRequisitions;
    }

    public void setStaffLeaveRequisitions(Set<StaffLeaveRequisition> staffLeaveRequisitions) {
        this.staffLeaveRequisitions = staffLeaveRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<TCRequisition> getTcRequisitions() {
        return this.tcRequisitions;
    }

    public void setTcRequisitions(Set<TCRequisition> tcRequisitions) {
        this.tcRequisitions = tcRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @OrderBy(value="studentMovementRequisitionId ASC")
    public Set<StudentMovementRequisition> getStudentMovementRequisitions() {
        return this.studentMovementRequisitions;
    }

    public void setStudentMovementRequisitions(Set<StudentMovementRequisition> studentMovementRequisitions) {
        this.studentMovementRequisitions = studentMovementRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<StaffMovementRequisition> getStaffMomentRequisitions() {
        return this.staffMomentRequisitions;
    }

    public void setStaffMomentRequisitions(Set<StaffMovementRequisition> staffMomentRequisitions) {
        this.staffMomentRequisitions = staffMomentRequisitions;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="requisitionType")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@requisitionType")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<PurchaseRequisition> getPurchaseRequisitions() {
        return this.purchaseRequisitions;
    }

    public void setPurchaseRequisitions(Set<PurchaseRequisition> purchaseRequisitions) {
        this.purchaseRequisitions = purchaseRequisitions;
    }
}
