package com.bcbsnc.effective_dates.model;

import java.time.LocalDate;

public class EffectiveAndExpirationDate {

    private LocalDate effectiveDate;
    private LocalDate expirationDate;

    public EffectiveAndExpirationDate(LocalDate effectiveDate, LocalDate expirationDate) {
        this.effectiveDate = effectiveDate;
        this.expirationDate = expirationDate;
    }


    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
