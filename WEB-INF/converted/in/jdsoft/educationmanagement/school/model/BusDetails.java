/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.JsonManagedReference
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.OneToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.OrderBy
 *  javax.persistence.Table
 *  javax.persistence.Temporal
 *  javax.persistence.TemporalType
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.BusDriverDetails;
import in.jdsoft.educationmanagement.school.model.BusRoute;
import in.jdsoft.educationmanagement.school.model.BusRouteSchedule;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_bus_details")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BusDetails
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long busDetailId;
    private String busModel;
    private String busRegistrationNumber;
    private String createdBy;
    private String modifiedBy;
    private Date createdDate;
    private Date modifiedDate;
    private Integer status;
    private Date registrationPapersExpirationDate;
    private Integer gpsSIMNo;
    private Integer capacity;
    private BusDriverDetails busDriverDetails;
    private Set<BusRoute> busRoutes = new LinkedHashSet<BusRoute>();
    private Set<BusRouteSchedule> busRouteSchedules = new LinkedHashSet<BusRouteSchedule>();

    public BusDetails(String busModel, String busRegistrationNumber, String createdBy, String modifiedBy, Integer status, Date registrationPapersExpirationDate, Integer gpsSIMNo, Integer capacity, Set<BusRoute> busRoutes, Set<BusRouteSchedule> busRouteSchedules) {
        this.busModel = busModel;
        this.busRegistrationNumber = busRegistrationNumber;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = new Timestamp(Calendar.getInstance().getTime().getTime());
        this.status = status;
        this.registrationPapersExpirationDate = registrationPapersExpirationDate;
        this.gpsSIMNo = gpsSIMNo;
        this.capacity = capacity;
        this.busRoutes = busRoutes;
        this.busRouteSchedules = busRouteSchedules;
    }

    BusDetails() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bus_detail_id", unique=true, nullable=false)
    public Long getBusDetailId() {
        return this.busDetailId;
    }

    public void setBusDetailId(Long busDetailId) {
        this.busDetailId = busDetailId;
    }

    @Column(name="bus_model", nullable=false, length=150)
    public String getBusModel() {
        return this.busModel;
    }

    public void setBusModel(String busModel) {
        this.busModel = busModel;
    }

    @Column(name="bus_registration_number", nullable=false, length=150)
    public String getBusRegistrationNumber() {
        return this.busRegistrationNumber;
    }

    public void setBusRegistrationNumber(String busRegistrationNumber) {
        this.busRegistrationNumber = busRegistrationNumber;
    }

    @Column(name="status", nullable=false, length=20)
    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name="capacity", nullable=false, length=50)
    public Integer getCapacity() {
        return this.capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Temporal(value=TemporalType.DATE)
    @Column(name="registration_paper_expiration_date", nullable=false)
    public Date getRegistrationPapersExpirationDate() {
        return this.registrationPapersExpirationDate;
    }

    public void setRegistrationPapersExpirationDate(Date registrationPapersExpirationDate) {
        this.registrationPapersExpirationDate = registrationPapersExpirationDate;
    }

    @Column(name="gps_sim_number", nullable=false, length=30)
    public Integer getGpsSIMNo() {
        return this.gpsSIMNo;
    }

    public void setGpsSIMNo(Integer gpsSIMNo) {
        this.gpsSIMNo = gpsSIMNo;
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

    @OneToMany(fetch=FetchType.LAZY, mappedBy="busDetails")
    @ForeignKey(name="busDetailsInBusRoute")
    @OrderBy(value="bus_route_id ASC")
    public Set<BusRoute> getBusRoutes() {
        return this.busRoutes;
    }

    public void setBusRoutes(Set<BusRoute> busRoutes) {
        this.busRoutes = busRoutes;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="busDetails")
    @ForeignKey(name="busDetailsInBusRouteSchedule")
    @OrderBy(value="bus_route_schedule_id ASC")
    public Set<BusRouteSchedule> getBusRouteSchedules() {
        return this.busRouteSchedules;
    }

    public void setBusRouteSchedules(Set<BusRouteSchedule> busRouteSchedules) {
        this.busRouteSchedules = busRouteSchedules;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bus_driver_id", nullable=true)
    @ForeignKey(name="busDriverDetailsInBusDetails")
    @JsonManagedReference
    public BusDriverDetails getBusDriverDetails() {
        return this.busDriverDetails;
    }

    public void setBusDriverDetails(BusDriverDetails busDriverDetails) {
        this.busDriverDetails = busDriverDetails;
    }
}
