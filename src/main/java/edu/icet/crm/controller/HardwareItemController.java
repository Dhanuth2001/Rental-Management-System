package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/item-controller")
public class HardwareItemController {
    final HardwareItemService itemService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addIteam(@RequestBody HardwareItem item) {
        itemService.addItem(item);
    }
    @GetMapping("/get-all")
    public List<Customer> getAllItems() {
        return itemService.getAllItems();
    }
}
