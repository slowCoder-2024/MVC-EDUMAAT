/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ModuleException;
import in.jdsoft.educationmanagement.school.model.Module;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ModuleService {
    public static final Logger log = LogManager.getLogger((String)ModuleService.class.getName());

    public Long createModule(Module var1);

    public void deleteModule(Long var1);

    public List<Module> moduleList();

    public List<Module> moduleList(Long var1) throws ModuleException;

    public Module moduleById(Long var1);

    public Module moduleByModuleName(String var1);

    public void update(Module var1);

    public Module moduleByModuleNameAndInstitution(String var1, Long var2);
}
