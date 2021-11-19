package com.hanson.darajaapi.controllers;

import com.hanson.darajaapi.dtos.*;
import com.hanson.darajaapi.repository.B2CC2BEntriesRepository;
import com.hanson.darajaapi.services.DarajaApi;
import com.hanson.documents.B2C_C2B_Entries;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("mobile-money")
public class MpesaController {

    private final DarajaApi darajaApi;
    private final AcknowledgeResponse acknowledgeResponse;
    private final B2CC2BEntriesRepository b2CC2BEntriesRepository;

    public MpesaController(DarajaApi darajaApi, AcknowledgeResponse acknowledgeResponse, B2CC2BEntriesRepository b2CC2BEntriesRepository) {
        this.darajaApi = darajaApi;
        this.acknowledgeResponse = acknowledgeResponse;
        this.b2CC2BEntriesRepository = b2CC2BEntriesRepository;
    }

    @GetMapping(path = "/token", produces = "application/json")
    public ResponseEntity<AccessTokenResponse> getAccessToken(){

        return ResponseEntity.ok(darajaApi.getAccessToken());
    }

    @GetMapping(path = "/register-url", produces = "application/json")
    public ResponseEntity<RegisterUrlResponse> registerUrl(){

        return ResponseEntity.ok(darajaApi.registerUrl());
    }

    @PostMapping(path = "/validation", produces = "application/json")
    public ResponseEntity<AcknowledgeResponse> mpesaValidation(@RequestBody MpesaValidationResponse mpesaValidationResponse){

        B2C_C2B_Entries b2CC2BEntry = b2CC2BEntriesRepository.findByBillRefNumber(mpesaValidationResponse.getBillRefNumber());

        b2CC2BEntry.setRawCallbackPayloadResponse(mpesaValidationResponse);
        b2CC2BEntry.setResultCode("0");
        b2CC2BEntry.setTransactionId(mpesaValidationResponse.getTransID());

        b2CC2BEntriesRepository.save(b2CC2BEntry);
        return ResponseEntity.ok(acknowledgeResponse);
    }

    @PostMapping(path = "/simulate-c2b", produces = "application/json")
    public ResponseEntity<SimulateTransactionResponse> simulateB2CTransaction(@RequestBody SimulateTransactionRequest simulateTransactionRequest) {

        SimulateTransactionResponse simulateTransactionResponse = darajaApi.simulateC2BTransaction(simulateTransactionRequest);

        B2C_C2B_Entries b2C_c2BEntry = new B2C_C2B_Entries();
        b2C_c2BEntry.setTransactionType("C2B");
        b2C_c2BEntry.setBillRefNumber(simulateTransactionRequest.getBillRefNumber());
        b2C_c2BEntry.setAmount(simulateTransactionRequest.getAmount());
        b2C_c2BEntry.setEntryDate(new Date());
        b2C_c2BEntry.setOriginatorConversationId(simulateTransactionResponse.getOriginatorCoversationID());
        b2C_c2BEntry.setConversationId(simulateTransactionResponse.getConversationID());
        b2C_c2BEntry.setMsisdn(simulateTransactionRequest.getMsisdn());

        b2CC2BEntriesRepository.save(b2C_c2BEntry);

        return ResponseEntity.ok(simulateTransactionResponse);
    }
}
