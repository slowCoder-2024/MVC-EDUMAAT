/*
 * Decompiled with CFR 0.152.
 */
package in.jdsoft.educationmanagement.school.reports.model;

import java.sql.Time;
import java.util.Date;

public class PunchDetails {
    private String staffCode;
    private String staffName;
    private Date date;
    private Time inTime;
    private Time outTime;
    private Time overTime;

    public PunchDetails(String staffCode, String staffName, Date date, Time inTime) {
        this.staffCode = staffCode;
        this.staffName = staffName;
        this.date = date;
        this.inTime = inTime;
    }

    public String getStaffCode() {
        return this.staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getInTime() {
        return this.inTime;
    }

    public void setInTime(Time inTime) {
        this.inTime = inTime;
    }

    public Time getOutTime() {
        return this.outTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime = outTime;
    }

    public Time getOverTime() {
        return this.overTime;
    }

    public void setOverTime(Time overTime) {
        this.overTime = overTime;
    }
}
