package project.projecttest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.projecttest.domain.Board;
import project.projecttest.domain.BoardNews;
import project.projecttest.domain.Grade;

@Data
@NoArgsConstructor
public class BoardNewsDto {

    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private Grade grade;

    @Builder
    public BoardNewsDto(String title, String content, String createdBy, Grade grade) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.grade = grade;
    }

    public BoardNews toEntity() {
        return BoardNews.builder()
                .title(title)
                .content(content)
                .createdBy(createdBy)
                .grade(grade)
                .build();
    }

    public BoardNewsDto(BoardNews boardNews) {
        id = boardNews.getId();
        title = boardNews.getTitle();
        content = boardNews.getContent();
        createdBy = boardNews.getCreatedBy();
    }
}