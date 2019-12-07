package com.hackaton.finishdown.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Objects;

public class ResLoader {

    private ClassLoader loader;

    public ResLoader() {
        loader = getClass().getClassLoader();
    }

    public File getFile(String name) {
        String path = Objects.requireNonNull(loader.getResource(name)).getFile();
        return new File(path);
    }

    public Path getPath(String name) {
        return getFile(name).toPath();
    }
}
