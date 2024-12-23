/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateDaysDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableTemplateHoursDAO;
import in.jdsoft.educationmanagement.school.exceptions.TimeTableTemplateException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplate;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateDays;
import in.jdsoft.educationmanagement.school.model.TimeTableTemplateHours;
import in.jdsoft.educationmanagement.school.services.TimeTableTemplateService;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="timeTableTemplateService")
public class TimeTableTemplateServiceImpl
implements TimeTableTemplateService {
    @Autowired
    TimeTableTemplateDAO timeTableTemplateDAO;
    @Autowired
    TimeTableTemplateDaysDAO timeTableTemplateDaysDAO;
    @Autowired
    TimeTableTemplateHoursDAO timeTableTemplateHoursDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    ExceptionComparator exceptionComparator;
    private Logger log = LogManager.getLogger((String)TimeTableTemplateServiceImpl.class.getName());

    @Override
    public void createTimeTableTemplate(TimeTableTemplate timeTableTemplate, Set<TimeTableTemplateDays> timeTableTemplateDays, Set<TimeTableTemplateHours> timeTableTemplateHours) throws TimeTableTemplateException {
        try {
            this.timeTableTemplateDAO.persist(timeTableTemplate);
            for (TimeTableTemplateDays timeTableTemplateDay : timeTableTemplateDays) {
                this.timeTableTemplateDaysDAO.persist(timeTableTemplateDay);
            }
            for (TimeTableTemplateHours timeTableTemplateHour : timeTableTemplateHours) {
                this.timeTableTemplateHoursDAO.persist(timeTableTemplateHour);
            }
            this.log.info((Object)"TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours is created");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateTimeTableTemplate(TimeTableTemplate timeTableTemplate) throws TimeTableTemplateException {
        try {
            this.timeTableTemplateDAO.saveOrUpdate(timeTableTemplate);
            Long timeTableTemplateId = timeTableTemplate.getTimeTableTemplateId();
            if (timeTableTemplateId != null) {
                this.log.info((Object)"TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours is updated");
            } else {
                this.log.info((Object)"New TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours has been added, because no TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours found for update");
            }
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteTimeTableTemplate(Long timeTableTemplateId) throws TimeTableTemplateException {
        try {
            this.timeTableTemplateDAO.delete(this.timeTableTemplateDAO.getTimeTableTemplateById(timeTableTemplateId));
            this.log.info((Object)"TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting TimeTableTemplate,TimeTableTemplateDays,TimeTableTemplateHours", e.getCause());
            throw e;
        }
    }

    @Override
    public TimeTableTemplate timeTableTemplateById(Long timeTableTemplateId) {
        try {
            TimeTableTemplate timeTableTemplate = this.timeTableTemplateDAO.getTimeTableTemplateById(timeTableTemplateId);
            if (timeTableTemplate != null) {
                this.log.info((Object)("TimeTableTemplate with id=" + timeTableTemplateId + " has been reterived"));
                return timeTableTemplate;
            }
            this.log.info((Object)("No TimeTableTemplate with  id=" + timeTableTemplateId + " is available"));
            return timeTableTemplate;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableTemplate by id=" + timeTableTemplateId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableTemplate> timeTableTemplateList(Long institutionId) throws TimeTableTemplateException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<TimeTableTemplate> TimeTableTemplates = this.timeTableTemplateDAO.getTimeTableTemplatesByInstitution(institution);
                Integer timeTableTemplateRecordSize = TimeTableTemplates.size();
                if (timeTableTemplateRecordSize > 0) {
                    this.log.info((Object)(timeTableTemplateRecordSize + " TimeTableTemplate records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No TimeTableTemplate Records found for institution " + institution.getInstitutionAliasName()));
                }
                return TimeTableTemplates;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new TimeTableTemplateException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving TimeTableTemplates of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableTemplate timeTableTemplateIdByEager(Long timeTableTemplateId) {
        try {
            TimeTableTemplate timeTableTemplate = this.timeTableTemplateDAO.getTimeTableTemplateById(timeTableTemplateId);
            if (timeTableTemplate != null) {
                Hibernate.initialize((Object)timeTableTemplate.getInstitution());
                Hibernate.initialize(timeTableTemplate.getTimeTableTemplateDays());
                Hibernate.initialize(timeTableTemplate.getTimeTableTemplateHours());
                for (TimeTableTemplateDays timeTableTemplateDay : timeTableTemplate.getTimeTableTemplateDays()) {
                    Hibernate.initialize((Object)timeTableTemplateDay);
                }
                for (TimeTableTemplateHours timeTableTemplateHour : timeTableTemplate.getTimeTableTemplateHours()) {
                    Hibernate.initialize((Object)timeTableTemplateHour);
                }
                this.log.info((Object)("TimeTableTemplate with id=" + timeTableTemplateId + " has been retrieved"));
                return timeTableTemplate;
            }
            this.log.info((Object)("No TimeTableTemplate with  id=" + timeTableTemplateId + " is available"));
            return timeTableTemplate;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableTemplate by id=" + timeTableTemplateId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableTemplate> timeTableTemplateListEager(Long institutionId) throws TimeTableTemplateException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<TimeTableTemplate> timeTableTemplates = this.timeTableTemplateDAO.getTimeTableTemplatesByInstitution(institution);
                for (TimeTableTemplate timeTableTemplate : timeTableTemplates) {
                    Hibernate.initialize((Object)timeTableTemplate.getInstitution());
                    Hibernate.initialize(timeTableTemplate.getTimeTableTemplateDays());
                    Hibernate.initialize(timeTableTemplate.getTimeTableTemplateHours());
                }
                Integer timeTableTemplateRecordSize = timeTableTemplates.size();
                if (timeTableTemplateRecordSize > 0) {
                    this.log.info((Object)(timeTableTemplateRecordSize + " TimeTableTemplate records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No TimeTableTemplate Records found for institution " + institution.getInstitutionAliasName()));
                }
                return timeTableTemplates;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new TimeTableTemplateException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving TimeTableTemplates of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableTemplate> timeTableTemplateList() {
        try {
            List<TimeTableTemplate> timeTableTemplateList = this.timeTableTemplateDAO.getList();
            Integer timeTableTemplateListSize = timeTableTemplateList.size();
            if (timeTableTemplateListSize > 0) {
                this.log.info((Object)(timeTableTemplateListSize + " TimeTableTemplate records where retrieved"));
            } else {
                this.log.info((Object)"No TimeTableTemplate list available");
            }
            return timeTableTemplateList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving TimeTableTemplate list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
