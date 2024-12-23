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
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.PurchaseRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.PurchaseRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.PurchaseRequisitionService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="purchaseRequisitionService")
public class PurchaseRequisitionServiceImpl
implements PurchaseRequisitionService {
    @Autowired
    PurchaseRequisitionDAO purchaseRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    private UserDAO userDAO;

    @Override
    public Long createPurchaseRequisition(PurchaseRequisition purchaseRequisition, PortalTask portalTask) {
        try {
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            purchaseRequisition.setPortalTask(persistedPortalTask);
            PurchaseRequisition persistedPurchaseRequisition = this.purchaseRequisitionDAO.save(purchaseRequisition);
            Long PurchaseRequisitionId = persistedPurchaseRequisition.getPurchaseRequisitionId();
            log.info((Object)("PurchaseRequisition created with the id=" + PurchaseRequisitionId));
            return PurchaseRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating PurchaseRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deletePurchaseRequisition(Long purchaseRequisitionId) {
        try {
            PurchaseRequisition purchaseRequisition = this.purchaseRequisitionDAO.getPurchaseRequisitionById(purchaseRequisitionId);
            if (purchaseRequisition != null) {
                this.purchaseRequisitionDAO.delete(purchaseRequisition);
                log.info((Object)("PurchaseRequisition with id=" + purchaseRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting PurchaseRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PurchaseRequisition> purchaseRequisitionList() {
        try {
            List<PurchaseRequisition> PurchaseRequisitionList = this.purchaseRequisitionDAO.getList();
            Integer PurchaseRequisitionListSize = PurchaseRequisitionList.size();
            if (PurchaseRequisitionListSize > 0) {
                log.info((Object)(PurchaseRequisitionListSize + " PurchaseRequisition records where reterived"));
            } else {
                log.info((Object)"No PurchaseRequisition list available");
            }
            return PurchaseRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving PurchaseRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PurchaseRequisition purchaseRequisitionById(Long purchaseRequisitionId) {
        try {
            PurchaseRequisition PurchaseRequisition2 = this.purchaseRequisitionDAO.getPurchaseRequisitionById(purchaseRequisitionId);
            if (PurchaseRequisition2 != null) {
                log.info((Object)("PurchaseRequisition with id=" + purchaseRequisitionId + " has been reterived"));
                return PurchaseRequisition2;
            }
            log.info((Object)("No PurchaseRequisition with  id=" + purchaseRequisitionId + " is available"));
            return PurchaseRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving PurchaseRequisition by id=" + purchaseRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updatePurchaseRequisition(PurchaseRequisition purchaseRequisition, PortalTask portalTask) {
        try {
            this.purchaseRequisitionDAO.saveOrUpdate(purchaseRequisition);
            this.portalTaskDAO.save(portalTask);
            Long PurchaseRequisitionId = purchaseRequisition.getPurchaseRequisitionId();
            if (PurchaseRequisitionId != null) {
                log.info((Object)("PurchaseRequisition with id=" + PurchaseRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New PurchaseRequisition has been added, because no PurchaseRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating PurchaseRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public PurchaseRequisition purchaseRequisitionByIdEager(Long purchaseRequisitionId) {
        try {
            PurchaseRequisition PurchaseRequisition2 = this.purchaseRequisitionDAO.getPurchaseRequisitionById(purchaseRequisitionId);
            if (PurchaseRequisition2 != null) {
                log.info((Object)("PurchaseRequisition with id=" + purchaseRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)PurchaseRequisition2.getPortalTask());
                Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseApproverBy());
                Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseRequistionBy());
                return PurchaseRequisition2;
            }
            log.info((Object)("No PurchaseRequisition with  id=" + purchaseRequisitionId + " is available"));
            return PurchaseRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving PurchaseRequisition by id=" + purchaseRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PurchaseRequisition> pendingPurchaseRequisitionListByRequesterEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            List<PurchaseRequisition> PurchaseRequisitionList = this.purchaseRequisitionDAO.getPurchaseRequisitionListByRequesterUser(user, "Pending");
            Integer PurchaseRequisitionListSize = PurchaseRequisitionList.size();
            if (PurchaseRequisitionListSize > 0) {
                for (PurchaseRequisition PurchaseRequisition2 : PurchaseRequisitionList) {
                    Hibernate.initialize((Object)PurchaseRequisition2);
                    Hibernate.initialize((Object)PurchaseRequisition2.getPortalTask());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseApproverBy());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseRequistionBy());
                }
                log.info((Object)(PurchaseRequisitionListSize + " PurchaseRequisition records where reterived"));
            } else {
                log.info((Object)"No PurchaseRequisition list available");
            }
            return PurchaseRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving PurchaseRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void cancelPurchaseRequisition(PurchaseRequisition PurchaseRequisition2) {
        try {
            log.info((Object)("PurchaseRequisition with id=" + PurchaseRequisition2.getPurchaseRequisitionId() + " has been cancelled"));
            PortalTask portalTask = PurchaseRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.purchaseRequisitionDAO.update(PurchaseRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel PurchaseRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PurchaseRequisition> pendingPurchaseRequisitionListByApproverEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            List<PurchaseRequisition> PurchaseRequisitionList = this.purchaseRequisitionDAO.getPurchaseRequisitionListByApproverUser(user, "Pending");
            Integer PurchaseRequisitionListSize = PurchaseRequisitionList.size();
            if (PurchaseRequisitionListSize > 0) {
                for (PurchaseRequisition PurchaseRequisition2 : PurchaseRequisitionList) {
                    Hibernate.initialize((Object)PurchaseRequisition2);
                    Hibernate.initialize((Object)PurchaseRequisition2.getPortalTask());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseApproverBy());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseRequistionBy());
                }
                log.info((Object)(PurchaseRequisitionListSize + " PurchaseRequisition records where reterived"));
            } else {
                log.info((Object)"No PurchaseRequisition list available");
            }
            return PurchaseRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving PurchaseRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<PurchaseRequisition> approvedAndRejectedPurchaseRequisitionListByRequesterEmail(String email) {
        try {
            User user = this.userDAO.getUserByEmail(email);
            ArrayList<PurchaseRequisition> PurchaseRequisitionList = new ArrayList<PurchaseRequisition>();
            PurchaseRequisitionList.addAll(this.purchaseRequisitionDAO.getPurchaseRequisitionListByRequesterUser(user, "Approved"));
            PurchaseRequisitionList.addAll(this.purchaseRequisitionDAO.getPurchaseRequisitionListByRequesterUser(user, "Rejected"));
            Integer PurchaseRequisitionListSize = PurchaseRequisitionList.size();
            if (PurchaseRequisitionListSize > 0) {
                for (PurchaseRequisition PurchaseRequisition2 : PurchaseRequisitionList) {
                    Hibernate.initialize((Object)PurchaseRequisition2);
                    Hibernate.initialize((Object)PurchaseRequisition2.getPortalTask());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseApproverBy());
                    Hibernate.initialize((Object)PurchaseRequisition2.getPurchaseRequistionBy());
                }
                log.info((Object)(PurchaseRequisitionListSize + " PurchaseRequisition records where reterived"));
            } else {
                log.info((Object)"No PurchaseRequisition list available");
            }
            return PurchaseRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving PurchaseRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
