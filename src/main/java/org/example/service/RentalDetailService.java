package org.example.service;


import org.example.dto.RentalDetail;

import java.util.List;

public interface RentalDetailService {
    void addItem(RentalDetail rentalDetail);
    List<RentalDetail> getAll();
    void deleteById(Long id);
    void update(RentalDetail rentalDetail);
    RentalDetail getItemById(Long id);
}
