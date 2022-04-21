package com.live.feign.utils;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class WireMockServers {

    public void serverPosts(Resource body) {
        WireMock.stubFor(WireMock
                .get(String.format("/posts"))
                .willReturn(WireMock.aResponse().
                        withStatus(200).
                        withHeader("Content-Type", "application/json")
                        .withBody(ResourceUtils.getContentFile(body))));
    }

}
