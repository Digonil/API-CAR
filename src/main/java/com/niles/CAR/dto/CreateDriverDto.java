package com.niles.CAR.dto;

import com.niles.CAR.domain.Driver;

import java.util.Date;

public class CreateDriverDto {
    private String name;
    private Date birthDate;

    public CreateDriverDto() {
    }

    public CreateDriverDto(Driver driver) {
        this.name = driver.getName();
        this.birthDate = driver.getBirthDate();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



}
