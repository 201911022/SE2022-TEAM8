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
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/team8")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    //게시글 생성
    @PostMapping("/article/create")
    public ResponseEntity<Void> createArticle(@RequestBody ArticleDTO article, HttpServletRequest request) {
    	HttpSession session = request.getSession();
		String sessionName = (String)session.getAttribute("loginId");
		article.setUserId(sessionName);
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
    public ResponseEntity<Void> deleteArticle(@PathVariable(name="no") Long no, @RequestBody ArticleDTO article, HttpServletRequest request) {
        if(articleService.delete(no)) {
            return ResponseEntity.ok(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/articlelist")
    public ResponseEntity<Map<String, Object>> sharedArticleList(HttpServletRequest request){
    	
    	List<ArticleEntity> list = articleService.sharedArticleList();
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("articlelist", list);
    	return ResponseEntity.ok(map);
    }


}
