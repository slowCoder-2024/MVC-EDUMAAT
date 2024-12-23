/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.ModuleDAO;
import in.jdsoft.educationmanagement.school.exceptions.ModuleException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Module;
import in.jdsoft.educationmanagement.school.services.ModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="moduleService")
public class ModuleServiceImpl
implements ModuleService {
    @Autowired
    private ModuleDAO moduleDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public Long createModule(Module module) {
        try {
            Module persistedmodule = this.moduleDAO.save(module);
            Long moduleId = persistedmodule.getModuleId();
            log.info((Object)("Module is created with the id=" + moduleId));
            return moduleId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Module", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteModule(Long moduleId) {
        try {
            Module module = this.moduleDAO.getModuleById(moduleId);
            if (module != null) {
                this.moduleDAO.delete(module);
                log.info((Object)("Module with id=" + moduleId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Module", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Module> moduleList() {
        try {
            List<Module> moduleList = this.moduleDAO.getList();
            Integer moduleListSize = moduleList.size();
            if (moduleListSize > 0) {
                log.info((Object)(moduleListSize + "module records where reterived"));
            } else {
                log.info((Object)"No module(s) available");
            }
            return moduleList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving module list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Module> moduleList(Long institutionId) throws ModuleException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Module> modules = this.moduleDAO.getModulesByInstitution(institution);
                Integer moduleRecordSize = modules.size();
                if (moduleRecordSize > 0) {
                    log.info((Object)(moduleRecordSize + " module records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No module Records found for institution " + institution.getInstitutionAliasName()));
                }
                return modules;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new ModuleException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving modules of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Module moduleById(Long moduleId) {
        try {
            Module module = this.moduleDAO.getModuleById(moduleId);
            if (module != null) {
                log.info((Object)("module with id=" + moduleId + " has been reterived"));
                return module;
            }
            log.info((Object)("No module with  id=" + moduleId + " is available"));
            return module;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving module by id=" + moduleId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void update(Module module) {
        try {
            this.moduleDAO.saveOrUpdate(module);
            Long moduleId = module.getModuleId();
            if (moduleId != null) {
                log.info((Object)("module with id=" + moduleId + " has been updated"));
            } else {
                log.info((Object)"New module has been added, because no module found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating module", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Module moduleByModuleName(String moduleName) {
        try {
            Module module = this.moduleDAO.getModuleByModuleName(moduleName);
            if (module != null) {
                log.info((Object)("module with name=" + moduleName + " has been reterived"));
                return module;
            }
            log.info((Object)("No module with  name=" + moduleName + " is available"));
            return module;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving module by name=" + moduleName), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Module moduleByModuleNameAndInstitution(String moduleName, Long institutionId) {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            Module module = this.moduleDAO.getModuleByModuleNameAndInstitution(moduleName, institution);
            if (module != null) {
                log.info((Object)("module with name=" + moduleName + " has been reterived"));
                return module;
            }
            log.info((Object)("No module with  name=" + moduleName + " is available"));
            return module;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving module by name=" + moduleName), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
