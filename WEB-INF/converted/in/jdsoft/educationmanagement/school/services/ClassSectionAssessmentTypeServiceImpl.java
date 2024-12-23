/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionAssesmentTypeDAO;
import in.jdsoft.educationmanagement.school.dao.ClassSectionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.model.ClassSection;
import in.jdsoft.educationmanagement.school.model.ClassSectionAssesmentType;
import in.jdsoft.educationmanagement.school.services.ClassSectionAssessmentTypeService;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionAssessmentTypeService")
public class ClassSectionAssessmentTypeServiceImpl
implements ClassSectionAssessmentTypeService {
    @Autowired
    ClassSectionDAO classSectionDAO;
    @Autowired
    ClassDAO classDAO;
    @Autowired
    SectionDAO sectionDAO;
    @Autowired
    ClassSectionAssesmentTypeDAO classSectionAssesmentTypeDAO;

    @Override
    public Set<ClassSectionAssesmentType> AssessmentTypeById(Long classId, Long sectionId) {
        try {
            ClassSection classSection = this.classSectionDAO.getClasssSectionByClassAndSection(this.classDAO.getClassById(classId), this.sectionDAO.getSectionById(sectionId));
            LinkedHashSet<ClassSectionAssesmentType> classSectionAssesmentTypes = new LinkedHashSet<ClassSectionAssesmentType>();
            for (ClassSectionAssesmentType classSectionAssesmentType : classSection.getClassSectionAssesmentType()) {
                Hibernate.initialize((Object)classSectionAssesmentType.getClassSectionAssesmentTypeId());
                Hibernate.initialize((Object)classSectionAssesmentType.getClassSectionAssesmentName());
                Hibernate.initialize((Object)classSectionAssesmentType.getGradeSystem());
                Hibernate.initialize((Object)classSectionAssesmentType.isGradeMethod());
                Hibernate.initialize((Object)classSectionAssesmentType.getAssessmentLimit());
                classSectionAssesmentTypes.add(classSectionAssesmentType);
            }
            return classSectionAssesmentTypes;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving classSectionAssessmentType", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ClassSectionAssesmentType classSectionAssesmentTypeEagerBy(Long classSectionAssessmentTypeId) {
        try {
            ClassSectionAssesmentType classSectionAssesmentType = this.classSectionAssesmentTypeDAO.getClassSectionAssesmentTypeById(classSectionAssessmentTypeId);
            if (classSectionAssesmentType != null) {
                Hibernate.initialize((Object)classSectionAssesmentType.getGradeSystem());
                log.info((Object)("classSectionAssessmentTypeEager with id=" + classSectionAssessmentTypeId + " has been reterived"));
                return classSectionAssesmentType;
            }
            log.info((Object)("No classSectionAssessmentTypeEager with  id=" + classSectionAssessmentTypeId + " is available"));
            return classSectionAssesmentType;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving classSectionAssessmentTypeEager by id=" + classSectionAssessmentTypeId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
