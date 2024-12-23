/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonIdentityInfo
 *  com.fasterxml.jackson.annotation.JsonIdentityReference
 *  com.fasterxml.jackson.annotation.JsonIgnoreProperties
 *  com.fasterxml.jackson.annotation.JsonInclude
 *  com.fasterxml.jackson.annotation.JsonInclude$Include
 *  com.fasterxml.jackson.annotation.ObjectIdGenerators$IntSequenceGenerator
 *  javax.persistence.Column
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.JoinColumn
 *  javax.persistence.ManyToOne
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import in.jdsoft.educationmanagement.school.model.BusDetails;
import in.jdsoft.educationmanagement.school.model.BusRoute;
import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_bus_route_schedule")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BusRouteSchedule
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long busRouteScheduleId;
    private Time departureTime;
    private Time arrivalTime;
    private BusRoute busRoute;
    private BusDetails busDetails;

    public BusRouteSchedule(Time departureTime, Time arrivalTime, BusRoute busRoute) {
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.busRoute = busRoute;
    }

    BusRouteSchedule() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bus_route_schedule_id", nullable=false)
    public Long getBusRouteScheduleId() {
        return this.busRouteScheduleId;
    }

    public void setBusRouteScheduleId(Long busRouteScheduleId) {
        this.busRouteScheduleId = busRouteScheduleId;
    }

    @Column(name="departure_time", nullable=false)
    public Time getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    @Column(name="arrival_time", nullable=false)
    public Time getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bus_route_id", nullable=false)
    @ForeignKey(name="busRouteInBusRouteSchedule")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@busRouteSchedules")
    @JsonIdentityReference(alwaysAsId=true)
    public BusRoute getBusRoute() {
        return this.busRoute;
    }

    public void setBusRoute(BusRoute busRoute) {
        this.busRoute = busRoute;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bus_detail_id", nullable=false)
    @ForeignKey(name="busRouteInBusRouteSchedule")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@busRouteSchedules")
    @JsonIdentityReference(alwaysAsId=true)
    public BusDetails getBusDetails() {
        return this.busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }
}
