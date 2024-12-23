/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PurchaseRequisitionService {
    public static final Logger log = LogManager.getLogger((String)PurchaseRequisitionService.class.getName());

    public Long createPurchaseRequisition(PurchaseRequisition var1, PortalTask var2);

    public void deletePurchaseRequisition(Long var1);

    public List<PurchaseRequisition> purchaseRequisitionList();

    public List<PurchaseRequisition> pendingPurchaseRequisitionListByRequesterEmail(String var1);

    public List<PurchaseRequisition> pendingPurchaseRequisitionListByApproverEmail(String var1);

    public PurchaseRequisition purchaseRequisitionById(Long var1);

    public PurchaseRequisition purchaseRequisitionByIdEager(Long var1);

    public void updatePurchaseRequisition(PurchaseRequisition var1, PortalTask var2);

    public void cancelPurchaseRequisition(PurchaseRequisition var1);

    public List<PurchaseRequisition> approvedAndRejectedPurchaseRequisitionListByRequesterEmail(String var1);
}
