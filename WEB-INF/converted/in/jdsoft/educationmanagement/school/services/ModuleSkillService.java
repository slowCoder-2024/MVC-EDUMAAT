/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.ModuleSkill;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ModuleSkillService {
    public static final Logger log = LogManager.getLogger((String)ModuleSkillService.class.getName());

    public List<ModuleSkill> moduleSkillList();

    public ModuleSkill moduleSkillById(Long var1);

    public List<ModuleSkill> moduleSkillListEager();

    public ModuleSkill moduleSkillByIdEager(Long var1);
}
