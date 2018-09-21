package com.exercise.store.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Response<T> {

    @JsonProperty("statusCode")
    private String statusCode="0000";

    @JsonProperty("statusDescription")
    private String statusDescription="successfull";

    @JsonProperty("responseDetail")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T response;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
