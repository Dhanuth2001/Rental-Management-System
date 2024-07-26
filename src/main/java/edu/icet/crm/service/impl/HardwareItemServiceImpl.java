package edu.icet.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.crm.entity.CustomerEntity;
import edu.icet.crm.entity.HardwareItemEntity;
import edu.icet.crm.model.Customer;
import edu.icet.crm.model.HardwareItem;
import edu.icet.crm.repository.CustomerRepository;
import edu.icet.crm.repository.HarwareItemRepository;
import edu.icet.crm.service.HardwareItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class HardwareItemServiceImpl implements HardwareItemService {
    final HarwareItemRepository harwareItemRepository;

    final ObjectMapper mapper;
    @Override
    public void addItem(HardwareItem item) {
        if (!item.equals(null)){
            HardwareItemEntity hardwareItemEntity = convertToEntity(item);
            harwareItemRepository.save(hardwareItemEntity);
        }
    }

    @Override
    public List<HardwareItem> getAllItems() {
        Iterable<HardwareItemEntity> all = harwareItemRepository.findAll();
        ArrayList<HardwareItem> hardwareItemArrayList = new ArrayList<>();
        all.forEach(hardwareItemEntity -> {
            HardwareItem item = convertToModel(hardwareItemEntity);
            hardwareItemArrayList.add(item);
        });
        return hardwareItemArrayList;
    }

    @Override
    public void updateItem(HardwareItem item) {

    }

    @Override
    public void deleteItem(Long id) {

    }

    @Override
    public HardwareItem getItemById(Long id) {
        return null;
    }

    private HardwareItemEntity convertToEntity(HardwareItem item) {
        return mapper.convertValue(item, HardwareItemEntity.class);
    }

    private HardwareItem convertToModel(HardwareItemEntity itemEntity) {
        return mapper.convertValue(itemEntity, HardwareItem.class);
    }
}
