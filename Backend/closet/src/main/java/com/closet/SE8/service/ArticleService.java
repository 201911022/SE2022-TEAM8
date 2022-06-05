package com.closet.SE8.service;

import com.closet.SE8.dao.ArticleDAO;
import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService implements ArticleDAO {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {this.articleRepository = articleRepository;}

    public Long createArticle(ArticleDTO article) {
        return this.articleRepository.saveAndFlush(article.toEntity()).getArticleNo();
    }
}
