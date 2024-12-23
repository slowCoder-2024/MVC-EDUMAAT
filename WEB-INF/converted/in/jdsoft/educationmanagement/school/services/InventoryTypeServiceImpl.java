/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InventoryTypeDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.InventoryType;
import in.jdsoft.educationmanagement.school.services.InventoryTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryTypeService")
public class InventoryTypeServiceImpl
implements InventoryTypeService {
    @Autowired
    InventoryTypeDAO inventoryTypeDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<InventoryType> inventoryTypeList() {
        try {
            List<InventoryType> inventoryType = this.inventoryTypeDAO.getList();
            Integer inventorySize = inventoryType.size();
            if (inventorySize > 0) {
                log.info((Object)(inventorySize + " InventoryType records where reterived"));
            } else {
                log.info((Object)"No InventoryType available");
            }
            return inventoryType;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryType inventoryTypeById(Long inventoryTypeId) {
        try {
            InventoryType inventoryType = this.inventoryTypeDAO.getInventoryTypeById(inventoryTypeId);
            if (inventoryTypeId != null) {
                log.info((Object)("InventoryType with id=" + inventoryTypeId + " has been reterived"));
                return inventoryType;
            }
            log.info((Object)("No InventoryType with  id=" + inventoryTypeId + " is available"));
            return inventoryType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryType by id=" + inventoryTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryType(InventoryType inventoryType) {
        try {
            this.inventoryTypeDAO.save(inventoryType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryType(InventoryType inventoryType) {
        try {
            this.inventoryTypeDAO.saveOrUpdate(inventoryType);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryType(Long inventoryTypeId) {
        try {
            this.inventoryTypeDAO.delete(this.inventoryTypeDAO.getInventoryTypeById(inventoryTypeId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryType " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
