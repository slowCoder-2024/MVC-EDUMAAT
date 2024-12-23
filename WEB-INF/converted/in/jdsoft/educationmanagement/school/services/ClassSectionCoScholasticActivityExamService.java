/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ClassSectionCoScholasticActivityExam;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassSectionCoScholasticActivityExamService {
    public static final Logger log = LogManager.getLogger((String)ClassSectionCoScholasticActivityExamService.class.getName());

    public List<ClassSectionCoScholasticActivityExam> classSectionCoScholasticActivityExamEagerById(Long var1);
}
