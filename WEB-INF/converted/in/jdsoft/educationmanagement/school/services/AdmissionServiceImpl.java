/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.poi.hssf.usermodel.HSSFRow
 *  org.apache.poi.hssf.usermodel.HSSFSheet
 *  org.apache.poi.hssf.usermodel.HSSFWorkbook
 *  org.apache.poi.ss.usermodel.Cell
 *  org.apache.poi.ss.usermodel.DataFormatter
 *  org.hibernate.Hibernate
 *  org.hibernate.exception.ConstraintViolationException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.mail.MailSendException
 *  org.springframework.stereotype.Service
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.dao.AdmissionConfigDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionDocumentDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionDocumentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionEducationLevelDetailsDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionEducationLevelSubjectsDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionProcessStatusDAO;
import in.jdsoft.educationmanagement.school.dao.AdmissionStatusDAO;
import in.jdsoft.educationmanagement.school.dao.CategoryDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.CommunicationNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.EducationLevelDAO;
import in.jdsoft.educationmanagement.school.dao.GeographicalLocationDAO;
import in.jdsoft.educationmanagement.school.dao.HearedUsDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.PortalNotificationDAO;
import in.jdsoft.educationmanagement.school.dao.ReligionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.SponserDAO;
import in.jdsoft.educationmanagement.school.dao.UserDAO;
import in.jdsoft.educationmanagement.school.exceptions.AdmissionException;
import in.jdsoft.educationmanagement.school.exceptions.AdmissionProcessServiceException;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionConfig;
import in.jdsoft.educationmanagement.school.model.AdmissionDocument;
import in.jdsoft.educationmanagement.school.model.AdmissionDocumentTypes;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelDetails;
import in.jdsoft.educationmanagement.school.model.AdmissionEducationLevelSubjects;
import in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.school.model.AdmissionStatus;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.CommunicationMessageMode;
import in.jdsoft.educationmanagement.school.model.CommunicationNotification;
import in.jdsoft.educationmanagement.school.model.CommunicationTargetGroup;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import in.jdsoft.educationmanagement.school.model.GeographicalLocation;
import in.jdsoft.educationmanagement.school.model.HearedUs;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.PortalNotification;
import in.jdsoft.educationmanagement.school.model.Religion;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Sponser;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.AdmissionService;
import in.jdsoft.educationmanagement.school.services.CommunicationMessageModeService;
import in.jdsoft.educationmanagement.school.services.CommunicationTargetGroupService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.hibernate.Hibernate;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service(value="admissionService")
public class AdmissionServiceImpl
implements AdmissionService {
    @Autowired
    private AdmissionDAO admissionDAO;
    @Autowired
    private AdmissionConfigDAO admissionConfigDAO;
    @Autowired
    private AdmissionProcessStatusDAO admissionProcessStatusDAO;
    @Autowired
    private AdmissionDocumentTypeDAO admissionDocumentTypeDAO;
    @Autowired
    private AdmissionStatusDAO admissionStatusDAO;
    @Autowired
    private ClassDAO classDAO;
    @Autowired
    private ReligionDAO religionDAO;
    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private SpecialCategoryDAO specialCategoryDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private GeographicalLocationDAO geographicalLocationDAO;
    @Autowired
    private InstitutionDAO institutionDAO;
    @Autowired
    private PortalNotificationDAO portalNotificationDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private AdmissionEducationLevelDetailsDAO admissionEducationLevelDetailsDAO;
    @Autowired
    private AdmissionEducationLevelSubjectsDAO admissionEducationLevelSubjectsDAO;
    @Autowired
    private AdmissionDocumentDAO admissionDocumentDAO;
    @Autowired
    private CommunicationMessageModeService communicationMessageModeService;
    @Autowired
    private CommunicationTargetGroupService communicationTargetGroupService;
    @Autowired
    private CommunicationNotificationDAO communicationNotificationDAO;
    @Autowired
    private EducationLevelDAO educationLevelDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private SponserDAO sponserDAO;
    @Autowired
    private HearedUsDAO hearedUsDAO;

    @Override
    public void createAdmission(Admission admission, Set<AdmissionEducationLevelDetails> admissionEducationLevelDetails, Set<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects, Set<AdmissionDocument> admissionDocuments) {
        Admission persistdAdmission = this.admissionDAO.save(admission);
        for (AdmissionEducationLevelDetails admissionEducationLevelDetails2 : admissionEducationLevelDetails) {
            admissionEducationLevelDetails2.setAdmission(persistdAdmission);
            AdmissionEducationLevelDetails persistedAdmissionEducationLevelDetails = this.admissionEducationLevelDetailsDAO.save(admissionEducationLevelDetails2);
            for (AdmissionEducationLevelSubjects admissionEducationLevelSubjects2 : admissionEducationLevelSubjects) {
                admissionEducationLevelSubjects2.setAdmissionEducationLevelDetail(persistedAdmissionEducationLevelDetails);
                this.admissionEducationLevelSubjectsDAO.save(admissionEducationLevelSubjects2);
            }
        }
        for (AdmissionDocument admissionDocument : admissionDocuments) {
            admissionDocument.setAdmission(persistdAdmission);
            this.admissionDocumentDAO.save(admissionDocument);
        }
    }

    @Override
    public void addAdmission(Admission admission) {
        this.admissionDAO.persist(admission);
    }

    @Override
    public void updateAdmission(Admission admission) {
        this.admissionDAO.update(admission);
    }

    @Override
    public void intimateApplicationStatus(Admission admission, User createdUser) throws Exception {
        try {
            this.admissionDAO.update(admission);
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            addUser.add(admission.getUser());
            PortalNotification portalNotification = new PortalNotification("Application Status Updated", "Application Status Updated", addUser, 1, "/admissions/candidate/applyforadmission", createdUser.getEmail(), createdUser.getInstitution());
            PortalNotification persistedPortalNotification = this.portalNotificationDAO.save(portalNotification);
            this.portalNotificationDAO.persist(portalNotification);
            Long messageModeId = 1L;
            CommunicationMessageMode communicationMessageMode = this.communicationMessageModeService.communicationMessageModeById(messageModeId);
            Long targetGroupId = 9L;
            CommunicationTargetGroup communicationTargetGroup = this.communicationTargetGroupService.communicationTargetGroupById(targetGroupId);
            CommunicationNotification communicationNotification = new CommunicationNotification("Application Status Updated", "You are selected", createdUser.getEmail(), 1, communicationTargetGroup, communicationMessageMode, addUser, createdUser.getInstitution());
            communicationNotification.setPortalNotification(persistedPortalNotification);
            this.communicationNotificationDAO.save(communicationNotification);
            this.emailHandler.sendEmail(admission.getCandidateEmail(), "Application Status", "you are selected");
        }
        catch (Exception e) {
            if (e.getClass().equals(MailSendException.class)) {
                throw new AdmissionException(new Message("failure", "No Internet Connnetion Found..! Please Check The Connection..!"));
            }
            throw e;
        }
    }

    @Override
    public void deleteAdmission(Long admissionId) {
        this.admissionDAO.delete(this.admissionDAO.getAdmissionById(admissionId));
    }

    @Override
    public Admission getAdmissionDetailsById(Long admissionId) throws AdmissionProcessServiceException {
        try {
            Admission admission = this.admissionDAO.getAdmissionById(admissionId);
            Hibernate.initialize((Object)admission.getUser());
            return admission;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new AdmissionProcessServiceException(new Message("failure", "Invalid Admission Number"));
            }
            throw e;
        }
    }

    @Override
    public Admission getAdmissionDetailsLazyById(Long admissionId) throws AdmissionProcessServiceException {
        try {
            Admission admission = this.admissionDAO.getAdmissionById(admissionId);
            Hibernate.initialize((Object)admission.getClassz());
            Hibernate.initialize((Object)admission.getAdmissionStatus());
            Hibernate.initialize((Object)admission.getReligion());
            Hibernate.initialize((Object)admission.getSponser());
            Hibernate.initialize((Object)admission.getCategory());
            Hibernate.initialize((Object)admission.getSpecialCategory());
            Hibernate.initialize((Object)admission.getHearedUs());
            Hibernate.initialize((Object)admission.getUser());
            Hibernate.initialize(admission.getAdmissionAcademicsDetails());
            Hibernate.initialize(admission.getAdmissionDocuments());
            Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
            Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
            Hibernate.initialize((Object)admission.getAdmissionConfig());
            Hibernate.initialize((Object)admission.getStudent());
            Hibernate.initialize((Object)admission.getEducationLevel());
            return admission;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new AdmissionProcessServiceException(new Message("failure", "Invalid Admission Number"));
            }
            throw e;
        }
    }

    @Override
    public Admission editAdmissionApplication(Long admissionId) {
        try {
            Admission admission = this.admissionDAO.getAdmissionById(admissionId);
            Hibernate.initialize((Object)admission.getClassz());
            Hibernate.initialize((Object)admission.getAdmissionConfig());
            Hibernate.initialize((Object)admission.getAdmissionStatus());
            Hibernate.initialize((Object)admission.getReligion());
            Hibernate.initialize((Object)admission.getSponser());
            Hibernate.initialize((Object)admission.getCategory());
            Hibernate.initialize((Object)admission.getSpecialCategory());
            Hibernate.initialize((Object)admission.getHearedUs());
            Hibernate.initialize((Object)admission.getUser());
            Hibernate.initialize(admission.getAdmissionDocuments());
            Hibernate.initialize(admission.getAdmissionAcademicsDetails());
            for (AdmissionEducationLevelDetails admissionEducationLevelDetails : admission.getAdmissionAcademicsDetails()) {
                Hibernate.initialize((Object)admissionEducationLevelDetails.getEducationLevel());
                Hibernate.initialize(admissionEducationLevelDetails.getAdmissionEducationLevelSubjects());
            }
            return admission;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Admission getFullAdmissionDetails(Long admissionId) throws Exception {
        try {
            Admission admission = this.admissionDAO.getAdmissionById(admissionId);
            if (admission.getAdmissionStatus().getAdmissionStatusTitle().equals(this.admissionStatusDAO.getAdmissionStatusById(4L).getAdmissionStatusTitle())) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                return admission;
            }
            throw new Exception("Invalid admission id");
        }
        catch (Exception e) {
            throw new Exception("Admission id not found");
        }
    }

    @Override
    public Admission getFullAdmissionDetailsByApplicantCode(String applicantCode) throws Exception {
        try {
            Admission admission = this.admissionDAO.getApplicantByApplicantCode(applicantCode);
            if (admission.getAdmissionStatus().getAdmissionStatusTitle().equals(this.admissionStatusDAO.getAdmissionStatusById(4L).getAdmissionStatusTitle()) || admission.getAdmissionStatus().getAdmissionStatusTitle().equals(this.admissionStatusDAO.getAdmissionStatusById(5L).getAdmissionStatusTitle())) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getAdmissionStatus());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                Hibernate.initialize((Object)admission.getHearedUs());
                Hibernate.initialize(admission.getUser().getCommunicationFeedBackAndOthers());
                Hibernate.initialize(admission.getUser().getCommunicationFeedBackAndOthersArchives());
                Hibernate.initialize(admission.getUser().getCommunicationFeedBackAndOthersHistory());
                Hibernate.initialize(admission.getUser().getCommunicationNotificationArchives());
                Hibernate.initialize(admission.getUser().getCommunicationNotifications());
                Hibernate.initialize(admission.getUser().getPortalMessages());
                Hibernate.initialize(admission.getUser().getPortalNotifications());
                Hibernate.initialize(admission.getUser().getPortalReplyMessages());
                Hibernate.initialize(admission.getUser().getPortalTasks());
                Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                Hibernate.initialize(admission.getAdmissionDocuments());
                Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                Hibernate.initialize((Object)admission.getAdmissionConfig());
                Hibernate.initialize((Object)admission.getStudent());
                Hibernate.initialize((Object)admission.getEducationLevel());
                return admission;
            }
            return null;
        }
        catch (Exception e) {
            throw new Exception("Admission id not found");
        }
    }

    @Override
    public ArrayList<Admission> getAdmissionsList() throws Exception, AdmissionProcessServiceException {
        try {
            return (ArrayList)this.admissionDAO.getList();
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new AdmissionProcessServiceException(new Message("failure", "No Data Found"));
            }
            throw new Exception(e.getCause());
        }
    }

    @Override
    public void addAdmissionConfig(AdmissionConfig admissionConfig) {
        this.admissionConfigDAO.persist(admissionConfig);
    }

    @Override
    public void updateAdmissionConfig(AdmissionConfig admissionConfig) throws Exception, AdmissionProcessServiceException {
        try {
            this.admissionConfigDAO.update(admissionConfig);
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new AdmissionProcessServiceException(new Message("failure", "Cannot Be Done"));
            }
            throw new Exception(e.getCause());
        }
    }

    @Override
    public void deleteAdmissionConfig(Long admissionId) {
        this.admissionConfigDAO.delete(this.admissionConfigDAO.getAdmissionConfigById(admissionId));
    }

    @Override
    public AdmissionConfig getAdmissionConfigById(Long admissionId) throws Exception, AdmissionProcessServiceException {
        try {
            AdmissionConfig admissionConfig = this.admissionConfigDAO.getAdmissionConfigById(admissionId);
            Hibernate.initialize(admissionConfig.getClasses());
            Hibernate.initialize((Object)admissionConfig.getAdmissionProcessStatus());
            return admissionConfig;
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                throw new AdmissionProcessServiceException(new Message("failure", "Invalid Admission Number"));
            }
            throw new Exception(e.getCause());
        }
    }

    @Override
    public ArrayList<AdmissionConfig> getAdmissionConfigList() {
        return (ArrayList)this.admissionConfigDAO.getList();
    }

    @Override
    public ArrayList<AdmissionProcessStatus> getAdmissionProcessStatusList() {
        return (ArrayList)this.admissionProcessStatusDAO.getList();
    }

    @Override
    public AdmissionProcessStatus getAdmissionProcessStatusById(Long admissionProcessStatusId) {
        return this.admissionProcessStatusDAO.getAdmissionProcessStatusById(admissionProcessStatusId);
    }

    @Override
    public void addAdmissionProcessStatus(AdmissionProcessStatus admissionProcessStatus) {
        this.admissionProcessStatusDAO.persist(admissionProcessStatus);
    }

    @Override
    public ArrayList<AdmissionDocumentTypes> getAdmissionDocumentTypeList() {
        return (ArrayList)this.admissionDocumentTypeDAO.getList();
    }

    @Override
    public AdmissionDocumentTypes getAdmissionDocumentTypeById(Long admissionDocumentTypeId) {
        return this.admissionDocumentTypeDAO.getAdmissionDocumentTypesById(admissionDocumentTypeId);
    }

    @Override
    public AdmissionStatus getAdmissionStatusById(Long admissionStatusId) {
        return this.admissionStatusDAO.getAdmissionStatusById(admissionStatusId);
    }

    @Override
    public void addAdmissionStatus(AdmissionStatus admissionStatus) {
        this.admissionStatusDAO.persist(admissionStatus);
    }

    @Override
    public ArrayList<Admission> getApplicants(Long classId) {
        ArrayList admissions = (ArrayList)this.admissionDAO.getApplicantsList(this.classDAO.getClassById(classId));
        AdmissionStatus admissionStatus = this.getAdmissionStatusById(1L);
        for (Admission admission : admissions) {
            Hibernate.initialize((Object)admission.getClassz());
            Hibernate.initialize((Object)admission.getAdmissionStatus());
            Hibernate.initialize((Object)admission.getReligion());
            Hibernate.initialize((Object)admission.getSponser());
            Hibernate.initialize((Object)admission.getCategory());
            Hibernate.initialize((Object)admission.getSpecialCategory());
            Hibernate.initialize((Object)admission.getHearedUs());
            Hibernate.initialize((Object)admission.getUser());
            Hibernate.initialize(admission.getAdmissionAcademicsDetails());
            Hibernate.initialize(admission.getAdmissionDocuments());
            Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
            Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
            Hibernate.initialize((Object)admission.getAdmissionConfig());
            Hibernate.initialize((Object)admission.getStudent());
            Hibernate.initialize((Object)admission.getEducationLevel());
        }
        Iterator iterator = admissions.iterator();
        while (iterator.hasNext()) {
            Admission admission = (Admission)iterator.next();
            if (admission.getAdmissionStatus().getAdmissionStatusTitle().equals(admissionStatus.getAdmissionStatusTitle())) continue;
            iterator.remove();
        }
        return admissions;
    }

    @Override
    public ArrayList<Admission> getApplicantsCount(Long classId, Long sectionId) {
        try {
            ArrayList admissions = (ArrayList)this.admissionDAO.getApplicants(this.classDAO.getClassById(classId), this.sectionDAO.getSectionById(sectionId));
            AdmissionStatus admissionStatusSelectAndNotPaid = this.getAdmissionStatusById(4L);
            AdmissionStatus admissionStatusSelectAndPaid = this.getAdmissionStatusById(5L);
            for (Admission admission : admissions) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getAdmissionStatus());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                Hibernate.initialize((Object)admission.getHearedUs());
                Hibernate.initialize((Object)admission.getUser());
                Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                Hibernate.initialize(admission.getAdmissionDocuments());
                Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                Hibernate.initialize((Object)admission.getAdmissionConfig());
                Hibernate.initialize((Object)admission.getStudent());
                Hibernate.initialize((Object)admission.getEducationLevel());
            }
            Iterator iterator = admissions.iterator();
            while (iterator.hasNext()) {
                Admission admission = (Admission)iterator.next();
                if (admission.getAdmissionStatus().getAdmissionStatusTitle().equals(admissionStatusSelectAndNotPaid.getAdmissionStatusTitle()) || admission.getAdmissionStatus().getAdmissionStatusTitle().equals(admissionStatusSelectAndPaid.getAdmissionStatusTitle())) continue;
                iterator.remove();
            }
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Admission> getApplicantsDetailsByAcademicYear(AdmissionConfig admissionConfig) {
        try {
            ArrayList admissions = (ArrayList)this.admissionDAO.getApplicantsByAcademicYear(admissionConfig);
            for (Admission admission : admissions) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getAdmissionStatus());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                Hibernate.initialize((Object)admission.getHearedUs());
                Hibernate.initialize((Object)admission.getUser());
                Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                Hibernate.initialize(admission.getAdmissionDocuments());
                Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                Hibernate.initialize((Object)admission.getAdmissionConfig());
                Hibernate.initialize((Object)admission.getStudent());
                Hibernate.initialize((Object)admission.getEducationLevel());
            }
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Admission> getApplicantsDetailsByClass(Class classz) throws Exception {
        try {
            ArrayList admissions = (ArrayList)this.admissionDAO.getApplicantsByClass(classz);
            for (Admission admission : admissions) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getAdmissionStatus());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                Hibernate.initialize((Object)admission.getHearedUs());
                Hibernate.initialize((Object)admission.getUser());
                Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                Hibernate.initialize(admission.getAdmissionDocuments());
                Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                Hibernate.initialize((Object)admission.getAdmissionConfig());
                Hibernate.initialize((Object)admission.getStudent());
                Hibernate.initialize((Object)admission.getEducationLevel());
            }
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Admission> getApplicantsDetailsByClassAndAdmissionConfig(Class classz, AdmissionConfig admissionCofig) throws Exception {
        try {
            ArrayList<Admission> addAdmissions = new ArrayList<Admission>();
            ArrayList admissions = (ArrayList)this.admissionDAO.getApplicantsByClassAndAdmissionConfig(classz, admissionCofig);
            if (admissions.size() > 0) {
                for (Admission admission : admissions) {
                    Hibernate.initialize((Object)admission.getAdmissionStatus());
                    if (admission.getAdmissionStatus().getAdmissionStatusId() == 5L || admission.getAdmissionStatus().getAdmissionStatusId() == 4L || admission.getAdmissionStatus().getAdmissionStatusId() == 3L) continue;
                    Hibernate.initialize((Object)admission.getClassz());
                    Hibernate.initialize((Object)admission.getReligion());
                    Hibernate.initialize((Object)admission.getSponser());
                    Hibernate.initialize((Object)admission.getCategory());
                    Hibernate.initialize((Object)admission.getSpecialCategory());
                    Hibernate.initialize((Object)admission.getHearedUs());
                    Hibernate.initialize((Object)admission.getUser());
                    Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                    Hibernate.initialize(admission.getAdmissionDocuments());
                    Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                    Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                    Hibernate.initialize((Object)admission.getAdmissionConfig());
                    Hibernate.initialize((Object)admission.getStudent());
                    Hibernate.initialize((Object)admission.getEducationLevel());
                    addAdmissions.add(admission);
                }
            }
            return addAdmissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Admission> getApplicantsDetailsBySection(Section section) {
        try {
            ArrayList admissions = (ArrayList)this.admissionDAO.getApplicantsBySection(section);
            for (Admission admission : admissions) {
                Hibernate.initialize((Object)admission.getClassz());
                Hibernate.initialize((Object)admission.getAdmissionStatus());
                Hibernate.initialize((Object)admission.getReligion());
                Hibernate.initialize((Object)admission.getSponser());
                Hibernate.initialize((Object)admission.getCategory());
                Hibernate.initialize((Object)admission.getSpecialCategory());
                Hibernate.initialize((Object)admission.getHearedUs());
                Hibernate.initialize((Object)admission.getUser());
                Hibernate.initialize(admission.getAdmissionAcademicsDetails());
                Hibernate.initialize(admission.getAdmissionDocuments());
                Hibernate.initialize(admission.getAdmissionEducationLevelSubjects());
                Hibernate.initialize((Object)admission.getAdmissionFeesPaymentDetails());
                Hibernate.initialize((Object)admission.getAdmissionConfig());
                Hibernate.initialize((Object)admission.getStudent());
                Hibernate.initialize((Object)admission.getEducationLevel());
            }
            return admissions;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public AdmissionConfig getCurrentAdmissionConfig() {
        AdmissionConfig admissionConfig = null;
        List<AdmissionConfig> admissionConfigList = this.admissionConfigDAO.getCurrentAdmissionConfigList();
        if (admissionConfigList != null) {
            for (AdmissionConfig admissionConfig1 : admissionConfigList) {
                Hibernate.initialize((Object)admissionConfig1.getAdmissionProcessStatus());
                Hibernate.initialize(admissionConfig1.getAdmissions());
                if (admissionConfig1.getAdmissionProcessStatus().getAdmissionProcessStatusId() != 3L) continue;
                admissionConfig = admissionConfig1;
            }
        }
        return admissionConfig;
    }

    @Override
    public List<AdmissionConfig> getOnGoingAdmissionConfig() {
        List<AdmissionConfig> admissionConfigList = this.admissionConfigDAO.getAdmissionConfigList();
        if (admissionConfigList != null) {
            for (AdmissionConfig admissionConfig : admissionConfigList) {
                Hibernate.initialize((Object)admissionConfig.getAdmissionProcessStatus());
                Hibernate.initialize(admissionConfig.getAdmissions());
            }
        }
        return admissionConfigList;
    }

    @Override
    public List<AdmissionConfig> getAdmissionConfigByClass(Set<Class> classz) {
        List<AdmissionConfig> admissionConfigList = this.admissionConfigDAO.getAdmissionConfigListByClassz(classz);
        if (admissionConfigList != null) {
            for (AdmissionConfig admissionConfig : admissionConfigList) {
                Hibernate.initialize((Object)admissionConfig.getAdmissionProcessStatus());
                Hibernate.initialize(admissionConfig.getAdmissions());
            }
        }
        return admissionConfigList;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public Integer studentAdmissionBulkUpload(MultipartFile studentExcelFile, Long institutionId, String createdBy) throws AdmissionException, Exception {
        int i = 1;
        try {
            DataFormatter formatter = new DataFormatter();
            HSSFWorkbook workbook = new HSSFWorkbook(studentExcelFile.getInputStream());
            HSSFSheet worksheet = workbook.getSheetAt(0);
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            while (i <= worksheet.getLastRowNum()) {
                Date date;
                Date date2;
                Date date3;
                HSSFRow row = worksheet.getRow(i++);
                String applicantfirstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(0)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantFirstNameNotFound", "Upload Failed : You have to mention Applicant First Name in row " + i));
                }
                applicantfirstName = formatter.formatCellValue((Cell)row.getCell(0)).trim();
                String applicantlastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(1)).isEmpty()) {
                    applicantlastName = formatter.formatCellValue((Cell)row.getCell(1)).trim();
                }
                String sex = null;
                if (formatter.formatCellValue((Cell)row.getCell(2)).isEmpty()) throw new AdmissionException(new Message("genderNotFound", "Upload Failed : You have to mention Gender in row " + i));
                String gender = formatter.formatCellValue((Cell)row.getCell(2)).trim();
                if (!(gender.equals("Male") || gender.equals("Female") || gender.equals("Others"))) {
                    throw new AdmissionException(new Message("genderNotFound", "Upload Failed : Gender can be Male/Female/Others in row " + i));
                }
                sex = gender;
                Date birthDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(3)).isEmpty()) {
                    throw new AdmissionException(new Message("invalidDateFormat", "Upload Failed : Invalid Birth Date Format in row " + i + " correct format [eg:dd/mm//yyyy]"));
                }
                birthDate = date3 = new Date(formatter.formatCellValue((Cell)row.getCell(3)).trim());
                Religion religion = null;
                if (formatter.formatCellValue((Cell)row.getCell(4)).isEmpty()) throw new AdmissionException(new Message("religionNotFound", "Upload Failed : Invalid Religion in row " + i));
                religion = this.religionDAO.getReligionByReligionName(formatter.formatCellValue((Cell)row.getCell(4)).trim());
                if (religion == null) {
                    throw new AdmissionException(new Message("religionNotfound", "Upload Failed : Invalid Religion in row " + i));
                }
                Category category = null;
                if (formatter.formatCellValue((Cell)row.getCell(5)).isEmpty()) throw new AdmissionException(new Message("categoryNotFound", "Upload Failed : Invalid Category in row " + i));
                category = this.categoryDAO.getCategoryByCategoryName(formatter.formatCellValue((Cell)row.getCell(5)).trim());
                if (category == null) {
                    throw new AdmissionException(new Message("categoryNotfound", "Upload Failed : Invalid Category in row " + i));
                }
                SpecialCategory specialCategory = null;
                if (formatter.formatCellValue((Cell)row.getCell(6)).isEmpty()) throw new AdmissionException(new Message("specialCategoryNameNotFound", "Upload Failed : You have to mention Special Category in row " + i));
                String currentSpecialCategory = formatter.formatCellValue((Cell)row.getCell(6)).trim();
                if (this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(currentSpecialCategory, institution) == null) {
                    throw new AdmissionException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid Special Category in row " + i));
                }
                specialCategory = this.specialCategoryDAO.getSpecialCategoryByNameAndInstitution(currentSpecialCategory, institution);
                String passportOrIDNumber = null;
                if (!formatter.formatCellValue((Cell)row.getCell(7)).isEmpty()) {
                    passportOrIDNumber = formatter.formatCellValue((Cell)row.getCell(7)).trim();
                }
                String countryIDissued = null;
                if (!formatter.formatCellValue((Cell)row.getCell(8)).isEmpty()) {
                    countryIDissued = formatter.formatCellValue((Cell)row.getCell(8)).trim();
                }
                String studiedHereBefore = null;
                if (!formatter.formatCellValue((Cell)row.getCell(9)).isEmpty()) {
                    studiedHereBefore = formatter.formatCellValue((Cell)row.getCell(9)).trim();
                }
                String previousStudentIDofThisInstitute = null;
                if (!formatter.formatCellValue((Cell)row.getCell(10)).isEmpty()) {
                    previousStudentIDofThisInstitute = formatter.formatCellValue((Cell)row.getCell(10)).trim();
                }
                Sponser whoWillSponserYourStudiesHere = null;
                if (!formatter.formatCellValue((Cell)row.getCell(11)).isEmpty()) {
                    whoWillSponserYourStudiesHere = this.sponserDAO.getSponserBySponserName(formatter.formatCellValue((Cell)row.getCell(11)).trim());
                }
                String doYouHaveAnyDisability = null;
                if (formatter.formatCellValue((Cell)row.getCell(12)).isEmpty()) {
                    throw new AdmissionException(new Message("disabilityNotFound", "Upload Failed : You have to mention Disability in row " + i));
                }
                doYouHaveAnyDisability = formatter.formatCellValue((Cell)row.getCell(12)).trim();
                String fatherFirstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(13)).isEmpty()) {
                    throw new AdmissionException(new Message("fatherFirstNameNotFound", "Upload Failed : You have to mention Father First Name in row " + i));
                }
                fatherFirstName = formatter.formatCellValue((Cell)row.getCell(13)).trim();
                String fatherLastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(14)).isEmpty()) {
                    fatherLastName = formatter.formatCellValue((Cell)row.getCell(14)).trim();
                }
                String fatherOccupation = null;
                if (!formatter.formatCellValue((Cell)row.getCell(15)).isEmpty()) {
                    fatherOccupation = formatter.formatCellValue((Cell)row.getCell(15)).trim();
                }
                String motherFirstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(16)).isEmpty()) {
                    throw new AdmissionException(new Message("motherFirstNameNotFound", "Upload Failed : You have to mention Mother First Name in row " + i));
                }
                motherFirstName = formatter.formatCellValue((Cell)row.getCell(16)).trim();
                String motherLastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(17)).isEmpty()) {
                    motherLastName = formatter.formatCellValue((Cell)row.getCell(17)).trim();
                }
                String motherOccupation = null;
                if (!formatter.formatCellValue((Cell)row.getCell(18)).isEmpty()) {
                    motherOccupation = formatter.formatCellValue((Cell)row.getCell(18)).trim();
                }
                double fatherIncome = 0.0;
                if (!formatter.formatCellValue((Cell)row.getCell(19)).isEmpty()) {
                    fatherIncome = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(19)).trim());
                }
                double motherIncome = 0.0;
                if (!formatter.formatCellValue((Cell)row.getCell(20)).isEmpty()) {
                    motherIncome = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(20)).trim());
                }
                String guardianFirstName = null;
                if (formatter.formatCellValue((Cell)row.getCell(21)).isEmpty()) {
                    throw new AdmissionException(new Message("guardianFirstNameNotFound", "Upload Failed : You have to mention Guardian First Name in row " + i));
                }
                guardianFirstName = formatter.formatCellValue((Cell)row.getCell(21)).trim();
                String guardianLastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(22)).isEmpty()) {
                    guardianLastName = formatter.formatCellValue((Cell)row.getCell(22)).trim();
                }
                String reference1FirstName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(23)).isEmpty()) {
                    reference1FirstName = formatter.formatCellValue((Cell)row.getCell(23)).trim();
                }
                String reference1LastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(24)).isEmpty()) {
                    reference1LastName = formatter.formatCellValue((Cell)row.getCell(24)).trim();
                }
                String reference1Email = " ";
                if (!formatter.formatCellValue((Cell)row.getCell(25)).isEmpty()) {
                    reference1Email = formatter.formatCellValue((Cell)row.getCell(25)).trim();
                }
                String reference1MobileNo = null;
                if (!formatter.formatCellValue((Cell)row.getCell(26)).isEmpty()) {
                    reference1MobileNo = formatter.formatCellValue((Cell)row.getCell(26)).trim();
                }
                String reference1AddressLine1 = null;
                if (!formatter.formatCellValue((Cell)row.getCell(27)).isEmpty()) {
                    reference1AddressLine1 = formatter.formatCellValue((Cell)row.getCell(27)).trim();
                }
                String reference1AddressLine2 = null;
                if (!formatter.formatCellValue((Cell)row.getCell(28)).isEmpty()) {
                    reference1AddressLine2 = formatter.formatCellValue((Cell)row.getCell(28)).trim();
                }
                String reference1Country = null;
                if (!formatter.formatCellValue((Cell)row.getCell(29)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(29)).trim());
                    if (geoGraphicalLocation == null) throw new AdmissionException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                    if (geoGraphicalLocation.getGeographicalLocationType() != 0) throw new AdmissionException(new Message("countryNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(29)) + " is not a country in row " + i));
                    reference1Country = geoGraphicalLocation.getName();
                }
                String reference1Pincode = null;
                if (!formatter.formatCellValue((Cell)row.getCell(30)).isEmpty()) {
                    reference1Pincode = formatter.formatCellValue((Cell)row.getCell(30)).trim();
                }
                String reference2FirstName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(31)).isEmpty()) {
                    reference2FirstName = formatter.formatCellValue((Cell)row.getCell(31)).trim();
                }
                String reference2LastName = null;
                if (!formatter.formatCellValue((Cell)row.getCell(32)).isEmpty()) {
                    reference2LastName = formatter.formatCellValue((Cell)row.getCell(32)).trim();
                }
                String reference2Email = " ";
                if (!formatter.formatCellValue((Cell)row.getCell(33)).isEmpty()) {
                    reference2Email = formatter.formatCellValue((Cell)row.getCell(33)).trim();
                }
                String reference2MobileNo = null;
                if (!formatter.formatCellValue((Cell)row.getCell(34)).isEmpty()) {
                    reference2MobileNo = formatter.formatCellValue((Cell)row.getCell(34)).trim();
                }
                String reference2AddressLine1 = null;
                if (!formatter.formatCellValue((Cell)row.getCell(35)).isEmpty()) {
                    reference2AddressLine1 = formatter.formatCellValue((Cell)row.getCell(35)).trim();
                }
                String reference2AddressLine2 = null;
                if (!formatter.formatCellValue((Cell)row.getCell(36)).isEmpty()) {
                    reference2AddressLine2 = formatter.formatCellValue((Cell)row.getCell(36)).trim();
                }
                String reference2Country = null;
                if (!formatter.formatCellValue((Cell)row.getCell(37)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(37)).trim());
                    if (geoGraphicalLocation == null) throw new AdmissionException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                    if (geoGraphicalLocation.getGeographicalLocationType() != 0) throw new AdmissionException(new Message("countryNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(37)) + " is not a country in row " + i));
                    reference2Country = geoGraphicalLocation.getName();
                }
                String reference2Pincode = null;
                if (!formatter.formatCellValue((Cell)row.getCell(38)).isEmpty()) {
                    reference2Pincode = formatter.formatCellValue((Cell)row.getCell(38)).trim();
                }
                HearedUs howDidYouHearedUs = null;
                if (!formatter.formatCellValue((Cell)row.getCell(39)).isEmpty()) {
                    howDidYouHearedUs = this.hearedUsDAO.getHearedUsByHearedUsName(formatter.formatCellValue((Cell)row.getCell(39)).trim());
                }
                String applicantAddressLine1 = null;
                if (formatter.formatCellValue((Cell)row.getCell(40)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantAddressLine1NotFound", "Upload Failed : You have to mention Applicant AddressLine1 in row " + i));
                }
                applicantAddressLine1 = formatter.formatCellValue((Cell)row.getCell(40)).trim();
                String applicantAddressLine2 = null;
                if (formatter.formatCellValue((Cell)row.getCell(41)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantAddressLine2NotFound", "Upload Failed : You have to mention Applicant AddressLine2 in row " + i));
                }
                applicantAddressLine2 = formatter.formatCellValue((Cell)row.getCell(41)).trim();
                String applicantMobileNumber = null;
                if (formatter.formatCellValue((Cell)row.getCell(42)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantMobileNumberNotFound", "Upload Failed : You have to mention Applicant Mobile Number in row " + i));
                }
                applicantMobileNumber = formatter.formatCellValue((Cell)row.getCell(42)).trim();
                String applicantEmail = " ";
                if (formatter.formatCellValue((Cell)row.getCell(43)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantEmailNotFound", "Upload Failed : You have to mention Applicant Email in row " + i));
                }
                applicantEmail = formatter.formatCellValue((Cell)row.getCell(43)).trim();
                Long applicantCountryId = null;
                String applicantCountry = null;
                if (formatter.formatCellValue((Cell)row.getCell(44)).isEmpty()) throw new AdmissionException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                GeographicalLocation geoGraphicalLocation = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(44)).trim());
                if (geoGraphicalLocation == null) throw new AdmissionException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                if (geoGraphicalLocation.getGeographicalLocationType() != 0) {
                    throw new AdmissionException(new Message("countryNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(44)) + " is not a country in row " + i));
                }
                applicantCountryId = geoGraphicalLocation.getGeographicalLocationId();
                applicantCountry = geoGraphicalLocation.getName();
                Long applicantStateId = null;
                String applicantState = null;
                if (formatter.formatCellValue((Cell)row.getCell(45)).isEmpty()) throw new AdmissionException(new Message("stateNotFound", "Upload Failed : Invalid State in row " + i));
                GeographicalLocation geoGraphicalLocation2 = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(45)).trim());
                if (geoGraphicalLocation2 == null) throw new AdmissionException(new Message("stateNotFound", "Upload Failed : Invalid State in row " + i));
                if (geoGraphicalLocation2.getGeographicalLocationType() != 1) throw new AdmissionException(new Message("stateNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(45)) + " is not a state in row " + i));
                if ((long)geoGraphicalLocation2.getParentId() != applicantCountryId) {
                    throw new AdmissionException(new Message("stateNotFound", "Upload Failed :No such state for given country in row " + i));
                }
                applicantStateId = geoGraphicalLocation2.getGeographicalLocationId();
                applicantState = geoGraphicalLocation2.getName();
                String applicantCity = null;
                if (formatter.formatCellValue((Cell)row.getCell(46)).isEmpty()) throw new AdmissionException(new Message("cityNotFound", "Upload Failed : Invalid City in row " + i));
                GeographicalLocation geoGraphicalLocation3 = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(46)).trim());
                if (geoGraphicalLocation3 == null) throw new AdmissionException(new Message("cityNotFound", "Upload Failed : Invalid City in row " + i));
                if (geoGraphicalLocation3.getGeographicalLocationType() != 2) throw new AdmissionException(new Message("cityNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(46)) + " is not a city in row " + i));
                if ((long)geoGraphicalLocation3.getParentId() != applicantStateId) {
                    throw new AdmissionException(new Message("cityNotFound", "Upload Failed :No such City for given state in row " + i));
                }
                applicantCity = geoGraphicalLocation3.getName();
                String applicantPostCode = null;
                if (formatter.formatCellValue((Cell)row.getCell(47)).isEmpty()) {
                    throw new AdmissionException(new Message("applicantPostCodeNotFound", "Upload Failed : You have to mention Applicant PostCode in row " + i));
                }
                applicantPostCode = formatter.formatCellValue((Cell)row.getCell(47)).trim();
                EducationLevel educationLevel = null;
                if (formatter.formatCellValue((Cell)row.getCell(48)).isEmpty()) throw new AdmissionException(new Message("educationLevelNotFound", "Upload Failed : You have to mention Education Level in row " + i));
                if (this.educationLevelDAO.getEducationLevelByEducationLevelName(formatter.formatCellValue((Cell)row.getCell(48)).trim()) == null) {
                    throw new AdmissionException(new Message("specialCategoryNameNotFound", "Upload Failed : Invalid Education Level in row " + i));
                }
                educationLevel = this.educationLevelDAO.getEducationLevelByEducationLevelName(formatter.formatCellValue((Cell)row.getCell(48)).trim());
                String nameOfDegreeOrCourse = null;
                if (formatter.formatCellValue((Cell)row.getCell(49)).isEmpty()) {
                    throw new AdmissionException(new Message("nameOfDegreeOrCourseNotFound", "Upload Failed : You have to mention Name Of Degree Or Course in row " + i));
                }
                nameOfDegreeOrCourse = formatter.formatCellValue((Cell)row.getCell(49)).trim();
                String boardAndUniversityName = null;
                if (formatter.formatCellValue((Cell)row.getCell(50)).isEmpty()) {
                    throw new AdmissionException(new Message("boardAndUniversityNotFound", "Upload Failed : You have to mention Board And University Name in row " + i));
                }
                boardAndUniversityName = formatter.formatCellValue((Cell)row.getCell(50)).trim();
                String institutionName = null;
                if (formatter.formatCellValue((Cell)row.getCell(51)).isEmpty()) {
                    throw new AdmissionException(new Message("institutionNameNotFound", "Upload Failed : You have to mention Institution Name in row " + i));
                }
                institutionName = formatter.formatCellValue((Cell)row.getCell(51)).trim();
                Long countryId = null;
                String institutionCountry = null;
                if (!formatter.formatCellValue((Cell)row.getCell(52)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation4 = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(52)).trim());
                    if (geoGraphicalLocation4 == null) throw new AdmissionException(new Message("countryNotFound", "Upload Failed : Invalid Country in row " + i));
                    if (geoGraphicalLocation4.getGeographicalLocationType() != 0) throw new AdmissionException(new Message("countryNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(52)) + " is not a country in row " + i));
                    countryId = geoGraphicalLocation4.getGeographicalLocationId();
                    institutionCountry = geoGraphicalLocation4.getName();
                }
                Long stateId = null;
                String institutionState = null;
                if (!formatter.formatCellValue((Cell)row.getCell(53)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation5 = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(53)).trim());
                    if (geoGraphicalLocation5 == null) throw new AdmissionException(new Message("stateNotFound", "Upload Failed : Invalid State in row " + i));
                    if (geoGraphicalLocation5.getGeographicalLocationType() != 1) throw new AdmissionException(new Message("stateNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(53)) + " is not a state in row " + i));
                    if ((long)geoGraphicalLocation5.getParentId() != countryId) throw new AdmissionException(new Message("stateNotFound", "Upload Failed :No such state for given country in row " + i));
                    stateId = geoGraphicalLocation5.getGeographicalLocationId();
                    institutionState = geoGraphicalLocation5.getName();
                }
                String institutionCity = null;
                if (!formatter.formatCellValue((Cell)row.getCell(54)).isEmpty()) {
                    GeographicalLocation geoGraphicalLocation6 = this.geographicalLocationDAO.getGeographicalLocationByName(formatter.formatCellValue((Cell)row.getCell(54)).trim());
                    if (geoGraphicalLocation6 == null) throw new AdmissionException(new Message("cityNotFound", "Upload Failed : Invalid City in row " + i));
                    if (geoGraphicalLocation6.getGeographicalLocationType() != 2) throw new AdmissionException(new Message("cityNotFound", "Upload Failed :" + formatter.formatCellValue((Cell)row.getCell(54)) + " is not a city in row " + i));
                    if ((long)geoGraphicalLocation6.getParentId() != stateId) throw new AdmissionException(new Message("cityNotFound", "Upload Failed :No such City for given state in row " + i));
                    institutionCity = geoGraphicalLocation6.getName();
                }
                Date academicStartDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(55)).isEmpty()) {
                    throw new AdmissionException(new Message("invalidAcademicStartDateFormat", "Upload Failed : Invalid Academic Start Date Format in row " + i + " correct format [eg:dd/mm//yyyy]"));
                }
                academicStartDate = date2 = new Date(formatter.formatCellValue((Cell)row.getCell(55)).trim());
                Date academicEndDate = null;
                if (formatter.formatCellValue((Cell)row.getCell(56)).isEmpty()) {
                    throw new AdmissionException(new Message("invalidAcademicEndDateFormat", "Upload Failed : Invalid Academic End Date Format in row " + i + " correct format [eg:dd/mm//yyyy]"));
                }
                academicEndDate = date = new Date(formatter.formatCellValue((Cell)row.getCell(56)).trim());
                String yearOfPassing = null;
                if (formatter.formatCellValue((Cell)row.getCell(57)).isEmpty()) {
                    throw new AdmissionException(new Message("yearOfPassingNotFound", "Upload Failed : You have to mention Year Of Passing in row " + i));
                }
                yearOfPassing = formatter.formatCellValue((Cell)row.getCell(57)).trim();
                String markType = null;
                if (formatter.formatCellValue((Cell)row.getCell(58)).isEmpty()) {
                    throw new AdmissionException(new Message("markTypeNotFound", "Upload Failed : You have to mention Mark Type in row " + i));
                }
                markType = formatter.formatCellValue((Cell)row.getCell(58)).trim();
                Double overAllPercentage = 0.0;
                if (formatter.formatCellValue((Cell)row.getCell(59)).isEmpty()) {
                    throw new AdmissionException(new Message("overAllPercentageNotFound", "Upload Failed : You have to mention OverAll Percentage in row " + i));
                }
                overAllPercentage = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(59)).trim());
                Double percentage = 0.0;
                Double cgpa = 0.0;
                if (markType.equals("Percentage")) {
                    percentage = overAllPercentage;
                } else if (markType.equals("CGPA")) {
                    cgpa = overAllPercentage;
                }
                Double subject1 = 0.0;
                Double subject2 = 0.0;
                Double subject3 = 0.0;
                Double subject4 = 0.0;
                if (!educationLevel.getEducationLevelTitle().equals("LKG") && !educationLevel.getEducationLevelTitle().equals("UKG")) {
                    if (formatter.formatCellValue((Cell)row.getCell(60)).isEmpty()) {
                        throw new AdmissionException(new Message("subject1NotFound", "Upload Failed : You have to mention Subject1 in row " + i));
                    }
                    subject1 = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(60)).trim());
                    if (formatter.formatCellValue((Cell)row.getCell(61)).isEmpty()) {
                        throw new AdmissionException(new Message("subject2NotFound", "Upload Failed : You have to mention Subject2 in row " + i));
                    }
                    subject2 = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(61)).trim());
                    if (formatter.formatCellValue((Cell)row.getCell(62)).isEmpty()) {
                        throw new AdmissionException(new Message("subject3NotFound", "Upload Failed : You have to mention Subject3 in row " + i));
                    }
                    subject3 = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(62)).trim());
                    if (formatter.formatCellValue((Cell)row.getCell(63)).isEmpty()) throw new AdmissionException(new Message("subject4NotFound", "Upload Failed : You have to mention Subject4 in row " + i));
                    subject4 = Double.parseDouble(formatter.formatCellValue((Cell)row.getCell(63)).trim());
                }
                String registerNumber = null;
                if (formatter.formatCellValue((Cell)row.getCell(64)).isEmpty()) {
                    throw new AdmissionException(new Message("registerNumberNotFound", "Upload Failed : You have to mention Register Number in row " + i));
                }
                registerNumber = formatter.formatCellValue((Cell)row.getCell(64)).trim();
                String certificateNumber = null;
                if (!formatter.formatCellValue((Cell)row.getCell(65)).isEmpty()) {
                    certificateNumber = formatter.formatCellValue((Cell)row.getCell(65)).trim();
                }
                Class applyingClass = null;
                if (formatter.formatCellValue((Cell)row.getCell(66)).isEmpty()) throw new AdmissionException(new Message("classNotFound", "Upload Failed : You have to mention Applying Class in row " + i));
                applyingClass = this.classDAO.getClassByClassNameAndInstitution(formatter.formatCellValue((Cell)row.getCell(66)).trim(), institution);
                if (applyingClass == null) {
                    throw new AdmissionException(new Message("classNotFound", "Upload Failed : Invalid Applying Class in row " + i));
                }
                String admissionCode = null;
                if (formatter.formatCellValue((Cell)row.getCell(67)).isEmpty()) {
                    throw new AdmissionException(new Message("admissionCodeNotFound", "Upload Failed : You have to mention Admission Code in row " + i));
                }
                admissionCode = formatter.formatCellValue((Cell)row.getCell(67)).trim();
                AdmissionConfig currentConfig = this.admissionConfigDAO.getAdmissionConfigByAdmissionConfigName(admissionCode);
                admissionCode = currentConfig.getApplicationCodeFormat().concat(Long.toString(System.currentTimeMillis()));
                AdmissionStatus admissionStatus = this.admissionStatusDAO.getAdmissionStatusById(1L);
                LinkedHashSet<AdmissionEducationLevelDetails> admissionAcademicsDetails = new LinkedHashSet<AdmissionEducationLevelDetails>();
                LinkedHashSet<AdmissionEducationLevelSubjects> admissionEducationLevelSubjects = new LinkedHashSet<AdmissionEducationLevelSubjects>();
                LinkedHashSet<AdmissionDocument> admissionDocuments = new LinkedHashSet<AdmissionDocument>();
                String candidateProfilePicturePath = "/resources/themes/images/profile-pic/a.png";
                String candidateSignaturePath = "/resources/themes/images/profile-pic/a.png";
                String candidateSSLCCertificatePath = "/resources/themes/images/profile-pic/a.png";
                String candidateHSCCertificatePath = "/resources/themes/images/profile-pic/a.png";
                String candidateTransferCertificatePath = "/resources/themes/images/profile-pic/a.png";
                String candidatePreviousMarkSheetCertificatePath = "/resources/themes/images/profile-pic/a.png";
                String candidateSSLCCertificateName = "candidateSSLCCertificate";
                String candidateHSCCertificateName = "candidateHSCCertificate";
                String candidateTCCertificateName = "candidateTCCertificate";
                String candidatePreviousMarkSheetCertificateName = "candidatePreviousMarkSheetCertificate";
                User user = this.userDAO.getUserByEmail(createdBy);
                int submitStatus = 0;
                Double admissionRank = 0.0;
                Admission newAdmission = new Admission(currentConfig, applyingClass, admissionStatus, religion, whoWillSponserYourStudiesHere, category, specialCategory, howDidYouHearedUs, admissionCode, applicantfirstName, applicantlastName, fatherFirstName, fatherLastName, fatherOccupation, motherFirstName, motherLastName, motherOccupation, fatherIncome, motherIncome, guardianFirstName, guardianLastName, passportOrIDNumber, studiedHereBefore, previousStudentIDofThisInstitute, doYouHaveAnyDisability, reference1FirstName, reference1LastName, reference1Email, reference1MobileNo, reference1AddressLine1, reference1AddressLine2, reference1Country, reference1Pincode, reference2FirstName, reference2LastName, reference2Email, reference2MobileNo, reference2AddressLine1, reference2AddressLine2, reference2Country, reference2Pincode, candidateSignaturePath, sex, birthDate, applicantEmail, applicantMobileNumber, countryIDissued, applicantAddressLine1, applicantAddressLine2, applicantCountry, applicantState, applicantCity, applicantPostCode, candidateProfilePicturePath, submitStatus, admissionRank, user, educationLevel);
                AdmissionDocumentTypes admissionDocumentTypeSSLC = this.admissionDocumentTypeDAO.getAdmissionDocumentTypesById(1L);
                AdmissionDocument admissionDocumentSSLC = new AdmissionDocument(newAdmission, admissionDocumentTypeSSLC, candidateSSLCCertificateName, candidateSSLCCertificatePath);
                AdmissionDocumentTypes admissionDocumentTypeHSC = this.admissionDocumentTypeDAO.getAdmissionDocumentTypesById(2L);
                AdmissionDocument admissionDocumentHSC = new AdmissionDocument(newAdmission, admissionDocumentTypeHSC, candidateHSCCertificateName, candidateHSCCertificatePath);
                AdmissionDocumentTypes admissionDocumentTypeTC = this.admissionDocumentTypeDAO.getAdmissionDocumentTypesById(3L);
                AdmissionDocument admissionDocumentTC = new AdmissionDocument(newAdmission, admissionDocumentTypeTC, candidateTCCertificateName, candidateTransferCertificatePath);
                AdmissionDocumentTypes admissionDocumentTypePreviousMarkSheet = this.admissionDocumentTypeDAO.getAdmissionDocumentTypesById(4L);
                AdmissionDocument admissionDocumentPreviousMarkSheet = new AdmissionDocument(newAdmission, admissionDocumentTypePreviousMarkSheet, candidatePreviousMarkSheetCertificateName, candidatePreviousMarkSheetCertificatePath);
                admissionDocuments.add(admissionDocumentHSC);
                admissionDocuments.add(admissionDocumentSSLC);
                admissionDocuments.add(admissionDocumentTC);
                admissionDocuments.add(admissionDocumentPreviousMarkSheet);
                AdmissionEducationLevelDetails admissionEducationLevelDetail = new AdmissionEducationLevelDetails(newAdmission, educationLevel, nameOfDegreeOrCourse, registerNumber, certificateNumber, academicStartDate, academicEndDate, overAllPercentage, percentage, cgpa, boardAndUniversityName, institutionCountry, institutionState, institutionCity, institutionName, yearOfPassing, markType);
                admissionAcademicsDetails.add(admissionEducationLevelDetail);
                if (!educationLevel.getEducationLevelTitle().equals("LKG") && !educationLevel.getEducationLevelTitle().equals("UKG")) {
                    AdmissionEducationLevelSubjects admissionEducationLevelSubject1 = new AdmissionEducationLevelSubjects(admissionEducationLevelDetail, newAdmission, subject1, "subject1");
                    AdmissionEducationLevelSubjects admissionEducationLevelSubject2 = new AdmissionEducationLevelSubjects(admissionEducationLevelDetail, newAdmission, subject2, "subject2");
                    AdmissionEducationLevelSubjects admissionEducationLevelSubject3 = new AdmissionEducationLevelSubjects(admissionEducationLevelDetail, newAdmission, subject3, "subject3");
                    AdmissionEducationLevelSubjects admissionEducationLevelSubject4 = new AdmissionEducationLevelSubjects(admissionEducationLevelDetail, newAdmission, subject4, "subject4");
                    admissionEducationLevelSubjects.add(admissionEducationLevelSubject1);
                    admissionEducationLevelSubjects.add(admissionEducationLevelSubject2);
                    admissionEducationLevelSubjects.add(admissionEducationLevelSubject3);
                    admissionEducationLevelSubjects.add(admissionEducationLevelSubject4);
                }
                Admission persistdAdmission = this.admissionDAO.save(newAdmission);
                for (AdmissionEducationLevelDetails admissionEducationLevelDetails2 : admissionAcademicsDetails) {
                    admissionEducationLevelDetails2.setAdmission(persistdAdmission);
                    AdmissionEducationLevelDetails persistedAdmissionEducationLevelDetails = this.admissionEducationLevelDetailsDAO.save(admissionEducationLevelDetails2);
                    for (AdmissionEducationLevelSubjects admissionEducationLevelSubjects2 : admissionEducationLevelSubjects) {
                        admissionEducationLevelSubjects2.setAdmissionEducationLevelDetail(persistedAdmissionEducationLevelDetails);
                        this.admissionEducationLevelSubjectsDAO.save(admissionEducationLevelSubjects2);
                    }
                }
                for (AdmissionDocument admissionDocument : admissionDocuments) {
                    admissionDocument.setAdmission(persistdAdmission);
                    this.admissionDocumentDAO.save(admissionDocument);
                }
            }
            return i;
        }
        catch (IOException | ConstraintViolationException e) {
            if (e.getClass().equals(IOException.class)) {
                e.printStackTrace();
                throw new AdmissionException(new Message("fileError", "Excel File Not Found"));
            }
            if (e.getClass().equals(NullPointerException.class)) {
                e.printStackTrace();
                throw new AdmissionException(new Message("Null Value", "Fields Cannot be Blank"));
            }
            if (e.getClass().equals(ConstraintViolationException.class)) {
                e.printStackTrace();
                throw new AdmissionException(new Message("duplicateException", "Upload Failed: Check for Duplicates email-id in the Excel"));
            }
            e.printStackTrace();
            return 0;
        }
    }
}
