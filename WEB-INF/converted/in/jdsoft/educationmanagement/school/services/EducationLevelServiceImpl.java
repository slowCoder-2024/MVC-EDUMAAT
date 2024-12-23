/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.hibernate.Hibernate
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.EducationLevelDAO;
import in.jdsoft.educationmanagement.school.dao.EducationLevelSubjectDAO;
import in.jdsoft.educationmanagement.school.model.EducationLevel;
import in.jdsoft.educationmanagement.school.model.EducationLevelSubject;
import in.jdsoft.educationmanagement.school.services.EducationLevelService;
import java.util.ArrayList;
import java.util.Set;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="educationLevelService")
public class EducationLevelServiceImpl
implements EducationLevelService {
    @Autowired
    EducationLevelDAO educationLevelDAO;
    @Autowired
    EducationLevelSubjectDAO educationLevelSubjectDAO;

    @Override
    public void addEducationLevel(EducationLevel educationLevel) {
        this.educationLevelDAO.persist(educationLevel);
    }

    @Override
    public ArrayList<EducationLevel> getEducationLevelList() {
        return (ArrayList)this.educationLevelDAO.getList();
    }

    @Override
    public void deleteEducationLevel(Long educationLevelId) {
        this.educationLevelDAO.delete(this.educationLevelDAO.getEducationLevelById(educationLevelId));
    }

    @Override
    public void updateEducationLevel(EducationLevel educationLevel) {
        this.educationLevelDAO.update(educationLevel);
    }

    @Override
    public EducationLevel getEducationLevelById(Long educationLevelId) {
        return this.educationLevelDAO.getEducationLevelById(educationLevelId);
    }

    @Override
    public EducationLevel getEducationLevelLazyById(Long educationLevelId) {
        EducationLevel educationLevel = this.educationLevelDAO.getEducationLevelById(educationLevelId);
        Hibernate.initialize(educationLevel.getEducationLevelSubjects());
        return educationLevel;
    }

    @Override
    public void addEducationLevelSubject(EducationLevelSubject educationLevelSubject) {
        this.educationLevelSubjectDAO.persist(educationLevelSubject);
    }

    @Override
    public ArrayList<EducationLevelSubject> getEducationLevelSubjectList() {
        return (ArrayList)this.educationLevelSubjectDAO.getList();
    }

    @Override
    public void deleteEducationLevelSubject(Long educationLevelSubjectId) {
        this.educationLevelSubjectDAO.delete(this.educationLevelSubjectDAO.getEducationLevelSubjectById(educationLevelSubjectId));
    }

    @Override
    public void updateEducationLevelSubject(EducationLevelSubject educationLevelSubject) {
        this.educationLevelSubjectDAO.update(educationLevelSubject);
    }

    @Override
    public EducationLevelSubject getEducationLevelSubjectById(Long educationLevelSubjectId) {
        return this.educationLevelSubjectDAO.getEducationLevelSubjectById(educationLevelSubjectId);
    }

    @Override
    public Set<EducationLevelSubject> getEducationLevelSubjectByEducationLevelId(Long educationLevelId) {
        EducationLevel educationLevel = this.educationLevelDAO.getEducationLevelById(educationLevelId);
        Hibernate.initialize(educationLevel.getEducationLevelSubjects());
        return educationLevel.getEducationLevelSubjects();
    }
}
