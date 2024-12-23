/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.StudentIDCardGeneration;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={StudentIDCardGenerationException.class})
public interface StudentIDCardGenerationService {
    public static final Logger log = LogManager.getLogger((String)StudentIDCardGenerationService.class.getName());

    public void createBarCodeAndBarCodeImage(Set<StudentIDCardGeneration> var1) throws StudentIDCardGenerationException, Exception;

    public void deleteStudentIDCard(Long var1, Long var2, Long var3, Long var4) throws Exception;

    public List<StudentIDCardGeneration> studentIDCardGenerationListByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3, Long var4) throws Exception;
}
