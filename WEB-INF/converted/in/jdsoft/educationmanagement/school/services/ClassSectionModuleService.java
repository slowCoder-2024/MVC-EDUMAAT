/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionModule;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.model.Staff;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ClassSectionModuleService {
    public static final Logger log = LogManager.getLogger(ClassSectionModuleService.class);

    public ClassSectionModule classSectionModuleById(Long var1);

    public ClassSectionModule classSectionModuleByIdEager(Long var1);

    public ClassSectionModule classSectionModuleByIdAndStaffEager(Long var1, Staff var2);

    public ClassSectionModule classSectionModuleByClassSectionAndModule(ClassSection var1, Module var2);
}
