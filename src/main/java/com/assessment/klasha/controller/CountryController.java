package com.assessment.klasha.controller;

import com.assessment.klasha.model.request.CountryRequest;
import com.assessment.klasha.model.response.CityStateResponse;
import com.assessment.klasha.model.response.CountryResponseData;
import com.assessment.klasha.service.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@RestController
@RequestMapping("api/v1/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enable user to get a single country details.")
    public CountryResponseData getCountryData(@RequestBody CountryRequest countryRequest) {
        return countryService.getAllDetails(countryRequest);
    }

    @PostMapping(value = "/state", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enable user to fetch state and cities related to the specified state")
    public CityStateResponse getStatesAndCity(@RequestBody @Validated CountryRequest countryRequest){
        return countryService.getStateAndCityDetails(countryRequest);
    }
}
