package com.kgrad.dropwizardtest.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Directory {

    private final long id;
    private final String directory;

    public Directory(long id, String directory) {
        this.id = id;
        this.directory = directory;
    }

    public long getId() {
        return id;
    }

    public List<FileNode> getDirectoryList() {

        // List the directory.
        File dir = new File(directory);
        File[] files = dir.listFiles();
        List<FileNode> nodes = Lists.newArrayList();
        
        for (File f : files) {
            nodes.add(new FileNode(f));
        }

        return nodes;

    }

    public class FileNode {

        private final String type;
        private final String name;

        public FileNode(File f) {
            this.type = f.isDirectory() ? "Dir" : "File";
            this.name = f.getName();
        }

        public String getType() {
            return type;
        }

        public String getName() {
            return name;
        }
    }
}
