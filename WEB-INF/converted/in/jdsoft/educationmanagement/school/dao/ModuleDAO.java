/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Module;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class ModuleDAO
extends GenericDAO<Module> {
    public ModuleDAO() {
        super(Module.class);
    }

    public Module getModuleById(Long id) {
        Module instance = (Module)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Module", (Serializable)id);
        return instance;
    }

    public List<Module> getModulesByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Module.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List modules = criteria.list();
        return modules;
    }

    public Module getModuleByModuleName(String moduleName) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Module.class);
        criteria.add((Criterion)Restrictions.eq((String)"moduleName", (Object)moduleName));
        Module module = (Module)criteria.uniqueResult();
        return module;
    }

    public Module getModuleByModuleNameAndInstitution(String moduleName, Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Module.class);
        criteria.add((Criterion)Restrictions.eq((String)"moduleName", (Object)moduleName));
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        Module module = (Module)criteria.uniqueResult();
        return module;
    }
}
