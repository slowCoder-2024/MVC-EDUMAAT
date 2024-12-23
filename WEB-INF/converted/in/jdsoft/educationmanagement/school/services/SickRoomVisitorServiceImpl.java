/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SickRoomVisitorDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.exceptions.SickRoomVisitorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.services.SickRoomVisitorService;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="sickRoomVisitorService")
public class SickRoomVisitorServiceImpl
implements SickRoomVisitorService {
    @Autowired
    SickRoomVisitorDAO sickRoomVisitorDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;

    @Override
    public Long createSickRoomVisitor(SickRoomVisitor sickRoomVisitor) throws SickRoomVisitorException {
        try {
            SickRoomVisitor persistedSickRoomVisitor = this.sickRoomVisitorDAO.save(sickRoomVisitor);
            Long SickRoomVisitorId = persistedSickRoomVisitor.getSickRoomVisitorId();
            log.info((Object)("SickRoomVisitor created with the id=" + SickRoomVisitorId));
            return SickRoomVisitorId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating SickRoomVisitor", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteSickRoomVisitor(Long sickRoomVisitorId) throws SickRoomVisitorException {
        try {
            SickRoomVisitor SickRoomVisitor2 = this.sickRoomVisitorDAO.getSickRoomVisitorById(sickRoomVisitorId);
            if (SickRoomVisitor2 != null) {
                this.sickRoomVisitorDAO.delete(SickRoomVisitor2);
                log.info((Object)("SickRoomVisitor with id=" + sickRoomVisitorId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting SickRoomVisitor", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorList() throws SickRoomVisitorException {
        try {
            List<SickRoomVisitor> SickRoomVisitorList = this.sickRoomVisitorDAO.getList();
            Integer SickRoomVisitorListSize = SickRoomVisitorList.size();
            if (SickRoomVisitorListSize > 0) {
                log.info((Object)(SickRoomVisitorListSize + " SickRoomVisitor records where reterived"));
            } else {
                log.info((Object)"No SickRoomVisitor list available");
            }
            return SickRoomVisitorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SickRoomVisitor list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SickRoomVisitor sickRoomVisitorById(Long sickRoomVisitorId) throws SickRoomVisitorException {
        try {
            SickRoomVisitor SickRoomVisitor2 = this.sickRoomVisitorDAO.getSickRoomVisitorById(sickRoomVisitorId);
            if (SickRoomVisitor2 != null) {
                log.info((Object)("SickRoomVisitor with id=" + sickRoomVisitorId + " has been reterived"));
                return SickRoomVisitor2;
            }
            log.info((Object)("No SickRoomVisitor with  id=" + sickRoomVisitorId + " is available"));
            return SickRoomVisitor2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving SickRoomVisitor by id=" + sickRoomVisitorId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSickRoomVisitor(SickRoomVisitor sickRoomVisitor) throws SickRoomVisitorException {
        try {
            this.sickRoomVisitorDAO.saveOrUpdate(sickRoomVisitor);
            Long SickRoomVisitorId = sickRoomVisitor.getSickRoomVisitorId();
            if (SickRoomVisitorId != null) {
                log.info((Object)("SickRoomVisitor with id=" + SickRoomVisitorId + " has been updated"));
            } else {
                log.info((Object)"New SickRoomVisitor has been added, because no SickRoomVisitor found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating SickRoomVisitor", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SickRoomVisitor sickRoomVisitorByIdEager(Long sickRoomVisitorId) throws SickRoomVisitorException {
        try {
            SickRoomVisitor SickRoomVisitor2 = this.sickRoomVisitorDAO.getSickRoomVisitorById(sickRoomVisitorId);
            if (SickRoomVisitor2 != null) {
                log.info((Object)("SickRoomVisitor with id=" + sickRoomVisitorId + " has been reterived"));
                return SickRoomVisitor2;
            }
            log.info((Object)("No SickRoomVisitor with  id=" + sickRoomVisitorId + " is available"));
            return SickRoomVisitor2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving SickRoomVisitor by id=" + sickRoomVisitorId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<SickRoomVisitor> sickRoomVisitorListByStaffEmail(String staffEMail) throws SickRoomVisitorException {
        try {
            LinkedHashSet<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>();
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByStaff(staff));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<SickRoomVisitor> sickRoomVisitorListByStudentEmail(String studentEMail) throws SickRoomVisitorException {
        try {
            LinkedHashSet<SickRoomVisitor> sickRoomVisitors = new LinkedHashSet<SickRoomVisitor>();
            Student student = this.studentDAO.getStudentByEmail(studentEMail);
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByStudent(student));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByStudentAndAcademicYearAndIsititution(Student student, AcademicYear academicYear, Institution institution) throws SickRoomVisitorException {
        try {
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByStudentAndAcademicYearAndInstitution(student, academicYear, institution));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByStaffAndAcademicYearAndIsititution(Staff staff, AcademicYear academicYear, Institution institution) throws SickRoomVisitorException {
        try {
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByStaffAndAcademicYearAndInstitution(staff, academicYear, institution));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByInstitution(Long institutionId) throws SickRoomVisitorException {
        try {
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByInstitution(institution));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByInstitutionAndAcademicYear(Long institutionId, Long academicYearId) throws SickRoomVisitorException {
        try {
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            sickRoomVisitors.addAll(this.sickRoomVisitorDAO.getSickRoomVisitorByAcademicYearAndInstitution(academicYear, institution));
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListEager() throws SickRoomVisitorException {
        try {
            List<SickRoomVisitor> SickRoomVisitorList = this.sickRoomVisitorDAO.getList();
            Integer SickRoomVisitorListSize = SickRoomVisitorList.size();
            if (SickRoomVisitorListSize > 0) {
                for (SickRoomVisitor sickRoomVisitor : SickRoomVisitorList) {
                    Hibernate.initialize((Object)sickRoomVisitor.getAcademicYear());
                    Hibernate.initialize((Object)sickRoomVisitor.getInstitution());
                    Hibernate.initialize((Object)sickRoomVisitor.getStaff());
                    Hibernate.initialize((Object)sickRoomVisitor.getStudent());
                }
                log.info((Object)(SickRoomVisitorListSize + " SickRoomVisitor records where reterived"));
            } else {
                log.info((Object)"No SickRoomVisitor list available");
            }
            return SickRoomVisitorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SickRoomVisitor list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByStudentEmailAndAcademicYear(String studentEMail, Long academicYearId) throws SickRoomVisitorException {
        try {
            Student student = this.studentDAO.getStudentByEmail(studentEMail);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            for (SickRoomVisitor sickRoomVisitor : this.sickRoomVisitorDAO.getSickRoomVisitorByStudentAndAcademicYear(student, academicYear)) {
                if (student != null) {
                    Hibernate.initialize((Object)sickRoomVisitor.getAcademicYear());
                    Hibernate.initialize((Object)sickRoomVisitor.getInstitution());
                    Hibernate.initialize((Object)sickRoomVisitor.getStudent());
                }
                sickRoomVisitors.add(sickRoomVisitor);
            }
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SickRoomVisitor> sickRoomVisitorListByStaffEmailAndAcademicYear(String staffEMail, Long academicYearId) throws SickRoomVisitorException {
        try {
            Staff staff = this.staffDAO.getStaffByStaffEmail(staffEMail);
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            ArrayList<SickRoomVisitor> sickRoomVisitors = new ArrayList<SickRoomVisitor>();
            for (SickRoomVisitor sickRoomVisitor : this.sickRoomVisitorDAO.getSickRoomVisitorByStaffAndAcademicYear(staff, academicYear)) {
                if (staff != null) {
                    Hibernate.initialize((Object)sickRoomVisitor.getAcademicYear());
                    Hibernate.initialize((Object)sickRoomVisitor.getInstitution());
                    Hibernate.initialize((Object)sickRoomVisitor.getStaff());
                }
                sickRoomVisitors.add(sickRoomVisitor);
            }
            return sickRoomVisitors;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
