package org.example.repository;

import org.example.entity.HardwareItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HardwareItemRepository extends JpaRepository<HardwareItemEntity,Long> {
}
