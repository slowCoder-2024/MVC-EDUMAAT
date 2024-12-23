/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ClassSectionModuleSkillDAO;
import in.jdsoft.educationmanagement.school.model.ClassSectionModuleSkill;
import in.jdsoft.educationmanagement.school.services.ClassSectionModuleSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="classSectionModuleSkillService")
public class ClassSectionModuleSkillImpl
implements ClassSectionModuleSkillService {
    @Autowired
    ClassSectionModuleSkillDAO classSectionModuleSkillDAO;

    @Override
    public ClassSectionModuleSkill classSectionModuleSkillById(Long classSectionModuleSkillId) {
        try {
            ClassSectionModuleSkill classSectionModuleSkill = this.classSectionModuleSkillDAO.getClassSectionModuleSkillById(classSectionModuleSkillId);
            if (classSectionModuleSkill != null) {
                log.info((Object)("Class Section Module Skill with id=" + classSectionModuleSkillId + " has been reterived"));
                return classSectionModuleSkill;
            }
            log.info((Object)("No Class Section Module Skill with  id=" + classSectionModuleSkillId + " is available"));
            return classSectionModuleSkill;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving Class Section Module Skill by id=" + classSectionModuleSkillId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
