package edu.icet.crm.controller;

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
    public List<Rental> getAllItems() {
        return rentalService.getAllRentals();
    }
}
