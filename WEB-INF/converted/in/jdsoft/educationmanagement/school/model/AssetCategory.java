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
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@Table(name="tbl_asset_category", uniqueConstraints={@UniqueConstraint(columnNames={"asset_category_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AssetCategory
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long assetCategoryId;
    private String assetCategoryName;
    private Set<AssetCategory> assetCategory = new LinkedHashSet<AssetCategory>();

    public AssetCategory(String assetCategoryName) {
        this.assetCategoryName = assetCategoryName;
    }

    AssetCategory() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="asset_category_id", unique=true, nullable=false)
    public Long getAssetCategoryId() {
        return this.assetCategoryId;
    }

    public void setAssetCategoryId(Long assetCategoryId) {
        this.assetCategoryId = assetCategoryId;
    }

    @Column(name="asset_category_name", nullable=false, length=100)
    public String getAssetCategoryName() {
        return this.assetCategoryName;
    }

    public void setAssetCategoryName(String assetCategoryName) {
        this.assetCategoryName = assetCategoryName;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="assetCategory")
    public Set<AssetCategory> getAssetCategory() {
        return this.assetCategory;
    }

    public void setAssetCategory(Set<AssetCategory> assetCategory) {
        this.assetCategory = assetCategory;
    }
}
