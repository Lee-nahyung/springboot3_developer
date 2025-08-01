package me.nahyung.springboot3_developer.dto;

import lombok.Getter;
import me.nahyung.springboot3_developer.domain.Article;

@Getter
public class ArticleResponse {
    private final String title;
    private final String content;

    public ArticleResponse(Article article){
        this.title = article.getTitle();
        this.content = article.getContent();
    }
}
