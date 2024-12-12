package com.example.board.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    // 속성
    private final String username;  // 로그인할 때 사용할 ID

    private final String password;  // 로그인할 때 사용할 비밀번호

    private final Integer age;

    // 생성자
    public SignUpRequestDto(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
