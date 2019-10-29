package com.bcbsnc.effective_dates.service;

import com.bcbsnc.effective_dates.dao.EffectiveDateDataAccessInt;
import com.bcbsnc.effective_dates.model.EffectiveDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class EffectiveDateService {
    private final EffectiveDateDataAccessInt effectiveDateDataAccessInt;

    @Autowired
    public EffectiveDateService(EffectiveDateDataAccessInt effectiveDateDataAccessInt) {
        this.effectiveDateDataAccessInt = effectiveDateDataAccessInt;
    }

    public EffectiveDate getAEPU65(String eDate, String product) {
        return effectiveDateDataAccessInt.getAEPUnder65(eDate, product);
    }
    public EffectiveDate QLELossOfCoverageUnder65(String referenceDate, String eventDate, String product){
        return effectiveDateDataAccessInt.QLELossOfCoverageUnder65(eventDate, referenceDate, product);
    }
    public EffectiveDate QLEBirthOrAdoptionUnder65(String eventDate, String product){
        return effectiveDateDataAccessInt.QLEBirthOrAdoptionUnder65(eventDate, product);
    }
    public EffectiveDate getAEPOver65(String eventDate, String product) throws JSONException, IOException, InterruptedException {
        return effectiveDateDataAccessInt.getAEPOver65(eventDate, product);
    }
}
