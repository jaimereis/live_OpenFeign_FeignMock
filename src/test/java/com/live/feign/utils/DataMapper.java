package com.live.feign.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

    @Getter
    @Setter
    @Value("classpath:json/posts_200.json")
    private Resource posts200;


}
