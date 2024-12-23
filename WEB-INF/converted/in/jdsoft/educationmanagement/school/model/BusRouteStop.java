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
 *  javax.persistence.ManyToMany
 *  javax.persistence.OneToOne
 *  javax.persistence.Table
 *  org.hibernate.annotations.ForeignKey
 */
package in.jdsoft.educationmanagement.school.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import in.jdsoft.educationmanagement.school.model.BusRoute;
import in.jdsoft.educationmanagement.school.model.FeesItem;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="tbl_bus_route_stop")
@JsonIgnoreProperties(value={"hibernateLazyInitializer", "handler"})
@JsonInclude(value=JsonInclude.Include.NON_EMPTY)
public class BusRouteStop
implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long busRouteStopId;
    private String busRouteStopName;
    private FeesItem feesItem;
    private Set<BusRoute> busRoutes = new LinkedHashSet<BusRoute>();

    public BusRouteStop(String busRouteStopName, FeesItem feesItem) {
        this.busRouteStopName = busRouteStopName;
        this.feesItem = feesItem;
    }

    BusRouteStop() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="bus_route_stop_id", nullable=false)
    public Long getBusRouteStopId() {
        return this.busRouteStopId;
    }

    public void setBusRouteStopId(Long busRouteStopId) {
        this.busRouteStopId = busRouteStopId;
    }

    @Column(name="bus_route_stop_name", nullable=false, length=255)
    public String getBusRouteStopName() {
        return this.busRouteStopName;
    }

    public void setBusRouteStopName(String busRouteStopName) {
        this.busRouteStopName = busRouteStopName;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="fees_item_id", nullable=true)
    @ForeignKey(name="busRouteStopInFeesItem")
    @JsonManagedReference
    public FeesItem getFeesItem() {
        return this.feesItem;
    }

    public void setFeesItem(FeesItem feesItem) {
        this.feesItem = feesItem;
    }

    @ManyToMany(fetch=FetchType.LAZY, mappedBy="busRouteStops")
    @ForeignKey(name="busRouteStopInBusRoutes")
    public Set<BusRoute> getBusRoutes() {
        return this.busRoutes;
    }

    public void setBusRoutes(Set<BusRoute> busRoutes) {
        this.busRoutes = busRoutes;
    }
}
