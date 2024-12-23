/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.CoScholasticActivity;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CoScholasticActivityService {
    public static final Logger log = LogManager.getLogger((String)CoScholasticActivityService.class.getName());

    public List<CoScholasticActivity> coScholasticActivityList();

    public CoScholasticActivity coScholasticActivityById(Long var1);

    public List<CoScholasticActivity> coScholasticActivityListEager();

    public CoScholasticActivity coScholasticActivityByIdEager(Long var1);
}
