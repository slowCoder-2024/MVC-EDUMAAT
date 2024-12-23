/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.Admission;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;

@Entity
@Table(name="tbl_heared_us", uniqueConstraints={@UniqueConstraint(columnNames={"hearedus_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class HearedUs
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long hearedUsId;
    private String hearedUsTitle;
    private Set<Admission> admissionListByHearedUsType = new HashSet<Admission>(0);

    public HearedUs() {
    }

    public HearedUs(String hearedUsTitle) {
        this.hearedUsTitle = WordUtils.capitalize((String)hearedUsTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="hearedus_id", unique=true, nullable=false)
    public Long getHearedUsId() {
        return this.hearedUsId;
    }

    public void setHearedUsId(Long hearedUsId) {
        this.hearedUsId = hearedUsId;
    }

    @Column(name="hearedus_title", unique=true, nullable=false, length=40)
    public String getHearedUsTitle() {
        return this.hearedUsTitle;
    }

    public void setHearedUsTitle(String hearedUsTitle) {
        this.hearedUsTitle = WordUtils.capitalize((String)hearedUsTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="hearedUs")
    public Set<Admission> getAdmissionListByHearedUsType() {
        return this.admissionListByHearedUsType;
    }

    public void setAdmissionListByHearedUsType(Set<Admission> admissionListByHearedUsType) {
        this.admissionListByHearedUsType = admissionListByHearedUsType;
    }
}
