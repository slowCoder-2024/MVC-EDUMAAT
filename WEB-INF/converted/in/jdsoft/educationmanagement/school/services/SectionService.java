/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.log4j.LogManager
 *  org.apache.log4j.Logger
 *  org.springframework.transaction.annotation.Transactional
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.exceptions.SectionException;
import in.jdsoft.educationmanagement.school.model.Section;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SectionService {
    public static final Logger log = LogManager.getLogger((String)SectionService.class.getName());

    public Long createSection(Section var1);

    public void deleteSection(Long var1);

    public List<Section> sectionList();

    public List<Section> sectionList(Long var1) throws SectionException;

    public Section sectionById(Long var1);

    public void updateSection(Section var1);
}
