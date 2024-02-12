package com.niles.CAR.services;

import com.niles.CAR.domain.Passenger;
import com.niles.CAR.domain.PassengerRepository;
import com.niles.CAR.dto.CreatePassengerDto;
import com.niles.CAR.dto.RetrievePassengerDto;
import com.niles.CAR.dto.UpdatePassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository repository;

    @Transactional(readOnly = true)
    public List<RetrievePassengerDto> findAll() {
        List<Passenger> passengers = repository.findAll();
        List<RetrievePassengerDto> dtoPassengers = new ArrayList<>();
        for (Passenger passenger : passengers) {
            dtoPassengers.add(new RetrievePassengerDto(passenger));
        }
        return dtoPassengers;
    }

    @Transactional(readOnly = true)
    public RetrievePassengerDto findById(Long id) {
        Optional<Passenger> passengerOpt = repository.findById(id);
        Passenger passenger = passengerOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return new RetrievePassengerDto(passenger);
    }

    @Transactional
    public RetrievePassengerDto createPassenger(CreatePassengerDto dto) {
        Passenger passenger = new Passenger(dto);
        Passenger savePassenger = repository.save(passenger);
        return new RetrievePassengerDto(savePassenger);
    }

    @Transactional
    public UpdatePassengerDto updatePassenger(Long id, UpdatePassengerDto dto) {
        Passenger passenger = repository.getReferenceById(id);
        entityToDto(passenger, dto);
        passenger = repository.save(passenger);
        return new UpdatePassengerDto(passenger);
    }

    @Transactional
    public void deletePassenger(Long id) {
        if (id != null) {
            Passenger passenger = repository.getReferenceById(id);
            repository.delete(passenger);
        }
    }


    private void entityToDto(Passenger passenger, UpdatePassengerDto dto) {
        passenger.setName(dto.getName());
    }
}
