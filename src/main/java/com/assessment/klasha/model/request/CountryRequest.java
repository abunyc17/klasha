package com.assessment.klasha.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryRequest {
    private String country;

    public CountryRequest() {
    }

    public CountryRequest(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
