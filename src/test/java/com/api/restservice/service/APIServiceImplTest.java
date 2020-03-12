package com.api.restservice.service;

import com.api.restservice.SpringTestConfig;
import com.api.restservice.model.Error;
import com.api.restservice.model.Quote;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 23:33
 * Email: xianzhihai@gmail.com
 * Description:
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringTestConfig.class)
public class APIServiceImplTest {

    @Autowired
    private APIServiceImpl apiService;



    @Test
    public void givenRemoteApiCall_when404Error_thenThrowNotFound() {
        //Assert.assertNotNull(this.server);
        //String fakeAPI = "https://gturnquist-quoters.cfapps.io/api/ran";
        String fakeAPI = "http://localhost:8080";

        Error error = new Error();
        error.setTimestamp(LocalDateTime.now());
        error.setMessage("API not found: "+ fakeAPI);
        error.setStatus(HttpStatus.NOT_FOUND.toString());

        Quote testQuote = new Quote("Failure", error);


        Quote quote = apiService.fetchAPI(fakeAPI);

        Assert.assertArrayEquals(new Object[]{testQuote.getType(), String.valueOf(testQuote.getError().getStatus())},
                new Object[]{quote.getType(), String.valueOf(quote.getError().getStatus())});
    }

}
