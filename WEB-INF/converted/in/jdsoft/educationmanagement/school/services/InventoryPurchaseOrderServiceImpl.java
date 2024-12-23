/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InventoryPurchaseOrderDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryPurchaseOrderDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import in.jdsoft.educationmanagement.school.services.InventoryPurchaseOrderService;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryPurchaseOrderService")
public class InventoryPurchaseOrderServiceImpl
implements InventoryPurchaseOrderService {
    @Autowired
    InventoryPurchaseOrderDAO inventoryPurchaseOrderDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InventoryPurchaseOrderDetailsDAO inventoryPurchaseOrderDetailsDAO;

    @Override
    public List<InventoryPurchaseOrder> inventoryPurchaseOrderList() {
        try {
            List<InventoryPurchaseOrder> inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getList();
            Integer inventorySize = inventoryPurchaseOrder.size();
            if (inventorySize > 0) {
                for (InventoryPurchaseOrder inventoryPurchaseOrders : inventoryPurchaseOrder) {
                    Hibernate.initialize((Object)inventoryPurchaseOrders.getAcademicYear());
                    Hibernate.initialize((Object)inventoryPurchaseOrders.getSupplierMaster());
                }
                log.info((Object)(inventorySize + " InventoryPurchaseOrder records where reterived"));
            } else {
                log.info((Object)"No InventoryPurchaseOrder available");
            }
            return inventoryPurchaseOrder;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryPurchaseOrder list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryPurchaseOrder inventoryPurchaseOrderById(Long inventoryPurchaseOrderId) {
        try {
            InventoryPurchaseOrder inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(inventoryPurchaseOrderId);
            Hibernate.initialize(inventoryPurchaseOrder.getInventoryPurchaseOrderDetails());
            if (inventoryPurchaseOrderId != null) {
                log.info((Object)("InventoryPurchaseOrder with id=" + inventoryPurchaseOrderId + " has been reterived"));
                return inventoryPurchaseOrder;
            }
            log.info((Object)("No InventoryPurchaseOrder with  id=" + inventoryPurchaseOrderId + " is available"));
            return inventoryPurchaseOrder;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryPurchaseOrder by id=" + inventoryPurchaseOrderId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryPurchaseOrder(InventoryPurchaseOrder inventoryPurchaseOrder, Set<InventoryPurchaseOrderDetails> inventoryPurchaseOrderDetails) {
        try {
            InventoryPurchaseOrder persistedInventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.save(inventoryPurchaseOrder);
            String purchaseOrderNo = persistedInventoryPurchaseOrder.getPurchaseOrderId().toString();
            persistedInventoryPurchaseOrder.setPurchaseOrderNo(purchaseOrderNo);
            this.inventoryPurchaseOrderDAO.update(persistedInventoryPurchaseOrder);
            for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : inventoryPurchaseOrderDetails) {
                inventoryPurchaseOrderDetail.setInventoryPurchaseOrder(persistedInventoryPurchaseOrder);
                this.inventoryPurchaseOrderDetailsDAO.persist(inventoryPurchaseOrderDetail);
            }
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryPurchaseOrder " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryPurchaseOrder(InventoryPurchaseOrder inventoryPurchaseOrder) {
        try {
            this.inventoryPurchaseOrderDAO.saveOrUpdate(inventoryPurchaseOrder);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryPurchaseOrder " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryPurchaseOrder(Long inventoryPurchaseOrderId) {
        try {
            this.inventoryPurchaseOrderDAO.delete(this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(inventoryPurchaseOrderId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryPurchaseOrder " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryPurchaseOrder inventoryPurchaseOrderEager(Long purchaseOrderId) {
        try {
            InventoryPurchaseOrder inventoryPurchaseOrders = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderByInventoryPurchaseOrder(purchaseOrderId);
            Hibernate.initialize(inventoryPurchaseOrders.getInventoryPurchaseOrderDetails());
            for (InventoryPurchaseOrderDetails inventoryPurchaseOrderss : inventoryPurchaseOrders.getInventoryPurchaseOrderDetails()) {
                Hibernate.initialize((Object)inventoryPurchaseOrderss.getInventoryItemMaster());
            }
            return inventoryPurchaseOrders;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
