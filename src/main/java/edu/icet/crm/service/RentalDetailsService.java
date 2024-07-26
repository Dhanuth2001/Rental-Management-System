package edu.icet.crm.service;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.RentalDetails;

import java.util.List;

public interface RentalDetailsService {
    List<RentalDetails> getAllRentalDetails();

    void addRentalDetails(RentalDetails rentalDetails);

    RentalDetails getRentalDetailById(Long id);
}
