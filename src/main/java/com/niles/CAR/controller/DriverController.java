package com.niles.CAR.controller;

import com.niles.CAR.domain.Driver;
import com.niles.CAR.dto.RetrieveDriverDto;
import com.niles.CAR.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping
    public ResponseEntity<List<RetrieveDriverDto>> findAll() {
        List<RetrieveDriverDto> dtoDrivers = service.findAll();
        return ResponseEntity.ok().body(dtoDrivers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RetrieveDriverDto> findById(@PathVariable Long id) {
        RetrieveDriverDto driver = service.findById(id);
        return ResponseEntity.ok().body(driver);
    }
}
