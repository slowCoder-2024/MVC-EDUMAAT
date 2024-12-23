/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.ModuleSkillDAO;
import in.jdsoft.educationmanagement.school.model.ModuleSkill;
import in.jdsoft.educationmanagement.school.services.ModuleSkillService;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="moduleSkillService")
public class ModuleSkillServiceImpl
implements ModuleSkillService {
    @Autowired
    ModuleSkillDAO moduleSkillDAO;

    @Override
    public List<ModuleSkill> moduleSkillList() {
        try {
            List<ModuleSkill> moduleSkills = this.moduleSkillDAO.getList();
            Integer moduleSkillsSize = moduleSkills.size();
            if (moduleSkillsSize > 0) {
                log.info((Object)(moduleSkillsSize + " module skills records where reterived"));
            } else {
                log.info((Object)"No module skill list available");
            }
            return moduleSkills;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving module skill list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ModuleSkill moduleSkillById(Long moduleSkillId) {
        try {
            ModuleSkill moduleSkill = this.moduleSkillDAO.getModuleSkillById(moduleSkillId);
            if (moduleSkill != null) {
                log.info((Object)("Module Skill with id=" + moduleSkillId + " has been reterived"));
                return moduleSkill;
            }
            log.info((Object)("No Module Skill with  id=" + moduleSkillId + " is available"));
            return moduleSkill;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving module skill by id=" + moduleSkillId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<ModuleSkill> moduleSkillListEager() {
        try {
            List<ModuleSkill> moduleSkills = this.moduleSkillDAO.getList();
            Integer moduleSkillsSize = moduleSkills.size();
            if (moduleSkillsSize > 0) {
                for (ModuleSkill moduleSkill : moduleSkills) {
                    Hibernate.initialize(moduleSkill.getModuleSkillIndicators());
                    Hibernate.initialize(moduleSkill.getClassSectionModuleSkills());
                }
                log.info((Object)(moduleSkillsSize + " module skills records where reterived with childs"));
            } else {
                log.info((Object)"No module skill list available");
            }
            return moduleSkills;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving module skill list with its childs", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ModuleSkill moduleSkillByIdEager(Long moduleSkillId) {
        try {
            ModuleSkill moduleSkill = this.moduleSkillDAO.getModuleSkillById(moduleSkillId);
            if (moduleSkill != null) {
                Hibernate.initialize(moduleSkill.getModuleSkillIndicators());
                Hibernate.initialize(moduleSkill.getClassSectionModuleSkills());
                log.info((Object)("Module Skill with id=" + moduleSkillId + " has been reterived"));
                return moduleSkill;
            }
            log.info((Object)("No Module Skill with  id=" + moduleSkillId + " is available"));
            return moduleSkill;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving module skill by id=" + moduleSkillId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
