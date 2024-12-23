/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.DiscriminatorColumn
 *  javax.persistence.DiscriminatorType
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Inheritance
 *  javax.persistence.InheritanceType
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.AssetCategory;
import in.jdsoft.educationmanagement.school.model.AssetRegisterWithComputer;
import in.jdsoft.educationmanagement.school.model.AssetType;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.User;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_asset_register")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=255)
@DiscriminatorValue(value="asset_register")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AssetRegister
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long assetId;
    private String assetName;
    private String assetBarCode;
    private String assetRFID;
    private String assetBarImage;
    private String assetDescription;
    private String manufacturer;
    private String modelNumber;
    private String serialNumber;
    private String type;
    private double price;
    private Integer unitOfMeasure;
    private Double quantity;
    private String location;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private User inCharge;
    private Integer status;
    private String comments;
    private AssetType assetType;
    private AssetCategory assetCategory;
    private InventoryItemMaster inventoryItemMaster;
    private Set<AssetRegisterWithComputer> assetRegisters = new LinkedHashSet<AssetRegisterWithComputer>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="asset_id", unique=true, nullable=false)
    public Long getAssetId() {
        return this.assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @Column(name="asset_name", nullable=false, length=255)
    public String getAssetName() {
        return this.assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    @Column(name="asset_bar_code", nullable=true, length=255)
    public String getAssetBarCode() {
        return this.assetBarCode;
    }

    public void setAssetBarCode(String assetBarCode) {
        this.assetBarCode = assetBarCode;
    }

    @Column(name="asset_rfid", nullable=true, length=255)
    public String getAssetRFID() {
        return this.assetRFID;
    }

    public void setAssetRFID(String assetRFID) {
        this.assetRFID = assetRFID;
    }

    @Column(name="asset_bar_code_image", nullable=true, length=255)
    public String getAssetBarImage() {
        return this.assetBarImage;
    }

    public void setAssetBarImage(String assetBarImage) {
        this.assetBarImage = assetBarImage;
    }

    @Column(name="asset_description", nullable=true, length=255)
    public String getAssetDescription() {
        return this.assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    @Column(name="asset_manufacturer", nullable=true, length=255)
    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Column(name="asset_model_number", nullable=true, length=255)
    public String getModelNumber() {
        return this.modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    @Column(name="asset_serial_number", nullable=true, length=255)
    public String getSerialNumber() {
        return this.serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column(name="asset_type", nullable=true, length=255)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="asset_price", nullable=false)
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="asset_unit_measure", nullable=false, length=255)
    public Integer getUnitOfMeasure() {
        return this.unitOfMeasure;
    }

    public void setUnitOfMeasure(Integer unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    @Column(name="asset_qty", nullable=false)
    public Double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Column(name="asset_loc", nullable=false, length=255)
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    @JoinColumn(name="in_charge_user_id", nullable=true, referencedColumnName="user_id")
    public User getInCharge() {
        return this.inCharge;
    }

    public void setInCharge(User inCharge) {
        this.inCharge = inCharge;
    }

    @Column(name="asset_status", nullable=false, length=100)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="asset_comments", nullable=true, length=100)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asset_type_id", nullable=false)
    public AssetType getAssetType() {
        return this.assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asset_category_id", nullable=false)
    public AssetCategory getAssetCategory() {
        return this.assetCategory;
    }

    public void setAssetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="inventory_item_id", nullable=false)
    public InventoryItemMaster getInventoryItemMaster() {
        return this.inventoryItemMaster;
    }

    public void setInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        this.inventoryItemMaster = inventoryItemMaster;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="assetRegister")
    @ForeignKey(name="assetRegisterInAssetRegisterWithComputer")
    public Set<AssetRegisterWithComputer> getAssetRegisters() {
        return this.assetRegisters;
    }

    public void setAssetRegisters(Set<AssetRegisterWithComputer> assetRegisters) {
        this.assetRegisters = assetRegisters;
    }
}
