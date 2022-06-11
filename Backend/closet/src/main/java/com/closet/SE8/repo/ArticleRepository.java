package com.closet.SE8.repo;

import com.closet.SE8.entities.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    Optional<ArticleEntity> findByArticleNo(Long articleNo);
    List<ArticleEntity> findAllByShared(String shared);
    List<ArticleEntity> findAllByUserId(String userId);
}
