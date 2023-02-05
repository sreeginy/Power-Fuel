package com.system.controller;

import com.system.model.Category;
import com.system.model.CommonResponse;
import com.system.model.FuelType;
import com.system.repository.FuelTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping(path = "/fuelType")
public class FuelTypeController {

    @Autowired
    private FuelTypeRepository fuelTypeRepository;


    @PostMapping(path = "/add")
    public @ResponseBody CommonResponse addNewFuelType(@RequestBody FuelType fuelType){
        FuelType fuelDB = fuelTypeRepository.findByFuelType(fuelType.getFuelType());
        if (fuelDB == null){
            fuelTypeRepository.save(fuelType);
            return CommonResponse.generateResponse(null,1000,"Success");

        }else {
            return CommonResponse.generateResponse(null,1001,"Fuel type already exists");

        }
    }

    //List All users
    @GetMapping(path = "/all")
    public @ResponseBody CommonResponse getAllFuelType() {
        return CommonResponse.generateResponse(fuelTypeRepository.findAll(),1000,"Success");

    }

    //Update User
    @PostMapping(path = "/update/{id}")
    public CommonResponse updateFuelType(@RequestBody FuelType fuelType,@PathVariable("id") Integer id){
        FuelType fulDB = fuelTypeRepository.findById(id).get();
        if (Objects.nonNull(fuelType.getInStock())
                && !"".equalsIgnoreCase(
                fuelType.getInStock().toString())&& !fulDB.getInStock().equals(fuelType.getInStock())) {
            fulDB.setInStock(
                    fuelType.getInStock());
        }

        return CommonResponse.generateResponse(fuelTypeRepository.save(fulDB),1000,"Success");


    }

    //Delete User
    @GetMapping(path = "/delete/{id}")
    public @ResponseBody CommonResponse deleteFuelTypeById(@PathVariable("id") Integer fuelId){
        fuelTypeRepository.deleteById(fuelId);

        return CommonResponse.generateResponse(null,1000,"Deleted Successfully");
    }
}
