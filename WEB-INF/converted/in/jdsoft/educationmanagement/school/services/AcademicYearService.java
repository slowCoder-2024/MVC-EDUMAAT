/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.AcademicYearException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor={AcademicYearException.class})
public interface AcademicYearService {
    public static final Logger log = LogManager.getLogger((String)AcademicYearService.class.getName());

    public Long createAcademicYear(AcademicYear var1) throws AcademicYearException;

    public void deleteAcademicYear(Long var1);

    public List<AcademicYear> academicYearList();

    public List<AcademicYear> academicYearList(Long var1) throws AcademicYearException;

    public AcademicYear academicYearById(Long var1);

    public void updateAcademicYear(AcademicYear var1) throws Exception;

    public AcademicYear getActiveAcademicYearOfdInstitution(Long var1);

    public AcademicYear institutionCurrentAcademicYear(Long var1);

    public AcademicYear getActiveAcademicYear();
}
