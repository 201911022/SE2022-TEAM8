package com.closet.SE8.controller;

import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/team8/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody ArticleDTO article, HttpServletRequest request) {
        Long no = articleService.createArticle(article);
        System.out.println(no);
        return ResponseEntity.ok(null);
    }
}
