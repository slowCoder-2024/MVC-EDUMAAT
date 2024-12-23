/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.FeesStructureException;
import in.jdsoft.educationmanagement.school.model.FeesStructure;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FeesStructureService {
    public static final Logger log = LogManager.getLogger((String)FeesStructureService.class.getName());

    public Long createFeesStructure(FeesStructure var1);

    public void deleteFeesStructure(Long var1);

    public List<FeesStructure> feesStructureList();

    public List<FeesStructure> feesStructureList(Long var1) throws FeesStructureException;

    public List<FeesStructure> feesStructureListEager(Long var1) throws FeesStructureException;

    public FeesStructure feesStructureById(Long var1);

    public FeesStructure feesStructureByIdEager(Long var1);

    public void updateFeesStructure(FeesStructure var1);
}
