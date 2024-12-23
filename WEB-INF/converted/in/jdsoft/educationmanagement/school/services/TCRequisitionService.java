/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.TransferCertificateRequisitionException;
import in.jdsoft.educationmanagement.school.model.TCRequisition;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TCRequisitionService {
    public static final Logger log = LogManager.getLogger((String)TCRequisitionService.class.getName());

    public Long createTCRequisition(TCRequisition var1) throws TransferCertificateRequisitionException;

    public void deleteTCRequisition(Long var1) throws TransferCertificateRequisitionException;

    public List<TCRequisition> tcRequisitionList() throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequisitionListByStudentEmail(String var1) throws TransferCertificateRequisitionException;

    public TCRequisition tcRequisitionById(Long var1) throws TransferCertificateRequisitionException;

    public TCRequisition tcRequisitionByIdEager(Long var1) throws TransferCertificateRequisitionException;

    public void updateTCRequisition(TCRequisition var1) throws TransferCertificateRequisitionException;

    public void cancelTCRequisition(TCRequisition var1) throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequisitionListByTCApprover(String var1) throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequestApprovedAndRejectedLists(String var1) throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequisitionListByAcademicYearAndAllClass(Long var1) throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequisitionListByAcademicYearAndClassAndSection(Long var1, Long var2, Long var3) throws TransferCertificateRequisitionException;

    public Set<TCRequisition> tcRequisitionListByAcademicYearAndAdmissionNo(Long var1, String var2) throws TransferCertificateRequisitionException;
}
