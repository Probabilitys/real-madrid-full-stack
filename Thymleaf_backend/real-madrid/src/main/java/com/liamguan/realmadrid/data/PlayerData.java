package com.liamguan.realmadrid.data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PlayerData {

    private String name;
    private String birthDate;
    private String position;
    private int number;

    public PlayerData() {
    }

    public PlayerData(String name, String birthDate, String position, int number) {
        this.name = name;
        this.birthDate = birthDate;
        this.position = position;
        this.number = number;
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
}
