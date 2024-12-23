/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.BloodGroupDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.reports.model.TwoFieldReport;
import in.jdsoft.educationmanagement.school.services.BloodGroupService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="bloodGroupService")
public class BloodGroupServiceImpl
implements BloodGroupService {
    @Autowired
    BloodGroupDAO bloodGroupDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public List<BloodGroup> bloodGroupList() {
        try {
            List<BloodGroup> bloodGroups = this.bloodGroupDAO.getList();
            Integer bloodGroupsSize = bloodGroups.size();
            if (bloodGroupsSize > 0) {
                log.info((Object)(bloodGroupsSize + " blood group records where reterived"));
            } else {
                log.info((Object)"No blood group available");
            }
            return bloodGroups;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving blood group list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public BloodGroup bloodGroupById(Long bloodGroupId) {
        try {
            BloodGroup bloodGroup = this.bloodGroupDAO.getBloodGroupById(bloodGroupId);
            if (bloodGroup != null) {
                log.info((Object)("Blood Group with id=" + bloodGroupId + " has been reterived"));
                return bloodGroup;
            }
            log.info((Object)("No Blood Group with  id=" + bloodGroupId + " is available"));
            return bloodGroup;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Blood Groupby id=" + bloodGroupId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCount() {
        ArrayList bloodGroups = (ArrayList)this.bloodGroupDAO.getList();
        ArrayList<TwoFieldReport> twoFieldReports = new ArrayList<TwoFieldReport>();
        for (BloodGroup bloodGroup : bloodGroups) {
            Hibernate.initialize(bloodGroup.getStudents());
            Integer studentsCount = bloodGroup.getStudents().size();
            TwoFieldReport report = new TwoFieldReport(bloodGroup.getBloodGroupName(), studentsCount);
            twoFieldReports.add(report);
        }
        return twoFieldReports;
    }

    @Override
    public ArrayList<TwoFieldReport> getBloodGroupWiseStudentCountByInstitution(Long institutionId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        ArrayList bloodGroups = (ArrayList)this.bloodGroupDAO.getList();
        ArrayList<TwoFieldReport> twoFieldReports = new ArrayList<TwoFieldReport>();
        for (BloodGroup bloodGroup : bloodGroups) {
            TwoFieldReport report;
            Integer studentsCount;
            if (!this.studentDAO.getStudentsByInstitutionAndBloodGroup(institution, bloodGroup).isEmpty()) {
                studentsCount = this.studentDAO.getStudentsByInstitutionAndBloodGroup(institution, bloodGroup).size();
                report = new TwoFieldReport(bloodGroup.getBloodGroupName(), studentsCount);
                twoFieldReports.add(report);
                continue;
            }
            studentsCount = 0;
            report = new TwoFieldReport(bloodGroup.getBloodGroupName(), studentsCount);
            twoFieldReports.add(report);
        }
        return twoFieldReports;
    }
}
