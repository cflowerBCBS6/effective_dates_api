package com.bcbsnc.effective_dates.dao;

import com.bcbsnc.effective_dates.model.EffectiveDate;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;

public interface EffectiveDateDataAccessInt {

    EffectiveDate getAEPUnder65(String eventDate, String product);
    EffectiveDate QLELossOfCoverageUnder65(String eventDate, String referenceDate, String product);
    EffectiveDate QLEBirthOrAdoptionUnder65(String eventDate, String product);
    EffectiveDate getAEPOver65(String eventDate, String product) throws JSONException, IOException, InterruptedException;
}
