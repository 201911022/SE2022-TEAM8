package com.closet.SE8.dto;

import com.closet.SE8.entities.ArticleEntity;
import com.closet.SE8.entities.UserEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArticleDTO {
    private Integer articleNo; // pk
    private String userId;
    private String title;
    private String content;
    private String category;
    private LocalDateTime regDate;
    private LocalDateTime lastModified;
    private boolean isPublished;
    private String image;

    public ArticleEntity toEntity() {
        return ArticleEntity.builder()
                .userId(userId)
                .title(title)
                .content(content)
                .category(category)
                .regDate(regDate)
                .lastModified(lastModified)
                .isPublished(isPublished)
                .image(image)
                .build();
    }
}
