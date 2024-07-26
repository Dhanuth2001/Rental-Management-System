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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        if(harwareItemRepository.existsById(item.getItemID())){
            HardwareItemEntity hardwareItemEntity = convertToEntity(item);
            harwareItemRepository.save(hardwareItemEntity);
        }
    }

    @Override
    public void deleteItem(Long id) {
        if(harwareItemRepository.existsById(id)){

            harwareItemRepository.deleteById(id);
        }
    }

    @Override
    public HardwareItem getItemById(Long id) {
        Optional<HardwareItemEntity> optionalHardwareItemEntity = harwareItemRepository.findById(id);
        if (optionalHardwareItemEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item with ID " + id + " not found");
        }
        return convertToModel(optionalHardwareItemEntity.get());
    }

    private HardwareItemEntity convertToEntity(HardwareItem item) {
        return mapper.convertValue(item, HardwareItemEntity.class);
    }

    private HardwareItem convertToModel(HardwareItemEntity itemEntity) {
        return mapper.convertValue(itemEntity, HardwareItem.class);
    }
}
