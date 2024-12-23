/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryItemMasterService {
    public static final Logger log = LogManager.getLogger((String)InventoryItemMasterService.class.getName());

    public List<InventoryItemMaster> inventoryItemMasterList();

    public InventoryItemMaster inventoryItemMasterById(Long var1);

    public void createInventoryItemMaster(InventoryItemMaster var1) throws Exception;

    public void updateInventoryItemMaster(InventoryItemMaster var1);

    public void deleteInventoryItemMaster(Long var1);

    public List<InventoryItemMaster> getAssetListsFromInventoryItemMaster();
}
