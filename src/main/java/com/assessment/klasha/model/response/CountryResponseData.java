package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryResponseData extends BaseResponse{
    private PopulationResponse population;
    private CapitalResponse capitalCity;
    private LocationResponse location;
    private CurrencyResponse currency;
    private IsoResponse iso;

    public PopulationResponse getPopulation() {
        return population;
    }

    public void setPopulation(PopulationResponse population) {
        this.population = population;
    }

    public CapitalResponse getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(CapitalResponse capitalCity) {
        this.capitalCity = capitalCity;
    }

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }

    public CurrencyResponse getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyResponse currency) {
        this.currency = currency;
    }

    public IsoResponse getIso() {
        return iso;
    }

    public void setIso(IsoResponse iso) {
        this.iso = iso;
    }

    //    private CountryData population;
//    private CapitalData capitalCity;
//    private LocationData location;
//    private CurrencyData currency;
//    private IsoData iso;
//
//    public CountryData getPopulation() {
//        return population;
//    }
//
//    public void setPopulation(CountryData population) {
//        this.population = population;
//    }
//
//    public CapitalData getCapitalCity() {
//        return capitalCity;
//    }
//
//    public void setCapitalCity(CapitalData capitalCity) {
//        this.capitalCity = capitalCity;
//    }
//
//    public LocationData getLocation() {
//        return location;
//    }
//
//    public void setLocation(LocationData location) {
//        this.location = location;
//    }
//
//    public CurrencyData getCurrency() {
//        return currency;
//    }
//
//    public void setCurrency(CurrencyData currency) {
//        this.currency = currency;
//    }
//
//    public IsoData getIso() {
//        return iso;
//    }
//
//    public void setIso(IsoData iso) {
//        this.iso = iso;
//    }
}
