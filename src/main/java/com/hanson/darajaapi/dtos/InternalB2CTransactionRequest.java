package com.hanson.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InternalB2CTransactionRequest {

    @JsonProperty("Remarks")
    private String remarks;

    @JsonProperty("Amount")
    private String amount;

    @JsonProperty("Occassion")
    private String occassion;

    @JsonProperty("CommandID")
    private String commandID;

    @JsonProperty("PartyB")
    private String partyB;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOccassion() {
        return occassion;
    }

    public void setOccassion(String occassion) {
        this.occassion = occassion;
    }

    public String getCommandID() {
        return commandID;
    }

    public void setCommandID(String commandID) {
        this.commandID = commandID;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }
}
