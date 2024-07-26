package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalDetailsEntity;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.model.RentalDetails;
import edu.icet.crm.repository.HarwareItemRepository;
import edu.icet.crm.repository.RentalDetailsRepository;
import edu.icet.crm.service.HardwareItemService;
import edu.icet.crm.service.RentalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RentalDetailsServiceImpl implements RentalDetailsService {
    final RentalDetailsRepository rentalDetailsRepository;

    final ObjectMapper mapper;

    private RentalDetailsEntity convertToEntity(RentalDetails rentalDetails) {
        return mapper.convertValue(rentalDetails, RentalDetailsEntity.class);
    }

    private RentalDetails convertToModel(RentalDetailsEntity rentalDetailsEntity) {
        return mapper.convertValue(rentalDetailsEntity, RentalDetails.class);
    }

    @Override
    public List<RentalDetails> getAllRentalDetails() {
        Iterable<RentalDetailsEntity> all = rentalDetailsRepository.findAll();
        ArrayList<RentalDetails> rentalDetailsArrayList = new ArrayList<>();
        all.forEach(rentalDetailsEntity -> {
            RentalDetails rentalDetails = convertToModel(rentalDetailsEntity);
            rentalDetailsArrayList.add(rentalDetails);
        });
        return rentalDetailsArrayList;
    }

    @Override
    public void addRentalDetails(RentalDetails rentalDetails) {
        if (!rentalDetails.equals(null)){
            RentalDetailsEntity rentalDetailsEntity = convertToEntity(rentalDetails);
            rentalDetailsRepository.save(rentalDetailsEntity);
        }
    }

    @Override
    public RentalDetails getRentalDetailById(Long id) {
        Optional<RentalDetailsEntity> optionalRentalDetailsEntity = rentalDetailsRepository.findById(id);
        if (optionalRentalDetailsEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Rental Detail with ID " + id + " not found");
        }
        return convertToModel(optionalRentalDetailsEntity.get());
    }

    @Override
    public void updateRentalDetails(RentalDetails rentalDetails) {
        if(rentalDetailsRepository.existsById(rentalDetails.getRentDetailID())){
            RentalDetailsEntity rentalDetailsEntity = convertToEntity(rentalDetails);
            rentalDetailsRepository.save(rentalDetailsEntity);
        }
    }

    @Override
    public void deleteRentalDetail(Long id) {
        if(rentalDetailsRepository.existsById(id)){

            rentalDetailsRepository.deleteById(id);
        }
    }
}
