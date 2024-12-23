/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.SickRoomVisitorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.SickRoomVisitor;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.Student;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SickRoomVisitorService {
    public static final Logger log = LogManager.getLogger((String)SickRoomVisitorService.class.getName());

    public Long createSickRoomVisitor(SickRoomVisitor var1) throws SickRoomVisitorException;

    public void deleteSickRoomVisitor(Long var1) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorList() throws SickRoomVisitorException;

    public Set<SickRoomVisitor> sickRoomVisitorListByStudentEmail(String var1) throws SickRoomVisitorException;

    public Set<SickRoomVisitor> sickRoomVisitorListByStaffEmail(String var1) throws SickRoomVisitorException;

    public SickRoomVisitor sickRoomVisitorById(Long var1) throws SickRoomVisitorException;

    public SickRoomVisitor sickRoomVisitorByIdEager(Long var1) throws SickRoomVisitorException;

    public void updateSickRoomVisitor(SickRoomVisitor var1) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByStudentAndAcademicYearAndIsititution(Student var1, AcademicYear var2, Institution var3) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByStaffAndAcademicYearAndIsititution(Staff var1, AcademicYear var2, Institution var3) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByInstitution(Long var1) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByInstitutionAndAcademicYear(Long var1, Long var2) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListEager() throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByStudentEmailAndAcademicYear(String var1, Long var2) throws SickRoomVisitorException;

    public List<SickRoomVisitor> sickRoomVisitorListByStaffEmailAndAcademicYear(String var1, Long var2) throws SickRoomVisitorException;
}
