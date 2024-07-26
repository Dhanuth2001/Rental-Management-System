package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalDetailsEntity;
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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RentalServiceImpl implements RentalService {
    final RentalRepository rentalRepository;

    final ObjectMapper mapper;


    private RentalDetailsEntity convertToEntity(RentalDetails rentalDetails) {
        return mapper.convertValue(rentalDetails, RentalDetailsEntity.class);
    }

    private RentalDetails convertToModel(RentalDetailsEntity rentalDetailsEntity) {
        return mapper.convertValue(rentalDetailsEntity, RentalDetails.class);
    }



    @Override
    public List<Rental> getAllRentals() {
        return null;
    }

    @Override
    public void addRental(Rental rental) {

    }
}
