package com.assessment.klasha.model.response;

import java.util.List;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/
public class CityModel {
    private String stateName;
    private List<String> cities;

    public CityModel() {
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
