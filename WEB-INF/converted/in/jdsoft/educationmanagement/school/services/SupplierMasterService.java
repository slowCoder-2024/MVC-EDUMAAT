/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SupplierMasterService {
    public static final Logger log = LogManager.getLogger((String)SupplierMasterService.class.getName());

    public List<SupplierMaster> supplierMasterList();

    public SupplierMaster supplierMasterById(Long var1);

    public void createSupplierMaster(SupplierMaster var1);

    public void updateSupplierMaster(SupplierMaster var1);

    public void deleteSupplierMaster(Long var1);
}
