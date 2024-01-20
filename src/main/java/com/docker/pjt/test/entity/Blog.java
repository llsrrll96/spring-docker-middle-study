package com.docker.pjt.test.entity;

import com.docker.pjt.test.dto.BlogCreateRequest;
import com.docker.pjt.test.dto.BlogUpdateRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    private String title;


    @Builder
    public Blog(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static Blog of(BlogCreateRequest request) {
        return Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public void update(BlogUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
