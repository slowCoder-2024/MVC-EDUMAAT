/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.StudentMark;
import in.jdsoft.educationmanagement.school.model.StudentMarksDetailWithModuleBased;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface StaffModuleWiseMarkSystemService {
    public static final Logger log = LogManager.getLogger((String)StaffModuleWiseMarkSystemService.class.getName());

    public void saveModuleWiseMark(Set<StudentMark> var1, Set<StudentMarksDetailWithModuleBased> var2);
}
