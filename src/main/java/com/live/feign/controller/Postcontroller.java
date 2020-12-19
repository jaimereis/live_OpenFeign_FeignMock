package com.live.feign.controller;

import com.live.feign.DTO.PostDTO;
import com.live.feign.clientFeign.PostClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class Postcontroller {

    private PostClient postClient;

    @GetMapping(value = "/{id}")
    public List<PostDTO> getAllPosts() {
        return postClient.getAllPosts();
    }

    @GetMapping(value = "/id/{id}")
    public PostDTO getAllPosts(@PathVariable Integer id) {
        return postClient.getPostById(id);
    }


}
