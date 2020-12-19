package com.live.feign.clientFeign;

import com.live.feign.DTO.PostDTO;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertFalse;

class PostClientTest {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String RESPONSE_POSTS = "[{\n" +
            "    \"userId\": 1,\n" +
            "    \"id\": 1,\n" +
            "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
            "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
            "  }]";


    private PostClient postClient;

    @Test
    public void whenGetPostClientThenReturnOk() {
        this.buildFeignClient(new MockClient().ok(
                HttpMethod.GET,
                BASE_URL.concat("/posts"),
                RESPONSE_POSTS));

        List<PostDTO> postDTOList = postClient.getAllPosts();

        assertFalse(postDTOList.isEmpty());
        assertThat(postDTOList.get(0).getId(), equalTo(1));
        assertThat(postDTOList.get(0).getUserId(), equalTo(1));
        assertThat(postDTOList.get(0).getTitle(), containsString("provident"));
    }


    private void buildFeignClient(MockClient mockClient) {
        postClient = Feign.builder()
                .client(mockClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(PostClient.class, BASE_URL);
    }

}