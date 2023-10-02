package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityStateResponse {
    private String country;
    private List<CityModel> states;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<CityModel> getStates() {
        return states;
    }

    public void setStates(List<CityModel> states) {
        this.states = states;
    }
}
