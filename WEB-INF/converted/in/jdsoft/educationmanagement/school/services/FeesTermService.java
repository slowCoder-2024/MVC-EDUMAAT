/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.FeesTermException;
import in.jdsoft.educationmanagement.school.model.FeesTerm;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FeesTermService {
    public static final Logger log = LogManager.getLogger((String)FeesTermService.class.getName());

    public Long createFeesTerm(FeesTerm var1);

    public void deleteFeesTerm(Long var1);

    public List<FeesTerm> feesTermList();

    public Set<FeesTerm> feesTermList(Long var1) throws FeesTermException;

    public FeesTerm feesTermById(Long var1);

    public void update(FeesTerm var1);
}
