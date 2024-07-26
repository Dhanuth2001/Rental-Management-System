package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.entity.RentalDetailsEntity;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.model.RentalDetails;
import edu.icet.crm.repository.HarwareItemRepository;
import edu.icet.crm.repository.RentalDetailsRepository;
import edu.icet.crm.service.HardwareItemService;
import edu.icet.crm.service.RentalDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    @Override
    public void addRentalDetails(RentalDetails rentalDetails) {

    }

    @Override
    public RentalDetails getRentalDetailById(Long id) {
        return null;
    }
}
