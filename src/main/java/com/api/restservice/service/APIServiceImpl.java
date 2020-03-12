package com.api.restservice.service;

import com.api.restservice.exception.APIException;
import com.api.restservice.exception.APINotFoundException;
import com.api.restservice.exception.RestTemplateResponseErrorHandler;
import com.api.restservice.model.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import com.api.restservice.model.Error;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 19:42
 * Email: xianzhihai@gmail.com
 * Description: https://gturnquist-quoters.cfapps.io/api/random
 */

@Service
public class APIServiceImpl {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
         return restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }


    public Quote fetchAPI(String apiUrl) {
        Error error = new Error();
        error.setTimestamp(LocalDateTime.now());
        try {
            return getRestTemplate().getForObject(apiUrl, Quote.class);
        }catch (APIException ie){

            error.setMessage("API Error: "+ apiUrl);
            error.setStatus(HttpStatus.BAD_REQUEST.toString());

        }catch (APINotFoundException e){
            error.setMessage("API not found: "+ apiUrl);
            error.setStatus(HttpStatus.NOT_FOUND.toString());
        }

        return new Quote("Failure", error);

    }
}
