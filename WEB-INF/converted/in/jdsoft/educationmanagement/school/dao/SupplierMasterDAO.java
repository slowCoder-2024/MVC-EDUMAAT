/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierMasterDAO
extends GenericDAO<SupplierMaster> {
    public SupplierMasterDAO() {
        super(SupplierMaster.class);
    }

    public SupplierMaster getSupplierMasterById(Long id) {
        SupplierMaster instance = (SupplierMaster)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.SupplierMaster", (Serializable)id);
        return instance;
    }
}
