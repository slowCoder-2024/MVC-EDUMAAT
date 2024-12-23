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
 *  javax.persistence.JoinTable
 *  javax.persistence.ManyToMany
 *  javax.persistence.ManyToOne
 *  javax.persistence.OneToMany
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
import in.jdsoft.educationmanagement.school.model.BusRouteSchedule;
import in.jdsoft.educationmanagement.school.model.BusRouteStop;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_bus_route")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BusRoute
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long busRouteId;
    private String busRouteName;
    private String aliasName;
    private BusDetails busDetails;
    private Set<BusRouteStop> busRouteStops = new LinkedHashSet<BusRouteStop>();
    private Set<BusRouteSchedule> busRouteSchedules = new LinkedHashSet<BusRouteSchedule>();

    public BusRoute(String busRouteName, String aliasName, Set<BusRouteStop> busRouteStops) {
        this.busRouteName = busRouteName;
        this.aliasName = aliasName;
        this.busRouteStops = busRouteStops;
    }

    BusRoute() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bus_route_id", nullable=false)
    public Long getBusRouteId() {
        return this.busRouteId;
    }

    public void setBusRouteId(Long busRouteId) {
        this.busRouteId = busRouteId;
    }

    @Column(name="bus_route_name", nullable=false, length=255)
    public String getBusRouteName() {
        return this.busRouteName;
    }

    public void setBusRouteName(String busRouteName) {
        this.busRouteName = busRouteName;
    }

    @Column(name="bus_route_alias_name", nullable=false, length=255)
    public String getAliasName() {
        return this.aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="tbl_bus_route_and_stop_mapping", joinColumns={@JoinColumn(name="bus_route_id", updatable=true)}, inverseJoinColumns={@JoinColumn(name="bus_route_stop_id", updatable=true)})
    @ForeignKey(name="busRouteInBusRouteStop")
    public Set<BusRouteStop> getBusRouteStops() {
        return this.busRouteStops;
    }

    public void setBusRouteStops(Set<BusRouteStop> busRouteStops) {
        this.busRouteStops = busRouteStops;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="busRoute")
    @ForeignKey(name="busRouteScheduleInBusRoute")
    public Set<BusRouteSchedule> getBusRouteSchedules() {
        return this.busRouteSchedules;
    }

    public void setBusRouteSchedules(Set<BusRouteSchedule> busRouteSchedules) {
        this.busRouteSchedules = busRouteSchedules;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bus_detail_id", nullable=false)
    @ForeignKey(name="busDetailsInBusRoute")
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@busRoutes")
    @JsonIdentityReference(alwaysAsId=true)
    public BusDetails getBusDetails() {
        return this.busDetails;
    }

    public void setBusDetails(BusDetails busDetails) {
        this.busDetails = busDetails;
    }
}
