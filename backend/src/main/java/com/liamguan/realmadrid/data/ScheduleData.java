package com.liamguan.realmadrid.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;


public class ScheduleData {

    private String home;
    private String away;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public ScheduleData() {
    }

    public ScheduleData(String home, String away, Date date) {
        this.home = home;
        this.away = away;
        this.date = date;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", matchDate=" + date +
                '}';
    }
}

