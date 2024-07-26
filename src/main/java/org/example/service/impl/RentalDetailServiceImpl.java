package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.dto.HardwareItem;
import org.example.dto.RentalDetail;
import org.example.entity.HardwareItemEntity;
import org.example.entity.RentalDetailEntity;
import org.example.repository.RentalDetailRepository;
import org.example.service.RentalDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalDetailServiceImpl implements RentalDetailService {

    final RentalDetailRepository rentalDetailRepository;
    @Override
    public void addItem(RentalDetail rentalDetail) {
        rentalDetailRepository.save(
                new ObjectMapper().convertValue(rentalDetail, RentalDetailEntity.class)
        );
    }
    @Override
    public List<RentalDetail> getAll() {
        List<RentalDetail> rentalDetailList= new ArrayList<>();
        List<RentalDetailEntity> all = rentalDetailRepository.findAll();
        all.forEach(rentalDetailEntity -> {
            rentalDetailList.add(
                    new ObjectMapper().convertValue(rentalDetailEntity, RentalDetail.class)
            );
        });
        return rentalDetailList;
    }
    @Override
    public void deleteById(Long id) {
        if (rentalDetailRepository.existsById(id)){
            rentalDetailRepository.deleteById(id);
        }
    }
    @Override
    public void update(RentalDetail rentalDetail) {
        if(rentalDetailRepository.findById(rentalDetail.getRentId()).isPresent()){
            rentalDetailRepository.save(
                    new ObjectMapper().convertValue(rentalDetail, RentalDetailEntity.class)
            );
        }
    }
    @Override
    public RentalDetail getItemById(Long id) {
        if (rentalDetailRepository.findById(id).isPresent()){
            Optional<RentalDetailEntity> byId = rentalDetailRepository.findById(id);
            return new ObjectMapper().convertValue(byId.get(), RentalDetail.class);
        }
        return new RentalDetail();
    }

}
