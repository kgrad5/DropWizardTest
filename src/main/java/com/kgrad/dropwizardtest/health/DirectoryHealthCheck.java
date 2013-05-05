package com.kgrad.dropwizardtest.health;

import com.yammer.metrics.core.HealthCheck;

public class DirectoryHealthCheck extends HealthCheck {
    private final String directory;

    public DirectoryHealthCheck(String directory) {
        super("directory");
        this.directory = directory;
    }

    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
