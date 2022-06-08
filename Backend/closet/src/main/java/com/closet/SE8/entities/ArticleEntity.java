package com.closet.SE8.entities;

import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.entities.ArticleEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "article")
@Entity(name = "Article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleEntity {


    @Id
    @SequenceGenerator(name = "article_sequence", sequenceName = "article_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "article_sequence")
    private Long articleNo;

    @Column(name = "userId", unique = true, nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "regDate", nullable = false)
    private LocalDateTime regDate;

    @Column(name = "lastModified", nullable = false)
    private LocalDateTime lastModified;

    @Column(name = "isPublished", nullable = false)
    private boolean isPublished;

    @Column(name = "image", nullable = false)
    private String image;

    public ArticleDTO toDTO() {
        return ArticleDTO.builder()
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
