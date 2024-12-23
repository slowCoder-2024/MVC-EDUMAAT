/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AssetTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.AssetType;
import in.jdsoft.educationmanagement.school.services.AssetTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="assetTypeService")
public class AssetTypeServiceImpl
implements AssetTypeService {
    @Autowired
    AssetTypeDAO assetTypeDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<AssetType> assetTypeList() {
        try {
            List<AssetType> assetType = this.assetTypeDAO.getList();
            Integer assetSize = assetType.size();
            if (assetSize > 0) {
                log.info((Object)(assetSize + " AssetType records where reterived"));
            } else {
                log.info((Object)"No AssetType available");
            }
            return assetType;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving AssetType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AssetType assetTypeById(Long assetTypeId) {
        try {
            AssetType assetType = this.assetTypeDAO.getAssetTypeById(assetTypeId);
            if (assetTypeId != null) {
                log.info((Object)("AssetType with id=" + assetTypeId + " has been reterived"));
                return assetType;
            }
            log.info((Object)("No AssetType with  id=" + assetTypeId + " is available"));
            return assetType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving AssetType by id=" + assetTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createAssetType(AssetType assetType) {
        try {
            this.assetTypeDAO.save(assetType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating AssetType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateAssetType(AssetType assetType) {
        try {
            this.assetTypeDAO.saveOrUpdate(assetType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating AssetType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAssetType(Long assetTypeId) {
        try {
            this.assetTypeDAO.delete(this.assetTypeDAO.getAssetTypeById(assetTypeId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting AssetType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
