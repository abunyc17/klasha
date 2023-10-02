package com.assessment.klasha.util;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

/**
 * Created by Abubakar Adamu on 01/10/2023
 **/

@Component
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder
                .setConnectTimeout(Duration.ofMillis(ApplicationConstants.CONNECT_TIME_OUT))
                .setReadTimeout(Duration.ofMillis(ApplicationConstants.READ_TIME_OUT))
                .build();
    }
}
