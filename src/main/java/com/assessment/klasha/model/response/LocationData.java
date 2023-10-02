package com.assessment.klasha.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationData {
    private String name;
    private String iso2;
    private int longitute;
    private int lat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public int getLongitute() {
        return longitute;
    }

    public void setLongitute(int longitute) {
        this.longitute = longitute;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }
}
