package com.assessment.klasha.service;

import com.assessment.klasha.model.request.CountryRequest;
import com.assessment.klasha.model.response.CityStateResponse;
import com.assessment.klasha.model.response.CountryResponseData;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
public interface CountryService {
    CountryResponseData getAllDetails(CountryRequest countryRequest);

    CityStateResponse getStateAndCityDetails(CountryRequest countryRequest);
}
