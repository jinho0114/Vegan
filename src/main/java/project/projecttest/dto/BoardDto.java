package project.projecttest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.projecttest.domain.Board;
import project.projecttest.domain.Grade;

@Data
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String createdBy;
    private Grade grade;

    @Builder
    public BoardDto(String title, String content, String createdBy, Grade grade) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.grade = grade;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .createdBy(createdBy)
                .grade(grade)
                .build();
    }

    public BoardDto(Board board) {
        id = board.getId();
        title = board.getTitle();
        content = board.getContent();
        createdBy = board.getCreatedBy();
    }
}