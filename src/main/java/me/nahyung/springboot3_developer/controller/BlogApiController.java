package me.nahyung.springboot3_developer.controller;

import lombok.RequiredArgsConstructor;
import me.nahyung.springboot3_developer.dto.AddArticleRequest;
import me.nahyung.springboot3_developer.domain.Article;
import me.nahyung.springboot3_developer.dto.ArticleResponse;
import me.nahyung.springboot3_developer.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController //HTTP Response Body에 HTTP 응답으로 객체 데이터를 JSON 형식으로 반환
public class BlogApiController {

    private final BlogService blogService;

    //HTTP메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticles(@RequestBody AddArticleRequest request){
        Article saveArticle = blogService.save(request);

        //요청한 자원이 성공적으로 생성되었으며, 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saveArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }
}
