package com.example.board.dto;

import lombok.Getter;

@Getter
public class BoardResponseDto {

    // 속성
    private final Long id;

    private final String title;

    private final String contents;

    // 생성자
    public BoardResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }


    // 기능
}
