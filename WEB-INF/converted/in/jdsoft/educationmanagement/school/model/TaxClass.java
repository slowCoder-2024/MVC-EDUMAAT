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
 *  javax.persistence.ManyToMany
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_tax_class", uniqueConstraints={@UniqueConstraint(columnNames={"tax_type_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class TaxClass
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long taxId;
    private String taxTypeName;
    private double taxRate;
    private Set<InventoryItemMaster> inventoryItemMasters = new LinkedHashSet<InventoryItemMaster>();
    private Set<InventoryReceipt> inventoryReceipts = new LinkedHashSet<InventoryReceipt>();
    private Set<FeesItem> feesItems = new LinkedHashSet<FeesItem>();

    public TaxClass(String taxTypeName, double taxRate) {
        this.taxTypeName = taxTypeName;
        this.taxRate = taxRate;
    }

    public TaxClass() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="tax_id", nullable=false)
    public Long getTaxId() {
        return this.taxId;
    }

    public void setTaxId(Long taxId) {
        this.taxId = taxId;
    }

    @Column(name="tax_type_name", nullable=false, length=100)
    public String getTaxTypeName() {
        return this.taxTypeName;
    }

    public void setTaxTypeName(String taxTypeName) {
        this.taxTypeName = taxTypeName;
    }

    @Column(name="tax_rate", nullable=false, precision=22, scale=0)
    public double getTaxRate() {
        return this.taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="taxClass")
    public Set<InventoryItemMaster> getInventoryItemMasters() {
        return this.inventoryItemMasters;
    }

    public void setInventoryItemMasters(Set<InventoryItemMaster> inventoryItemMasters) {
        this.inventoryItemMasters = inventoryItemMasters;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="taxClass")
    public Set<InventoryReceipt> getInventoryReceipts() {
        return this.inventoryReceipts;
    }

    public void setInventoryReceipts(Set<InventoryReceipt> inventoryReceipts) {
        this.inventoryReceipts = inventoryReceipts;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="taxClasses")
    @ForeignKey(name="taxClassInFeesItems")
    public Set<FeesItem> getFeesItems() {
        return this.feesItems;
    }

    public void setFeesItems(Set<FeesItem> feesItems) {
        this.feesItems = feesItems;
    }
}
