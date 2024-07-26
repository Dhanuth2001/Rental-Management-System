package edu.icet.crm.service;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> getAllRentals();

    void addRental(Rental rental);
}