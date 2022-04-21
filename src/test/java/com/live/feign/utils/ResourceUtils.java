package com.live.feign.utils;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;

@Component
public class ResourceUtils {

    public static String getContentFile(Resource resource) {
        try {
            return new String(Files.readAllBytes(resource.getFile().toPath()));
        } catch (IOException e) {
            return null;
        }
    }

}
