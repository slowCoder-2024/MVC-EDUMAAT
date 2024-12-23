/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.SpecialCategoryException;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SpecialCategoryService {
    public static final Logger log = LogManager.getLogger((String)SpecialCategoryService.class.getName());

    public Long createSpecialCategory(SpecialCategory var1);

    public void deleteSpecialCategory(Long var1);

    public List<SpecialCategory> specialCategoryList();

    public List<SpecialCategory> specialCategoryList(Long var1) throws SpecialCategoryException;

    public SpecialCategory specialCategoryById(Long var1);

    public void updateSpecialCategory(SpecialCategory var1);

    public ThreeFieldReports getStudentRatioFromSpecialCategory(Long var1);

    public ThreeFieldReports getStudentRatioFromSpecialCategoryByInstitution(Long var1, Long var2);
}
