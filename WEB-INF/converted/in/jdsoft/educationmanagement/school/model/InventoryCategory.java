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
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
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

@Entity
@Table(name="tbl_inventory_category", uniqueConstraints={@UniqueConstraint(columnNames={"inventory_category_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InventoryCategory
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long inventoryCategoryId;
    private String inventoryCategoryName;
    private Set<InventoryItemMaster> inventoryItemMasters = new LinkedHashSet<InventoryItemMaster>();

    public InventoryCategory(String inventoryCategoryName) {
        this.inventoryCategoryName = inventoryCategoryName;
    }

    InventoryCategory() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="inventory_category_id", unique=true, nullable=false)
    public Long getInventoryCategoryId() {
        return this.inventoryCategoryId;
    }

    public void setInventoryCategoryId(Long inventoryCategoryId) {
        this.inventoryCategoryId = inventoryCategoryId;
    }

    @Column(name="inventory_category_name", nullable=false, length=50)
    public String getInventoryCategoryName() {
        return this.inventoryCategoryName;
    }

    public void setInventoryCategoryName(String inventoryCategoryName) {
        this.inventoryCategoryName = inventoryCategoryName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="inventoryCategory")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@inventoryCategory")
    @JsonIdentityReference(alwaysAsId=true)
    public Set<InventoryItemMaster> getInventoryItemMasters() {
        return this.inventoryItemMasters;
    }

    public void setInventoryItemMasters(Set<InventoryItemMaster> inventoryItemMasters) {
        this.inventoryItemMasters = inventoryItemMasters;
    }
}
