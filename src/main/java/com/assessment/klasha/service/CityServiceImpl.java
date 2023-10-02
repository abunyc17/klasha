package com.assessment.klasha.service;

import com.assessment.klasha.model.response.CityPopulationResponse;
import com.assessment.klasha.model.response.Data;
import com.assessment.klasha.model.response.PopulationCountExtended;
import com.assessment.klasha.util.ApplicationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    RestTemplate restTemplateConfig;


    @Override
    public CityPopulationResponse getAllCity(int n) {
        CityPopulationResponse filteredCityPopulationResponse = new CityPopulationResponse();
        String endpoint = ApplicationConstants.BASE_URL + ApplicationConstants.GET_COUNTRY_POPULATION;
        CityPopulationResponse cityPopulationResponse =  restTemplateConfig.getForObject(String.format("%s", endpoint),CityPopulationResponse.class);
        System.out.println("return Data size" + cityPopulationResponse.getData().size());
        List<Data> dataList = cityPopulationResponse.getData().stream().filter(d -> d.getCountry().equalsIgnoreCase("Italy")
        || d.getCountry().equalsIgnoreCase("New Zealand") || d.getCountry().equalsIgnoreCase("Ghana")
        ).toList();
        System.out.println("filter data list" +dataList.size());
        if(n > dataList.size()){
            filteredCityPopulationResponse = buildCityResponse(cityPopulationResponse,dataList);
        }else{
           List<Data> filteredNData = dataList.stream().sorted(Comparator.comparingDouble(data -> getHighestPopulationCount(data))).limit(n).collect(Collectors.toList());
           System.out.println("N data = "+ filteredNData.size());
            filteredCityPopulationResponse = buildCityResponse(cityPopulationResponse,filteredNData);
        }

        return filteredCityPopulationResponse;
    }

    private static double getHighestPopulationCount(Data data) {
        List<PopulationCountExtended> populationCounts = data.getPopulationCounts();
        double highestPopulation = 0;

        for (PopulationCountExtended populationCount : populationCounts) {
            double populationValue = Double.parseDouble(populationCount.getValue());
            if (populationValue > highestPopulation) {
                highestPopulation = populationValue;
            }
        }
        return highestPopulation;
    }

    private CityPopulationResponse buildCityResponse(CityPopulationResponse cityPopulationResponse, List<Data> data){
        CityPopulationResponse cityResponse = new CityPopulationResponse();
        cityResponse.setError(cityPopulationResponse.isError());
        cityResponse.setMsg(cityPopulationResponse.getMsg());
        cityResponse.setData(data);
        return cityResponse;
    }

}
