package com.example.board.entitiy;

import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class Board extends BaseEntity{

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
}
