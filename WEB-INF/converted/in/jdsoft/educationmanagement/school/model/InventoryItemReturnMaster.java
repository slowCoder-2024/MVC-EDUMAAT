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
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_inventory_item_return_master")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryItemReturnMaster
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long inventoryItemReturnMasterId;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Date itemReturnDate;
    private Double noOfQtyReturn;
    private User returnedBy;
    private AcademicYear itemReturnedAcademicYear;
    private InventoryItemIssueMaster inventoryItemIssueMaster;

    public InventoryItemReturnMaster(String createdBy, String modifiedBy, Date itemReturnDate, Double noOfQtyReturn, User returnedBy, AcademicYear itemReturnedAcademicYear, InventoryItemIssueMaster inventoryItemIssueMaster) {
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.itemReturnDate = itemReturnDate;
        this.noOfQtyReturn = noOfQtyReturn;
        this.returnedBy = returnedBy;
        this.itemReturnedAcademicYear = itemReturnedAcademicYear;
        this.inventoryItemIssueMaster = inventoryItemIssueMaster;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    InventoryItemReturnMaster() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_item_return_master_id", unique=true, nullable=false)
    public Long getInventoryItemReturnMasterId() {
        return this.inventoryItemReturnMasterId;
    }

    public void setInventoryItemReturnMasterId(Long inventoryItemReturnMasterId) {
        this.inventoryItemReturnMasterId = inventoryItemReturnMasterId;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=true, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="item_return_date", nullable=true)
    public Date getItemReturnDate() {
        return this.itemReturnDate;
    }

    public void setItemReturnDate(Date itemReturnDate) {
        this.itemReturnDate = itemReturnDate;
    }

    @Column(name="no_of_qty_return", nullable=true)
    public Double getNoOfQtyReturn() {
        return this.noOfQtyReturn;
    }

    public void setNoOfQtyReturn(Double noOfQtyReturn) {
        this.noOfQtyReturn = noOfQtyReturn;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_returned_user_id", nullable=true, referencedColumnName="user_id")
    public User getReturnedBy() {
        return this.returnedBy;
    }

    public void setReturnedBy(User returnedBy) {
        this.returnedBy = returnedBy;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="item_returned_academic_year_id", nullable=true, referencedColumnName="academic_year_id")
    public AcademicYear getItemReturnedAcademicYear() {
        return this.itemReturnedAcademicYear;
    }

    public void setItemReturnedAcademicYear(AcademicYear itemReturnedAcademicYear) {
        this.itemReturnedAcademicYear = itemReturnedAcademicYear;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_item_issue_master_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryItemReturnMaster")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryItemIssueMaster getInventoryItemIssueMaster() {
        return this.inventoryItemIssueMaster;
    }

    public void setInventoryItemIssueMaster(InventoryItemIssueMaster inventoryItemIssueMaster) {
        this.inventoryItemIssueMaster = inventoryItemIssueMaster;
    }
}
