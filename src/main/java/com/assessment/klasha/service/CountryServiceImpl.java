package com.assessment.klasha.service;

import com.assessment.klasha.model.request.CountryRequest;
import com.assessment.klasha.model.request.CountryStateMapper;
import com.assessment.klasha.model.response.*;
import com.assessment.klasha.util.ApplicationConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    RestTemplate restTemplate;

    @Override
    public CountryResponseData getAllDetails(CountryRequest countryRequest){

        CountryResponseData responseData = new CountryResponseData();

        String populationEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.SINGLE_COUNTRY_POPULATION;
        PopulationResponse populationResponse = restTemplate.postForObject(populationEndpoint,countryRequest,PopulationResponse.class);
        String currencyEndpoint = ApplicationConstants.BASE_URL.concat(ApplicationConstants.SINGLE_COUNTRY_CURRENCY);
        CurrencyResponse currencyResponse = restTemplate.postForObject(currencyEndpoint,countryRequest, CurrencyResponse.class);
        String locationEndpoint = ApplicationConstants.BASE_URL+ApplicationConstants.SINGLE_COUNTRY_LOCATION;
        String capitalEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.SINGLE_COUNTRY_CAPITAL;
        String isoEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.SINGLE_COUNTRY_ISO;

        LocationResponse locationResponse = restTemplate.postForObject(locationEndpoint,countryRequest, LocationResponse.class);
        CapitalResponse capitalResponse = restTemplate.postForObject(capitalEndpoint,countryRequest, CapitalResponse.class);
        IsoResponse isoResponse = restTemplate.postForObject(isoEndpoint,countryRequest, IsoResponse.class);
        responseData = buildCountryResponse(populationResponse,currencyResponse,locationResponse,capitalResponse,isoResponse);
        return responseData;
    }

    @Override
    public CityStateResponse getStateAndCityDetails(CountryRequest countryRequest) {
        CityStateResponse cityStateResponse = new CityStateResponse();
        String stateEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.COUNTRY_STATE_ENDPOINT;
        StateDataResponse stateDataResponse = restTemplate.postForObject(stateEndpoint,countryRequest,StateDataResponse.class);

        List<States> statesList = stateDataResponse.getData().getStates();
        //check list to avoid null pointer
        ObjectMapper objectMapper = new ObjectMapper();
        String cityEndpoint = ApplicationConstants.BASE_URL + ApplicationConstants.CITY_STATE_ENDPOINT;
        List<CityModel> cityModelList = new ArrayList<>();
        for(States states : statesList){
            CityModel cityModel = new CityModel();
            CountryStateMapper countryStateMapper = new CountryStateMapper();
            countryStateMapper.setCountry(countryRequest.getCountry());
            countryStateMapper.setState(states.getName());
            try{
                String jsonCaller = objectMapper.writeValueAsString(countryStateMapper);
                CityResponse cityResponse = restTemplate.postForObject(cityEndpoint,jsonCaller, CityResponse.class);
                cityModel.setStateName(states.getName());
                cityModel.setCities(cityResponse.getData());
                cityModelList.add(cityModel);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }

        }
        cityStateResponse.setCountry(countryRequest.getCountry());
        cityStateResponse.setStates(cityModelList);
        return cityStateResponse;
    }

    private CountryResponseData buildCountryResponse(PopulationResponse populationResponse,
                                                     CurrencyResponse currencyResponse,
                                                     LocationResponse locationResponse,
                                                     CapitalResponse capitalResponse,
                                                     IsoResponse isoResponse){
        CountryResponseData responseData = new CountryResponseData();
        responseData.setError(populationResponse.isError());
        responseData.setMsg(populationResponse.getMsg());
        responseData.setPopulation(populationResponse);
        responseData.setCurrency(currencyResponse);
        responseData.setLocation(locationResponse);
        responseData.setCapitalCity(capitalResponse);
        responseData.setIso(isoResponse);

        return responseData;

    }
}
