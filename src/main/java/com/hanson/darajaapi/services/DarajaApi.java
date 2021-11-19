package com.hanson.darajaapi.services;

import com.hanson.darajaapi.dtos.AccessTokenResponse;
import com.hanson.darajaapi.dtos.RegisterUrlResponse;
import com.hanson.darajaapi.dtos.SimulateTransactionRequest;
import com.hanson.darajaapi.dtos.SimulateTransactionResponse;

public interface DarajaApi {

    AccessTokenResponse getAccessToken();

    RegisterUrlResponse registerUrl();

    SimulateTransactionResponse simulateC2BTransaction(SimulateTransactionRequest simulateTransactionRequest);

}
