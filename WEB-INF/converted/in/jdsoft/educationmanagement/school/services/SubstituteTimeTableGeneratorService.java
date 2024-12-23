/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.SubstituteTimeTableGeneratorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SubstituteTimeTableGeneratorService {
    public static final Logger log = LogManager.getLogger((String)SubstituteTimeTableGeneratorService.class.getName());

    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList() throws SubstituteTimeTableGeneratorException;

    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListEager() throws SubstituteTimeTableGeneratorException;

    public SubstituteTimeTableGenerator substituteTimeTableGeneratorById(Long var1) throws SubstituteTimeTableGeneratorException;

    public void createSubstituteTimeTableGenerator(SubstituteTimeTableGenerator var1) throws SubstituteTimeTableGeneratorException;

    public void updateSubstituteTimeTableGenerator(SubstituteTimeTableGenerator var1) throws SubstituteTimeTableGeneratorException;

    public void deleteSubstituteTimeTableGenerator(Long var1) throws SubstituteTimeTableGeneratorException;

    public void createSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> var1) throws SubstituteTimeTableGeneratorException, Exception;

    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByInstitutionAndAcademicYearEager(Long var1, AcademicYear var2) throws SubstituteTimeTableGeneratorException;

    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByStaffAndDateEager(Staff var1, Date var2) throws SubstituteTimeTableGeneratorException;

    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByClassAndSectionAndDateEager(Long var1, Long var2, Date var3) throws SubstituteTimeTableGeneratorException;
}
