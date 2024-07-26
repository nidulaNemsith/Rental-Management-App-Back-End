package org.example.repository;

import org.example.dto.RentalDetail;
import org.example.entity.RentalDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDetailRepository extends JpaRepository<RentalDetailEntity,Long> {
}
