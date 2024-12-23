/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InventoryCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.InventoryCategory;
import in.jdsoft.educationmanagement.school.services.InventoryCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryCategoryService")
public class InventoryCategoryServiceImpl
implements InventoryCategoryService {
    @Autowired
    InventoryCategoryDAO inventoryCategoryDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<InventoryCategory> inventoryCategoryList() {
        try {
            List<InventoryCategory> inventoryCategory = this.inventoryCategoryDAO.getList();
            Integer inventorySize = inventoryCategory.size();
            if (inventorySize > 0) {
                log.info((Object)(inventorySize + " InventoryCategory records where reterived"));
            } else {
                log.info((Object)"No InventoryCategory available");
            }
            return inventoryCategory;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryCategory list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryCategory inventoryCategoryById(Long inventoryCategoryId) {
        try {
            InventoryCategory inventoryCategory = this.inventoryCategoryDAO.getInventoryCategoryById(inventoryCategoryId);
            if (inventoryCategoryId != null) {
                log.info((Object)("InventoryCategory with id=" + inventoryCategoryId + " has been reterived"));
                return inventoryCategory;
            }
            log.info((Object)("No InventoryCategory with  id=" + inventoryCategoryId + " is available"));
            return inventoryCategory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryCategory by id=" + inventoryCategoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryCategory(InventoryCategory inventoryCategory) {
        try {
            this.inventoryCategoryDAO.save(inventoryCategory);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryCategory(InventoryCategory inventoryCategory) {
        try {
            this.inventoryCategoryDAO.saveOrUpdate(inventoryCategory);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryCategory(Long inventoryCategoryId) {
        try {
            this.inventoryCategoryDAO.delete(this.inventoryCategoryDAO.getInventoryCategoryById(inventoryCategoryId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryCategory " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
