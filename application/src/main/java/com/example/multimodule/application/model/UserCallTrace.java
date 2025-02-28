package com.example.multimodule.application.model;

import java.time.OffsetDateTime;

public class UserCallTrace {

    private String userName;

    private String requestType;
    private OffsetDateTime callTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public OffsetDateTime getCallTime() {
        return callTime;
    }

    public void setCallTime(OffsetDateTime callTime) {
        this.callTime = callTime;
    }
}
