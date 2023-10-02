package com.assessment.klasha.controller;

import com.assessment.klasha.model.request.ExchangeRequest;
import com.assessment.klasha.model.response.CurrencyFinalResponse;
import com.assessment.klasha.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@RestController
@RequestMapping("api/v1/currency")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Enable user to perform some currency exchange functions")
    public CurrencyFinalResponse getCurrencyDetails(@RequestBody ExchangeRequest request) throws IOException {
        return currencyService.getCurrencyRelatedDetails(request);
    }


}
