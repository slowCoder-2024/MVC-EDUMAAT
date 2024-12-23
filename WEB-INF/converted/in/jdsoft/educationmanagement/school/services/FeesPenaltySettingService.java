/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.FeesPenaltySettingException;
import in.jdsoft.educationmanagement.school.model.FeesPenaltySetting;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface FeesPenaltySettingService {
    public static final Logger log = LogManager.getLogger((String)FeesPenaltySettingService.class.getName());

    public void createFeesPenaltySetting(FeesPenaltySetting var1) throws FeesPenaltySettingException;

    public void updateFeesPenaltySetting(FeesPenaltySetting var1) throws FeesPenaltySettingException;

    public void deleteFeesPenaltySetting(Long var1) throws FeesPenaltySettingException;

    public FeesPenaltySetting feesPenaltySettingById(Long var1);

    public FeesPenaltySetting feesPenaltySettingIdByEager(Long var1);

    public List<FeesPenaltySetting> feesPenaltySettingList();

    public List<FeesPenaltySetting> feesPenaltySettingListByInstitution(Long var1);

    public FeesPenaltySetting feesPenaltySettingByInstitution(Long var1);

    public FeesPenaltySetting feesPenaltySettingByFeesPenaltySeetingType(String var1);

    public FeesPenaltySetting feesPenaltySettingByFeesPenaltySettingTypeAndInstitution(String var1, Long var2);
}
