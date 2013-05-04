package com.kgrad.dropwizardtest;

import com.yammer.dropwizard.config.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class ListDirectoryConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty
    private String directory;

    public String getDirectory() {
        return directory;
    }
}