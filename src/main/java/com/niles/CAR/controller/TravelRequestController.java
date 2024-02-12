package com.niles.CAR.controller;

import com.niles.CAR.dto.CreateTravelRequestDto;
import com.niles.CAR.dto.RetrieveTravelRequestDto;
import com.niles.CAR.services.TravelRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(value = "/requests")
public class TravelRequestController {

    @Autowired
    private TravelRequestService service;

    @PostMapping
    public ResponseEntity<RetrieveTravelRequestDto> makeTravelRequest(@RequestBody CreateTravelRequestDto dto) {
        RetrieveTravelRequestDto retrieveDto = service.makeTraveRequest(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(retrieveDto.getId()).toUri();
        return ResponseEntity.created(uri).body(retrieveDto);
    }
}
