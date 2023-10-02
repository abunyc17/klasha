package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyResponse extends BaseResponse{
    private CurrencyData data;

    public CurrencyData getData() {
        return data;
    }

    public void setData(CurrencyData data) {
        this.data = data;
    }
}
