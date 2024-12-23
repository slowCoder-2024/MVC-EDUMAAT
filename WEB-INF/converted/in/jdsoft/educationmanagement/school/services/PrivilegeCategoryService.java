/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.PrivilegeCategory;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PrivilegeCategoryService {
    public static final Logger log = LogManager.getLogger((String)PrivilegeCategoryService.class.getName());

    public List<PrivilegeCategory> privilegeCategoryList();

    public PrivilegeCategory privilegeCategoryById(Long var1);
}
