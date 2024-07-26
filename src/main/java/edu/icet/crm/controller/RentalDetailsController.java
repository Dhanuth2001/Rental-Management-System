package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.Rental;
import edu.icet.crm.model.RentalDetails;
import edu.icet.crm.service.RentalDetailsService;
import edu.icet.crm.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/rentalDetail-controller")
public class RentalDetailsController {
    final RentalDetailsService rentalDetailsService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addRentalDetails(@RequestBody RentalDetails rentalDetails) {
        rentalDetailsService.addRentalDetails(rentalDetails);
    }
    @GetMapping("/get-all")
    public List<RentalDetails> getAllRentalDetails() {
        return rentalDetailsService.getAllRentalDetails();
    }

    @GetMapping("/get-by-id/{id}")
    public RentalDetails getRentalDetailById(@PathVariable("id") Long id) {
        RentalDetails rentalDetails = rentalDetailsService.getRentalDetailById(id);
        return rentalDetails;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateRentalDetail(@RequestBody RentalDetails rentalDetails) {
        rentalDetailsService.updateRentalDetails(rentalDetails);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRentalDetail(@PathVariable("id") Long id) {
        rentalDetailsService.deleteRentalDetail(id);
    }
}
