/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryItemMasterDAO
extends GenericDAO<InventoryItemMaster> {
    public InventoryItemMasterDAO() {
        super(InventoryItemMaster.class);
    }

    public InventoryItemMaster getInventoryItemMasterById(Long id) {
        InventoryItemMaster instance = (InventoryItemMaster)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryItemMaster", (Serializable)id);
        return instance;
    }

    public List<InventoryItemMaster> getAssetInventory(boolean isAsset) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryItemMaster.class);
        criteria.add((Criterion)Restrictions.eq((String)"assetItem", (Object)isAsset));
        List inventoryItemMasters = criteria.list();
        return inventoryItemMasters;
    }
}
