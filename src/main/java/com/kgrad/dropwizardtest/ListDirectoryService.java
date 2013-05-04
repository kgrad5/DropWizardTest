package com.kgrad.dropwizardtest;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.kgrad.dropwizardtest.resources.ListDirectoryResource;
import com.kgrad.dropwizardtest.health.DirectoryHealthCheck;

public class ListDirectoryService extends Service<ListDirectoryConfiguration> {

    public static void main(String[] args) throws Exception {
        new ListDirectoryService().run(args);
    }

    @Override
    public void initialize(Bootstrap<ListDirectoryConfiguration> bootstrap) {
        bootstrap.setName("list-directory");
    }

    @Override
    public void run(ListDirectoryConfiguration configuration,
            Environment environment) {
        final String directory = configuration.getDirectory();
        environment.addResource(new ListDirectoryResource(directory));
        environment.addHealthCheck(new DirectoryHealthCheck(directory));
    }
}