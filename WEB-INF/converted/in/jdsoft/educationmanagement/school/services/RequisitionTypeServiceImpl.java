/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.RequisitionTypeDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.model.UserRole;
import in.jdsoft.educationmanagement.school.services.RequisitionTypeService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="requisitionTypeService")
public class RequisitionTypeServiceImpl
implements RequisitionTypeService {
    @Autowired
    RequisitionTypeDAO requisitionTypeDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    UserDAO userDAO;

    @Override
    public Long createRequisitionType(RequisitionType requisitionType) {
        try {
            RequisitionType persistedRequisitionType = this.requisitionTypeDAO.save(requisitionType);
            Long RequisitionTypeId = persistedRequisitionType.getRequisitionTypeId();
            log.info((Object)(" RequisitionType created with the id=" + RequisitionTypeId));
            return RequisitionTypeId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  RequisitionType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteRequisitionType(Long requisitionTypeId) {
        try {
            RequisitionType RequisitionType2 = this.requisitionTypeDAO.getRequisitionTypeById(requisitionTypeId);
            if (RequisitionType2 != null) {
                this.requisitionTypeDAO.delete(RequisitionType2);
                log.info((Object)(" RequisitionType with id=" + requisitionTypeId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  RequisitionType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<RequisitionType> requisitionTypeList() {
        try {
            List<RequisitionType> RequisitionTypeList = this.requisitionTypeDAO.getList();
            Integer RequisitionTypeListSize = RequisitionTypeList.size();
            if (RequisitionTypeListSize > 0) {
                log.info((Object)(RequisitionTypeListSize + "  RequisitionType records where reterived"));
            } else {
                log.info((Object)"No  RequisitionType list available");
            }
            return RequisitionTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  RequisitionType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RequisitionType requisitionTypeById(Long requisitionTypeId) {
        try {
            RequisitionType RequisitionType2 = this.requisitionTypeDAO.getRequisitionTypeById(requisitionTypeId);
            if (RequisitionType2 != null) {
                log.info((Object)(" RequisitionType with id=" + requisitionTypeId + " has been reterived"));
                return RequisitionType2;
            }
            log.info((Object)("No  RequisitionType with  id=" + requisitionTypeId + " is available"));
            return RequisitionType2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  RequisitionType by id=" + requisitionTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateRequisitionType(RequisitionType requisitionType) {
        try {
            this.requisitionTypeDAO.saveOrUpdate(requisitionType);
            Long RequisitionTypeId = requisitionType.getRequisitionTypeId();
            if (RequisitionTypeId != null) {
                log.info((Object)(" RequisitionType with id=" + RequisitionTypeId + " has been updated"));
            } else {
                log.info((Object)"New  RequisitionType has been added, because no  RequisitionType found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  RequisitionType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public RequisitionType requisitionTypeByIdEager(Long requisitionTypeId) {
        try {
            RequisitionType RequisitionType2 = this.requisitionTypeDAO.getRequisitionTypeById(requisitionTypeId);
            if (RequisitionType2 != null) {
                log.info((Object)(" RequisitionType with id=" + requisitionTypeId + " has been reterived"));
                return RequisitionType2;
            }
            log.info((Object)("No  RequisitionType with  id=" + requisitionTypeId + " is available"));
            return RequisitionType2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  RequisitionType by id=" + requisitionTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<RequisitionType> requisitionTypeListByUser(User user) {
        try {
            List<RequisitionType> requisitionLists = this.requisitionTypeDAO.getList();
            Integer requisitionListSize = requisitionLists.size();
            if (requisitionListSize > 0) {
                Iterator requisitionList = requisitionLists.iterator();
                while (requisitionList.hasNext()) {
                    RequisitionType requisitionType = (RequisitionType)requisitionList.next();
                    for (UserRole userRole : user.getUserRoles()) {
                        if (!userRole.getTargetType().equals("admin")) {
                            if (userRole.getTargetType().equals("student")) {
                                if (requisitionType.getRequisitionTypeId() != 3L) continue;
                                requisitionList.remove();
                                continue;
                            }
                            if (userRole.getTargetType().equals("staff")) {
                                if (requisitionType.getRequisitionTypeId() != 3L) continue;
                                requisitionList.remove();
                                continue;
                            }
                            if (!userRole.getTargetType().equals("parent")) continue;
                            if (requisitionType.getRequisitionTypeId() == 1L) {
                                requisitionList.remove();
                                continue;
                            }
                            if (requisitionType.getRequisitionTypeId() != 2L) continue;
                            requisitionList.remove();
                            continue;
                        }
                        if (!userRole.getTargetType().equals("admin") || requisitionType.getRequisitionTypeId() != 3L) continue;
                        requisitionList.remove();
                    }
                }
                log.info((Object)(requisitionListSize + " RequisitionType records where reterived"));
            } else {
                log.info((Object)"No RequisitionType available");
            }
            return requisitionLists;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving RequisitionType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<RequisitionType> requisitionTypeListInventoryAndPurchaseByUser(User user) {
        try {
            List<RequisitionType> requisitionLists = this.requisitionTypeDAO.getList();
            Integer requisitionListSize = requisitionLists.size();
            if (requisitionListSize > 0) {
                Iterator requisitionList = requisitionLists.iterator();
                while (requisitionList.hasNext()) {
                    RequisitionType requisitionType = (RequisitionType)requisitionList.next();
                    for (UserRole userRole : user.getUserRoles()) {
                        if (userRole.getTargetType().equals("visitoradmin") || userRole.getTargetType().equals("superstaff") || userRole.getTargetType().equals("admin") || userRole.getTargetType().equals("student") || userRole.getTargetType().equals("staff") || userRole.getTargetType().equals("superadmin")) {
                            if (requisitionType.getRequisitionTypeId() == 5L) continue;
                            requisitionList.remove();
                            continue;
                        }
                        if (!userRole.getTargetType().equals("inventoryandassetadmin") && !userRole.getTargetType().equals("libraryadmin") || requisitionType.getRequisitionTypeId() == 6L) continue;
                        requisitionList.remove();
                    }
                }
            }
            return requisitionLists;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving RequisitionType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
