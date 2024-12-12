package com.example.board.dto;

import lombok.Getter;

@Getter
public class SignUpResponseDto {

    // 속성
    private final Long id;  // 식별자

    private final String username;  // 회원가입 때 생성된 유저의 ID

    private final Integer age;  // 회원가입 때 사용한 나이

    // 생성자
    public SignUpResponseDto(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
