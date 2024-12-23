/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.StudentHostelIDCardGenerationException;
import in.jdsoft.educationmanagement.school.model.StudentHostelIDCardGeneration;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={StudentHostelIDCardGenerationException.class})
public interface StudentHostelIDCardGenerationService {
    public static final Logger log = LogManager.getLogger((String)StudentHostelIDCardGenerationService.class.getName());

    public void createBarCodeAndBarCodeImage(Set<StudentHostelIDCardGeneration> var1) throws StudentHostelIDCardGenerationException, Exception;

    public void createBarCodeAndBarCodeImage(StudentHostelIDCardGeneration var1) throws StudentHostelIDCardGenerationException, Exception;

    public void deleteStudentIDCard(Long var1, Long var2, Long var3, Long var4) throws Exception;

    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3, Long var4) throws Exception;

    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3) throws Exception;

    public List<StudentHostelIDCardGeneration> StudentHostelIDCardGenerationListByClassAndSectionAndFeesTerm(Long var1, Long var2, Long var3) throws Exception;

    public void deleteStudentHostelIDCardByClassAndSectionAndAcademicYear(Long var1, Long var2, Long var3) throws Exception;

    public void deleteStudentHostelIDCardByClassAndSectionAndFeesTerm(Long var1, Long var2, Long var3) throws Exception;
}
