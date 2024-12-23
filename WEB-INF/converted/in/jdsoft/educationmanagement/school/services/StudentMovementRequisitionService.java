/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentMovementRequisitionException;
import in.jdsoft.educationmanagement.school.model.StudentMovementRequisition;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentMovementRequisitionService {
    public static final Logger log = LogManager.getLogger((String)StudentMovementRequisitionService.class.getName());

    public Long createStudentMovementRequisition(StudentMovementRequisition var1) throws StudentMovementRequisitionException;

    public void deleteStudentMovementRequisition(Long var1) throws StudentMovementRequisitionException;

    public List<StudentMovementRequisition> studentMovementRequisitionList() throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequisitionListByStudentEmail(String var1) throws StudentMovementRequisitionException;

    public StudentMovementRequisition studentMovementRequisitionById(Long var1) throws StudentMovementRequisitionException;

    public StudentMovementRequisition studentMovementRequisitionByIdEager(Long var1) throws StudentMovementRequisitionException;

    public void updateStudentMovementRequisition(StudentMovementRequisition var1) throws StudentMovementRequisitionException;

    public void cancelStudentMovementRequisition(StudentMovementRequisition var1) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequisitionListByMovementApprover(String var1) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequestApprovedAndRejectedLists(String var1) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndAllClass(Long var1) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndClassAndSection(Long var1, Long var2, Long var3) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequisitionListByAcademicYearAndAdmissionNo(Long var1, String var2) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequestApprovedListByInstitution(Long var1) throws StudentMovementRequisitionException;

    public Set<StudentMovementRequisition> studentMovementRequestApprovedListByInstitutionAndDate(Long var1, Date var2) throws StudentMovementRequisitionException;
}
