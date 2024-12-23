/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface InventoryItemIssueAndReturnMasterService {
    public static final Logger log = LogManager.getLogger((String)InventoryItemIssueAndReturnMasterService.class.getName());

    public List<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasterList();

    public InventoryItemIssueMaster inventoryItemIssueAndReturnMasterById(Long var1);

    public void createInventoryItemIssueAndReturnMaster(InventoryItemIssueMaster var1, InventoryItemMaster var2) throws Exception;

    public void updateInventoryItemReturnMaster(InventoryItemReturnMaster var1, InventoryItemMaster var2);

    public void deleteInventoryItemIssueAndReturnMaster(Long var1);

    public List<InventoryItemReturnMaster> inventoryItemReturnMasterList();

    public List<InventoryItemReturnMaster> inventoryItemReturnMasterByInventoryItemIssueMasterId(Long var1);

    public List<TwoFieldReport> inventoryItemIssuedReport();

    public List<TwoFieldReport> inventoryItemReturnedReport();

    public List<TwoFieldReport> inventoryItemReport();

    public String inventoryItemPercentage();

    public String inventoryItemIssuedPercentage();

    public String inventoryItemReturnPercentage();
}
