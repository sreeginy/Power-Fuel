package com.system.repository;

import com.system.model.FuelRequest;
import com.system.model.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypeRepository extends JpaRepository<FuelType,Integer> {
    FuelType findByFuelType(String name);
}
