package com.bcbsnc.effective_dates.dao;

import com.bcbsnc.effective_dates.model.EffectiveAndExpirationDate;
import com.bcbsnc.effective_dates.model.EffectiveDate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository(value = "nonDB")
public class EffectiveDateDataAccess implements EffectiveDateDataAccessInt {
    private List<LocalDate> effectiveDates;
    private List<LocalDate> expirationDates;
    private List<EffectiveAndExpirationDate> expAndEff;
    private LocalDate eventDate;
    private final static String fileName = "C:/Users/u107951/Desktop/doumentation";


    //AEP for under 65 for now, until I figure out what else I need to add
    @Override
    public EffectiveDate getAEPUnder65(String eDate, String product){
        LocalDate effectiveDate;
        eventDate = LocalDate.parse(eDate);
        expAndEff = new ArrayList<>();

        //if day is before the 16th of the month
        if(eventDate.getDayOfMonth() < 16){
            effectiveDate = eventDate.minusDays(eventDate.getDayOfMonth() - 1).plusMonths(1);
            expAndEff.add(new EffectiveAndExpirationDate(effectiveDate, effectiveDate.plusDays(60)));
        } else {
            effectiveDate = eventDate.minusDays(eventDate.getDayOfMonth() - 1).plusMonths(2);
            expAndEff.add(new EffectiveAndExpirationDate(effectiveDate, effectiveDate.plusDays(60)));
        }

        return new EffectiveDate("Under 65", "AEP", eventDate,null, "Medical", expAndEff);
    }

    // This is one of the SEP situations, this one is loss of coverage for under 65
    @Override
    public EffectiveDate QLELossOfCoverageUnder65(String rDate, String eDate, String product){
        LocalDate dateToUse;
        eventDate = LocalDate.parse(eDate);
        LocalDate referenceDate = LocalDate.parse(rDate);
        expAndEff = new ArrayList<>();

        if(eventDate.isBefore(referenceDate) || eventDate.equals(referenceDate)){
            dateToUse = referenceDate.withDayOfMonth(1).plusMonths(1);
            expAndEff.add(new EffectiveAndExpirationDate(dateToUse, dateToUse.plusDays(60)));
        } else {
            dateToUse = eventDate.withDayOfMonth(1).plusMonths(1);
            expAndEff.add(new EffectiveAndExpirationDate(dateToUse, dateToUse.plusDays(60)));
        }

        return new EffectiveDate("Under 65", "SEP", eventDate, referenceDate,  "Medical",  expAndEff);
    }

    //This is another SEP situation, this one is for Birth or Adoption (also under 65)
    @Override
    public EffectiveDate QLEBirthOrAdoptionUnder65(String eDate, String product){
        eventDate = LocalDate.parse(eDate);
        expAndEff = new ArrayList<>();

        expAndEff.add(new EffectiveAndExpirationDate(eventDate, eventDate.plusDays(60)));
        System.out.println(expAndEff.get(0).getEffectiveDate());
        if(eventDate.getDayOfMonth() > 15){
            expAndEff.add(new EffectiveAndExpirationDate(eventDate.plusDays(30), eventDate.plusDays(30).plusDays(60)));
            expAndEff.add(new EffectiveAndExpirationDate(eventDate.plusDays(60), eventDate.plusDays(60).plusDays(60)));
        } else {
            expAndEff.add(new EffectiveAndExpirationDate(eventDate.plusDays(30), eventDate.plusDays(30).plusDays(60)));
        }
        return new EffectiveDate("Under 65", "SEP", eventDate,null, "Medical", expAndEff);
    }

    //I just called it AEP but it's not AEP, this is for Over 65
    @Override
    public EffectiveDate getAEPOver65(String eDate, String config) throws IOException, InterruptedException {
        effectiveDates = new ArrayList<>();
        expirationDates = new ArrayList<>();
        expAndEff = new ArrayList<>();
        eventDate = LocalDate.parse(eDate);
        LocalDate dateHolder = eventDate;
        LocalDate expirationHolder;
        ConfigurationDataAccess configure = new ConfigurationDataAccess();
        int daysForExpiration = Integer.parseInt(configure.configReadFromGit());

        if(eventDate.getDayOfMonth() <= 14){
            dateHolder = dateHolder.withDayOfMonth(15);
            effectiveDates.add(dateHolder);
            expirationDates.add(dateHolder.plusDays(daysForExpiration));

            for(int i = 0; i < 11; i++){
                if(i % 2 == 0){
                    dateHolder = dateHolder.withDayOfMonth(1);
                    dateHolder = dateHolder.plusMonths(1);
                    expirationHolder = dateHolder.plusDays(daysForExpiration);
                    expAndEff.add(new EffectiveAndExpirationDate(dateHolder, expirationHolder));
                    effectiveDates.add(dateHolder);
                    expirationDates.add(expirationHolder);
                } else {
                    dateHolder = dateHolder.withDayOfMonth(15);
                    expirationHolder = dateHolder.plusDays(daysForExpiration);
                    expAndEff.add(new EffectiveAndExpirationDate(dateHolder, expirationHolder));
                    effectiveDates.add(dateHolder);
                    expirationDates.add(expirationHolder);
                }
            }
        } else {
            dateHolder = dateHolder.withDayOfMonth(1);
            dateHolder = dateHolder.plusMonths(1);
            expirationHolder = dateHolder.plusDays(daysForExpiration);
            effectiveDates.add(dateHolder);
            expirationDates.add(expirationHolder);

            for(int i = 0; i < 11; i++){
                if(i % 2 == 0){
                    dateHolder = dateHolder.withDayOfMonth(15);
                    expirationHolder = dateHolder.plusDays(daysForExpiration);
                    effectiveDates.add(dateHolder);
                    expirationDates.add(expirationHolder);
                    expAndEff.add(new EffectiveAndExpirationDate(dateHolder, expirationHolder));

                } else {
                    dateHolder = dateHolder.withDayOfMonth(1);
                    dateHolder = dateHolder.plusMonths(1);
                    expirationHolder = dateHolder.plusDays(daysForExpiration);
                    effectiveDates.add(dateHolder);
                    expirationDates.add(expirationHolder);
                    expAndEff.add(new EffectiveAndExpirationDate(dateHolder, expirationHolder));
                }
            }
        }

        return new EffectiveDate("Over 65", "none", eventDate, null, "med sup", expAndEff);
    }
    //U65 - MEDICAL VS/DT
    //O65 meds(we do calculate), pdp(we dont calc) , med adv(we don't calc)

}
