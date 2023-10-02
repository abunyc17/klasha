package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryData {
    private String country;
    private String code;
    private String iso3;
    private List<PopulationIntCounts> populationCounts;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public List<PopulationIntCounts> getPopulationCounts() {
        return populationCounts;
    }

    public void setPopulationCounts(List<PopulationIntCounts> populationCounts) {
        this.populationCounts = populationCounts;
    }
}
