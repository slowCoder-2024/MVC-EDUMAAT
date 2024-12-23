/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InventoryItemIssueMasterDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryItemMasterDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryItemReturnMasterDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemIssueMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryItemReturnMaster;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.InventoryItemIssueAndReturnMasterService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryItemIssueAndReturnMasterService")
public class InventoryItemIssueAndReturnMasterServiceImpl
implements InventoryItemIssueAndReturnMasterService {
    @Autowired
    InventoryItemIssueMasterDAO inventoryItemIssueMasterDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InventoryItemMasterDAO inventoryItemMasterDAO;
    @Autowired
    InventoryItemReturnMasterDAO inventoryItemReturnMasterDAO;

    @Override
    public List<InventoryItemIssueMaster> inventoryItemIssueAndReturnMasterList() {
        try {
            List<InventoryItemIssueMaster> inventoryItemIssueAndReturnMaster = this.inventoryItemIssueMasterDAO.getList();
            Integer inventorySize = inventoryItemIssueAndReturnMaster.size();
            if (inventorySize > 0) {
                for (InventoryItemIssueMaster inventoryItemIssueAndReturnMasters : inventoryItemIssueAndReturnMaster) {
                    Hibernate.initialize((Object)inventoryItemIssueAndReturnMasters.getAcademicYear());
                    Hibernate.initialize((Object)inventoryItemIssueAndReturnMasters.getInventoryItemMaster());
                    Hibernate.initialize((Object)inventoryItemIssueAndReturnMasters.getIssueToUser());
                    Hibernate.initialize((Object)inventoryItemIssueAndReturnMasters.getInCharge());
                    Hibernate.initialize(inventoryItemIssueAndReturnMasters.getInventoryItemReturnMaster());
                }
                log.info((Object)(inventorySize + " InventoryItemIssueAndReturnMaster records where reterived"));
            } else {
                log.info((Object)"No InventoryItemIssueAndReturnMaster available");
            }
            return inventoryItemIssueAndReturnMaster;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryItemIssueAndReturnMaster list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryItemIssueMaster inventoryItemIssueAndReturnMasterById(Long inventoryItemIssueAndReturnMasterId) {
        try {
            InventoryItemIssueMaster inventoryItemIssueAndReturnMaster = this.inventoryItemIssueMasterDAO.getInventoryItemIssueAndReturnMasterById(inventoryItemIssueAndReturnMasterId);
            if (inventoryItemIssueAndReturnMasterId != null) {
                Hibernate.initialize((Object)inventoryItemIssueAndReturnMaster.getAcademicYear());
                Hibernate.initialize((Object)inventoryItemIssueAndReturnMaster.getInventoryItemMaster());
                Hibernate.initialize((Object)inventoryItemIssueAndReturnMaster.getIssueToUser());
                Hibernate.initialize((Object)inventoryItemIssueAndReturnMaster.getInCharge());
                Hibernate.initialize(inventoryItemIssueAndReturnMaster.getInventoryItemReturnMaster());
                log.info((Object)("InventoryItemIssueAndReturnMaster with id=" + inventoryItemIssueAndReturnMasterId + " has been reterived"));
                return inventoryItemIssueAndReturnMaster;
            }
            log.info((Object)("No InventoryItemIssueAndReturnMaster with  id=" + inventoryItemIssueAndReturnMasterId + " is available"));
            return inventoryItemIssueAndReturnMaster;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryItemIssueAndReturnMaster by id=" + inventoryItemIssueAndReturnMasterId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createInventoryItemIssueAndReturnMaster(InventoryItemIssueMaster inventoryItemIssueAndReturnMaster, InventoryItemMaster inventoryItemMaster) throws Exception {
        try {
            this.inventoryItemIssueMasterDAO.save(inventoryItemIssueAndReturnMaster);
            this.inventoryItemMasterDAO.update(inventoryItemMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating InventoryItemIssueAndReturnMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryItemReturnMaster(InventoryItemReturnMaster inventoryItemReturnMaster, InventoryItemMaster inventoryItemMaster) {
        try {
            this.inventoryItemReturnMasterDAO.saveOrUpdate(inventoryItemReturnMaster);
            this.inventoryItemMasterDAO.update(inventoryItemMaster);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating InventoryItemIssueAndReturnMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryItemIssueAndReturnMaster(Long inventoryItemIssueAndReturnMasterId) {
        try {
            InventoryItemIssueMaster inventoryItemIssueMaster = this.inventoryItemIssueMasterDAO.getInventoryItemIssueAndReturnMasterById(inventoryItemIssueAndReturnMasterId);
            Hibernate.initialize((Object)inventoryItemIssueMaster.getInventoryItemMaster());
            InventoryItemMaster inventoryItemMaster = inventoryItemIssueMaster.getInventoryItemMaster();
            inventoryItemMaster.setTotalQuantityInStock(inventoryItemMaster.getTotalQuantityInStock() + inventoryItemIssueMaster.getNoOfQtyIssue());
            this.inventoryItemMasterDAO.update(inventoryItemMaster);
            this.inventoryItemIssueMasterDAO.delete(this.inventoryItemIssueMasterDAO.getInventoryItemIssueAndReturnMasterById(inventoryItemIssueAndReturnMasterId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting InventoryItemIssueAndReturnMaster " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryItemReturnMaster> inventoryItemReturnMasterList() {
        try {
            List<InventoryItemReturnMaster> inventoryItemReturnMasters = this.inventoryItemReturnMasterDAO.getList();
            Integer inventorySize = inventoryItemReturnMasters.size();
            if (inventorySize > 0) {
                for (InventoryItemReturnMaster inventoryItemReturnMaster : inventoryItemReturnMasters) {
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getReturnedBy());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getItemReturnedAcademicYear());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getInventoryItemIssueMaster());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getInventoryItemIssueMaster().getInventoryItemMaster());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getInventoryItemIssueMaster().getIssueToUser());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getInventoryItemIssueMaster().getInCharge());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getInventoryItemIssueMaster().getAcademicYear());
                }
                log.info((Object)(inventorySize + " InventoryItemReturnMaster records where reterived"));
            } else {
                log.info((Object)"No InventoryItemReturnMaster available");
            }
            return inventoryItemReturnMasters;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving InventoryItemReturnMaster list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryItemReturnMaster> inventoryItemReturnMasterByInventoryItemIssueMasterId(Long inventoryItemIssueMasterId) {
        try {
            ArrayList<InventoryItemReturnMaster> addInventoryItemReturnMaster = new ArrayList<InventoryItemReturnMaster>();
            InventoryItemIssueMaster inventoryItemIssueAndReturnMaster = this.inventoryItemIssueMasterDAO.getInventoryItemIssueAndReturnMasterById(inventoryItemIssueMasterId);
            if (inventoryItemIssueMasterId != null) {
                Hibernate.initialize((Object)inventoryItemIssueAndReturnMaster);
                for (InventoryItemReturnMaster inventoryItemReturnMaster : inventoryItemIssueAndReturnMaster.getInventoryItemReturnMaster()) {
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getReturnedBy());
                    Hibernate.initialize((Object)inventoryItemReturnMaster.getItemReturnedAcademicYear());
                    addInventoryItemReturnMaster.add(inventoryItemReturnMaster);
                }
                log.info((Object)("InventoryItemReturnMaster with id=" + inventoryItemIssueMasterId + " has been reterived"));
                return addInventoryItemReturnMaster;
            }
            log.info((Object)("No InventoryItemReturnMaster with  id=" + inventoryItemIssueMasterId + " is available"));
            return addInventoryItemReturnMaster;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving InventoryItemReturnMaster by id=" + inventoryItemIssueMasterId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TwoFieldReport> inventoryItemIssuedReport() {
        ArrayList<TwoFieldReport> addTwoFieldReports = new ArrayList<TwoFieldReport>();
        try {
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                Double count = 0.0;
                for (InventoryItemIssueMaster inventoryItemIssueMaster : this.inventoryItemIssueMasterDAO.getInventoryItemIssueByInventoryItemMaster(inventoryItemMaster)) {
                    count = count + inventoryItemIssueMaster.getNoOfQtyIssue();
                }
                addTwoFieldReports.add(new TwoFieldReport(inventoryItemMaster.getItemName(), count));
            }
            return addTwoFieldReports;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item issue ", e.getCause());
            e.printStackTrace();
            return addTwoFieldReports;
        }
    }

    @Override
    public List<TwoFieldReport> inventoryItemReturnedReport() {
        ArrayList<TwoFieldReport> addTwoFieldReports = new ArrayList<TwoFieldReport>();
        try {
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                Double count = 0.0;
                for (InventoryItemReturnMaster inventoryItemReturnMaster : this.inventoryItemReturnMasterDAO.getInventoryItemReturnByInventoryItemMaster(inventoryItemMaster)) {
                    count = count + inventoryItemReturnMaster.getNoOfQtyReturn();
                }
                addTwoFieldReports.add(new TwoFieldReport(inventoryItemMaster.getItemName(), count));
            }
            return addTwoFieldReports;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item returned ", e.getCause());
            e.printStackTrace();
            return addTwoFieldReports;
        }
    }

    @Override
    public List<TwoFieldReport> inventoryItemReport() {
        ArrayList<TwoFieldReport> addTwoFieldReports = new ArrayList<TwoFieldReport>();
        try {
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                addTwoFieldReports.add(new TwoFieldReport(inventoryItemMaster.getItemName(), inventoryItemMaster.getTotalQuantityInStock()));
            }
            return addTwoFieldReports;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item", e.getCause());
            e.printStackTrace();
            return addTwoFieldReports;
        }
    }

    @Override
    public String inventoryItemPercentage() {
        String percentage = "0%";
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            Double quantity = 0.0;
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                quantity = quantity + inventoryItemMaster.getTotalQuantityInStock();
            }
            Double totalPercentage = quantity;
            if (!totalPercentage.isNaN()) {
                percentage = df.format(totalPercentage).concat("%");
            }
            return percentage;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item percentage ", e.getCause());
            e.printStackTrace();
            return percentage;
        }
    }

    @Override
    public String inventoryItemIssuedPercentage() {
        String percentage = "0%";
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            List inventoryItemMasterList1 = this.inventoryItemMasterDAO.getList();
            Double quantity = 0.0;
            Double count = 0.0;
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList1) {
                quantity = quantity + inventoryItemMaster.getTotalQuantityInStock();
            }
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                for (InventoryItemIssueMaster inventoryItemIssueMaster : this.inventoryItemIssueMasterDAO.getInventoryItemIssueByInventoryItemMaster(inventoryItemMaster)) {
                    count = count + inventoryItemIssueMaster.getNoOfQtyIssue();
                }
            }
            Double totalPercentage = count / quantity * 100.0;
            if (!totalPercentage.isNaN()) {
                percentage = df.format(totalPercentage).concat("%");
            }
            return percentage;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item issued percentage", e.getCause());
            e.printStackTrace();
            return percentage;
        }
    }

    @Override
    public String inventoryItemReturnPercentage() {
        String percentage = "0%";
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            List inventoryItemMasterList1 = this.inventoryItemMasterDAO.getList();
            Double quantity = 0.0;
            Double count = 0.0;
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList1) {
                quantity = quantity + inventoryItemMaster.getTotalQuantityInStock();
            }
            List inventoryItemMasterList = this.inventoryItemMasterDAO.getList();
            for (InventoryItemMaster inventoryItemMaster : inventoryItemMasterList) {
                for (InventoryItemReturnMaster inventoryItemReturnMaster : this.inventoryItemReturnMasterDAO.getInventoryItemReturnByInventoryItemMaster(inventoryItemMaster)) {
                    count = count + inventoryItemReturnMaster.getNoOfQtyReturn();
                }
            }
            Double totalPercentage = count / quantity * 100.0;
            if (!totalPercentage.isNaN()) {
                percentage = df.format(totalPercentage).concat("%");
            }
            return percentage;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventory item returned percentage", e.getCause());
            e.printStackTrace();
            return percentage;
        }
    }
}
