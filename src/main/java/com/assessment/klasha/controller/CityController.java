package com.assessment.klasha.controller;

import com.assessment.klasha.model.response.CityPopulationResponse;
import com.assessment.klasha.service.CityService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@RestController
@RequestMapping("api/v1/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping
    @Operation(summary = "Enable use to fetch city base on the value of the request parameter passed")
    public CityPopulationResponse getCity(@RequestParam int n){
        return cityService.getAllCity(n);
    }

}
