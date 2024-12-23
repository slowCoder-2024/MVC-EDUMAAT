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
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_supplier_master", uniqueConstraints={@UniqueConstraint(columnNames={"supplier_code"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class SupplierMaster
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long supplierId;
    private String supplierName;
    private String contactPersonName;
    private String gender;
    private String contactNumber;
    private String email;
    private String fax;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private String postCode;
    private String supplierCode;
    private String tinNumber;
    private String cstNumber;
    private String serviceTaxNumber;
    private String bankName;
    private String bankAccountNo;
    private String bankIFSCCode;
    private String panNumber;
    private String description;
    private Integer scoringField;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Integer status;
    private Set<InventoryPurchaseOrder> inventoryPurchaseOrder = new LinkedHashSet<InventoryPurchaseOrder>();
    private Set<InventoryReceipt> inventoryReceipt = new LinkedHashSet<InventoryReceipt>();

    public SupplierMaster(String supplierName, String contactPersonName, String gender, String contactNumber, String email, String addressLine1, String addressLine2, String country, String state, String city, String postCode, String tinNumber, String bankName, String bankAccountNo, String bankIFSCCode, String panNumber, String createdBy, String modifiedBy, Integer status) {
        this.supplierName = supplierName;
        this.contactPersonName = contactPersonName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postCode = postCode;
        this.tinNumber = tinNumber;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
        this.bankIFSCCode = bankIFSCCode;
        this.panNumber = panNumber;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.status = status;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
    }

    public SupplierMaster(String supplierName, String contactPersonName, String gender, String contactNumber, String email, String fax, String addressLine1, String addressLine2, String country, String state, String city, String postCode, String tinNumber, String cstNumber, String serviceTaxNumber, String bankName, String bankAccountNo, String bankIFSCCode, String panNumber, String description, String createdBy, String modifiedBy, Integer status) {
        this.supplierName = supplierName;
        this.contactPersonName = contactPersonName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.fax = fax;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postCode = postCode;
        this.tinNumber = tinNumber;
        this.cstNumber = cstNumber;
        this.serviceTaxNumber = serviceTaxNumber;
        this.bankName = bankName;
        this.bankAccountNo = bankAccountNo;
        this.bankIFSCCode = bankIFSCCode;
        this.panNumber = panNumber;
        this.description = description;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
    }

    SupplierMaster() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="supplier_id", unique=true, nullable=false)
    public Long getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Column(name="supplier_name", nullable=false, length=100)
    public String getSupplierName() {
        return this.supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Column(name="contact_person_name", nullable=true, length=100)
    public String getContactPersonName() {
        return this.contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    @Column(name="gender", nullable=true, length=15)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="contact_number", nullable=false, length=20)
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name="email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="fax", nullable=true, length=30)
    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name="address_line1", nullable=false, length=255)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name="address_line2", nullable=false, length=255)
    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name="country", nullable=false, length=100)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="state", nullable=false, length=100)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="city", nullable=false, length=100)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="post_code", nullable=false, length=10)
    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Column(name="supplier_code", nullable=false, length=50)
    public String getSupplierCode() {
        return this.supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    @Column(name="tin_number", nullable=true, length=50)
    public String getTinNumber() {
        return this.tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    @Column(name="cst_number", nullable=true, length=50)
    public String getCstNumber() {
        return this.cstNumber;
    }

    public void setCstNumber(String cstNumber) {
        this.cstNumber = cstNumber;
    }

    @Column(name="service_tax_number", nullable=true, length=50)
    public String getServiceTaxNumber() {
        return this.serviceTaxNumber;
    }

    public void setServiceTaxNumber(String serviceTaxNumber) {
        this.serviceTaxNumber = serviceTaxNumber;
    }

    @Column(name="bank_name", nullable=true, length=100)
    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name="account_number", nullable=true, length=100)
    public String getBankAccountNo() {
        return this.bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    @Column(name="ifsc_code", nullable=true, length=100)
    public String getBankIFSCCode() {
        return this.bankIFSCCode;
    }

    public void setBankIFSCCode(String bankIFSCCode) {
        this.bankIFSCCode = bankIFSCCode;
    }

    @Column(name="pan_number", nullable=true, length=50)
    public String getPanNumber() {
        return this.panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    @Column(name="description", nullable=true, length=255)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Column(name="status", nullable=false, length=20)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="scoring_field", nullable=true, length=11)
    public Integer getScoringField() {
        return this.scoringField;
    }

    public void setScoringField(Integer scoringField) {
        this.scoringField = scoringField;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="supplierMaster")
    @ForeignKey(name="supplierMasterInInventoryPurchaseOrder")
    @OrderBy(value="purchase_order_id ASC")
    public Set<InventoryPurchaseOrder> getInventoryPurchaseOrder() {
        return this.inventoryPurchaseOrder;
    }

    public void setInventoryPurchaseOrder(Set<InventoryPurchaseOrder> inventoryPurchaseOrder) {
        this.inventoryPurchaseOrder = inventoryPurchaseOrder;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="supplierMaster")
    @ForeignKey(name="supplierMasterInInventoryReceipt")
    public Set<InventoryReceipt> getInventoryReceipt() {
        return this.inventoryReceipt;
    }

    public void setInventoryReceipt(Set<InventoryReceipt> inventoryReceipt) {
        this.inventoryReceipt = inventoryReceipt;
    }
}
