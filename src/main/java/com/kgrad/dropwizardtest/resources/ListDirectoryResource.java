package com.kgrad.dropwizardtest.resources;

import com.kgrad.dropwizardtest.core.Directory;
import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/list-directory")
@Produces(MediaType.APPLICATION_JSON)
public class ListDirectoryResource {
    private final String defaultDirectory;
    private final AtomicLong counter;

    public ListDirectoryResource(String directory) {
        this.defaultDirectory = directory;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Directory listDirectory(@QueryParam("directory") Optional<String> directory) {
        return new Directory(counter.incrementAndGet(), directory.or(defaultDirectory));
    }
}
