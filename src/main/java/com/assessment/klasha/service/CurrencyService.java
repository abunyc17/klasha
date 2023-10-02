package com.assessment.klasha.service;

import com.assessment.klasha.model.request.ExchangeRequest;
import com.assessment.klasha.model.response.CurrencyFinalResponse;
import com.assessment.klasha.model.response.CurrencyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/
public interface CurrencyService {
    CurrencyFinalResponse getCurrencyRelatedDetails(ExchangeRequest request) throws IOException;
}
