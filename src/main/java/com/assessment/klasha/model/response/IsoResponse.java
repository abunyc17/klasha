package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class IsoResponse extends BaseResponse{
    private IsoData data;

    public IsoData getData() {
        return data;
    }

    public void setData(IsoData data) {
        this.data = data;
    }
}
