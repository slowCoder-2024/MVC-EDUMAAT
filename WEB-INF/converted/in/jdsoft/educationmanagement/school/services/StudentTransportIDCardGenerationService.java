/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentTransportIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.StudentTransportIDCardGeneration;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={StudentTransportIDCardGenerationException.class})
public interface StudentTransportIDCardGenerationService {
    public static final Logger log = LogManager.getLogger((String)StudentTransportIDCardGenerationService.class.getName());

    public void createBarCodeAndBarCodeImage(Set<StudentTransportIDCardGeneration> var1) throws StudentTransportIDCardGenerationException, Exception;

    public void createBarCodeAndBarCodeImage(StudentTransportIDCardGeneration var1) throws StudentTransportIDCardGenerationException, Exception;

    public void deleteStudentIDCard(Long var1, Long var2, Long var3, Long var4) throws Exception;

    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3, Long var4) throws Exception;

    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3) throws Exception;

    public List<StudentTransportIDCardGeneration> StudentTransportIDCardGenerationListByClassAndSectionAndFeesTerm(Long var1, Long var2, Long var3) throws Exception;

    public void deleteStudentTransportIDCardByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3) throws Exception;

    public void deleteStudentTransportIDCardByClassAndSectionAndFeesTerm(Long var1, Long var2, Long var3) throws Exception;
}
