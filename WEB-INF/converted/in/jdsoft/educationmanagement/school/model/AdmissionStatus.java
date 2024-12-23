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
@Table(name="tbl_admission_status", uniqueConstraints={@UniqueConstraint(columnNames={"admission_status_title"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionStatus
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionStatusId;
    private String admissionStatusTitle;
    private Set<Admission> admissions = new HashSet<Admission>(0);

    public AdmissionStatus() {
    }

    public AdmissionStatus(String admissionStatusTitle) {
        this.admissionStatusTitle = WordUtils.capitalize((String)admissionStatusTitle);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_status_id", unique=true, nullable=false)
    public Long getAdmissionStatusId() {
        return this.admissionStatusId;
    }

    public void setAdmissionStatusId(Long admissionStatusId) {
        this.admissionStatusId = admissionStatusId;
    }

    @Column(name="admission_status_title", unique=true, nullable=false, length=50)
    public String getAdmissionStatusTitle() {
        return this.admissionStatusTitle;
    }

    public void setAdmissionStatusTitle(String admissionStatusTitle) {
        this.admissionStatusTitle = WordUtils.capitalize((String)admissionStatusTitle);
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admissionStatus")
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }
}
