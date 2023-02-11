package com.liamguan.realmadrid.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String birthDate;
    private String position;
    private int number;

    public Player() {
    }

    public Player(String name, String birthDate, String position, int number) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.number = number;
    }

    public Player(long id, String name, String birthDate, String position, int number) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", position='" + position + '\'' +
                ", number=" + number +
                '}';
    }
}
