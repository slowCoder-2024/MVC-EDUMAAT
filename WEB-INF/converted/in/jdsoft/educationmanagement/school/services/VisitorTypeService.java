/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.VisitorType;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VisitorTypeService {
    public static final Logger log = LogManager.getLogger((String)VisitorTypeService.class.getName());

    public Long createVisitorType(VisitorType var1);

    public void deleteVisitorType(Long var1);

    public List<VisitorType> visitorTypeList();

    public VisitorType visitorTypeById(Long var1);

    public VisitorType visitorTypeByIdEager(Long var1);

    public void updateVisitorType(VisitorType var1);
}
