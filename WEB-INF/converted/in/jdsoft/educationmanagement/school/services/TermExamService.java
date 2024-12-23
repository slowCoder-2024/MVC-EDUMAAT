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
import in.jdsoft.educationmanagement.school.model.TermExam;
import java.util.List;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TermExamService {
    public static final Logger log = LogManager.getLogger((String)TermExamService.class.getName());

    public List<TermExam> termExamList();

    public TermExam termExamById(Long var1);

    public void deleteTermExam(Long var1) throws ExamTemplateException;

    public void deleteAllTermExam(Set<TermExam> var1) throws ExamTemplateException;
}
