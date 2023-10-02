package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class PopulationResponse extends BaseResponse{
    private CountryData data;

    public CountryData getData() {
        return data;
    }

    public void setData(CountryData data) {
        this.data = data;
    }
}
