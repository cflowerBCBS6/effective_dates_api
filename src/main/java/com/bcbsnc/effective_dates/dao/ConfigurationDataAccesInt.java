package com.bcbsnc.effective_dates.dao;


import java.io.IOException;

public interface ConfigurationDataAccesInt {
    void configWriteToFile(String data) throws IOException, InterruptedException;
    String configReadFromGit() throws IOException, InterruptedException;
}
