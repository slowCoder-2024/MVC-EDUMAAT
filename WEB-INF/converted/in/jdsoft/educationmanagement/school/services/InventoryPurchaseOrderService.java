/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryPurchaseOrderService {
    public static final Logger log = LogManager.getLogger((String)InventoryPurchaseOrderService.class.getName());

    public List<InventoryPurchaseOrder> inventoryPurchaseOrderList();

    public InventoryPurchaseOrder inventoryPurchaseOrderById(Long var1);

    public void createInventoryPurchaseOrder(InventoryPurchaseOrder var1, Set<InventoryPurchaseOrderDetails> var2);

    public void updateInventoryPurchaseOrder(InventoryPurchaseOrder var1);

    public void deleteInventoryPurchaseOrder(Long var1);

    public InventoryPurchaseOrder inventoryPurchaseOrderEager(Long var1);
}
