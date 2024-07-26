package org.example.service;

import org.example.dto.HardwareItem;

import java.util.List;

public interface HardwareItemService {

    void addItem(HardwareItem hardwareItem);
    List<HardwareItem>getAll();
    void deleteById(Long id);
    void update(HardwareItem hardwareItem);
    HardwareItem getItemById(Long id);
}
