/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.Table
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_license")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class License
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long licenseId;
    private String customerCode;
    private String licenseCode;
    private String status;
    private String motherBoardSerialNumber;
    private String mACAddress;
    private String ipAddress;

    public License(String customerCode, String licenseCode) {
        this.customerCode = customerCode;
        this.licenseCode = licenseCode;
    }

    License() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="license_id", nullable=false)
    public Long getLicenseId() {
        return this.licenseId;
    }

    public void setLicenseId(Long licenseId) {
        this.licenseId = licenseId;
    }

    @Column(name="customer_code", nullable=false, length=255)
    public String getCustomerCode() {
        return this.customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Column(name="license_code", nullable=false, length=255)
    public String getLicenseCode() {
        return this.licenseCode;
    }

    public void setLicenseCode(String licenseCode) {
        this.licenseCode = licenseCode;
    }

    @Column(name="license_status", nullable=false, length=255)
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name="mother_board_serial_number", nullable=true, length=255)
    public String getMotherBoardSerialNumber() {
        return this.motherBoardSerialNumber;
    }

    public void setMotherBoardSerialNumber(String motherBoardSerialNumber) {
        this.motherBoardSerialNumber = motherBoardSerialNumber;
    }

    @Column(name="mac_address", nullable=true, length=255)
    public String getmACAddress() {
        return this.mACAddress;
    }

    public void setmACAddress(String mACAddress) {
        this.mACAddress = mACAddress;
    }

    @Column(name="ip_address", nullable=true, length=255)
    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
