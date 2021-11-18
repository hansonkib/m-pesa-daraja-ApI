package com.hanson.darajaapi.services;

import com.hanson.darajaapi.dtos.AccessTokenResponse;
import com.hanson.darajaapi.dtos.RegisterUrlResponse;

public interface DarajaApi {

    AccessTokenResponse getAccessToken();

    RegisterUrlResponse registerUrl();
}
