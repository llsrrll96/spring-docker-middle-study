package com.docker.pjt.test.repository;

import com.docker.pjt.test.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
