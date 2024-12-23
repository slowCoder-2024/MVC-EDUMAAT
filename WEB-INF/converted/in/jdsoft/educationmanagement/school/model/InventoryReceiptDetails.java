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
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
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
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_inventory_receipt_detail")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryReceiptDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long inventoryReceiptDetailId;
    private InventoryReceipt inventoryReceipt;
    private InventoryItemMaster inventoryItemMaster;
    private Double quantity;
    private Integer unitOfMeasure;
    private Double itemamount;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;

    public InventoryReceiptDetails(InventoryItemMaster inventoryItemMaster, Integer unitOfMeasure, Double quantity, Double itemamount, String createdBy, String modifiedBy) {
        this.inventoryItemMaster = inventoryItemMaster;
        this.quantity = quantity;
        this.unitOfMeasure = unitOfMeasure;
        this.itemamount = itemamount;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public InventoryReceiptDetails() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_receipt_detail_id", nullable=false)
    public Long getInventoryReceiptDetailId() {
        return this.inventoryReceiptDetailId;
    }

    public void setInventoryReceiptDetailId(Long inventoryReceiptDetailId) {
        this.inventoryReceiptDetailId = inventoryReceiptDetailId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_receipt_id", nullable=false)
    @ForeignKey(name="inventoryReceiptDetailsInInventoryReceipt")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryReceiptDetails")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryReceipt getInventoryReceipt() {
        return this.inventoryReceipt;
    }

    public void setInventoryReceipt(InventoryReceipt inventoryReceipt) {
        this.inventoryReceipt = inventoryReceipt;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_item_id", nullable=false)
    @ForeignKey(name="inventoryReceiptDetailsInInventoryItem")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryReceiptsItems")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryItemMaster getInventoryItemMaster() {
        return this.inventoryItemMaster;
    }

    public void setInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        this.inventoryItemMaster = inventoryItemMaster;
    }

    @Column(name="quantity", nullable=false, length=100)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name="item_amount", nullable=false)
    public Double getItemamount() {
        return this.itemamount;
    }

    public void setItemamount(Double itemamount) {
        this.itemamount = itemamount;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="modified_by", nullable=false, length=100)
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

    @Column(name="unit_of_measure", nullable=false, length=30)
    public Integer getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(Integer unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
