/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.RequisitionType;
import in.jdsoft.educationmanagement.school.model.User;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RequisitionTypeService {
    public static final Logger log = LogManager.getLogger((String)RequisitionTypeService.class.getName());

    public Long createRequisitionType(RequisitionType var1);

    public void deleteRequisitionType(Long var1);

    public List<RequisitionType> requisitionTypeList();

    public RequisitionType requisitionTypeById(Long var1);

    public RequisitionType requisitionTypeByIdEager(Long var1);

    public void updateRequisitionType(RequisitionType var1);

    public List<RequisitionType> requisitionTypeListByUser(User var1);

    public List<RequisitionType> requisitionTypeListInventoryAndPurchaseByUser(User var1);
}
