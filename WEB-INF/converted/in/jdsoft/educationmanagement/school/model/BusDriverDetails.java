/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonBackReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import in.jdsoft.educationmanagement.school.model.BusDetails;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_bus_driver_details")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BusDriverDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long busDriverId;
    private String busDriverName;
    private String gender;
    private String contactNumber;
    private String email;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private String postCode;
    private String busDriverCode;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Integer status;
    private Date licenseExpirationDate;
    private String comments;
    private String licenseNumber;
    private BusDetails busDetails;

    public BusDriverDetails(String busDriverName, String gender, String contactNumber, String email, String addressLine1, String addressLine2, String country, String state, String city, String postCode, String busDriverCode, String createdBy, String modifiedBy, Integer status, Date licenseExpirationDate, String comments, String licenseNumber) {
        this.busDriverName = busDriverName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.postCode = postCode;
        this.busDriverCode = busDriverCode;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.licenseExpirationDate = licenseExpirationDate;
        this.comments = comments;
        this.licenseNumber = licenseNumber;
    }

    BusDriverDetails() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bus_driver_id", unique=true, nullable=false)
    public Long getBusDriverId() {
        return this.busDriverId;
    }

    public void setBusDriverId(Long busDriverId) {
        this.busDriverId = busDriverId;
    }

    @Column(name="bus_driver_name", nullable=false, length=150)
    public String getBusDriverName() {
        return this.busDriverName;
    }

    public void setBusDriverName(String busDriverName) {
        this.busDriverName = busDriverName;
    }

    @Column(name="gender", nullable=true, length=15)
    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name="contact_number", nullable=false, length=20)
    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Column(name="email", nullable=false, length=100)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="address_line1", nullable=false, length=255)
    public String getAddressLine1() {
        return this.addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @Column(name="address_line2", nullable=false, length=255)
    public String getAddressLine2() {
        return this.addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Column(name="country", nullable=false, length=100)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name="state", nullable=false, length=100)
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name="city", nullable=false, length=100)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name="post_code", nullable=false, length=10)
    public String getPostCode() {
        return this.postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Column(name="bus_driver_code", nullable=false, length=50)
    public String getBusDriverCode() {
        return this.busDriverCode;
    }

    public void setBusDriverCode(String busDriverCode) {
        this.busDriverCode = busDriverCode;
    }

    @Column(name="comments", nullable=true, length=255)
    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="license_expiration_date", nullable=false)
    public Date getLicenseExpirationDate() {
        return this.licenseExpirationDate;
    }

    public void setLicenseExpirationDate(Date licenseExpirationDate) {
        this.licenseExpirationDate = licenseExpirationDate;
    }

    @Column(name="license_number", nullable=false, length=150)
    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Column(name="created_by", nullable=false, length=100)
    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name="last_modified_by", nullable=false, length=100)
    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="created_date", nullable=false)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name="last_modified_date", nullable=false, columnDefinition="timestamp")
    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name="status", nullable=false, length=20)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @OneToOne(fetch=FetchType.LAZY, mappedBy="busDriverDetails")
    @JsonBackReference
    public BusDetails getBusDetails() {
        return this.busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }
}
