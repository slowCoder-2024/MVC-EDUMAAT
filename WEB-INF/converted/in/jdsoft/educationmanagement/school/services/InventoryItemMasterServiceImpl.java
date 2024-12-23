/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.zxing.BarcodeFormat
 *  com.google.zxing.client.j2se.MatrixToImageWriter
 *  com.google.zxing.common.BitMatrix
 *  com.google.zxing.oned.Code128Writer
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import in.jdsoft.educationmanagement.school.components.FileUploadHandler;
import in.jdsoft.educationmanagement.school.dao.InventoryItemMasterDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.services.InventoryItemMasterService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryItemMasterService")
public class InventoryItemMasterServiceImpl
implements InventoryItemMasterService {
    @Autowired
    InventoryItemMasterDAO inventoryItemMasterDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    FileUploadHandler fileUploadHandler;

    @Override
    public List<InventoryItemMaster> inventoryItemMasterList() {
        try {
            List<InventoryItemMaster> inventoryItemMaster = this.inventoryItemMasterDAO.getList();
            Integer inventorySize = inventoryItemMaster.size();
            if (inventorySize > 0) {
                for (InventoryItemMaster inventoryItemMasters : inventoryItemMaster) {
                    Hibernate.initialize((Object)inventoryItemMasters.getInventoryType());
                    Hibernate.initialize((Object)inventoryItemMasters.getInventoryCategory());
                    Hibernate.initialize((Object)inventoryItemMasters.getTaxClass());
                }
                log.info((Object)(inventorySize + " InventoryItemMaster records where reterived"));
            } else {
                log.info((Object)"No InventoryItemMaster available");
            }
            return inventoryItemMaster;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryItemMaster list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryItemMaster inventoryItemMasterById(Long inventoryItemMasterId) {
        try {
            InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryItemMasterId);
            if (inventoryItemMasterId != null) {
                Hibernate.initialize((Object)inventoryItemMaster.getInventoryType());
                Hibernate.initialize((Object)inventoryItemMaster.getInventoryCategory());
                Hibernate.initialize((Object)inventoryItemMaster.getTaxClass());
                Hibernate.initialize((Object)inventoryItemMaster.getInCharge());
                log.info((Object)("InventoryItemMaster with id=" + inventoryItemMasterId + " has been reterived"));
                return inventoryItemMaster;
            }
            log.info((Object)("No InventoryItemMaster with  id=" + inventoryItemMasterId + " is available"));
            return inventoryItemMaster;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryItemMaster by id=" + inventoryItemMasterId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryItemMaster(InventoryItemMaster inventoryItemMaster) throws Exception {
        try {
            inventoryItemMaster.setTotalQuantityInStock(0.0);
            String itemCode = "ITEM" + Long.toString(System.currentTimeMillis());
            String millisecond = Long.toString(System.currentTimeMillis());
            String code = "ITEM" + millisecond;
            String[] args = inventoryItemMaster.getItemBarImage().split("@");
            String location = args[0];
            String path = args[1];
            location = String.valueOf(location) + path;
            this.fileUploadHandler.createFolderIfNotExist(location);
            String name = String.valueOf(inventoryItemMaster.getItemName()) + Long.toString(System.currentTimeMillis()) + ".jpg";
            try {
                BitMatrix bitMatrix = new Code128Writer().encode(code, BarcodeFormat.CODE_128, 150, 80, null);
                MatrixToImageWriter.writeToStream((BitMatrix)bitMatrix, (String)"jpg", (OutputStream)new FileOutputStream(new File(String.valueOf(location) + name)));
            }
            catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            inventoryItemMaster.setItemCode(itemCode);
            inventoryItemMaster.setItemBarCode(code);
            inventoryItemMaster.setItemBarImage(String.valueOf(path) + name);
            this.inventoryItemMasterDAO.save(inventoryItemMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryItemMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        try {
            this.inventoryItemMasterDAO.saveOrUpdate(inventoryItemMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryItemMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryItemMaster(Long inventoryItemMasterId) {
        try {
            this.inventoryItemMasterDAO.delete(this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryItemMasterId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryItemMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryItemMaster> getAssetListsFromInventoryItemMaster() {
        try {
            List<InventoryItemMaster> inventoryItemMasters = this.inventoryItemMasterDAO.getAssetInventory(true);
            Integer inventorySize = inventoryItemMasters.size();
            if (inventorySize > 0) {
                for (InventoryItemMaster inventoryItemMaster : inventoryItemMasters) {
                    Hibernate.initialize((Object)inventoryItemMaster.getItemId());
                    Hibernate.initialize((Object)inventoryItemMaster.getItemBarCode());
                    Hibernate.initialize((Object)inventoryItemMaster.getTotalQuantityInStock());
                    Hibernate.initialize((Object)inventoryItemMaster.getItemCode());
                    Hibernate.initialize((Object)inventoryItemMaster.getItemName());
                    Hibernate.initialize((Object)inventoryItemMaster.getInCharge());
                }
                log.info((Object)(inventorySize + " InventoryItemMaster records where reterived"));
            } else {
                log.info((Object)"No InventoryItemMaster available");
            }
            return inventoryItemMasters;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryItemMaster list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
