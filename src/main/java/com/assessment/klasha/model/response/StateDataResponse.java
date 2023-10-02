package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class StateDataResponse extends BaseResponse{
    private StatesData data;

    public StatesData getData() {
        return data;
    }

    public void setData(StatesData data) {
        this.data = data;
    }
}
