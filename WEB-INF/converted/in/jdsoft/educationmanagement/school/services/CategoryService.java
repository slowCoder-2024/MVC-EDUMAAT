/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CategoryService {
    public static final Logger log = LogManager.getLogger((String)CategoryService.class.getName());

    public List<Category> categoryList();

    public Category categoryById(Long var1);

    public ThreeFieldReports getStudentRatioFromCategory(Long var1);

    public ThreeFieldReports getStudentRatioFromCategoryAndInstitution(Long var1, Long var2);
}
