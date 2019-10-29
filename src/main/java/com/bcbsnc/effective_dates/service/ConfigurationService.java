package com.bcbsnc.effective_dates.service;

import com.bcbsnc.effective_dates.dao.ConfigurationDataAccesInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConfigurationService {
    private final ConfigurationDataAccesInt configurationDataAccesInt;

    @Autowired
    public ConfigurationService(ConfigurationDataAccesInt configurationDataAccesInt) {
        this.configurationDataAccesInt = configurationDataAccesInt;
    }

    public void setConfig(String configData) throws IOException, InterruptedException {
         configurationDataAccesInt.configWriteToFile(configData);
    }
}
