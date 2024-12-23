/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.FeesItem;
import in.jdsoft.educationmanagement.school.model.Institution;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_fees_structure", uniqueConstraints={@UniqueConstraint(columnNames={"fees_structure_name", "institution_id"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class FeesStructure
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long feesStructureId;
    private String feesStructureName;
    private Institution institution;
    private Set<FeesItem> feesItems = new LinkedHashSet<FeesItem>();

    FeesStructure() {
    }

    public FeesStructure(String feesStructureName, Institution institution, Set<FeesItem> feesItems) {
        this.feesStructureName = WordUtils.capitalize((String)feesStructureName);
        this.institution = institution;
        this.setFeesItems(feesItems);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="fees_structure_id", nullable=false)
    public Long getFeesStructureId() {
        return this.feesStructureId;
    }

    public void setFeesStructureId(Long feesStructureId) {
        this.feesStructureId = feesStructureId;
    }

    @Column(name="fees_structure_name", nullable=false, length=100)
    public String getFeesStructureName() {
        return this.feesStructureName;
    }

    public void setFeesStructureName(String feesStructureName) {
        this.feesStructureName = feesStructureName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", nullable=false)
    @ForeignKey(name="feesStructureInInstitution")
    public Institution getInstitution() {
        return this.institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_fees_structure_mapping", joinColumns={@JoinColumn(name="fees_structure_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="fees_item_id", updatable=true)})
    @ForeignKey(name="feesStructuresInFeesItems")
    public Set<FeesItem> getFeesItems() {
        return this.feesItems;
    }

    public void setFeesItems(Set<FeesItem> feesItems) {
        this.feesItems = feesItems;
    }
}
