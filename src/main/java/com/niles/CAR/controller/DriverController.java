package com.niles.CAR.controller;

import com.niles.CAR.dto.CreateDriverDto;
import com.niles.CAR.dto.RetrieveDriverDto;
import com.niles.CAR.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PostMapping
    public ResponseEntity<RetrieveDriverDto> createDriver(@RequestBody CreateDriverDto dto) {
        RetrieveDriverDto driver = service.createDriver(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(driver.getId()).toUri();
        return ResponseEntity.created(uri).body(driver);
    }
}
