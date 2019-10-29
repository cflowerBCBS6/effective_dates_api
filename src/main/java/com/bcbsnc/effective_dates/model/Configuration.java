package com.bcbsnc.effective_dates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Configuration {
    private String expirationDate;

    public Configuration(@JsonProperty(value = "Expiration limitby days") String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
