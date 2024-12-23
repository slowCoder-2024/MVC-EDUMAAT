/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.AssetType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AssetTypeService {
    public static final Logger log = LogManager.getLogger((String)AssetTypeService.class.getName());

    public List<AssetType> assetTypeList();

    public AssetType assetTypeById(Long var1);

    public void createAssetType(AssetType var1);

    public void updateAssetType(AssetType var1);

    public void deleteAssetType(Long var1);
}
