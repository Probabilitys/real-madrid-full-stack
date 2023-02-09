package com.liamguan.realmadrid.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String home;
    private String away;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;

    public Schedule() {
    }

    public Schedule(String home, String away, Date date) {
        this.home = home;
        this.away = away;
        this.date = date;
    }

    public Schedule(long id, String home, String away, Date date) {
        this.id = id;
        this.home = home;
        this.away = away;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", home='" + home + '\'' +
                ", away='" + away + '\'' +
                ", matchDate=" + date +
                '}';
    }
}
