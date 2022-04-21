package com.live.feign.clientFeign;

import com.live.feign.DTO.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "post", url = "${api.post.url}")
public interface PostClient {

    @GetMapping(value = "/posts")
    List<PostDTO> getAllPosts();

    @GetMapping(value = "/posts/{id}")
    PostDTO getPostById(@RequestParam(value = "id") Integer id);

}
