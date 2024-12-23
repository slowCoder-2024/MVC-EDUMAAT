/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import in.jdsoft.educationmanagement.school.model.AssetRegister;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.ForeignKey;

@Entity
@DiscriminatorValue(value="assetregisterwithcomputer")
public class AssetRegisterWithComputer
extends AssetRegister {
    private static final long serialVersionUID = 1L;
    private AssetRegister assetRegister;

    AssetRegisterWithComputer() {
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="asset_register_id", nullable=true)
    @ForeignKey(name="assetRegisterWithComputerInAssetRegister")
    public AssetRegister getAssetRegister() {
        return this.assetRegister;
    }

    public void setAssetRegister(AssetRegister assetRegister) {
        this.assetRegister = assetRegister;
    }
}
