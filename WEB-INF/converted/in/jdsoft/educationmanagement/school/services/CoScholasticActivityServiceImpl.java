/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CoScholasticActivityDAO;
import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
import in.jdsoft.educationmanagement.school.services.CoScholasticActivityService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="coScholasticActivityService")
public class CoScholasticActivityServiceImpl
implements CoScholasticActivityService {
    @Autowired
    CoScholasticActivityDAO coScholasticActivityDAO;

    @Override
    public List<CoScholasticActivity> coScholasticActivityList() {
        try {
            List<CoScholasticActivity> coScholasticActivities = this.coScholasticActivityDAO.getList();
            Integer coScholasticActivitySize = coScholasticActivities.size();
            if (coScholasticActivitySize > 0) {
                log.info((Object)(coScholasticActivitySize + " co-scholastic activity records where reterived"));
            } else {
                log.info((Object)"No co-scholastic activity list available");
            }
            return coScholasticActivities;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving co-scholastic activity list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CoScholasticActivity coScholasticActivityById(Long coScholasticActivityId) {
        try {
            CoScholasticActivity coScholasticActivity = this.coScholasticActivityDAO.getCoScholasticActivityById(coScholasticActivityId);
            if (coScholasticActivity != null) {
                log.info((Object)("Co-scholastic activity with id=" + coScholasticActivityId + " has been reterived"));
                return coScholasticActivity;
            }
            log.info((Object)("No Co-scholastic activity with  id=" + coScholasticActivityId + " is available"));
            return coScholasticActivity;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving co-scholastic activity by id=" + coScholasticActivityId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<CoScholasticActivity> coScholasticActivityListEager() {
        try {
            List<CoScholasticActivity> coScholasticActivities = this.coScholasticActivityDAO.getList();
            Integer coScholasticActivitySize = coScholasticActivities.size();
            if (coScholasticActivitySize > 0) {
                for (CoScholasticActivity coScholasticActivity : coScholasticActivities) {
                    Hibernate.initialize(coScholasticActivity.getCoScholasticActivityIndicators());
                    Hibernate.initialize(coScholasticActivity.getClassSectionCoScholasticActivites());
                }
                log.info((Object)(coScholasticActivitySize + " co-scholastic activity records where reterived"));
            } else {
                log.info((Object)"No co-scholastic activity list available");
            }
            return coScholasticActivities;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving co-scholastic activity list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public CoScholasticActivity coScholasticActivityByIdEager(Long coScholasticActivityId) {
        try {
            CoScholasticActivity coScholasticActivity = this.coScholasticActivityDAO.getCoScholasticActivityById(coScholasticActivityId);
            if (coScholasticActivity != null) {
                Hibernate.initialize(coScholasticActivity.getCoScholasticActivityIndicators());
                Hibernate.initialize(coScholasticActivity.getClassSectionCoScholasticActivites());
                log.info((Object)("Co-scholastic activity with id=" + coScholasticActivityId + " has been reterived"));
                return coScholasticActivity;
            }
            log.info((Object)("No Co-scholastic activity with  id=" + coScholasticActivityId + " is available"));
            return coScholasticActivity;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving co-scholastic activity by id=" + coScholasticActivityId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
