/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.components.EmailHandler;
import in.jdsoft.educationmanagement.school.dao.AcademicYearDAO;
import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.dao.SubstituteTimeTableGeneratorDAO;
import in.jdsoft.educationmanagement.school.exceptions.SubstituteTimeTableGeneratorException;
import in.jdsoft.educationmanagement.school.model.AcademicYear;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.Staff;
import in.jdsoft.educationmanagement.school.model.SubstituteTimeTableGenerator;
import in.jdsoft.educationmanagement.school.model.User;
import in.jdsoft.educationmanagement.school.services.SubstituteTimeTableGeneratorService;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="substituteTimeTableGeneratorService")
public class SubstituteTimeTableGeneratorServiceImpl
implements SubstituteTimeTableGeneratorService {
    @Autowired
    SubstituteTimeTableGeneratorDAO substituteTimeTableGeneratorDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    AcademicYearDAO academicYearDAO;
    @Autowired
    private EmailHandler emailHandler;
    @Autowired
    private ClassDAO classDAO;
    @Autowired
    private SectionDAO sectionDAO;

    @Override
    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList() {
        try {
            List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList = this.substituteTimeTableGeneratorDAO.getList();
            Integer substituteTimeTableGeneratorSize = substituteTimeTableGeneratorList.size();
            if (substituteTimeTableGeneratorSize > 0) {
                log.info((Object)(substituteTimeTableGeneratorSize + " SubstituteTimeTableGenerators records where reterived"));
            } else {
                log.info((Object)"No SubstituteTimeTableGenerator(s) available");
            }
            return substituteTimeTableGeneratorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SubstituteTimeTableGenerators list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SubstituteTimeTableGenerator substituteTimeTableGeneratorById(Long substituteTimeTableGeneratorId) {
        try {
            SubstituteTimeTableGenerator substituteTimeTableGenerator = this.substituteTimeTableGeneratorDAO.getSubstituteTimeTableGeneratorById(substituteTimeTableGeneratorId);
            if (substituteTimeTableGenerator != null) {
                log.info((Object)("SubstituteTimeTableGenerator with id=" + substituteTimeTableGeneratorId + " has been reterived"));
                return substituteTimeTableGenerator;
            }
            log.info((Object)("No SubstituteTimeTableGenerator with  id=" + substituteTimeTableGeneratorId + " is available"));
            return substituteTimeTableGenerator;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving SubstituteTimeTableGenerator by id=" + substituteTimeTableGeneratorId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createSubstituteTimeTableGenerator(SubstituteTimeTableGenerator substituteTimeTableGenerator) throws SubstituteTimeTableGeneratorException {
        try {
            this.substituteTimeTableGeneratorDAO.save(substituteTimeTableGenerator);
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating SubstituteTimeTableGenerator " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSubstituteTimeTableGenerator(SubstituteTimeTableGenerator substituteTimeTableGenerator) throws SubstituteTimeTableGeneratorException {
        try {
            this.substituteTimeTableGeneratorDAO.saveOrUpdate(substituteTimeTableGenerator);
        }
        catch (Exception e) {
            log.error((Object)("Exception in updating SubstituteTimeTableGenerator " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteSubstituteTimeTableGenerator(Long substituteTimeTableGeneratorId) throws SubstituteTimeTableGeneratorException {
        try {
            this.substituteTimeTableGeneratorDAO.delete(this.substituteTimeTableGeneratorDAO.getSubstituteTimeTableGeneratorById(substituteTimeTableGeneratorId));
        }
        catch (Exception e) {
            log.error((Object)("Exception in deleting SubstituteTimeTableGenerator " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void createSubstituteTimeTableGenerators(Set<SubstituteTimeTableGenerator> substituteTimeTableGenerators) throws SubstituteTimeTableGeneratorException, Exception {
        try {
            LinkedHashSet<User> addUser = new LinkedHashSet<User>();
            for (SubstituteTimeTableGenerator substituteTimeTableGenerator : substituteTimeTableGenerators) {
                addUser.add(substituteTimeTableGenerator.getStaff().getUser());
                this.substituteTimeTableGeneratorDAO.save(substituteTimeTableGenerator);
            }
            if (addUser.size() > 0) {
                String[] userMailIds = new String[addUser.size()];
                int i = 0;
                for (User user : addUser) {
                    userMailIds[i] = user.getEmail().trim();
                    ++i;
                }
                this.emailHandler.sendEmail(userMailIds, "Substitute TimeTable", "Please Check Your Substitute TimeTable");
            }
        }
        catch (Exception e) {
            log.error((Object)("Exception in creating SubstituteTimeTableGenerator " + e.getCause()));
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListEager() throws SubstituteTimeTableGeneratorException {
        try {
            List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList = this.substituteTimeTableGeneratorDAO.getList();
            Integer substituteTimeTableGeneratorSize = substituteTimeTableGeneratorList.size();
            if (substituteTimeTableGeneratorSize > 0) {
                for (SubstituteTimeTableGenerator substituteTimeTableGenerator : substituteTimeTableGeneratorList) {
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getModule());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getTimeTableClass());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getSection());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getAcademicYear());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getInstitution());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getStaff());
                }
                log.info((Object)(substituteTimeTableGeneratorSize + " SubstituteTimeTableGenerators records where reterived"));
            } else {
                log.info((Object)"No SubstituteTimeTableGenerator(s) available");
            }
            return substituteTimeTableGeneratorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SubstituteTimeTableGenerators list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByInstitutionAndAcademicYearEager(Long institutionId, AcademicYear academicYear) throws SubstituteTimeTableGeneratorException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList = this.substituteTimeTableGeneratorDAO.getSubstituteTimeTableGeneratorByInstitutionAndActiveAcademicYear(institution, academicYear);
            Integer substituteTimeTableGeneratorSize = substituteTimeTableGeneratorList.size();
            if (substituteTimeTableGeneratorSize > 0) {
                for (SubstituteTimeTableGenerator substituteTimeTableGenerator : substituteTimeTableGeneratorList) {
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getModule());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getTimeTableClass());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getSection());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getAcademicYear());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getInstitution());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getStaff());
                }
                log.info((Object)(substituteTimeTableGeneratorSize + " SubstituteTimeTableGenerators records where reterived"));
            } else {
                log.info((Object)"No SubstituteTimeTableGenerator(s) available");
            }
            return substituteTimeTableGeneratorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SubstituteTimeTableGenerators list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByStaffAndDateEager(Staff staff, Date todayDate) throws SubstituteTimeTableGeneratorException {
        try {
            List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList = this.substituteTimeTableGeneratorDAO.getSubstituteTimeTableGeneratorByStaffAndDate(staff, todayDate);
            Integer substituteTimeTableGeneratorSize = substituteTimeTableGeneratorList.size();
            if (substituteTimeTableGeneratorSize > 0) {
                for (SubstituteTimeTableGenerator substituteTimeTableGenerator : substituteTimeTableGeneratorList) {
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getModule());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getTimeTableClass());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getSection());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getAcademicYear());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getInstitution());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getStaff());
                }
                log.info((Object)(substituteTimeTableGeneratorSize + " SubstituteTimeTableGenerators records where reterived"));
            } else {
                log.info((Object)"No SubstituteTimeTableGenerator(s) available");
            }
            return substituteTimeTableGeneratorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SubstituteTimeTableGenerators list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorListByClassAndSectionAndDateEager(Long classId, Long sectionId, Date todayDate) throws SubstituteTimeTableGeneratorException {
        try {
            Class classes = this.classDAO.getClassById(classId);
            Section section = this.sectionDAO.getSectionById(sectionId);
            List<SubstituteTimeTableGenerator> substituteTimeTableGeneratorList = this.substituteTimeTableGeneratorDAO.getSubstituteTimeTableGeneratorByClassAndSectionAndDate(classes, section, todayDate);
            Integer substituteTimeTableGeneratorSize = substituteTimeTableGeneratorList.size();
            if (substituteTimeTableGeneratorSize > 0) {
                for (SubstituteTimeTableGenerator substituteTimeTableGenerator : substituteTimeTableGeneratorList) {
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getModule());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getTimeTableClass());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getSection());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getAcademicYear());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getInstitution());
                    Hibernate.initialize((Object)substituteTimeTableGenerator.getStaff());
                }
                log.info((Object)(substituteTimeTableGeneratorSize + " SubstituteTimeTableGenerators records where reterived"));
            } else {
                log.info((Object)"No SubstituteTimeTableGenerator(s) available");
            }
            return substituteTimeTableGeneratorList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving SubstituteTimeTableGenerators list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
