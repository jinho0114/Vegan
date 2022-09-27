package project.projecttest.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_news")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardNews {

    @Id @GeneratedValue
    @Column(name = "board_news")
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private String createdBy;

//    private Long countVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Builder
    public BoardNews(String title, String content, String createdBy, Grade grade, Member member) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.grade = grade;
        if (this.member != null) {
            member.getBoardNewsList().remove(this);
        }

    }


}