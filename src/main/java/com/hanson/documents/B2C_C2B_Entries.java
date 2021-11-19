package com.hanson.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "b2c_c2b_entries")
public class B2C_C2B_Entries {

    @Id
    private String internalId;

    private String transactionType;

    @Indexed(unique = true)
    private String transactionId;

    private String billRefNumber;

    private String msisdn;

    private String amount;

    @Indexed(unique = true)
    private String conversationId;

    @Indexed(unique = true)
    private String originatorConversationId;

    private Date EntryDate;

    private String resultCode;

    private Object rawCallbackPayloadResponse;

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getBillRefNumber() {
        return billRefNumber;
    }

    public void setBillRefNumber(String billRefNumber) {
        this.billRefNumber = billRefNumber;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getOriginatorConversationId() {
        return originatorConversationId;
    }

    public void setOriginatorConversationId(String originatorConversationId) {
        this.originatorConversationId = originatorConversationId;
    }

    public Date getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(Date entryDate) {
        EntryDate = entryDate;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object getRawCallbackPayloadResponse() {
        return rawCallbackPayloadResponse;
    }

    public void setRawCallbackPayloadResponse(Object rawCallbackPayloadResponse) {
        this.rawCallbackPayloadResponse = rawCallbackPayloadResponse;
    }
}
