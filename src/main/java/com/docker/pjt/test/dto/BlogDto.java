package com.docker.pjt.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDto {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private String title;
}
