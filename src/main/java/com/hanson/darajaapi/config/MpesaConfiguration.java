package com.hanson.darajaapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")
public class MpesaConfiguration {

    private String consumerKey;
    private String consumerSecret;
    private String grantType;
    private String oauthEndpoint;

    @Override
    public String toString() {

        return String.format("{consumerKey = ' %s ', consumerSecret = ' %s ', grantType = ' %s ', oauthEndpoint = ' %s '}");
    }


    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getOauthEndpoint() {
        return oauthEndpoint;
    }

    public void setOauthEndpoint(String oauthEndpoint) {
        this.oauthEndpoint = oauthEndpoint;
    }
}
