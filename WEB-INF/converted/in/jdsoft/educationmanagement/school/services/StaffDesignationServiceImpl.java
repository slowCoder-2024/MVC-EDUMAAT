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
import in.jdsoft.educationmanagement.school.dao.StaffDesignationDAO;
import in.jdsoft.educationmanagement.school.dao.StaffTypeDAO;
import in.jdsoft.educationmanagement.school.exceptions.StaffDesignationException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.StaffDesignation;
import in.jdsoft.educationmanagement.school.model.StaffType;
import in.jdsoft.educationmanagement.school.services.StaffDesignationService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffDesignationService")
public class StaffDesignationServiceImpl
implements StaffDesignationService {
    @Autowired
    StaffDesignationDAO staffDesignationDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StaffTypeDAO staffTypeDAO;

    @Override
    public Long createStaffDesignation(StaffDesignation staffDesignation) {
        try {
            StaffDesignation persistedStaffDesignation = this.staffDesignationDAO.save(staffDesignation);
            Long staffDesignationId = persistedStaffDesignation.getStaffDesignationId();
            log.info((Object)("Staff Designation created with the id=" + staffDesignationId));
            return staffDesignationId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Staff Designation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffDesignation(Long staffDesignationId) {
        try {
            StaffDesignation staffDesignation = this.staffDesignationDAO.getStaffDesignationById(staffDesignationId);
            this.staffDesignationDAO.delete(staffDesignation);
            log.info((Object)("Staff Designation with id=" + staffDesignationId + " has been deleted successfully"));
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Staff Designation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffDesignation> staffDesignationList() {
        try {
            List<StaffDesignation> staffDesignationList = this.staffDesignationDAO.getList();
            Integer staffDesignationListSize = staffDesignationList.size();
            if (staffDesignationListSize > 0) {
                log.info((Object)(staffDesignationListSize + " staff designation records where reterived"));
            } else {
                log.info((Object)"No staff designation list available");
            }
            return staffDesignationList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving staff designation list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffDesignation> staffDesignationList(Long institutionId) throws StaffDesignationException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<StaffDesignation> staffDesignations = this.staffDesignationDAO.getStaffDesignationByInstitution(institution);
                Integer staffDesignationRecordsSize = staffDesignations.size();
                if (staffDesignationRecordsSize > 0) {
                    log.info((Object)(staffDesignationRecordsSize + " staff designation records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No staff designation Records found for institution " + institution.getInstitutionAliasName()));
                }
                return staffDesignations;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffDesignationException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reterivings taff designation of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffDesignation> staffDesignationList(Long institutionId, Long staffTypeId) throws StaffDesignationException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            StaffType staffType = this.staffTypeDAO.getStaffTypeById(staffTypeId);
            if (institution != null) {
                if (staffType != null) {
                    List<StaffDesignation> staffDesignations = this.staffDesignationDAO.getStaffDesignationByInstitutionAndStaffType(institution, staffType);
                    Integer staffDesignationRecordsSize = staffDesignations.size();
                    if (staffDesignationRecordsSize > 0) {
                        log.info((Object)(staffDesignationRecordsSize + " staff designation records of staff type in institution " + institution.getInstitutionAliasName() + " where reterived"));
                    } else {
                        log.info((Object)("No staff designation Records found for the staff type in institution " + institution.getInstitutionAliasName()));
                    }
                    return staffDesignations;
                }
                throw new NullPointerException("Invalid staff Type Id");
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffDesignationException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving staff designation of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffDesignation staffDesignationById(Long staffDesignationId) {
        try {
            StaffDesignation staffDesignation = this.staffDesignationDAO.getStaffDesignationById(staffDesignationId);
            if (staffDesignation != null) {
                log.info((Object)("Staff designation with id=" + staffDesignationId + " has been reterived"));
                return staffDesignation;
            }
            log.info((Object)("No Staff designation with  id=" + staffDesignationId + " is available"));
            return staffDesignation;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff designation by id=" + staffDesignationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffDesignation(StaffDesignation staffDesignation) {
        try {
            this.staffDesignationDAO.saveOrUpdate(staffDesignation);
            Long staffDesignationId = staffDesignation.getStaffDesignationId();
            if (staffDesignationId != null) {
                log.info((Object)("Staff Designation with id=" + staffDesignationId + " has been updated"));
            } else {
                log.info((Object)"New Staff Designation has been added, because no staff designation found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating Staff Designation", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffDesignation> staffDesignationListEager(Long institutionId) throws StaffDesignationException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<StaffDesignation> staffDesignations = this.staffDesignationDAO.getStaffDesignationByInstitution(institution);
                Integer staffDesignationRecordsSize = staffDesignations.size();
                if (staffDesignationRecordsSize > 0) {
                    for (StaffDesignation staffDesignation : staffDesignations) {
                        Hibernate.initialize(staffDesignation.getStaffs());
                        Hibernate.initialize((Object)staffDesignation.getStaffType());
                    }
                    log.info((Object)(staffDesignationRecordsSize + " staff designation records of institution " + institution.getInstitutionAliasName() + " where reterived with childs"));
                } else {
                    log.info((Object)("No staff designation and its child Records found for institution " + institution.getInstitutionAliasName()));
                }
                return staffDesignations;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new StaffDesignationException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reterivings taff designation of Institution with childs", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffDesignation staffDesignationByIdEager(Long staffDesignationId) {
        try {
            StaffDesignation staffDesignation = this.staffDesignationDAO.getStaffDesignationById(staffDesignationId);
            if (staffDesignation != null) {
                log.info((Object)("Staff designation with id=" + staffDesignationId + " has been reterived"));
                Hibernate.initialize(staffDesignation.getStaffs());
                Hibernate.initialize((Object)staffDesignation.getStaffType());
                return staffDesignation;
            }
            log.info((Object)("No Staff designation with  id=" + staffDesignationId + " is available"));
            return staffDesignation;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving staff designation by id=" + staffDesignationId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
