package com.niles.CAR.services;

import com.niles.CAR.domain.Driver;
import com.niles.CAR.domain.DriverRepository;
import com.niles.CAR.dto.RetrieveDriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public List<RetrieveDriverDto> findAll() {
        List<Driver> drivers = repository.findAll();
        List<RetrieveDriverDto> dtoDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            dtoDrivers.add(new RetrieveDriverDto(driver));
        }
        return dtoDrivers;
    }

    public RetrieveDriverDto findById(Long id) {
        Optional<Driver> driverOpt = repository.findById(id);
        Driver driver = driverOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new RetrieveDriverDto(driver);
    }
}
