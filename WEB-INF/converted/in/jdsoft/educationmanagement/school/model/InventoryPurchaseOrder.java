/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.CascadeType
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_inventory_purchase_order", uniqueConstraints={@UniqueConstraint(columnNames={"purchase_order_no"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryPurchaseOrder
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long purchaseOrderId;
    private String purchaseOrderNo;
    private SupplierMaster supplierMaster;
    private Date purchaseOrderDate;
    private AcademicYear academicYear;
    private Double totalQuantity;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Institution institution;
    private boolean isPurchased;
    private InventoryReceipt inventoryReceipt;
    private Set<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails = new LinkedHashSet<InventoryPurchaseOrderDetails>(0);

    public InventoryPurchaseOrder(SupplierMaster supplierMaster, AcademicYear academicYear, String createdBy, String modifiedBy, Institution institution, boolean isPurchased, Double totalQuantity) {
        this.supplierMaster = supplierMaster;
        this.purchaseOrderNo = Long.toString(System.currentTimeMillis());
        this.purchaseOrderDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.academicYear = academicYear;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.institution = institution;
        this.isPurchased = isPurchased;
        this.totalQuantity = totalQuantity;
    }

    public InventoryPurchaseOrder() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="purchase_order_id", unique=true, nullable=false)
    public Long getPurchaseOrderId() {
        return this.purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="supplier_id", nullable=false)
    @ForeignKey(name="inventoryPurchaseOrderInSupplierMaster")
    public SupplierMaster getSupplierMaster() {
        return this.supplierMaster;
    }

    public void setSupplierMaster(SupplierMaster supplierMaster) {
        this.supplierMaster = supplierMaster;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="purchase_order_date", nullable=false)
    public Date getPurchaseOrderDate() {
        return this.purchaseOrderDate;
    }

    public void setPurchaseOrderDate(Date purchaseOrderDate) {
        this.purchaseOrderDate = purchaseOrderDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="academic_year_id", nullable=false)
    @ForeignKey(name="inventoryPurchaseOrderInAcademicYear")
    public AcademicYear getAcademicYear() {
        return this.academicYear;
    }

    public void setAcademicYear(AcademicYear academicYear) {
        this.academicYear = academicYear;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="inventoryPurchaseOrderInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @Column(name="is_purchased", nullable=false)
    public boolean isPurchased() {
        return this.isPurchased;
    }

    public void setPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    @Column(name="purchase_order_no", nullable=false, length=100)
    public String getPurchaseOrderNo() {
        return this.purchaseOrderNo;
    }

    public void setPurchaseOrderNo(String purchaseOrderNo) {
        this.purchaseOrderNo = purchaseOrderNo;
    }

    @OneToOne(fetch=FetchType.LAZY)
    public InventoryReceipt getInventoryReceipt() {
        return this.inventoryReceipt;
    }

    public void setInventoryReceipt(InventoryReceipt inventoryReceipt) {
        this.inventoryReceipt = inventoryReceipt;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryPurchaseOrder", cascade={CascadeType.ALL, CascadeType.REMOVE})
    @ForeignKey(name="inventoryPurchaseOrderInInventoryPurchaseOrderDetails")
    @OrderBy(value="purchase_order_detail_id ASC")
    public Set<InventoryPurchaseOrderDetails> getInventoryPurchaseOrderDetails() {
        return this.inventoryPurchaseOrderDetails;
    }

    public void setInventoryPurchaseOrderDetails(Set<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails) {
        this.inventoryPurchaseOrderDetails = inventoryPurchaseOrderDetails;
    }

    @Column(name="total_quantity", nullable=false, length=100)
    public Double getTotalQuantity() {
        return this.totalQuantity;
    }

    public void setTotalQuantity(Double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
