package com.example.board.dto;

import lombok.Getter;

@Getter
public class MemberResponseDto {

    // 속성
    private final String username;

    private final Integer age;

    // 생성자
    public MemberResponseDto(String username, Integer age) {
        this.username = username;
        this.age = age;
    }


    // 기능
}
