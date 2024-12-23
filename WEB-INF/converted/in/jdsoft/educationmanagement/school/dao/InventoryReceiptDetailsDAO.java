/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryReceiptDetailsDAO
extends GenericDAO<InventoryReceiptDetails> {
    public InventoryReceiptDetailsDAO() {
        super(InventoryReceiptDetails.class);
    }

    public InventoryReceiptDetails getInventoryReceiptDetailsById(Long id) {
        InventoryReceiptDetails instance = (InventoryReceiptDetails)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryReceiptDetails", (Serializable)id);
        return instance;
    }
}
