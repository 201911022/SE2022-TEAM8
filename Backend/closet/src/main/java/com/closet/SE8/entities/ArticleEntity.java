package com.closet.SE8.entities;

import com.closet.SE8.dto.ArticleDTO;
import com.closet.SE8.entities.ArticleEntity;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "season", nullable = false)
    private String season;
    
    @Column(name = "shared", nullable = false)
    private String shared;


    public ArticleDTO toDTO() {
        return ArticleDTO.builder()
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
