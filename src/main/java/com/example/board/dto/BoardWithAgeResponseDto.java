package com.example.board.dto;

import lombok.Getter;

@Getter
public class BoardWithAgeResponseDto {

    // 속성
    private final String title;

    private final String contents;

    private final Integer age;

    // 생성자
    public BoardWithAgeResponseDto(String title, String contents, Integer age) {
        this.title = title;
        this.contents = contents;
        this.age = age;
    }


    // 기능
}
