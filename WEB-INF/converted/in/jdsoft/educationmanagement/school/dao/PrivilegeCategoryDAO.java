/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.PrivilegeCategory;
import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class PrivilegeCategoryDAO
extends GenericDAO<PrivilegeCategory> {
    public PrivilegeCategoryDAO() {
        super(PrivilegeCategory.class);
    }

    public PrivilegeCategory getPrivilegeCategoryById(Long id) {
        PrivilegeCategory instance = (PrivilegeCategory)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.PrivilegeCategory", (Serializable)id);
        return instance;
    }
}
