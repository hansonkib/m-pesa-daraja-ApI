package com.hanson.darajaapi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanson.darajaapi.dtos.RegisterUrlRequest;
import lombok.extern.slf4j.Slf4j;
import org.bson.internal.Base64;

import java.nio.charset.StandardCharsets;

@Slf4j
public class HelperUtility {

    public static String toBase64String(String value){

        byte[] data = value.getBytes(StandardCharsets.ISO_8859_1);

        return Base64.encode(data);
    }

    public static String toJson(Object object) {

        try {

            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {

            return null;
        }

    }
}