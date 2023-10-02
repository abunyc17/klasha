package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationResponse extends BaseResponse{
    private LocationData data;

    public LocationData getData() {
        return data;
    }

    public void setData(LocationData data) {
        this.data = data;
    }
}
