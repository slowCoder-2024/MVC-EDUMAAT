/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassSectionAssessmentTypeService {
    public static final Logger log = LogManager.getLogger(ClassSectionAssessmentTypeService.class);

    public Set<ClassSectionAssesmentType> AssessmentTypeById(Long var1, Long var2);

    public ClassSectionAssesmentType classSectionAssesmentTypeEagerBy(Long var1);
}
