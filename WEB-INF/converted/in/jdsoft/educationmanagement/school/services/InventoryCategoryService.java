/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryCategory;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryCategoryService {
    public static final Logger log = LogManager.getLogger((String)InventoryCategoryService.class.getName());

    public List<InventoryCategory> inventoryCategoryList();

    public InventoryCategory inventoryCategoryById(Long var1);

    public void createInventoryCategory(InventoryCategory var1);

    public void updateInventoryCategory(InventoryCategory var1);

    public void deleteInventoryCategory(Long var1);
}
