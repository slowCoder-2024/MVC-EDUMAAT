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
 *  javax.persistence.OneToMany
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.AssetRegister;
import in.jdsoft.educationmanagement.school.model.InventoryCategory;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.InventoryType;
import in.jdsoft.educationmanagement.school.model.TaxClass;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_inventory_item_master", uniqueConstraints={@UniqueConstraint(columnNames={"item_code"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryItemMaster
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long itemId;
    private String itemName;
    private String itemCode;
    private String itemBarCode;
    private String itemBarImage;
    private InventoryType inventoryType;
    private InventoryCategory inventoryCategory;
    private String itemDescription;
    private boolean purchaseItem;
    private boolean assetItem;
    private boolean salesItem;
    private double salesRate;
    private boolean inventoryItem;
    private Double totalQuantityInStock;
    private String location;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private TaxClass taxClass;
    private double pricePerUnit;
    private Integer unitOfMeasure;
    private Double quantity;
    private User inCharge;
    private Set<InventoryRequisition> inventoryRequisitions = new LinkedHashSet<InventoryRequisition>();
    private Set<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails = new LinkedHashSet<InventoryPurchaseOrderDetails>();
    private Set<InventoryReceiptDetails> inventoryReceiptsItems = new LinkedHashSet<InventoryReceiptDetails>();
    private Set<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasters = new LinkedHashSet<InventoryItemIssueMaster>();
    private Set<AssetRegister> assetRegister = new LinkedHashSet<AssetRegister>();

    public InventoryItemMaster(String itemName, InventoryType inventoryType, InventoryCategory inventoryCategory, String itemDescription, boolean purchaseItem, boolean assetItem, boolean salesItem, double salesRate, boolean inventoryItem, String location, String createdBy, String modifiedBy, User inCharge) {
        this.itemName = itemName;
        this.inventoryType = inventoryType;
        this.inventoryCategory = inventoryCategory;
        this.itemDescription = itemDescription;
        this.purchaseItem = purchaseItem;
        this.assetItem = assetItem;
        this.salesItem = salesItem;
        this.salesRate = salesRate;
        this.inventoryItem = inventoryItem;
        this.location = location;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.inCharge = inCharge;
    }

    public InventoryItemMaster() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_id", unique=true, nullable=false)
    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name="item_name", nullable=false, length=255)
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Column(name="item_code", nullable=false, length=50)
    public String getItemCode() {
        return this.itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Column(name="item_bar_code", nullable=false, length=255)
    public String getItemBarCode() {
        return this.itemBarCode;
    }

    public void setItemBarCode(String itemBarCode) {
        this.itemBarCode = itemBarCode;
    }

    @Column(name="item_bar_image", nullable=false, length=255)
    public String getItemBarImage() {
        return this.itemBarImage;
    }

    public void setItemBarImage(String itemBarImage) {
        this.itemBarImage = itemBarImage;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_type_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryItemMasters")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryType getInventoryType() {
        return this.inventoryType;
    }

    public void setInventoryType(InventoryType inventoryType) {
        this.inventoryType = inventoryType;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_category_id", nullable=false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryItemMasters")
    @JsonIdentityReference(alwaysAsId=true)
    public InventoryCategory getInventoryCategory() {
        return this.inventoryCategory;
    }

    public void setInventoryCategory(InventoryCategory inventoryCategory) {
        this.inventoryCategory = inventoryCategory;
    }

    @Column(name="item_description", nullable=true, length=255)
    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tax_class_id", nullable=true)
    public TaxClass getTaxClass() {
        return this.taxClass;
    }

    public void setTaxClass(TaxClass taxClass) {
        this.taxClass = taxClass;
    }

    @Column(name="is_purchase_item", nullable=false)
    public boolean isPurchaseItem() {
        return this.purchaseItem;
    }

    public void setPurchaseItem(boolean purchaseItem) {
        this.purchaseItem = purchaseItem;
    }

    @Column(name="is_Sales_item", nullable=false)
    public boolean isSalesItem() {
        return this.salesItem;
    }

    public void setSalesItem(boolean salesItem) {
        this.salesItem = salesItem;
    }

    @Column(name="sales_rate", nullable=false, length=100)
    public double getSalesRate() {
        return this.salesRate;
    }

    public void setSalesRate(double salesRate) {
        this.salesRate = salesRate;
    }

    @Column(name="price_per_unit_in_last_purchased", nullable=true)
    public double getPricePerUnit() {
        return this.pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Column(name="unit_of_measure_in_last_purchased", nullable=true, length=30)
    public Integer getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(Integer unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Column(name="total_qty_in_stock", nullable=false, length=100)
    public Double getTotalQuantityInStock() {
        return this.totalQuantityInStock;
    }

    public void setTotalQuantityInStock(Double totalQuantityInStock) {
        this.totalQuantityInStock = totalQuantityInStock;
    }

    @Column(name="location", nullable=false, length=255)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name="is_Inventory_item", nullable=false)
    public boolean isInventoryItem() {
        return this.inventoryItem;
    }

    public void setInventoryItem(boolean inventoryItem) {
        this.inventoryItem = inventoryItem;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemId")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryItemId")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<InventoryRequisition> getInventoryRequisitions() {
        return this.inventoryRequisitions;
    }

    public void setInventoryRequisitions(Set<InventoryRequisition> inventoryRequisitions) {
        this.inventoryRequisitions = inventoryRequisitions;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="last_modified_by", nullable=false, length=100)
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
    @Column(name="last_modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="in_charge_user_id", nullable=false, referencedColumnName="user_id")
    public User getInCharge() {
        return this.inCharge;
    }

    public void setInCharge(User inCharge) {
        this.inCharge = inCharge;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemMaster")
    @ForeignKey(name="InventoryItemMasterInInventoryItemIssueAndReturn")
    public Set<InventoryItemIssueMaster> getInventoryItemIssueAndReturnMasters() {
        return this.inventoryItemIssueAndReturnMasters;
    }

    public void setInventoryItemIssueAndReturnMasters(Set<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasters) {
        this.inventoryItemIssueAndReturnMasters = inventoryItemIssueAndReturnMasters;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemMaster")
    @ForeignKey(name="inventoryItemMasterInInventoryPurchaseOrderDetails")
    @OrderBy(value="purchase_order_detail_id ASC")
    public Set<InventoryPurchaseOrderDetails> getInventoryPurchaseOrderDetails() {
        return this.inventoryPurchaseOrderDetails;
    }

    public void setInventoryPurchaseOrderDetails(Set<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails) {
        this.inventoryPurchaseOrderDetails = inventoryPurchaseOrderDetails;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemMaster")
    @ForeignKey(name="inventoryItemInInventoryReceiptDetails")
    @OrderBy(value="inventory_receipt_detail_id ASC")
    public Set<InventoryReceiptDetails> getInventoryReceiptsItems() {
        return this.inventoryReceiptsItems;
    }

    public void setInventoryReceiptsItems(Set<InventoryReceiptDetails> inventoryReceiptsItems) {
        this.inventoryReceiptsItems = inventoryReceiptsItems;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryItemMaster")
    public Set<AssetRegister> getAssetRegister() {
        return this.assetRegister;
    }

    public void setAssetRegister(Set<AssetRegister> assetRegister) {
        this.assetRegister = assetRegister;
    }

    @Column(name="is_asset_item", nullable=false)
    public boolean isAssetItem() {
        return this.assetItem;
    }

    public void setAssetItem(boolean assetItem) {
        this.assetItem = assetItem;
    }

    @Column(name="total_qty_in_last_purchased", nullable=true, length=100)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
