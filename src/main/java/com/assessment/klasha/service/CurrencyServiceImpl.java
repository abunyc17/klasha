package com.assessment.klasha.service;

import com.assessment.klasha.model.request.CountryRequest;
import com.assessment.klasha.model.request.CsvMapper;
import com.assessment.klasha.model.request.ExchangeRequest;
import com.assessment.klasha.model.response.CurrencyFinalResponse;
import com.assessment.klasha.model.response.CurrencyResponse;
import com.assessment.klasha.util.ApplicationConstants;
import com.assessment.klasha.util.CSVReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@Service
public class CurrencyServiceImpl implements CurrencyService{

    @Autowired
    RestTemplate restTemplateConfig;

    @Override
    public CurrencyFinalResponse getCurrencyRelatedDetails(ExchangeRequest request) throws IOException {
        CountryRequest countryRequest = new CountryRequest();
        CurrencyFinalResponse currencyFinalResponse = new CurrencyFinalResponse();
        countryRequest.setCountry(request.getCountry());
        String currencyEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.SINGLE_COUNTRY_CURRENCY;
        ObjectMapper objectMapper = new ObjectMapper();
        String requestJson = objectMapper.writeValueAsString(countryRequest);
        CurrencyResponse currencyResponse = restTemplateConfig.postForObject(currencyEndpoint,requestJson,CurrencyResponse.class);
        List<CsvMapper> csvDataReader = CSVReader.readCsvFile();
        CsvMapper csvMapper = csvDataReader.stream().filter(t ->
                t.getSourceCurrency().equals(currencyResponse.getData().getCurrency())
                && t.getTargetCurrency().equals(request.getTargetCurrency())
        ).collect(Collectors.toList()).get(0);
        double finalAmount = request.getAmount() * csvMapper.getRate();

        currencyFinalResponse.setSourceCurrency(csvMapper.getSourceCurrency());
        currencyFinalResponse.setTargetCurrency(csvMapper.getTargetCurrency());
        currencyFinalResponse.setAmount(request.getAmount());
        currencyFinalResponse.setRate(csvMapper.getRate());
        currencyFinalResponse.setConvertedAmount(finalAmount);
        return currencyFinalResponse;
    }
}

