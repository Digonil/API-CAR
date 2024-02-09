package com.niles.CAR.dto;

import com.niles.CAR.domain.Driver;

import java.util.Date;
import java.util.Optional;

public class RetrieveDriverDto {

    private Long id;
    private String name;
    private Date birthDate;

    public RetrieveDriverDto(Optional<Driver> driver) {
    }

    public RetrieveDriverDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.birthDate = driver.getBirthDate();
    }

    public Long getId() {
        return id;
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
