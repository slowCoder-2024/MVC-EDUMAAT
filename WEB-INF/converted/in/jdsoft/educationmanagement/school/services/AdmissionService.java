/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.transaction.annotation.Transactional
 *  org.springframework.web.multipart.MultipartFile
 */
package in.jdsoft.educationmanagement.school.services;

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
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface AdmissionService {
    public void createAdmission(Admission var1, Set<AdmissionEducationLevelDetails> var2, Set<AdmissionEducationLevelSubjects> var3, Set<AdmissionDocument> var4);

    public void addAdmission(Admission var1);

    public void updateAdmission(Admission var1);

    public void intimateApplicationStatus(Admission var1, User var2) throws Exception;

    public void deleteAdmission(Long var1);

    public Admission getAdmissionDetailsById(Long var1) throws AdmissionProcessServiceException;

    public AdmissionConfig getAdmissionConfigById(Long var1) throws Exception, AdmissionProcessServiceException;

    public Admission getAdmissionDetailsLazyById(Long var1) throws AdmissionProcessServiceException;

    public Admission editAdmissionApplication(Long var1);

    public Admission getFullAdmissionDetails(Long var1) throws Exception;

    public Admission getFullAdmissionDetailsByApplicantCode(String var1) throws Exception;

    public ArrayList<Admission> getAdmissionsList() throws Exception, AdmissionProcessServiceException;

    public void addAdmissionConfig(AdmissionConfig var1);

    public void updateAdmissionConfig(AdmissionConfig var1) throws Exception, AdmissionProcessServiceException;

    public void deleteAdmissionConfig(Long var1);

    public ArrayList<AdmissionConfig> getAdmissionConfigList();

    public ArrayList<AdmissionProcessStatus> getAdmissionProcessStatusList();

    public AdmissionProcessStatus getAdmissionProcessStatusById(Long var1);

    public void addAdmissionProcessStatus(AdmissionProcessStatus var1);

    public ArrayList<AdmissionDocumentTypes> getAdmissionDocumentTypeList();

    public AdmissionDocumentTypes getAdmissionDocumentTypeById(Long var1);

    public AdmissionStatus getAdmissionStatusById(Long var1);

    public void addAdmissionStatus(AdmissionStatus var1);

    public ArrayList<Admission> getApplicants(Long var1);

    public ArrayList<Admission> getApplicantsCount(Long var1, Long var2);

    public ArrayList<Admission> getApplicantsDetailsByAcademicYear(AdmissionConfig var1);

    public ArrayList<Admission> getApplicantsDetailsByClass(Class var1) throws Exception;

    public ArrayList<Admission> getApplicantsDetailsByClassAndAdmissionConfig(Class var1, AdmissionConfig var2) throws Exception;

    public ArrayList<Admission> getApplicantsDetailsBySection(Section var1);

    public AdmissionConfig getCurrentAdmissionConfig();

    public List<AdmissionConfig> getOnGoingAdmissionConfig();

    public List<AdmissionConfig> getAdmissionConfigByClass(Set<Class> var1);

    public Integer studentAdmissionBulkUpload(MultipartFile var1, Long var2, String var3) throws AdmissionException, Exception;
}
