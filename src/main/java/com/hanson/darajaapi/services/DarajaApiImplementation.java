package com.hanson.darajaapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanson.darajaapi.config.MpesaConfiguration;
import com.hanson.darajaapi.dtos.AccessTokenResponse;
import com.hanson.darajaapi.dtos.RegisterUrlRequest;
import com.hanson.darajaapi.dtos.RegisterUrlResponse;
import com.hanson.darajaapi.utils.HelperUtility;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

import static com.hanson.darajaapi.utils.Constants.*;

/**
 * @author hanson kibet
 */
@Service
@Slf4j
public class DarajaApiImplementation implements DarajaApi {

    private final MpesaConfiguration mpesaConfiguration;
    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    public DarajaApiImplementation(MpesaConfiguration mpesaConfiguration, OkHttpClient okHttpClient, ObjectMapper objectMapper) {
        this.mpesaConfiguration = mpesaConfiguration;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public AccessTokenResponse getAccessToken() {

        String encodedCredentials = HelperUtility.toBase64String(String.format("%s:%s", mpesaConfiguration.getConsumerKey(), mpesaConfiguration.getConsumerSecret()));

        Request request = new Request.Builder()
                .url(String.format("%s?grant_type=%s", mpesaConfiguration.getOauthEndpoint(), mpesaConfiguration.getGrantType()))
                .addHeader(AUTHORIZATION_HEADER_STRING, String.format("%s %s", BASIC_AUTH_STRING, encodedCredentials))
                .addHeader(CACHE_CONTROL_HEADER, CACHE_CONTROL_HEADER_VALUE)
                .get()
                .build();
        try {

            Response response = okHttpClient.newCall(request).execute();
            assert response.body() != null;

            return objectMapper.readValue(response.body().string(), AccessTokenResponse.class);
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }

    }

    @Override
    public RegisterUrlResponse registerUrl() {

        AccessTokenResponse accessTokenResponse = getAccessToken();

        RegisterUrlRequest registerUrlRequest = new RegisterUrlRequest();

        registerUrlRequest.setConfirmationURL(mpesaConfiguration.getConfirmationURL());
        registerUrlRequest.setResponseType(mpesaConfiguration.getResponseType());
        registerUrlRequest.setShortCode(mpesaConfiguration.getShortCode());
        registerUrlRequest.setValidationURL(mpesaConfiguration.getValidationURL());

        RequestBody body = RequestBody.create(JSON_MEDIA_TYPE, Objects.requireNonNull(HelperUtility.toJson(registerUrlRequest)));

        Request request = new Request.Builder()
                .url(mpesaConfiguration.getRegisterUrlEndpoint())
                .post(body)
                .addHeader("Authorization", String.format("%s %s", BEARER_AUTH_STRING, accessTokenResponse.getAccessToken()))
                .build();

        try {

            Response response = okHttpClient.newCall(request).execute();

            assert response.body() != null;

            return objectMapper.readValue(response.body().string(), RegisterUrlResponse.class);
        } catch (IOException e) {

//            log.error(String.format("Could not register url -> %s", e.getLocalizedMessage()));
            e.printStackTrace();
            return null;
        }
    }
}
