package com.MyWebsite.Utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class URIHandler {
    private URIHandler() {
        // do nothing
    }

    public static URI getURI(String path, String... stuffId) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path(path).buildAndExpand(stuffId).toUri();
    }

}
