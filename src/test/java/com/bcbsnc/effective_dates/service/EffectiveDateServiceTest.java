package com.bcbsnc.effective_dates.service;


import com.bcbsnc.effective_dates.dao.EffectiveDateDataAccess;
import com.bcbsnc.effective_dates.model.EffectiveDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class EffectiveDateServiceTest {

    private EffectiveDateDataAccess effectiveDateDataAccess = new EffectiveDateDataAccess();

    private  String marketSegment;
    private  String situation;
    private  LocalDate eventDate;
    private  LocalDate referenceDate;
    private  LocalDate effectiveDate;
    private  List<LocalDate> listOfEffectiveDates;
    private HashMap<String, LocalDate> expirationDates;


//    @Test
//    void getU65AEP() {
//        String effectiveDate1 = effectiveDateDataAccess.getAEPUnder65("2019-10-18").toString();
//        String effectiveDateTest = new EffectiveDate("Under 65", "AEP", LocalDate.parse("2019-10-18"),null, LocalDate.parse("2019-12-01"),null, null,null, LocalDate.parse("2020-02-01")).toString();
//        Assertions.assertEquals(effectiveDateTest, effectiveDate1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void getO65(){
//        String effectiveDate1 = effectiveDateDataAccess.getAEPOver65("2019-10-18").toString();
//
//        List<LocalDate> effectiveDates = new ArrayList<>();
//
//        effectiveDates.add(LocalDate.parse("2019-11-01"));
//        effectiveDates.add(LocalDate.parse("2019-11-15"));
//        effectiveDates.add(LocalDate.parse("2019-12-01"));
//        effectiveDates.add(LocalDate.parse("2019-12-15"));
//        effectiveDates.add(LocalDate.parse("2020-01-01"));
//        effectiveDates.add(LocalDate.parse("2020-01-15"));
//        effectiveDates.add(LocalDate.parse("2020-02-01"));
//        effectiveDates.add(LocalDate.parse("2020-02-15"));
//        effectiveDates.add(LocalDate.parse("2020-03-01"));
//        effectiveDates.add(LocalDate.parse("2020-03-15"));
//        effectiveDates.add(LocalDate.parse("2020-04-01"));
//        effectiveDates.add(LocalDate.parse("2020-04-15"));
//        String effectiveDateTest = new EffectiveDate("Over 65", "none", LocalDate.parse("2019-10-18"), null, null, effectiveDates, null, null, null).toString();
//
//        Assertions.assertEquals(effectiveDateTest, effectiveDate1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void QleLOCU65() {
//        String effectiveDate1 = effectiveDateDataAccess.QLELossOfCoverageUnder65("2019-10-18", "2019-10-18").toString();
//        String effectiveDateTest = new EffectiveDate("Under 65", "SEP: Loss of coverage", LocalDate.parse("2019-10-18"), LocalDate.parse("2019-10-18"), LocalDate.parse("2019-11-01"),null, null,null, LocalDate.parse("2020-01-01")).toString();
//        Assertions.assertEquals(effectiveDateTest, effectiveDate1);
//    }
//
//    @org.junit.jupiter.api.Test
//    void QleBOAU65() {
//        String effectiveDate1 = effectiveDateDataAccess.QLEBirthOrAdoptionUnder65("2019-10-18").toString();
//        List<LocalDate> effectiveDates = new ArrayList<>();
//        effectiveDates.add(LocalDate.of(2019,10,18));
//        effectiveDates.add(LocalDate.of(2019,12,1));
//        effectiveDates.add(LocalDate.of(2019,11,1));
//        String effectiveDateTest = new EffectiveDate("Under 65", "SEP: Birth or adoption", LocalDate.parse("2019-10-18"),null, null, effectiveDates, null, null, null).toString();
//        Assertions.assertEquals(effectiveDateTest, effectiveDate1);
//    }
}