package com.closet.SE8.service;

import com.closet.SE8.dao.ArticleDAO;
import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.entities.ArticleEntity;
import com.closet.SE8.repo.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService implements ArticleDAO {
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
    	this.articleRepository = articleRepository;
    }
    
    //게시물 생성
    public Long createArticle(ArticleDTO article) {
        return this.articleRepository.saveAndFlush(article.toEntity()).getArticleNo();
    }
    
    //게시물 수정
    public boolean updateArticle(ArticleDTO article) {
        Optional<ArticleEntity> beforeArticle = this.articleRepository.findByArticleNo(article.getArticleNo());
        ArticleEntity newArticle = beforeArticle.get();
        if (beforeArticle.isPresent()) {
        	newArticle.setUserId(article.getUserId());
            newArticle.setTitle(article.getTitle());
            newArticle.setContent(article.getContent());
            newArticle.setCategory(article.getCategory());
            newArticle.setImage(article.getImage());
            newArticle.setSeason(article.getSeason());
            newArticle.setShared(article.getShared());
            articleRepository.save(newArticle);
            return true;
        }
        else {
            return false;
        }
    }

    //게시물 삭제 부분
    public boolean delete(Long no) {
        Optional<ArticleEntity> num = this.articleRepository.findByArticleNo(no);
        if(num.isPresent()) {
            articleRepository.delete(num.get());
            return true;
        }
        else {
            return false;
        }
    }

    //공유 게시물 조회 부분
    public List<ArticleEntity> sharedArticleList() {
    	return articleRepository.findAllByShared("true");
    }


    //  내 게시물 조회 부분
    public List<ArticleEntity> myArticleList(String id) {
        return articleRepository.findAllByUserId(id);
    }

    //상세조회
    public Optional<ArticleEntity> detailArticle(Long articleNo) {
        Optional<ArticleEntity> articleDetail = this.articleRepository.findByArticleNo(articleNo);
        
        if(articleDetail.isPresent()) {
            return articleDetail;
        }
        return null;
    }
}
