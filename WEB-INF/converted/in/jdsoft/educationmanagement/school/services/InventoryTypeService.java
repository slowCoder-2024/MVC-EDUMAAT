/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryTypeService {
    public static final Logger log = LogManager.getLogger((String)InventoryTypeService.class.getName());

    public List<InventoryType> inventoryTypeList();

    public InventoryType inventoryTypeById(Long var1);

    public void createInventoryType(InventoryType var1);

    public void updateInventoryType(InventoryType var1);

    public void deleteInventoryType(Long var1);
}
