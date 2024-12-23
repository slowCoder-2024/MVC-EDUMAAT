/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.StaffAppraisalDAO;
import in.jdsoft.educationmanagement.school.dao.StaffDAO;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.StaffAppraisal;
import in.jdsoft.educationmanagement.school.services.StaffAppraisalService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="staffAppraisalService")
public class StaffAppraisalServiceImpl
implements StaffAppraisalService {
    @Autowired
    StaffAppraisalDAO staffAppraisalDAO;
    @Autowired
    StaffDAO staffDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;

    @Override
    public List<StaffAppraisal> staffAppraisalList() {
        try {
            List<StaffAppraisal> staffAppraisalList = this.staffAppraisalDAO.getList();
            Integer appraisalSize = staffAppraisalList.size();
            if (appraisalSize > 0) {
                for (StaffAppraisal staffAppraisal : staffAppraisalList) {
                    Hibernate.initialize((Object)staffAppraisal.getStaff());
                    Hibernate.initialize((Object)staffAppraisal.getInstitution());
                    Hibernate.initialize((Object)staffAppraisal.getAcademicYear());
                }
                log.info((Object)(appraisalSize + " StaffAppraisal records where reterived"));
            } else {
                log.info((Object)"No StaffAppraisal available");
            }
            return staffAppraisalList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving StaffAppraisal list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public StaffAppraisal staffAppraisalById(Long staffAppraisalId) {
        try {
            StaffAppraisal staffAppraisal = this.staffAppraisalDAO.getStaffAppraisalById(staffAppraisalId);
            if (staffAppraisalId != null) {
                Hibernate.initialize((Object)staffAppraisal.getStaff());
                Hibernate.initialize((Object)staffAppraisal.getInstitution());
                Hibernate.initialize((Object)staffAppraisal.getAcademicYear());
                log.info((Object)("StaffAppraisal with id=" + staffAppraisalId + " has been reterived"));
                return staffAppraisal;
            }
            log.info((Object)("No StaffAppraisal with  id=" + staffAppraisalId + " is available"));
            return staffAppraisal;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving StaffAppraisal by id=" + staffAppraisalId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createStaffAppraisal(StaffAppraisal staffAppraisal) throws Exception {
        try {
            this.staffAppraisalDAO.save(staffAppraisal);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating StaffAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateStaffAppraisal(StaffAppraisal dtaffAppraisal) {
        try {
            this.staffAppraisalDAO.saveOrUpdate(dtaffAppraisal);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating StaffAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteStaffAppraisal(Long StaffAppraisalId) {
        try {
            this.staffAppraisalDAO.delete(this.staffAppraisalDAO.getStaffAppraisalById(StaffAppraisalId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting StaffAppraisal " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffAppraisal> staffAppraisalListByStaffCode(String staffCode) {
        try {
            Staff staff = this.staffDAO.getStaffByStaffCode(staffCode);
            ArrayList<StaffAppraisal> staffAppraisalList = new ArrayList<StaffAppraisal>();
            if (this.staffAppraisalDAO.getStaffAppraisalListByStaff(staff).size() > 0) {
                for (StaffAppraisal staffAppraisal : this.staffAppraisalDAO.getStaffAppraisalListByStaff(staff)) {
                    Hibernate.initialize((Object)staffAppraisal.getStaff());
                    Hibernate.initialize((Object)staffAppraisal.getInstitution());
                    Hibernate.initialize((Object)staffAppraisal.getAcademicYear());
                    staffAppraisalList.add(staffAppraisal);
                }
            }
            return staffAppraisalList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffAppraisal> staffAppraisalListByAcademicYear(Long academicYearId) {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            ArrayList<StaffAppraisal> staffAppraisalList = new ArrayList<StaffAppraisal>();
            if (this.staffAppraisalDAO.getStaffAppraisalListByAcademicYear(academicYear).size() > 0) {
                for (StaffAppraisal staffAppraisal : this.staffAppraisalDAO.getStaffAppraisalListByAcademicYear(academicYear)) {
                    Hibernate.initialize((Object)staffAppraisal.getStaff());
                    Hibernate.initialize((Object)staffAppraisal.getInstitution());
                    Hibernate.initialize((Object)staffAppraisal.getAcademicYear());
                    staffAppraisalList.add(staffAppraisal);
                }
            }
            return staffAppraisalList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<StaffAppraisal> staffAppraisalListByAcademicYearAndEmail(Long academicYearId, String email) {
        try {
            AcademicYear academicYear = this.academicYearDAO.getAcademicYearById(academicYearId);
            Staff staff = this.staffDAO.getStaffByStaffEmail(email);
            ArrayList<StaffAppraisal> staffAppraisalList = new ArrayList<StaffAppraisal>();
            if (this.staffAppraisalDAO.getStaffAppraisalListByAcademicYearAndEmail(academicYear, staff).size() > 0) {
                for (StaffAppraisal staffAppraisal : this.staffAppraisalDAO.getStaffAppraisalListByAcademicYearAndEmail(academicYear, staff)) {
                    Hibernate.initialize((Object)staffAppraisal.getStaff());
                    Hibernate.initialize((Object)staffAppraisal.getInstitution());
                    Hibernate.initialize((Object)staffAppraisal.getAcademicYear());
                    staffAppraisalList.add(staffAppraisal);
                }
            }
            return staffAppraisalList;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
