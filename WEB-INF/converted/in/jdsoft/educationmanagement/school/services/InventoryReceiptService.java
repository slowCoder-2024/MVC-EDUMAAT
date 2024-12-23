/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryReceiptService {
    public static final Logger log = LogManager.getLogger((String)InventoryReceiptService.class.getName());

    public List<InventoryReceipt> inventoryReceiptList();

    public InventoryReceipt inventoryReceiptById(Long var1);

    public void createInventoryReceiptByCash(InventoryReceipt var1, Set<InventoryReceiptDetails> var2);

    public void createInventoryReceiptByCheque(InventoryReceipt var1, Set<InventoryReceiptDetails> var2);

    public void createInventoryReceiptByDD(InventoryReceipt var1, Set<InventoryReceiptDetails> var2);

    public void updateInventoryReceipt(InventoryReceipt var1);

    public void deleteInventoryReceipt(Long var1);
}
