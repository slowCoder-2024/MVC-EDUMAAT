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
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryItemIssueMasterDAO
extends GenericDAO<InventoryItemIssueMaster> {
    public InventoryItemIssueMasterDAO() {
        super(InventoryItemIssueMaster.class);
    }

    public InventoryItemIssueMaster getInventoryItemIssueAndReturnMasterById(Long id) {
        InventoryItemIssueMaster instance = (InventoryItemIssueMaster)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster", (Serializable)id);
        return instance;
    }

    public List<InventoryItemIssueMaster> getInventoryItemIssueByInventoryItemMaster(InventoryItemMaster inventoryItemMaster) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(InventoryItemIssueMaster.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"inventoryItemMaster", (Object)inventoryItemMaster));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }
}
