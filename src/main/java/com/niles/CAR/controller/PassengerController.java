package com.niles.CAR.controller;

import com.niles.CAR.dto.CreatePassengerDto;
import com.niles.CAR.dto.RetrievePassengerDto;
import com.niles.CAR.dto.UpdatePassengerDto;
import com.niles.CAR.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/passengers")
public class PassengerController {

    @Autowired
    private PassengerService service;

    @GetMapping
    public ResponseEntity<List<RetrievePassengerDto>> findAll() {
        List<RetrievePassengerDto> dtoPassengers = service.findAll();
        return ResponseEntity.ok().body(dtoPassengers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RetrievePassengerDto> findById(@PathVariable Long id) {
        RetrievePassengerDto passenger = service.findById(id);
        return ResponseEntity.ok().body(passenger);
    }

    @PostMapping
    public ResponseEntity<RetrievePassengerDto> createPassenger(@RequestBody CreatePassengerDto dto) {
        RetrievePassengerDto passenger = service.createPassenger(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(passenger.getId()).toUri();
        return ResponseEntity.created(uri).body(passenger);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UpdatePassengerDto> updatePassenger(@PathVariable Long id, @RequestBody UpdatePassengerDto dto) {
        UpdatePassengerDto passengerDto = service.updatePassenger(id, dto);
        return ResponseEntity.ok().body(passengerDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deletePassenger(@PathVariable Long id) {
        service.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
