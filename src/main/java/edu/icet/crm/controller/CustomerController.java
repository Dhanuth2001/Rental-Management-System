package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/cus-controller")
public class CustomerController {
    final CustomerService customerService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }
    @GetMapping("/get-all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}
