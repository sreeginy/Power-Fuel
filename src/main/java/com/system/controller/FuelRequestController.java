package com.system.controller;

import com.system.model.CommonResponse;
import com.system.model.FuelRequest;
import com.system.model.FuelStation;
import com.system.repository.FuelRequestRepository;
import com.system.repository.FuelStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@RestController
@RequestMapping (path = "/fuelrequest")
public class FuelRequestController {

    @Autowired
    private PasswordEncoder bcryptEncoder;
    @Autowired
    private FuelRequestRepository fuelRequestRepository;

    @PostMapping(path = "/add")
    public @ResponseBody CommonResponse createFuelrequest(@RequestBody FuelRequest fuelRequest){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate= formatter.format(date);
        fuelRequest.setCreatedAt(strDate);
        fuelRequestRepository.save(fuelRequest);
        return CommonResponse.generateResponse(null, 1000, "Success!!!");
    }

    @PostMapping(path = "/all")
    public @ResponseBody CommonResponse getAllFuelRequest() {
        return CommonResponse.generateResponse(fuelRequestRepository.findAll(),1000,"Successful!!!");
    }

    @PutMapping(path = "/update/{id}")
    public CommonResponse updateFuelrequest(@RequestBody FuelRequest fuelRequest,@PathVariable("id") Integer Id) {
        FuelRequest fuelRequestDB = fuelRequestRepository.findById(Id).get();

        if (Objects.nonNull(fuelRequest.getFuelType())
                && !"".equalsIgnoreCase(
                fuelRequest.getFuelType().toString())) {
            fuelRequestDB.setFuelType(
                    fuelRequest.getFuelType());
        }

        if (Objects.nonNull(fuelRequest.getFuelStation())
                && !"".equalsIgnoreCase(
                fuelRequest.getFuelStation().toString())) {
            fuelRequestDB.setFuelStation(
                    fuelRequest.getFuelStation());
        }


        if (Objects.nonNull(fuelRequest.getRequestLitre())
                && !"".equalsIgnoreCase(
                String.valueOf(fuelRequest.getRequestLitre()))) {
            fuelRequestDB.setRequestLitre(
                    fuelRequest.getRequestLitre());
        }

        if (Objects.nonNull(fuelRequest.getStatus())
                && !"".equalsIgnoreCase(
                fuelRequest.getStatus())) {
            fuelRequestDB.setStatus(
                    fuelRequest.getStatus());
        }

        fuelRequestRepository.save(fuelRequestDB);

        return CommonResponse.generateResponse(null,1000,"Updated Successfully!!!");
    }

    //Delete Product
    @GetMapping(path = "/delete/{id}")
    public @ResponseBody CommonResponse deleteFuelrequestById(@PathVariable("id") Integer fuelrequestId){
        fuelRequestRepository.deleteById(fuelrequestId);

        return CommonResponse.generateResponse(null,1000,"Deleted Successfully!!!");
    }

    @GetMapping(path = "/count")
    public @ResponseBody long getCount(){
       return fuelRequestRepository.count();
    }
}
