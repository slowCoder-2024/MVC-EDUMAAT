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
import in.jdsoft.educationmanagement.school.model.AssetRegister;
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
@Table(name="tbl_asset_type", uniqueConstraints={@UniqueConstraint(columnNames={"asset_type"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AssetType
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long assetTypeId;
    private String assetType;
    private Set<AssetRegister> assetRegisters = new LinkedHashSet<AssetRegister>();

    public AssetType(String assetType) {
        this.assetType = assetType;
    }

    public AssetType() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="asset_type_id", unique=true, nullable=false)
    public Long getAssetTypeId() {
        return this.assetTypeId;
    }

    public void setAssetTypeId(Long assetTypeId) {
        this.assetTypeId = assetTypeId;
    }

    @Column(name="asset_type", nullable=false, length=100)
    public String getAssetType() {
        return this.assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="assetType")
    public Set<AssetRegister> getAssetRegisters() {
        return this.assetRegisters;
    }

    public void setAssetRegisters(Set<AssetRegister> assetRegisters) {
        this.assetRegisters = assetRegisters;
    }
}
