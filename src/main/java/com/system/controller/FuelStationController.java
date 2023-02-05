package com.system.controller;

import com.system.model.CommonResponse;
import com.system.model.Customers;
import com.system.model.FuelStation;
import com.system.model.Orders;
import com.system.repository.CustomerRepository;
import com.system.repository.FuelRequestRepository;
import com.system.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping(path = "/fuelstation")
public class FuelStationController {

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private FuelStationRepository fuelStationRepository;
    @Autowired
    private FuelRequestRepository fuelRequestRepository;

    @PostMapping(path = "/add")
    public @ResponseBody CommonResponse createFuelstation(@RequestBody FuelStation fuelStation){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate= formatter.format(date);
        fuelStation.setCreatedAt(strDate);
        fuelStationRepository.save(fuelStation);
        return CommonResponse.generateResponse(null,1000,"Success!!!");
    }

    //List All Product
    @GetMapping(path = "/all")
    public @ResponseBody CommonResponse getAllFuelstation() {
        return CommonResponse.generateResponse(fuelStationRepository.findAll(),1000,"Success!!!");

    }

    //Update customer
    @PostMapping(path = "/update/{id}")
    public CommonResponse updateFuelstation(@RequestBody FuelStation fuelStation,@PathVariable("id") Integer Id) {
        FuelStation fuelstationDB = fuelStationRepository.findById(Id).get();

        if (Objects.nonNull(fuelStation.getFirstName())
                && !"".equalsIgnoreCase(
                fuelStation.getFirstName())) {
            fuelstationDB.setFirstName(
                    fuelStation.getFirstName());
        }

        if (Objects.nonNull(fuelStation.getLastName())
                && !"".equalsIgnoreCase(
                fuelStation.getLastName())) {
            fuelstationDB.setLastName(
                    fuelStation.getLastName());
        }

        if (Objects.nonNull(fuelStation.getDistric())
                && !"".equalsIgnoreCase(
                fuelStation.getDistric())) {
            fuelstationDB.setDistric(
                    fuelStation.getDistric());
        }

        if (Objects.nonNull(fuelStation.getContactNo())
                && !"".equalsIgnoreCase(
                String.valueOf(fuelStation.getContactNo()))) {
            fuelstationDB.setContactNo(
                    fuelStation.getContactNo());
        }

        if (Objects.nonNull(fuelStation.getBusinessName())
                && !"".equalsIgnoreCase(
                fuelStation.getBusinessName())) {
            fuelstationDB.setBusinessName(
                    fuelStation.getBusinessName());
        }


        fuelStationRepository.save(fuelstationDB);
        return CommonResponse.generateResponse(null, 1000, "Updated Successfully!!!");
       }

        //Delete Product
        @GetMapping(path = "/delete/{id}")
        public @ResponseBody CommonResponse deleteFuelstationById(@PathVariable("id") Integer fuelstationId){
            fuelStationRepository.deleteById(fuelstationId);

            return CommonResponse.generateResponse(null,1000,"Deleted Successfully!!!");
    }

    @GetMapping(path = "/count")
    public @ResponseBody long getCount(){
        return fuelStationRepository.count();
    }
}
