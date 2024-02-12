package com.niles.CAR.services;

import com.niles.CAR.domain.TravelRequest;
import com.niles.CAR.domain.TravelRequestRepository;
import com.niles.CAR.dto.CreateTravelRequestDto;
import com.niles.CAR.dto.RetrieveTravelRequestDto;
import org.springframework.stereotype.Service;

@Service
public class TravelRequestService {

    private TravelRequestRepository repository;

    public RetrieveTravelRequestDto makeTraveRequest(CreateTravelRequestDto dto) {
        TravelRequest travelRequest = new TravelRequest(dto);
        repository.save(travelRequest);
        return new RetrieveTravelRequestDto(travelRequest);
    }
}
