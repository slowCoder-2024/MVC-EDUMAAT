/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.AcademicYearException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.AcademicYearService;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="academicYearService")
public class AcademicYearServiceImpl
implements AcademicYearService {
    @Autowired
    private AcademicYearDAO academicYearDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public Long createAcademicYear(AcademicYear academicYear) throws AcademicYearException {
        try {
            if (academicYear.getAcademicYearStatus() == 1) {
                if (this.institutionCurrentAcademicYear(academicYear.getInstitution().getInstitutionId()) != null) {
                    throw new AcademicYearException(new Message("alert", "Already Active Academic Year Exist,Close it or save this with closed status"));
                }
                AcademicYear persistedacademicYear = this.academicYearDAO.save(academicYear);
                Long academicYearId = persistedacademicYear.getAcademicYearId();
                log.info((Object)("AcademicYear is created with the id=" + academicYearId));
                return academicYearId;
            }
            AcademicYear persistedacademicYear = this.academicYearDAO.save(academicYear);
            Long academicYearId = persistedacademicYear.getAcademicYearId();
            log.info((Object)("AcademicYear is created with the id=" + academicYearId));
            return academicYearId;
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                throw new AcademicYearException(new Message("alert", "Cannot Create Duplicate Academic Year Title"));
            }
            log.error((Object)"Exception in Creating AcademicYear", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAcademicYear(Long academicYearId) {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            if (academicYear != null) {
                this.academicYearDAO.delete(academicYear);
                log.info((Object)("AcademicYear with id=" + academicYearId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting AcademicYear", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<AcademicYear> academicYearList() {
        try {
            List<AcademicYear> academicYearList = this.academicYearDAO.getList();
            Integer listSize = academicYearList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + " academicYear records where reterived"));
            } else {
                log.info((Object)"No academicYear(s) available");
            }
            return academicYearList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving academicYear list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AcademicYear academicYearById(Long academicYearId) {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            if (academicYear != null) {
                log.info((Object)("academicYear with id=" + academicYearId + " has been reterived"));
                return academicYear;
            }
            log.info((Object)("No academicYear with  id=" + academicYearId + " is available"));
            return academicYear;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving academicYear by id=" + academicYearId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateAcademicYear(AcademicYear academicYear) throws Exception {
        try {
            if (academicYear.getAcademicYearStatus() == 1) {
                AcademicYear currentAcademic = this.institutionCurrentAcademicYear(academicYear.getInstitution().getInstitutionId());
                if (currentAcademic != null) {
                    if (currentAcademic.getAcademicYearId() != academicYear.getAcademicYearId()) {
                        Message message = new Message("alert", "Already Active Academic Year Exist,Close it then update this");
                        throw new AcademicYearException(message);
                    }
                    if (currentAcademic.getAcademicYearStatus() == 0) {
                        Message message = new Message("alert", "Closed Acdemic Year Cannot Be Made Active");
                        throw new AcademicYearException(message);
                    }
                    currentAcademic.setAcademicYearStatus(academicYear.getAcademicYearStatus());
                    currentAcademic.setAcademicYearTitle(academicYear.getAcademicYearTitle());
                    currentAcademic.setTotalWorkingDays(academicYear.getTotalWorkingDays());
                    this.academicYearDAO.update(currentAcademic);
                } else {
                    AcademicYear currentAcademic1 = this.academicYearById(academicYear.getAcademicYearId());
                    currentAcademic1.setAcademicYearStatus(academicYear.getAcademicYearStatus());
                    currentAcademic1.setAcademicYearTitle(academicYear.getAcademicYearTitle());
                    currentAcademic1.setTotalWorkingDays(academicYear.getTotalWorkingDays());
                    this.academicYearDAO.update(currentAcademic1);
                }
            } else {
                log.info((Object)("academicYear with id=" + academicYear.getAcademicYearId() + " has been updated"));
                this.academicYearDAO.saveOrUpdate(academicYear);
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating academicYear", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<AcademicYear> academicYearList(Long institutionId) throws AcademicYearException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<AcademicYear> academicYears = this.academicYearDAO.getAcademicYearByInstitution(institution);
                Integer academicYearRecordSize = academicYears.size();
                if (academicYearRecordSize > 0) {
                    log.info((Object)(academicYearRecordSize + " academicYear records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No academicYear Records found for institution " + institution.getInstitutionAliasName()));
                }
                return academicYears;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new AcademicYearException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving academicYears of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AcademicYear institutionCurrentAcademicYear(Long institutionId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Hibernate.initialize(institution.getAcademicYears());
        Set<AcademicYear> institutionAcademicYears = institution.getAcademicYears();
        Iterator<AcademicYear> iterator = institutionAcademicYears.iterator();
        AcademicYear academicYear = null;
        while (iterator.hasNext()) {
            academicYear = iterator.next();
            if (academicYear.getAcademicYearStatus() == 1) break;
            academicYear = null;
        }
        return academicYear;
    }

    @Override
    public AcademicYear getActiveAcademicYear() {
        AcademicYear academicYear = null;
        try {
            academicYear = this.academicYearDAO.getActiveAcademicYear();
            if (academicYear != null) {
                Long academicYearId = academicYear.getAcademicYearId();
                log.info((Object)("Active academicYear with id=" + academicYearId + " has been reterived"));
                return academicYear;
            }
            log.info((Object)"No Active Academic Year Found");
            return academicYear;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving Active Academic Year", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public AcademicYear getActiveAcademicYearOfdInstitution(Long institutionId) {
        AcademicYear academicYear = null;
        try {
            academicYear = this.academicYearDAO.getActiveAcademicYear(this.institutionDAO.getInstitutionById(institutionId));
            if (academicYear != null) {
                Long academicYearId = academicYear.getAcademicYearId();
                log.info((Object)("Active academicYear with id=" + academicYearId + " has been reterived"));
                return academicYear;
            }
            log.info((Object)"No Active Academic Year Found");
            return academicYear;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving Active Academic Year", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
