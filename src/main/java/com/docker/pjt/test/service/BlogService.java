package com.docker.pjt.test.service;

import com.docker.pjt.test.dto.BlogCreateRequest;
import com.docker.pjt.test.dto.BlogUpdateRequest;
import com.docker.pjt.test.entity.Blog;
import com.docker.pjt.test.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional(readOnly = true)
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Blog getBlog(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
    }

    public void create(BlogCreateRequest request) {
        blogRepository.save(Blog.of(request));
    }

    public void update(Long blogId, BlogUpdateRequest request) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
        blog.update(request);
    }

    public void delete(Long blogId) {
        blogRepository.deleteById(blogId);
    }
}