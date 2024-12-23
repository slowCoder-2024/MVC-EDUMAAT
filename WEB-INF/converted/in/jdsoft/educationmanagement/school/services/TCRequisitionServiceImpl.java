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
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalTaskDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.dao.TCRequisitionDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.TransferCertificateRequisitionException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.PortalTask;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.TCRequisitionService;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="tCRequisitionService")
public class TCRequisitionServiceImpl
implements TCRequisitionService {
    @Autowired
    TCRequisitionDAO TCRequisitionDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    PortalTaskDAO portalTaskDAO;
    @Autowired
    UserDAO userDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;

    @Override
    public Long createTCRequisition(TCRequisition tcRequisition) throws TransferCertificateRequisitionException {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(tcRequisition.getTcApprover());
            PortalTask portalTask = new PortalTask("TC Approvals", "TC Approvals", addUser, 1, "/staff/approvals", tcRequisition.getStudent().getEmail(), tcRequisition.getInstitution());
            PortalTask persistedPortalTask = this.portalTaskDAO.save(portalTask);
            tcRequisition.setPortalTask(persistedPortalTask);
            TCRequisition persistedTCRequisition = this.TCRequisitionDAO.save(tcRequisition);
            Long TCRequisitionId = persistedTCRequisition.getTransferCertificateRequisitionId();
            log.info((Object)("TCRequisition created with the id=" + TCRequisitionId));
            return TCRequisitionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating TCRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteTCRequisition(Long tcRequisitionId) throws TransferCertificateRequisitionException {
        try {
            TCRequisition TCRequisition2 = this.TCRequisitionDAO.getTCRequisitionById(tcRequisitionId);
            if (TCRequisition2 != null) {
                this.TCRequisitionDAO.delete(TCRequisition2);
                log.info((Object)("TCRequisition with id=" + tcRequisitionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting TCRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<TCRequisition> tcRequisitionList() throws TransferCertificateRequisitionException {
        try {
            List<TCRequisition> tcRequisitionList = this.TCRequisitionDAO.getList();
            Integer tcRequisitionListSize = tcRequisitionList.size();
            if (tcRequisitionListSize > 0) {
                log.info((Object)(tcRequisitionListSize + " TCRequisition records where reterived"));
            } else {
                log.info((Object)"No TCRequisition list available");
            }
            return tcRequisitionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving TCRequisition list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TCRequisition tcRequisitionById(Long tcRequisitionId) throws TransferCertificateRequisitionException {
        try {
            TCRequisition TCRequisition2 = this.TCRequisitionDAO.getTCRequisitionById(tcRequisitionId);
            if (TCRequisition2 != null) {
                log.info((Object)("TCRequisition with id=" + tcRequisitionId + " has been reterived"));
                return TCRequisition2;
            }
            log.info((Object)("No TCRequisition with  id=" + tcRequisitionId + " is available"));
            return TCRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TCRequisition by id=" + tcRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateTCRequisition(TCRequisition tcRequisition) throws TransferCertificateRequisitionException {
        try {
            this.TCRequisitionDAO.saveOrUpdate(tcRequisition);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(tcRequisition.getStudent().getParentUser());
            PortalTask portalTask = new PortalTask("TC " + tcRequisition.getApprovalStatus(), "TC " + tcRequisition.getApprovalStatus(), addUser, 1, "/student/transfercertificate/requisition", tcRequisition.getStudent().getParentGuardianEmail(), tcRequisition.getInstitution());
            this.portalTaskDAO.save(portalTask);
            Long TCRequisitionId = tcRequisition.getTransferCertificateRequisitionId();
            if (TCRequisitionId != null) {
                log.info((Object)("TCRequisition with id=" + TCRequisitionId + " has been updated"));
            } else {
                log.info((Object)"New TCRequisition has been added, because no TCRequisition found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating TCRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public TCRequisition tcRequisitionByIdEager(Long TCRequisitionId) throws TransferCertificateRequisitionException {
        try {
            TCRequisition TCRequisition2 = this.TCRequisitionDAO.getTCRequisitionById(TCRequisitionId);
            if (TCRequisition2 != null) {
                log.info((Object)("TCRequisition with id=" + TCRequisitionId + " has been reterived"));
                Hibernate.initialize((Object)TCRequisition2.getStudent());
                Hibernate.initialize((Object)TCRequisition2.getStudent().getInstitution());
                Hibernate.initialize((Object)TCRequisition2.getPortalTask());
                Hibernate.initialize((Object)TCRequisition2.getStudentClass());
                Hibernate.initialize((Object)TCRequisition2.getSection());
                Hibernate.initialize((Object)TCRequisition2.getAcademicYear());
                Hibernate.initialize((Object)TCRequisition2.getInstitution());
                return TCRequisition2;
            }
            log.info((Object)("No TCRequisition with  id=" + TCRequisitionId + " is available"));
            return TCRequisition2;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving TCRequisition by id=" + TCRequisitionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<TCRequisition> tcRequisitionListByStudentEmail(String studentEMail) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        Student student = this.studentDAO.getStudentByParentEmail(studentEMail);
        tcRequests.addAll(this.TCRequisitionDAO.getTCRequisitionListAndStatus(student, "Pending"));
        return tcRequests;
    }

    @Override
    public Set<TCRequisition> tcRequisitionListByTCApprover(String studentEMail) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        User user = this.userDAO.getUserByEmail(studentEMail);
        tcRequests.addAll(this.TCRequisitionDAO.getTCRequisitionListAndUserAndStatus(user, "Pending"));
        for (TCRequisition tcRequisition : tcRequests) {
            Hibernate.initialize((Object)tcRequisition.getStudent());
            Hibernate.initialize((Object)tcRequisition.getStudentClass());
            Hibernate.initialize((Object)tcRequisition.getSection());
            Hibernate.initialize((Object)tcRequisition.getInstitution());
            Hibernate.initialize((Object)tcRequisition.getAcademicYear());
        }
        return tcRequests;
    }

    @Override
    public void cancelTCRequisition(TCRequisition TCRequisition2) throws TransferCertificateRequisitionException {
        try {
            log.info((Object)("TCRequisition with id=" + TCRequisition2.getTransferCertificateRequisitionId() + " has been cancelled"));
            PortalTask portalTask = TCRequisition2.getPortalTask();
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            portalTask.setTargetUsers(addUser);
            this.portalTaskDAO.update(portalTask);
            this.TCRequisitionDAO.update(TCRequisition2);
        }
        catch (Exception e) {
            log.error((Object)"Exception in cancel TCRequisition", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Set<TCRequisition> tcRequestApprovedAndRejectedLists(String studentEMail) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        Student student = this.studentDAO.getStudentByParentEmail(studentEMail);
        tcRequests.addAll(this.TCRequisitionDAO.getTCRequisitionListAndStatus(student, "Approved"));
        tcRequests.addAll(this.TCRequisitionDAO.getTCRequisitionListAndStatus(student, "Rejected"));
        for (TCRequisition tcRequisition : tcRequests) {
            Hibernate.initialize((Object)tcRequisition.getStudent());
            Hibernate.initialize((Object)tcRequisition.getStudentClass());
            Hibernate.initialize((Object)tcRequisition.getSection());
            Hibernate.initialize((Object)tcRequisition.getInstitution());
            Hibernate.initialize((Object)tcRequisition.getAcademicYear());
        }
        return tcRequests;
    }

    @Override
    public Set<TCRequisition> tcRequisitionListByAcademicYearAndAllClass(Long academicYearId) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        if (this.TCRequisitionDAO.getTCRequisitionListAndAcademicYear(academicYear) != null) {
            for (TCRequisition tcRequisition : this.TCRequisitionDAO.getTCRequisitionListAndAcademicYear(academicYear)) {
                if (!tcRequisition.getApprovalStatus().equals("Approved")) continue;
                Hibernate.initialize((Object)tcRequisition.getStudent());
                Hibernate.initialize((Object)tcRequisition.getStudentClass());
                Hibernate.initialize((Object)tcRequisition.getSection());
                Hibernate.initialize((Object)tcRequisition.getInstitution());
                Hibernate.initialize((Object)tcRequisition.getAcademicYear());
                tcRequests.add(tcRequisition);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<TCRequisition> tcRequisitionListByAcademicYearAndClassAndSection(Long academicYearId, Long classId, Long sectionId) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        Class classs = this.classDAO.getClassById(classId);
        Section section = this.sectionDAO.getSectionById(sectionId);
        if (this.TCRequisitionDAO.getTCRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section) != null) {
            for (TCRequisition tcRequisition : this.TCRequisitionDAO.getTCRequisitionListAndAcademicYearAndClassAndSection(academicYear, classs, section)) {
                if (!tcRequisition.getApprovalStatus().equals("Approved")) continue;
                Hibernate.initialize((Object)tcRequisition.getStudent());
                Hibernate.initialize((Object)tcRequisition.getStudentClass());
                Hibernate.initialize((Object)tcRequisition.getSection());
                Hibernate.initialize((Object)tcRequisition.getInstitution());
                Hibernate.initialize((Object)tcRequisition.getAcademicYear());
                tcRequests.add(tcRequisition);
            }
        }
        return tcRequests;
    }

    @Override
    public Set<TCRequisition> tcRequisitionListByAcademicYearAndAdmissionNo(Long academicYearId, String admissionNo) throws TransferCertificateRequisitionException {
        LinkedHashSet<TCRequisition> tcRequests = new LinkedHashSet<TCRequisition>();
        AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
        if (this.TCRequisitionDAO.getTCRequisitionListAndAcademicYearAndAdmissionNumber(academicYear, admissionNo) != null) {
            for (TCRequisition tcRequisition : this.TCRequisitionDAO.getTCRequisitionListAndAcademicYearAndAdmissionNumber(academicYear, admissionNo)) {
                if (!tcRequisition.getApprovalStatus().equals("Approved")) continue;
                Hibernate.initialize((Object)tcRequisition.getStudent());
                Hibernate.initialize((Object)tcRequisition.getStudentClass());
                Hibernate.initialize((Object)tcRequisition.getSection());
                Hibernate.initialize((Object)tcRequisition.getInstitution());
                Hibernate.initialize((Object)tcRequisition.getAcademicYear());
                tcRequests.add(tcRequisition);
            }
        }
        return tcRequests;
    }
}
