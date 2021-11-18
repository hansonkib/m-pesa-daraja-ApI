package com.hanson.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegisterUrlResponse {

    @JsonProperty("ConversationID")
    private String conversationID;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("OriginatorCoversationID")
    private String originatorCoversationID;

    public String getConversationID() {
        return conversationID;
    }

    public void setConversationID(String conversationID) {
        this.conversationID = conversationID;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    public String getOriginatorCoversationID() {
        return originatorCoversationID;
    }

    public void setOriginatorCoversationID(String originatorCoversationID) {
        this.originatorCoversationID = originatorCoversationID;
    }
}
