package com.api.restservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-13 01:44
 * Email: xianzhihai@gmail.com
 * Description:
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.api.restservice")
public class SpringTestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}