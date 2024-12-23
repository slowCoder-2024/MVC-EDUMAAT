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
import in.jdsoft.educationmanagement.school.dao.VisitorTypeDAO;
import in.jdsoft.educationmanagement.school.model.VisitorType;
import in.jdsoft.educationmanagement.school.services.VisitorTypeService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="visitorTypeService")
public class VisitorTypeServiceImpl
implements VisitorTypeService {
    @Autowired
    VisitorTypeDAO visitorTypeDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public Long createVisitorType(VisitorType visitorType) {
        try {
            VisitorType persistedvisitorType = this.visitorTypeDAO.save(visitorType);
            Long visitorTypeId = persistedvisitorType.getVisitorTypeId();
            log.info((Object)(" visitorType created with the id=" + visitorTypeId));
            return visitorTypeId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating  visitorType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteVisitorType(Long visitorTypeId) {
        try {
            VisitorType visitorType = this.visitorTypeDAO.getVisitorTypeById(visitorTypeId);
            if (visitorType != null) {
                this.visitorTypeDAO.delete(visitorType);
                log.info((Object)(" visitorType with id=" + visitorTypeId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting  visitorType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<VisitorType> visitorTypeList() {
        try {
            List<VisitorType> visitorTypeList = this.visitorTypeDAO.getList();
            Integer visitorTypeListSize = visitorTypeList.size();
            if (visitorTypeListSize > 0) {
                log.info((Object)(visitorTypeListSize + "  visitorType records where reterived"));
            } else {
                log.info((Object)"No  visitorType list available");
            }
            return visitorTypeList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving  visitorType list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public VisitorType visitorTypeById(Long visitorTypeId) {
        try {
            VisitorType visitorType = this.visitorTypeDAO.getVisitorTypeById(visitorTypeId);
            if (visitorType != null) {
                log.info((Object)(" visitorType with id=" + visitorTypeId + " has been reterived"));
                return visitorType;
            }
            log.info((Object)("No  visitorType with  id=" + visitorTypeId + " is available"));
            return visitorType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  visitorType by id=" + visitorTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateVisitorType(VisitorType visitorType) {
        try {
            this.visitorTypeDAO.saveOrUpdate(visitorType);
            Long visitorTypeId = visitorType.getVisitorTypeId();
            if (visitorTypeId != null) {
                log.info((Object)(" visitorType with id=" + visitorTypeId + " has been updated"));
            } else {
                log.info((Object)"New  visitorType has been added, because no  visitorType found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating  visitorType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public VisitorType visitorTypeByIdEager(Long visitorTypeId) {
        try {
            VisitorType visitorType = this.visitorTypeDAO.getVisitorTypeById(visitorTypeId);
            if (visitorType != null) {
                log.info((Object)(" visitorType with id=" + visitorTypeId + " has been reterived"));
                Hibernate.initialize(visitorType.getVisitorManagements());
                return visitorType;
            }
            log.info((Object)("No  visitorType with  id=" + visitorTypeId + " is available"));
            return visitorType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving  visitorType by id=" + visitorTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
