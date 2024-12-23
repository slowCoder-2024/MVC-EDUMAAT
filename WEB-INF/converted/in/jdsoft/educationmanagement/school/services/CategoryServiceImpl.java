/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.CategoryDAO;
import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.services.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="categoryService")
public class CategoryServiceImpl
implements CategoryService {
    @Autowired
    CategoryDAO categoryDAO;
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    InstitutionDAO institutionDAO;

    @Override
    public List<Category> categoryList() {
        try {
            List<Category> categories = this.categoryDAO.getList();
            Integer categoriesSize = categories.size();
            if (categoriesSize > 0) {
                log.info((Object)(categoriesSize + " category records where reterived"));
            } else {
                log.info((Object)"No category available");
            }
            return categories;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving category list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Category categoryById(Long categoryId) {
        try {
            Category category = this.categoryDAO.getCategoryById(categoryId);
            if (category != null) {
                log.info((Object)("Category with id=" + categoryId + " has been reterived"));
                return category;
            }
            log.info((Object)("No category with  id=" + categoryId + " is available"));
            return category;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving category by id=" + categoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ThreeFieldReports getStudentRatioFromCategory(Long categoryId) {
        Category category = this.categoryDAO.getCategoryById(categoryId);
        Integer femaleCount = this.studentDAO.getFemaleStudentCountInCategory(category);
        Integer maleCount = this.studentDAO.getMaleStudentCountInCategory(category);
        Integer otherCount = this.studentDAO.getOtherStudentCountInCategory(category);
        return new ThreeFieldReports(maleCount, femaleCount, otherCount);
    }

    @Override
    public ThreeFieldReports getStudentRatioFromCategoryAndInstitution(Long categoryId, Long institutionId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        Category category = this.categoryDAO.getCategoryById(categoryId);
        Integer femaleCount = this.studentDAO.getFemaleStudentCountInCategoryAndInstitution(category, institution);
        Integer maleCount = this.studentDAO.getMaleStudentCountInCategoryAndInstitution(category, institution);
        Integer otherCount = this.studentDAO.getOtherStudentCountInCategoryAndInstitution(category, institution);
        return new ThreeFieldReports(maleCount, femaleCount, otherCount);
    }
}
