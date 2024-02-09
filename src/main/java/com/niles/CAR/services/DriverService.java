package com.niles.CAR.services;

import com.niles.CAR.domain.Driver;
import com.niles.CAR.domain.DriverRepository;
import com.niles.CAR.dto.CreateDriverDto;
import com.niles.CAR.dto.RetrieveDriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    @Transactional(readOnly = true)
    public List<RetrieveDriverDto> findAll() {
        List<Driver> drivers = repository.findAll();
        List<RetrieveDriverDto> dtoDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            dtoDrivers.add(new RetrieveDriverDto(driver));
        }
        return dtoDrivers;
    }

    @Transactional(readOnly = true)
    public RetrieveDriverDto findById(Long id) {
        Optional<Driver> driverOpt = repository.findById(id);
        Driver driver = driverOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new RetrieveDriverDto(driver);
    }

    @Transactional
    public RetrieveDriverDto createDriver(CreateDriverDto dto) {
        Driver driver = new Driver(dto);
        Driver saveDriver = repository.save(driver);
        return new RetrieveDriverDto(saveDriver);
    }


}
