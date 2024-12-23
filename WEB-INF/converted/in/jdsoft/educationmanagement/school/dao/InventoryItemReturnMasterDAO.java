/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Conjunction
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryItemReturnMasterDAO
extends GenericDAO<InventoryItemReturnMaster> {
    public InventoryItemReturnMasterDAO() {
        super(InventoryItemReturnMaster.class);
    }

    public InventoryItemReturnMaster getInventoryItemIssueAndReturnMasterById(Long id) {
        InventoryItemReturnMaster instance = (InventoryItemReturnMaster)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster", (Serializable)id);
        return instance;
    }

    public List<InventoryItemReturnMaster> getInventoryItemReturnByInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryItemReturnMaster.class).createAlias("inventoryItemIssueMaster", "inventoryItemIssueMaster");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"inventoryItemIssueMaster.inventoryItemMaster", (Object)inventoryItemMaster));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }
}
