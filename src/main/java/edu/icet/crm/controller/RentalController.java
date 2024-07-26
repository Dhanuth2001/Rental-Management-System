package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.model.Rental;
import edu.icet.crm.service.HardwareItemService;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/rental-controller")
public class RentalController {
    final RentalService rentalService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRental(@RequestBody Rental rental) {
        rentalService.addRental(rental);
    }
    @GetMapping("/get-all")
    public List<Rental> getAllRentals() {
        return rentalService.getAllRentals();
    }
    @GetMapping("/get-by-id/{id}")
    public Rental getRentalById(@PathVariable("id") Long id) {
        Rental rental = rentalService.getRentalById(id);
        return rental;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRental(@RequestBody Rental rental) {
        rentalService.updateRental(rental);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRental(@PathVariable("id") Long id) {
        rentalService.deleteRental(id);
    }
}
