package com.closet.SE8.dto;

import com.closet.SE8.entities.ArticleEntity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticleDTO {
    private Long articleNo; // pk
    private String userId;
    private String title;
    private String content;
    private String category;
    private String image;
    private String season;
    private String shared;
    public ArticleEntity toEntity() {
        return ArticleEntity.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .category(category)
                .image(image)
                .season(season)
                .shared(shared)
                .build();
    }
}
