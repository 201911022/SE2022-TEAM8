package com.closet.SE8.controller;

import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.entities.ArticleEntity;
import com.closet.SE8.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/team8")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //게시글 생성
    @PostMapping("/article/create")
    public ResponseEntity<Void> createArticle(@RequestBody ArticleDTO article, HttpServletRequest request) {
        Long no = articleService.createArticle(article);
        System.out.println(no);
        return ResponseEntity.ok(null);
    }
    //게시글 수정
    @PostMapping("/article/update/{no}")
    public ResponseEntity<Void> updateArticle(@PathVariable(name="no") Long no, @RequestBody ArticleDTO article, HttpServletRequest request) {
        article.setArticleNo(no);
    	if(articleService.updateArticle(article)) {
            return ResponseEntity.ok(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    
    //게시글 삭제
    @PostMapping("/article/delete/{no}")
    public ResponseEntity<Void> deleteArticle(@PathVariable(name="no") Long no, HttpServletRequest request) {
        if(articleService.delete(no)) {
            return ResponseEntity.ok(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //공유 게시물 조회부분
    @GetMapping("/articlelist")
    public ResponseEntity<Map<String, Object>> sharedArticleList(HttpServletRequest request){
        try{
        	List<ArticleEntity> list = articleService.sharedArticleList();
	        Map<String, Object> map = new HashMap<>();
	        map.put("articlelist", list);
	        return ResponseEntity.ok(map);
        }catch(Exception e) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //내 게시물 조회 부분
    @GetMapping("/articlelist/my/{id}")
    public ResponseEntity<Map<String, Object>> myArticleList(@PathVariable(name="id") String id, HttpServletRequest request){
		try{
        	List<ArticleEntity> list = articleService.myArticleList(id);
	        Map<String, Object> map = new HashMap<>();
	        map.put("articlelist", list);
	        return ResponseEntity.ok(map);
        }catch(Exception e) {
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    //상세조회
    @GetMapping("/articledetail/{articleNo}")
    public ResponseEntity<Optional<ArticleEntity>> detailArticle(@PathVariable(name="articleNo") Long articleNo, HttpServletRequest request) {
        Optional<ArticleEntity> article = articleService.detailArticle(articleNo);
        return ResponseEntity.ok(article);
    }


}
