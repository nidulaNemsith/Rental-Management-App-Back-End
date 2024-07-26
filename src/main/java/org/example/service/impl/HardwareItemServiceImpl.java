package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.entity.HardwareItemEntity;
import org.example.repository.HardwareItemRepository;
import org.example.service.HardwareItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareItemServiceImpl implements HardwareItemService {

    final HardwareItemRepository hardwareItemRepository;
    @Override
    public void addItem(HardwareItem hardwareItem) {
        hardwareItemRepository.save(
                new ObjectMapper().convertValue(hardwareItem, HardwareItemEntity.class)
        );
    }

    @Override
    public List<HardwareItem> getAll() {
        List<HardwareItem> hardwareItemList= new ArrayList<>();
        List<HardwareItemEntity> all = hardwareItemRepository.findAll();
        all.forEach(hardwareItemEntity -> {
            hardwareItemList.add(
                    new ObjectMapper().convertValue(hardwareItemEntity, HardwareItem.class)
            );
        });
        return hardwareItemList;
    }

    @Override
    public void deleteById(Long id) {
        if (hardwareItemRepository.existsById(id)){
            hardwareItemRepository.deleteById(id);
        }
    }

    @Override
    public void update(HardwareItem hardwareItem) {
        if(hardwareItemRepository.findById(hardwareItem.getItemId()).isPresent()){
            hardwareItemRepository.save(
                    new ObjectMapper().convertValue(hardwareItem, HardwareItemEntity.class)
            );
        }

    }
    @Override
    public HardwareItem getItemById(Long id) {
        if (hardwareItemRepository.findById(id).isPresent()){
            Optional<HardwareItemEntity> byId = hardwareItemRepository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), HardwareItem.class);
        }
        return new HardwareItem();
    }
}
