/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Privilege;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PrivilegeService {
    public static final Logger log = LogManager.getLogger((String)PrivilegeService.class.getName());

    public List<Privilege> privilegeList();

    public Privilege privilegeById(Long var1);

    public List<Privilege> staffAndAdminPrivileges();

    public List<Privilege> privilegesBasedOn(String var1, Long var2);
}
