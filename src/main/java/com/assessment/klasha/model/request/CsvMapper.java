package com.assessment.klasha.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 02/10/2023
 **/

@JsonIgnoreProperties(ignoreUnknown = true)
public class CsvMapper {
    private String sourceCurrency;
    private String targetCurrency;
    private double rate;
    private double xColumn;

    public String getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(String sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getxColumn() {
        return xColumn;
    }

    public void setxColumn(double xColumn) {
        this.xColumn = xColumn;
    }
}
