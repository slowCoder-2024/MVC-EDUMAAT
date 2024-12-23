/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SpecialCategoryDAO;
import in.jdsoft.educationmanagement.school.dao.StudentDAO;
import in.jdsoft.educationmanagement.school.exceptions.SpecialCategoryException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.reports.model.ThreeFieldReports;
import in.jdsoft.educationmanagement.school.services.SpecialCategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="specialCategoryService")
public class SpecialCategoryServiceImpl
implements SpecialCategoryService {
    @Autowired
    SpecialCategoryDAO specialCategoryDAO;
    @Autowired
    InstitutionDAO institutionDAO;
    @Autowired
    StudentDAO studentDAO;

    @Override
    public Long createSpecialCategory(SpecialCategory specialCategory) {
        try {
            SpecialCategory persistedSpecialCategory = this.specialCategoryDAO.save(specialCategory);
            Long specialCategoryId = persistedSpecialCategory.getSpecialCategoryId();
            log.info((Object)("Special Category created with the id=" + specialCategoryId));
            return specialCategoryId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Special Category", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteSpecialCategory(Long specialCategoryId) {
        try {
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            if (specialCategory != null) {
                this.specialCategoryDAO.delete(specialCategory);
                log.info((Object)("Special Category with id=" + specialCategoryId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Special Category", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SpecialCategory> specialCategoryList() {
        try {
            List<SpecialCategory> specialCategoryList = this.specialCategoryDAO.getList();
            Integer specialCategoryListSize = specialCategoryList.size();
            if (specialCategoryListSize > 0) {
                log.info((Object)(specialCategoryListSize + " special category records where reterived"));
            } else {
                log.info((Object)"No special category list available");
            }
            return specialCategoryList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving special category list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<SpecialCategory> specialCategoryList(Long institutionId) throws SpecialCategoryException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<SpecialCategory> specialCategories = this.specialCategoryDAO.getSpecialCategoryByInstitution(institution);
                Integer specialCategoriesRecordSize = specialCategories.size();
                if (specialCategoriesRecordSize > 0) {
                    log.info((Object)(specialCategoriesRecordSize + " special category records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No Special Category Records found for institution " + institution.getInstitutionAliasName()));
                }
                return specialCategories;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new SpecialCategoryException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving special category of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public SpecialCategory specialCategoryById(Long specialCategoryId) {
        try {
            SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(specialCategoryId);
            if (specialCategory != null) {
                log.info((Object)("Special Category with id=" + specialCategoryId + " has been reterived"));
                return specialCategory;
            }
            log.info((Object)("No special category with  id=" + specialCategoryId + " is available"));
            return specialCategory;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving special category by id=" + specialCategoryId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSpecialCategory(SpecialCategory specialCategory) {
        try {
            this.specialCategoryDAO.saveOrUpdate(specialCategory);
            Long specialCategoryId = specialCategory.getSpecialCategoryId();
            if (specialCategoryId != null) {
                log.info((Object)("Special Category with id=" + specialCategoryId + " has been updated"));
            } else {
                log.info((Object)"New Special Category has been added, because no special category found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating special category", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public ThreeFieldReports getStudentRatioFromSpecialCategory(Long SpecialCategoryId) {
        SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(SpecialCategoryId);
        Integer femaleCount = this.studentDAO.getFemaleStudentCountInSpecialCategory(specialCategory);
        Integer maleCount = this.studentDAO.getMaleStudentCountInSpecialCategory(specialCategory);
        Integer otherCount = this.studentDAO.getOtherStudentCountInSpecialCategory(specialCategory);
        return new ThreeFieldReports(maleCount, femaleCount, otherCount);
    }

    @Override
    public ThreeFieldReports getStudentRatioFromSpecialCategoryByInstitution(Long SpecialCategoryId, Long institutionId) {
        Institution institution = this.institutionDAO.getInstitutionById(institutionId);
        SpecialCategory specialCategory = this.specialCategoryDAO.getSpecialCategoryById(SpecialCategoryId);
        Integer femaleCount = this.studentDAO.getFemaleStudentCountInSpecialCategoryAndInstitution(specialCategory, institution);
        Integer maleCount = this.studentDAO.getMaleStudentCountInSpecialCategoryAndInstitution(specialCategory, institution);
        Integer otherCount = this.studentDAO.getOtherStudentCountInSpecialCategoryAndInstitution(specialCategory, institution);
        return new ThreeFieldReports(maleCount, femaleCount, otherCount);
    }
}
