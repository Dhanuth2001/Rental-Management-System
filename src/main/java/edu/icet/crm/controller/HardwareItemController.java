package edu.icet.crm.controller;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.service.HardwareItemService;
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
    public void addItem(@RequestBody HardwareItem item) {
        itemService.addItem(item);
    }
    @GetMapping("/get-all")
    public List<HardwareItem> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/get-by-id/{id}")
    public HardwareItem getItemById(@PathVariable("id") Long id) {
        HardwareItem item = itemService.getItemById(id);
        return item;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateItem(@RequestBody HardwareItem item) {
        itemService.updateItem(item);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }
}
