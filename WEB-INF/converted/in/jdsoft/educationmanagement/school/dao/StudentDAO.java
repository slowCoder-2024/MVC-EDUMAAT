/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Criteria
 *  org.hibernate.criterion.Conjunction
 *  org.hibernate.criterion.Criterion
 *  org.hibernate.criterion.Restrictions
 *  org.springframework.stereotype.Repository
 */
package in.jdsoft.educationmanagement.school.dao;

import in.jdsoft.educationmanagement.school.dao.GenericDAO;
import in.jdsoft.educationmanagement.school.model.BloodGroup;
import in.jdsoft.educationmanagement.school.model.Category;
import in.jdsoft.educationmanagement.school.model.Class;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.model.SpecialCategory;
import in.jdsoft.educationmanagement.school.model.Student;
import in.jdsoft.educationmanagement.school.model.StudentStatus;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO
extends GenericDAO<Student> {
    public StudentDAO() {
        super(Student.class);
    }

    public Student getStudentById(Long id) {
        Student instance = (Student)this.sessionFactory.getCurrentSession().get("in.jdsoft.educationmanagement.school.model.Student", (Serializable)id);
        return instance;
    }

    public Student getStudentByAdmissionNo(String admissionNo) {
        try {
            Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
            studentCriteria.add((Criterion)Restrictions.eq((String)"admissionNo", (Object)admissionNo));
            Student student = (Student)studentCriteria.uniqueResult();
            return student;
        }
        catch (Exception re) {
            re.printStackTrace();
            throw re;
        }
    }

    public Student getStudentByEmail(String Email) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.eq((String)"email", (Object)Email));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public Student getStudentByParentEmail(String Email) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.eq((String)"parentGuardianEmail", (Object)Email));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public Student getStudentByAdmissionNoAndStatus(String admissionNo, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"admissionNo", (Object)admissionNo)).add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus)));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public List<Student> getStudentsByStatus(Institution institution, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }

    public List<Student> getStudentListByStatus(StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }

    public List<Student> getStudentsByStatusAndClass(Institution institution, StudentStatus studentStatus, Class classes) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }

    public List<Student> getStudentsByStatusAndClassAndSectionAndInstitution(Institution institution, StudentStatus studentStatus, Class classes, Section section) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus));
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }

    public List<Student> getStudentsBySpecialCategory(Institution institution, SpecialCategory specialCategory) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "specialcategory");
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        and.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"specialcategory.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        studentCriteria.add((Criterion)and);
        return studentCriteria.list();
    }

    public List<Student> getStudentsByClassAndSection(Class clazz, Section section) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)));
        List students = studentCriteria.list();
        return students;
    }

    public List<Student> getStudentsByClassAndSectionAndStatus(Class clazz, Section section, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus)));
        List students = studentCriteria.list();
        return students;
    }

    public Student getStudentsByClassAndSectionAndAdmissionNo(Class clazz, Section section, String admissionNo) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"admissionNo", (Object)admissionNo)));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public Student getStudentsByClassAndSectionAndAdmissionNoAndStatus(Class clazz, Section section, String admissionNo, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"admissionNo", (Object)admissionNo)).add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus)));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public List<Student> getStudentsByClassSectionAndStatus(Class clazz, Section section, StudentStatus status) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"studentStatus", (Object)status)));
        List students = studentCriteria.list();
        return students;
    }

    public List<Student> getStudentsByClassSectionAndSpecialCategory(Class clazz, Section section, SpecialCategory specialCategory) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)));
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = studentCriteria.list();
        return students;
    }

    public List<Student> getStudentsByClassSectionAndSpecialCategoryAndStatus(Class clazz, Section section, SpecialCategory specialCategory, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus)));
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = studentCriteria.list();
        return students;
    }

    public Student getStudentsByClassSectionAndAdmissionNo(Class clazz, Section section, String admissionNo) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)clazz)).add((Criterion)Restrictions.eq((String)"section", (Object)section)).add((Criterion)Restrictions.eq((String)"admissionNo", (Object)admissionNo)));
        Student student = (Student)studentCriteria.uniqueResult();
        return student;
    }

    public List<Student> getStudentsByInstitution(Institution institution) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        List students = criteria.list();
        return students;
    }

    public List<Student> getStudentsByInstitutionAndBloodGroup(Institution institution, BloodGroup bloodGroup) {
        Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        criteria.add((Criterion)Restrictions.eq((String)"institution", (Object)institution));
        criteria.add((Criterion)Restrictions.eq((String)"bloodGroup", (Object)bloodGroup));
        List students = criteria.list();
        return students;
    }

    public List<Student> getStudentAttendanceByClassAndSection(Class classs, Section section) {
        Criteria staffModuleAttendanceCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        Conjunction and = Restrictions.conjunction();
        and.add((Criterion)Restrictions.eq((String)"studentClass", (Object)classs));
        and.add((Criterion)Restrictions.eq((String)"section", (Object)section));
        staffModuleAttendanceCriteria.add((Criterion)and);
        return staffModuleAttendanceCriteria.list();
    }

    public Integer getMaleStudentCountInSpecialCategory(SpecialCategory specialCategory) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public Integer getMaleStudentCountInSpecialCategoryAndInstitution(SpecialCategory specialCategory, Institution institution) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public List<Student> getStudentsBySpecialCategory(SpecialCategory specialCategory) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students;
    }

    public Integer getFemaleStudentCountInSpecialCategory(SpecialCategory specialCategory) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public Integer getFemaleStudentCountInSpecialCategoryAndInstitution(SpecialCategory specialCategory, Institution institution) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public Integer getOtherStudentCountInSpecialCategory(SpecialCategory specialCategory) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public Integer getOtherStudentCountInSpecialCategoryAndInstitution(SpecialCategory specialCategory, Institution institution) {
        Criteria specialCategoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        specialCategoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = specialCategoryCriteria.list();
        return students.size();
    }

    public Integer getFemaleStudentCountInCategory(Category category) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getFemaleStudentCountInCategoryAndInstitution(Category category, Institution institution) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getMaleStudentCountInCategory(Category category) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getMaleStudentCountInCategoryAndInstitution(Category category, Institution institution) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getOtherStudentCountInCategory(Category category) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getOtherStudentCountInCategoryAndInstitution(Category category, Institution institution) {
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"category", (Object)category)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        return students.size();
    }

    public Integer getMaleStudentCountInClass(Class classes) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public Integer getMaleStudentCountInClassAndInstitution(Class classes, Institution institution) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Male")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public Integer getFemaleStudentCountInClass(Class classes) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public Integer getFemaleStudentCountInClassAndInstitution(Class classes, Institution institution) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Female")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public Integer getOtherStudentCountInClass(Class classes) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public Integer getOtherStudentCountInClassAndInstitution(Class classes, Institution institution) {
        Integer count = 0;
        Criteria categoryCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class);
        categoryCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentClass", (Object)classes)).add((Criterion)Restrictions.eq((String)"sex", (Object)"Others")).add((Criterion)Restrictions.eq((String)"institution", (Object)institution)));
        List students = categoryCriteria.list();
        if (students.size() > 0) {
            count = students.size();
        }
        return count;
    }

    public List<Student> getStudentsBySpecialCategoryAndStatus(SpecialCategory specialCategory, StudentStatus studentStatus) {
        Criteria studentCriteria = this.sessionFactory.getCurrentSession().createCriteria(Student.class).createAlias("specialCategories", "sc");
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"studentStatus", (Object)studentStatus)));
        studentCriteria.add((Criterion)Restrictions.conjunction().add((Criterion)Restrictions.eq((String)"sc.specialCategoryName", (Object)specialCategory.getSpecialCategoryName())));
        List students = studentCriteria.list();
        return students;
    }
}
