package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityResponse extends BaseResponse{
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
