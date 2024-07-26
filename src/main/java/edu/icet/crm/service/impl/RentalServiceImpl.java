package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalDetailsEntity;
import edu.icet.crm.entity.RentalEntity;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalDetails;
import edu.icet.crm.repository.HarwareItemRepository;
import edu.icet.crm.repository.RentalDetailsRepository;
import edu.icet.crm.repository.RentalRepository;
import edu.icet.crm.service.HardwareItemService;
import edu.icet.crm.service.RentalDetailsService;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RentalServiceImpl implements RentalService {
    final RentalRepository rentalRepository;

    final ObjectMapper mapper;


    private RentalEntity convertToEntity(Rental rental) {
        return mapper.convertValue(rental, RentalEntity.class);
    }

    private Rental convertToModel(RentalEntity rentalEntity) {
        return mapper.convertValue(rentalEntity, Rental.class);
    }



    @Override
    public List<Rental> getAllRentals() {
        Iterable<RentalEntity> all = rentalRepository.findAll();
        ArrayList<Rental> rentalArrayList = new ArrayList<>();
        all.forEach(rentalEntity -> {
            Rental rental = convertToModel(rentalEntity);
            rentalArrayList.add(rental);
        });
        return rentalArrayList;
    }

    @Override
    public void addRental(Rental rental) {
        if (!rental.equals(null)){
            RentalEntity rentalEntity = convertToEntity(rental);
            rentalRepository.save(rentalEntity);
        }
    }

    @Override
    public Rental getRentalById(Long id) {
        Optional<RentalEntity> optionalRentalEntity = rentalRepository.findById(id);
        if (optionalRentalEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental with ID " + id + " not found");
        }
        return convertToModel(optionalRentalEntity.get());
    }

    @Override
    public void updateRental(Rental rental) {
        if(rentalRepository.existsById(rental.getRentID())){
            RentalEntity rentalEntity = convertToEntity(rental);
            rentalRepository.save(rentalEntity);
        }
    }

    @Override
    public void deleteRental(Long id) {
        if(rentalRepository.existsById(id)){

            rentalRepository.deleteById(id);
        }
    }
}
