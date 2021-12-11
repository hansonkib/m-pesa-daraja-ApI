package com.hanson.darajaapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultParameters {

    @JsonProperty("ResultParameter")
    private List<ResultParameterItem> resultParameter;

    public List<ResultParameterItem> getResultParameter() {
        return resultParameter;
    }

    public void setResultParameter(List<ResultParameterItem> resultParameter) {
        this.resultParameter = resultParameter;
    }
}
