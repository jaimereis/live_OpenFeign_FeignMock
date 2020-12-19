package com.live.feign.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PostDTO {

    private Integer userId;
    private Integer id;
    private String title;
    private String body;


}
