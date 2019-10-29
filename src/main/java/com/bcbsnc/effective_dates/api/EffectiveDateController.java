package com.bcbsnc.effective_dates.api;

import com.bcbsnc.effective_dates.model.EffectiveDate;
import com.bcbsnc.effective_dates.service.ConfigurationService;
import com.bcbsnc.effective_dates.service.EffectiveDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;



@RequestMapping("/api/effectivedates")
@RestController
public class EffectiveDateController {

    private EffectiveDateService effectiveDateService;
    private ConfigurationService configurationService;

    @Autowired
    public EffectiveDateController(EffectiveDateService effectiveDateService, ConfigurationService configurationService) {
        this.effectiveDateService = effectiveDateService;
        this.configurationService = configurationService;
    }

    //YYYY-MM-DD
    @CrossOrigin
    @GetMapping("/under65")
    public EffectiveDate effectiveDate(@RequestParam(value = "eventDate", required = false) String eventDate,
                                       @RequestParam(value = "situation", required = false) String situation,
                                       @RequestParam(value = "referenceDate", required = false) String referenceDate,
                                       @RequestParam(value = "product", required = false) String product)
    {
        //AEP is the only null occurrence

        if(eventDate == null) {
            eventDate = LocalDate.now().toString();
        }
        if(referenceDate == null){
            referenceDate = LocalDate.now().toString();
        }
        if(situation == null){
            return effectiveDateService.getAEPU65(eventDate, product);
        } else if(situation.toUpperCase().equals("LOC")) {
            return effectiveDateService.QLELossOfCoverageUnder65(referenceDate, eventDate, product);
        } else if(situation.toUpperCase().equals("BOA")) {
            return effectiveDateService.QLEBirthOrAdoptionUnder65(eventDate, product);
        } else {
            return effectiveDateService.getAEPU65(eventDate, product);
        }
    }

    @GetMapping("/over65")
    public EffectiveDate effectiveDateOver65(@RequestParam(value = "eventDate", required = false)String eventDate,
                                             @RequestParam(value = "product", required = false)String product) throws JSONException, IOException, InterruptedException {
        if(eventDate == null) {
            eventDate = LocalDate.now().toString();
        }
        return effectiveDateService.getAEPOver65(eventDate, product);
    }

    @GetMapping("/help")
    public URI getHelp() throws IOException, URISyntaxException {
        return new URI("http://cflowerbcbs6.github.io/documenation-effectivedates-api/");
    }

    @PostMapping("/configure")
    public void configurations(@RequestBody String configData) throws IOException, InterruptedException {
        configurationService.setConfig(configData);
    }

//    @GetMapping("/testQuoteDate")
//    public EffectiveDate testQuoteDate(){
//        return null;
//    }

    //for testing they can pass in

}
