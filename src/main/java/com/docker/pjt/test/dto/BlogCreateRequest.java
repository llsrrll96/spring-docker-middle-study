package com.docker.pjt.test.dto;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogCreateRequest {
    private String title;
    private String content;
}