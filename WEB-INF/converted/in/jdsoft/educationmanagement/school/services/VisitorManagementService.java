/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.VisitorManagement;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VisitorManagementService {
    public static final Logger log = LogManager.getLogger((String)VisitorManagementService.class.getName());

    public Long createVisitorManagement(VisitorManagement var1) throws Exception;

    public void deleteVisitorManagement(Long var1);

    public List<VisitorManagement> visitorManagementList();

    public VisitorManagement visitorManagementById(Long var1);

    public VisitorManagement visitorManagementByIdEager(Long var1);

    public void updateVisitorManagement(VisitorManagement var1);

    public List<VisitorManagement> visitorManagementListByInsitution(Long var1);
}
