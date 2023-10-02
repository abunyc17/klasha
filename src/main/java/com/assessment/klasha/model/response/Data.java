package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    private String city;
    private String country;
    private List<PopulationCountExtended> populationCounts;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PopulationCountExtended> getPopulationCounts() {
        return populationCounts;
    }

    public void setPopulationCounts(List<PopulationCountExtended> populationCounts) {
        this.populationCounts = populationCounts;
    }
}
