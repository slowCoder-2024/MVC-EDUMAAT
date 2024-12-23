/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  javax.persistence.DiscriminatorValue
 *  javax.persistence.Entity
 */
package in.jdsoft.educationmanagement.school.model;

import in.jdsoft.educationmanagement.school.model.AssetRegister;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="assetregisterwithsoftware")
public class AssetRegisterWithSoftware
extends AssetRegister {
    private static final long serialVersionUID = 1L;
    @Column(name="licenses_for_number_of_installations", nullable=true, length=100)
    private Integer licensesForNumberOfInstallations;

    AssetRegisterWithSoftware() {
    }
}
