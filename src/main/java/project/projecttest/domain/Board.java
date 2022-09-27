package project.projecttest.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
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
    public Board(String title, String content, String createdBy, Grade grade, Member member) {
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.grade = grade;
        if (this.member != null) {
            member.getBoardList().remove(this);
        }

    }


}