/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.SupplierMasterDAO;
import in.jdsoft.educationmanagement.school.model.SupplierMaster;
import in.jdsoft.educationmanagement.school.services.SupplierMasterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="supplierMasterService")
public class SupplierMasterServiceImpl
implements SupplierMasterService {
    @Autowired
    SupplierMasterDAO supplierMasterDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public List<SupplierMaster> supplierMasterList() {
        try {
            List<SupplierMaster> supplierMaster = this.supplierMasterDAO.getList();
            Integer supplierMasterSize = supplierMaster.size();
            if (supplierMasterSize > 0) {
                log.info((Object)(supplierMasterSize + " SupplierMaster records where reterived"));
            } else {
                log.info((Object)"No SupplierMaster available");
            }
            return supplierMaster;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SupplierMaster list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SupplierMaster supplierMasterById(Long supplierMasterId) {
        try {
            SupplierMaster supplierMaster = this.supplierMasterDAO.getSupplierMasterById(supplierMasterId);
            if (supplierMasterId != null) {
                log.info((Object)("SupplierMaster with id=" + supplierMasterId + " has been reterived"));
                return supplierMaster;
            }
            log.info((Object)("No SupplierMaster with  id=" + supplierMasterId + " is available"));
            return supplierMaster;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving SupplierMaster by id=" + supplierMasterId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createSupplierMaster(SupplierMaster supplierMaster) {
        try {
            String supplierCode = "SUPLR" + System.currentTimeMillis();
            supplierMaster.setSupplierCode(supplierCode);
            this.supplierMasterDAO.save(supplierMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating SupplierMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSupplierMaster(SupplierMaster supplierMaster) {
        try {
            this.supplierMasterDAO.saveOrUpdate(supplierMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating SupplierMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteSupplierMaster(Long supplierMasterId) {
        try {
            this.supplierMasterDAO.delete(this.supplierMasterDAO.getSupplierMasterById(supplierMasterId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting SupplierMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }
}
