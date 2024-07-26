package edu.icet.crm.service;

import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;

import java.util.List;

public interface HardwareItemService {
    void addItem(HardwareItem item);

    List<HardwareItem> getAllItems();

    void updateItem(HardwareItem item);

    void deleteItem(Long id);

    HardwareItem getItemById(Long id);
}
