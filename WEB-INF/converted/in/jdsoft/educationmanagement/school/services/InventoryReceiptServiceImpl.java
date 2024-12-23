/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InventoryItemMasterDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryPurchaseOrderDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryPurchaseOrderDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryReceiptDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryReceiptDetailsDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrder;
import in.jdsoft.educationmanagement.school.model.InventoryPurchaseOrderDetails;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import in.jdsoft.educationmanagement.school.services.InventoryReceiptService;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryReceiptService")
public class InventoryReceiptServiceImpl
implements InventoryReceiptService {
    @Autowired
    InventoryReceiptDAO inventoryReceiptDAO;
    @Autowired
    InventoryReceiptDetailsDAO inventoryReceiptDetailsDAO;
    @Autowired
    InventoryItemMasterDAO inventoryItemMasterDAO;
    @Autowired
    InventoryPurchaseOrderDAO inventoryPurchaseOrderDAO;
    @Autowired
    InventoryPurchaseOrderDetailsDAO inventoryPurchaseOrderDetailsDAO;

    @Override
    public List<InventoryReceipt> inventoryReceiptList() {
        try {
            List<InventoryReceipt> inventoryReceipts = this.inventoryReceiptDAO.getList();
            Integer inventorySize = inventoryReceipts.size();
            if (inventorySize > 0) {
                for (InventoryReceipt inventoryReceipt : inventoryReceipts) {
                    Hibernate.initialize((Object)inventoryReceipt.getAcademicYear());
                    Hibernate.initialize((Object)inventoryReceipt.getInventoryReceiptGenerateDate());
                    Hibernate.initialize((Object)inventoryReceipt.getAmount());
                    Hibernate.initialize((Object)inventoryReceipt.getInvoiceNumber());
                    Hibernate.initialize((Object)inventoryReceipt.getPaymentMode());
                    Hibernate.initialize((Object)inventoryReceipt.getSupplierMaster());
                    Hibernate.initialize((Object)inventoryReceipt.getInvoiceNumber());
                    Hibernate.initialize((Object)inventoryReceipt.getReceiptNumber());
                    Hibernate.initialize((Object)inventoryReceipt.getQuantity());
                }
                log.info((Object)(inventorySize + " InventoryReceipt records where reterived"));
            } else {
                log.info((Object)"No InventoryReceipt available");
            }
            return inventoryReceipts;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryReceipt list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryReceipt inventoryReceiptById(Long inventoryReceiptId) {
        try {
            InventoryReceipt inventoryReceipt = this.inventoryReceiptDAO.getInventoryReceiptById(inventoryReceiptId);
            if (inventoryReceiptId != null) {
                log.info((Object)("InventoryReceipt with id=" + inventoryReceiptId + " has been reterived"));
                return inventoryReceipt;
            }
            log.info((Object)("No InventoryReceipt with  id=" + inventoryReceiptId + " is available"));
            return inventoryReceipt;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryReceipt by id=" + inventoryReceiptId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryReceiptByCash(InventoryReceipt inventoryReceipt, Set<InventoryReceiptDetails> inventoryReceiptDetails) {
        try {
            inventoryReceipt.setSupplierMaster(inventoryReceipt.getInventoryPurchaseOrder().getSupplierMaster());
            inventoryReceipt.setQuantity(inventoryReceipt.getInventoryPurchaseOrder().getTotalQuantity());
            InventoryReceipt persistedInventoryReceipt = this.inventoryReceiptDAO.save(inventoryReceipt);
            for (InventoryReceiptDetails inventoryReceiptDetail : inventoryReceiptDetails) {
                inventoryReceiptDetail.setInventoryReceipt(persistedInventoryReceipt);
                InventoryReceiptDetails persistedInventoryReceiptDetails = this.inventoryReceiptDetailsDAO.save(inventoryReceiptDetail);
                for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : persistedInventoryReceipt.getInventoryPurchaseOrder().getInventoryPurchaseOrderDetails()) {
                    InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryPurchaseOrderDetail.getInventoryItemMaster().getItemId());
                    if (inventoryItemMaster.getItemId().equals(persistedInventoryReceiptDetails.getInventoryItemMaster().getItemId())) {
                        inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setTaxClass(persistedInventoryReceipt.getTaxClass());
                        inventoryItemMaster.setPricePerUnit(inventoryReceiptDetail.getItemamount());
                        inventoryItemMaster.setQuantity(inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setUnitOfMeasure(inventoryReceiptDetail.getUnitOfMeasure());
                    }
                    this.inventoryItemMasterDAO.update(inventoryItemMaster);
                }
            }
            InventoryPurchaseOrder inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(persistedInventoryReceipt.getInventoryPurchaseOrder().getPurchaseOrderId());
            inventoryPurchaseOrder.setPurchased(true);
            this.inventoryPurchaseOrderDAO.update(inventoryPurchaseOrder);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryReceipt " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryReceipt(InventoryReceipt inventoryReceipt) {
        try {
            this.inventoryReceiptDAO.saveOrUpdate(inventoryReceipt);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryReceipt " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryReceipt(Long inventoryReceiptId) {
        try {
            InventoryReceipt inventoryReceipt = this.inventoryReceiptDAO.getInventoryReceiptById(inventoryReceiptId);
            Long inventoryPurchaseId = inventoryReceipt.getInventoryPurchaseOrder().getPurchaseOrderId();
            this.inventoryReceiptDAO.delete(this.inventoryReceiptDAO.getInventoryReceiptById(inventoryReceiptId));
            InventoryPurchaseOrder inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(inventoryPurchaseId);
            for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : inventoryPurchaseOrder.getInventoryPurchaseOrderDetails()) {
                inventoryPurchaseOrderDetail.getInventoryItemMaster().setQuantity(null);
                inventoryPurchaseOrderDetail.getInventoryItemMaster().setPricePerUnit(0.0);
                inventoryPurchaseOrderDetail.getInventoryItemMaster().setUnitOfMeasure(null);
                inventoryPurchaseOrderDetail.getInventoryItemMaster().setTaxClass(null);
            }
            inventoryPurchaseOrder.setPurchased(false);
            this.inventoryPurchaseOrderDAO.update(inventoryPurchaseOrder);
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryReceipt " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryReceiptByCheque(InventoryReceipt inventoryReceipt, Set<InventoryReceiptDetails> inventoryReceiptDetails) {
        try {
            inventoryReceipt.setSupplierMaster(inventoryReceipt.getInventoryPurchaseOrder().getSupplierMaster());
            inventoryReceipt.setQuantity(inventoryReceipt.getInventoryPurchaseOrder().getTotalQuantity());
            InventoryReceipt persistedInventoryReceipt = this.inventoryReceiptDAO.save(inventoryReceipt);
            for (InventoryReceiptDetails inventoryReceiptDetail : inventoryReceiptDetails) {
                inventoryReceiptDetail.setInventoryReceipt(persistedInventoryReceipt);
                InventoryReceiptDetails persistedInventoryReceiptDetails = this.inventoryReceiptDetailsDAO.save(inventoryReceiptDetail);
                for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : persistedInventoryReceipt.getInventoryPurchaseOrder().getInventoryPurchaseOrderDetails()) {
                    InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryPurchaseOrderDetail.getInventoryItemMaster().getItemId());
                    if (inventoryItemMaster.getItemId().equals(persistedInventoryReceiptDetails.getInventoryItemMaster().getItemId())) {
                        inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setTaxClass(persistedInventoryReceipt.getTaxClass());
                        inventoryItemMaster.setPricePerUnit(inventoryReceiptDetail.getItemamount());
                        inventoryItemMaster.setQuantity(inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setUnitOfMeasure(inventoryReceiptDetail.getUnitOfMeasure());
                    }
                    this.inventoryItemMasterDAO.update(inventoryItemMaster);
                }
            }
            InventoryPurchaseOrder inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(persistedInventoryReceipt.getInventoryPurchaseOrder().getPurchaseOrderId());
            inventoryPurchaseOrder.setPurchased(true);
            this.inventoryPurchaseOrderDAO.update(inventoryPurchaseOrder);
            for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : persistedInventoryReceipt.getInventoryPurchaseOrder().getInventoryPurchaseOrderDetails()) {
                InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryPurchaseOrderDetail.getInventoryItemMaster().getItemId());
                inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryReceipt.getInventoryPurchaseOrder().getTotalQuantity());
                this.inventoryItemMasterDAO.update(inventoryItemMaster);
            }
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryReceipt " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryReceiptByDD(InventoryReceipt inventoryReceipt, Set<InventoryReceiptDetails> inventoryReceiptDetails) {
        try {
            inventoryReceipt.setSupplierMaster(inventoryReceipt.getInventoryPurchaseOrder().getSupplierMaster());
            inventoryReceipt.setQuantity(inventoryReceipt.getInventoryPurchaseOrder().getTotalQuantity());
            InventoryReceipt persistedInventoryReceipt = this.inventoryReceiptDAO.save(inventoryReceipt);
            for (InventoryReceiptDetails inventoryReceiptDetail : inventoryReceiptDetails) {
                inventoryReceiptDetail.setInventoryReceipt(persistedInventoryReceipt);
                InventoryReceiptDetails persistedInventoryReceiptDetails = this.inventoryReceiptDetailsDAO.save(inventoryReceiptDetail);
                for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : persistedInventoryReceipt.getInventoryPurchaseOrder().getInventoryPurchaseOrderDetails()) {
                    InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryPurchaseOrderDetail.getInventoryItemMaster().getItemId());
                    if (inventoryItemMaster.getItemId().equals(persistedInventoryReceiptDetails.getInventoryItemMaster().getItemId())) {
                        inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setTaxClass(persistedInventoryReceipt.getTaxClass());
                        inventoryItemMaster.setPricePerUnit(inventoryReceiptDetail.getItemamount());
                        inventoryItemMaster.setQuantity(inventoryReceiptDetail.getQuantity());
                        inventoryItemMaster.setUnitOfMeasure(inventoryReceiptDetail.getUnitOfMeasure());
                    }
                    this.inventoryItemMasterDAO.update(inventoryItemMaster);
                }
            }
            InventoryPurchaseOrder inventoryPurchaseOrder = this.inventoryPurchaseOrderDAO.getInventoryPurchaseOrderById(persistedInventoryReceipt.getInventoryPurchaseOrder().getPurchaseOrderId());
            inventoryPurchaseOrder.setPurchased(true);
            this.inventoryPurchaseOrderDAO.update(inventoryPurchaseOrder);
            for (InventoryPurchaseOrderDetails inventoryPurchaseOrderDetail : persistedInventoryReceipt.getInventoryPurchaseOrder().getInventoryPurchaseOrderDetails()) {
                InventoryItemMaster inventoryItemMaster = this.inventoryItemMasterDAO.getInventoryItemMasterById(inventoryPurchaseOrderDetail.getInventoryItemMaster().getItemId());
                inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryReceipt.getInventoryPurchaseOrder().getTotalQuantity());
                this.inventoryItemMasterDAO.update(inventoryItemMaster);
            }
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryReceipt " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
