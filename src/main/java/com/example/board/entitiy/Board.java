package com.example.board.entitiy;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "board")
public class Board extends BaseEntity{

    // 속성
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @ManyToOne  // 1:N인 경우 N에 @ManyToOne 설정한다.
    @JoinColumn(name = "member_id")
    private Member member;

    // 생성자
    public Board() {}

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    // 기능
    public void setMember(Member member) {
        this.member = member;
    }
}
