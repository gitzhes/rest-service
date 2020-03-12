package com.api.restservice.controller;

import com.api.restservice.model.Quote;
import com.api.restservice.service.APIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 16:17
 * Email: xianzhihai@gmail.com
 * Description:
 * data model - Quote
 * url - https://gturnquist-quoters.cfapps.io/api/random
 */

@RestController
public class APIController {

    @Autowired
    public APIServiceImpl serviceImpl;

    @GetMapping("/service")
    public Quote processQuote(Model model) {

        String url = "https://gturnquist-quoters.cfapps.io/api/random";

        return serviceImpl.fetchAPI(url);
    }

}
