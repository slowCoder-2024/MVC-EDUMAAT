/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CoScholasticAreaDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
import in.jdsoft.educationmanagement.school.services.CoScholasticAreaService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="coScholasticAreaService")
public class CoScholasticAreaServiceImpl
implements CoScholasticAreaService {
    @Autowired
    CoScholasticAreaDAO coScholasticAreaDAO;

    @Override
    public List<CoScholasticArea> coScholasticAreaList() {
        try {
            List<CoScholasticArea> coScholasticAreas = this.coScholasticAreaDAO.getList();
            Integer coScholasticAreasSize = coScholasticAreas.size();
            if (coScholasticAreasSize > 0) {
                log.info((Object)(coScholasticAreasSize + " co-scholastic area records where reterived"));
            } else {
                log.info((Object)"No co-scholastic area list available");
            }
            return coScholasticAreas;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving co-scholastic area list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CoScholasticArea coScholasticAreaById(Long coScholasticAreaId) {
        try {
            CoScholasticArea coScholasticArea = this.coScholasticAreaDAO.getCoScholasticAreaById(coScholasticAreaId);
            if (coScholasticArea != null) {
                log.info((Object)("Co-scholastic area with id=" + coScholasticAreaId + " has been reterived"));
                return coScholasticArea;
            }
            log.info((Object)("No Co-scholastic area with  id=" + coScholasticAreaId + " is available"));
            return coScholasticArea;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving co-scholastic area by id=" + coScholasticAreaId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CoScholasticArea> coScholasticAreaListEager() {
        try {
            List<CoScholasticArea> coScholasticAreas = this.coScholasticAreaDAO.getList();
            Integer coScholasticAreasSize = coScholasticAreas.size();
            if (coScholasticAreasSize > 0) {
                for (CoScholasticArea coScholasticArea : coScholasticAreas) {
                    Hibernate.initialize(coScholasticArea.getCoScholasticAreaIndicators());
                    Hibernate.initialize(coScholasticArea.getClassSectionCoScholasticArea());
                }
                log.info((Object)(coScholasticAreasSize + " co-scholastic area records where reterived with childs"));
            } else {
                log.info((Object)"No co-scholastic area list available");
            }
            return coScholasticAreas;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving co-scholastic area list with its child", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CoScholasticArea coScholasticAreaByIdEager(Long coScholasticAreaId) {
        try {
            CoScholasticArea coScholasticArea = this.coScholasticAreaDAO.getCoScholasticAreaById(coScholasticAreaId);
            if (coScholasticArea != null) {
                Hibernate.initialize(coScholasticArea.getCoScholasticAreaIndicators());
                Hibernate.initialize(coScholasticArea.getClassSectionCoScholasticArea());
                log.info((Object)("Co-scholastic area with id=" + coScholasticAreaId + " has been reterived with its childs"));
                return coScholasticArea;
            }
            log.info((Object)("No Co-scholastic area with  id=" + coScholasticAreaId + " is available"));
            return coScholasticArea;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving co-scholastic area with its childs by id=" + coScholasticAreaId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
