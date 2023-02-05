package com.system.repository;

import com.system.model.FuelStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/")
public interface FuelStationRepository extends JpaRepository<FuelStation,Integer> {
    FuelStation findBydistric(String distric);
}
