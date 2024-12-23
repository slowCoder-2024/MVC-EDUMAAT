/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.GradeSystemException;
import in.jdsoft.educationmanagement.school.model.GradeSystem;
import in.jdsoft.educationmanagement.school.model.GradeSystemDetail;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface GradeSystemService {
    public static final Logger log = LogManager.getLogger((String)GradeSystemService.class.getName());

    public void createGradeSystem(GradeSystem var1, Set<GradeSystemDetail> var2) throws GradeSystemException;

    public void updateGradeSystem(GradeSystem var1, Set<GradeSystemDetail> var2) throws GradeSystemException;

    public void deleteGradeSystem(Long var1) throws GradeSystemException;

    public GradeSystem gradeSystemById(Long var1);

    public GradeSystem gradeSystemIdByEager(Long var1);

    public List<GradeSystem> gradeSystemList(Long var1) throws GradeSystemException;

    public List<GradeSystem> gradeSystemListEager(Long var1) throws GradeSystemException;

    public List<GradeSystem> gradeSystemList();
}
