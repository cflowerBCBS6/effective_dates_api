package com.bcbsnc.effective_dates.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

import java.util.List;

//TODO: add product field and Expiration field
public class EffectiveDate {
    private  String marketSegment;
    private  String situation;
    private  LocalDate eventDate;
    private  LocalDate referenceDate;
    private String product;
    private List<EffectiveAndExpirationDate> effectiveDatesAndExpirationDate;

    public EffectiveDate(@JsonProperty("MarketSegment") String marketSegment,
                         @JsonProperty("Situation") String situation,
                         @JsonProperty("Eventdate") LocalDate eventDate,
                         @JsonProperty("ReferenceDate") LocalDate referenceDate,
                         @JsonProperty("Product") String product,
                         @JsonProperty("EffectiveAndExpirationDates") List<EffectiveAndExpirationDate> effectiveDatesAndExpirationDate){
        this.marketSegment = marketSegment;
        this.situation = situation;
        this.eventDate = eventDate;
        this.referenceDate = referenceDate;
        this.product = product;
        this.effectiveDatesAndExpirationDate = effectiveDatesAndExpirationDate;
    }

    public String getMarket_Segment() {
        return marketSegment;
    }

    public void setMarketSegment(String marketSegment) {
        this.marketSegment = marketSegment;
    }

    public String getSituation() {
        return situation;
    }

    public LocalDate getEvent_Date() {
        return eventDate;
    }

    public LocalDate getReference_Date() {
        return referenceDate;
    }

    public String getProduct() {
        return product;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setReferenceDate(LocalDate referenceDate) {
        this.referenceDate = referenceDate;
    }

    public List<EffectiveAndExpirationDate> getEffectiveDatesAndExpirationDate() {
        return effectiveDatesAndExpirationDate;
    }

    public void setEffectiveDatesAndExpirationDate(List<EffectiveAndExpirationDate> effectiveDatesAndExpirationDate) {
        this.effectiveDatesAndExpirationDate = effectiveDatesAndExpirationDate;
    }

    @Override
    public String toString() {
        return "EffectiveDate{" +
                "marketSegment='" + marketSegment + '\'' +
                ", situation='" + situation + '\'' +
                ", eventDate=" + eventDate +
                ", referenceDate=" + referenceDate +
                '}';
    }
}
