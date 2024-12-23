/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.EducationLevel;
import in.jdsoft.educationmanagement.school.model.EducationLevelSubject;
import java.util.ArrayList;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EducationLevelService {
    public static final Logger log = LogManager.getLogger((String)EducationLevelService.class.getName());

    public void addEducationLevel(EducationLevel var1);

    public ArrayList<EducationLevel> getEducationLevelList();

    public void deleteEducationLevel(Long var1);

    public void updateEducationLevel(EducationLevel var1);

    public EducationLevel getEducationLevelById(Long var1);

    public EducationLevel getEducationLevelLazyById(Long var1);

    public void addEducationLevelSubject(EducationLevelSubject var1);

    public ArrayList<EducationLevelSubject> getEducationLevelSubjectList();

    public void deleteEducationLevelSubject(Long var1);

    public void updateEducationLevelSubject(EducationLevelSubject var1);

    public EducationLevelSubject getEducationLevelSubjectById(Long var1);

    public Set<EducationLevelSubject> getEducationLevelSubjectByEducationLevelId(Long var1);
}
