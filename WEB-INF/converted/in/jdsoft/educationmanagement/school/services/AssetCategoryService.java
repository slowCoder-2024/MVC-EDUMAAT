/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.AssetCategory;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AssetCategoryService {
    public static final Logger log = LogManager.getLogger((String)AssetCategoryService.class.getName());

    public List<AssetCategory> assetCategoryList();

    public AssetCategory assetCategoryById(Long var1);

    public void createAssetCategory(AssetCategory var1);

    public void updateAssetCategory(AssetCategory var1);

    public void deleteAssetCategory(Long var1);
}
