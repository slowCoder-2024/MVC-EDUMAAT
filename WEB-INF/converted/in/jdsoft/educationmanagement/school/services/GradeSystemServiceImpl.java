/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.ExceptionComparator;
import in.jdsoft.educationmanagement.school.dao.GradeSystemDAO;
import in.jdsoft.educationmanagement.school.dao.GradeSystemDetailDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.exceptions.GradeSystemException;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.services.GradeSystemService;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="gradeSystemService")
public class GradeSystemServiceImpl
implements GradeSystemService {
    @Autowired
    GradeSystemDAO gradeSystemDAO;
    @Autowired
    GradeSystemDetailDAO gradeSystemDetailDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    ExceptionComparator exceptionComparator;
    private Logger log = LogManager.getLogger((String)GradeSystemServiceImpl.class.getName());

    @Override
    @Transactional(rollbackFor={GradeSystemException.class})
    public void createGradeSystem(GradeSystem gradeSystem, Set<GradeSystemDetail> gradeSystemDetails) throws GradeSystemException {
        try {
            this.gradeSystemDAO.persist(gradeSystem);
            for (GradeSystemDetail gradeSystemDetail : gradeSystemDetails) {
                this.gradeSystemDetailDAO.persist(gradeSystemDetail);
            }
            this.log.info((Object)"GradeSystem,GradeSystemDetail is created");
        }
        catch (Exception e) {
            if (e.getClass().equals(ConstraintViolationException.class)) {
                String valid = this.exceptionComparator.containsWord(e.getMessage());
                if (valid != null) {
                    throw new GradeSystemException(new Message("duplicate", "Cannot Create Duplicate " + valid));
                }
                throw e;
            }
            throw e;
        }
    }

    @Override
    public void updateGradeSystem(GradeSystem gradeSystem, Set<GradeSystemDetail> gradeSystemDetails) throws GradeSystemException {
        try {
            this.gradeSystemDAO.saveOrUpdate(gradeSystem);
            for (GradeSystemDetail gradeSystemDetail : gradeSystemDetails) {
                this.gradeSystemDetailDAO.saveOrUpdate(gradeSystemDetail);
            }
            this.log.info((Object)"GradeSystem,GradeSystemDetail is updated");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Updating GradeSystem,GradeSystemDetail", e.getCause());
            throw e;
        }
    }

    @Override
    public void deleteGradeSystem(Long GradeSystemId) throws GradeSystemException {
        try {
            this.gradeSystemDAO.delete(this.gradeSystemDAO.getGradeSystemById(GradeSystemId));
            this.log.info((Object)"GradeSystem,GradeSystemDetail is deleted");
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in Deleting GradeSystem,GradeSystemDetail", e.getCause());
            throw e;
        }
    }

    @Override
    public GradeSystem gradeSystemById(Long gradeSystemId) {
        try {
            GradeSystem gradeSystem = this.gradeSystemDAO.getGradeSystemById(gradeSystemId);
            if (gradeSystem != null) {
                this.log.info((Object)("GradeSystem with id=" + gradeSystemId + " has been reterived"));
                return gradeSystem;
            }
            this.log.info((Object)("No GradeSystem with  id=" + gradeSystemId + " is available"));
            return gradeSystem;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving GradeSystem by id=" + gradeSystemId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GradeSystem> gradeSystemList(Long institutionId) throws GradeSystemException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<GradeSystem> gradeSystems = this.gradeSystemDAO.getGradeSystemsByInstitution(institution);
                Integer gradeSystemRecordSize = gradeSystems.size();
                if (gradeSystemRecordSize > 0) {
                    this.log.info((Object)(gradeSystemRecordSize + " GradeSystem records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No GradeSystem Records found for institution " + institution.getInstitutionAliasName()));
                }
                return gradeSystems;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new GradeSystemException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving GradeSystems of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public GradeSystem gradeSystemIdByEager(Long gradeSystemId) {
        try {
            GradeSystem gradeSystem = this.gradeSystemDAO.getGradeSystemById(gradeSystemId);
            if (gradeSystem != null) {
                Hibernate.initialize(gradeSystem.getGradeSystemDetails());
                this.log.info((Object)("GradeSystem with id=" + gradeSystemId + " has been retrieved"));
                return gradeSystem;
            }
            this.log.info((Object)("No GradeSystem with  id=" + gradeSystemId + " is available"));
            return gradeSystem;
        }
        catch (Exception e) {
            this.log.error((Object)("Exception in retrieving GradeSystem by id=" + gradeSystemId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GradeSystem> gradeSystemListEager(Long institutionId) throws GradeSystemException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<GradeSystem> gradeSystems = this.gradeSystemDAO.getGradeSystemsByInstitution(institution);
                for (GradeSystem gradeSystem : gradeSystems) {
                    Hibernate.initialize(gradeSystem.getGradeSystemDetails());
                }
                Integer gradeSystemRecordSize = gradeSystems.size();
                if (gradeSystemRecordSize > 0) {
                    this.log.info((Object)(gradeSystemRecordSize + " GradeSystem records of institution " + institution.getInstitutionAliasName() + " where retrieved"));
                } else {
                    this.log.info((Object)("No GradeSystem Records found for institution " + institution.getInstitutionAliasName()));
                }
                return gradeSystems;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                this.log.error((Object)"NullPointerException", e.getCause());
                throw new GradeSystemException(new Message("nullpointer", e.getMessage()));
            }
            this.log.error((Object)"Exception in retrieving GradeSystems of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<GradeSystem> gradeSystemList() {
        try {
            List<GradeSystem> gradeSystemList = this.gradeSystemDAO.getList();
            Integer gradeSystemListSize = gradeSystemList.size();
            if (gradeSystemListSize > 0) {
                this.log.info((Object)(gradeSystemListSize + " GradeSystem records where retrieved"));
            } else {
                this.log.info((Object)"No GradeSystem list available");
            }
            return gradeSystemList;
        }
        catch (Exception e) {
            this.log.error((Object)"Exception in retrieving GradeSystem list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
