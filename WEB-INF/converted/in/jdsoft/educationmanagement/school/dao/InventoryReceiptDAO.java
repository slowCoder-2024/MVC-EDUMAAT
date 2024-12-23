/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InventoryReceipt;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryReceiptDAO
extends GenericDAO<InventoryReceipt> {
    public InventoryReceiptDAO() {
        super(InventoryReceipt.class);
    }

    public InventoryReceipt getInventoryReceiptById(Long id) {
        InventoryReceipt instance = (InventoryReceipt)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryReceipt", (Serializable)id);
        return instance;
    }
}
