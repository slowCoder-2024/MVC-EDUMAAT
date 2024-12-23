/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AssetCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.AssetCategory;
import in.jdsoft.educationmanagement.school.services.AssetCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="assetCategoryService")
public class AssetCategoryServiceImpl
implements AssetCategoryService {
    @Autowired
    AssetCategoryDAO assetCategoryDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<AssetCategory> assetCategoryList() {
        try {
            List<AssetCategory> assetCategory = this.assetCategoryDAO.getList();
            Integer assetSize = assetCategory.size();
            if (assetSize > 0) {
                log.info((Object)(assetSize + " AssetCategory records where reterived"));
            } else {
                log.info((Object)"No AssetCategory available");
            }
            return assetCategory;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving AssetCategory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AssetCategory assetCategoryById(Long assetCategoryId) {
        try {
            AssetCategory assetCategory = this.assetCategoryDAO.getAssetCategoryById(assetCategoryId);
            if (assetCategoryId != null) {
                log.info((Object)("AssetCategory with id=" + assetCategoryId + " has been reterived"));
                return assetCategory;
            }
            log.info((Object)("No AssetCategory with  id=" + assetCategoryId + " is available"));
            return assetCategory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving AssetCategory by id=" + assetCategoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createAssetCategory(AssetCategory assetCategory) {
        try {
            this.assetCategoryDAO.save(assetCategory);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating AssetCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateAssetCategory(AssetCategory assetCategory) {
        try {
            this.assetCategoryDAO.saveOrUpdate(assetCategory);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating AssetCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAssetCategory(Long assetCategoryId) {
        try {
            this.assetCategoryDAO.delete(this.assetCategoryDAO.getAssetCategoryById(assetCategoryId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting AssetCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
