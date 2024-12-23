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
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryRequisitionService {
    public static final Logger log = LogManager.getLogger((String)InventoryRequisitionService.class.getName());

    public Long createInventoryRequisition(InventoryRequisition var1, PortalTask var2);

    public void deleteInventoryRequisition(Long var1);

    public List<InventoryRequisition> inventoryRequisitionList();

    public List<InventoryRequisition> pendingInventoryRequisitionListByRequesterEmail(String var1);

    public List<InventoryRequisition> pendingInventoryRequisitionListByApproverEmail(String var1);

    public InventoryRequisition inventoryRequisitionById(Long var1);

    public InventoryRequisition inventoryRequisitionByIdEager(Long var1);

    public void updateInventoryRequisition(InventoryRequisition var1, PortalTask var2);

    public void cancelInventoryRequisition(InventoryRequisition var1);

    public List<InventoryRequisition> approvedAndRejectedInventoryRequisitionListByRequesterEmail(String var1);

    public List<User> inventoryRequisitionApprovedUserList();

    public List<InventoryItemMaster> inventoryRequisitionApprovedInventoryItemMasterList();
}
