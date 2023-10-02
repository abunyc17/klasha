package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CapitalData extends IsoData{
    private String capital;

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
