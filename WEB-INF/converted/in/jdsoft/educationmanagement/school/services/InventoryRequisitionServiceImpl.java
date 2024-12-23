/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.InventoryRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.InventoryItemMaster;
import in.jdsoft.educationmanagement.school.model.InventoryRequisition;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.InventoryRequisitionService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="inventoryRequisitionService")
public class InventoryRequisitionServiceImpl
implements InventoryRequisitionService {
    @Autowired
    InventoryRequisitionDAO inventoryRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public Long createInventoryRequisition(InventoryRequisition inventoryRequisition, PortalTask portalTask) {
        try {
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            inventoryRequisition.setPortalTask(persistedPortalTask);
            InventoryRequisition persistedInventoryRequisition = this.inventoryRequisitionDAO.save(inventoryRequisition);
            Long InventoryRequisitionId = persistedInventoryRequisition.getInventoryRequisitionId();
            log.info((Object)("inventoryRequisition created with the id=" + InventoryRequisitionId));
            return InventoryRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating inventoryRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteInventoryRequisition(Long inventoryRequisitionId) {
        try {
            InventoryRequisition inventoryRequisition = this.inventoryRequisitionDAO.getInventoryRequisitionById(inventoryRequisitionId);
            if (inventoryRequisition != null) {
                this.inventoryRequisitionDAO.delete(inventoryRequisition);
                log.info((Object)("inventoryRequisition with id=" + inventoryRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting inventoryRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryRequisition> inventoryRequisitionList() {
        try {
            List<InventoryRequisition> inventoryRequisitionList = this.inventoryRequisitionDAO.getList();
            Integer inventoryRequisitionListSize = inventoryRequisitionList.size();
            if (inventoryRequisitionListSize > 0) {
                log.info((Object)(inventoryRequisitionListSize + " inventoryRequisition records where reterived"));
            } else {
                log.info((Object)"No inventoryRequisition list available");
            }
            return inventoryRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventoryRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryRequisition inventoryRequisitionById(Long inventoryRequisitionId) {
        try {
            InventoryRequisition inventoryRequisition = this.inventoryRequisitionDAO.getInventoryRequisitionById(inventoryRequisitionId);
            if (inventoryRequisition != null) {
                log.info((Object)("inventoryRequisition with id=" + inventoryRequisitionId + " has been reterived"));
                return inventoryRequisition;
            }
            log.info((Object)("No inventoryRequisition with  id=" + inventoryRequisitionId + " is available"));
            return inventoryRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving inventoryRequisition by id=" + inventoryRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateInventoryRequisition(InventoryRequisition inventoryRequisition, PortalTask portalTask) {
        try {
            this.inventoryRequisitionDAO.saveOrUpdate(inventoryRequisition);
            this.portalTaskDAO.save(portalTask);
            Long InventoryRequisitionId = inventoryRequisition.getInventoryRequisitionId();
            if (InventoryRequisitionId != null) {
                log.info((Object)("inventoryRequisition with id=" + InventoryRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New inventoryRequisition has been added, because no inventoryRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating inventoryRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public InventoryRequisition inventoryRequisitionByIdEager(Long inventoryRequisitionId) {
        try {
            InventoryRequisition inventoryRequisition = this.inventoryRequisitionDAO.getInventoryRequisitionById(inventoryRequisitionId);
            if (inventoryRequisition != null) {
                log.info((Object)("inventoryRequisition with id=" + inventoryRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)inventoryRequisition.getPortalTask());
                Hibernate.initialize((Object)inventoryRequisition);
                Hibernate.initialize((Object)inventoryRequisition.getInventoryRequisitionApproverBy());
                Hibernate.initialize((Object)inventoryRequisition.getInventoryRequistionBy());
                Hibernate.initialize((Object)inventoryRequisition.getInventoryItemId());
                return inventoryRequisition;
            }
            log.info((Object)("No inventoryRequisition with  id=" + inventoryRequisitionId + " is available"));
            return inventoryRequisition;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving inventoryRequisition by id=" + inventoryRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryRequisition> pendingInventoryRequisitionListByRequesterEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            List<InventoryRequisition> InventoryRequisitionList = this.inventoryRequisitionDAO.getInventoryRequisitionListByRequesterUser(user, "Pending");
            Integer InventoryRequisitionListSize = InventoryRequisitionList.size();
            if (InventoryRequisitionListSize > 0) {
                for (InventoryRequisition InventoryRequisition2 : InventoryRequisitionList) {
                    Hibernate.initialize((Object)InventoryRequisition2);
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequisitionApproverBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequistionBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryItemId());
                    Hibernate.initialize((Object)InventoryRequisition2.getPortalTask());
                }
                log.info((Object)(InventoryRequisitionListSize + " inventoryRequisition records where reterived"));
            } else {
                log.info((Object)"No inventoryRequisition list available");
            }
            return InventoryRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventoryRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void cancelInventoryRequisition(InventoryRequisition InventoryRequisition2) {
        try {
            log.info((Object)("inventoryRequisition with id=" + InventoryRequisition2.getInventoryRequisitionId() + " has been cancelled"));
            PortalTask portalTask = InventoryRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.inventoryRequisitionDAO.update(InventoryRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel inventoryRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryRequisition> pendingInventoryRequisitionListByApproverEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            List<InventoryRequisition> InventoryRequisitionList = this.inventoryRequisitionDAO.getInventoryRequisitionListByApproverUser(user, "Pending");
            Integer InventoryRequisitionListSize = InventoryRequisitionList.size();
            if (InventoryRequisitionListSize > 0) {
                for (InventoryRequisition InventoryRequisition2 : InventoryRequisitionList) {
                    Hibernate.initialize((Object)InventoryRequisition2);
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequisitionApproverBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequistionBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryItemId());
                    Hibernate.initialize((Object)InventoryRequisition2.getPortalTask());
                }
                log.info((Object)(InventoryRequisitionListSize + " inventoryRequisition records where reterived"));
            } else {
                log.info((Object)"No inventoryRequisition list available");
            }
            return InventoryRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventoryRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryRequisition> approvedAndRejectedInventoryRequisitionListByRequesterEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            ArrayList<InventoryRequisition> InventoryRequisitionList = new ArrayList<InventoryRequisition>();
            InventoryRequisitionList.addAll(this.inventoryRequisitionDAO.getInventoryRequisitionListByRequesterUser(user, "Approved"));
            InventoryRequisitionList.addAll(this.inventoryRequisitionDAO.getInventoryRequisitionListByRequesterUser(user, "Rejected"));
            Integer InventoryRequisitionListSize = InventoryRequisitionList.size();
            if (InventoryRequisitionListSize > 0) {
                for (InventoryRequisition InventoryRequisition2 : InventoryRequisitionList) {
                    Hibernate.initialize((Object)InventoryRequisition2);
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequisitionApproverBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequistionBy());
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryItemId());
                    Hibernate.initialize((Object)InventoryRequisition2.getPortalTask());
                }
                log.info((Object)(InventoryRequisitionListSize + " inventoryRequisition records where reterived"));
            } else {
                log.info((Object)"No inventoryRequisition list available");
            }
            return InventoryRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving inventoryRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<User> inventoryRequisitionApprovedUserList() {
        try {
            ArrayList<InventoryRequisition> InventoryRequisitionList = new ArrayList<InventoryRequisition>();
            ArrayList<User> userList = new ArrayList<User>();
            InventoryRequisitionList.addAll(this.inventoryRequisitionDAO.getInventoryRequisitionListByStatus("Approved"));
            Integer InventoryRequisitionListSize = InventoryRequisitionList.size();
            if (InventoryRequisitionListSize > 0) {
                for (InventoryRequisition InventoryRequisition2 : InventoryRequisitionList) {
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryRequistionBy());
                    userList.add(InventoryRequisition2.getInventoryRequistionBy());
                }
                log.info((Object)(InventoryRequisitionListSize + " user records where reterived"));
            } else {
                log.info((Object)"No user list available");
            }
            return userList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving user list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<InventoryItemMaster> inventoryRequisitionApprovedInventoryItemMasterList() {
        try {
            ArrayList<InventoryRequisition> InventoryRequisitionList = new ArrayList<InventoryRequisition>();
            ArrayList<InventoryItemMaster> inventoryItemMasterList = new ArrayList<InventoryItemMaster>();
            InventoryRequisitionList.addAll(this.inventoryRequisitionDAO.getInventoryRequisitionListByStatus("Approved"));
            Integer InventoryRequisitionListSize = InventoryRequisitionList.size();
            if (InventoryRequisitionListSize > 0) {
                for (InventoryRequisition InventoryRequisition2 : InventoryRequisitionList) {
                    Hibernate.initialize((Object)InventoryRequisition2.getInventoryItemId());
                    inventoryItemMasterList.add(InventoryRequisition2.getInventoryItemId());
                }
                log.info((Object)(InventoryRequisitionListSize + " user records where reterived"));
            } else {
                log.info((Object)"No user list available");
            }
            return inventoryItemMasterList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving user list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
