/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ClassSectionTermExamActivity;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassSectionTermExamActivityService {
    public static final Logger log = LogManager.getLogger((String)ClassSectionTermExamActivityService.class.getName());

    public List<ClassSectionTermExamActivity> classSectionTermExamActivityByclassSectionTermExamIdId(Long var1);

    public ClassSectionTermExamActivity classSectionTermExamActivityById(Long var1);
}
