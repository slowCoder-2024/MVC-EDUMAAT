/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.FeesItemException;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FeesItemService {
    public static final Logger log = LogManager.getLogger((String)FeesItemService.class.getName());

    public Long createFeesItem(FeesItem var1);

    public void deleteFeesItem(Long var1);

    public List<FeesItem> feesItemList();

    public List<FeesItem> feesItemList(Long var1) throws FeesItemException;

    public FeesItem feesItemById(Long var1);

    public void updateFeesItem(FeesItem var1);
}
