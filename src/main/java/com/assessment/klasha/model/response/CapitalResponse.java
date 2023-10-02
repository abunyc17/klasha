package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CapitalResponse extends BaseResponse{
    private CapitalData data;

    public CapitalData getData() {
        return data;
    }

    public void setData(CapitalData data) {
        this.data = data;
    }
}
