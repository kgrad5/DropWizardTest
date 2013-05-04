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
        final String saying = String.format(directory, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("directory doesn't include a string");
        }
        return Result.healthy();
    }
}
