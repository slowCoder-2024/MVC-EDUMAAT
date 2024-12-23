/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import in.jdsoft.educationmanagement.school.model.Student;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ReportCardGeneratorService {
    public static final Logger log = LogManager.getLogger((String)ReportCardGeneratorService.class.getName());

    public ReportCardGenerator reportCardGeneratorEagerByStudent(Student var1);
}
