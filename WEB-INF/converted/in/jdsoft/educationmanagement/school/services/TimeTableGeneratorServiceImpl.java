/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.ClassSectionDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorDaysDAO;
import in.jdsoft.educationmanagement.school.dao.TimeTableGeneratorHoursDAO;
import in.jdsoft.educationmanagement.school.exceptions.TimeTableGeneratorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.TimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorDays;
import in.jdsoft.educationmanagement.school.model.TimeTableGeneratorHours;
import in.jdsoft.educationmanagement.school.services.TimeTableGeneratorService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="timeTableGeneratorService")
public class TimeTableGeneratorServiceImpl
implements TimeTableGeneratorService {
    @Autowired
    TimeTableGeneratorDAO timeTableGeneratorDAO;
    @Autowired
    TimeTableGeneratorDaysDAO timeTableGeneratorDaysDAO;
    @Autowired
    TimeTableGeneratorHoursDAO timeTableGeneratorHoursDAO;
    @Autowired
    ExceptionComparator exceptionComparator;
    @Autowired
    ClassSectionDAO classSectionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    private Logger log = LogManager.getLogger((String)TimeTableGeneratorServiceImpl.class.getName());

    @Override
    @Transactional(rollbackFor={TimeTableGeneratorException.class})
    public void createTimeTableGenerator(TimeTableGenerator timeTableGenerator, Set<TimeTableGeneratorDays> timeTableGeneratorDays, Set<TimeTableGeneratorHours> timeTableGeneratorHours) throws TimeTableGeneratorException {
        try {
            this.timeTableGeneratorDAO.persist(timeTableGenerator);
            for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGeneratorDays) {
                this.timeTableGeneratorDaysDAO.persist(timeTableGeneratorDay);
            }
            for (TimeTableGeneratorHours timeTableGeneratorHour : timeTableGeneratorHours) {
                this.timeTableGeneratorHoursDAO.persist(timeTableGeneratorHour);
            }
            this.log.info((Object)"TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours is created");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Adding TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateTimeTableGenerator(TimeTableGenerator timeTableGenerator, Set<TimeTableGeneratorDays> timeTableGeneratorDays, Set<TimeTableGeneratorHours> timeTableGeneratorHours) throws TimeTableGeneratorException {
        try {
            this.timeTableGeneratorDAO.update(timeTableGenerator);
            for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGeneratorDays) {
                this.timeTableGeneratorDaysDAO.update(timeTableGeneratorDay);
            }
            for (TimeTableGeneratorHours timeTableGeneratorHour : timeTableGeneratorHours) {
                this.timeTableGeneratorHoursDAO.update(timeTableGeneratorHour);
            }
            this.log.info((Object)"TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours is updated");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteTimeTableGenerator(Long timeTableGeneratorId) throws TimeTableGeneratorException {
        try {
            this.timeTableGeneratorDAO.delete(this.timeTableGeneratorDAO.getTimeTableGeneratorById(timeTableGeneratorId));
            this.log.info((Object)"TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours", e.getCause());
            throw e;
        }
    }

    @Override
    public TimeTableGenerator timeTableGeneratorById(Long timeTableGeneratorId) {
        try {
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorDAO.getTimeTableGeneratorById(timeTableGeneratorId);
            if (timeTableGenerator != null) {
                this.log.info((Object)("TimeTableGenerator with id=" + timeTableGeneratorId + " has been reterived"));
                return timeTableGenerator;
            }
            this.log.info((Object)("No TimeTableGenerator with  id=" + timeTableGeneratorId + " is available"));
            return timeTableGenerator;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by id=" + timeTableGeneratorId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGenerator timeTableGeneratorIdByEager(Long timeTableGeneratorId) {
        try {
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorDAO.getTimeTableGeneratorById(timeTableGeneratorId);
            if (timeTableGenerator != null) {
                Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                    Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                    for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                        Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                    }
                }
                this.log.info((Object)("TimeTableGenerator with id=" + timeTableGeneratorId + " has been retrieved"));
                return timeTableGenerator;
            }
            this.log.info((Object)("No TimeTableGenerator with  id=" + timeTableGeneratorId + " is available"));
            return timeTableGenerator;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by id=" + timeTableGeneratorId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorList() {
        try {
            List<TimeTableGenerator> timeTableGeneratorList = this.timeTableGeneratorDAO.getList();
            Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
            if (timeTableGeneratorListSize > 0) {
                this.log.info((Object)(timeTableGeneratorListSize + " TimeTableGenerator records where retrieved"));
            } else {
                this.log.info((Object)"No TimeTableGenerator list available");
            }
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving TimeTableGenerator list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorListEager() throws TimeTableGeneratorException {
        try {
            List<TimeTableGenerator> timeTableGeneratorList = this.timeTableGeneratorDAO.getList();
            Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
            if (timeTableGeneratorListSize > 0) {
                for (TimeTableGenerator timeTableGenerator : timeTableGeneratorList) {
                    Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                    Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                    for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                        Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                        for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                            Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                        }
                    }
                }
                this.log.info((Object)(timeTableGeneratorListSize + " TimeTableGenerator records where retrieved"));
            } else {
                this.log.info((Object)"No TimeTableGenerator list available");
            }
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving TimeTableGenerator list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TimeTableGenerator timeTableGeneratorEagerByClassSectionId(Long classSectionId) {
        try {
            ClassSection classSection = this.classSectionDAO.getClassSectionById(classSectionId);
            TimeTableGenerator timeTableGenerator = this.timeTableGeneratorDAO.getTimeTableGeneratorsByClassSection(classSection);
            if (timeTableGenerator != null) {
                Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                Hibernate.initialize((Object)timeTableGenerator.getClassSection().getClassSection());
                Hibernate.initialize((Object)timeTableGenerator.getClassSection().getSectionClass());
                for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                    Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                    for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                        Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                    }
                }
                this.log.info((Object)("TimeTableGenerator with ClassSection id=" + classSectionId + " has been reterived"));
                return timeTableGenerator;
            }
            this.log.info((Object)("No TimeTableGenerator with ClassSection id=" + classSectionId + " is available"));
            return timeTableGenerator;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by ClassSection id=" + classSectionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorList(Long institutionId) throws TimeTableGeneratorException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<TimeTableGenerator> timeTableGeneratorList = this.timeTableGeneratorDAO.getTimeTableGeneratorsByInstitution(institution);
            Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
            if (timeTableGeneratorListSize > 0) {
                this.log.info((Object)("TimeTableGenerator with institution id=" + institutionId + " has been reterived"));
                return timeTableGeneratorList;
            }
            this.log.info((Object)("No TimeTableGenerator with institution id=" + institutionId + " is available"));
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by institution id=" + institutionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorListEager(Long institutionId) throws TimeTableGeneratorException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<TimeTableGenerator> timeTableGeneratorList = this.timeTableGeneratorDAO.getTimeTableGeneratorsByInstitution(institution);
            Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
            if (timeTableGeneratorListSize > 0) {
                for (TimeTableGenerator timeTableGenerator : timeTableGeneratorList) {
                    Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                    Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                    for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                        Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                        for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                            Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                        }
                    }
                }
                this.log.info((Object)("TimeTableGenerator with institution id=" + institutionId + " has been reterived"));
                return timeTableGeneratorList;
            }
            this.log.info((Object)("No TimeTableGenerator with institution id=" + institutionId + " is available"));
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by institution id=" + institutionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<TimeTableGenerator> timeTableGeneratorByTimeTableGeneratorDayAndTimeTableGeneratorHourEager(Set<TimeTableGeneratorDays> listtimeTableGeneratorDay, Set<TimeTableGeneratorHours> listtimeTableGeneratorHour) {
        try {
            LinkedHashSet<TimeTableGenerator> timeTableGenerator = new LinkedHashSet<TimeTableGenerator>();
            List timeTableGeneratorList = this.timeTableGeneratorDAO.getList();
            for (TimeTableGenerator timeTableGenerator1 : timeTableGeneratorList) {
                Hibernate.initialize(timeTableGenerator1.getTimeTableGeneratorDays());
                for (TimeTableGeneratorDays timeTableGeneratorDays : timeTableGenerator1.getTimeTableGeneratorDays()) {
                    Hibernate.initialize(timeTableGeneratorDays.getTimeTableGeneratorHours());
                    for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDays.getTimeTableGeneratorHours()) {
                        Hibernate.initialize((Object)timeTableGeneratorHours);
                        block5: for (TimeTableGeneratorDays timeTableGeneratorDaysObj : listtimeTableGeneratorDay) {
                            for (TimeTableGeneratorHours timeTableGeneratorHoursObj : listtimeTableGeneratorHour) {
                                if (timeTableGeneratorDaysObj == null || timeTableGeneratorDays == null || timeTableGeneratorHoursObj == null || timeTableGeneratorHours == null || !timeTableGeneratorDaysObj.getTimeTableGeneratorDayName().equals(timeTableGeneratorDays.getTimeTableGeneratorDayName()) || !timeTableGeneratorHoursObj.getHourTitle().equals(timeTableGeneratorHours.getHourTitle())) continue;
                                timeTableGenerator.add(timeTableGenerator1);
                                continue block5;
                            }
                        }
                    }
                }
            }
            return timeTableGenerator;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving TimeTableGenerator by ClassSection id=", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createAutomaticTimeTableGenerator(Set<TimeTableGenerator> timeTableGenerator, Set<TimeTableGeneratorDays> timeTableGeneratorDays, Set<TimeTableGeneratorHours> timeTableGeneratorHours) throws TimeTableGeneratorException {
        try {
            for (TimeTableGenerator timeTableGenerator1 : timeTableGenerator) {
                this.timeTableGeneratorDAO.persist(timeTableGenerator1);
            }
            for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGeneratorDays) {
                this.timeTableGeneratorDaysDAO.persist(timeTableGeneratorDay);
            }
            for (TimeTableGeneratorHours timeTableGeneratorHour : timeTableGeneratorHours) {
                this.timeTableGeneratorHoursDAO.persist(timeTableGeneratorHour);
            }
            this.log.info((Object)"TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours is created");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Adding TimeTableGenerator,TimeTableGeneratorDays,TimeTableGeneratorHours", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorList(Long institutionId, AcademicYear academicYear) throws TimeTableGeneratorException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<TimeTableGenerator> timeTableGeneratorList = this.timeTableGeneratorDAO.getTimeTableGeneratorsByInstitutionAndActiveAcademicYear(institution, academicYear);
            Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
            if (timeTableGeneratorListSize > 0) {
                for (TimeTableGenerator timeTableGenerator : timeTableGeneratorList) {
                    Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                    Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                    for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                        Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                        for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                            Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                        }
                    }
                }
                this.log.info((Object)("TimeTableGenerator with institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId() + " has been reterived"));
                return timeTableGeneratorList;
            }
            this.log.info((Object)("No TimeTableGenerator with institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId() + " is available"));
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId()), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TimeTableGenerator> timeTableGeneratorListEager(Long institutionId, AcademicYear academicYear) throws TimeTableGeneratorException {
        List<TimeTableGenerator> timeTableGeneratorList = null;
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (this.timeTableGeneratorDAO.getTimeTableGeneratorsByInstitutionAndActiveAcademicYear(institution, academicYear) != null) {
                timeTableGeneratorList = this.timeTableGeneratorDAO.getTimeTableGeneratorsByInstitutionAndActiveAcademicYear(institution, academicYear);
                Integer timeTableGeneratorListSize = timeTableGeneratorList.size();
                if (timeTableGeneratorListSize > 0) {
                    for (TimeTableGenerator timeTableGenerator : timeTableGeneratorList) {
                        Hibernate.initialize(timeTableGenerator.getTimeTableGeneratorDays());
                        Hibernate.initialize((Object)timeTableGenerator.getClassSection());
                        for (TimeTableGeneratorDays timeTableGeneratorDay : timeTableGenerator.getTimeTableGeneratorDays()) {
                            Hibernate.initialize(timeTableGeneratorDay.getTimeTableGeneratorHours());
                            for (TimeTableGeneratorHours timeTableGeneratorHours : timeTableGeneratorDay.getTimeTableGeneratorHours()) {
                                Hibernate.initialize((Object)timeTableGeneratorHours.getModule());
                            }
                        }
                    }
                    this.log.info((Object)("TimeTableGenerator with institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId() + " has been reterived"));
                    return timeTableGeneratorList;
                }
                this.log.info((Object)("No TimeTableGenerator with institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId() + " is available"));
                return timeTableGeneratorList;
            }
            return timeTableGeneratorList;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving TimeTableGenerator by institution id=" + institutionId + " and academicYear id=" + academicYear.getAcademicYearId()), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
