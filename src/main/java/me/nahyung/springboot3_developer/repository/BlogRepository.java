package me.nahyung.springboot3_developer.repository;

import me.nahyung.springboot3_developer.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article , Long> {
}
