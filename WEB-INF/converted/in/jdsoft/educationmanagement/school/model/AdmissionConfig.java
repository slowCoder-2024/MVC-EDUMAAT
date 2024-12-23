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
 *  javax.persistence.JoinColumn
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  javax.persistence.UniqueConstraint
 *  org.apache.commons.lang.WordUtils
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import in.jdsoft.educationmanagement.school.model.Admission;
import in.jdsoft.educationmanagement.school.model.AdmissionProcessStatus;
import in.jdsoft.educationmanagement.school.model.Class;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang.WordUtils;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_admission_config", uniqueConstraints={@UniqueConstraint(columnNames={"admission_application_code_format"})})
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
public class AdmissionConfig
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long admissionConfigId;
    private String admissionProcessYear;
    private Date admissionStartDate;
    private Date admissionEndDate;
    private AdmissionProcessStatus admissionProcessStatus;
    private String applicationCodeFormat;
    private Double applicationFees;
    private Long applicationTotalSeats;
    private Set<Admission> admissions = new HashSet<Admission>(0);
    private Set<Class> classes = new LinkedHashSet<Class>();

    public AdmissionConfig() {
    }

    public AdmissionConfig(AdmissionProcessStatus admissionProcessStatus, String admissionProcessYear, Date admissionStartDate, Date admissionEndDate, String applicationCodeFormat, Double applicationFees, Long applicationTotalSeats, Set<Class> classes) {
        this.admissionProcessYear = admissionProcessYear;
        this.admissionStartDate = admissionStartDate;
        this.admissionEndDate = admissionEndDate;
        this.applicationCodeFormat = WordUtils.capitalize((String)applicationCodeFormat);
        this.admissionProcessStatus = admissionProcessStatus;
        this.applicationFees = applicationFees;
        this.applicationTotalSeats = applicationTotalSeats;
        this.classes = classes;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="admission_config_id", unique=true, nullable=false)
    public Long getAdmissionConfigId() {
        return this.admissionConfigId;
    }

    public void setAdmissionConfigId(Long admissionConfigId) {
        this.admissionConfigId = admissionConfigId;
    }

    @Column(name="admission_process_year", nullable=false, length=10)
    public String getAdmissionProcessYear() {
        return this.admissionProcessYear;
    }

    public void setAdmissionProcessYear(String admissionProcessYear) {
        this.admissionProcessYear = admissionProcessYear;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="admission_start_date", nullable=false)
    public Date getAdmissionStartDate() {
        return this.admissionStartDate;
    }

    public void setAdmissionStartDate(Date admissionStartDate) {
        this.admissionStartDate = admissionStartDate;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="admission_end_date", nullable=false)
    public Date getAdmissionEndDate() {
        return this.admissionEndDate;
    }

    public void setAdmissionEndDate(Date admissionEndDate) {
        this.admissionEndDate = admissionEndDate;
    }

    @Column(name="admission_application_code_format", nullable=false, length=20)
    public String getApplicationCodeFormat() {
        return this.applicationCodeFormat;
    }

    public void setApplicationCodeFormat(String applicationCodeFormat) {
        this.applicationCodeFormat = WordUtils.capitalize((String)applicationCodeFormat);
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="admission_process_status_id", nullable=false)
    public AdmissionProcessStatus getAdmissionProcessStatus() {
        return this.admissionProcessStatus;
    }

    public void setAdmissionProcessStatus(AdmissionProcessStatus admissionProcessStatus) {
        this.admissionProcessStatus = admissionProcessStatus;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="admissionConfig")
    public Set<Admission> getAdmissions() {
        return this.admissions;
    }

    public void setAdmissions(Set<Admission> admissions) {
        this.admissions = admissions;
    }

    @Column(name="application_fees", nullable=false)
    public Double getApplicationFees() {
        return this.applicationFees;
    }

    public void setApplicationFees(Double applicationFees) {
        this.applicationFees = applicationFees;
    }

    @Column(name="application_total_seats", nullable=false)
    public Long getApplicationTotalSeats() {
        return this.applicationTotalSeats;
    }

    public void setApplicationTotalSeats(Long applicationTotalSeats) {
        this.applicationTotalSeats = applicationTotalSeats;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_admission_config_class", joinColumns={@JoinColumn(name="admission_config_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="class_id", updatable=true)})
    @ForeignKey(name="admissionConfigInClass")
    public Set<Class> getClasses() {
        return this.classes;
    }

    public void setClasses(Set<Class> classes) {
        this.classes = classes;
    }
}
