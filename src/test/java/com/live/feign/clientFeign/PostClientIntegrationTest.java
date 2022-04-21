package com.live.feign.clientFeign;

import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import com.live.feign.DTO.PostDTO;
import com.live.feign.FeignApplication;
import com.live.feign.utils.DataMapper;
import com.live.feign.utils.WireMockServers;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;

@WireMockTest(httpPort = 8081)
@SpringBootTest(classes = FeignApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PostClientIntegrationTest {

    @Autowired
    private PostClient postClient;
    @Autowired
    private WireMockServers wireMock;
    @Autowired
    private DataMapper dataMapper;

    @Test
    @Order(1)
    @DisplayName("1 - Request all posts")
    public void givenRequestUrlPostsThenReturnStatusCode200() {
        wireMock.serverPosts(dataMapper.getPosts200());
        List<PostDTO> postDTOList = postClient.getAllPosts();

        assertFalse(postDTOList.isEmpty());
        assertThat(postDTOList.get(0).getId(), equalTo(1));
        assertThat(postDTOList.get(0).getUserId(), equalTo(1));
        assertThat(postDTOList.get(0).getTitle(), containsString("provident"));

    }

}