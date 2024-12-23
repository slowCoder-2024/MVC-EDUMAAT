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
@Table(name="tbl_religion", uniqueConstraints={@UniqueConstraint(columnNames={"religion_name"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class Religion
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long religionId;
    private String religionName;
    private Set<Admission> admissionListByReligion = new HashSet<Admission>(0);

    public Religion() {
    }

    public Religion(String religionName) {
        this.religionName = WordUtils.capitalize((String)religionName);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="religion_id", unique=true, nullable=false)
    public Long getReligionId() {
        return this.religionId;
    }

    public void setReligionId(Long religionId) {
        this.religionId = religionId;
    }

    @Column(name="religion_name", unique=true, nullable=false, length=40)
    public String getReligionName() {
        return this.religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = WordUtils.capitalize((String)religionName);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="religion")
    public Set<Admission> getAdmissionListByReligion() {
        return this.admissionListByReligion;
    }

    public void setAdmissionListByReligion(Set<Admission> admissionListByReligion) {
        this.admissionListByReligion = admissionListByReligion;
    }
}
