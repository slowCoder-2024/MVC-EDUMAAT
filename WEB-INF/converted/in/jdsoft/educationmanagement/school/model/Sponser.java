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
@Table(name="tbl_sponser", uniqueConstraints={@UniqueConstraint(columnNames={"sponser_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Sponser
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long sponserId;
    private String sponserTitle;
    private Set<Admission> admissionListBySponserType = new HashSet<Admission>(0);

    public Sponser() {
    }

    public Sponser(String sponserTitle) {
        this.sponserTitle = WordUtils.capitalize((String)sponserTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="sponser_id", unique=true, nullable=false)
    public Long getSponserId() {
        return this.sponserId;
    }

    public void setSponserId(Long sponserId) {
        this.sponserId = sponserId;
    }

    @Column(name="sponser_title", unique=true, nullable=false, length=40)
    public String getSponserTitle() {
        return this.sponserTitle;
    }

    public void setSponserTitle(String sponserTitle) {
        this.sponserTitle = WordUtils.capitalize((String)sponserTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="sponser")
    public Set<Admission> getAdmissionListBySponserType() {
        return this.admissionListBySponserType;
    }

    public void setAdmissionListBySponserType(Set<Admission> admissionListBySponserType) {
        this.admissionListBySponserType = admissionListBySponserType;
    }
}
