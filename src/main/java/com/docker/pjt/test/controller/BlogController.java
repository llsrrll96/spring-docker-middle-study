package com.docker.pjt.test.controller;

import com.docker.pjt.test.dto.BlogCreateRequest;
import com.docker.pjt.test.dto.BlogUpdateRequest;
import com.docker.pjt.test.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
    private final BlogService blogService;

    // blog 조회
    @GetMapping
    public ResponseEntity<?> getBlogs() {
        log.info("getBlogs");
        return ResponseEntity.ok(blogService.getBlogs());
    }

    // blog 상세조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(
            @PathVariable("id") Long id
    ) {
        log.info("getBlog id: {}", id);
        return ResponseEntity.ok(blogService.getBlog(id));
    }


    // blog 생성
    // create
    @PostMapping()
    public ResponseEntity<?> createBlog(@RequestBody BlogCreateRequest request) {
        log.info("createBlog request: {}", request);
        blogService.create(request);
        return ResponseEntity.ok("created");
    }

    // blog 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBlog(
            @PathVariable("id") Long id,
            @RequestBody BlogUpdateRequest request
    ) {
        log.info("updateBlog id: {}, request: {}", id, request);
        blogService.update(id, request);
        return ResponseEntity.ok("updated");
    }

    // blog 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlog(
            @PathVariable("id") Long id
    ) {
        log.info("deleteBlog id: {}", id);
        blogService.delete(id);
        return ResponseEntity.ok("deleted");
    }

}
