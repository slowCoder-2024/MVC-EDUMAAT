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

@Entity
@Table(name="tbl_institution_config_details")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class InstitutionConfigDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long institutionConfigDetailsId;
    private boolean isMultiInstitutions;
    private Integer feeCollectionAdminType;
    private Integer inventoryAndAssetAdminType;
    private Integer visitorAdminType;
    private Integer libraryAdminType;

    public InstitutionConfigDetails(boolean isMultiInstitutions, Integer feeCollectionAdminType, Integer inventoryAndAssetAdminType, Integer visitorAdminType, Integer libraryAdminType) {
        this.isMultiInstitutions = isMultiInstitutions;
        this.feeCollectionAdminType = feeCollectionAdminType;
        this.inventoryAndAssetAdminType = inventoryAndAssetAdminType;
        this.visitorAdminType = visitorAdminType;
        this.libraryAdminType = libraryAdminType;
    }

    public InstitutionConfigDetails() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="institution_config_details_id", nullable=false)
    public Long getInstitutionConfigDetailsId() {
        return this.institutionConfigDetailsId;
    }

    public void setInstitutionConfigDetailsId(Long institutionConfigDetailsId) {
        this.institutionConfigDetailsId = institutionConfigDetailsId;
    }

    @Column(name="is_multi_institutions", nullable=false, length=50)
    public boolean isMultiInstitutions() {
        return this.isMultiInstitutions;
    }

    public void setMultiInstitutions(boolean isMultiInstitutions) {
        this.isMultiInstitutions = isMultiInstitutions;
    }

    @Column(name="fee_coll_admin_type", nullable=false, length=50)
    public Integer getFeeCollectionAdminType() {
        return this.feeCollectionAdminType;
    }

    public void setFeeCollectionAdminType(Integer feeCollectionAdminType) {
        this.feeCollectionAdminType = feeCollectionAdminType;
    }

    @Column(name="invent_asset_admin_type", nullable=false, length=50)
    public Integer getInventoryAndAssetAdminType() {
        return this.inventoryAndAssetAdminType;
    }

    public void setInventoryAndAssetAdminType(Integer inventoryAndAssetAdminType) {
        this.inventoryAndAssetAdminType = inventoryAndAssetAdminType;
    }

    @Column(name="visitor_admin_type", nullable=false, length=50)
    public Integer getVisitorAdminType() {
        return this.visitorAdminType;
    }

    public void setVisitorAdminType(Integer visitorAdminType) {
        this.visitorAdminType = visitorAdminType;
    }

    @Column(name="library_admin_type", nullable=false, length=50)
    public Integer getLibraryAdminType() {
        return this.libraryAdminType;
    }

    public void setLibraryAdminType(Integer libraryAdminType) {
        this.libraryAdminType = libraryAdminType;
    }
}
