/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package in.jdsoft.educationmanagement.school.services;

import in.jdsoft.educationmanagement.school.dao.InstitutionDAO;
import in.jdsoft.educationmanagement.school.dao.SectionDAO;
import in.jdsoft.educationmanagement.school.exceptions.SectionException;
import in.jdsoft.educationmanagement.school.model.Institution;
import in.jdsoft.educationmanagement.school.model.Message;
import in.jdsoft.educationmanagement.school.model.Section;
import in.jdsoft.educationmanagement.school.services.SectionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="sectionService")
public class SectionServiceImpl
implements SectionService {
    @Autowired
    private SectionDAO sectionDAO;
    @Autowired
    private InstitutionDAO institutionDAO;

    @Override
    public Long createSection(Section section) {
        try {
            Section persistedsection = this.sectionDAO.save(section);
            Long sectionId = persistedsection.getSectionId();
            log.info((Object)("Section is created with the id=" + sectionId));
            return sectionId;
        }
        catch (Exception e) {
            log.error((Object)"Exception in Creating Section", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteSection(Long sectionId) {
        try {
            Section section = this.sectionDAO.getSectionById(sectionId);
            if (section != null) {
                this.sectionDAO.delete(section);
                log.info((Object)("Section with id=" + sectionId + " has been deleted successfully"));
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in deleting Section", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Section> sectionList() {
        try {
            List<Section> sectionList = this.sectionDAO.getList();
            Integer listSize = sectionList.size();
            if (listSize > 0) {
                log.info((Object)(listSize + " section records where reterived"));
            } else {
                log.info((Object)"No section(s) available");
            }
            return sectionList;
        }
        catch (Exception e) {
            log.error((Object)"Exception in reteriving section list", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Section sectionById(Long sectionId) {
        try {
            Section section = this.sectionDAO.getSectionById(sectionId);
            if (section != null) {
                log.info((Object)("section with id=" + sectionId + " has been reterived"));
                return section;
            }
            log.info((Object)("No section with  id=" + sectionId + " is available"));
            return section;
        }
        catch (Exception e) {
            log.error((Object)("Exception in reteriving section by id=" + sectionId), e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void updateSection(Section section) {
        try {
            this.sectionDAO.saveOrUpdate(section);
            Long sectionId = section.getSectionId();
            if (sectionId != null) {
                log.info((Object)("section with id=" + sectionId + " has been updated"));
            } else {
                log.info((Object)"New section has been added, because no section found for update");
            }
        }
        catch (Exception e) {
            log.error((Object)"Exception in updating section", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Section> sectionList(Long institutionId) throws SectionException {
        try {
            Institution institution = this.institutionDAO.getInstitutionById(institutionId);
            if (institution != null) {
                List<Section> sections = this.sectionDAO.getSectionsByInstitution(institution);
                Integer sectionRecordSize = sections.size();
                if (sectionRecordSize > 0) {
                    log.info((Object)(sectionRecordSize + " section records of institution " + institution.getInstitutionAliasName() + " where reterived"));
                } else {
                    log.info((Object)("No section Records found for institution " + institution.getInstitutionAliasName()));
                }
                return sections;
            }
            throw new NullPointerException("Invalid Institution Id");
        }
        catch (Exception e) {
            if (e.getClass().equals(NullPointerException.class)) {
                log.error((Object)"NullPointerException", e.getCause());
                throw new SectionException(new Message("nullpointer", e.getMessage()));
            }
            log.error((Object)"Exception in reteriving sections of Institution", e.getCause());
            e.printStackTrace();
            throw e;
        }
    }
}
