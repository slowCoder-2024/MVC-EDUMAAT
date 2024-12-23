/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ClassSectionTermExam;
import in.jdsoft.educationmanagement.school.model.ReportCardGenerator;
import java.util.ArrayList;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StudentGPAndCGPAService {
    public static final Logger log = LogManager.getLogger((String)StudentGPAndCGPAService.class.getName());

    public void GenerateGPAndCGPA(ReportCardGenerator var1, ArrayList<ClassSectionTermExam> var2, ArrayList<ClassSectionTermExam> var3);
}
