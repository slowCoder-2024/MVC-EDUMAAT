/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="tbl_asset_class", uniqueConstraints={@UniqueConstraint(columnNames={"asset_class"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class AssetClass
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long assetClassId;
    private String assetClass;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="asset_class_id", unique=true, nullable=false)
    public Long getAssetClassId() {
        return this.assetClassId;
    }

    public void setAssetClassId(Long assetClassId) {
        this.assetClassId = assetClassId;
    }

    @Column(name="asset_class", nullable=false, length=100)
    public String getAssetClass() {
        return this.assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }
}
