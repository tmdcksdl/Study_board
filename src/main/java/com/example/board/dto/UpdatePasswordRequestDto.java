package com.example.board.dto;

import lombok.Getter;

@Getter
public class UpdatePasswordRequestDto {

    // 속성
    private final String oldPassword;

    private final String newPassword;

    // 생성자
    public UpdatePasswordRequestDto(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }


    // 기능
}
