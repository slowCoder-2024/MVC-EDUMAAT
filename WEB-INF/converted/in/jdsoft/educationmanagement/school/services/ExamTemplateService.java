/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.ExamTemplateException;
import in.jdsoft.educationmanagement.school.model.ExamTemplate;
import in.jdsoft.educationmanagement.school.model.Term;
import in.jdsoft.educationmanagement.school.model.TermExam;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ExamTemplateService {
    public static final Logger log = LogManager.getLogger((String)ExamTemplateService.class.getName());

    public void createExamTemplate(ExamTemplate var1, Set<Term> var2, Set<TermExam> var3) throws ExamTemplateException;

    public void updateExamTemplate(ExamTemplate var1, Set<Term> var2, Set<TermExam> var3) throws ExamTemplateException;

    public void deleteExamTemplate(Long var1) throws ExamTemplateException;

    public ExamTemplate examTemplateById(Long var1);

    public ExamTemplate examTemplateIdByEager(Long var1);

    public List<ExamTemplate> examTemplateList();

    public List<ExamTemplate> examTemplateList(Long var1) throws ExamTemplateException;

    public List<ExamTemplate> examTemplateListEager(Long var1) throws ExamTemplateException;
}
