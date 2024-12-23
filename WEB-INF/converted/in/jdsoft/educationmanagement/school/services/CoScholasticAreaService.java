/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.CoScholasticArea;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CoScholasticAreaService {
    public static final Logger log = LogManager.getLogger((String)CoScholasticAreaService.class.getName());

    public List<CoScholasticArea> coScholasticAreaList();

    public CoScholasticArea coScholasticAreaById(Long var1);

    public List<CoScholasticArea> coScholasticAreaListEager();

    public CoScholasticArea coScholasticAreaByIdEager(Long var1);
}
