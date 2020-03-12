package com.api.restservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

/**
 * Created with Intellij IDEA.
 * Author: Zhihai
 * Date: 2020-03-12 22:17
 * Email: xianzhihai@gmail.com
 * Description:
 */


@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {
        try {
            return (
                    httpResponse.getStatusCode().series() == CLIENT_ERROR
                            || httpResponse.getStatusCode().series() == SERVER_ERROR);
        }catch(IOException ioe){
            throw new APIException();
        }

    }

    @Override
    public void handleError(ClientHttpResponse httpResponse){
        try {
            if (httpResponse.getStatusCode().series() == SERVER_ERROR) {
                // handle SERVER_ERROR
                throw new APIException();
            } else if (httpResponse.getStatusCode().series() == CLIENT_ERROR) {
                // handle CLIENT_ERROR
                if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                    throw new APINotFoundException();
                }else throw new APIException();
            }
        }catch(IOException ioe){
            throw new APIException();
        }
    }
}